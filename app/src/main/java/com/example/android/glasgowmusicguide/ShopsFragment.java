package com.example.android.glasgowmusicguide;


import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Fragment that displays a list of shop business objects
 */
public class ShopsFragment extends Fragment {


    public ShopsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        // Create a list of shops
        final ArrayList<Business> shops = new ArrayList<Business>();
        shops.add(new Business(R.string.monorailmusic_name, R.string.monorailmusic_address, R.string.monorailmusic_phone, R.string.monorailmusic_web, R.drawable.monorail, R.drawable.monorail_large, R.string.monorailmusic_description));
        shops.add(new Business(R.string.lovemusic_name, R.string.lovemusic_address, R.string.lovemusic_phone, R.string.lovemusic_web, R.drawable.lovemusic, R.drawable.lovemusic_large, R.string.lovemusic_description));
        shops.add(new Business(R.string.fopp_name, R.string.fopp_address, R.string.fopp_phone, R.string.fopp_web, R.drawable.fopp, R.drawable.fopp_large, R.string.fopp_description));

        // Create a Business adapter whose data source is a list of businesses
        BusinessAdapter adapter = new BusinessAdapter(getActivity(), shops);

        // Find the ListView object in the view hierarchy of the Activity
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the ListView use the BusinessAdapter
        listView.setAdapter(adapter);

        // Set a click listener to open the detail activity when the item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the Business object at the given position the user clicked on
                Business business = shops.get(position);
                // Build the intent
                Intent detailIntent = new Intent(getActivity(), DetailActivity.class);
                detailIntent.putExtra("chosenBusinessName", business.getName());
                detailIntent.putExtra("chosenBusinessAddress", business.getAddress());
                detailIntent.putExtra("chosenBusinessPhone", business.getPhone());
                detailIntent.putExtra("chosenBusinessWebsite", business.getWebsite());
                detailIntent.putExtra("chosenBusinessImageResIDLarge", business.getImageResIDLarge());
                detailIntent.putExtra("chosenBusinessDescription", business.getDescription());
                startActivity(detailIntent);
            }
        });

        return rootView;
    }

}
