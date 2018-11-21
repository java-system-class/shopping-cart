CREATE TABLE `user` (
    id          INTEGER         PRIMARY KEY NOT NULL,
    name        VARCHAR(20)     NOT NULL,
    password    VARCHAR(255)     NOT NULL
);

CREATE TABLE `cart_item` (
    id          INTEGER         PRIMARY KEY NOT NULL,
    user_id     INTEGER         NOT NULL,
    product_id  INTEGER         NOT NULL,
    quantity    INTEGER         NOT NULL
);

CREATE TABLE `product` (
    id          INTEGER         PRIMARY KEY NOT NULL,
    name        VARCHAR(25)     NOT NULL,
    price       INTEGER         NOT NULL,
    description VARCHAR(255)    NOT NULL
);

CREATE TABLE `order` (
    id          INTEGER         PRIMARY KEY NOT NULL,
    user_id     INTEGER         NOT NULL,
    product_id  INTEGER         NOT NULL,
    quantity    INTEGER         NOT NULL,
    status      VARCHAR(25)     NOT NULL,
    address     VARCHAR(255)    NOT NULL
);