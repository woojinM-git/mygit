-- 1. 암시적 형변환
--  1) 날짜 자료형의 값들은 자동으로 문자열로 변환됨
-- 	2) '1200'와 같은 숫자가 문자열로 된 자원들은 숫자로 자동 변환됨
-- 	3) 1200과 같은 숫자가 문자열로 자동 변환됨

-- 2. 명시적 형변환
--  1) SQL 문장 내에서 변환함수를 사용하여 특정 자원을 원하는 자료형으로 변환하는 것!
-- 		예를 들면 date_format함수를 이용하여 날짜 자원을 만드는 행위!
SELECT CAST('100' AS UNSIGNED) as num; -- UNSIGNED : 정수로 바꿈

-- 3. 데이터 그룹화
-- 	지금까지는 각 테이블 자체가 하나의 그룹이었고, 이제는 각 테이블에서
-- 	소그룹을 만들어 겨로가를 소그룹별로 얻고자 할 때
-- 	그룹생성법을 알아야 가능하다.
-- 	예) emp 테이블에서 각 부서별 인원수를 출력하자!
SELECT deptno, COUNT(*)
FROM emp
GROUP BY deptno
ORDER BY deptno;

SELECT * FROM emp;

-- 예) emp테이블에서 각 부서별 인원수, 그리고 급여의 평균과 총액을 구하자!
-- COUNT(), AVG(), SUM() = GROUP BY 를 짓고 사용해야한다.
SELECT deptno, COUNT(*), AVG(sal), SUM(sal)
FROM emp
GROUP BY deptno;

-- 문제) emp 테이블에서 직종별(job) 급여의 합과 평균을 구하시오!
SELECT job, FLOOR(AVG(sal)) AS 평균, SUM(sal) AS 합
FROM emp
GROUP BY job;

-- 문제) emp 테이블에서 각 부서별 보너스(comm)의 합, 평균 그리고
-- 		인원수를 순서대로 출력하시오!
-- 			comm 이라는 컬럼에 null을 가진 자원은 0으로 대채하는 문장
-- 		IFNULL(comm, 0)

SELECT * from emp;
SELECT deptno, COUNT(*), SUM(IFNULL(comm, 0)) AS 합, AVG(IFNULL(comm, 0)) AS 평균
FROM emp
GROUP BY deptno;

-- NULL 값을 다른 값으로 대체할 때는 IFNULL 함수 사용!!
-- 오라클에서는 NVL함수를 사용
-- 만약 특정 부서의 인원들 중에서 3명이 보너스를 받지 못하여 보너스 컬럼에 
-- NULL이 있었다면 평균을 구할 때는 그 3명은 평균을 구하는 연산에서 제외된다.
-- 그렇지 않고 전체인원으로 평균을 구해야 한다면 IFNULL함수로
-- NULL값을 0으로 대체하여 연산에 참여할 수 있도록 해야 한다

-- 예) emp테이블에서 연봉을 계산하는 SELECT 문장을 기술해 보자 (급여*보너스)
SELECT *, sal * comm FROM emp;
SELECT *, sal * IFNULL(comm, 1) FROM emp;

-- 예) 분석가들의 급여 평균을 구하자!
SELECT job, AVG(sal)
FROM emp
WHERE job = 'ANALYST';

SELECT job, AVG(sal)
FROM emp
WHERE job = 'ANALYST'
GROUP BY job;

-- SQL 문의 실행순서
-- FROM과 JOIN --> WHERE --> GROUP BY --> HAVING --> SELECT --> ORDER BY

-- 문제) emp 테이블에서 직종이 'CLERK' 또는 'SALESMAN'인 사원들 중
-- 최대급여를 구하는 SELECT 문은?
SELECT MAX(sal)
FROM emp
WHERE job in('CLERK', 'SALESMAN');

-- 위는 직종이 'CLERK'과 'SALESMAN'들을 합하여 최대값을 구한다.
-- 따로 구하고 싶다면 그룹화 해야 함

SELECT job, MAX(sal)
FROM emp
WHERE job in('CLERK', 'SALESMAN')
GROUP BY job;

-- 예) emp 테이블에서 각 부서별 인원수, 급여의 합을 구하는 SELECT문을 구하자
SELECT deptno, count(*), sum(sal) 
from emp
GROUP BY deptno;

-- 위의 결과에서 인원수가 7명 이상인 부서만 확인하고 싶다면

-- 조건식에 그룹함수(MAX, MIN, SUM, AVG, COUNT, . . .)가 포함된다면
-- WHERE 절에서 기술하지 못하고, HAVING 절에서 기술해야 한다!!
SELECT deptno, count(*), sum(sal) 
from emp
GROUP BY deptno
HAVING count(*) >= 7;

