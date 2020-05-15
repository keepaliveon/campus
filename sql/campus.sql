DROP DATABASE IF EXISTS campus;
CREATE DATABASE campus;
USE campus;

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`
(
    `username` varchar(20)  NOT NULL COMMENT '用户名',
    `password` varchar(255) NOT NULL COMMENT '密码',
    PRIMARY KEY (`username`)
) COMMENT '管理员';

DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`
(
    `id`   INTEGER     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` varchar(50) NOT NULL COMMENT '标签名称',
    PRIMARY KEY (`id`)
) COMMENT '标签';

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `id`         char(12)     NOT NULL COMMENT 'ID即学号',
    `name`       varchar(20) COMMENT '姓名',
    `sex`        bit COMMENT '性别',
    `speciality` varchar(50) COMMENT '专业',
    `collage`    varchar(50) COMMENT '学院',
    `open_id`    varchar(255) NOT NULL UNIQUE COMMENT '微信OpenID',
    `avatar_url` varchar(255) NOT NULL COMMENT '用户头像',
    PRIMARY KEY (`id`)
) COMMENT '学生';

DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow`
(
    `student_id`  char(12) NOT NULL COMMENT '被关注者ID',
    `follower_id` char(12) NOT NULL COMMENT '关注者ID',
    PRIMARY KEY (`student_id`, `follower_id`),
    CONSTRAINT FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
    CONSTRAINT FOREIGN KEY (`follower_id`) REFERENCES `student` (`id`)
) COMMENT '关注';

DROP TABLE IF EXISTS `community`;
CREATE TABLE `community`
(
    `id`       char(6)      NOT NULL COMMENT 'ID',
    `name`     varchar(50)  NOT NULL COMMENT '社团名称',
    `password` varchar(255) NOT NULL COMMENT '登陆密码',
    `intro`    varchar(255) NOT NULL COMMENT '社团介绍',
    `img_name` varchar(255) NOT NULL COMMENT '图片名称',
    `img_url`  text         NOT NULL COMMENT '图片地址',
    PRIMARY KEY (`id`)
) COMMENT '社团';

DROP TABLE IF EXISTS `join`;
CREATE TABLE `join`
(
    `student_id`   char(12) NOT NULL COMMENT '学生ID',
    `community_id` char(6)  NOT NULL COMMENT '社团ID',
    `state`        bit      NOT NULL DEFAULT 0 COMMENT '状态',
    PRIMARY KEY (`student_id`, `community_id`),
    CONSTRAINT FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
    CONSTRAINT FOREIGN KEY (`community_id`) REFERENCES `community` (`id`)
) COMMENT '学生加入社团中间表';

DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`
(
    `id`    INTEGER      NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`  varchar(50)  NOT NULL COMMENT '板块名称',
    `title` varchar(255) NOT NULL COMMENT '板块标题',
    `color` varchar(255) NOT NULL COMMENT '板块色彩',
    `icon`  varchar(255) NOT NULL COMMENT '板块图标',
    PRIMARY KEY (`id`)
) COMMENT '板块';

DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`
(
    `id`         char(14)     NOT NULL COMMENT 'ID',
    `student_id` char(12)     NOT NULL COMMENT '学生ID',
    `group_id`   INTEGER      NOT NULL COMMENT '板块ID',
    `time`       timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
    `content`    varchar(255) NOT NULL COMMENT '发布内容',
    `title`      varchar(255) NOT NULL COMMENT '发布标题',
    `pic_url`    text         NOT NULL COMMENT '配图',
    PRIMARY KEY (`id`),
    CONSTRAINT FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
    CONSTRAINT FOREIGN KEY (`group_id`) REFERENCES `group` (`id`)
) COMMENT '帖子';

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`
(
    `id`            char(14)    NOT NULL COMMENT 'ID',
    `post_id`       char(50)    NOT NULL COMMENT '帖子ID',
    `student_id`    char(12)    NOT NULL COMMENT '学生ID',
    `time`          timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
    `content`       varchar(80) NOT NULL COMMENT '内容',
    `to_comment_id` char(20)    NOT NULL COMMENT '回复评论ID',
    PRIMARY KEY (`id`),
    CONSTRAINT FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
    CONSTRAINT FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) COMMENT '评论';

DROP TABLE IF EXISTS `like`;
CREATE TABLE `like`
(
    `post_id`    char(14)  NOT NULL COMMENT '帖子ID',
    `student_id` char(12)  NOT NULL COMMENT '学生ID',
    `time`       timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '点赞时间',
    PRIMARY KEY (`post_id`, `student_id`),
    CONSTRAINT FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
    CONSTRAINT FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) COMMENT '点赞';

DROP TABLE IF EXISTS `accuse`;
CREATE TABLE `accuse`
(
    `post_id`     char(14)     NOT NULL COMMENT '帖子ID',
    `student_id`  char(12)     NOT NULL COMMENT '举报人ID',
    `reason_type` int(1)       NOT NULL COMMENT '举报类型',
    `content`     varchar(255) NOT NULL COMMENT '举报内容',
    `time`        timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '举报时间',
    PRIMARY KEY (`post_id`, `student_id`),
    CONSTRAINT FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
    CONSTRAINT FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) COMMENT '举报';