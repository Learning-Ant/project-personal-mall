DROP SEQUENCE M_ADDRBOOK_SEQ;

CREATE SEQUENCE M_ADDRBOOK_SEQ
START WITH 1
INCREMENT BY 1
MAXVALUE 999999
NOCYCLE
NOCACHE;

DROP TABLE M_ADDRBOOK;
DROP TABLE M_CUSTOMER;

CREATE TABLE M_CUSTOMER
(
	M_CUSTOMER_ID VARCHAR2(20) PRIMARY KEY,
	M_CUSTOMER_PW VARCHAR2(20) NOT NULL,
	M_CUSTOMER_NAME VARCHAR2(20) NOT NULL,
	M_CUSTOMER_PHONENUM CHAR(13) UNIQUE NOT NULL,
	M_CUSTOMER_BIRTH DATE NOT NULL,
	M_CUSTOMER_EMAIL VARCHAR2(50) UNIQUE NOT NULL,
	M_CUSTOMER_ADDR VARCHAR2(100) NOT NULL,
	M_CUSTOMER_JOINDATE DATE NOT NULL,
	M_CUSTOMER_POINT NUMBER,
	M_CUSTOMER_GRADE VARCHAR2(10),
	M_CUSTOMER_SUMPRICE NUMBER,
	M_CUSTOMER_AGREE CHAR(1) NOT NULL
);
CREATE TABLE M_ADDBOOK
(
	M_ADDRBOOK_NO NUMBER PRIMARY KEY,
	M_ADDRBOOK_NAME VARCHAR2(20) NOT NULL,
	M_ADDRBOOK_PHONENUM CHAR(13) NOT NULL,
	M_ADDRBOOK_ADDR VARCHAR2(100) NOT NULL,
	M_CUSTOMER_ID VARCHAR2(20) REFERENCES M_CUSTOMER(M_CUSTOMER_ID)
);

INSERT INTO M_CUSTOMER VALUES ('admin', '1111', '관리자', '010-1111-1111', '1992-06-10', 'jspark9206@naver.com', '서울 마포구 노고산동', SYSDATE, 0, 'BRONZE', 0, '1');
