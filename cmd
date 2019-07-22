
启动 redis :
docker run -p 6379:6379 -v $PWD/data:/data -d redis redis-server --appendonly yes

启动 mongoDB :
docker run -p 27017:27017 -v $PWD/db:/data/db -d mongo

查询端口被占用
sudo lsof -i :9000
sudo kill -9 pid

所有端口
netstat -ntlp


80端口转发到8088端口
在root账户下面运行一下命令：
iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to-port 8088
