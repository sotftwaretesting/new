CREATE DATABASE test;

CREATE USER 'root'@'localhost'
  IDENTIFIED BY 'root';

GRANT ALL PRIVILEGES ON test.* To 'root'@'localhost' IDENTIFIED BY 'root';

CREATE TABLE USER(
id int(8) AUTO_INCREMENT,
name varchar(25),
age int,
isAdmin bit,
createdDate TIMESTAMP,
PRIMARY KEY(id)
);

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Sasha',25,false,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Vasya',35,false,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Slava',20,true,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Igor',44,true,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Luba',50,true,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Tanya',90,false,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Alex',23,true,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Nikita',15,true,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Dima',33,false,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Yana',54,FALSE ,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Natasha',23,true,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Petr',32,true,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Ira',33,false,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Denis',66,true,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Victor',33,false,now());

<<<<<<< HEAD
=======

>>>>>>> 152075e23b147ff1e160e58416c881e642fc7f61
commit;

