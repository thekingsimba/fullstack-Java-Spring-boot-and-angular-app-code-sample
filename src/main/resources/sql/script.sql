create database testingdb;

use testingdb;

CREATE TABLE 'users' (
    'id' INT NOT NULL AUTO_INCREMENT,
    'username' VARCHAR(45) NOT NULL,
    'password' VARCHAR(45) NOT NULL,
    'enabled' INT NOT NULL,
    PRIMARY_KEY('id')
);

CREATE TABLE 'authorities' (
    'id' INT NOT NULL AUTO_INCREMENT,
    'username' VARCHAR(45) NOT NULL,
    'authority' VARCHAR(45) NOT NULL,
    PRIMARY_KEY('id')
);