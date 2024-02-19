package com.example.wishlistapi.services;

import com.example.wishlistapi.domain.User;
import com.example.wishlistapi.exception.EtAuthException;
import com.example.wishlistapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public User validateUser(String email, String password) throws EtAuthException {
       if(email!=null) email = email.toLowerCase();
       return userRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email!=null) email.toLowerCase();
        if(!pattern.matcher(email).matches())
            throw new EtAuthException("Invalid email Fromat");

        Integer count = userRepository.getCountByEmail(email);
        if(count>0)
             throw new EtAuthException("Email Already in Use");

        Integer userId = userRepository.create(firstName,lastName,email,password);
        return userRepository.findById(userId);

    }
}
