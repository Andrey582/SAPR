# Лабораторная работа №2
## Настройка локальной среды разработки для проекта САПР схем

**Дисциплина:** Система автоматизированного проектирования (САПР) схем  
**Технология сборки:** Gradle (Kotlin DSL)  
**Дата выполнения:** 23.03.2026

## 1. Цель работы

Настроить локальную среду разработки для проекта:
- создать/проверить базовую структуру каталогов;
- подготовить файлы конфигурации сборки Gradle;
- оформить `README.md` с инструкцией по развертыванию.

## 2. Базовая структура каталогов

В проекте используется следующая структура:

```text
SAPR/
├── build.gradle.kts
├── settings.gradle.kts
├── gradle/wrapper/gradle-wrapper.jar
├── gradle/wrapper/gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── src/main/kotlin/stud/ganyushkin/sapr/SaprApplication.kt
├── src/main/resources/application.yaml
├── src/test/kotlin/stud/ganyushkin/sapr/SaprApplicationTests.kt
└── README.md
```

## 3. Конфигурация сборки Gradle

Используются основные файлы конфигурации:
- `build.gradle.kts` — зависимости, плагины, настройки сборки и тестов;
- `settings.gradle.kts` — имя корневого проекта;
- `gradle/wrapper/*` — фиксированная версия Gradle для одинаковой сборки у всех участников.

В проекте настроены:
- Spring Boot plugin;
- Kotlin JVM и Kotlin Spring plugins;
- Java Toolchain 21;
- JUnit 5 для тестирования.

## 4. Инструкция по развертыванию

Инструкция подготовлена в файле:
- `README.md`

В README описаны:
- требования к окружению (JDK 21);
- команды сборки и тестирования (`./gradlew clean build`);
- команда запуска (`./gradlew bootRun`);
- полезные Gradle-команды и запуск в Windows.

## 5. Результат

Локальная среда разработки для проекта настроена с использованием **Gradle**: базовая структура каталогов подтверждена, конфигурация сборки оформлена, `README.md` с инструкцией по развертыванию подготовлен.
