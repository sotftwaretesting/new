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
)

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Sidorov',25,false,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Ivanov',35,false,now());

INSERT INTO test.user(name, age, isAdmin, createdDate)
VALUES('Petrov',40,true,now());
commit;

