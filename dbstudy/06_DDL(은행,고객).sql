-- 테이블 삭제
DROP TABLE CUSTOMER;
DROP TABLE BANK;
-- BANK 테이블 생성
CREATE TABLE BANK(
    BANK_CODE VARCHAR2(20 BYTE) NOT NULL,
    BANK_NAME VARCHAR2(30 BYTE) NOT NULL
);
-- CUSTOMER 테이블 생성
CREATE TABLE CUSTOMER( -- 제약조건 NULL은 생략가능 
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

--8/25-----------------------------------------------------------------------------------------------------------

/*
    FK 옵션
    1. ON DELETE SET NULL
        1) 참조하던 PK의 값이 삭제되면 FK의 값을 NULL로 수정
        2) FK 필수 설정(NOT NULL)이면 사용할 수 없는 옵션
    2. ON DELETE CASCADE
        1) 참조하던 PK의 값이 삭제되면 FK의 값을 함께 삭제
        2) 회원 탈퇴 시 작성한 게시글 모두 삭제, 게시글 삭제 시 달린 댓글 모두 삭제와 같은 경우
*/


-- 테이블 변경하기(ALTER TABLE)
-- 1. 칼럼 추가 : ALTER TABLE 테이블 ADD 칼럼명 데이터타입 [제약조건]
-- 2. 칼럼 수정 : ALTER TABLE 테이블 MODIFY 칼럼명 데이터타입 [제약조건] (ADD만 MODIFY로 바꾼 형태)
-- 3. 칼럼 삭제 : ALTER TABLE 테이블 DROP COLUMN 칼럼명
-- 4. 칼럼 이름 : ALTER TABLE 테이블 RENAME COLUMN OLD이름 TO NEW이름
-- 5. 테이블 이름 : ALTER TABLE 테이블 RENAME TO NEW이름

-- 1. BANK 테이블에 BANK_PHONE 칼럼을 추가하시오.
ALTER TABLE BANK
    ADD BANK_PHONE VARCHAR2(20 BYTE) NULL;


-- 2. CUSTOMER 테이블에 GRADE 칼럼을 추가하시오. ('VIP', 'GOLD', 'SILVER' 중 하나의 값만 가진다.) CHECK 제약 조건
ALTER TABLE CUSTOMER
    ADD GRADE VARCHAR2(6 BYTE) CHECK(GRADE IN('VIP', 'GOLD', 'SILVER')); -- 텍스트는 작은 따옴표로 묶어서 적어준다.

-- 3. BANK 테이블의 BANK_NAME 칼럼을 VARCHAR2(15 BYTE)로 수정하시오.
ALTER TABLE BANK
    MODIFY BANK_NAME VARCHAR2(15 BYTE); -- 제약 조건은 적지 않아도 된다.


-- 4. BANK 테이블의 BANK_NAME 칼럼을 NULL로 수정하시오.
ALTER TABLE BANK
    MODIFY BANK_NAME VARCHAR2(15 BYTE) NULL; -- 타입은 줘야한다. 

-- 5. CUSTOMER 테이블의 AGE 칼럼을 삭제하시오.
ALTER TABLE CUSTOMER
    DROP COLUMN CUS_AGE; 

-- 6. CUSTOMER 테이블의 NO 칼럼과 NAME 칼럼이름을 CUST_NO와 CUST_NAME으로 수정하시오.
ALTER TABLE CUSTOMER
    RENAME COLUMN CUS_NO TO CUST_NO;
ALTER TABLE CUSTOMER
    RENAME COLUMN CUS_NAME TO CUST_NAME;    

-- 7. BANK 테이블의 이름을 BANK_TBL로 수정하시오.
ALTER TABLE BANK
    RENAME TO BANK_TBL;