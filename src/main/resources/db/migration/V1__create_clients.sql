CREATE SEQUENCE  IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE clients (
  id INTEGER NOT NULL,
  created_at TIMESTAMP with time zone NOT NULL,
  updated_at TIMESTAMP with time zone NOT NULL,
  name VARCHAR(255),
  birth_date VARCHAR(255),
  genre VARCHAR(255),
  email VARCHAR(255),
  CONSTRAINT pk_clients PRIMARY KEY (id)
);