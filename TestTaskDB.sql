USE MYTEST;

DROP TABLE IF EXISTS CURRENCY_RATE;
DROP TABLE IF EXISTS CURRENCY_TYPE;

CREATE TABLE CURRENCY_TYPE (
    CURR_ID    VARCHAR(10) NOT NULL UNIQUE PRIMARY KEY,
    Num_Code   VARCHAR(10),
    Char_Code  VARCHAR(10),
    Nominal    VARCHAR(10),
    Name       VARCHAR(128),
    IS_DELETED VARCHAR(1) NOT NULL DEFAULT 'F',
    CREATED    TIMESTAMP NOT NULL DEFAULT NOW()
);
CREATE TABLE CURRENCY_RATE (
    ID      			INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    CURR_ID VARCHAR(10) NOT NULL,
    Value   			FLOAT NOT NULL,
    UPDATED 			DATE NOT NULL,
    FOREIGN KEY (CURR_ID) REFERENCES CURRENCY_TYPE (CURR_ID) ON DELETE CASCADE
);
CREATE UNIQUE INDEX UPDATE_IDX ON CURRENCY_RATE(CURR_ID,UPDATED);


DROP PROCEDURE IF EXISTS getRATES;
CREATE PROCEDURE getRATES(T DATE) 
  SELECT id, t1.CURR_ID as CURR_ID, Nominal as coeff, Name, Char_Code, Value, UPDATED FROM CURRENCY_RATE t1
  INNER JOIN (SELECT CURR_ID AS i1,MAX(UPDATED) AS d1 FROM CURRENCY_RATE WHERE UPDATED<=T GROUP BY CURR_ID ) t2
  INNER JOIN CURRENCY_TYPE t3
  ON t1.CURR_ID=i1 AND t1.UPDATED=d1 AND t3.CURR_ID=t1.CURR_ID;

DROP PROCEDURE IF EXISTS getRateTrend;
CREATE PROCEDURE getRateTrend(c VARCHAR(10),d0 DATE,d1 DATE) 
  SELECT id, t1.CURR_ID as CURR_ID, Nominal as coeff, Name, Char_Code, Value, UPDATED FROM CURRENCY_RATE t1
  INNER JOIN CURRENCY_TYPE t2
  USING(CURR_ID) WHERE t1.CURR_ID=c AND UPDATED>=d0 AND UPDATED<=d1;
  
DROP PROCEDURE IF EXISTS getCURRENCIES;
CREATE PROCEDURE getCURRENCIES()
  SELECT ROW_NUMBER() Over (Order By CURR_ID) as id, CURR_ID as CURR_ID, Nominal as coeff, Name, Char_Code, 0 as Value,0 as UPDATED FROM CURRENCY_TYPE;
  
call getRATES('2020-08-10');
call getRateTrend('R01010','2020-08-8','2020-08-14');
call getCURRENCIES();
 
commit;
