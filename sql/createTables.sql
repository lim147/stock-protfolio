CREATE DATABASE IF NOT EXISTS conygre;
USE conygre;

DROP TABLE IF EXISTS stocks; -- run if database needs a reset
CREATE TABLE stocks
  (
     id                  INT PRIMARY KEY auto_increment,
     symbol              VARCHAR (50),
     name                VARCHAR(30),
     submitted_price     DOUBLE,
     submitted_date_time DATETIME,
     qty                 INT,
     type                INT
  );

INSERT INTO stocks VALUES (1, 'AAPL', 'Apple', 172.10, "2022-08-12 16:08:12", 5, 0);
INSERT INTO stocks VALUES (2, 'MSFT', 'Microsoft', 291.91, "2022-07-15 13:10:15", 10, 1);
INSERT INTO stocks VALUES (3, 'TSLA', 'Tesla', 900, "2022-06-12 10:30:20", 2, 0);
