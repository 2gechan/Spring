-- board user 화면
use boarddb;

create table tbl_users(
u_id VARCHAR(25) PRIMARY KEY,
u_password VARCHAR(125) NOT NULL,
u_name VARCHAR(125) NOT NULL,
u_tel VARCHAR(15) NOT NULL,
u_addr VARCHAR(125)
);

desc tbl_users;

insert into tbl_users
(u_id, u_password, u_name, u_tel, u_addr)
values('test', '1234', '테스트', '010-1111-1111', '광주광역시');

select * from tbl_users;

show tables;