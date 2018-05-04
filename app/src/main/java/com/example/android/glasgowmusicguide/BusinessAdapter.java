package com.example.android.glasgowmusicguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class BusinessAdapter extends ArrayAdapter<Business> {

    public BusinessAdapter(Activity context, ArrayList<Business> businesses) {
        super(context, 0, businesses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_entry, parent, false);
        }

        // Get the business object located at this position in the list
        Business currentBusiness = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID business_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.business_name);
        // Get the name of the business and set it to the textview
        nameTextView.setText(currentBusiness.getName());

        // Find the TextView in the list_item.xml layout with the ID business_address
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.business_address);
        // Get the address of the business and set it to the textview
        if (currentBusiness.getAddress() != null) {
            addressTextView.setText(currentBusiness.getAddress());
        } else {
            addressTextView.setVisibility(View.GONE);
        }

        // Find the TextView in the list_item.xml layout with the ID business_phone
        TextView phoneTextView = (TextView) listItemView.findViewById(R.id.business_phone);
        // Get the address of the business and set it to the textview
        if (currentBusiness.getPhone() != null) {
            phoneTextView.setText(currentBusiness.getPhone());
        } else {
            phoneTextView.setVisibility(View.GONE);
        }

        // Find the ImageView in the list_item.xml layout with the ID business_image
        ImageView image = (ImageView) listItemView.findViewById(R.id.business_image);
        // Get the image resource for the business and set it to the imageview
        image.setImageResource(currentBusiness.getImageResID());


        return listItemView;
    }

}
