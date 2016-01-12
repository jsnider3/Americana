CREATE DATABASE results;
USE results;

CREATE TABLE results (
  ipaddr VARCHAR(30) NOT NULL,
  cmp INT NOT NULL,
  first INT NOT NULL,
  second INT NOT NULL,
  count INT NOT NULL,
  time INT NOT NULL,
  ruid INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY(ruid)
);
