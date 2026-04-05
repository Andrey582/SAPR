# Лабораторная работа №10
## Поиск преднамеренно внедренной логической ошибки с помощью отладчика IDE

**Дисциплина:** Система автоматизированного проектирования (САПР) схем  
**Дата выполнения:** 06.04.2026

## 1. Цель работы

Внедрить в код преднамеренную логическую ошибку и подготовить воспроизводимый сценарий ее поиска с помощью встроенного отладчика IDE.

## 2. Внедренная ошибка

Ошибка внесена в метод:

- `CircuitAnalysisService.findInvalidConnectionIds(...)`

Суть ошибки:

- условие проверки некорректного соединения изменено так, что соединение с отсутствующим только `source` больше не считается ошибочным;
- вместо ожидаемой логики с `OR` между проверками использована комбинация, которая требует одновременного отсутствия и `source`, и `target`.

## 3. Симптом ошибки

Тест:

- `CircuitConnectionValidationTddTest.findInvalidConnectionIds should return connection with missing source`

Ожидает:

- результат `["W1"]`

Фактически получает:

- пустой список `[]`

## 4. Сценарий отладки в IDE

### Точка входа

Запустить в режиме Debug тест:

- `CircuitConnectionValidationTddTest`

или отдельно метод:

- `findInvalidConnectionIds should return connection with missing source`

### Точки останова

Установить breakpoints:

- в тесте перед вызовом `service.findInvalidConnectionIds(...)`;
- в `CircuitAnalysisService.findInvalidConnectionIds(...)` на строке с условием `filter`;
- на строке `.map { it.id }`.

### Шаги трассировки

1. Остановиться в тесте и проверить входные данные:
   - список компонентов содержит только `C1`;
   - соединение `W1` ссылается на `source = R1` и `target = C1`.
2. Перейти `Step Into` в `findInvalidConnectionIds(...)`.
3. Проверить значение `componentIds`:
   - ожидаемое значение: `["C1"]`.
4. На breakpoint внутри `filter` проверить выражение:
   - `connection.sourceComponentId !in componentIds` -> `true`
   - `connection.targetComponentId !in componentIds` -> `false`
   - итог всего условия -> `false`
5. Сделать вывод:
   - соединение ошибочно не попадает в список невалидных;
   - причина в неверной логике объединения условий.

## 5. Просмотр call stack

Во время отладки в IDE ожидаемая цепочка вызовов:

- `CircuitConnectionValidationTddTest.findInvalidConnectionIds should return connection with missing source`
- `CircuitAnalysisService.findInvalidConnectionIds`
- Kotlin collection pipeline: `filter` / `map`

## 6. Результат

В рамках лабораторной работы №10 в код преднамеренно внедрена логическая ошибка и подготовлен воспроизводимый сценарий ее поиска через встроенный отладчик IDE с использованием точек останова, трассировки выполнения и анализа call stack.
