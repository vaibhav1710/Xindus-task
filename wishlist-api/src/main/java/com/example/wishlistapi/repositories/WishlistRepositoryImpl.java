package com.example.wishlistapi.repositories;

import com.example.wishlistapi.domain.User;
import com.example.wishlistapi.domain.Wishlist;
import com.example.wishlistapi.exception.EtBadRequestException;
import com.example.wishlistapi.exception.EtResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class WishlistRepositoryImpl implements WishlistRepository {

    private static final String SQL_FIND_ALL = "SELECT WISHLIST_ID, USER_ID, NAME FROM TA_WISHLISTS WHERE USER_ID=?";
    private static final String SQL_CREATE = "INSERT INTO TA_WISHLISTS (WISHLIST_ID,USER_ID,NAME) VALUES(NEXTVAL('TA_WISHLISTS_WISHLIST_ID_SEQ'),?,?)";
    private static final String SQL_FIND_BY_ID = "SELECT WISHLIST_ID, USER_ID, NAME FROM TA_WISHLISTS WHERE USER_ID = ? AND WISHLIST_ID = ?";
    private static final String SQL_REMOVE_WISHLIST = "DELETE FROM TA_WISHLISTS WHERE USER_ID = ? AND WISHLIST_ID = ?";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Wishlist> findAll(Integer userId) throws EtResourceNotFoundException {
        return jdbcTemplate.query(SQL_FIND_ALL, new Object[]{userId}, wishlistRowMapper);
    }

    @Override
    public Integer create(Integer userId, String name) throws EtBadRequestException {
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1,userId);
                ps.setString(2,name);
                return ps;
            },keyHolder);
            return (Integer) keyHolder.getKeys().get("WISHLIST_ID");
        }catch(Exception e){
            throw new EtBadRequestException("Invalid Request");
        }
    }

    @Override
    public Wishlist findById(Integer userId, Integer wishlistId) {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{userId, wishlistId}, wishlistRowMapper);
        }catch(Exception e){
            throw new EtResourceNotFoundException("ITEM NOT FOUND");
        }
    }

    @Override
    public void removeById(Integer userId, Integer wishlistId) {
       try{
           jdbcTemplate.update(SQL_REMOVE_WISHLIST, userId, wishlistId);
       }catch(Exception e){
           throw new EtBadRequestException("Not Found");
       }
    }

    private RowMapper<Wishlist> wishlistRowMapper = ((rs, rowNum) -> {
        return new Wishlist(rs.getInt("WISHLIST_ID"),
                rs.getInt("USER_ID"),
                rs.getString("NAME"));
    });
}
