package com.example.terrafund2;


public class Post {
    private String postId;
    private String userId;
    private String title;
    private String description;
    private String budget;
    private int progress;

    public Post() {
    }

    public Post(String postId, String userId, String title, String description, String budget, int progress) {
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.budget = budget;
        this.progress = progress;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
