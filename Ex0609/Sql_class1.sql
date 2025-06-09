-- 1. SQL 기본 문법

-- SQL문 종류
-- 1) DDL (Data Definition Language) : 데이터 정의어
-- CREATE(생성), DROP(삭제), ALTER(추가) 등
-- 2) DML (Data Manipulation Language) : 데이터 조작어
-- SELECT, UPDATE, INSERT, DELETE 등
-- 3) DCL (Data Control Language) : 데이터 제어어
-- GRANT, REVOKE, COMMIT, ROLLBACK 등

-- 컬럼은 자원 한개를 저장하는 공간이다.
-- 컬럼들은 자료형이 있어야 한다.
-- 자료형들:
-- 		- 문자형 : CHAR(길이), VARCHAR(길이), TEXT
-- 		- 날짜형 : DATE, DATETIME, TIMESTAMP
-- 		- 정수형 : INT(길이), BIGINT(길이)
-- 		- 고정소수점 : DECIMAL, NUMBERIC

-- 조작어
-- 테이블에서 자원들을 추출하는 SQL문 작성
-- SELECT [컬럼명 또는 *] FROM [테이블명]

select * from emp;

-- 문제) emp 테이블에서 사번(empno), 이름(ename), 부서코드(deptno) 순으로 출력하는
-- SQL문장을 완성하시오!

select empno, ename, deptno from emp;

-- SELCT 문은 자원검색에 사용되는 문장이다.
-- 전체 데이터 확인하기 : SELECT * FROM emp;

-- 컬럼명을 기술하면서 확인하기 : SELECT [컬럼명], [컬럼명], [컬럼명] from emp;

-- 조건부여(WHERE절)
-- 	일반적으로 테이블에 있는 자원들을 조회할 때가 많다.
--  이때 사용자가 원하는 자원들을 간단한 연산자 등을 이용하여
-- 	WHERE절에 조건으로 기술하면 결과를 얻을 수 있다.
-- 예) 사원테이블에서 부서(deptno)가 10번인 사원들의 정보를
-- 	사번, 이름, 입사일, 부서코드 순으로 출력하자!

select * from emp;

SELECT empno, ename, hiredate, deptno
			from emp
            WHERE deptno = 10;
            
-- 뮨제) 사원 테이블에서 직종(job)이 "SALESMAN"인 사원들의 정보를
-- 		사번, 이름, 부서코드, 직종 순으로 출력하자!

select empno, ename, deptno, job
FROM emp
WHERE job = 'SALESMAN';

-- 문제) 사원 테이블에서 사번이 1500번 이상인 사원들의 정보를
-- 		사번, 이름, 급여, 입사일 순으로 출력하시오

select empno, ename, sal, hiredate
from emp
WHERE empno >= 1500;

-- 주의)
--  1. 비교연산자는 ==이 아니라 =로 같은 값을 비교한다
--  2. 문자열을 의미할 때는 쌍따옴표가 아니라 홑따옴표로 표기한다.

-- 문제) 사원 테이블에서 입사일이 1981년도에 입사한 사원들의 정보를 
-- 사번, 이름, 입사일, 부서코드 순으로 출력하시오

select * from emp;
SELECT empno, ename, hiredate, deptno
from emp
where hiredate >= '1981-01-01'
AND hiredate <= '1981-12-31';

-- 문제) 사원 테이블에서 10번 부서에 1981년도에 입사한 사원들의 정보를
-- 		사번, 이름, 입사일, 부서코드 순으로 출력하시오!

SELECT empno, ename, hiredate, deptno
from emp
where hiredate >= '1981-01-01'
AND hiredate <= '1981-12-31'
AND deptno = 10;

-- 정렬 (ORDER BY 절) ************************
-- 	특정 컬럼을 중심으로 오름차순 또는 내림차순으로 정렬을 시켜 
-- 	출력하고자 할 때 사용한다.
-- 	예) 입사일이 1981년에 입사한 사원들의 정보를 사번, 이름, 직종, 입사일 순으로
-- 		출력하고 가장 최근에 입사한 자원부터 출력하자!

SELECT empno, ename, hiredate, deptno
from emp
where hiredate >= '1981-01-01'
AND hiredate <= '1981-12-31'
order by hiredate; -- 자동 오름차순

-- 오름차순 : ASC, 내림차순 : DESC
-- order by hiredate; = 오름차순이 된다.

-- 2. SQL 연산자
-- 		1) BETWEEN 연산자
--		2) IN 연산자
--		3) LIKE 연산자

-- 1) BTWEEN 연산자
-- 		특정 값 A에서 값 B의 사이(범위)의 정보를 얻을 때 사용한다.

