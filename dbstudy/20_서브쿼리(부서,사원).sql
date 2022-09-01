-- 테이블 삭제
DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;

-- DEPARTMENT 테이블 생성
CREATE TABLE DEPARTMENT(
    DEPT_NO   NUMBER            NOT NULL,
    DEPT_NAME VARCHAR2(15 BYTE) NOT NULL,
    LOCATION  VARCHAR2(15 BYTE) NOT NULL
);

-- EMPLOYEE 테이블 생성
CREATE TABLE EMPLOYEE(
    EMP_NO    NUMBER            NOT NULL,
    NAME      VARCHAR2(20 BYTE) NOT NULL,
    DEPART    NUMBER            NULL,
    POSITION  VARCHAR2(20 BYTE) NULL,
    GENDER    CHAR(2)           NULL,
    HIRE_DATE DATE              NULL, 
    SALARY    NUMBER            NULL
);

-- 기본키
ALTER TABLE DEPARTMENT 
    ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY(DEPT_NO);
ALTER TABLE EMPLOYEE 
    ADD CONSTRAINT PK_EMPLOYEE PRIMARY KEY(EMP_NO);

-- 외래키
ALTER TABLE EMPLOYEE 
    ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT FOREIGN KEY(DEPART) 
        REFERENCES DEPARTMENT(DEPT_NO)
            ON DELETE SET NULL;

-- 부서 테이블에서 사용할 부서_시퀀스
DROP SEQUENCE DEPARTMENT_SEQ;
CREATE SEQUENCE DEPARTMENT_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 100
    NOCACHE
    NOCYCLE;

-- 부서 테이블에 행(Row) 삽입
INSERT INTO DEPARTMENT (DEPT_NO, DEPT_NAME, LOCATION) VALUES (DEPARTMENT_SEQ.NEXTVAL, '영업부', '대구');
INSERT INTO DEPARTMENT (DEPT_NO, DEPT_NAME, LOCATION) VALUES (DEPARTMENT_SEQ.NEXTVAL, '인사부', '서울');
INSERT INTO DEPARTMENT (DEPT_NO, DEPT_NAME, LOCATION) VALUES (DEPARTMENT_SEQ.NEXTVAL, '총무부', '대구');
INSERT INTO DEPARTMENT (DEPT_NO, DEPT_NAME, LOCATION) VALUES (DEPARTMENT_SEQ.NEXTVAL, '기획부', '서울');

-- 작업의 완료
COMMIT;


-- 사원 테이블에서 사용할 사원_시퀀스
DROP SEQUENCE EMPLOYEE_SEQ;
CREATE SEQUENCE EMPLOYEE_SEQ
    START WITH 1001
    NOCACHE;

-- 사원 테이블에 행(Row) 삽입
INSERT INTO EMPLOYEE VALUES (EMPLOYEE_SEQ.NEXTVAL, '구창민', 1, '과장', 'M', '95/05/01', 5000000); 
INSERT INTO EMPLOYEE VALUES (EMPLOYEE_SEQ.NEXTVAL, '김민서', 1, '사원', 'F', '17/09/01', 2000000);
INSERT INTO EMPLOYEE VALUES (EMPLOYEE_SEQ.NEXTVAL, '이은영', 2, '부장', NULL, '90-09-01', 5500000);
INSERT INTO EMPLOYEE VALUES (EMPLOYEE_SEQ.NEXTVAL, '한성일', 2, '과장', 'M', '93-04-01', 5000000);
COMMIT;


/***********************************************************************************************************************************/

