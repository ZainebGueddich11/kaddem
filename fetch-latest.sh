#!/bin/sh

# Fetching the metadata to get the latest version
latest_version=$(curl -s 'http://192.168.1.25:8081/repository/maven-snapshots/tn/esprit/spring/kaddem/maven-metadata.xml' | grep -oP '<latest>.*?</latest>' | grep -oP '>.*?<' | sed 's/[><]//g')

# Downloading the latest version of the JAR file
wget "http://192.168.1.25:8081/repository/maven-snapshots/tn/esprit/spring/kaddem/$latest_version/kaddem-$latest_version.jar" -O /kaddem-latest.jar

# Running the application with the downloaded JAR
java -jar /kaddem-latest.jar
