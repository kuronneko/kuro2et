# Kuro2EncrypterTool
Simple algorithm to encrypt text, base on the hexadecimal system. This console app works like Password Manager using the kuro algorithm to encrypt text and store it on a database.

* Algorithm written from scratch using raw JAVA
* MySQL Database
* Has a GUI Offiline Swing version https://github.com/kuronneko/Hex-to-String


### Preview
<p> <img src="https://github.com/kuronneko/kuro2et/blob/master/kuro2et.png" width="450"> </p>

### How to use
`1.` Required

    JRE 8
    mysql-connector-java-8.0.27.jar

`2.` Create a database

    CREATE TABLE `filek2et` (
    `id` int(11) NOT NULL,
    `name` varchar(200) NOT NULL,
    `text` text NOT NULL,
    `created_at` timestamp NULL DEFAULT NULL,
    `updated_at` timestamp NULL DEFAULT NULL,
     ADD PRIMARY KEY (`id`)
    );
    
`3.` Set DB params at config.properties

`4.` Open Netbeans project and add mysql-connector

`5.` Compile and execute

    java -jar kuro2et.jar
 

