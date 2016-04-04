package com.olab.ukrsibmap.model;

import java.util.ArrayList;

/**
 * Created by Oleg on 01/04/2016.
 */

public class AtmLocator {
    private String bankKey = "";
    private String address = "";
    private String atmId = "";
    //private String[] atmsTypeArr = {MapApplication.getContext().getString(2131230932)};
    //private String[] branchesTypeArr = {MapApplication.getContext().getString(2131230931)};
    private String city = "";
    private String country = "";
    private double distance = 0.0D;
    private String id = "";
    private String image = "";
    private int indexInCsv = 0;
    private boolean isAtm = false;
    private boolean isBranches = false;
    private boolean isInitialized = false;
    private boolean isSelfService = false;
    private double lat = 0.0D;
    private double lng = 0.0D;
    private ArrayList<AtmLocatorDay> openingHours = null;
    private String reference = "";
    private String region = "";
    private String services = "";
    private String servicesBinary = "";
    private String subType = "";
    private String telephone = "";
    private String title = "";

    public String getBankKey() {
        return bankKey;
    }

    public void setBankKey(String bankKey) {
        this.bankKey = bankKey;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIndexInCsv() {
        return indexInCsv;
    }

    public void setIndexInCsv(int indexInCsv) {
        this.indexInCsv = indexInCsv;
    }

    public boolean isAtm() {
        return isAtm;
    }

    public void setIsAtm(boolean isAtm) {
        this.isAtm = isAtm;
    }

    public boolean isBranches() {
        return isBranches;
    }

    public void setIsBranches(boolean isBranches) {
        this.isBranches = isBranches;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void setIsInitialized(boolean isInitialized) {
        this.isInitialized = isInitialized;
    }

    public boolean isSelfService() {
        return isSelfService;
    }

    public void setIsSelfService(boolean isSelfService) {
        this.isSelfService = isSelfService;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public ArrayList<AtmLocatorDay> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(ArrayList<AtmLocatorDay> openingHours) {
        this.openingHours = openingHours;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getServicesBinary() {
        return servicesBinary;
    }

    public void setServicesBinary(String servicesBinary) {
        this.servicesBinary = servicesBinary;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type = "";
}
