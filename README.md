## 以阿里云服务器部署为例
### LINUX下运行
```
## 下载基本环境和依赖:

yum install git maven -y
wget https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
tar -xvf apache-maven-3.6.3-bin.tar.gz
mv apache-maven-3.6.3 /opt/
wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz
tar xf jdk-17_linux-x64_bin.tar.gz
mv jdk-17.0.7/ /usr/lib/jvm

## 更新配置

rm -rf /opt/apache-maven-3.6.3/conf/settings.xml
vi /opt/apache-maven-3.6.3/conf/settings.xml
更新settings.xml源，参考settings这个标题

vi /etc/profile
#set java environment(保存下面信息到/etc/profile末尾)
export M2_HOME='/opt/apache-maven-3.6.3'
export JAVA_HOME=/usr/lib/jvm/jdk-17.0.7
export CLASSPATH=$JAVA_HOME/lib/tools.jar:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib
export PATH=$M2_HOME/bin:$JAVA_HOME/bin:$PATH

source /etc/profile

## 下载文件包
git clone https://github.com/zgimszhd61/java-code-simple.git
cd java-code-simple

## 试编译运行:
mvn install
mvn package

```

### USAGE
```

mvn spring-boot:run

```

### 注意
```

打开的是8080端口，如果用的是阿里云，需要注意安全组允许8080端口被访问
如果想要启动的是80端口，那么pom.xml的配置需改一下

```

### settings.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">

  <mirrors>
    <mirror>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云公共仓库</name>
     <url>https://maven.aliyun.com/repository/public</url>
    </mirror>
     <mirror>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云谷歌仓库</name>
     <url>https://maven.aliyun.com/repository/google</url>
    </mirror>
    <mirror>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云阿帕奇仓库</name>
     <url>https://maven.aliyun.com/repository/apache-snapshots</url>
    </mirror>
    <mirror>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云spring仓库</name>
     <url>https://maven.aliyun.com/repository/spring</url>
    </mirror>
    <mirror>
     <id>aliyunmaven</id>
     <mirrorOf>*</mirrorOf>
     <name>阿里云spring插件仓库</name>
     <url>https://maven.aliyun.com/repository/spring-plugin</url>
    </mirror>
   </mirrors>
</settings>
```

## 如果80或8080端口被占用
```

运行 lsof -i:8080 ， 得到PID进程号
kill -9 PID进程号 ，杀掉进程
然后重新运行

```