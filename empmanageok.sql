create database empmanageok;

use empmanageok;

create table login(
username varchar(20), 
password varchar(20)
);

insert into login values('admin', '12345');

create table employee(
id varchar(20) NOT NULL, 
name varchar(30), 
gender varchar(20),  
dob varchar(30),  
email varchar(30), 
phone varchar(30), 
position varchar(30),
address varchar(50),
PRIMARY KEY  (id)
);

select *from employee;

create table attendence(
id varchar(20), 
date varchar(50), 
fh varchar(20),
sh varchar(20),
PRIMARY KEY  (id),
fOREIGN KEY (id) REFERENCES employee(id)
);
select *from attendence;

create table salary(
id varchar(20), 
hra varchar(20), 
da varchar(20), 
med varchar(20), 
pf varchar(20), 
basic varchar(20),
PRIMARY KEY  (id),
fOREIGN KEY (id) REFERENCES employee(id)
);

select *from salary;

create table leav (
id varchar(20), 
Name varchar(50), 
Start_date varchar(20),
End_date varchar(20), 
Reason varchar(20),
PRIMARY KEY  (id),
fOREIGN KEY (id) REFERENCES employee(id)
);

select *from leav;