-- 4. SUBQUERY
-- 		서브쿼리는 특정 SQL문장 안에 또 다른 SQL 문장이 포함된 것

-- 		[장점]
-- 		DB에 여러 번 접속해야 하는 상황을 한번에 처리가 가능하게 해 준다.
-- 		한마디로 DB 접속 되는 회수를 줄이고, 속도를 증가시킨다.

-- 서브쿼리를 사용할 수 있는 곳
-- 	- WHERE, HAVING
-- 	- INSERT 구문에 INTO
-- 	- UPDATE 구문에 SET 
-- 	- SELECT 또는 DELETE 구문의 FROM 

-- 예) emp테이블에서 사원 이름이 'SMITH'이고, 직종이 'CLERK'인
-- 		사원의 급여보다 더 많이 받는 사원들의 정보를 사번, 이름, 직종, 급여 순으로 출력하자!
-- 	[풀이]
-- 1. 먼저 이름이 'SMITH'이고, 직종이 'CLERK'인 사원의 급여를 알아내야 한다.
SELECT sal from emp
where ename = 'SMITH' AND job = 'CLERK';

-- 2) 1.에서 알아낸 결과 800이라는 급여보다 더 많이 받는 사원들의 정보를 출력
SELECT empno, ename, job, sal
FROM emp
where sal > 800;

-- 위는 2번에 걸쳐 실행하는 상황이다. 이것을 서브쿼리로 바꿔보자
SELECT empno, ename, job, sal
FROM emp
where sal > (
SELECT sal from emp
where ename = 'SMITH' AND job = 'CLERK'
);

-- 문제) emp테이블에서 사번이 7521번인 사원의 직종과 같고, 7844번 사원의
-- 		급여보다 많이 받는 사원들의 정보를 사번, 이름, 직종, 급여, 입사일 순으로 출력

SELECT job from emp
WHERE empno = 7521; -- SALESMAN

SELECT sal FROM emp
where empno = 7844; -- 1500.00

SELECT empno, ename, job, sal, hiredate
FROM emp
where sal >= 1500
AND
	job = 'SALESMAN';
    
-- 위의 SQL 문장들을 조합하면 . . .
SELECT empno, ename, job, sal, hiredate
FROM emp
WHERE sal >= (SELECT sal FROM emp
where empno = 7844)
AND
	job = (SELECT job from emp
			WHERE empno = 7521);
            
-- 문제) emp 테이블에서 급여가 3000이상인 사원들 중
-- 입사일이 1982년 이전에 입사한 사원들의 정보를
-- 사번, 이름, 급여, 입사일 순으로 출력하자!

SELECT empno, ename, sal, hiredate
FROM emp
WHERE hiredate < '1982-01-01'
AND sal >= 3000;

-- 위는 emp테이블 전체를 대상으로 검색을 수행한다.
-- 하지만 다음은 내용이 그렇지 않다.
SELECT a.empno, a.ename, a.sal, a.hiredate
FROM (SELECT * from emp where sal >= 3000) a
WHERE a.hiredate < '1982-01-01';

SELECT empno, ename, sal, hiredate
FROM (SELECT * from emp where sal >= 3000) a
WHERE a.hiredate < '1982-01-01';

-- 예) 급여가 3000이상인 사원들의 부서코드와 부서명을 출력하자!
-- 1) 먼저 급여가 3000이상인 사원들의 부서코드를 알아내야 한다.
SELECT deptno FROM emp
WHERE sal >= 3000;

-- 2) 위를 수행하면 결과가 20번 부서는 2개가 나옴. 그래서 중복된 값을 제거해야 함
SELECT distinct deptno FROM emp
WHERE sal >= 3000;

-- 3) 앞서 구한 10, 20 번을 가지고 있는 dept 테이블에서 조건으로 사용하여
-- 		부서코드와 부서명을 출력하면 된다.
SELECT deptno, dname
FROM dept
WHERE deptno IN(10, 20);

-- 4) 위의 문장들을 하나로 합쳐서 결과를 확인하자!
SELECT deptno, dname
FROM dept
WHERE deptno IN(SELECT distinct deptno FROM emp
WHERE sal >= 3000);

-- 5. 조인(JOIN)
-- 	데이터베이스의 테이블들 간 결합을 의미한다.
-- 	여러 개의 테이블에 자원들이 흩어져 있는 상태에서 데이터를
-- 	마치 하나의 테이블에서 보는 것 처럼 결과를 내고 싶을 때 JOIN 사용

