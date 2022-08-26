--DROP TABLE
DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;

--CREATE TABLE
CREATE TABLE DEPARTMENT(
    DEPT_NO NUMBER,
    DEPT_NAME VARCHAR2(15 BYTE) NOT NULL,
    LOCATION VARCHAR2(15 BYTE) NOT NULL
);

CREATE TABLE EMPLOYEE(
    EMP_NO NUMBER,
    NAME VARCHAR2(20 BYTE) NOT NULL,
    DEPART NUMBER,
    POSITION VARCHAR2(20 BYTE),
    GENDER CHAR(2),
    HIRE_DATE DATE,
    SALARY NUMBER
);

--ALTER TABLE
--PK
ALTER TABLE DEPARTMENT
    ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY(DEPT_NO);
ALTER TABLE EMPLOYEE
    ADD CONSTRAINT PK_EMPLOYEE PRIMARY KEY(EMP_NO);
    
--FK
ALTER TABLE EMPLOYEE
    ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT FOREIGN KEY(DEPART) 
        REFERENCES DEPARTMENT(DEPT_NO)
            ON DELETE SET NULL;
            
-------------------------------------------------------------------------

/*
    시퀀스
    
    1. SEQUENCE
    2. 일련번호를 생성하는 데이터베이스 객체
    3. 자동으로 증가하는 번호를 생성
    4. 기본키(PK)에서 주로 사용(인공키) CREATE/DROP으로 생성 삭제
    5. NEXTVAL를 이용하면 새로운 번호가 생성
    6. CURRVAL를 이용하면 현재 번호를 확인(번호표가 몇번까지 나갔는지 확인하는 용도)
*/

/*
    시퀀스 생성 형식
    
    CREATE SEQUENCE 시퀀스_이름
        START WITH 시작값 -- 생략하면 시작값은 1이다. / 생성 이후 수정 불가 지우고 다시 만들어야 한다.
        INCREMENT BY 증가값 -- 생락하면 1씩 증가한다.
        MINVALUE 최소값 -- 감소할 때 사용
        MAXVALUE 최대값
        CACHE사용유무 -- NOCACHE 권장
        CYCLE사용유무 -- 생략하면 NO CYCLE / PK에서 사용한다면 NOCYCLE
*/

-- 부서 테이블에서 사용할 부서_시퀀스
DROP SEQUENCE DEPARTMENT_SEQ; -- 테이블과 같은 이유로 DROP 먼저 만들어준다.
CREATE SEQUENCE DEPARTMENT_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 100 -- NOMAXVALUE
    NOCACHE  
    NOCYCLE;

-- 부서 테이블에 행(Row) 삽입
-- 부모 테이블(관계에서 PK를 가진 테이블)에 먼저 삽입을 해야 함
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '영업부', '대구');
    
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '인사부', '서울');
    
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '총무부', '대구');
    
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (DEPARTMENT_SEQ.NEXTVAL, '기획부', '서울');
    
-- ROLLBACK(취소)하면 전부 다 취소된다.


-- 작업의 완료
COMMIT;


-- 사원테이블에서 사용할 사원_시퀀스
DROP SEQUENCE EMPLOYEE_CEQ;
CREATE SEQUENCE EMPLOYEE_CEQ
    START WITH 1001
    NOCACHE;
    
-- 사원 테이블에 행(Row) 삽입
-- 자식 테이블(관계에서 FK를 가진 테이블)은 참조 무결성에 위배되지 않는 데이터만 삽입 가능
-- 부서(부서번호) - 사원(소속부서)
-- PK             - FK
-- 1,2,3,4        - 1,2,3,4중 하나만 가능
INSERT INTO 
    EMPLOYEE -- 칼럼을 입력하지 않으면 전부 입력
VALUES
    (EMPLOYEE_CEQ.NEXTVAL, '구창민', 1, '과장', 'M', '95-05-01', 5000000); -- 날짜 표기법 작은 따옴표안에 표기 /나 -으로 구분

INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_CEQ.NEXTVAL, '김민서', 1, '사원', 'F', '17/09/01', 2000000);
    
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_CEQ.NEXTVAL, '이은영', 2, '부장', NULL, '90-09-01', 5500000); -- NULL값이 필요할 때 비워두면 안 되고 NULL이라고 명시해준다.

INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_CEQ.NEXTVAL, '한성일', 2, '과장', 'M', '93-04-01', 5000000);

-- 오류가 발생하는 INSERT
-- INSERT는 실패하였으나 시퀀스의 번호는 사용했음
/*
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_CEQ.NEXTVAL, '신현준', 5, '대리', 'M', '98-12-01', 3500000); -- 1005번을 뽑기만 하고 사용하지 못했다.
*/
-- 정상 데이터 다시 INSERT 
INSERT INTO
    EMPLOYEE
VALUES
    (EMPLOYEE_CEQ.NEXTVAL, '신현준', 3, '대리', 'M', '98-12-01', 3500000);
    
COMMIT;

------------------------------------------------------------------------------------

-- CURRVAL 사용
DROP TABLE SAMPLE;
CREATE TABLE SAMPLE(
    NO1 NUMBER,
    NO2 NUMBER
);

DROP SEQUENCE SAMPLE_SEQ;
CREATE SEQUENCE SAMPLE_SEQ NOCACHE;

-- 최초 1번은 NEXTVAL를 사용해야 CURRVAL도 사용 가능함
INSERT INTO SAMPLE(NO1) VALUES(SAMPLE_SEQ.CURRVAL);

-- NEWXTVAL, CURRVAL 함께 사용
INSERT INTO SAMPLE(NO1, NO2) VALUES(SAMPLE_SEQ.NEXTVAL, SAMPLE_SEQ.CURRVAL);

COMMIT;




















