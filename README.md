# Spring Boot Wishlist API

## Overview

This is a Spring Boot API that provides endpoints for managing wishlists. Users can create new wishlists, retrieve their wishlists, and delete wishlists. Authentication is implemented using Spring Security. The application uses a PostgreSQL database to store wishlist data. Docker is used to containerize the application.

## Features

- **Create Wishlist**: Users can create new wishlists by providing a name.
- **Get Wishlists**: Users can retrieve their wishlists.
- **Delete Wishlist**: Users can delete a wishlist.

## Technologies Used

- Spring Boot
- JWT (for authentication)
- PostgreSQL
- Docker

## Prerequisites

1. Java JDK (17 or later)
2. Maven
3. Docker

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/spring-boot-wishlist-api.git
2. Navigate to the project directory:

   ```bash
   cd spring-boot-wishlist-api

3. Build the Docker image:

    ```bash
       docker build -t wishlist-api .

   
4. Run the Docker container:
      ```bash
      docker run -p 8080:8080 wishlist-api

The API will be accessible at http://localhost:8080.

## Database Schema

### Users Table

- **Table Name:** `ta_users`
  - `user_id` (Primary Key, Integer, Not Null)
  - `first_name` (Varchar(20), Not Null)
  - `last_name` (Varchar(20), Not Null)
  - `password` (Text, Not Null)
  - `email` (Varchar(30), Not Null)

### Wishlists Table

- **Table Name:** `ta_wishlists`
  - `wishlist_id` (Primary Key, Integer, Not Null)
  - `user_id` (Foreign Key, Integer, Not Null)
  - `name` (Varchar(30), Not Null)

### Sequences

- `ta_users_user_id_seq`: Sequence for generating user IDs.
- `ta_wishlists_wishlist_id_seq`: Sequence for generating wishlist IDs.

## Authentication

Authentication is handled using JWT (JSON Web Token). Users need to include a valid JWT token in the `Authorization` header of the request.

**Note:** When testing the Wishlist endpoints, make sure to include the authentication token in the request header. Add an "Authorization" header with the value Bearer *token* for proper authentication.


# Wishlist API

## API Endpoints


### 1. Register
**Endpoint:** `POST /api/users/register`

### 2. Login
**Endpoint:** `POST /api/users/login`

### 3. Create Wishlist
**Endpoint:** `POST /api/wishlist`

### 4. Get Wishlist
**Endpoint:** `GET /api/wishlist`

### 5. Delete Wishlist
**Endpoint** `DELETE /api/wishlist/{wishlistid}`


## Postman Collection

Explore and test the API using the [Postman Collection](https://www.postman.com/spaceflight-geoscientist-4612179/workspace/tasks/collection/30722641-53812685-8fb0-4146-95f6-4753fcb1aa9a?action=share&creator=30722641).
