# Сначала выбираем образ с Maven для сборочного этапа
FROM maven:3.8.4-openjdk-17 AS build

# Установка рабочего каталога
WORKDIR /app

# Копирование файла pom.xml для загрузки зависимостей
COPY pom.xml .

# Загрузка зависимостей Maven (это ускорит процесс сборки, если файлы pom.xml не изменялись)
RUN mvn dependency:go-offline -B

# Копирование остальных файлов проекта и выполнение сборки
COPY src ./src
RUN mvn package -DskipTests

# Создание финального образа с JRE
FROM openjdk:17-jdk-slim

# Установка рабочего каталога
WORKDIR /app

# Копирование собранного JAR-файла из сборочного этапа
COPY --from=build /app/target/software_phoenix.jar app.jar

# Определение точки входа для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]

# Опционально: открываем порт, если ваше приложение слушает на определенном порту
EXPOSE 8080
