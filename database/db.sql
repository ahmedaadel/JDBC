CREATE DATABASE jdbc_db ;

USE jdbc_db ;
CREATE table employee (
    id INT AUTO_INCREMENT PRIMARY KEY ,
    name varchar(30),
    salary Real,
    gender boolean ,
    birthdate date
);