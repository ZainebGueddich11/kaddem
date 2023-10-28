FROM openjdk:8-jdk-alpine
EXPOSE 8089
# Add a script to fetch the latest JAR version
ADD fetch-latest.sh /fetch-latest.sh

# Make the script executable
RUN chmod +x /fetch-latest.sh
# Set the script as the entry point
ENTRYPOINT ["/fetch-latest.sh"]


