CREATE DATABASE results;
USE results;

CREATE TABLE results (
  ipaddr VARCHAR(30) NOT NULL,
  cmp INT NOT NULL,
  first INT NOT NULL,
  second INT NOT NULL,
  count INT NOT NULL,
  time INT NOT NULL, -- How long it took to make a decision.
  ruid INT NOT NULL AUTO_INCREMENT,
  timestamp double DEFAULT NULL, -- The time since epoch.
  PRIMARY KEY(ruid)
);
