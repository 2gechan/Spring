-- board user 화면

use boarddb;

show tables;
desc tbl_users;

select * from tbl_users;

create table tbl_board (
b_seq bigint primary key auto_increment,
b_uid varchar(25),
b_title varchar(125),
b_content varchar(1000),
b_nickname varchar(125),
b_date varchar(10),
b_viewcount long
);
drop table tbl_board;
desc tbl_board;

select * from tbl_board;
truncate tbl_board;

delete from tbl_board where b_seq = 1;

insert into tbl_board(b_uid, b_title, b_content, b_nickname, b_date, b_viewcount)
values('test','15', '내용테스트', '닉네임테스트', '날짜테스트', 0);

select * from tbl_board limit 5 offset 0;

select count(*) from tbl_board;