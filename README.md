## Running the application locally

To run jazz system locally, complete the following steps:

### Prerequisites

You have to install the following software components to set up project environment locally:

* JDK 17
* Apache Maven
* Docker Desktop

#### Start

Check the current java version:

```
java -version
```

If the current version is different from 17, set up the `JAVA_HOME` variable to java 17, because
maven uses the `JAVA_HOME` variable for build and execute.

If the current version is 17 just run the following command

```
mvn clean package
```

Enter 'help' if you need to see SSHCommand list

Run docker compose command

```
docker-compose up --build
```

To use pgAdmin use link 'http://localhost/browser/', enter email 'admin@mymail.ru' and 
password 'adminpassword', to enter postres server enter 'postgres'
