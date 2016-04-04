package com.olab.ukrsibmap;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.olab.ukrsibmap.controller.AtmManager;
import com.olab.ukrsibmap.model.AtmLocator;

import org.springframework.http.ContentCodingType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.TimeZone;

import static org.springframework.http.HttpHeaders.IF_MODIFIED_SINCE;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    public static MediaType BRANCH_MEDIATYPE = new MediaType("application", "vnd.bnpp-branchlocator+json",
            new LinkedHashMap<String, String>() {{
                put("ver", "1");
                put("charset", "UTF-8");
            }});

    private GoogleMap mMap;
    private AtmManager atmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        atmManager = new AtmManager();
    }

    @Override
    public void onStart() {
        super.onStart();

        new LoadATMTask().execute(getString(R.string.branchlocator_url));


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    private class LoadATMTask extends AsyncTask<String, Void, AtmLocator[]> {

        @Override
        protected AtmLocator[] doInBackground(String... urls) {
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setAccept(Collections.singletonList(BRANCH_MEDIATYPE));
            requestHeaders.setAcceptEncoding(ContentCodingType.GZIP);
            requestHeaders.setAcceptLanguage("uk");
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -1);
            requestHeaders.set(IF_MODIFIED_SINCE, getDateForIfLastModifiedHeader(calendar.getTime()));
            HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            ResponseEntity<String> responseEntity = restTemplate.exchange(urls[0],
                    HttpMethod.GET, requestEntity, String.class);
            //AtmLocator[] locators = responseEntity.getBody();
            return null;
        }
    }

    public ObjectMapper jacksonObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    public MappingJackson2HttpMessageConverter jsonConverter() {
        MappingJackson2HttpMessageConverter jacksonConverter = new
                MappingJackson2HttpMessageConverter();
        jacksonConverter.setSupportedMediaTypes(Collections.singletonList(BRANCH_MEDIATYPE));
        jacksonConverter.setObjectMapper(jacksonObjectMapper());
        return jacksonConverter;
    }

    public static String getDateForIfLastModifiedHeader(Date date) {
        TimeZone localTimeZone = TimeZone.getTimeZone("GMT");
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
        localSimpleDateFormat.setTimeZone(localTimeZone);
        return localSimpleDateFormat.format(date) + " GMT";
    }
}