-- 예) 사원 테이블에서 입사일이 1981년에 입사한 사원들의정보를
--		사번, 이름, 직종, 입사일 순으로 출력하자!
        
-- BETWEEN
--	특정 값 A에서 특정 값 B의 사이(범위)를 얻을 때 사용한다.
-- 		ex) 사원 테이블에서 입사일이 1981년에 입사한 사원들의 정보를 사번, 이름, 직종, 입사일 순으로 출락하자

-- BETWEEN을 사용ㅎ하지 않은 경우:
SELECT empno, ename, job, hiredate
FROM emp
WHERE hiredate >= '1891-01-01'
AND hiredate <= '1981-12-31';

-- BETWEEN 을 사용한 경우
SELECT empno, ename, job, hiredate
FROM emp
WHERE hiredate BETWEEN '1891-01-01' AND '1981-12-31';

-- 문제) 사원테이블에서 사번이 1100~1500사이의 사월들 정보를 사번, 이름, 직종, 부서코드 순으로 출력하시오
SELECT empno, ename, job, deptno
FROM emp
WHERE empno BETWEEN 1100 AND 1500;

-- 2) IN 연산자
-- 특정 목록의 결과값에서 비교값이 속하는지? 를 가려내는 연산자다(OR)
-- [구성]
-- 		WHERE [컬럼명] IN[값1, 값2, 값3 . . . . 값n];

-- ex) 사원테이블에서 사번이 1000, 1102, 1200, 1120, 1166인 
--		사원들의 정보를 출력하시오!

SELECT empno, ename, job FROM emp
WHERE empno = 1000
or empno = 1102
or empno  = 1200
or empno = 1120 
or empno = 1166;

-- 위의 내용을 IN연산자를 사용하면 다음과 같다
SELECT empno, ename, job FROM emp
WHERE empno IN(1000, 1102, 1200, 1120, 1166);

-- 문제) 사원테이블에서 직종이 'SALESMAN' 또는 'DEVLOP' 직의 사원들을
-- 사번, 이름, 직종, 부서코드 순으로 출력하시오
select * from emp;
SELECT empno, ename, job, deptno FROM emp
where job IN('SALESMAN', 'DEVLOP');

-- 문제) 사원테이블에서 직종이 'SALESMAN'또는 'DEVLOP'직의 사원들 중에
-- 		급여를 1500이상 받는 사원의 사번, 이름, 직종, 급여, 부서코드 순으로 출력하시오!
SELECT empno, ename, job, sal, deptno FROM emp
where job IN('SALESMAN', 'DEVLOP') AND sal >= 1500;

-- LIKE 연산자
-- 지정한 문자형태와 일치한 자원들을 검색할 때 사용한다.
-- [형식]
-- 1) %: 모든 값
-- 2) _: 하나의 값

-- 예시1) 'M%':M으로 시작하는 모든 값( Michael, Mike, Mk14 . . .)
-- 예시2) '%n':n으로 끝나는 모든 값( Michael, Mike, Mk14 . . .)
-- 예시3) '%a%':a가 포함된 모든 값( 1apart100, apple, Na . . .)
-- 예시4) '_a':총 2자이면서 a로 끝나는 모든 값( na, Aa, 1a . . .)
-- 문제) 총 7자이면서 M으로 시작하는 값을 의미하는 문자 형식은 무엇인가?
--	'M_____';

-- 문제) 입사일이 1981년에 입사한 사원들의 정보를 사번, 이름, 직종, 입사일 순으로
-- 		출력하고 가장 최근에 입사한 자원부터 출력하자!(단, Like 연산자를 활용해야 함)

select empno, ename, job, hiredate FROM emp
WHERE hiredate LIKE '1981%';

-- 3.SQL 함수
-- 기본적으로 쿼리(질의)문을 더욱 강력하게 하고, 데이터 값을 조작하는데 있어
-- 도움이 되는 것이 바로 SQL 함수다.

-- SQL 함수의 특징과 장점
-- : 자원에 대한 연산을 수행할 수 있다.
-- : 개별적인 데이터 항목을 수행할 수 있다.
-- : 그룹화 작업에도 용이하다.

-- SQL 함수의 종류
-- 1) 문자함수 (변환, 조작)
-- 2) 숫자함수
-- 3) 날짜함수

-- 1) 문자함수
-- 	- 변환함수
-- 		LOWER(컬럼명 또는 값) : 알파벳 값을 소문자로 변환
-- 		UPPER(컬럼명 또는 값) : 알파벳 값을 대문자로 변환
-- 		INITCAP(컬럼명 또는 값): 알파벳 첫 문자만 대문자로 변환

-- 예) 사원테이블에서 직종이 'salesman'인 사원들의 정보를
--		사번, 이름, 직종 순으로 출력해보자

