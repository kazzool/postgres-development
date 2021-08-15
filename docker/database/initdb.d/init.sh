#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE ROLE flyway WITH LOGIN PASSWORD 'flyway';
    ALTER ROLE flyway WITH CREATEROLE;
    CREATE DATABASE sample_db;
    GRANT ALL PRIVILEGES ON DATABASE sample_db TO flyway WITH GRANT OPTION;

    CREATE ROLE sample_user WITH LOGIN PASSWORD 'sample_user';
    GRANT sample_user TO flyway;
EOSQL