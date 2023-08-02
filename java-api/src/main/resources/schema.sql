DROP TABLE IF EXISTS trades;
DROP TABLE IF EXISTS securities;
DROP TABLE IF EXISTS counter_parties;
DROP TABLE IF EXISTS book_user;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS books;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(20) NOT NULL
);

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    book_name VARCHAR(50) NOT NULL
);

CREATE TABLE book_user (
    book_id INT REFERENCES books (id),
    user_id INT REFERENCES users (id),
    UNIQUE (book_id, user_id)
);

CREATE TABLE counter_parties (
    id INT AUTO_INCREMENT PRIMARY KEY,
    holder_name VARCHAR(50) NOT NULL
);

CREATE TABLE securities (
    isin VARCHAR(12) PRIMARY KEY,
    cusip VARCHAR(9),
    bond_currency VARCHAR(3) NOT NULL,
    coupon_percent FLOAT NOT NULL CHECK (coupon_percent >= 0),
    face_value FLOAT NOT NULL CHECK (face_value >= 0),
    issuer_name VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL,
    type ENUM('SOVN, GOVN, CORP') NOT NULL,
    bond_maturity_date DATE NOT NULL
);

CREATE TABLE trades (
       id INT AUTO_INCREMENT PRIMARY KEY,
       book_id INT REFERENCES books (id),
       security_id VARCHAR(12) REFERENCES securities (isin),
       counterparty_id INT REFERENCES counter_parties (id),
       trade_type  ENUM('buy', 'sell') NOT NULL,
       quantity INT NOT NULL CHECK (quantity > 0),
       trade_currency VARCHAR(3) NOT NULL,
       trade_status ENUM('open', 'closed') NOT NULL,
       unit_price FLOAT NOT NULL CHECK (unit_price >= 0),
       trade_date DATE NOT NULL,
       trade_settlement_date DATE NOT NULL,
       CHECK(trade_settlement_date >= trade_date)
);
