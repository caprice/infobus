CREATE SCHEMA didi_plate DEFAULT CHARACTER SET utf8 ;
--CREATE SCHEMA openfire DEFAULT CHARACTER SET utf8 ;


CREATE TABLE didi_plate.user (
  username VARCHAR(50) NOT NULL ,
  name VARCHAR(50) NULL ,
  password VARCHAR(50) NULL ,
  email VARCHAR(50) NULL ,
  status SMALLINT NULL ,
  createDate varchar(20),
  updateDate varchar(20),
  PRIMARY KEY (username)
);

CREATE TABLE didi_plate.userdetail (
  username VARCHAR(50) NOT NULL ,
  nickname VARCHAR(50) NULL ,
  plate VARCHAR(50) NULL ,
  phone VARCHAR(50) NULL ,
  idcard varchar(30) NULL,
  sex SMALLINT NULL ,
  age INT NULL ,
  birth varchar(20),
  profession VARCHAR(45) NULL ,
  signature VARCHAR(255) NULL ,
  location VARCHAR(255) NULL ,
  PRIMARY KEY (username)
);
  
CREATE TABLE didi_plate.ugroup(
  groupname             VARCHAR(50)     NOT NULL,
  description           VARCHAR(255),
  PRIMARY KEY (groupName)
);

CREATE TABLE didi_plate.groupuser (
  groupname             VARCHAR(50)     NOT NULL,
  username              VARCHAR(100)    NOT NULL,
  administrator         TINYINT         NOT NULL,
  PRIMARY KEY (groupname, username, administrator)
);