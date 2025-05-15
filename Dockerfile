# 1) Build stage
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /workspace

# 1-1) Gradle wrapper 및 설정만 먼저 복사 → 의존성만 설치
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./
RUN chmod +x gradlew \
 && ./gradlew dependencies --no-daemon

# 1-2) 실제 소스 복사 및 빌드
COPY src src
RUN ./gradlew clean bootJar --no-daemon

# 2) Runtime stage
FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY --from=builder /workspace/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]