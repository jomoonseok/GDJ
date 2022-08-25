-- 주석
/* 주석 */

/*
    오라클 데이터 타입
    1. CHAR(size) : 고정 길이 문자 타입(1 ~ 2000바이트)
    2. VARCHAR2(size) : 가변 길이 문자 타입(1 ~ 4000바이트)
    3. NUMBER(p,s) : 정밀도(p), 스케일(s)로 표현되는 숫자 타입
        - 정밀도(p) : 정수 + 소수점 모두 포함하는 전체 유효 숫자(0은 제외) 
        - 스케일(s) : 소수점 자리 수
        예시) 
        NUMBER : 최대 38자리 숫자(22바이트)
        NUMBER(3) : 최대 정수 3자리 
        NUMBER(5,2) : 최대 전체 5자리, 소수점 2자리 실수(123.45)
        NUMBER(2,2) : 1 미만의 소수점 2자리 실수(0.12) / 백분열 타입에서 많이 사용
*/

/*
    테이블 생성
    1. 제약조건의 이름을 지정하지 않는 방법(SYS로 시작하는 임의의 제약조건이름이 지정)
    2. 제약조건의 이름을 지정하는 방법
*/

/*
    제약조건 생성
    1. 테이블 생성할 때 함께 지정
    2. 테이블 생성한 뒤 테이블 수정하면서 지정
*/

/*
    제약조건 - 데이터 사전
    1. DBA_CONSTRAINTS 테이블
    2. USER_CONSTRAINTS 테이블
    3. ALL_CONSTRAINTS 테이블
*/

-- USER_CONSTRAINTS 테이블의 구조 확인
DESCRIB SYS.USER_CONSTRAINTS -- 약간의 자동완성 기능이 있다. 자동완성에서 나오는 공백은 밑줄이다. / SYS는 생략가능
-- 블록잡아서 CTRL + ENTER : 선택한 부분 실행

-- USER_CONSTRAINTS 테이블의 CONSTRAINT_NAME 칼럼 확인
SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS;

-- 1. 제약조건이름 없이 테이블 만들기
DROP TABLE USER_TBL; -- 한 번 만들면 수정할 수 없어서 테이블을 지워주는 쿼리문을 같이 작성한다.
CREATE TABLE USER_TBL(
    USER_ID VARCHAR2(30 BYTE) NOT NULL PRIMARY KEY,
    USER_PW VARCHAR2(30 BYTE) NOT NULL, -- NULL 불가능하다.
    USER_NAME VARCHAR2(30 BYTE) NULL, -- NULL 가능하다.
    USER_AGE NUMBER(3) NULL CHECK(USER_AGE BETWEEN 0 AND 100),
    USER_ADDR VARCHAR2(30 BYTE) NULL,
    USER_TEL CHAR(13 BYTE) NULL UNIQUE,
    USER_GEN CHAR(1 BYTE) NULL
);
/*
    5개의 제약 조건 
    USER_ID의 NOT NULL, PRIMARY KEY
    USER_PW의 NOT NULL 
    USER_AGE의 CHECK(USER_AGE BETWEEN 0 AND 100)
    USER_TEL의 UNIQUE
*/

-- 제약조건의 임의의 이름을 주는 것보다 만들 때 이름을 주는 게 좋다. 나중에 이름을 알아야 하는 경우가 있다.

-- 2. 제약조건이름 없이 테이블 만들기
DROP TABLE USER_TBL;
CREATE TABLE USER_TBL(
    USER_ID VARCHAR2(30 BYTE) NOT NULL,
    USER_PW VARCHAR2(30 BYTE) NOT NULL,
    USER_NAME VARCHAR2(30 BYTE) NULL, 
    USER_AGE NUMBER(3) NULL,
    USER_ADDR VARCHAR2(30 BYTE) NULL,
    USER_TEL CHAR(13 BYTE) NULL,
    USER_GEN CHAR(1 BYTE) NULL,
    PRIMARY KEY(USER_ID), 
    CHECK(USER_AGE BETWEEN 0 AND 100),
    UNIQUE(USER_TEL)
);

-- 3. 제약조건이름 지정하며 테이블 만들기
DROP TABLE USER_TBL;
CREATE TABLE USER_TBL(
    USER_ID VARCHAR2(30 BYTE) NOT NULL CONSTRAINT PK_USER_TBL PRIMARY KEY, -- USER TABLE의 PRIMARY KEY 제약조건
    USER_PW VARCHAR2(30 BYTE) NOT NULL,
    USER_NAME VARCHAR2(30 BYTE) NULL, -- NULL 가능하다.
    USER_AGE NUMBER(3) NULL CONSTRAINT CK_USER_AGE CHECK(USER_AGE BETWEEN 0 AND 100), -- USER AGE 칼럼의 CHECK 제약조건
    USER_ADDR VARCHAR2(30 BYTE) NULL,
    USER_TEL CHAR(13 BYTE) NULL CONSTRAINT UQ_USER_TEL UNIQUE, -- USER TEL 칼럼의 UNIQUE 제약조건
    USER_GEN CHAR(1 BYTE) NULL
);

-- SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS; 실행해서 조회해보면 제약조건의 이름이 생겼다. 임의의 이름은 NOT NULL 제약조건이다.

-- 4. 제약조건이름 지정하며 테이블 만들기 / 이 방법 연습하기
DROP TABLE USER_TBL;
CREATE TABLE USER_TBL(
    USER_ID VARCHAR2(30 BYTE) NOT NULL,
    USER_PW VARCHAR2(30 BYTE) NOT NULL,
    USER_NAME VARCHAR2(30 BYTE) NULL, 
    USER_AGE NUMBER(3) NULL,
    USER_ADDR VARCHAR2(30 BYTE) NULL,
    USER_TEL CHAR(13 BYTE) NULL,
    USER_GEN CHAR(1 BYTE) NULL,
    CONSTRAINT PK_USER_TBL PRIMARY KEY(USER_ID), 
    CONSTRAINT CK_USER_AGE CHECK(USER_AGE BETWEEN 0 AND 100),
    CONSTRAINT UQ_USER_TEL UNIQUE(USER_TEL)
);