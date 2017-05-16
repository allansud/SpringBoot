Projeto SpringBoot com Java
======================

Um projeto simples mostando como usar SpringBoot.

Dependencies included
---------------------

- Spring 4.3.5.RELEASE
- Spring data JPA 1.10.6.RELEASE
- Hibernate 5.0.11.Final
- MySQL 5.1.40
- Hikari CP 2.4.7
- Maven 3.1
- JDK 1.8

Requirements
------------
- Java 8
- Maven 3
- Tomcat7 (embedded)

Building
--------
- Via Eclipse:: Execute-o diretamente, nesse caso, o perfil padrão será usado. Caso você queira um perfil diferente para ser usado, crie uma configuração principal para a sua classe  	principal, especificando o perfil. Para fazer isso na barra de ferramentas, selecione  Run->Run Configurations->Arguments->VM Arguments. Add -Dspring.profiles.active=local or 	-Dspring.profiles.active=prod]
- Via Command line::
- On project root
- java -jar target/nameOfTheProjetct-1.0.0.jar –spring.profiles.active=local

After Deploy on Application Server
----------------------------------
- A aplicação pode ser consumida por Js, C#, java, python etc.
- Front-End não implementado, RestApiController