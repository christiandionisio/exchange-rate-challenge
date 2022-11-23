CREATE TABLE user_auth (id SERIAL PRIMARY KEY,
    email VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
);

CREATE TABLE exchange_rate_config (id SERIAL PRIMARY KEY,
    origin_currency VARCHAR(255),
    destiny_currency VARCHAR(255),
    exchange_rate NUMERIC(10,2),
    date TIMESTAMP,
    registry_date TIMESTAMP,
    registry_user VARCHAR(255),
    modification_date TIMESTAMP,
    modification_user VARCHAR(255)
);

CREATE TABLE exchange (id SERIAL PRIMARY KEY,
   amount NUMERIC(10,2),
   origin_currency VARCHAR(255),
   destiny_currency VARCHAR(255),
   exchange_rate NUMERIC(10,2),
   exchanged_amount NUMERIC(10,2),
   registry_date TIMESTAMP,
   registry_user VARCHAR(255)
);



INSERT INTO exchange_rate_config (origin_currency, destiny_currency, exchange_rate, date, registry_date, registry_user,
    modification_date, modification_user) VALUES ('PEN', 'EUR', 4.87, '2022-11-22T00:00:00', '2022-11-22T00:00:00',
    'dummy', null, null);