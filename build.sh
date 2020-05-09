#!/bin/bash



container=$(sudo docker ps | awk 'NR>1 {print $1}')

# if exists a container stop it
if [[ -n "$container" ]]; then
  echo "Stopping previuos container $container"
  (sudo docker stop $container) > /dev/null
  echo  "ok"
fi

# create container from docker file
echo "Building container"
sudo docker build -t "jso-jobapplication-ms" ./ > /dev/null
echo "ok"


# TODO Add other env
# run the container created
echo "Starting container"
sudo docker run -e AWS_DYNAMODB_HOST --detach -p 8081:8081 jso-jobapplication-ms > /dev/null
echo "ok"
