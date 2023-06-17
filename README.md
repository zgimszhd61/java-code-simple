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

yum install git maven

运行-1:
$ wget https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
$ tar -xvf apache-maven-3.6.3-bin.tar.gz
$ mv apache-maven-3.6.3 /opt/

地址为：
rm -rf /opt/apache-maven-3.6.3/conf/settings.xml
vi /opt/apache-maven-3.6.3/conf/settings.xml
更新settings.xml源，参考 -> https://www.cnblogs.com/sunxun001/p/17021432.html

wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz
tar xf jdk-17_linux-x64_bin.tar.gz
mv jdk-17.0.7/ /usr/lib/jvm

vi /etc/profile
#set java environment(保存下面信息到/etc/profile末尾)
export M2_HOME='/opt/apache-maven-3.6.3'
export JAVA_HOME=/usr/lib/jvm/jdk-17.0.7
export CLASSPATH=$JAVA_HOME/lib/tools.jar:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib
export PATH=$M2_HOME/bin:$JAVA_HOME/bin:$PATH

source /etc/profile



git clone https://github.com/zgimszhd61/java-code-simple.git
cd java-code-simple

运行-3:
mvn install
mvn package

```

### USAGE
```
mvn spring-boot:run
./mvnw spring-boot:run

```