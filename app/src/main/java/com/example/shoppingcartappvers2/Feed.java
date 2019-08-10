package com.example.shoppingcartappvers2;

public class Feed {
    private String name;
    private String status;
    private int userImage;
    private int feedImage;
    private int like;
    private int comment;
    private int share;

    public Feed(String name, String status, int userImage, int feedImage, int like, int comment, int share) {
        this.name = name;
        this.status = status;
        this.userImage = userImage;
        this.feedImage = feedImage;
        this.like = like;
        this.comment = comment;
        this.share = share;
//        git
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public int getFeedImage() {
        return feedImage;
    }

    public void setFeedImage(int feedImage) {
        this.feedImage = feedImage;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }
}
