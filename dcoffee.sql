--
-- File generated with SQLiteStudio v3.4.4 on จ. ต.ค. 7 20:52:18 2024
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: category
DROP TABLE IF EXISTS category;

CREATE TABLE IF NOT EXISTS category (
    category_id   INTEGER   PRIMARY KEY ASC AUTOINCREMENT,
    category_name TEXT (50) NOT NULL
);

INSERT INTO category (
                         category_id,
                         category_name
                     )
                     VALUES (
                         1,
                         'Coffee'
                     );

INSERT INTO category (
                         category_id,
                         category_name
                     )
                     VALUES (
                         2,
                         'dessert'
                     );

INSERT INTO category (
                         category_id,
                         category_name
                     )
                     VALUES (
                         3,
                         'candy'
                     );


-- Table: customer
DROP TABLE IF EXISTS customer;

CREATE TABLE IF NOT EXISTS customer (
    customer_id   INTEGER PRIMARY KEY ASC AUTOINCREMENT,
    customer_name TEXT,
    customer_tel  TEXT    UNIQUE
);

INSERT INTO customer (
                         customer_id,
                         customer_name,
                         customer_tel
                     )
                     VALUES (
                         1,
                         'menoi',
                         '0844848844'
                     );

INSERT INTO customer (
                         customer_id,
                         customer_name,
                         customer_tel
                     )
                     VALUES (
                         2,
                         'chanyut',
                         '0994762563'
                     );

INSERT INTO customer (
                         customer_id,
                         customer_name,
                         customer_tel
                     )
                     VALUES (
                         4,
                         'lol',
                         '0987654321'
                     );

INSERT INTO customer (
                         customer_id,
                         customer_name,
                         customer_tel
                     )
                     VALUES (
                         5,
                         'hello',
                         '0918725643'
                     );

INSERT INTO customer (
                         customer_id,
                         customer_name,
                         customer_tel
                     )
                     VALUES (
                         6,
                         'ping',
                         '0994872563'
                     );


-- Table: material
DROP TABLE IF EXISTS material;

CREATE TABLE IF NOT EXISTS material (
    material_id    INTEGER   PRIMARY KEY ASC AUTOINCREMENT,
    material_name  TEXT (50) UNIQUE,
    material_qty   INTEGER   NOT NULL,
    material_price INTEGER   NOT NULL
);

INSERT INTO material (
                         material_id,
                         material_name,
                         material_qty,
                         material_price
                     )
                     VALUES (
                         1,
                         'coffee',
                         10,
                         500
                     );

INSERT INTO material (
                         material_id,
                         material_name,
                         material_qty,
                         material_price
                     )
                     VALUES (
                         2,
                         'sugar',
                         5,
                         100
                     );


-- Table: product
DROP TABLE IF EXISTS product;

CREATE TABLE IF NOT EXISTS product (
    product_id          INTEGER   PRIMARY KEY ASC AUTOINCREMENT,
    product_name        TEXT (50) UNIQUE,
    product_price       DOUBLE    NOT NULL,
    product_size        TEXT (5)  DEFAULT SML
                                  NOT NULL,
    product_sweet_level TEXT (5)  DEFAULT (123) 
                                  NOT NULL,
    product_type        TEXT (5)  DEFAULT HCF
                                  NOT NULL,
    category_id         INTEGER   DEFAULT (1) 
                                  NOT NULL
                                  REFERENCES category (category_id) ON DELETE SET NULL
                                                                    ON UPDATE CASCADE
);

INSERT INTO product (
                        product_id,
                        product_name,
                        product_price,
                        product_size,
                        product_sweet_level,
                        product_type,
                        category_id
                    )
                    VALUES (
                        1,
                        'Espresso',
                        30.0,
                        'SML',
                        '0123',
                        'HCF',
                        1
                    );

