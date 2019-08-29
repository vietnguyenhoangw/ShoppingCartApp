package com.example.SocialNetworkClone;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {

    RecyclerView rvFeed;
    ArrayList<Feed> feedArrayList;
    FeedAdapter feedAdapter;

    ImageView selectData;
    TextView username;

    public FeedFragment() {
        // Required empty public constructor
    }

    public static FeedFragment newInstance() {
        return new FeedFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        /*
        * RecycleView configure
        * */
        rvFeed = view.findViewById(R.id.rvFeed);
        feedArrayList = new ArrayList<>();

        getFeedData();


        feedAdapter = new FeedAdapter(getContext(), feedArrayList,R.layout.item_feed);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL, false);

        rvFeed.setLayoutManager(linearLayoutManager);
        rvFeed.setAdapter(feedAdapter);

        /* select data click, up arrow in fragment display */
        selectData = view.findViewById(R.id.btnSelectUser);
        selectData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), UserSelectActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


        /* set text when have data from MainActivity */
        username = view.findViewById(R.id.username);

        try {
            String value = getArguments().getString("userNameSelect");
            username.setText(value + " selected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    /* getdata for recycleview */
    public void getFeedData() {
        feedArrayList.add(new Feed("Daniel","Share from instagram", R.drawable.coder,
            R.drawable.hinh2, 30, 21, 6));
        feedArrayList.add(new Feed("JustinBieber","Posted", R.drawable.justin,
            R.drawable.landmark, 7680, 398, 271));
        feedArrayList.add(new Feed("Leonardo","Posted", R.drawable.leo,
            R.drawable.leopic, 17680, 2980, 2171));
    }
}
