DROP TABLE IF EXISTS stocks;
DROP TABLE IF EXISTS transactions;

CREATE TABLE stocks
  (
     symbol              VARCHAR (50) PRIMARY KEY,
     name                VARCHAR(30),
     qty                 INT
  );

CREATE TABLE transactions
  (
     id                  INT PRIMARY KEY,
     symbol              VARCHAR (50),
     submitted_date_time DATETIME,
     submitted_price     DOUBLE,
     qty                 INT,
     type                INT
  );
