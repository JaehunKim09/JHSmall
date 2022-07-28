--Drop Table
drop table client;
drop table admin;
drop table product;
drop table product_order;
drop table review;
drop table mtm;
drop table cart;

--Delete Table
delete from client;
delete from admin;
delete from product;
delete from product_order;
delete from review;
delete from mtm;
delete from cart;

--Select
select * from client;
select * from admin;
select * from product;
select * from product_order;
select * from review;
select * from mtm;


--Table
create table client(
id      varchar2(100)  not null, --PK
pw 	    varchar2(100)  not null,
name    varchar2(100)  not null,
email   varchar2(100)  not null,
address1 varchar2(100) not null,
address2 varchar2(100) not null,
phone   varchar2(100)  not null,
CONSTRAINT Client_PK PRIMARY KEY(id)
);

insert into CLIENT values('cc','123','몽롱','aa@naver.com','aa','aa','222');


create table admin(
id   varchar2(100) not null, --PK
name varchar2(100) not null,
pw   varchar2(100) not null,
CONSTRAINT Admin_PK PRIMARY KEY(id)
);

create table product(
pNum        number       not null, --PK
pName       varchar2(100) not null,
pPrice      number       not null,
pImg        varchar2(100),
pShortInfo  varchar2(200),
pDetailInfo varchar2(4000),
pCategory   varchar2(100),
CONSTRAINT Product_PK PRIMARY KEY(pNum)
);


create table product_order(
pNum      number, --FK : product(pNum)
id        varchar2(100), --FK : client(id)
oNum      number        not null, --PK
oPrice    number        not null,
cnt       number        default 1 not null,
oName     varchar2(100)  not null,
oAddress  varchar2(100) not null,
oPhone    varchar2(100),
oDate     TimeStamp     default sysdate,
CONSTRAINT P_order_PK PRIMARY KEY(oNum),

CONSTRAINT Client_FK
FOREIGN KEY(id) REFERENCES client(id)
ON DELETE CASCADE,

CONSTRAINT Product_FK
FOREIGN KEY(pNum) REFERENCES product(pNum)
ON DELETE CASCADE
);

select * from review;
create table review(
pNum       number       , --FK : product(pNum)
id         varchar2(100), --FK : client(id)
oNum       number       , --FK : product_order(oNum)
rNum       number       not null, --PK
content    varchar2(4000),
rImg       varchar2(1000),
rReply	   varchar2(1000),
rDate      TimeStamp    default sysdate not null,
CONSTRAINT Review_PK PRIMARY KEY(rNum),

CONSTRAINT Client_review_FK
FOREIGN KEY(id) REFERENCES client(id)
ON DELETE CASCADE,

CONSTRAINT Product_review_FK
FOREIGN KEY(pNum) REFERENCES product(pNum)
ON DELETE CASCADE,

CONSTRAINT P_order_review_FK
FOREIGN KEY(oNum) REFERENCES product_order(oNum)
ON DELETE CASCADE
);

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'review';

select * from mtm;
create table mtm(
id      varchar2(15)   , --FK : client(id)
mNum    number         not null,
mKind   varchar2(20)   not null,
title   varchar2(100)  not null,
content varchar2(4000) not null,
reply   varchar2(4000),
mDate   TimeStamp      default sysdate not null,

CONSTRAINT mtm_PK PRIMARY KEY(mNum),

CONSTRAINT Client_mtm_FK
FOREIGN KEY(id) REFERENCES client(id)
ON DELETE CASCADE
);

create table cart(
cNum number not null primary key,
id   varchar2(100),
pNum number,
cnt  number
);

--Drop sequence
drop sequence pNum_seq;
drop sequence oNum_seq;
drop sequence rNum_seq;
drop sequence mNum_seq;
drop sequence cNum_seq;

--Create Sequence
create sequence pNum_seq start with 1 increment by 1;
create sequence oNum_seq start with 1 increment by 1;
create sequence rNum_seq start with 1 increment by 1;
create sequence mNum_seq start with 1 increment by 1;
create sequence cNum_seq start with 1 increment by 1;

--Drop view
drop view mypage1_view;
drop view mypage5_view;
drop view cart_view;

--Create View
create or replace view mypage1_view
as
select c.id, p.pNum, p.pName, p.pShortInfo, p.pImg, o.oNum, o.oDate, o.oPrice, o.cnt
from CLIENT c, PRODUCT p, PRODUCT_ORDER o
where p.pNum = o.pNum and c.id = o.id;


create or replace view mypage5_view
as
select c.id, p.pNum, p.pName, p.pImg, r.content, r.rReply, r.rDate
from CLIENT c, PRODUCT p, REVIEW r
where p.pNum = r.pNum and c.id = r.id;

drop view mypage5_view;
select * from mypage5_view;


create or replace view cart_view
as
select ct.cNum, ct.id, ct.pNum, ct.cnt, p.pImg, p.pName, p.pPrice
from cart ct, client c, product p 
where ct.id = c.id and ct.pNum = p.pNum;