-- 예) 원하는 결과가 다음과 같다면 . . .
-- 사번, 이름, 직종, 입사일, 부서코드, 부서명
-- |--------emp------|----dept----|
-- 이렇게 하나의 테이블에 있는 것 처럼 결과를 얻기 위해
-- 여러 개의 테이블 간 기본키와 외래키의 연결을 이용하여 JOIN 사용

-- 기본키 : 중복 불가, NULL 불가
-- 외래키 : 중복 허용, NULL 불가
SELECT * from emp;
SELECT e.empno, e.ename, e.job, e.hiredate, d.deptno, d.dname
FROM emp e INNER JOIN dept d
ON e.deptno = d.deptno;

-- 조인의 종류
-- 1) INNER JOIN : 교집합
SELECT * FROM emp INNER JOIN dept
ON emp.deptno = dept.deptno;

-- 각 부서별 도시명을 출력하자!
-- 	부서코드, 부서명, 도시코드, 도시명 순으로 출력하자
--  |---dept---|--locations--|
SELECT d.deptno, d.dname, l.loc_code, l.city
FROM dept d INNER JOIN locations l
ON d.loc_code = l.loc_code;

-- 문제) 각 테이블 간 연결하여 각 사원들이 누가 어떤 도시에 있는 부서에서
-- 		근무하는지 출력하자!
-- 		사번, 이름, 직종, 입사일, 부서코드, 부서명, 도시명 순으로 출력하시오
SELECT e.empno, e.ename, e.job, e.hiredate, d.deptno, d.dname, l.city
FROM emp e INNER JOIN dept d INNER JOIN locations l
ON e.deptno = d.deptno AND d.loc_code = l.loc_code;

-- 위는 조인된 테이블들끼리 참조되는 동일한 자원들만 보여준다.
-- 그래서 사번이 1000번인 이도라는 사원의 deptno값을 NULL로 처리하고
-- 다시 실행하면 결과로 포함되지 않는다.
-- 때에 따라 이도 같은 자원들도 결과로 포함시키고 싶을 때가 있다.
-- 이때 사용하는 것이 바로 Left JOIN / Right JOIN 즉 Outer Join이다.

-- LEFT JOIN
-- 왼쪽 테이블의 자원들을 연결성을 고려하지 않고 모두 출력하고,
-- 오른쪽 테이블의 자원들은 연결되어 일치하는 자원들만 출력된다.

SELECT e.empno, e.ename, e.job, e.hiredate, d.deptno, d.dname 
FROM emp e LEFT JOIN dept d
ON e.deptno = d.deptno;

-- 현재 사원들과 부서간의 연결에서 부서는 존재하지만 근무하는
-- 구성원이 없는 부서가 무엇인지? 알아내자!
SELECT e.*, d.dname
FROM emp e RIGHT JOIN dept d
ON e.deptno = d.deptno;

-- 문제) emp 테이블에서 직종이 'ANALYST'인 사원들의 정보를
-- 사번, 이름, 직종, 급여, 부서명, 도시코드 순으로 출력하시오!
SELECT e.empno, e.ename, e.job, e.sal, d.dname, d.loc_code
FROM emp e LEFT OUTER JOIN dept d
ON e.deptno = d.deptno
WHERE e.job = 'ANALYST';

-- 위의 내용을 서브쿼리로 한다면?

SELECT e.empno, e.ename, e.job, e.sal, d.dname, d.loc_code
FROM (SELECT * from emp WHERE job = 'ANALYST') e LEFT OUTER JOIN dept d
ON e.deptno = d.deptno;

-- 위의 내용에서 도시명을 하나 더 추가해서 출력하려 한다면 ...
SELECT e.empno, e.ename, e.job, e.sal, d.dname, d.loc_code, l.city
FROM (SELECT * from emp WHERE job = 'ANALYST') e LEFT OUTER JOIN dept d 
ON e.deptno = d.deptno
LEFT OUTER JOIN locations l
ON d.loc_code = l.loc_code;

-- 문제) 'DALLAS'에서 근무하는 사원들의 정보를 
-- 		사번, 이름, 직종, 입사일, 부서코드, 도시명 순으로 출력하시오
SELECT e.empno, e.ename, e.job, e.hiredate, d.deptno, l.city
FROM emp e INNER JOIN dept d INNER JOIN (SELECT * FROM locations WHERE city = 'DALLAS') l
ON e.deptno = d.deptno AND d.loc_code = l.loc_code;

-- 문제) 각 사원들의 관리자(mgr)가 누구인지를 알아내어 사번 이름 관리자사번 관리자명 순으로 출력하시오
SELECT e.empno, e.ename, e.mgr as ManagerNumber, m.ename as Manager
FROM emp e INNER JOIN emp m
ON e.mgr = m.empno;