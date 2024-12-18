create schema 2024_batch; 
use 2024_batch;
create table employee(empId int auto_increment primary key, empName varchar(200), empPhone varchar(200)); 
create table bike(id int auto_increment primary key,name varchar(10),company varchar(10));
create table tablet (id int auto_increment,tabletName varchar(200),tabletQty int,tabletPrice double, primary key (id));
create table mobile(id int auto_increment primary key ,name varchar(100),phoneNumber long,price double);
create table product(prodId int auto_increment primary key, prodName varchar(200), qty int, price double);