/*
    서브쿼리
    
    1. SUB QUERY
    2. 메인 쿼리(MAIN QUERY)에 포함하는 하위 쿼리(SUB QUERY)
    3. 서브쿼리는 메인쿼리에 괄호()를 이용해서 포함시킴
    4. 항상 서버쿼리를 먼저 실행하고, 서브쿼리 실행 결과를 메인쿼리에서 사용한다.
    5. 사용되는 절에 따른 구분
        1) SELECT절 : 스칼라 서브쿼리 / 단일 행
        2) FROM절   : 인라인뷰 / 다중 행
        3) WHERE절  : 서브쿼리 / 단일 행, 다중 행
    6. 서브쿼리 결과에 따른 구분
        1) 단일 행 서브쿼리
            (1) 서브쿼리 결과가 1개
            (2) PK나 UNIQUE 칼럼의 동등 비교(=) 결과, 함수의 결과
            (3) 단일 행 연산자를 사용(=, !=, >, >=, <, <=) 
        2) 다중 행 서브쿼리
            (1) 서브쿼리 결과가 2개 이상
            (2) FROM절, WHERE절에서 사용
            (3) 다중 행 연산자를 사용(IN, ANY, ALL 등)
*/

/* WHERE절 */

-- 1. 사원번호가 1001인 사원과 같은 직급(POSITION)을 가진 사원 조회하기
SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE POSITION = (SELECT POSITION        -- 단일 행 서브쿼리이므로 연산자 =를 사용했다. / 하위쿼리는 메인쿼리와 동등비교(=)되므로 반드시 POSITION을 반환
                     FROM EMPLOYEE
                    WHERE EMP_NO = 1001);  -- EMP_NO는 PK이므로 단일 행 서브쿼리
                   

-- 2. 급여(SALARY)가 가장 높은 사원 조회하기
SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE SALARY = (SELECT MAX(SALARY)
                   FROM EMPLOYEE); -- 서브쿼리가 함수이므로 단일 행 서브쿼리


-- 3. 부서번호가 1인 부서와 같은 지역에 있는 부서 정보를 조회하기
SELECT DEPT_NO, DEPT_NAME, LOCATION
  FROM DEPARTMENT 
 WHERE LOCATION = (SELECT LOCATION
                     FROM DEPARTMENT
                    WHERE DEPT_NO = 1);
              
                  
-- 4. 평균급여 이상을 받는 사원 조회하기
SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE SALARY >= (SELECT AVG(SALARY)
                    FROM EMPLOYEE);
      
                    
-- 5. 평균근속기간 이상을 근무한 사원 조회하기
-- 근속기간 구하기
-- 1) 일수 계산 : SYSDATE - HIRE_DATE
-- 2) 개월 계산 : MONTHS_BETWEEN(SYSDATE, HIRE_DATE)
SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE (SYSDATE - HIRE_DATE) >= (SELECT AVG(SYSDATE - HIRE_DATE)
                                   FROM EMPLOYEE);


SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE) >= (SELECT AVG(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))
                                   FROM EMPLOYEE);
        
                                   
-- 6. 부서번호가 2인 부서에 근무하는 사원들의 직급과 일치하는 직급을 가진 사원 조회하기
SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE POSITION IN (SELECT POSITION    -- 다중 행 서브쿼리의 동등 비교는 IN 연산으로 수행해야 한다
                     FROM EMPLOYEE
                    WHERE DEPART = 2); -- DEPART가 PK나 UNIQUE가 아니기 때문에 다중 행 서브쿼리(IN을 가장 많이 사용한다.)
-- 다중 행 서브쿼리는 IN을 가장 많이 사용한다.


-- TIP: 단일 행/다중 행 상관 없이 동등 비교는 IN 연산으로 수행 가능


-- 7. 부서명이 '영업부'인 부서에 근무하는 사원 조회하기 / JOIN으로 문제를 해결 할 수 있다.
SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE DEPART IN (SELECT DEPT_NO
                    FROM DEPARTMENT
                   WHERE DEPT_NAME = '영업부'); -- DEPT_NAME이 PK/UNIQUE가 아니라서 다중 행 서브쿼리이다. / 나중에 영업부가 생길 수 있다.

-- JOIN
SELECT E.EMP_NO, E.NAME, E.DEPART, E.GENDER, E.POSITION, E.HIRE_DATE, E.SALARY
  FROM DEPARTMENT D INNER JOIN EMPLOYEE E
    ON D.DEPT_NO = E.DEPART
 WHERE D.DEPT_NAME = '영업부';


