查看某个端口号 netstat -ano | findstr 1883
杀死进程 taskkill /pid xxx -f
查看所有进程 tasklist
查看进程号对应的执行文件 tasklist |findstr 8836

启动 mqtt mosquitto -c mosquitto.conf -v
设置mqtt登录用户以及密码 mosquitto_passwd -c pwfile.example admin
mqtt发布消息 mosquitto_pub.exe -t sensor -m wo -u admin -P dynabook
mqtt订阅消息 mosquitto_sub -t sensor  -u admin -P dynabook
mosquitto_sub.exe -d -v -h SCD-ZhangL-P01 -p 1883 -t aa --cafile ca.crt -u admin -P dynabook

mosquitto_sub.exe -d -v -h SCD-ZhangL-P01 -p 1883 -t aa --cafile ca.crt --cert client.crt --key client.key
mosquitto_pub.exe -d -h SCD-ZhangL-P01 -p 1883 -t aa -m hellomqtt --cafile ca.crt -u admin -P dynabook
mosquitto_pub.exe -d -h SCD-ZhangL-P01 -p 1883 -t aa -m hellomqtt --cafile ca.crt --cert client.crt --key client.key

查看数据库安装路径 SELECT @@basedir as path from DUAL
查看数据库版本 SELECT VERSION()
查看主机名称 hostname

（2）开通服务器防火墙对应的端口

使用如下命令开通80端口

firewall-cmd --zone=public --add-port=80/tcp --permanent
参数说明：

--zone   # 作用域

--add-port=80/tcp  # 添加端口，格式为：端口号/通信协议

--permanent  # 永久生效，没有此参数重启后失效

 

centenos7操作防火墙的其它命令：

查询某一个端口是否开启（如：查询80）：firewall-cmd --query-port=80/tcp

查询哪些防火墙端口开放：firewall-cmd --list-port

重启防火墙：firewall-cmd --reload

禁止开机启动防火墙：systemctl disable firewalld.service

允许开机启动防火墙：systemctl enable firewalld.service

查看防火墙状态：firewall-cmd --state

关闭端口号（如：关闭80端口）：firewall-cmd --zone=public --remove-port=80/tcp
