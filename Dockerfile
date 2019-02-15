FROM java:openjdk-8-jre

ENV SLEEP=0

# add directly the war
ADD ./target/*.jar /app.jar

#EXPOSE 8080 5701/udp
CMD ./app.jar
