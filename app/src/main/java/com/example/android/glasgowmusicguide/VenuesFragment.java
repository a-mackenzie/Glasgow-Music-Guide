package com.example.android.glasgowmusicguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;


import java.util.ArrayList;

/**
 * Fragment that displays a list of venue business objects
 */
public class VenuesFragment extends Fragment {


    public VenuesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        // Create a list of venues
        final ArrayList<Business> venues = new ArrayList<Business>();
        venues.add(new Business(R.string.barras_name, R.string.barras_address, R.string.barras_phone, R.string.barras_web, R.drawable.barras, R.drawable.barras_large, R.string.barras_description));
        venues.add(new Business(R.string.o2Academy_name, R.string.o2Academy_address, R.string.o2Academy_phone, R.string.o2Academy_web, R.drawable.o2academy, R.drawable.o2academy_large, R.string.o2Academy_description));
        venues.add(new Business(R.string.hydro_name, R.string.hydro_address, R.string.hydro_phone, R.string.hydro_web, R.drawable.hydro, R.drawable.hydro_large, R.string.hydro_description));
        venues.add(new Business(R.string.kingtuts_name, R.string.kingtuts_address, R.string.kingtuts_phone, R.string.kingtuts_web, R.drawable.kingtuts, R.drawable.kingtuts_large, R.string.kingtuts_description));

        // Create a Business adapter whose data source is a list of businesses
        BusinessAdapter adapter = new BusinessAdapter(getActivity(), venues);

        // Find the ListView object in the view hierarchy of the Activity
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the ListView use the BusinessAdapter
        listView.setAdapter(adapter);

        // Set a click listener to open the detail activity when the item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the Business object at the given position the user clicked on
                Business business = venues.get(position);
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
