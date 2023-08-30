-- root 화면

create database boarddb;

create user 'board'@'localhost'
identified by '12341234';

grant all privileges on boarddb.* to 'board'@'localhost';

grant all privileges on busdb.* to 'bus'@'localhost';

flush privileges;