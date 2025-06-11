-- DOL : 데이터 정의어
-- CREATE, ALTER, DROP
-- 테이블 생성법
-- CREATE TABLE [테이블명] (
-- 		[컬럼명1][자료형(자료형길이)], 
-- 		[칼럼명2] [자료형(길이), . . .]
-- 		CNSTRAINT [제약조건명] [제약조건]
-- );
-- 도서저장 테이블 생성
-- 하나의 도서 : 도서명, 도서고유번호, 저자, 출판사, 가격, 등록일, . . .)

CREATE TABLE book_t(
	b_idx BIGINT(4) AUTO_INCREMENT,
    title CHAR(100),
    author VARCHAR(50),
    press VARCHAR(50),
    price DECIMAL(9,1),
    CONSTRAINT book_t_pk PRIMARY KEY(b_idx) -- 
);

-- 테이블 수정(컬럼추가)
-- 	등록일 컬럼을 추가한다.
ALTER TABLE book_t
ADD COLUMN reg_date DATE;

-- 	등록일 컬럼을 press 컬럼 뒤에 추가할 때 어떻게 해야 하나?
ALTER TABLE book_t
ADD COLUMN reg_date DATE NULL AFTER press;

-- 테이블 수정(컬럼의 자료형 변경)
-- 	제목의 자료형 길이를 200으로 변경하고자 한다.
ALTER TABLE book_t
MODIFY title VARCHAR(200); -- 자료형과 길이 수정

-- 테이블 수정(컬럼명 변경)
-- title 컬럼명을 subject로 변경하자!
ALTER TABLE book_t
RENAME COLUMN title TO subject;

-- 테이블 수정(컬럼 삭제)
-- 출판사 (press) 정보는 삭제하자
ALTER TABLE book_t
DROP COLUMN press;

-- 회원정보(member_t)를 저장하는 테이블이 필요한 상황이다
-- 정보는 회원명, 이메일, 연락처가 반드시 들어가야 함
CREATE TABLE member_t(
	m_idx BIGINT(6) AUTO_INCREMENT,
    m_name VARCHAR(50) NOT NULL, -- NULL을 허용하지 않는다
    m_email VARCHAR(100),
    m_phone VARCHAR(20),
    CONSTRAINT member_t_pk PRIMARY KEY(m_idx)
);

-- 데이터 추가(INSERT)
-- [구성]
-- 	INSERT INTO [테이블명] (컬럼명1, 컬럼명2, . . . , 컬럼명n)
-- 	VALUES(값1, 값2, . . ., 값n);
-- 주의) 명시한 컬럼의 수와 지정한 값의 수가 일치해야 한다.

-- 예) 회원정보 추가하기
INSERT INTO member_t(m_name, m_email, m_phone)
VALUES('마루치', 'maru@korea.com', '010-1234-5678');

INSERT INTO member_t(m_name, m_email, m_phone)
VALUES('아라치', 'arachi@korea.com', '010-2102-5678');

-- 데이터 확인
SELECT * FROM member_t;

INSERT INTO member_t(m_name, m_email)
VALUES('이도', "");

-- 회원등록 날짜를 저장하는 컬럼을 추가하려면 . . .
ALTER TABLE member_t
ADD write_date DATE null;

-- 문제) member_t에서 write_date라는 컬럼을 reg_date로 변경
ALTER TABLE member_t
RENAME COLUMN write_date to reg_date;

-- 데이터 수정(UPDATE)
-- [구성]
-- 	UPDATE[테이블명]
-- 	SET [변경할정보가 있는 컬럼명] = [변경할 값]
-- 	WHERE[조건식];

UPDATE member_t
SET m_email = 'edo@korea.com'
WHERE m_idx = 3;

-- 데이터 삭제(DELETE)
-- [구성]
-- 	DELETE FROM [테이블명]
-- 	WHERE [조건식];

-- 예) member_t테이블에서 m_idx값이 4번인 자원을 삭제하자!
DELETE FROM member_t
WHERE m_idx = 4;

-- 예) member_t테이블에서 m_idx값이 20, 308, 5번인 자원을 삭제하자!
DELETE FROM member_t
WHERE m_idx IN(20, 308, 5);