SELECT empno, ename, job FROM emp
WHERE LOWER(job) = 'salesman';

-- -조작함수
-- CONCAT : 두 문자열을 연결
-- SUBSTR : 특정 문자나 문자열을 추출(자바의 substring())
-- SUBSTRING:
-- LEFT : 왼쪽부터 지정한 길이만큼 추출
-- RIGHT : 오른쪽부터 지정한 길이만큼 추출
-- LENGTH : 문자열의 길이
-- INSTR : 명시된 문자열의 위치값 ( 자바의 indexOf())
-- LTRIM : 문자열의 왼쪽에 있는 공백 제거 : "    Test" --> "Test"
-- RTRIM : 문자열의 오른쪽에 있는 공백 제거 : "    Test    " --> "Test"
-- REVERSE : 문자열의 순서를 역순으로 만든다.

-- 예) 사원테이블에서 각 사원들의 직종의 3번째 문자값을 추출하여 출력해 보자!
--		출력할 컬럼명은 사번, 이름, 직종 순이다.

SELECT empno, ename, job, SUBSTR(job, 3, 1) AS Sub1, SUBSTRING(job, 3, 1), LENGTH(job)
FROM emp;

-- 문제) 사원테이블에서 각 사원들의 직종 값에 있는 'S'의 위치값을 알아내자!
SELECT empno, ename, job, INSTR(job, 'S')
FROM emp;

-- 2) 숫자함수
-- ROUND : 반올림
-- CEIL : 소수점 이하를 자르면서 올림( 2.423 --> 3 )
SELECT ceil(3.14), ceil(5.01), ceil(3.00), ceil(3.001);

-- FLOOR : 소수점 이하를 자르면서 버림
-- POW : 거듭제곱
-- MOD : 나머지 값
-- GREATEST : 최대값
-- LEAST : 최소값

SELECT ROUND(1200.34, 0), ROUND(1234.34, -2),  ROUND(1234.34, 1),
	MOD(20, 3), FLOOR(3.95), GREATEST(10, 23, 8, 45, 34);
-- 뒤의 자리는 자르는 수의 위치를 의미

-- 3) 날짜함수 : 현재날짜(NOW())
-- weekday(날짜) : 요일(월요일-0, 화요일 -1, . . . 일요일 -6)
-- dayofweek(날짜) : 한 주의 요일 (일 -1, 월-2, . . . 토 -7)

SELECT now(), dayofweek(now()), dayofweek('2026-08-28');

-- dayofmonth(날짜) : 그 달에 몇번째 날인지 알아낸다.
-- dayofyear(날짜) : 그 해에 몇번째 날인지 알아낸다.

SELECT now(), dayofmonth(now()), dayofyear(now());

-- month(날짜) : 해당 날짜의 월 반환
-- year(날짜) : 해당 날짜의 년도 반환
-- dayname(날짜) : 요일명 반환
-- quarter(날짜) : 분기 반환

SELECT now(), month(now()), dayname(now()), quarter(now());

-- period_add(날짜형식, 더할_월수) : 몇 개월 뒤를 구할 때 사용

SELECT now(), period_add(202511, 2);

-- 두 날짜 사이의 개월 수를 반환 : period_diff(현재 월, 입사 년월)

SELECT now(), period_diff(202506, 202411);

-- 현재 날짜는 NOW()다 여기서 년도와 월을 구해내는 방법
-- ex) 사원 테이블에서 각 사원들이 현재까지 몇 개월 째 일을 하는지? 알아보자!

SELECT now(), SUBSTR(NOW(),1,4), substr(now(),6,2);
-- 년도와 월 얻어내기
SELECT empno, ename, hiredate, NOW(), period_diff(CONCAT(SUBSTR(NOW(),1,4), substr(now(),6,2)), concat(substr(hiredate,1,4),substr(hiredate,6,2)))
FROM emp;

-- date_format(날짜, 형식)
-- 형식은 정해지는 것에 따라 날짜 또는 시간을 출력한다.
-- [형식]
-- '%m' : 월이름
-- '%w' : 요일 이름
-- '%d' : 일(몇일)
-- '%Y' : 4자리의 년도
-- '%y' : 2자리의 년도
-- '%H' : 24시 형식의 시간
-- '%h' : 12시 형식의 시간
-- '%i' : 분(0~59)
-- '%s' : 초(0~59)
-- 현재날짜를 가지고 년 / 월 형식으로 출력해 보자

select now(), date_format(now(), '%Y/%m') AS c_date;

SELECT empno, ename, hiredate, now(), period_diff(date_format(now(), '%Y%m'), date_format(hiredate, '%Y%m')) AS long_work FROM emp;