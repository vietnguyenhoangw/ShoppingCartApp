package com.example.shoppingcartappvers2;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {

    RecyclerView rvFeed;
    ArrayList<Feed> feedArrayList;
    FeedAdapter feedAdapter;


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

//        feedAdapter.getFeedData();
        feedArrayList.add(new Feed("Daniel","Share from instagram", R.drawable.coder,
                R.drawable.hinh2, 30, 21, 6));

        feedAdapter = new FeedAdapter(getContext(), feedArrayList,R.layout.item_feed);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL, false);

        rvFeed.setLayoutManager(linearLayoutManager);
        rvFeed.setAdapter(feedAdapter);
    }
}
