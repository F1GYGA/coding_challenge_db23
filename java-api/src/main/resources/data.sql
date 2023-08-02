INSERT INTO
users (user_name)
values
('Alex'),('Bob'),('Carl');

INSERT INTO
books (book_name)
VALUES
('trading_book_1'),('trading_book_2'),
('trading_book_3'),('trading_book_4'),
('trading_book_5'),('trading_book_6');

INSERT INTO
book_user
(user_id,book_id)
VALUES
(1,1),(1,3),(1,5),(2,1),(2,4),(2,6),
(3,2),(3,4),(3,5);

INSERT INTO
counter_parties (holder_name)
VALUES
('AZ Holdings Inc'),('Acme co'),('Sovereign Investments'),
('Astra Trading Ltd'),('Muncipal Gov Of Orange County'),
('Goldman Sachs'),('UBS'),('Barclays'),('British Telecom'),
('Pension Holdings'),('Zurich Pension fund 4');

INSERT INTO securities
(isin,cusip,bond_currency,coupon_percent,face_value,issuer_name,status,type,bond_maturity_date)
VALUES
('A12356111', '123456bh0', 'USD', 2, 900, 'UBS Facebook (USD)', 'active', 'CORP', '2021-09-30'),
('GB00B6460505', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '2021-08-09'),
('GB00B6460506', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '2021-08-09'),
('GB00B6460507', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '2021-08-09'),
('GB00B6460508', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '2021-08-09'),
('GB00B6460509', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '2021-08-09'),
('GB00B6460510', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '2021-08-09'),
('GB00B6460511', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '2021-08-09'),
('GB00B6460512', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '2021-08-09'),
('GB00B6460513', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '2021-08-09'),
('GB00B6460514', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '2021-08-09'),
('GB00B6460515', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '2021-08-09'),
('IE00B29LNP31', '87973RAA8', 'USD', 1.123, 340, 'First Norway Alpha Kl.IV', 'active', 'SOVN', '2030-12-22'),
('US87973RAA86', '87973RAA8', 'USD', 2.02, 690, 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S', 'active', 'SOVN', '2021-08-06'),
('USN0280EAR64', '123456780', 'USD', 3.15, 900, 'Airbus 3.15%  USD', 'active', 'CORP', '2021-07-30'),
('USU02320AG12', 'AMZN 3.15 08-22-27 REGS', 'USD', 3.15, 900, 'Amazon', 'active', 'CORP', '2021-08-03'),
('XS1988387210', '', 'USD', 4.37, 1000, 'BNPParibasIssu 4,37% Microsoft Corp (USD)', 'active', 'CORP', '2021-08-05');

INSERT INTO trades
(book_id,security_id,counterparty_id,trade_type,quantity,trade_currency,trade_status,unit_price,trade_date,trade_settlement_date)
VALUES( 1, 'XS1988387210', 1, 'buy', 50, 'USD', 'open', 90, '2021-05-13', '2021-08-04'),
( 1, 'XS1988387210', 1, 'sell', 40, 'USD', 'open', 89.56, '2021-02-04', '2021-08-04'),
( 2, 'USN0280EAR64', 2, 'buy', 1000, 'USD', 'open', 105.775, '2021-05-13', '2021-08-23'),
( 2, 'USN0280EAR64', 2, 'sell', 900, 'USD', 'open', 105.775, '2021-02-04', '2021-09-10'),
( 3, 'A12356111', 3, 'buy', 50, 'USD', 'open', 90, '2021-05-13', '2021-08-23'),
( 2, 'USN0280EAR64', 4, 'buy', 1000, 'USD', 'open', 105.775, '2021-05-13', '2021-08-23'),
( 2, 'A12356111', 3, 'sell', 50, 'USD', 'open', 90, '2021-05-13', '2021-08-23'),
( 4, 'USU02320AG12', 5, 'buy', 60, 'USD', 'open', 98.56, '2021-02-04', '2021-09-27'),
( 4, 'USU02320AG12', 5, 'buy', 50, 'USD', 'open', 98.56, '2021-08-23', '2021-08-23'),
( 6, 'GB00B6460505', 6, 'buy', 1100, 'GBP', 'open', 110.35, '2021-09-27', '2021-09-27'),
( 6, 'GB00B6460506', 6, 'sell', 900, 'GBP', 'open', 110.35, '2021-09-28', '2021-09-28'),
( 6, 'GB00B6460507', 7, 'buy', 2000, 'GBP', 'open', 110.35, '2021-09-29', '2021-09-29'),
( 6, 'GB00B6460508', 7, 'sell', 2000, 'GBP', 'open', 110.35, '2021-09-30', '2021-09-30'),
( 6, 'GB00B6460509', 8, 'buy', 1000, 'GBP', 'open', 110.35, '2021-10-01', '2021-10-01'),
( 6, 'GB00B6460510', 8, 'buy', 900, 'GBP', 'open', 110.35, '2019-10-02', '2019-10-02'),
( 6, 'GB00B6460511', 8, 'sell', 1900, 'GBP', 'open', 110.35, '2019-10-03', '2019-10-03'),
( 6, 'GB00B6460512', 9, 'buy', 600, 'GBP', 'open', 110.35, '2018-10-04', '2018-10-04'),
( 6, 'GB00B6460513', 10, 'buy', 600, 'GBP', 'open', 110.35, '2019-10-05', '2019-10-05'),
( 6, 'GB00B6460514', 10, 'buy', 700, 'GBP', 'open', 110.35, '2021-06-06', '2021-06-06'),
( 6, 'GB00B6460515', 10, 'sell', 1300, 'GBP', 'open', 110.35, '2011-10-07', '2021-10-07'),
( 4, 'US87973RAA86', 11, 'buy', 60, 'USD', 'open', 100.13, '2012-02-04', '2021-09-27'),
( 4, 'US87973RAA86', 11, 'buy', 50, 'USD', 'open', 100.13, '2012-08-23', '2021-08-23'),
( 4, 'US87973RAA86', 11, 'buy', 75, 'USD', 'open', 100.13, '2013-02-04', '2021-09-27'),
( 4, 'US87973RAA86', 11, 'buy', 50, 'USD', 'open', 100.13, '2014-08-23', '2021-08-23'),
( 4, 'IE00B29LNP31', 11, 'buy', 300, 'USD', 'open', 98.76, '2016-02-04', '2021-09-27'),
( 4, 'IE00B29LNP31', 11, 'buy', 300, 'USD', 'open', 98.76, '2012-08-23', '2021-08-23'),
(4, 'IE00B29LNP31', 11, 'buy', 300, 'USD', 'open', 98.76, '2013-02-04', '2021-09-27'),
(4, 'IE00B29LNP31', 11, 'sell', 300, 'USD', 'open', 98.76, '2015-08-23', '2021-08-23');