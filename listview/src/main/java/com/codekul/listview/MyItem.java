package com.codekul.listview;

/**
 * Created by aniruddha on 9/8/16.
 */
public class MyItem {

    private Long id;
    private int imageId;
    private String name;

    public MyItem(Long id, int imageId, String name) {
        this.id = id;
        this.imageId = imageId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
