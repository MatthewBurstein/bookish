CREATE TABLE users (
id SERIAL,
username VARCHAR(30),
password VARCHAR(30),
PRIMARY KEY (id)
);

CREATE TABLE books (
id SERIAL,
isbn VARCHAR(30),
author VARCHAR(60),
title VARCHAR(60),
number_of_copies int,
PRIMARY KEY (id)
);

CREATE TABLE loans (
id SERIAL,
start_date DATE,
end_date DATE,
user_account int REFERENCES users(id),
book int REFERENCES books(id)
);
