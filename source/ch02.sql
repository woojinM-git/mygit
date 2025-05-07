 show databases;
 
  -- information_schema : MYSQL서버의 메타데이터를 제공(메타데이터란 데이터베이스의 구조에 대한 정보, ex) 테이블, 칼럼, 인덱스, 사용자 권한 등)
 -- mysql : MYSQL 서버의 사용자 계정 정보, 권한 그리고 다른 시스템 레벨의 정보를 저장
 -- perfomance_schema : MYSQL 서버 성능을 진단하고 모니터링하는데 관련된 데이터를 저장
 -- sys : performance_schema의 데이터를 단순화해 사용자가 더 쉽게 성능을 분석할 수 있도록 도와줌
 
 CREATE database mapdonalds; -- mapdonalds DB 생성
 USE mapdonalds; -- mapdonalds DB 진입
 SELECT DATABASE(); -- 현재 사용 중인 DB 조회
 DROP DATABASE mapdonalds; -- mapdonalds DB 삭제
 
 CREATE DATABASE mapdonalds;	-- mapdonalds DB 생성
 USE mapdonalds;				-- mapdonalds DB 진입
 
-- burgers 테이블 생성
 CREATE TABLE burgers (
 id INTEGER PRIMARY KEY,		-- 아이디(정수형 숫자)
 name VARCHAR(50), 	-- 이름(문자형: 최대 50자)
 price INTEGER,		-- 가격(정수형 숫자)
 gram INTEGER,		-- 그램(정수형 숫자)
 kcal INTEGER,		-- 열량(정수형 숫자)
 protein INTEGER,	-- 단백질량(정수형 숫자)
 PRIMARY KEY (id)	-- 기본키 지정:id
 );
 
  -- id : 테이블에 저장된 모든 버거를 구분하기 위해 칼럼으로 중복되지 않는 유일한 값을 가짐, 칼럼을 "기본키" 라고 한다
 -- name : 버거의 이름을 나타내며 문자로 작성
 -- price : 버거의 가격을 나타내며 원 단위 숫자로 작성
 -- gram : 버거의 무게를 나타내며 그램 단위 숫자로 작성
 -- kcal : 버거의 열량을 나타내며 킬로칼로리 단위 숫자 작성
 -- protein : 버거의 단백질량을 나타내며 그램 단위 숫자로 작성
 
 DESC burgers;
--  Field: 테이블의 칼럼을 나타낸다
--  Type: 칼럼의 자료형을 나타낸다
--  Null: 칼럼에 값을 넣어야 하는지 넣지 않아도 되는지를 나타낸다
--  key: 칼럼이 테이블의 기본키, 외래키, 고유키 등 특별한 키로 사용되는지를 나타낸다
--  Default: 칼럼의 기본값을 나타낸다
--  Extra: 칼럼에 적용된 추가 속성을 나타낸다

-- 단일 데이터 삽입
INSERT INTO burgers (id, name, price, gram, kcal, protein)
VALUES (1, '빅맨', 5300, 223, 583, 27);

SELECT *
FROM burgers;