dockers=$(docker ps -a --format "{{.Names}}")
hasDocker="false"
for docker in $dockers
do
    if [ "$docker" = "chat-local-mongo" ]
    then
        hasDocker="true"
        echo "Container exists, starting"
        docker start chat-local-mongo
    fi
done

if [ "$hasDocker" = "false" ]
then
    echo "Create container, starting"
    docker run --name chat-local-mongo -d -p 127.0.0.1:27017:27017 mongo
fi

docker container ps