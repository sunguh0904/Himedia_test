USE drinkdb;
DROP TABLE IF EXISTS tbl_drink;
DROP TABLE IF EXISTS tbl_category;

CREATE TABLE IF NOT EXISTS tbl_category (
	CATEGORY_CODE INT PRIMARY KEY AUTO_INCREMENT,
    CATEGORY_NAME VARCHAR(5) NOT NULL UNIQUE
) ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS tbl_drink (
	DRINK_CODE INT PRIMARY KEY AUTO_INCREMENT,
    DRINK_NAME VARCHAR(15) NOT NULL UNIQUE,
    DRINK_PRICE INT NOT NULL,
    CATEGORY_CODE INT NOT NULL,
    FOREIGN KEY(CATEGORY_CODE) REFERENCES tbl_category(CATEGORY_CODE)
) ENGINE = INNODB;

ALTER TABLE tbl_category AUTO_INCREMENT = 1;
ALTER TABLE tbl_drink AUTO_INCREMENT = 1;

INSERT INTO tbl_category (CATEGORY_NAME)
VALUES
('탄산음료'),
('이온음료'),
('과즙음료'),
('제로음료'),
('에너지음료');

INSERT INTO tbl_drink (DRINK_NAME, DRINK_PRICE, CATEGORY_CODE)
VALUES
('코카콜라', 1500, 1),
('칠성사이다', 1600, 1),
('환타', 1700, 1),
('웰치스', 1800, 1),
('닥터페퍼', 1900, 1),
('게토레이', 1500, 2),
('파워에이드', 1600, 2),
('토레타', 1700, 2),
('포카리스웨트', 1800, 2),
('사과주스', 1500, 3),
('감귤주스', 1600, 3),
('포도주스', 1700, 3),
('토마토주스', 1800, 3),
('알로에주스', 1900, 3),
('펩시제로', 1500, 4),
('환타제로', 1600, 4),
('밀키스제로', 1700, 4),
('웰치스제로', 1800, 4),
('탐스제로', 1900, 4),
('몬스터', 1500, 5),
('핫식스', 1600, 5),
('더킹', 1700, 5),
('레드불', 1800, 5);