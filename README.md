Тестовое задание

Спроектировать(продумать формат и ограничения входящих/исходящих параметров) и реализовать REST API, вычисляющее частоту встречи символов по заданной строке. Результат должен быть отсортирован по убыванию количества вхождений символа в заданную строку.

Пример входной строки: “aaaaabcccc”
Пример выходного результата: “a”: 5, “c”: 4, “b”: 1

Используемые технологии:
- Java 17
- Spring Boot 3
- Swagger
- Lombok
- Junit, Mockito
- Docker

Запуск приложения :

- скачать образ с помощью команды: docker pull tatiby/testinternshipt1:1.1
- запустить контейнер на основе образа с помощью команды: docker run -d -p 8085:8085 tatiby/testinternshipt1:1.1

Либо:

- Скачать или склонировать репозиторий приложения в программу IntelliJ IDEA

- Упаковать проект в Maven

- В терминале в корне приложения выполнить команду docker build ./

- Упаковать образ в контейнер командой docker-compose build

- Запустить контейнер командой docker-compose up


Swagger досупен по адресу:
- http://localhost:8085/swagger-ui/index.html#/