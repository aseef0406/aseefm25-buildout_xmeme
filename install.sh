sudo apt install -y maven
sudo apt install -y openjdk-8-jre-headless
cd aseef-crio-meme-backend
mvn install
cd ..
sudo apt install -y postgresql postgresql-contrib
export PGPASSWORD="PASSWORD"
sudo -u postgres psql -c "ALTER USER postgres WITH ENCRYPTED PASSWORD '${PGPASSWORD}';"
sudo -u postgres createdb mydatabase
sudo -u postgres -H -- psql -d mydatabase -c "CREATE TABLE public.meme(id  SERIAL PRIMARY KEY NOT NULL,name text,caption text,url text ) TABLESPACE pg_default;"

sudo -u postgres -H -- psql -d mydatabase -c "ALTER TABLE public.meme OWNER to postgres;"


