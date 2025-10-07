FROM openjdk:17-jdk-slim

# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["mvn", "jetty:run"]

CMD ["mvn", "jetty:run", "-Djetty.http.host=0.0.0.0", "-Djetty.http.port=8080"]