package com.example.wishlistapi;

import com.example.wishlistapi.filters.AuthFilter;
import jakarta.servlet.FilterRegistration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WishlistApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(WishlistApiApplication.class, args);
	}

	@Bean
    public FilterRegistrationBean<AuthFilter> filterRegistrationBean(){
		FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
		AuthFilter authFilter = new AuthFilter();
	    registrationBean.setFilter(authFilter);
		registrationBean.addUrlPatterns("/api/wishlist/*");
		return registrationBean;
	}
}
