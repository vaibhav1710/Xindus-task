package com.example.wishlistapi.resources;

import com.example.wishlistapi.domain.Wishlist;
import com.example.wishlistapi.exception.EtBadRequestException;
import com.example.wishlistapi.exception.EtResourceNotFoundException;
import com.example.wishlistapi.services.WishlistService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/wishlist")
public class WishListResource {

    @Autowired
    WishlistService wishlistService;

    @GetMapping("")
    public ResponseEntity<List<Wishlist>> getAllWishlist(HttpServletRequest request){
        int userId = (Integer) request.getAttribute("userId");
        List<Wishlist> wishlist = wishlistService.fetchAllwishlist(userId);
        return new ResponseEntity<>(wishlist,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Wishlist> addWishlist(HttpServletRequest request,
                                                @RequestBody Map<String,Object> wishlistMap){
        int userId = (Integer) request.getAttribute("userId");
        String name = (String) wishlistMap.get("name");
        Wishlist wishlist = wishlistService.addWishlist(userId,name);
        return new ResponseEntity<>(wishlist, HttpStatus.CREATED);
    }

    @DeleteMapping("/{wishlistId}")
    public ResponseEntity<Void> removeWishlist(HttpServletRequest request, @PathVariable Integer wishlistId) {
        try {
            int userId = (Integer) request.getAttribute("userId");
            wishlistService.removeWishlist(userId, wishlistId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        } catch (EtResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        } catch (EtBadRequestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400 Bad Request
        }
    }
}
