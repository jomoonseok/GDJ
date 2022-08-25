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
    DML
    1. Data Manipulation Language
    2. 데이터 조작어
    3. 행(Row, Record, Tuple) 단위 삽입, 수정, 삭제
    4. 트랜잭션(작업) 완료를 위해 COMMIT이 필요
    5. 트랜잭션(작업) 취소를 위해 ROLLBACK 사용 가능
    6. 종류
        1) INSERT INTO VALUES
        2) UPDATE SET WHERE
        3) DELETE FROM WHERE
*/

/*
    행 삽입
    1. 지정한 칼럼에 삽입
       INSERT INTO 테이블(칼럼1, 칼럼2) VALUES(값1, 값2)
    2. 모든 칼럼에 데이터 삽입
       INSERT INTO 테이블 VALUES(값1, 값2)
*/

-- 부서 테이블에 행(Row) 삽입
-- 부모 테이블(관계에서 PK를 가진 테이블)에 먼저 삽입을 해야 함
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (1, '영업부', '대구');
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (2, '인사부', '서울');
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (3, '총무부', '대구');
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (4, '기획부', '서울');
-- ROLLBACK(취소)하면 전부 다 취소된다.

-- 작업의 완료
COMMIT;

--INSERT INTO DEPARTMENT(DEPT_NO, DEPT_NAME) VALUES(5, '개발부'); -- LOCATION 칼럼은 NOT NULL인데 NULL값 넣어서 오류발생 한다.
--INSERT INTO DEPARTMENT(DEPT_NO, DEPT_NAME, LOCATION) VALUES(5, '개발부', '부에노스아이리스'); -- 설정한 것보다 크기가 넘어가서 오류발생 한다.
--INSERT INTO DEPARTMENT(DEPT_NO, DEPT_NAME, LOCATION) VALUES(4, '개발부', '인천'); -- UNIQUE 제약조건에 걸린다.
-- 오류체크 하는 게 중요하다. 오류발생 했을 때 이유를 찾아서 해결할 줄 알아야 한다.

-- 사원 테이블에 행(Row) 삽입
-- 자식 테이블(관계에서 FK를 가진 테이블)은 참조 무결성에 위배되지 않는 데이터만 삽입 가능
-- 부서(부서번호) - 사원(소속부서)
-- PK             - FK
-- 1,2,3,4        - 1,2,3,4중 하나만 가능
INSERT INTO 
    EMPLOYEE -- 칼럼을 입력하지 않으면 전부 입력
VALUES
    (1001, '구창민', 1, '과장', 'M', '95-05-01', 5000000); -- 날짜 표기법 작은 따옴표안에 표기 /나 -으로 구분

INSERT INTO
    EMPLOYEE
VALUES
    (1002, '김민서', 1, '사원', 'F', '17/09/01', 2000000);
    
INSERT INTO
    EMPLOYEE
VALUES
    (1003, '이은영', 2, '부장', NULL, '90-09-01', 5500000); -- NULL값이 필요할 때 비워두면 안 되고 NULL이라고 명시해준다.

INSERT INTO
    EMPLOYEE
VALUES
    (1004, '한성일', 2, '과장', 'M', '93-04-01', 5000000);

COMMIT;
/*
INSERT INTO EMPLOYEE
    (EMP_NO, NAME, DEPART)
VALUES
    (1005, '아무개', 5);
-- parent key not found 
*/

-- 외부데이터 IMPORT
-- 엑셀 데이터(시트마다 테이블 1개)
-- 테이블 선택 후 우클릭 - [데이터 임포트]


-- 부서 테이블 수정
-- 부서번호가 1인 부서의 지역을 '인천'으로 수정
UPDATE DEPARTMENT
   SET LOCATION = '인천'
 WHERE DEPT_NO = 1;

-- 부서번호가 3인 부서명을 '전략부', 지역을 '부산'으로 수정
UPDATE DEPARTMENT
   SET DEPT_NAME = '전략부'
     , LOCATION = '부산'
 WHERE DEPT_NO = 3; -- WHERE절에 1 = 1 이런 코드가 있는 이유는 IF문과 같은 걸 사용할 때 WHERE절이 사용되게 하려고
 
 -- 부서번호가 3인 부서의 부서번호를 6으로 수정
 /*
    부서 - 사원
    1    - 1
    2    - 1
    3    - 2
    4    - 2
    5    - 3
    부서에서는 문제가 발생하지 않지만 
    사원에서 문제가 발생한다.
    사원이 부서 번호를 참조하고 있는데 
    부서번호를 바꾸면 참조무결성 위배규칙에 걸린다.
    결론은 안 된다.
 */
 -- DEPARTMENT의 부서번호를 EMPLOYEE가 참조중이므로 수정이 안 됨
 -- 해결책 
 -- 1. 외래키 일시중지
 -- 2. 수정
 -- 3. 외래키 재시작
 
ALTER TABLE EMPLOYEE
    DISABLE CONSTRAINT FK_EMPLOYEE_DEPARTMENT; -- 외래키 중지

UPDATE EMPLOYEE
   SET DEPART = 6
 WHERE DEPART = 5;
-- ├ 하나의 트랜잭션 
UPDATE DEPARTMENT
   SET DEPT_NO = 6
 WHERE DEPT_NO = 3;
 
ALTER TABLE EMPLOYEE
    ENABLE CONSTRAINT FK_EMPLOYEE_DEPARTMENT; -- 외래키 시작
    
-- 4. 부서번호 1인 사원들의 월급을 100000 인상
UPDATE EMPLOYEE
   SET SALARY = SALARY + 100000
 WHERE DEPART = 1;
-- 5. 직급이 '과장'인 사원들의 월급을 10% 인상
UPDATE EMPLOYEE
   SET SALARY = SALARY * 1.1
 WHERE POSITION = '과장';
 
-- 테이블 삭제

-- 1. 부서번호가 4인 부서를 삭제
-- 부서번호가 4인 행(Row)을 참조하는 사원이 없으므로 정상 삭제
DELETE
  FROM DEPARTMENT
 WHERE DEPT_NO = 4;

-- 2. 부서번호가 1인 부서를 삭제
-- 외래키 옵션으로 ON DELETE SET NULL 처리를 했기 때문에
-- 부서번호가 1인 행(Row)의 소속부서가 NULL 값으로 함께 변경
DELETE
  FROM DEPARTMENT
 WHERE DEPT_NO = 1; -- ON DELETE SET NULL 적용









