sudo apt install -y maven
sudo apt install -y openjdk-8-jre-headless
cd aseef-crio-meme-backend
mvn install
cd ..
sudo apt install -y postgresql postgresql-contrib
sudo -u postgres createdb mydatabase
sudo -u postgres -H -- psql -d database_name -c "CREATE TABLE public.meme(id  SERIAL PRIMARY KEY NOT NULL,name text,caption text,url text ) TABLESPACE pg_default;"

sudo -u postgres -H -- psql -d database_name -c "ALTER TABLE publicmeme OWNER to postgres;"


