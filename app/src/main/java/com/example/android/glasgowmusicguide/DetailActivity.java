package com.example.android.glasgowmusicguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView image = (ImageView) findViewById(R.id.business_image);
        TextView name = (TextView) findViewById(R.id.business_name);
        TextView address = (TextView) findViewById(R.id.business_address);
        TextView phone = (TextView) findViewById(R.id.business_phone);
        TextView website = (TextView) findViewById(R.id.business_website);
        TextView description = (TextView) findViewById(R.id.business_description); 

        // Pull the details of the business from the extras bundle
        Integer businessName;
        Integer businessAddress;
        Integer businessPhone;
        Integer businessWebsite;
        Integer businessImageResID;
        Integer businessDescription;

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            businessName = null;
            businessAddress = null;
            businessPhone = null;
            businessWebsite = null;
            businessImageResID = null;
            businessDescription = null;
        } else {
            businessName = extras.getInt("chosenBusinessName");
            businessAddress = extras.getInt("chosenBusinessAddress");
            businessPhone = extras.getInt("chosenBusinessPhone");
            businessWebsite = extras.getInt("chosenBusinessWebsite");
            businessImageResID = extras.getInt("chosenBusinessImageResIDLarge");
            businessDescription = extras.getInt("chosenBusinessDescription");
        }
        
        // Set the views in the layout to contain the relevant information
        image.setImageResource(businessImageResID);
        name.setText(businessName);
        description.setText(businessDescription);

        if (businessAddress != 0) {
            address.setText(businessAddress);
        } else {
            address.setVisibility(View.GONE);
        }

        if (businessPhone != 0) {
            phone.setText(businessPhone);
        } else {
            phone.setVisibility(View.GONE);
        }

        if (businessWebsite != 0) {
            website.setText(businessWebsite);
        } else {
            website.setVisibility(View.GONE);
        }

    }
}
