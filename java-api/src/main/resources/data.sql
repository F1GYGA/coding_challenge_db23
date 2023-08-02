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
('A12356111', '123456bh0', 'USD', 2, 900, 'UBS Facebook (USD)', 'active', 'CORP', '2021-09-30');
--('GB00B6460505', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '9-8-2021'),
--('GB00B6460506', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '9-8-2021'),
--('GB00B6460507', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '9-8-2021'),
--('GB00B6460508', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '9-8-2021'),
--('GB00B6460509', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '9-8-2021'),
--('GB00B6460510', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '9-8-2021'),
--('GB00B6460511', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '9-8-2021'),
--('GB00B6460512', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '9-8-2021'),
--('GB00B6460513', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '9-8-2021'),
--('GB00B6460514', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '9-8-2021'),
--('GB00B6460515', 'BDCHBW8', 'GBP', 0.75, 900, 'HM Treasury United Kingdom', 'active', 'GOVN', '9-8-2021'),
--('IE00B29LNP31', '87973RAA8', 'USD', 1.123, 340, 'First Norway Alpha Kl.IV', 'active', 'SOVN', '22-12-2030'),
--('US87973RAA86', '87973RAA8', 'USD', 2.02, 690, 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S', 'active', 'SOVN', '6-8-2021'),
--('USN0280EAR64', '123456780', 'USD', 3.15, 900, 'Airbus 3.15%  USD', 'active', 'CORP', '30-07-2021'),
--('USU02320AG12', 'AMZN 3.15 08-22-27 REGS', 'USD', 3.15, 900, 'Amazon', 'active', 'CORP', '3-8-2021'),
--('XS1988387210', '', 'USD', 4.37, 1000, 'BNPParibasIssu 4,37% Microsoft Corp (USD)', 'active', 'CORP', '5-8-2021');

--INSERT INTO trades
--(book_id,security_id,counterparty_id,trade_type,quantity,currency,status,unit_price,trade_date,trade_settlement_date)
--VALUES(1, 1, 'XS1988387210', 1, 'buy', 50, 'USD', 'active', 90, '13-05-2021', '4-8-2021'),
--(2, 1, 'XS1988387210', 1, 'sell', 40, 'USD', 'active', 89.56, '4-2-2021', '4-8-2021'),
--(3, 2, 'USN0280EAR64', 2, 'buy', 1000, 'USD', 'active', 105.775, '13-05-2021', '23-08-2021'),
--(4, 2, 'USN0280EAR64', 2, 'sell', 900, 'USD', 'active', 105.775, '4-2-2021', '10-9-2021'),
--(5, 3, 'A12356111', 3, 'buy', 50, 'USD', 'active', 90, '13-05-2021', '23-08-2021'),
--(6, 2, 'USN0280EAR64', 4, 'buy', 1000, 'USD', 'active', 105.775, '13-05-2021', '23-08-2021'),
--(7, 2, 'A12356111', 3, 'sell', 50, 'USD', 'active', 90, '13-05-2021', '23-08-2021'),
--(8, 4, 'USU02320AG12', 5, 'buy', 60, 'USD', 'active', 98.56, '4-2-2021', '27-09-2021'),
--(9, 4, 'USU02320AG12', 5, 'buy', 50, 'USD', 'active', 98.56, '23-08-2021', '23-08-2021'),
--(10, 6, 'GB00B6460505', 6, 'buy', 1100, 'GBP', 'active', 110.35, '27-09-2021', '27-09-2021'),
--(11, 6, 'GB00B6460506', 6, 'sell', 900, 'GBP', 'active', 110.35, '28-09-2021', '28-09-2021'),
--(12, 6, 'GB00B6460507', 7, 'buy', 2000, 'GBP', 'active', 110.35, '29-09-2021', '29-09-2021'),
--(13, 6, 'GB00B6460508', 7, 'sell', 2000, 'GBP', 'active', 110.35, '30-09-2021', '30-09-2021'),
--(14, 6, 'GB00B6460509', 8, 'buy', 1000, 'GBP', 'active', 110.35, '1-10-2021', '1-10-2021'),
--(15, 6, 'GB00B6460510', 8, 'buy', 900, 'GBP', 'active', 110.35, '2-10-2019', '2-10-2019'),
--(16, 6, 'GB00B6460511', 8, 'sell', 1900, 'GBP', 'active', 110.35, '3-10-2019', '3-10-2019'),
--(17, 6, 'GB00B6460512', 9, 'buy', 600, 'GBP', 'active', 110.35, '4-10-2018', '4-10-2018'),
--(18, 6, 'GB00B6460513', 10, 'buy', 600, 'GBP', 'active', 110.35, '5-10-2019', '5-10-2019'),
--(19, 6, 'GB00B6460514', 10, 'buy', 700, 'GBP', 'active', 110.35, '6-6-2021', '6-6-2021'),
--(20, 6, 'GB00B6460515', 10, 'sell', 1300, 'GBP', 'active', 110.35, '7-10-2011', '7-10-2021'),
--(21, 4, 'US87973RAA86', 11, 'buy', 60, 'USD', 'active', 100.13, '4-2-2012', '27-09-2021'),
--(22, 4, 'US87973RAA86', 11, 'buy', 50, 'USD', 'active', 100.13, '23-08-2012', '23-08-2021'),
--(23, 4, 'US87973RAA86', 11, 'buy', 75, 'USD', 'active', 100.13, '4-2-2013', '27-09-2021'),
--(24, 4, 'US87973RAA86', 11, 'buy', 50, 'USD', 'active', 100.13, '23-08-2014', '23-08-2021'),
--(25, 4, 'IE00B29LNP31', 11, 'buy', 300, 'USD', 'active', 98.76, '4-2-2016', '27-09-2021'),
--(26, 4, 'IE00B29LNP31', 11, 'buy', 300, 'USD', 'active', 98.76, '23-08-2012', '23-08-2021'),
--(27, 4, 'IE00B29LNP31', 11, 'buy', 300, 'USD', 'active', 98.76, '4-2-2013', '27-09-2021'),
--(28, 4, 'IE00B29LNP31', 11, 'sell', 300, 'USD', 'active', 98.76, '23-08-2015', '23-08-2021');