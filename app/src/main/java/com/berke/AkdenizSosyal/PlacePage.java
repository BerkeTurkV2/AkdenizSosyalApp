package com.berke.AkdenizSosyal;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.berke.AkdenizSosyal.Adapter.PlaceAdapter;

public class PlacePage extends Fragment {
    private ListView mListView;
    private String[] PlaceName = {"Vitamin Olbia", "Chaplin Art Cafe", "Burger King", "Brother's Milk Bar"};
    private String[] PlaceType = {"İçecek / Tatlı", "Yemek / İçecek / Eğlence", "Yemek / İçecek", "İçecek / Eğlence"};
    private int[] PlaceImage = {R.drawable.vitamin, R.drawable.chaplin, R.drawable.burger, R.drawable.milkbar};
    private PlaceAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_place_page, container, false);

        mListView = (ListView) rootView.findViewById(R.id.placepagelistview);
        adapter = new PlaceAdapter(PlaceName, PlaceType, PlaceImage, this.getContext());
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return rootView;

    }
}