#!/bin/bash

while true; do
    docker build -t jenkins:jcasc .
    
    sudo docker run --name jenkins --rm -p 8080:8080 --env-file test.env jenkins:jcasc
    
    if [ $? -ne 0 ]; then
        echo "An error occurred. Checking for conflicts..."

        CONFLICTING_CONTAINER=$(sudo docker ps -a -q -f name=jenkins)
        if [ -n "$CONFLICTING_CONTAINER" ]; then
            echo "Removing conflicting container (ID: $CONFLICTING_CONTAINER)..."
            sudo docker rm -f $CONFLICTING_CONTAINER
        fi

        PID=$(sudo lsof -t -i:8080)
        if [ -n "$PID" ]; then
            echo "Stopping process using port 8080 (PID: $PID)..."
            sudo kill -9 $PID
        else
            echo "No process found using port 8080."
        fi
        
        clear
        echo "Restarting the program..."
    else
        echo "Program executed successfully. Exiting loop."
        break
    fi
done