-- 테이블 삭제(DROP TABLE)
DROP TABLE member_t;

-- 계정생성과 권한부여 : DCL 
-- 사용자 계정을 생성하려면 우선 관리자 계정(root)으로 로그인이 되어야 한다.
--  [구성]
-- 	 현재 서버에서만 접속할 수 있는 계정 생성
-- 		CREATE USER '사용자계정'@'localhost'
-- 		IDENTIFIED BY '비밀번호';

-- 	 해당 ip에서만 접속할 수 있는 계정 생성
-- 		CREATE USER '사용자계정'@'234.123.12.45'
-- 		IDENTIFIED BY '비밀번호';

-- 	 해당 ip영역대에서만 접속할 수 있는 계정 생성
-- 		CREATE USER '사용자계정'@'234.123.%'
-- 		IDENTIFIED BY '비밀번호';

-- 	 어디에서든 접속할 수 있는 계정 생성
-- 		CREATE USER '사용자계정'@'%'
-- 		IDENTIFIED BY '비밀번호';

CREATE USER 'test_admin'@'%'
IDENTIFIED BY '1111';

-- 계정이 생성되었지만 my_db에 접속조차 할 수가 없다. 이유는 
-- 권한이 없기 때문이다. 권한을 오너(최초 DB를 생성한 계정)가 부여해 줘야 한다.

-- 해당 DB의 모든 객체에 대한 모든 권한 주는 법
-- GRANT all PRIVILEGES ON *.* TO '계정명'@'호스트'; <- (*.*)모든 객체를 의미

-- 해당 DB의 모든객체에 대한 SELECT와 INSERT 권한만 주고 싶다면...
-- 	GRANT slect,insert PRIBILEGE ON *.* TO '계정명'@'호스트';

-- test_admin에게 my_db의 모든 객체들에게 모든 권한을 부여하자!
GRANT all PRIVILEGES ON my_db.* TO 'test_admin'@'%';

-- 권한 회수
-- [구성]
-- 	REVOKE all ON my_db.* FROM '계정명'@'호스트';

-- test_admin 계정에 부여한 권한을 회수하자!
REVOKE all ON my_db.* FROM 'test_admin'@'%';

-- 모델링
-- 	그림을 판매하는 프로그램을 구현하자!

-- 예술품(그림) 정보가 저장되는 테이블 작성
-- 	(제목, 작가, 유형, 가격, 제작년도, 등록일)
CREATE TABLE art_t(
	art_idx BIGINT(6) AUTO_INCREMENT,
    subject VARCHAR(100) NOT NULL,
    auther VARCHAR(50) NOT NULL,
    type VARCHAR(30),
    price DECIMAL(9,2),
    make_year VARCHAR(20),
    reg_date DATE,
    CONSTRAINT art_t_pk PRIMARY KEY(art_idx)
);

-- 회원정보가 저장되는 테이블 작성
-- 	(회원명, 아이디, 비밀번호, 연락처, 주소, 등록일)
CREATE TABLE member_t(
	m_idx BIGINT(6) AUTO_INCREMENT,
    m_name VARCHAR(50) NOT NULL,
    m_id VARCHAR(30) NOT NULL,
    m_pw VARCHAR(50) NOT NULL,
    m_phone VARCHAR(20) NOT NULL,
    m_addr VARCHAR(50),
    reg_date DATE,
    status INT(1) DEFAULT 0,
    etc1 VARCHAR(10),
    etc2 VARCHAR(10),
    CONSTRAINT member_t_pk PRIMARY KEY (m_idx)
);

-- 판매정보를 저장하는 테이블 작성
-- 	(판매할 그림정보, 구매하는 회원정보, 판매일, 거래일, 상태)
CREATE TABLE sales_t(
	s_idx BIGINT(6) AUTO_INCREMENT PRIMARY KEY,
    art_idx BIGINT(6) NOT NULL,
    m_idx BIGINT(6) NOT NULL,
    start_date DATE,
    sale_date DATE,
    status INT(1),
    CONSTRAINT sales_t_fk1 FOREIGN KEY(art_idx) REFERENCES art(art_idx),
	CONSTRAINT sales_t_fk1 FOREIGN KEY(m_idx) REFERENCES member_t(m_idx)
);