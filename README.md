# Kuro2EncrypterTool
### Description: 
Simple algorithm for encrypting text, based on the hexadecimal system. This console application works as a password manager using the kuro algorithm to encrypt text and store it in a database.

### Features:
* Algorithm written from scratch using raw JAVA
* MySQL Database

### Technologies:
JAVA 8, MySQL

### Preview:
<p> <img src="https://github.com/kuronneko/kuro2et/blob/master/kuro2et.png" width="450"> </p>

### How to use/install
* Load project with netbeans
* Add mysql-connector-java-8.0.27.jar to project
* Create a database
```
CREATE TABLE `filek2et` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `text` text NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
ADD PRIMARY KEY (`id`)
);
```
* Set DB params at config.properties
* Open Netbeans project and add mysql-connector
* Compile and execute
```
java -jar kuro2et.jar
```
 

