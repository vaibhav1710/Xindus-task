package com.example.wishlistapi.repositories;

import com.example.wishlistapi.domain.Wishlist;
import com.example.wishlistapi.exception.EtBadRequestException;
import com.example.wishlistapi.exception.EtResourceNotFoundException;

import java.util.List;

public interface WishlistRepository {
    List<Wishlist> findAll(Integer userId) throws EtResourceNotFoundException;
    Integer create(Integer userId, String name) throws EtBadRequestException;

    void removeById(Integer userId, Integer wishlistId);

     Wishlist findById(Integer userId, Integer wishlistId);

}
