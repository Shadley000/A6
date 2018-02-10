drop table if exists ALARM_PIVOT;
drop table if exists ALARM_DATA;
drop table if exists ALARM_TYPE;
drop table if exists ALARM_STATUS;
drop table if exists ALARM_PRIORITY;
drop table if exists MESSAGE_TYPE;
drop table if exists SUBSYSTEM;
drop table if exists SYSTEM;
drop table if exists ALARM_STAGING;
drop table if exists ERROR_LOG;
drop table if exists ALARM_FILE;

drop table if exists INSTALLATION;
drop table if exists PARSER_TYPE;
drop table if exists SHIP;
drop table if exists VENDOR;
drop table if exists CONTRACTOR;

CREATE TABLE CONTRACTOR (
    ID INT AUTO_INCREMENT,
    NNAME VARCHAR(64),
    LOGO VARCHAR(128),
    PRIMARY KEY (ID)
);

CREATE TABLE VENDOR (
    ID INT AUTO_INCREMENT,
    NNAME VARCHAR(64),
    LOGO VARCHAR(128),
    PRIMARY KEY (ID)
);

CREATE TABLE SHIP (
    ID INT AUTO_INCREMENT,
    NNAME VARCHAR(64),
    LOGO VARCHAR(128),
    PRIMARY KEY (ID)
);

CREATE TABLE INSTALLATION (
    ID INT AUTO_INCREMENT,
    ID_VENDOR INT,
    ID_SHIP INT,
    ID_CONTRACTOR INT,
    PARSER_NAME VARCHAR(64),
    NNAME VARCHAR(64),
    DATA_DIRECTORY VARCHAR(256),
    
    PRIMARY KEY (ID),
    FOREIGN KEY (ID_VENDOR) REFERENCES VENDOR (ID),
    FOREIGN KEY (ID_SHIP) REFERENCES SHIP (ID),
    FOREIGN KEY (ID_CONTRACTOR) REFERENCES CONTRACTOR (ID),
    UNIQUE (DATA_DIRECTORY)
);

CREATE TABLE ALARM_FILE(
 	ID INT AUTO_INCREMENT,
    ID_INSTALLATION INT,
    FILE_NAME VARCHAR(128),
	LOAD_DATE TIMESTAMP default now(),
    LINES_COUNT INT default 0,
    INSERTED_COUNT INT default 0,
    SKIPPED_COUNT INT default 0,
    ERROR_COUNT INT default 0,
    PRIMARY KEY (ID),
   FOREIGN KEY (ID_INSTALLATION)
        REFERENCES INSTALLATION (ID)
);

CREATE TABLE ERROR_LOG (
    ID INT AUTO_INCREMENT,
    ID_INSTALLATION INT,
    ID_ALARM_FILE INT,
    LINE_NUMBER INT,
    ERROR_MESSAGE VARCHAR(512),
    
    PRIMARY KEY (ID),
    FOREIGN KEY (ID_ALARM_FILE)
        REFERENCES ALARM_FILE (ID),
    FOREIGN KEY (ID_INSTALLATION)
        REFERENCES INSTALLATION (ID)
);

CREATE TABLE ALARM_STAGING (
    ID INT AUTO_INCREMENT,
    ID_INSTALLATION INT,
    ID_ALARM_FILE INT,
    ALARM_TIME DATETIME,
    ALARM_DATE DATE DEFAULT NULL,
    SYSTEM VARCHAR(64),
    SUBSYSTEM VARCHAR(64),
    MESSAGE_TYPE VARCHAR(64),
    TAG_NAME VARCHAR(32),
    ALARM_PRIORITY VARCHAR(16),
    ALARM_STATUS VARCHAR(16),
    DESCRIPTION VARCHAR(256),
    ID_ALARM_TYPE INT default 0,
    ALREADY_EXISTS INT DEFAULT 0,
    PRIMARY KEY (ID),
    FOREIGN KEY (ID_INSTALLATION)      REFERENCES INSTALLATION (ID),
	FOREIGN KEY (ID_ALARM_FILE)        REFERENCES ALARM_FILE (ID)
);
    