-- 8. 직급이 '과장'인 사원들이 근무하는 부서 조회하기 / JOIN으로 문제를 해결 할 수 있다.
SELECT DEPT_NO, DEPT_NAME, LOCATION
  FROM DEPARTMENT 
 WHERE DEPT_NO IN (SELECT DEPART
                     FROM EMPLOYEE
                    WHERE POSITION = '과장');

-- JOIN
SELECT DEPT_NO, DEPT_NAME, LOCATION
  FROM DEPARTMENT D INNER JOIN EMPLOYEE E
    ON D.DEPT_NO = E.DEPART
 WHERE E.POSITION = '과장';

/* ANY, ALL */
-- ANY와 ALL은 MIN과 MAX가 있어서 잘 사용하지 않는다.

-- 9. 부서번호가 1인 부서에 근무하는 사원들의 급여보다 더 많이 받는 금액을 받는 사원조회하기
-- 어떤 급여(200만원, 500만원)이든 하나의 급여보다 많이 받으면 조회하기

SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE SALARY > ANY(SELECT SALARY
                      FROM EMPLOYEE
                     WHERE DEPART = 1); -- DEPART가 PK/UNIQUE가 아니라서 다중 행 서브쿼리이다.

-- WHERE SALARY > ANY (2000000, 5000000)
-- SALARY가 200만원보다 크거나, 500만원보다 크면 됨(OR 개념)
-- 따라서 최소급여 2000000보다 크면 만족하는 상황임
SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE SALARY > (SELECT MIN(SALARY)
                   FROM EMPLOYEE
                  WHERE DEPART = 1);  -- 서브쿼리가 함수이므로 단일 행 서브쿼리


-- 10. 부서번호가 1인 부서에 근무하는 사원들의 급여보다 더 많이 받는 금액을 받는 사원조회하기
-- 모든 급여(200만원, 500만원)와 비교해서 많이 받으면 조회하기

SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE SALARY > ALL(SELECT SALARY
                      FROM EMPLOYEE
                     WHERE DEPART = 1); -- DEPART가 PK/UNIQUE가 아니라서 다중 행 서브쿼리이다.
                     
-- WHERE SALARY > ALL (2000000, 5000000)
-- SALARY가 200만원보다 크고 500만원보다 크면 됨(AND 개념)
-- 따라서 최대급여 5000000보다 크면 만족하는 상황임
SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE SALARY > (SELECT MAX(SALARY)
                   FROM EMPLOYEE
                  WHERE DEPART = 1);  -- 서브쿼리가 함수이므로 단일 행 서브쿼리


/*SELECT절의 서브쿼리*/


-- 1. 전체 사원의 인원수, 급여합계/평균/최대/최소 조회하기
SELECT
       (SELECT COUNT(*) FROM EMPLOYEE)
     , (SELECT SUM(SALARY) FROM EMPLOYEE)
     , (SELECT AVG(SALARY) FROM EMPLOYEE)
     , (SELECT MAX(SALARY) FROM EMPLOYEE)
     , (SELECT MIN(SALARY) FROM EMPLOYEE)
  FROM     
       DUAL;

-- 2. 부서번호가 1인 부서와 같은 지역에서 근무하는 사원 조회하기
--    사원번호(EMP_NO), 사원명(NAME), 부서번호(DEPART), 부서명(DEPT_NAME) 조회

-- 스칼라 서브쿼리 접근

-- 스칼라 서브쿼리는 일치하지 않는 정보를 NULL로 처리함
-- 따라서 스칼라 서브쿼리와 동일한 방식의 조인은 '외부조인'이다.

SELECT 
       E.EMP_NO
     , E.NAME
     , E.DEPART
     , (SELECT D.DEPT_NAME
          FROM DEPARTMENT D
         WHERE D.DEPT_NO = E.DEPART
           AND D.DEPT_NO = 1)
  FROM 
       EMPLOYEE E;


-- 조인 접근

SELECT E.EMP_NO, E.NAME, E.DEPART, D.DEPT_NAME
  FROM DEPARTMENT D RIGHT OUTER JOIN EMPLOYEE E
    ON D.DEPT_NO = E.DEPART
 WHERE D.LOCATION = (SELECT LOCATION
                       FROM DEPARTMENT
                      WHERE DEPT_NO = 1);


