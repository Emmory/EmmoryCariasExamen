# Usar una imagen base con JDK y Maven
FROM maven:3.8.6-eclipse-temurin-17 AS build

# Crear directorio dentro del contenedor
WORKDIR /app

# Copiar el pom.xml y descargar dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el resto del código
COPY src ./src

# Empaquetar el proyecto (esto genera un .jar en /target)
RUN mvn clean package -DskipTests

# Etapa final: solo con JDK para correr la app
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copiar el jar del build anterior
COPY --from=build /app/target/*.jar app.jar

# Puerto en el que corre tu app
EXPOSE 8081

# Comando para ejecutar
ENTRYPOINT ["java", "-jar", "app.jar"]
