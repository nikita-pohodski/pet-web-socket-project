call mvn -f pom.xml clean package -DskipTests

docker-compose build
docker-compose up -d