/* FROM절의 서버쿼리 */
/*
    인라인뷰(다중 행) / 뷰(복사본) = 테이블(원본)
    
    1. Inline-View
    2. FROM절에서 사용되는 서브쿼리를 의미함
    3. 인라인뷰는 테이블 형식임
    4. 인라인뷰에 별명을 주고 사용함
    5. 인라인뷰에서 조회한 칼럼만 메인쿼리에서 조회할 수 있다.
    6. SELECT문의 실행순서를 바꿀 때 사용한다.(목록보기를 구현하려면 필수)
*/

SELECT A.EMP_NO, A.NAME, A.POSITION -- 인라인뷰가 조회한 칼럼만 작성할 수 있다.
  FROM (SELECT EMP_NO, NAME, POSITION
          FROM EMPLOYEE
         WHERE DEPART = 1) A;       -- 인라인뷰의 별명은 A임


/* 09/01 */

/*
    가상 칼럼
    
    1. PSEUDO COLUMN
    2. 존재하지만 저장되어 있지 않은 칼럼
    3. 사용할 수 있으나 일부 제약이 있음
    4. 종류
        1) ROWID  : 행(ROW)의 ID, 어떤 행의 물리적 저장 위치
        2) ROWNUM : 행(ROW)의 NUMBER, 어떤 행의 번호 !중요
*/


-- ROWID
SELECT ROWID, EMP_NO, NAME
  FROM EMPLOYEE;

-- 현존하는 가장 빠른 조회 방식
-- ROWID를 직접 사용하는 것은 어렵기 때문에 대신 인덱스(INDEX)를 사용
SELECT EMP_NO, NAME
  FROM EMPLOYEE
 WHERE ROWID = 'AAAFBLAABAAALDBAAC'; 


-- ROWNUMBER
SELECT ROWNUM, EMP_NO, NAME
  FROM EMPLOYEE;

-- ROWNUM사용 방법
-- 1. ROWNUM은 1을 포함하는 범위는 조건으로 사용할 수 있음
-- 2. ROWNUM은 1을 포함하지 않는 범위는 조건으로 사용할 수 없음
SELECT EMP_NO, NAME
  FROM EMPLOYEE
 WHERE ROWNUM = 1; --조회 가능
 
SELECT EMP_NO, NAME
  FROM EMPLOYEE
 WHERE ROWNUM = 2; --조회 불가능
 

-- ROWNUM을 1 이외의 범위를 조건으로 사용하는 방법
-- ROWNUM에 별명을 지정하고 해당 별명을 사용하면 됨 / 별명을 주면 저장이 되고 그러면 제약없이 사용할 수 있다.
-- 3 : SELECT
-- 1 :   FROM (ROWNUM의 별명 지정하기)
-- 2 :  WHERE ROWNUM의 별명 사용하기
SELECT A.EMP_NO, A.NAME
  FROM (SELECT ROWNUM AS ROW_NUM, EMP_NO, NAME
          FROM EMPLOYEE) A
 WHERE A.ROW_NUM = 2;


-- 1. 연봉 기준으로 가장 높은 연봉을 받는 사원 조회하기

-- 1) WHERE절의 서브쿼리 이용
SELECT EMP_NO, NAME, SALARY
  FROM EMPLOYEE
 WHERE SALARY = (SELECT MAX(SALARY)
                   FROM EMPLOYEE);

-- 2) 정렬과 ROWNUM 이용
--      (1) 연봉의 내림차순 정렬을 수행(가장 높은 연봉이 1번째 행이 됨)
--      (2) 정렬 결과에서 ROWNUM = 1인 행을 조회
SELECT ROWNUM, A.EMP_NO, A.NAME, A.SALARY
  FROM (SELECT EMP_NO, NAME, SALARY -- 2 / 여기서 ROWNUM을 사용하면 번호를 붙이고 정렬하는 거라 사용 목적과 맞지 않다.
          FROM EMPLOYEE             -- 1
         ORDER BY SALARY DESC) A    -- 3
 WHERE ROWNUM = 1;