CREATE TABLE ALARM_TYPE (
    ID INT  AUTO_INCREMENT,
    ID_INSTALLATION INT,
    SYSTEM VARCHAR(64),
    SUBSYSTEM VARCHAR(64),
    MESSAGE_TYPE VARCHAR(64),
    ALARM_PRIORITY VARCHAR(16),
    TAG_NAME VARCHAR(32),
    DESCRIPTION VARCHAR(256),
    PRIMARY KEY (ID),
    FOREIGN KEY (ID_INSTALLATION)  REFERENCES INSTALLATION (ID),
    UNIQUE (ID_INSTALLATION , SYSTEM , SUBSYSTEM , MESSAGE_TYPE , ALARM_PRIORITY , TAG_NAME , DESCRIPTION)
);

CREATE TABLE ALARM_DATA (
    ID INT AUTO_INCREMENT,
    ID_INSTALLATION INT,
    ID_ALARM_FILE INT,
    ID_ALARM_TYPE INT,
    ALARM_STATUS VARCHAR(16),
    ALARM_TIME DATETIME,
    ALARM_DATE DATE DEFAULT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (ID_INSTALLATION)   REFERENCES INSTALLATION (ID),
	FOREIGN KEY (ID_ALARM_FILE)     REFERENCES ALARM_FILE (ID),
    FOREIGN KEY (ID_ALARM_TYPE)     REFERENCES ALARM_TYPE (ID)
);


create table ALARM_PIVOT
( 	ID_INSTALLATION int,
	ID_ALARM_TYPE int,
    ALARM_COUNT int,
	ALARM_DATE date,
	FOREIGN KEY (ID_INSTALLATION)
        REFERENCES INSTALLATION (ID)
);

INSERT INTO CONTRACTOR (ID,NNAME,LOGO) VALUES (1,"Ocean Diamond","images\Diamond\Diamond_Offshore.png");
INSERT INTO CONTRACTOR (ID,NNAME,LOGO) VALUES (2,"Demo Client","images\DEMO\DEMO_Client.png");
INSERT INTO CONTRACTOR (ID,NNAME,LOGO) VALUES (3,"Transocean","images\Transocean\DEMO_Client.png");


INSERT INTO SHIP (ID,NNAME,LOGO) VALUES (1,"BlackRhino","images\Diamond\BlackRhino.png");
INSERT INTO SHIP (ID,NNAME,LOGO) VALUES (2,"BlackLion","images\Diamond\BlackLion.png");
INSERT INTO SHIP (ID,NNAME,LOGO) VALUES (3,"BlackHawk","images\Diamond\BlackHawk.png");
INSERT INTO SHIP (ID,NNAME,LOGO) VALUES (4,"BlackHornet","images\Diamond\BlackHornet.png");
INSERT INTO SHIP (ID,NNAME,LOGO) VALUES (5,"Demo Rig 1","images\DEMO\DEMO_platform.png");
INSERT INTO SHIP (ID,NNAME,LOGO) VALUES (6,"Demo Rig 2","images\DEMO\DEMO_platform.png");
INSERT INTO SHIP (ID,NNAME,LOGO) VALUES (7,"Sedco Energy","images\Transocean\DEMO_platform.png");
INSERT INTO SHIP (ID,NNAME,LOGO) VALUES (8,"Cajun Express","images\Transocean\DEMO_platform.png");

INSERT INTO VENDOR (ID,NNAME,LOGO) VALUES (1,"NOV Cyberbase","images\vendor\nov.png");
INSERT INTO VENDOR (ID,NNAME,LOGO) VALUES (2,"Kongsberg VMS","images\vendor\kongsberg.png");
INSERT INTO VENDOR (ID,NNAME,LOGO) VALUES (3,"NOV Amphieon","images\vendor\nov.png");

