-- 테이블 삭제
DROP TABLE CUSTOMER;
DROP TABLE BANK;
-- BANK 테이블 생성
CREATE TABLE BANK(
    BANK_CODE VARCHAR2(20 BYTE) NOT NULL,
    BAKN_NAME VARCHAR2(30 BYTE) NULL
);
-- CUSTOMER 테이블 생성
CREATE TABLE CUSTOMER( -- NULL은 생략가능 
    CUS_NO NUMBER,
    CUS_NAME VARCHAR2(30 BYTE) NOT NULL,
    CUS_PHONE VARCHAR2(30 BYTE) UNIQUE,
    CUS_AGE NUMBER CHECK(CUS_AGE BETWEEN 0 AND 100),  -- BETWEEN AND 날짜 언제부터 언제까지 조건으로도 사용
    BANK_CODE VARCHAR2(20 BYTE)
);
-- 기본키 추가
ALTER TABLE BANK ADD CONSTRAINT PK_BANK PRIMARY KEY(BANK_CODE); 
ALTER TABLE CUSTOMER ADD CONSTRAINT PK_CUSTOMER PRIMARY KEY(CUS_NO);
-- 외래키 추가
ALTER TABLE CUSTOMER 
    ADD CONSTRAINT FK_CUSTOMER_BANK FOREIGN KEY(BANK_CODE) 
        REFERENCES BANK(BANK_CODE) 
            ON DELETE CASCADE; 
            -- ON DELETE SET NULL : NULL값 대입 (NULL이 들어갈 수 있어야 한다.)
            -- ON DELETE CASCADE  : 제거 (기록까지 전부 삭제)

/*
모델링 표현
            /                          /                                                 
    <---------  FK 필수O       <- - - - -  FK 필수X
            \                          \       
            
                                       /
                               <- - - O - FK : ON DELETE SET NULL
                                       \
                                       
                                       /
                               <- - - X - FK : ON DELETE CASCADE
                                       \
*/ 