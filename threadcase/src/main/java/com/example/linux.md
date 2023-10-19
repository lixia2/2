
journaactl -r 从新到旧系统日志
tar zxvf nginx-1.18.0.tar.gz 解压
https://blog.csdn.net/steve_frank/article/details/125130439 nginx安装命令
chmod +x  /home/mydata/mts/mqtt/config/mosquitto.conf

启动mysql: docker run  -p 3306:3306 -v /home/mydata/mysql/conf/my.cnf:/etc/mysql/my.cnf -v /home/mydata/mysql/data:/mydata/mysql/data  -e MYSQL_ROOT_PASSWORD='123456' --name=mysql-test mysql

查看版本nginx版本 docker image inspect nginx:latest | grep -i version
查看redis版本 docker exec -it myredis redis-server -v
查看mqtt版本 docker image inspect eclipse-mosquitto:latest | grep -i version



