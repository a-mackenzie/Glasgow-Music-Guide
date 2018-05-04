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
 * Fragment that displays a list of band business objects
 */
public class BandsFragment extends Fragment {


    public BandsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        // Create a list of bands
        final ArrayList<Business> bands = new ArrayList<Business>();
        bands.add(new Business(R.string.belle_name, R.string.belle_web, R.drawable.belle, R.drawable.belle_large, R.string.belle_description));
        bands.add(new Business(R.string.primal_name, R.string.primal_web, R.drawable.primal, R.drawable.primal_large, R.string.primal_description));
        bands.add(new Business(R.string.chvrches_name, R.string.chvrches_web, R.drawable.chvrches, R.drawable.chvrches_large, R.string.chvrches_description));
        bands.add(new Business(R.string.franz_name, R.string.franz_web, R.drawable.franz, R.drawable.franz_large, R.string.franz_description));

        // Create a Business adapter whose data source is a list of businesses
        BusinessAdapter adapter = new BusinessAdapter(getActivity(), bands);

        // Find the ListView object in the view hierarchy of the Activity
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the ListView use the BusinessAdapter
        listView.setAdapter(adapter);

        // Set a click listener to open the detail activity when the item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the Business object at the given position the user clicked on
                Business business = bands.get(position);
                // Build the intent
                Intent detailIntent = new Intent(getActivity(), DetailActivity.class);
                detailIntent.putExtra("chosenBusinessName", business.getName());
                detailIntent.putExtra("chosenBusinessWebsite", business.getWebsite());
                detailIntent.putExtra("chosenBusinessImageResIDLarge", business.getImageResIDLarge());
                detailIntent.putExtra("chosenBusinessDescription", business.getDescription());
                startActivity(detailIntent);
            }
        });

        return rootView;
    }

}
