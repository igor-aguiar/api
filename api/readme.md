# What we studied in this project:  

- API REST
- C.R.U.D.(create/read/update/delete) operation
- Migration
- Record
- Pageable endpoint
- Response Entity

>### Migration :
> 1. using spring we just need to add the dependecy on the pom.xml file when using maven
> 2. create the directory /db/migration inside resource directory.
> 3. All migrations should be name {prefix}{version}__{migration-name}.sql where 
>    1. prefix will always be "V"
>    2. version must start with "1" and after you can work around with it
>       1. if the new migration is a minor update you should use one underscore "1_1_3" and name should be written in snake case.
>    3. Example: 
>       1. V1__create_table_xpto.sql
>       2. V1_1_3__alter_table_xpto_insert_acme_field.sql
> 
> If some migration fail to update you can reset the "flyway_scheme_history" by running an delete query onde your SGBD, 
>  - ex(MySql): **"delete from flyway_scheme_history where success=0"** where it will delete only the failed migrations


>### Record :
> Record works like a DTO class, but works only in Java 17+ and works with constructor not methods.
> Go to [Record Baeldung](https://www.baeldung.com/java-record-keyword) for more information

>### Pageable :  
> you should use an Pageable class as parameter for the method GET (`public Page<ListDoctorsData> retrieveAllDoctor(Pageable pageable)`), so it can read URI parameters like size, page.
> - Ex: http://localhost:8080/doctor?size=2 will return this JSON
> - `{
    "content": [
    {
    "name": "Igor",
    "crm": "123456",
    "email": "igor@gmail.com",
    "specialization": "ORTOPEDY"
    },
    {
    "name": "Igor",
    "crm": "123456",
    "email": "igors@gmail.com",
    "specialization": "ORTOPEDY"
    }
    ],
    "pageable": {
    "sort": {
    "empty": true,
    "sorted": false,
    "unsorted": true
    },
    "offset": 0,
    "pageNumber": 0,
    "pageSize": 2,
    "unpaged": false,
    "paged": true
    },
    "last": false,
    "totalPages": 2,
    "totalElements": 4,
    "size": 2,
    "number": 0,
    "sort": {
    "empty": true,
    "sorted": false,
    "unsorted": true
    },
    "first": true,
    "numberOfElements": 2,
    "empty": false
    }`
 
>### Response Entity class:  
> -Used to return the HTTP verbs correct in the response, where you can work around with than, as in the POST methos where you will return the entity persisted using a record to export the data avoiding using the actual persisted entity.

#### Spring Properties
- You can find spring application.properties at [Spring Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.server)