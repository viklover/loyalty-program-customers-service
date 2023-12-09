CREATE TABLE CUSTOMER
(
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(15) NOT NULL,
    last_name  VARCHAR(25) NOT NULL,
    birth_day  TIMESTAMP   NULL,
    created_at TIMESTAMP   NOT NULL DEFAULT NOW()
);
