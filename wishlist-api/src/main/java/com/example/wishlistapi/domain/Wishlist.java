package com.example.wishlistapi.domain;

public class Wishlist {
    private Integer wishlistId;
    private Integer userId;
    private String name;

    public Wishlist(Integer wishlistId, Integer userId, String name) {
        this.wishlistId = wishlistId;
        this.userId = userId;
        this.name = name;
    }

    public Integer getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Integer wishlistid) {
        this.wishlistId = wishlistid;
    }

    public Integer getuserId() {
        return userId;
    }

    public void setuserId(Integer userid) {
        this.userId = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
