package com.berke.AkdenizSosyal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.berke.AkdenizSosyal.R;

public class PlaceAdapter extends ArrayAdapter<String> {
    private String[] PlaceName;
    private String[] PlaceType;
    private int[] PlaceImage;
    private Context context;

    private TextView placeName, placeType;
    private ImageView placeImage;

   public PlaceAdapter(String[] PlaceName, String[] PlaceType, int[] PlaceImage, Context context){
       super(context, R.layout.place_item, PlaceName);

       this.PlaceName = PlaceName;
       this.PlaceType = PlaceType;
       this.PlaceImage = PlaceImage;
       this.context = context;
   }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View view = LayoutInflater.from(context).inflate(R.layout.place_item,null);

       if(view != null){
           placeName = view.findViewById(R.id.place_item_placeName);
           placeType = view.findViewById(R.id.place_item_placeType);
           placeImage = view.findViewById(R.id.place_item_img);

           placeName.setText(PlaceName[position]);
           placeType.setText(PlaceType[position]);
           placeImage.setBackgroundResource(PlaceImage[position]);
       }

       return view;
    }
}
