package com.berke.AkdenizSosyal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.berke.AkdenizSosyal.Adapter.EventAdapter;
import com.berke.AkdenizSosyal.Model.Event;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class EventPage extends Fragment implements View.OnClickListener {

    private Button button;
    private RecyclerView mRecyclerView;
    private EventAdapter mEventAdapter;
    private FirebaseUser mFirebaseUser;

    private ArrayList<Event> mEventList;
    private Event mEvent;


    private FirebaseFirestore mFireStore;
    private Query mQuery;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_page, container, false);

        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        mFireStore = FirebaseFirestore.getInstance();
        mEventList = new ArrayList<>();

        button = (Button) rootView.findViewById(R.id.btn_add_event);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddEventPage.class);
                startActivity(intent);
            }
        });

        mRecyclerView = rootView.findViewById(R.id.event_fragment_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext(),LinearLayoutManager.VERTICAL,false));

        mQuery = mFireStore.collection("Events");
        mQuery.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error != null){
                    Toast.makeText(rootView.getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    return;
                }

                if(value != null){
                    mEventList.clear();

                    for(DocumentSnapshot snapshot : value.getDocuments()){
                        mEvent = snapshot.toObject(Event.class);

                        assert mEvent != null;

                        mEventList.add(mEvent);
                    }

                    mRecyclerView.addItemDecoration(new LinearDec(30,mEventList.size()));
                    mEventAdapter = new EventAdapter(mEventList,rootView.getContext());
                    mRecyclerView.setAdapter(mEventAdapter);
                }
            }
        });

        return rootView;
    }

    class LinearDec extends RecyclerView.ItemDecoration{
        private int space;
        private int data;

        public LinearDec(int space, int data) {
            this.space = space;
            this.data = data;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);

            if(position != (data-1))
                outRect.bottom = space;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onClick(View view) {

    }
}





