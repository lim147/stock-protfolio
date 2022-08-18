DROP TABLE IF EXISTS stocks;
DROP TABLE IF EXISTS transactions;

CREATE TABLE stocks
  (
     symbol VARCHAR (50) PRIMARY KEY,
     name   VARCHAR(30),
     qty    INT
  );

CREATE TABLE transactions
  (
     symbol              VARCHAR (50) PRIMARY KEY,
     submitted_date_time DATETIME,
     submitted_price     DOUBLE,
     qty                 INT,
     type                INT
  );
