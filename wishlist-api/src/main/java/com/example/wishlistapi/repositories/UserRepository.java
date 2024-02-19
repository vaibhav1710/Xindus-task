package com.example.wishlistapi.repositories;

import com.example.wishlistapi.domain.User;
import com.example.wishlistapi.exception.EtAuthException;

public interface UserRepository {
Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;

User findByEmailAndPassword(String email, String password) throws EtAuthException;

Integer getCountByEmail(String email);

User findById(Integer userId);

}
