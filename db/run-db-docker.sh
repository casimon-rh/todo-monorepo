docker run -d --name postgresql_database \
  -e POSTGRESQL_USER=hibernate \
  -e POSTGRESQL_PASSWORD=hibernate \
  -e POSTGRESQL_DATABASE=hibernate_db -p 5432:5432 \
  registry.access.redhat.com/rhscl/postgresql-10-rhel7:latest