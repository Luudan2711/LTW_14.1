# Sử dụng OpenJDK 17 làm base image
FROM openjdk:17-jdk-slim

# Thiết lập thư mục làm việc
WORKDIR /app

# Copy Maven wrapper và pom.xml
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
COPY pom.xml .

# Cấp quyền thực thi cho Maven wrapper
RUN chmod +x mvnw

# Download dependencies (cache layer)
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Build ứng dụng
RUN ./mvnw clean package -DskipTests

# Expose port mà ứng dụng sẽ chạy
EXPOSE 8080

# Set default values for environment variables
ENV JETTY_HOST=0.0.0.0
ENV JETTY_PORT=8080

# Command để chạy ứng dụng với Jetty embedded
CMD ["sh", "-c", "./mvnw jetty:run -Djetty.http.host=${JETTY_HOST} -Djetty.http.port=${PORT:-${JETTY_PORT}}"]