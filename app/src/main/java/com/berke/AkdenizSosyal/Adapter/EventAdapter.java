package com.berke.AkdenizSosyal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.berke.AkdenizSosyal.Model.Event;
import com.berke.AkdenizSosyal.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventHolder> {

    private ArrayList<Event> mEventList;
    private Context mContext;
    private View v;
    private Event mEvent;

    public EventAdapter(ArrayList<Event> mEventList, Context mContext) {
        this.mEventList = mEventList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public EventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(mContext).inflate(R.layout.event_item,parent,false);
        return new EventHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventHolder holder, int position) {
        // Etkinlik zorunlu kısımları (Holder kullanımı)
        mEvent = mEventList.get(position);
        holder.eventTitle.setText("Etkinlik : " + mEvent.getEventTitle());
        holder.eventDate.setText("Tarih : " + mEvent.getEventDate());
        holder.eventPlace.setText("Yer : " + mEvent.getEventPlace());

        /*if(mEvent.getEventImage().equals("sade"))
            holder.eventCircle.setImageResource(R.mipmap.ic_launcher);
        else
            Picasso.get().load(mEvent.getEventImage()).resize(80,100).into(holder.eventCircle); */
    }

    @Override
    public int getItemCount() {
        return mEventList.size();
    }

    static class EventHolder extends RecyclerView.ViewHolder{
        TextView eventTitle, eventDate, eventPlace;
        CircleImageView eventCircle;


        public EventHolder(@NonNull View itemView) {
            super(itemView);
            // init
            eventTitle = itemView.findViewById(R.id.event_item_txtTitle);
            eventDate = itemView.findViewById(R.id.event_item_txtDate);
            eventPlace = itemView.findViewById(R.id.event_item_txtPlace);
            eventCircle = itemView.findViewById(R.id.event_item_imgEvent);
        }
    }
}
