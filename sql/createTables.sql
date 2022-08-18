CREATE DATABASE IF NOT EXISTS conygre;
USE conygre;

DROP TABLE IF EXISTS stocks; -- run if database needs a reset
CREATE TABLE stocks
  (
     symbol              VARCHAR (50) PRIMARY KEY,
     name                VARCHAR(30),
     qty                 INT
  );

INSERT INTO stocks VALUES ('AAPL', 'Apple', 5);
INSERT INTO stocks VALUES ('MSFT', 'Microsoft', 10);
INSERT INTO stocks VALUES ('TSLA', 'Tesla', 2);

DROP TABLE IF EXISTS transactions; -- run if database needs a reset

CREATE TABLE transactions
  (
     symbol              VARCHAR (50) PRIMARY KEY,
     submitted_date_time DATETIME,
     submitted_price     DOUBLE,
     qty                 INT,
     type                INT
  ); 

INSERT INTO transactions VALUES ('AAPL', "2022-08-12 16:08:12", 172.10,  5, 0);
INSERT INTO transactions VALUES ('MSFT', "2022-07-15 13:10:15", 291.91, 10, 1);
INSERT INTO transactions VALUES ('TSLA', "2022-06-12 10:30:20", 900, 2, 0);
