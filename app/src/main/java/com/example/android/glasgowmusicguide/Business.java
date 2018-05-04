package com.example.android.glasgowmusicguide;

public class Business {

    // Name of the business
    private Integer mBusinessName;

    // Address of the business
    private Integer mBusinessAddress;

    // Phone number of the business
    private Integer mBusinessPhone;

    // Web address of the business
    private Integer mBusinessWebsite;

    // Image resource id for an image of the business
    private Integer mBusinessImageResID;

    // Image resource id for an image of the business
    private Integer mBusinessImageResIDLarge;

    // Description of the business
    private Integer mBusinessDescription;

    // Constructs the business object
    public Business(Integer businessName, Integer businessAddress, Integer businessPhone, Integer businessWebsite, Integer businessImageResID, Integer businessImageResIDLarge, Integer businessDesctiption) {
        mBusinessName = businessName;
        mBusinessAddress = businessAddress;
        mBusinessPhone = businessPhone;
        mBusinessWebsite = businessWebsite;
        mBusinessImageResID = businessImageResID;
        mBusinessImageResIDLarge = businessImageResIDLarge;
        mBusinessDescription = businessDesctiption;
    }

    // Constructs the business object for bands
    public Business(Integer businessName, Integer businessWebsite, Integer businessImageResID, Integer businessImageResIDLarge, Integer businessDesctiption) {
        mBusinessName = businessName;
        mBusinessWebsite = businessWebsite;
        mBusinessImageResID = businessImageResID;
        mBusinessImageResIDLarge = businessImageResIDLarge;
        mBusinessDescription = businessDesctiption;
    }

    // Gets the business name
    public Integer getName() {
        return mBusinessName;
    }

    // Gets the business address
    public Integer getAddress() {
        return mBusinessAddress;
    }

    // Gets the business phone number
    public Integer getPhone() {
        return mBusinessPhone;
    }

    // Gets the business website
    public Integer getWebsite() {
        return mBusinessWebsite;
    }

    // Gets the business image resource ID
    public Integer getImageResID() {
        return mBusinessImageResID;
    }

    // Gets the large business image resource ID
    public Integer getImageResIDLarge() {
        return mBusinessImageResIDLarge;
    }

    // Gets the description of the business
    public Integer getDescription() {
        return mBusinessDescription;
    }

}
