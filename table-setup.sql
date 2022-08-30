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

-- post table
create table post_table (
post_id serial primary key,
user_id int references user_table(user_id) on delete cascade,
post_text varchar(500),
image_format varchar(40)
);

-- post picture table
create table post_picture_table(
picture_id serial primary KEY ,
post_id int references post_table(post_id) on delete cascade,
picture bytea
);

-- chat table
create table chat_log_table (
chat_id serial primary key,
chat_date timestamp not null default clock_timestamp(),
user_id int references user_table(user_id) on delete cascade not null,
chat_content varchar(300) not null
);

-- comment table
create table comment_table (
comment_id serial primary key,
post_id int references post_table(post_id) on delete cascade,
user_id int references user_table(user_id) on delete cascade,
reply_user int references user_table(user_id) on delete cascade,
comment_text varchar(500)
);

-- profile pic table
create table user_picture_table(
picture_id serial primary KEY ,
user_id int references user_table(user_id) on delete cascade,
picture bytea
);