CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE clients_entity
(
    id        INTEGER NOT NULL,
    bith_date TIMESTAMP WITHOUT TIME ZONE,
    genre     VARCHAR(255),
    email     VARCHAR(255),
    CONSTRAINT pk_clientsentity PRIMARY KEY (id)
);

ALTER TABLE clients_entity
    ADD name VARCHAR(255);
