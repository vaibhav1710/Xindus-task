drop database wishlistapidb;
drop user wishlistapi;
create user wishlistapi with password 'password';
create database wishlistapidb with template=template0 owner=wishlistapi;
\connect wishlistapidb;

alter default privileges grant all on tables to wishlistapi;
alter default privileges grant all on sequences to wishlistapi;

create table ta_users (
    user_id integer primary key not null,
    first_name varchar(20)  not null,
    last_name varchar(20) not null,
    password text not null,
    email varchar(30) not null
);

create table ta_wishlists (
    wishlist_id integer primary key not null,
    user_id integer  not null,
    name varchar(30) not null
);

alter table ta_wishlists add constraint tac_users_fk
foreign key (user_id) references ta_users(user_id);

--create table ta_wishlist_items (
--    item_id integer primary key not null,
--    wishlist_id integer not null,
--    user_id integer not null,
--    name varchar(30) not null,
--    description text
--);
--
--alter table ta_wishlist_items add constraint wish_tac_fk
--foreign key (wishlist_id) references ta_wishlists(wishlist_id);
--alter table ta_wishlist_items add constraint wish_user_fk
--foreign key (user_id) references ta_users(user_id);

create sequence ta_users_user_id_seq increment 1 start 1;
create sequence ta_wishlists_wishlist_id_seq increment 1 start 1;

