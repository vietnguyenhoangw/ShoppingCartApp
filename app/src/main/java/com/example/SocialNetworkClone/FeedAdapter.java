package com.example.SocialNetworkClone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {

    Context context;
    ArrayList<Feed> feedArrayList;
    int layout;

    public FeedAdapter(Context context, ArrayList<Feed> feedArrayList, int layout) {
        this.context = context;
        this.feedArrayList = feedArrayList;
        this.layout = layout;
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(layout, parent, false);

        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {
        Feed feed = feedArrayList.get(position);

        holder.userName.setText(feed.getName());
        holder.status.setText(feed.getStatus());
        holder.userImage.setImageResource(feed.getUserImage());
        holder.feedImage.setImageResource(feed.getFeedImage());
        holder.like.setText(feed.getLike() + "");
        holder.comment.setText(feed.getComment() + "");
        holder.share.setText(feed.getShare() + "");
    }

    @Override
    public int getItemCount() {
        return feedArrayList.size();
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder{
        TextView userName;
        TextView status;
        ImageView userImage;
        ImageView feedImage;
        TextView like;
        TextView comment;
        TextView share;

        public FeedViewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.tv_userName);
            status = itemView.findViewById(R.id.tv_status);
            userImage = itemView.findViewById(R.id.img_userImage);
            feedImage = itemView.findViewById(R.id.img_feedImage);
            like = itemView.findViewById(R.id.tv_like);
            comment = itemView.findViewById(R.id.tv_comment);
            share = itemView.findViewById(R.id.tv_share);
        }
    }

    /*
    * *
    * * RecycleView Adapter
    * * mapping XML item file and Object class file
    * *
    * */
}
