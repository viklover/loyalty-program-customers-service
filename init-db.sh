set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE DATABASE "loyalty-program-customers-service";
  GRANT ALL PRIVILEGES ON DATABASE "loyalty-program-customers-service" TO postgres;

  \connect "loyalty-program-customers-service";
EOSQL
