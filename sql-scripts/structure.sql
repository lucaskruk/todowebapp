create database todolist;

create table todolist.task
(id int(6) unsigned not null auto_increment, taskname varchar(100) not null,
duedate date default null, status int(1), primary key(id));