INSERT INTO product (
                        product_id,
                        product_name,
                        product_price,
                        product_size,
                        product_sweet_level,
                        product_type,
                        category_id
                    )
                    VALUES (
                        2,
                        'Americano',
                        40.0,
                        'SML',
                        '012',
                        'HC',
                        1
                    );

INSERT INTO product (
                        product_id,
                        product_name,
                        product_price,
                        product_size,
                        product_sweet_level,
                        product_type,
                        category_id
                    )
                    VALUES (
                        3,
                        'เค้กชิฟฟ่อนช็อกโกแลต',
                        50.0,
                        '-',
                        '-',
                        '-',
                        2
                    );

INSERT INTO product (
                        product_id,
                        product_name,
                        product_price,
                        product_size,
                        product_sweet_level,
                        product_type,
                        category_id
                    )
                    VALUES (
                        4,
                        'บัตเตอร์เค้ก',
                        60.0,
                        '-',
                        '-',
                        '-',
                        2
                    );


-- Table: promotion
DROP TABLE IF EXISTS promotion;

CREATE TABLE IF NOT EXISTS promotion (
    promotion_id         INTEGER PRIMARY KEY ASC AUTOINCREMENT,
    promotion_name       TEXT,
    promotion_startDate  TEXT    NOT NULL,
    promotion_expireDate TEXT    NOT NULL,
    promotion_status     TEXT
);

INSERT INTO promotion (
                          promotion_id,
                          promotion_name,
                          promotion_startDate,
                          promotion_expireDate,
                          promotion_status
                      )
                      VALUES (
                          1,
                          '1plus1',
                          '2024-10-01',
                          '2024-10-31',
                          'active'
                      );


-- Table: promotion_detail
DROP TABLE IF EXISTS promotion_detail;

CREATE TABLE IF NOT EXISTS promotion_detail (
    promotion_detail_id INTEGER PRIMARY KEY ASC AUTOINCREMENT,
    discount            REAL,
    minimum             INTEGER,
    promotion_id        INTEGER REFERENCES promotion (promotion_id) ON DELETE CASCADE
                                                                    ON UPDATE RESTRICT,
    product_id          INTEGER REFERENCES product (product_id) ON DELETE RESTRICT
                                                                ON UPDATE CASCADE
);

INSERT INTO promotion_detail (
                                 promotion_detail_id,
                                 discount,
                                 minimum,
                                 promotion_id,
                                 product_id
                             )
                             VALUES (
                                 1,
                                 0.5,
                                 2,
                                 1,
                                 1
                             );


-- Table: receipt
DROP TABLE IF EXISTS receipt;

CREATE TABLE IF NOT EXISTS receipt (
    receipt_id     INTEGER    PRIMARY KEY AUTOINCREMENT,
    receipt_date   DATETIME   DEFAULT CURRENT_TIMESTAMP
                              NOT NULL,
    total          REAL,
    cash           REAL,
    total_quantity INTEGER,
    user_id        INTEGER    NOT NULL
                              REFERENCES user (user_id) ON DELETE RESTRICT
                                                        ON UPDATE CASCADE,
    customer_id    INTEGER    REFERENCES customer (customer_id) ON DELETE RESTRICT
                                                                ON UPDATE CASCADE,
    change         "[REAL ] " GENERATED ALWAYS AS (cash - total) VIRTUAL,
    FOREIGN KEY (
        user_id
    )
    REFERENCES user (user_id) ON DELETE RESTRICT
                              ON UPDATE CASCADE,
    FOREIGN KEY (
        customer_id
    )
    REFERENCES customer (customer_id) ON DELETE RESTRICT
                                      ON UPDATE CASCADE
);

INSERT INTO receipt (
                        receipt_id,
                        receipt_date,
                        total,
                        cash,
                        total_quantity,
                        user_id,
                        customer_id
                    )
                    VALUES (
                        1,
                        '2024-09-29 15:54:22',
                        160.0,
                        1000.0,
                        4,
                        6,
                        1
                    );


