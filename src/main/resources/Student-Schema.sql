drop table if exists `school`;
drop table if exists `student`;

create table `student` (`id` bigint not null auto_increment,
						`age` bigint not null,
						`magic_type` varchar(255) not null,
						`name` varchar(255) not null)
						;