INSERT INTO INSTALLATION(ID_CONTRACTOR, ID_SHIP, ID_VENDOR, NNAME, DATA_DIRECTORY, PARSER_NAME) VALUES (1,1,2,"BlackRhino Kongsberg",		"BlackRhinoKM",		"KM1");
INSERT INTO INSTALLATION(ID_CONTRACTOR, ID_SHIP, ID_VENDOR, NNAME, DATA_DIRECTORY, PARSER_NAME) VALUES (1,1,1,"BlackRhino NOV",			"BlackRhinoNOV",	"NOV1");
INSERT INTO INSTALLATION(ID_CONTRACTOR, ID_SHIP, ID_VENDOR, NNAME, DATA_DIRECTORY, PARSER_NAME) VALUES (1,2,2,"BlackLion Kongsberg",		"BlackLionKM",		"KM1");
INSERT INTO INSTALLATION(ID_CONTRACTOR, ID_SHIP, ID_VENDOR, NNAME, DATA_DIRECTORY, PARSER_NAME) VALUES (1,2,1,"BlackLion NOV",			"BlackLionNOV",		"NOV1");
INSERT INTO INSTALLATION(ID_CONTRACTOR, ID_SHIP, ID_VENDOR, NNAME, DATA_DIRECTORY, PARSER_NAME) VALUES (1,3,2,"BlackHawk Kongsberg",		"BlackHawkKM",		"KM1");
INSERT INTO INSTALLATION(ID_CONTRACTOR, ID_SHIP, ID_VENDOR, NNAME, DATA_DIRECTORY, PARSER_NAME) VALUES (1,3,1,"BlackHawk NOV",			"BlackHawkNOV",		"NOV1");
INSERT INTO INSTALLATION(ID_CONTRACTOR, ID_SHIP, ID_VENDOR, NNAME, DATA_DIRECTORY, PARSER_NAME) VALUES (1,4,2,"BlackHornet Kongsberg",	"BlackHornetKM",	"KM1");
INSERT INTO INSTALLATION(ID_CONTRACTOR, ID_SHIP, ID_VENDOR, NNAME, DATA_DIRECTORY, PARSER_NAME) VALUES (1,4,1,"BlackHornet NOV",			"BlackHornetNOV",	"NOV1");
INSERT INTO INSTALLATION(ID_CONTRACTOR, ID_SHIP, ID_VENDOR, NNAME, DATA_DIRECTORY, PARSER_NAME) VALUES (2,5,2,"Ship 1 Kongsberg",			"Ship1KM",			"KM1");
INSERT INTO INSTALLATION(ID_CONTRACTOR, ID_SHIP, ID_VENDOR, NNAME, DATA_DIRECTORY, PARSER_NAME) VALUES (2,5,1,"Ship 1 NOV",				"Ship1NOV",			"NOV1");
INSERT INTO INSTALLATION(ID_CONTRACTOR, ID_SHIP, ID_VENDOR, NNAME, DATA_DIRECTORY, PARSER_NAME) VALUES (2,6,2,"Ship 2 Kongsberg",			"Ship2KM",			"KM1");
INSERT INTO INSTALLATION(ID_CONTRACTOR, ID_SHIP, ID_VENDOR, NNAME, DATA_DIRECTORY, PARSER_NAME) VALUES (2,6,1,"Ship 2 NOV",				"Ship2NOV",			"NOV1");
INSERT INTO INSTALLATION(ID_CONTRACTOR, ID_SHIP, ID_VENDOR, NNAME, DATA_DIRECTORY, PARSER_NAME) VALUES (3,7,3,"Sedco Energy Amphieon",	"SedcoEnergyNOV",	"NOV1");
INSERT INTO INSTALLATION(ID_CONTRACTOR, ID_SHIP, ID_VENDOR, NNAME, DATA_DIRECTORY, PARSER_NAME) VALUES (3,8,3,"Cajun Express Amphieon",	"CajunExpressNOV",	"NOV1");


        

