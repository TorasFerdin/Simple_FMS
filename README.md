In application.properties, you need to replace these 2 lines:
- spring.datasource.username=root
- spring.datasource.password=root
With your username and your password from MySQL

I changed the default port to 8082

If you create the DB with the same name as mine, then you don't have to change the DB name in the following line in application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/archety_fms?useSSL=false&allowPublicKeyRetrieval=true

In the file "CorsConfig", i allowed the origins "http://127.0.0.1:5500/" since i used VS Code for the Frontend with the Live Server extension.
