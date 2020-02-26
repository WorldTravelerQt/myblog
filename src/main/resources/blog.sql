-- 创建用户表
drop table if exists t_user;
create table t_user(
    `id` bigint(20) auto_increment,
    `nickname` varchar(32) default null,
    `username` varchar(32) not null,
    `password` varchar(32) not null,
    `email` varchar(100) not null,
    `role` varchar(255) default '' comment '权限',
    `avatar` varchar(255) default '',
    `create_time` datetime,
    `modified_time` datetime,
    primary key(`id`)
);
-- 创建博客表
drop table if exists t_blog;
create table t_blog(
    `id` bigint(20) not null auto_increment,
    `title` varchar(255) not null comment '标题',
    `first_picture` varchar(255) default null comment '首图',
    `content` text comment '内容',
    `flag` varchar(255) default null comment '标记',
    `views` int(11) comment '浏览次数',
    `commendable` int(1) default 0 comment '赞赏开启',
    `share_statement` int(1) default 0 comment '转载开启',
    `allow_comment` int(1) default 0 comment '评论开启',
    `publish` int(1) default 0 comment '是否发布',
    `recommend` int(1) default 0 comment '是否推荐',
    `type_id` int(9) comment '所属分类',
    `user_id` bigint(20) not null comment '所属用户',
    `create_time` datetime comment '创建时间',
    `modified_time` datetime comment '修改时间',
    primary key (`id`),
    constraint blog
    foreign key(user_id)
       references t_user(id)
);
-- 创建标签表
drop table if exists t_tag;
create table t_tag(
    `id` bigint(20) auto_increment,
    `name` varchar(32) not null comment '标签名',
    primary key (`id`)
);
-- 创建博客和标签的关系表
drop table if exists t_blog_tag;
create table t_blog_tag(
    `id` bigint(20) auto_increment,
    `blog_id` bigint(20) not null comment '博客id',
    `tag_id` bigint(20) not null comment '标签id',
    primary key (`id`)
);
-- 创建评论表
drop table if exists t_comment;
create table t_comment(
    `id` bigint(20) auto_increment,
    `nickname` varchar(32) default null,
    `email` varchar(100) default null,
    `blog_id` bigint(20) not null ,
    `content` varchar(255) not null,
    `avatar` varchar(255) default null,
    `parent_id` bigint(20) default null comment '上级评论',
    primary key(`id`)
);
-- 创建分类表
drop table  if exists t_type;
create table t_type(
   `id` int(9) auto_increment,
   `name` varchar(32) not null,
   primary key(`id`)
);