DROP TABLE IF EXISTS USERS_TBL;

CREATE TABLE USERS_TBL(
                          ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                          NAME VARCHAR(20),
                          SURNAME VARCHAR(20)
);
CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;