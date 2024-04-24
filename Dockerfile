FROM openjdk:17

# Устанавливаем Maven
RUN apt-get update && apt-get install -y maven

# Устанавливаем рабочий каталог в /app
VOLUME /app
WORKDIR /app

# Копируем файлы Maven в контейнер и выполняем сборку проекта
COPY . .
RUN mvn clean package

# Устанавливаем рабочий каталог для запуска приложения
WORKDIR /software_phoenix

# Копируем собранный JAR-файл в контейнер
COPY ./target/software_phoenix-0.0.1-SNAPSHOT.jar .

# Указываем точку входа для запуска приложения
ENTRYPOINT ["java", "-jar", "software_phoenix-0.0.1-SNAPSHOT.jar"]
