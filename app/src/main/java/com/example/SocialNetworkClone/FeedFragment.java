package com.example.SocialNetworkClone;


import android.app.Activity;
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

    private static final int FILTER_REQUEST_CODE = 1000;
    RecyclerView rvFeed;
    ArrayList<Feed> feedArrayList;
    FeedAdapter feedAdapter;

    ImageView changeData;
    TextView userChecked;
    int itemCheck;

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

        rvFeed = view.findViewById(R.id.rvFeed);
        feedArrayList = new ArrayList<>();

        getFeedData();


        feedAdapter = new FeedAdapter(getContext(), feedArrayList,R.layout.item_feed);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL, false);

        rvFeed.setLayoutManager(linearLayoutManager);
        rvFeed.setAdapter(feedAdapter);

        changeData = view.findViewById(R.id.btnChangeData);
        changeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), UserSelectActivity.class);
                startActivity(intent);
            }
        });

        userChecked = view.findViewById(R.id.username);
        userChecked.setText("123123123");

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void getFeedData() {
        feedArrayList.add(new Feed("Daniel","Share from instagram", R.drawable.coder,
            R.drawable.hinh2, 30, 21, 6));
        feedArrayList.add(new Feed("JustinBieber","Posted", R.drawable.justin,
            R.drawable.landmark, 7680, 398, 271));
        feedArrayList.add(new Feed("Leonardo","Posted", R.drawable.leo,
            R.drawable.leopic, 17680, 2980, 2171));
    }
}
