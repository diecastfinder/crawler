# Crawler

## Configuration in IntelliJ
1. Add "local-discovery" to Active profiles

## How to run application
1. Run Docker (Docker Decktop for Win OS)
2. Run artemis container: docker run --detach --name mycontainer -p 61616:61616 -p 8161:8161 --rm apache/activemq-artemis:latest-alpine
3. Run project eurekareganddiscovery, check http://localhost:8761
4. Run [CatalogApplication.java](src%2Fmain%2Fjava%2Forg%2Fdiecastfinder%2Fcatalog%2FCatalogApplication.java) .main(). 