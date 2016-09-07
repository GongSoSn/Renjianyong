create database shopping;

use shopping;

/*创建admin表*/
create table admin(
	id int not null primary key,
	nameger varchar(20) not null,
	password varchar(20) not null,
	truename varchar(20) not null
);

desc admin;

/*创建订单表tb_order*/
create table tb_order(
	o_id int(11) not null primary key,
	o_truename varchar(30),
	o_address varchar(50) not null,
	o_money datetime,
	o_time int(11)  not null,
	o_if varchar(10),
	o_user varchar(100),
	create_man int(11) not null,
	constraint fk_ao foreign key(create_man) references admin(id)
);

alter table tb_order add column create_time datetime;

desc tb_order;

/*创建公告表tb_bulletin*/
create table tb_bulletin(
	b_id int(11) not null primary key,
	b_title varchar(50),
	b_inner varchar(20) not null,
	create_time datetime,
	create_man int(11) not null,
	constraint fk_ab foreign key (create_man) references admin(id)
);

alter table tb_bulletin add column update_man int(11);
alter table tb_bulletin add column update_time datetime;

desc tb_bulletin;

/*创建商品表tb_goods*/
create table tb_goods(
	g_id int(11) not null primary key,
	g_name varchar(50) not null,
	g_price decimal(10,4) not null,
	g_subid int(11) not null,
	g_supid int(11) not null,
	g_number int,
	g_bigpic varchar(50),
	g_introduce varchar(100),
	g_iftop varchar(10),
	create_man int(11) not null,
	create_time datetime,
    constraint fk_ga foreign key(create_man) references admin(id),
    constraint fk_gb foreign key(g_subid) references tb_sub(s_id),
    constraint fk_gp foreign key(g_supid) references tb_sup(s_supid)
);

desc tb_goods;

/*创建小分类表tb_sub*/
create table tb_sub(
	s_id int(11) not null primary key,
	s_name varchar(30) not null,
	s_supid int(11) not null,
	create_man int not null,
	create_time datetime,
	constraint fk_bp foreign key(s_supid) references tb_sup(s_supid),
	constraint fk_ba foreign key(create_man) references admin(id)
);

desc tb_sub;

/*创建大分类表tb_sup*/
create table tb_sup(
	s_supid int(11) not null primary key,
	s_supname varchar(30) not null,
	create_man int not null,
	create_time datetime,
	constraint fk_pa foreign key(create_man) references admin(id)
);

desc tb_sup;

/*创建系统用户表tb_sysuser*/
create table tb_sysuser(
	s_id int(11) not null primary key auto_increment,
	s_username varchar(20),
	s_truename varchar(30),
	s_pwd varchar(20),
	s_sex int(1),
	s_birth date,
	s_idcard varchar(25),
	s_email varchar(30),
	s_phone varchar(20),
	s_address varchar(50),
	s_if int(1),
	create_man int(11),
	create_time datetime,
	update_man int(11),
	update_time datetime
);

desc tb_sysuser;

