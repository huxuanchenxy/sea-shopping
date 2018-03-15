### springcloud eureka高可用集群 案例
eureka的高可用、服务提供者的高可用

### 启动步骤
1、首先在本地电脑的host文件中，配置好虚拟域名；
> 虚拟域名需要与sea-server-eureka、sea-service-user、sea-web-shop中application.yml中配置的eureka.client.service-url.defaultZone的域名一致；
 
我本地host文件中的配置如下（注意中间空格）：
```
127.0.0.1 server.eureka.slave1.com server.eureka.slave2.com
```
<br/>

2、启动eureka服务器，运行\sea-server-eureka\src\main\java\pers\zb\server\eureka\EurekaServer.java 中的main方法；
```
（建议运行至少2个eureka服务器节点，方可看到高可用效果）
```
<br/>

3、启动user服务，运行\sea-service-user\src\main\java\pers\zb\service\user\UserServiceApplication.java 中的main方法；
```
（建议运行至少2个user服务节点，方可看到高可用效果）
```
<br/>

4、启动服务调用者，运行\sea-web-shop\src\main\java\pers\zb\web\shop\ShopApplication.java 中的main方法；

<br/>

5、浏览器输入访问 http://127.0.0.1:8088/router 查看调用效果；
```
观察浏览器的输出内容，通过 msg 的值，可以看到其中的端口号发生了变化，也就说明调用了不同的user服务者节点
```

### 打开eureka控制台，查看高可用集群节点信息
> 根据在\sea-server-eureka\src\main\resources\application.yml中配置的eureka服务器的地址，在浏览器中输入：
<br/> http://127.0.0.1:18761 或者 http://127.0.0.1:28761 即可查看eureka的集群信息
<br/> 其中，18761和28761代表不同的eureka服务器的端口号


