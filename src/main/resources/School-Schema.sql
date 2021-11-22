
drop table if exists `school`;

create table school (id bigint not null auto_increment,
magic_class varchar(255) not null,
school_name varchar(255) not null,
student_id bigint, 
primary key (id));