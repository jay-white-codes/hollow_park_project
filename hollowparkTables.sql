create schema hollowpark default character set utf8mb4 collate utf8mb4_unicode_ci;

create table hollowpark.user (
id bigint not NULL AUTO_INCREMENT, -- unique id for the user --
first_name varchar(100) NULL default NULL, -- first name --
middle_name varchar(100) NULL default NULL, -- middle name --
last_name varchar(100) NULL default NULL, -- last name --
mobile_num varchar(15) NULL, -- user mobile number for alternative log in/registration --
email_address varchar(255) NULL, -- user email address for log in/registration --
passwordHash varchar(50) not NULL, -- algorithmic generated password hash, no plain or encrypted passwords --
admin tinyint(1) not NULL default 0, -- identify if user is administrator, most likely won't be --
vendor tinyint(1) not NULL default 0, -- identify if user is vendor, can sell product on shop --
registrationDate datetime not NULL, -- can calculate life of user account --
lastLogin datetime NULL default NULL, -- identify when user last logged in --
intro tinytext NULL default NULL, -- vendor user into, likely won't be used --
userProfile text NULL default NULL, -- vendor details on product page --
primary key (id),
unique index uq_mobile_num (mobile_num ASC),
unique index uq_email_address (email_address ASC)
);

create table hollowpark.product (
id bigint not NULL AUTO_INCREMENT, -- identify product --
userId bigint not NULL, -- identify admin or vendor --
title varchar(75) not NULL, -- product title on shop or product page --
metaTitle varchar(100) NULL, -- meta title, used for browser and SEO --
slug varchar(100) not NULL, -- form url --
summary tinytext NULL, -- key info --
type smallint(6) not NULL default 0, -- different product types --
sku varchar(100) not NULL, -- STOCK KEEPING UNIT, inventory tracking --
price decimal(15,2) not NULL default 0, -- product price --
discount decimal(15.2) not NULL default 0, -- product discount, if applicable --
quantity smallint(6) not NULL default 0, -- available product --
shop tinyint(1) not NULL default 0, -- identify if product is available in shop --
createTime datetime not NULL, -- date and time when product was created --
updateTime datetime NULL default NULL, -- date and time when product was updated --
publishTime datetime NULL default NULL, -- date and time when product was published in shop --
startTime datetime NULL default NULL, -- date and time when product starts sale --
endTime datetime NULL default NULL, -- date and time when product stops sale --
content text NULL default NULL, -- additional product details --
primary key (id),
unique index uq_slug (slug ASC),
index idx_product_user (userId ASC),
constraint fk_product_user
foreign key (userId)
references hollowpark.user (id)
-- on DELETE no ACTION --
-- on UPDATE no ACTION --
);

create table hollowpark.cart (
id bigint not NULL AUTO_INCREMENT, -- identify cart --
userId bigint NULL default NULL, -- identify user associated with cart --
sessionId varchar(100) not NULL, -- unique session id tied to cart --
token varchar(100) not NULL, -- unique token associated with cart, identifies cart across different sessions, Payment Gateway passable
status smallint(6) not NULL default 0, -- new, cart, checkout, paid, complete, and abandoned status --
first_name varchar(100) NULL default NULL, -- user first name --
middle_name varchar(100) NULL default NULL, -- user middle name --
last_name varchar(100) NULL default NULL, -- user last name --
mobile_num varchar(15) NULL, -- user mobile number --
email_address varchar(255) NULL, -- user email address --
address1 varchar(100) NULL default NULL, -- first line of address --
address2 varchar(100) NULL default NULL, -- second address line --
city varchar(100) NULL default NULL, -- city of address --
province varchar(100) NULL default NULL, -- province/state of address --
country varchar(100) NULL default NULL, -- country of address --
createTime datetime not NULL, -- what time cart was created --
updateTime datetime NULL default NULL, -- when cart was updated --
content text NULL default NULL, -- storage of additional cart details --
primary key (id),
index idx_cart_user (userId ASC),
constraint fk_cart_user
foreign key (userId)
references hollowpark.user (id)
-- on DELETE no ACTION --
-- on UPDATE no ACTION --
);

drop table hollowpark.product;

create table Product (
id bigint (13),
itemName varchar(250),
itemSize varchar (25),
description LONGTEXT,
image varchar (50),
inStock TINYINT(4),
listPrice FLOAT,
length FLOAT,
width FLOAT,
height FLOAT);