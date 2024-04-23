docker run -d \
    --name my-postgres-container \
    -e POSTGRES_PASSWORD=123 \
    -e POSTGRES_USER=spring-data-jpa-user \
    -e POSTGRES_DB=spring-data-jpa-playground \
    -p 5432:5432 \
    postgres