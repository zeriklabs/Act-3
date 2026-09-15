# ── Etapa 1: Build del JAR con Maven ──────────────────────────
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copiar archivos de Maven primero (cache de dependencias)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Descargar dependencias (cacheadas si pom.xml no cambia)
RUN ./mvnw dependency:go-offline -B

# Copiar código fuente y compilar
COPY src src
RUN ./mvnw package -DskipTests -B

# ── Etapa 2: Imagen final ligera ───────────────────────────────
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiar solo el JAR generado
COPY --from=build /app/target/*.jar app.jar

# Puerto expuesto (Render lo sobreescribe con $PORT)
EXPOSE 8080

# Arrancar con perfil de produccion
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]
