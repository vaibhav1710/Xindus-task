package com.example.wishlistapi.services;

import com.example.wishlistapi.domain.User;
import com.example.wishlistapi.exception.EtAuthException;

public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;
    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
}
