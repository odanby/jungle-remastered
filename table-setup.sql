-- user table
create table user_table (
	user_id serial primary key,
	first_name varchar(50),
	last_name varchar(50),
	email varchar(50),
	date_of_birth date,
	username varchar(50),
	user_password varchar(50),
	about_me varchar(255),
	status varchar(50)
);
