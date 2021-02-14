sudo apt install -y maven
sudo apt install -y openjdk-8-jre-headless
mvn install
sudo apt install -y postgresql postgresql-contrib
sudo -u postgres createdb mydatabase
sudo -u postgres psql
select current_database();
\c mydatabase
CREATE TABLE public.meme
(

    id  SERIAL PRIMARY KEY NOT NULL,

    name text COLLATE pg_catalog."default",

    caption text COLLATE pg_catalog."default",
	url text COLLATE pg_catalog."default"

)
TABLESPACE pg_default;

ALTER TABLE publicmeme

    OWNER to postgres;
	
\q

