/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  jswitzer09
 * Created: Dec 7, 2016
 */
DROP DATABASE IF EXISTS comp31a3;
CREATE DATABASE comp31a3;
USE comp31a3;

CREATE TABLE users
(
    userId      INT(3) NOT NULL AUTO_INCREMENT,
    userType    VARCHAR(25),
    firstName   VARCHAR(25),
    lastName    VARCHAR(25),
    userName    VARCHAR(50),
    passWord    VARCHAR(25),
    PRIMARY KEY (userId)
);
CREATE TABLE posts
(
    postId      INT(3) NOT NULL AUTO_INCREMENT,
    userId      INT(3) NOT NULL,
    postName    VARCHAR(20),
    postCreator VARCHAR(20),
    postContent VARCHAR(255),
    postDate    DATE,
    PRIMARY KEY (postId),
    FOREIGN KEY (userId)
        REFERENCES users(userId)
);

INSERT INTO users VALUES    (DEFAULT,'Admin','Admin','Admin','Admin',''),
                            (DEFAULT,'Moderator','Josh','Switzer','jswitzer','1111'),
                            (DEFAULT,'Guest','Ty','Gibbons','tgibbons','2222'),
                            (DEFAULT,'Moderator','Matt','St-Jean','mstjean','3333'),
                            (DEFAULT,'General','Aiden','Scott','ascott','4444'),
                            (DEFAULT,'Admin','Colin','Banger','cbanger','5555');

INSERT INTO posts VALUES    (DEFAULT,1,'Random Post Name','Admin','Hello','2016-10-24'),
                            (DEFAULT,3,'More Post Names','tgibbons','I Havent','2016-10-21'),
                            (DEFAULT,5,'Not Quite Sure','ascott','Figured Out','2016-10-22'),
                            (DEFAULT,4,'Hello','mstjean','How To','2016-10-14'),
                            (DEFAULT,2,'SQL','jswitzer','Do Many','2016-10-11'),
                            (DEFAULT,2,'DB2','jswitzer','Things','2016-10-27'),
                            (DEFAULT,2,'Oracle','jswitzer','In Java','2016-10-25'),
                            (DEFAULT,2,'PHP','jswitzer','Therefor','2016-10-2'),
                            (DEFAULT,2,'C#','jswitzer','I Am','2016-10-1'),
                            (DEFAULT,2,'C++','jswitzer','Going','2016-10-6'),
                            (DEFAULT,2,'COBOL','jswitzer','To Receive','2016-10-9'),
                            (DEFAULT,2,'CICS','jswitzer','Extremely','2016-10-14'),
                            (DEFAULT,2,'JCL','jswitzer','Low Marks.','2016-10-12'),
                            (DEFAULT,2,'Access','jswitzer','This is a Message of a Post','2016-10-3');