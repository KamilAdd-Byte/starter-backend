#!/bin/bash

set -e

echo "Building rye starter backend app project..."
./gradlew clean build

echo "Building the Docker image..."
docker build -t rye-starter .

echo "Running the Docker container..."
docker run -d -p 40075:40075 --name rye-starter rye-starter