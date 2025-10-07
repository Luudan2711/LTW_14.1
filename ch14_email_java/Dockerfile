FROM maven:3.9-openjdk-17

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["mvn", "jetty:run", "-Djetty.http.host=0.0.0.0", "-Djetty.http.port=8080"]