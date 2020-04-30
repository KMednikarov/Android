package com.hfad.a9gagapp;

class GalleryItem {
    private int imageId;
    private String itemTitle;
    private int pointsCount;
    private int commentsCount;


    public GalleryItem(int imageId, String itemTitle, int pointsCount, int commentsCount){
        this.setImageId(imageId);
        this.setItemTitle(itemTitle);
        this.setPointsCount(pointsCount);
        this.setCommentsCount(commentsCount);
    }

    public int getImageId() {
        return imageId;
    }

    private void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    private void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public int getPointsCount() {
        return pointsCount;
    }

    private void setPointsCount(int pointsCount) {
        this.pointsCount = pointsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    private void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }
}
