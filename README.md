# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.freedom.java-code-simple' is invalid and this project uses 'com.freedom.javacodesimple' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.1-SNAPSHOT/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.1-SNAPSHOT/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.1-SNAPSHOT/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

## 以阿里云服务器部署为例
### LINUX下运行
```
运行-1:
$ wget https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
$ tar -xvf apache-maven-3.6.3-bin.tar.gz
$ mv apache-maven-3.6.3 /opt/

Step 2: Setting M2_HOME and Path Variables
Add the following lines to the user profile file (.profile).

运行-2:
M2_HOME='/opt/apache-maven-3.6.3'
PATH="$M2_HOME/bin:$PATH"
export PATH

Relaunch the terminal or execute source .profile to apply the changes.

更新settings.xml源，参考 -> https://segmentfault.com/a/1190000022529672

mvn versions:display-dependency-updates

wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz
tar xf jdk-17_linux-x64_bin.tar.gz
mv jdk-17.0.3/ /usr/lib/jvm

运行-3:
mvn -N io.takari:maven:wrapper
mvn install
mvn package

```

### USAGE
```
mvn spring-boot:run
./mvnw spring-boot:run

```