-- 2. 2번째로 높은 연봉을 받는 사원 조회하기

-- 1) ROWNUM 칼럼
-- 인라인뷰 A : 연봉으로 정렬한 테이블
-- 인라인뷰 B : 정렬이 끝난 테이블에 행 번호를 추가한 테이블 / 목록보기에서 사용할 쿼리
SELECT B.ROW_NUM, B.EMP_NO, B.NAME, B.SALARY
  FROM (SELECT ROWNUM AS ROW_NUM, A.EMP_NO, A.NAME, A.SALARY
          FROM (SELECT EMP_NO, NAME, SALARY
                  FROM EMPLOYEE
                 ORDER BY SALARY DESC) A) B
 WHERE B.ROW_NUM = 2;
 
 -- 목록보기 : 1. 내림차순 정렬 2. 행 번호 붙이기 3. ROWNUM의 범위를 지정해서 10개(1페이지)씩 가져오게 한다.


-- 2) ROW_NUMBER() 함수 / 1)이 함수를 사용하지 않는 오리지널 사용법 / 목록보기 만들 때 추천
--    정렬과 행 번호 추가를 동시에 진행하는 함수
SELECT A.EMP_NO, A.NAME, A.SALARY
  FROM (SELECT ROW_NUMBER() OVER(ORDER BY SALARY DESC) AS ROW_NUM, EMP_NO, NAME, SALARY
          FROM EMPLOYEE) A
 WHERE A.ROW_NUM BETWEEN 2 AND 2;

-- 1)이 2)로 줄어드는 과정을 공부해야 한다. 2)만 공부하면 다양하게 사용하지 못한다.

-- 3) RANK() 함수
--    정렬 후 순위 매기는 함수
--    목록 가져오기에서는 부적절(동점자 처리 때문에 가져오는 목록의 수가 매번 달라질 수 있음)
SELECT A.EMP_NO, A.NAME, A.SALARY
  FROM (SELECT RANK() OVER(ORDER BY SALARY DESC) AS 순위, EMP_NO, NAME, SALARY
          FROM EMPLOYEE) A
 WHERE A.순위 BETWEEN 2 AND 2;


-- 3. 3~4번째로 입사한 사원 조회하기
SELECT ROWNUM AS ROW_NUM, A.EMP_NO, A.NAME, A.HIRE_DATE
          FROM (SELECT EMP_NO, NAME, HIRE_DATE
                  FROM EMPLOYEE
                 ORDER BY HIRE_DATE) A;
                 
SELECT B.EMP_NO, B.NAME, B.HIRE_DATE
  FROM (SELECT ROWNUM AS ROW_NUM, A.EMP_NO, A.NAME, A.HIRE_DATE
          FROM (SELECT EMP_NO, NAME, HIRE_DATE
                  FROM EMPLOYEE
                 ORDER BY HIRE_DATE) A) B
 WHERE ROW_NUM BETWEEN 3 AND 4;

SELECT A.EMP_NO, A.NAME, A.HIRE_DATE
  FROM (SELECT ROW_NUMBER() OVER(ORDER BY HIRE_DATE) AS HD, EMP_NO, NAME, HIRE_DATE
          FROM EMPLOYEE) A
 WHERE HD BETWEEN 3 AND 4;


/* 기타 서브쿼리 : CREATE, UPDATE DELETE 등에서 활용 */

-- CREATE와 서브쿼리
-- 1. 서브쿼리 결과 집합을 테이블로 저장
-- 2. 테이블 복사할 때
-- 3. NOT NULL 제약조건 제외한 제약조건은 복사되지 않는다.
-- 4. 형식
--    CREATE TABLE 테이블_이름 AS (서브쿼리)


-- 1. EMPLOYEE 테이블 복사하기
CREATE TABLE EMPLOYEE2
    AS (SELECT EMP_NO, NAME, DEPART, GENDER, POSITION, HIRE_DATE, SALARY
          FROM EMPLOYEE);
-- 제약조건이 복사되지 않았는지 확인
DESC USER_CONSTRAINTS;
SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'EMPLOYEE2';

