DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS stocks;

CREATE TABLE stocks
  (
     symbol              VARCHAR (50) PRIMARY KEY,
     name                VARCHAR(30),
     qty                 INT
  );

CREATE TABLE transactions
  (
     id                  INT PRIMARY KEY AUTO_INCREMENT,
     stock_symbol        VARCHAR (50),
     submitted_date_time DATETIME,
     submitted_price     DOUBLE,
     qty                 INT,
     type                VARCHAR (30),
     FOREIGN KEY (stock_symbol) REFERENCES stocks(symbol)
  );