-- Table: receipt_detail
DROP TABLE IF EXISTS receipt_detail;

CREATE TABLE IF NOT EXISTS receipt_detail (
    receipt_detail_id INTEGER PRIMARY KEY AUTOINCREMENT,
    product_id        INTEGER NOT NULL,
    product_name      TEXT    NOT NULL,
    product_price     REAL    NOT NULL,
    qty               INTEGER,
    total_price       REAL,
    receipt_id        INTEGER REFERENCES receipt (receipt_id) ON DELETE CASCADE
                                                              ON UPDATE CASCADE,
    FOREIGN KEY (
        product_id
    )
    REFERENCES product (product_id) ON DELETE RESTRICT
                                    ON UPDATE CASCADE,
    FOREIGN KEY (
        receipt_id
    )
    REFERENCES receipt (receipt_id) ON DELETE CASCADE
                                    ON UPDATE CASCADE
);

INSERT INTO receipt_detail (
                               receipt_detail_id,
                               product_id,
                               product_name,
                               product_price,
                               qty,
                               total_price,
                               receipt_id
                           )
                           VALUES (
                               1,
                               1,
                               'Espresso',
                               30.0,
                               2,
                               60.0,
                               1
                           );

INSERT INTO receipt_detail (
                               receipt_detail_id,
                               product_id,
                               product_name,
                               product_price,
                               qty,
                               total_price,
                               receipt_id
                           )
                           VALUES (
                               2,
                               4,
                               'butter_cake',
                               60.0,
                               1,
                               60.0,
                               1
                           );

INSERT INTO receipt_detail (
                               receipt_detail_id,
                               product_id,
                               product_name,
                               product_price,
                               qty,
                               total_price,
                               receipt_id
                           )
                           VALUES (
                               3,
                               2,
                               'Americano',
                               40.0,
                               1,
                               40.0,
                               1
                           );


-- Table: stock
DROP TABLE IF EXISTS stock;

CREATE TABLE IF NOT EXISTS stock (
    stock_id     INTEGER   PRIMARY KEY ASC AUTOINCREMENT,
    mat_name     TEXT (50) REFERENCES material (material_name),
    stock_total  INTEGER   NOT NULL,
    stock_amount INTEGER   NOT NULL
);

INSERT INTO stock (
                      stock_id,
                      mat_name,
                      stock_total,
                      stock_amount
                  )
                  VALUES (
                      1,
                      'coffee',
                      5,
                      2
                  );

INSERT INTO stock (
                      stock_id,
                      mat_name,
                      stock_total,
                      stock_amount
                  )
                  VALUES (
                      2,
                      'sugar',
                      10,
                      5
                  );


-- Table: user
DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user (
    user_id       INTEGER   PRIMARY KEY ASC AUTOINCREMENT,
    user_login    TEXT (50) UNIQUE,
    user_gender   TEXT (3)  NOT NULL,
    user_password TEXT (50) NOT NULL,
    user_role     INTEGER   NOT NULL,
    user_name     TEXT (50) 
);

INSERT INTO user (
                     user_id,
                     user_login,
                     user_gender,
                     user_password,
                     user_role,
                     user_name
                 )
                 VALUES (
                     6,
                     'werapan',
                     'M',
                     'password',
                     1,
                     'Worawit'
                 );

INSERT INTO user (
                     user_id,
                     user_login,
                     user_gender,
                     user_password,
                     user_role,
                     user_name
                 )
                 VALUES (
                     10,
                     'admin',
                     'M',
                     'password',
                     0,
                     'Administrator'
                 );

INSERT INTO user (
                     user_id,
                     user_login,
                     user_gender,
                     user_password,
                     user_role,
                     user_name
                 )
                 VALUES (
                     13,
                     'chanyut',
                     'M',
                     'ping',
                     0,
                     'lisawat'
                 );


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
