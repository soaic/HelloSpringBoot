
启动 redis :
docker run -p 6379:6379 -v $PWD/data:/data -d redis redis-server --appendonly yes

启动 mongoDB :
docker run -p 27017:27017 -v $PWD/db:/data/db -d mongo

查询端口被占用
sudo lsof -i :9000
sudo kill -9 pid