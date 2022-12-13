-- team 스키마 사용
USE team;

-- 쿼리문 실행
-- 1. 단독 실행 : ctrl + enter
-- 2. 블록 실행 : 블록 잡고 ctrl + shift + enter
-- 3. 전체 실행 : ctrl + shift + enter
-- 다중 첨부(게시글 하나에 여러 개의 첨부가 가능)

-- DROP TABLE
DROP TABLE IF EXISTS ATTACH; -- 있으면 지워라
DROP TABLE IF EXISTS UPLOAD;

-- CREATE TABLE
CREATE TABLE UPLOAD
(
    UPLOAD_NO INT NOT NULL AUTO_INCREMENT,  -- INT/BIGINT/SMALLINT, AUTO_INCREMENT-시퀀스 대체
    TITLE VARCHAR(100),
    CONTENT VARCHAR(100),
    CREATE_DATE DATETIME,
    MODIFY_DATE DATETIME,
    CONSTRAINT PK_UPLOAD PRIMARY KEY(UPLOAD_NO) -- AUTO_INCREMENT를 사용하려면 PK 등록이 필수
);

CREATE TABLE ATTACH
(
    ATTACH_NO INT NOT NULL AUTO_INCREMENT,
    PATH VARCHAR(300),       
    ORIGIN VARCHAR(300),     
    FILESYSTEM VARCHAR(42),  
    DOWNLOAD_CNT INT,          
    HAS_THUMBNAIL SMALLINT,          
    UPLOAD_NO INT,               
    CONSTRAINT PK_ATTACH PRIMARY KEY(ATTACH_NO),
    CONSTRAINT FK_ATTACH_UPLOAD FOREIGN KEY(UPLOAD_NO) REFERENCES UPLOAD(UPLOAD_NO) ON DELETE CASCADE
);