CREATE TABLE users
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(70) NOT NULL UNIQUE,
    username VARCHAR(50) NOT NULL UNIQUE,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    password VARCHAR(255) NOT NULL,
    profile_picture_path VARCHAR(255)
);