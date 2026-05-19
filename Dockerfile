# Fase de compilación
FROM eclipse-temurin:25-jdk-alpine AS build
WORKDIR /app
COPY . .
# Da permisos de ejecución al wrapper de gradle y construye el proyecto
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar -x test

# Fase de ejecución
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]