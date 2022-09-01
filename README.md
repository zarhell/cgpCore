# CGP Back end

## Herramientras de desarrollo empleadas

### FrameWork
-   [Java V8](https://www.java.com/es/download/ie_manual.jsp)
-   [Spring boot](https://spring.io/projects/spring-boot)
-   [javax validation](https://www.baeldung.com/javax-validation)
-   [Jackson Annotation](https://www.baeldung.com/jackson-annotations)
-   [hibernate validator](https://hibernate.org/validator/)
-   [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
-   [Spring Boot Dev Tools](https://www.baeldung.com/spring-boot-devtools)
-   [JUnit 5](https://junit.org/junit5/docs/current/user-guide/)
-   [Project Lombok](https://projectlombok.org/)
-   [Slf4j](https://www.slf4j.org/)

### Base de Datos   

-   [PostgreSQL](https://www.postgresql.org/)
-   [PgAdmin](https://www.pgadmin.org/)
-   [Flyway DB](https://flywaydb.org/)

### Despliegue en Producción
-   [Heroku](https://www.heroku.com/home)



## Para construir y ejecutar la aplicación se necesita tener instalado:

- [JDK 1.8](https://www.oracle.com/java/technologies/downloads/#java8)
- [Maven 3](https://maven.apache.org)
- [Git](https://git-scm.com/downloads)
- [VsCode](https://code.visualstudio.com/#alt-downloads)


###   Swagger Documentation 

-   [Swagger documentation](https://tripulantes.herokuapp.com/swagger-ui/index.html#/document-storage-controller/documentUpload)



### Para para abrir el proyecto:

1)  Abrir y configurar VsCode con las siguientes extensiones:
  
    - [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack)
    - [Language Support for Java(TM) by Red Hat](https://marketplace.visualstudio.com/items?itemName=redhat.java)

2)  En la línea de comandos de la terminal de su elección ejecutar:
    
    ```sh
    git clone url
    ```

3) En VsCode con STS, en el direcorio donde se ejecuto el comando del paso 2:
   
    ```sh
    File -> Open folder -> Select and open cloned Repository
    ```
4)  En la línea de comandos de la terminal de su elección ejecutar:
    
    ```sh
    mvn clean install -DskipTests
    ```

5) En VsCode:
    
    ```sh
    Presionar F5 o Utilizar el botón "Run" de la Spring Boot Dashboard en el Explorador de VsCode
    ```
    
### Para para probar el proyecto: 


###  Colleccion POSTMAN para pruebas en maquina: 

- [PostMan collection](https://www.getpostman.com/collections/edf5e231fa09adb0a63b)


###  Endpoints para probar en ambiente de Producción: 

####   /api/upload-documet : 
    
    ```
    curl --location --request PUT 'https://tripulantes.herokuapp.com/api/document/1abc' \
--header 'Content-Type: multipart/form-data;boundary=<calculated when request is sent>' \
--form 'file=@"/D:/Documentos/2019-07-23-FORMATO-CESION-DE-CONTRATO-V2.pdf"' \
--form 'request_body="{
  \"document_properties\": {
    \"document_type\": \"0\",
    \"document_area\": {
      \"original_area_code\": \"originalAreaCode\",
      \"destination_area_code\": \"destinationAreaCode\",
      \"area_name\": \"areaName\"
    },
    \"documental_user\": {
      \"user_origin_code\": \"userOriginCode\",
      \"user_destiny_code\": \"userDestinyCode\",
      \"user_lend_code\": \"lendUserCode\"
    },
    \"correspondence_type\": \"INTERN\",
    \"document_priority\": \"MEDIUM\",
    \"printed_tag\": \"printedTag\",
    \"documental_dates\": {
      \"document_creation_details\": \"2017-01-01 20:00\",
      \"document_storage_details\": \"2017-01-01 20:00\",
      \"document_sharing_details\": \"2018-01-01 20:00\",
      \"document_delivery_date_details\": \"2019-01-01 20:00\",
      \"document_archival_date_details\": \"2019-01-01 20:00\",
      \"document_destruction_details\": \"2019-01-01 20:00\",
      \"document_modification_date_details\": \"2019-01-01 20:00\"
    },
    \"document_name\": \"documentHostedUrl\",
    \"observations\": \"Observations\"
  }
}
"'

    ```
    
####   /api/download-document : 
    
        ```
        curl --location --request GET 'http://localhost:8080/api/document/?storage_id=759444949&user_lend_code="zrz_leng_code"'
        
        ```
        



