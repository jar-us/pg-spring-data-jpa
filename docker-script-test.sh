docker run -d \
    --name my-postgres-container-test \
    -e POSTGRES_PASSWORD=123 \
    -e POSTGRES_USER=spring-data-jpa-testuser \
    -e POSTGRES_DB=spring-data-jpa-playground-test \
    -p 5433:5432 \
    postgres