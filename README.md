# Лабораторная работа №2
## Настройка локальной среды разработки (Gradle)

Проект по дисциплине **«Система автоматизированного проектирования (САПР) схем»**.

## Требования

- JDK 21
- Gradle Wrapper (уже в проекте: `./gradlew`, `gradlew.bat`)
- Git (для клонирования проекта)

## Базовая структура проекта

```text
SAPR/
├── build.gradle.kts
├── settings.gradle.kts
├── gradle/wrapper/
├── gradlew
├── gradlew.bat
├── src/
│   ├── main/
│   │   ├── kotlin/stud/ganyushkin/sapr/SaprApplication.kt
│   │   └── resources/application.yaml
│   └── test/
│       └── kotlin/stud/ganyushkin/sapr/SaprApplicationTests.kt
└── README.md
```

## Запуск проекта локально

1. Перейти в корень проекта:

```bash
cd SAPR
```

2. Проверить Java:

```bash
java -version
```

Если версия не `21`, установите JDK 21 и настройте `JAVA_HOME`.
Для macOS пример:

```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 21)
```

3. Собрать проект и выполнить тесты:

```bash
./gradlew clean build
```

4. Запустить приложение:

```bash
./gradlew bootRun
```

После запуска приложение доступно по адресу `http://localhost:8080`.

## Полезные Gradle-команды

```bash
./gradlew tasks          # список задач
./gradlew test           # запуск тестов
./gradlew bootJar        # сборка исполняемого jar
./gradlew clean          # очистка артефактов сборки
```

## Запуск в Windows

Используйте аналогичные команды через `gradlew.bat`:

```bat
gradlew.bat clean build
gradlew.bat bootRun
```

## Примечание для сдачи лабораторной №2

В проекте используется **Gradle (Kotlin DSL)**, создана базовая структура каталогов `src/main` и `src/test`, присутствуют файлы конфигурации сборки (`build.gradle.kts`, `settings.gradle.kts`, `gradle/wrapper/*`) и подготовлен `README.md` с инструкцией по развертыванию.