-- EMPLOYEE2 테이블에 PK 제약조건을 추가하고 싶다면
ALTER TABLE EMPLOYEE2
    ADD CONSTRAINT PK_EMPLOYEE2 PRIMARY KEY(EMP_NO);


-- 2. DEPARTMENT 테이블의 구조만 복사하기(모든 행을 제외하고 복사하기)
CREATE TABLE DEPARTMENT2 
    AS (SELECT DEPT_NO, DEPT_NAME, LOCATION
          FROM DEPARTMENT
         WHERE 1 = 2); -- 만족하지 않는 조건을 주면 구조만 복사할 수 있다.

-- 행 제외하고 복사되었는지 확인
SELECT DEPT_NO, DEPT_NAME, LOCATION FROM DEPARTMENT2;


-- INSERT와 서브쿼리
-- 1. VALUES절 대신 서브쿼리를 이용
-- 2. 서브쿼리 결과 집합이 INSERT됨
-- 3. 형식
--    INSERT INTO 테이블_이름(칼럼1, 칼럼2, ...) (서브쿼리)  


-- 3. DEPARTMENT 테이블의 모든 행(ROW)을 DEPARTMENT2 테이블에 삽입
INSERT INTO DEPARTMENT2(DEPT_NO, DEPT_NAME, LOCATION)
(SELECT DEPT_NO, DEPT_NAME, LOCATION
   FROM DEPARTMENT); 
COMMIT;


-- UPDATE와 서브쿼리
-- SET절 WHERE절에서 서브쿼리 활용

UPDATE EMPLOYEE2
   SET NAME = (SELECT NAME FROM EMPLOYEE WHERE EMP_NO = 1004)
     , GENDER = (SELECT GENDER FROM EMPLOYEE WHERE EMP_NO = 1004)
 WHERE EMP_NO = 1001;
 
UPDATE EMPLOYEE2 
   SET (NAME, GENDER) = (SELECT NAME, GENDER   -- WHERE절에서 사용할 때도 있다.
                           FROM EMPLOYEE
                          WHERE EMP_NO = 1003)
 WHERE EMP_NO = 1001;

COMMIT;
SELECT EMP_NO, NAME, GENDER FROM EMPLOYEE2;


-- DELETE와 서브쿼리
-- WHERE절에서 주로 사용

DELETE
  FROM EMPLOYEE2
 WHERE DEPART IN (SELECT DEPT_NO
                    FROM DEPARTMENT2
                   WHERE DEPT_NAME = '영업부');  
COMMIT;
SELECT E.EMP_NO, D.DEPT_NAME
  FROM DEPARTMENT2 D INNER JOIN EMPLOYEE2 E
    ON D.DEPT_NO = E.DEPART;





-- 1. 사원번호가 1001인 사원과 같은 직급(POSITION)을 가진 사원 조회하기
-- 2. 급여(SALARY)가 가장 높은 사원 조회하기
-- 3. 부서번호가 1인 부서와 같은 지역에 있는 부서 정보를 조회하기
-- 4. 평균급여 이상을 받는 사원 조회하기
-- 5. 평균근속기간 이상을 근무한 사원 조회하기
-- 6. 부서번호가 2인 부서에 근무하는 사원들의 직급과 일치하는 직급을 가진 사원 조회하기
-- 7. 부서명이 '영업부'인 부서에 근무하는 사원 조회하기 / JOIN으로 문제를 해결 할 수 있다.
-- 8. 직급이 '과장'인 사원들이 근무하는 부서 조회하기 / JOIN으로 문제를 해결 할 수 있다.
-- 9. 부서번호가 1인 부서에 근무하는 사원들의 급여보다 더 많이 받는 금액을 받는 사원조회하기
-- 모든 급여(200만원, 500만원)와 비교해서 많이 받으면 조회하기
-- 10. 부서번호가 1인 부서에 근무하는 사원들의 급여보다 더 많이 받는 금액을 받는 사원조회하기
-- 모든 급여(200만원, 500만원)와 비교해서 많이 받으면 조회하기