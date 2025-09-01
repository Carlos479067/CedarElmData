package com.example.cedar_data.dto;

public class AddressDto {

    private String streetNumber;
    private String streetName;
    private String cityName;
    private String zipCode;

    public AddressDto() {

    }

    public AddressDto(String streetNumber, String streetName, String cityName, String zipCode) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.cityName = cityName;
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
