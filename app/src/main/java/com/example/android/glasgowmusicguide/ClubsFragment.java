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
 * Fragment that displays a list of club business objects
 */
public class ClubsFragment extends Fragment {


    public ClubsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        // Create a list of clubs
        final ArrayList<Business> clubs = new ArrayList<Business>();
        clubs.add(new Business(R.string.subclub_name, R.string.subclub_address, R.string.subclub_phone, R.string.subclub_web, R.drawable.subclub, R.drawable.subclub_large, R.string.subclub_description));
        clubs.add(new Business(R.string.swg3_name, R.string.swg3_address, R.string.swg3_phone, R.string.swg3_web, R.drawable.swg3, R.drawable.swg3_large, R.string.swg3_description));
        clubs.add(new Business(R.string.berkeley_name, R.string.berkeley_address, R.string.berkeley_phone, R.string.berkeley_web, R.drawable.berkeley, R.drawable.berkeley_large, R.string.berkeley_description));

        // Create a Business adapter whose data source is a list of businesses
        BusinessAdapter adapter = new BusinessAdapter(getActivity(), clubs);

        // Find the ListView object in the view hierarchy of the Activity
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the ListView use the BusinessAdapter
        listView.setAdapter(adapter);

        // Set a click listener to open the detail activity when the item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the Business object at the given position the user clicked on
                Business business = clubs.get(position);
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
