-- 1. 다음 칼럼 정보를 이용하여 MEMBER 테이블을 생성하시오.
--    1) 회원번호: MEMBER_NO, NUMBER, 필수
--    2) 회원아이디: ID, VARCHAR2(30 BYTE), 필수, 중복 불가
--    3) 회원패스워드: PW, VARCHAR2(30 BYTE), 필수
--    4) 회원포인트: POINT, NUMBER, 기본값 1000
--    5) 회원등급: GRADE, VARCHAR2(10 BYTE), 도메인('VIP', 'GOLD', 'SILVER', 'BRONZE')
--    6) 회원이메일: EMAIL, VARCHAR2(100 BYTE), 중복 불가
CREATE TABLE MEMBER(
    MEMBER_NO NUMBER NOT NULL,
    ID VARCHAR2(30 BYTE) NOT NULL UNIQUE,
    PW VARCHAR2(30 BYTE) NOT NULL,
    POINT NUMBER,
    GRADE VARCHAR2(10 BYTE) CHECK(GRADE IN ('VIP', 'GOLD', 'SILVER', 'BRONZE')),
    EMAIL VARCHAR2(100 BYTE) UNIQUE
);
INSERT INTO MEMBER (MEMBER_NO, ID, PW, POINT, GRADE, EMAIL) VALUES (0, ' ', ' ',1000, NULL, NULL);
COMMIT;

-- 2. MEMBER 테이블에 다음 새로운 칼럼을 추가하시오.
--    1) 회원주소: ADDRESS VARCHAR2(200 BYTE)
--    2) 회원가입일: REGIST_DATE DATE
ALTER TABLE MEMBER ADD ADDRESS VARCHAR2(200 BYTE);
ALTER TABLE MEMBER ADD REGIST_DATE DATE;

-- 3. 추가된 회원주소 칼럼을 다시 삭제하시오.
ALTER TABLE MEMBER DROP COLUMN ADDRESS;

-- 4. 회원등급 칼럼의 타입을 VARCHAR2(20 BYTE)으로 수정하시오.
ALTER TABLE MEMBER MODIFY GRADE VARCHAR2(20 BYTE);

-- 5. 회원패스워드 칼럼의 이름을 PWD로 수정하시오.
ALTER TABLE MEMBER RENAME COLUMN PW TO PWD;

-- 6. 회원번호 칼럼에 기본키(PK_MEMBER)를 설정하시오.
ALTER TABLE MEMBER ADD CONSTRAINT PK_MEMBER PRIMARY KEY(MEMBER_NO);

-- 7. 다음 칼럼 정보를 이용하여 BOARD 테이블을 생성하시오.
--    1) 글번호: BOARD_NO, NUMBER, 필수
--    2) 글제목: TITLE, VARCHAR2(1000 BYTE), 필수
--    3) 글내용: CONTENT, VARCHAR2(4000 BYTE), 필수
--    4) 조회수: HIT, VARCHAR2(1 BYTE)
--    5) 작성자: WRITER, VARCHAR2(30 BYTE), 필수
--    6) 작성일자: CREATE_DATE, DATE
CREATE TABLE BOARD(
    BOARD_NO NUMBER NOT NULL,
    TITLE VARCHAR2(1000 BYTE) NOT NULL,
    CONTENT VARCHAR2(4000 BYTE) NOT NULL,
    HIT VARCHAR2(1 BYTE),
    WRITER VARCHAR2(30 BYTE) NOT NULL,
    CREATE_DATE DATE
);

-- 8. 조회수 칼럼의 타입을 NUMBER로 수정하시오.
ALTER TABLE BOARD MODIFY HIT NUMBER;

-- 9. 글내용 칼럼의 필수 제약조건을 제거하시오.
ALTER TABLE BOARD MODIFY CONTENT VARCHAR2(4000 BYTE) NULL;

-- 10. 작성자 칼럼에 MEMBER 테이블의 회원아이디를 참조하는 FK_BOARD_MEMBER 외래키를 설정하시오.
-- 게시글을 작성한 회원 정보가 삭제되면 해당 회원이 작성한 게시글도 모두 함께 지워지도록 처리하시오.
ALTER TABLE BOARD 
    ADD CONSTRAINT FK_BOARD_MEMBER FOREIGN KEY(WRITER) REFERENCES MEMBER(ID) 
        ON DELETE CASCADE;

-- 11. MEMBER 테이블과 BOARD 테이블을 모두 삭제하시오.
DROP TABLE BOARD;
DROP TABLE MEMBER;

-- 다음 쿼리문을 이용해서 사용자 테이블과 구매 테이블을 작성하시오.

-- 테이블 삭제
DROP TABLE BUYS;
DROP TABLE USERS;

-- 사용자 테이블
CREATE TABLE USERS (
    USER_NO NUMBER NOT NULL,                    -- 사용자번호(기본키)
    USER_ID VARCHAR2(20 BYTE) NOT NULL UNIQUE,  -- 사용자아이디
    USER_NAME VARCHAR2(20 BYTE),                -- 사용자명
    USER_YEAR NUMBER(4),                        -- 태어난년도
    USER_ADDR VARCHAR2(100 BYTE),               -- 주소
    USER_MOBILE1 VARCHAR2(3 BYTE),              -- 연락처1(010, 011 등)
    USER_MOBILE2 VARCHAR2(8 BYTE),              -- 연락처2(12345678, 11111111 등)
    USER_REGDATE DATE                           -- 등록일
);
-- 사용자 테이블 기본키
ALTER TABLE USERS
    ADD CONSTRAINT PK_USERS PRIMARY KEY(USER_NO);


-- 구매 테이블
CREATE TABLE BUYS (
    BUY_NO NUMBER NOT NULL,           -- 구매번호
    USER_ID VARCHAR2(20 BYTE) ,       -- 구매자
    PROD_NAME VARCHAR2(20 BYTE),      -- 제품명
    PROD_CATEGORY VARCHAR2(20 BYTE),  -- 제품카테고리
    PROD_PRICE NUMBER,                -- 제품가격
    BUY_AMOUNT NUMBER                 -- 구매수량
);
-- 구매 테이블 기본키
ALTER TABLE BUYS
    ADD CONSTRAINT PK_BUYS PRIMARY KEY(BUY_NO);
-- 구매-사용자 외래키
ALTER TABLE BUYS
    ADD CONSTRAINT FK_BUYS_USERS FOREIGN KEY(USER_ID)
        REFERENCES USERS(USER_ID);


-- 문제.
-- BUYS 테이블의 종속 관계를 확인하고 정규화를 수행하시오.