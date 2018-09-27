### springcloud-practice

- 注册中心：http://localhost:10000/
- 监控：http://192.168.3.240:10002/actuator/health
- 接口：http://192.168.3.240:10010/swagger-ui.html
- 数据库连接池：http://192.168.3.240:10010/druid/index.html

- init spring boot project
- init eureka server
- init service project
- maven 
- actuator
- spring boot admin
- druid
- mybatis spring boot
- mybatis mapper
- mybatis pagehelper
- mybatis generate  
- json
- log
- aop
- ...

   
  
#### server
- ECS
- sql server
- Redis
- Kafka
- qiniu/OSS
- CDN
- solr

---
#### 初始化服务器环境
- 购买数据盘    

	Linux 格式化和挂载数据盘： https://help.aliyun.com/document_detail/25426.html

	挂载数据盘到/data目录：  
	`mount /dev/sdb1 /data`  

	开机自动挂载  
	`vi /etc/fstab
	/dev/sdb1       /data   ext4    defaults        1       1
	`

	查看磁盘状况：  
	`df -h`

- 创建用户和用户组  

	用户列表文件：# vi /etc/passwd
	用户组列表文件：# vi /etc/group

	1. 创建用户组dev   
	`groupadd dev`
	
	2. 创建用户lastName.firstName    
	`adduser lastName.firstName`  
	`passwd lastName.firstName`
	
	3. 将用户scp加入dev组  
	`usermod -G dev lastName.firstName`
	
	4. 修改/data目录用户组和权限  
	`chown -R :dev /data`  
	`chmod -R 775 /data`

- 防火墙设置
	
	1. 开启防火墙：`systemctl start firewalld`

	2. 查看防火墙状态：`systemctl status firewalld` 

	3. 开启端口：`firewall-cmd --zone=public --add-port=80/tcp --permanent`  
	命令含义：
	--zone #作用域
	--add-port=80/tcp #添加端口，格式为：端口/通讯协议
	--permanent #永久生效，没有此参数重启后失效

	4. 重启防火墙：`firewall-cmd --reload` 

---
#### 软件安装
- jdk

- nginx

- redis

- kafka

- tomcat

- solr

---
### 服务部署


- 创建目录  
	`mkdir /data/scp/${scp-service-name}/services`  
	`mkdir /data/scp/${scp-service-name}/logs`

- 在/etc/init.d/目录创建${scp-service-name}脚本

- 设置权限 
	`chmod +x /etc/init.d/${scp-service-name}`

- 运行启动/停止/重启命令
	`sudo service ${scp-service-name} start`

- 设置开机启动  
	`chkconfig --add ${scp-service-name}`  
	`chkconfig ${scp-service-name} on`

- 在项目根目录下运行package.bat， 会在target目录下生成${scp-service-name}.jar文件

- 将${scp-service-name}.jar文件上传到/data/scp/${scp-service-name}/services目录  

- 拷贝 scp-XXX-config.yml 到/data/scp/${scp-service-name}/services目录  

- 运行启动/停止/重启命令  
	`sudo service ${scp-service-name} restart`

- 查看日志，确定启动是否正常  
	系统错误日志：/data/scp/scp-XXX-service/logs/scp-sys.err  
	垃圾回收日志：/data/scp/scp-XXX-service/logs/scp-gc.log  
	应用日志：/data/scp/${scp-service-name}/logs/${scp-service-name}-yyyy-MM-dd.log  

- 开放需要的端口  
	`sudo firewall-cmd --zone=public --add-port=${scp-service-port}/tcp --permanent`
	`sudo firewall-cmd --reload`


- 创建nginx目录  
	`mkdir /usr/local/nginx/conf/vhost`  

- 拷贝 ${scp-service-name}.conf 到/usr/local/nginx/conf/vhost目录  

- 生效配置：  
	`service nginx reload`

- 参考文档：https://segmentfault.com/a/1190000003944843


####  RESTFUL架构规范

###### HTTP动词
> GET（SELECT）：从服务器取出资源（一项或多项）。   
POST（CREATE）：在服务器新建一个资源。   
PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）。   
PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。   
DELETE（DELETE）：从服务器删除资源。   

###### 1. 资源（resource），统一采用复数形式，比如topics、dynamics、comments
> GET /topics # 获取topic列表
GET /topics/12 # 查看某个具体的topic    
POST /topics # 新建一个topic       
PUT /topics/12 # 更新topic 12       
DELETE /topics/12 #删除topic 12       

###### 2. 子资源, 比如某个话题下的文章列表
> GET /topics/12/article

###### 3.action，比如点赞、搜索
> PUT /article/12/praise #点赞       
DELETE /article/12/praise #取消点赞      
GET /article/search #搜索       

###### 4.版本
> https://api.scp.com/v1/