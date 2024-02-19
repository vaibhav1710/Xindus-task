package com.example.wishlistapi.services;

import com.example.wishlistapi.domain.Wishlist;
import com.example.wishlistapi.exception.EtBadRequestException;
import com.example.wishlistapi.exception.EtResourceNotFoundException;
import com.example.wishlistapi.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService{

    @Autowired
    WishlistRepository wishlistRepository;


    @Override
    public List<Wishlist> fetchAllwishlist(Integer userId) {
        return wishlistRepository.findAll(userId);
    }

    @Override
    public Wishlist addWishlist(Integer userId, String name) throws EtBadRequestException {
        int wishlistId = wishlistRepository.create(userId,name);
        return wishlistRepository.findById(userId,wishlistId);
    }

    @Override
    public void removeWishlist(Integer userId, Integer wishlistId) throws EtResourceNotFoundException {
        wishlistRepository.removeById(userId,wishlistId);
    }
}
