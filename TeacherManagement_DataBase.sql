create database Teacher_Management_1;

use Teacher_Management_1;

create table Teachers_data_1(
							id int(10) primary key,
                            Name varchar(150),
                            DOB varchar(10),
                            Age int(10),
                            Gender varchar(100),
                            Mobile  int(10),
                            Subject varchar(150),
                            Qualification varchar(150),
                            Address varchar(300));
create table Classes__allocated(
							id int(10) primary key,
                            Name varchar(150),
                            DOB varchar(100),
                            Classes_Allocated int(30),
                            Subject varchar(100),
                            Mobile int(10));
		alter table Teachers_data_1 add Gmail varchar(20);
        alter table Teachers_data_1 modify Gmail varchar(20) after Mobile;
        select * from classes__allocated;
        select * from Teachers_data_1;
		alter table classes__allocated add Salary bigint(255);
insert into Teachers_data_1 values(1093,"DURGA","02-02-1997",26,"Male",984806643,"Durga1093@gmail.com","Mathematics","BTech","8-2-396");
insert into Teachers_data_1(id,Name,DOB,Age,Gender,Mobile,Gmail,Subject,Qualification,Address) values(1094,"RAVI","03-07-1996",27,"Male",767287678,"Ravi1094@gmail.com","English","MA in Literature","9-09-203");
insert into Teachers_data_1 values(1111,"HARI","09-97-1994",29,"Male",989897876,"Hari1111@gmail.com","Biology","MBBS","09-89-765");
insert into Teachers_data_1 values(1119,"Subhadra","08-10-1993",30,"Female",878789554,"Subha1119@gmail.com","Science","BE","98-09-654");
insert into Teachers_data_1 values(1590,"Kumar Karthikeya","05-12-1995",28,"Male",989986677,"kumar1590@gmail.com","Hindi","MA","98-03-234");
insert into Teachers_data_1 values(1990,"Harika","07-09-1999",24,"Female",703209988,"Harika1990@gmail.com","Social Studies","BSC","90-87-546");

insert into classes__allocated values(1093,"DURGA","02-02-1997",6,"Mathematics",984806643,25000);
insert into classes__allocated values(1094,"Ravi","03-07-1996",6,"English",767287678,35000);
insert into classes__allocated values(1111,"Hari","09-97-1994",6,"Bilogy",989897876,30000);
insert into classes__allocated values(1119,"Subhadra","08-10-1993",6,"Science",878789554,20000);
insert into classes__allocated values(1590,"Kumar Karthikeya","05-12-1995",6,"HIndi",989986677,40000);
insert into classes__allocated values(1990,"Harika","07-09-1999",6,"Social Studies",703209988,50000);
