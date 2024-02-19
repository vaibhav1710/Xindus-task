package com.example.wishlistapi.services;

import com.example.wishlistapi.domain.Wishlist;
import com.example.wishlistapi.exception.EtBadRequestException;
import com.example.wishlistapi.exception.EtResourceNotFoundException;

import java.util.List;

public interface WishlistService {

    List<Wishlist> fetchAllwishlist(Integer userId);

    Wishlist addWishlist(Integer userId, String name) throws EtBadRequestException;

    void removeWishlist(Integer userId, Integer wishlistId) throws EtResourceNotFoundException;


}
