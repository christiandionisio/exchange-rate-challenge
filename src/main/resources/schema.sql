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