# Лабораторная работа №1
## Тема 7. Настройка системы управления проектами для САПР схем

**Дисциплина:** Система автоматизированного проектирования (САПР) схем  
**Лабораторная работа:** №1  
**Проект в Jira:** `SAPR` (CAD-Schemes)  
**Инструмент:** Jira Software (Scrum)  
**Дата формирования отчета:** 23.03.2026

## 1. Настройка системы управления проектами (Jira)

В Jira создан Scrum-проект:
- `Project name`: `CAD-Schemes`
- `Project key`: `SAPR`
- `Board`: `CAD-Schemes Scrum Board`

Настроен workflow со статусами:
- `Backlog`
- `To Do`
- `In Progress`
- `Code Review`
- `Testing`
- `Done`

Созданы метки (`labels`):
- `feature`
- `bug`
- `tech-debt`
- `documentation`
- `high-priority`

Назначены участники:
- **Андрей Ганюшкин** — Project Manager / Developer
- **Тестировщик (роль)** — QA

## 2. Бэклог проекта (Jira Backlog)

| Issue Key | Summary | Issue Type | Priority | Story Points | Assignee |
|---|---|---|---|---:|---|
| SAPR-1 | Сформировать требования к модулю ввода схемы | Story | High | 3 | Андрей Ганюшкин |
| SAPR-2 | Реализовать модель данных: компоненты и соединения | Story | High | 5 | Андрей Ганюшкин |
| SAPR-3 | Добавить REST API для CRUD компонентов | Story | High | 5 | Андрей Ганюшкин |
| SAPR-4 | Добавить REST API для CRUD соединений | Story | High | 5 | Андрей Ганюшкин |
| SAPR-5 | Реализовать валидацию схемы (обрывы, циклы, дубли) | Story | High | 8 | Андрей Ганюшкин |
| SAPR-6 | Добавить импорт схемы из JSON | Story | Medium | 5 | Андрей Ганюшкин |
| SAPR-7 | Добавить экспорт схемы в JSON | Story | Medium | 3 | Андрей Ганюшкин |
| SAPR-8 | Покрыть сервисы unit-тестами | Task | High | 5 | Андрей Ганюшкин |
| SAPR-9 | Настроить интеграционные тесты API | Task | Medium | 5 | Андрей Ганюшкин |
| SAPR-10 | Подготовить Swagger/OpenAPI документацию | Task | Medium | 3 | Андрей Ганюшкин |
| SAPR-11 | Обработать ошибки в API (глобальный handler) | Story | Medium | 3 | Андрей Ганюшкин |
| SAPR-12 | Добавить логирование операций над схемой | Task | Low | 2 | Андрей Ганюшкин |
| SAPR-13 | Настроить CI (сборка + тесты) | Task | Medium | 3 | Андрей Ганюшкин |
| SAPR-14 | Подготовить пользовательскую инструкцию | Task | Low | 2 | Андрей Ганюшкин |
| SAPR-15 | Исправить дефекты по результатам тестирования | Bug | High | 5 | Андрей Ганюшкин |

## 3. Планирование 1-го спринта

**Sprint:** `Sprint 1`  
**Период:** 23.03.2026 - 05.04.2026 (2 недели)  
**Цель спринта:** получить минимально рабочий backend для описания и проверки электрической схемы.

В спринт включены задачи:
- SAPR-1 (3 SP)
- SAPR-2 (5 SP)
- SAPR-3 (5 SP)
- SAPR-4 (5 SP)
- SAPR-5 (8 SP)
- SAPR-11 (3 SP)
- SAPR-8 (5 SP)

**Итого нагрузка Sprint 1:** 34 SP

## 4. Назначение задач по спринту

| Issue Key | Assignee | Due Date | Status |
|---|---|---|---|
| SAPR-1 | Андрей Ганюшкин | 24.03.2026 | To Do |
| SAPR-2 | Андрей Ганюшкин | 26.03.2026 | To Do |
| SAPR-3 | Андрей Ганюшкин | 29.03.2026 | To Do |
| SAPR-4 | Андрей Ганюшкин | 31.03.2026 | To Do |
| SAPR-5 | Андрей Ганюшкин | 03.04.2026 | To Do |
| SAPR-11 | Андрей Ганюшкин | 04.04.2026 | To Do |
| SAPR-8 | Андрей Ганюшкин | 05.04.2026 | To Do |

## 5. Выгрузка доски в отчет (Jira Export)

Ниже представлена выгрузка состояния доски после планирования Sprint 1.

### 5.1 Снимок структуры статусов
- `Backlog`: SAPR-6, SAPR-7, SAPR-9, SAPR-10, SAPR-12, SAPR-13, SAPR-14, SAPR-15
- `To Do`: SAPR-1, SAPR-2, SAPR-3, SAPR-4, SAPR-5, SAPR-8, SAPR-11
- `In Progress`: —
- `Code Review`: —
- `Testing`: —
- `Done`: —

### 5.2 Табличная выгрузка (CSV-представление Jira)

| Issue key | Summary | Issue Type | Assignee | Priority | Labels | Story Points | Sprint | Status |
|---|---|---|---|---|---|---:|---|---|
| SAPR-1 | Требования к модулю ввода схемы | Story | Андрей Ганюшкин | High | feature,high-priority | 3 | Sprint 1 | To Do |
| SAPR-2 | Модель данных: компоненты и соединения | Story | Андрей Ганюшкин | High | feature,high-priority | 5 | Sprint 1 | To Do |
| SAPR-3 | REST API CRUD компонентов | Story | Андрей Ганюшкин | High | feature,high-priority | 5 | Sprint 1 | To Do |
| SAPR-4 | REST API CRUD соединений | Story | Андрей Ганюшкин | High | feature,high-priority | 5 | Sprint 1 | To Do |
| SAPR-5 | Валидация схемы | Story | Андрей Ганюшкин | High | feature,high-priority | 8 | Sprint 1 | To Do |
| SAPR-8 | Unit-тесты сервисов | Task | Андрей Ганюшкин | High | tech-debt | 5 | Sprint 1 | To Do |
| SAPR-11 | Глобальная обработка ошибок API | Story | Андрей Ганюшкин | Medium | feature | 3 | Sprint 1 | To Do |
| SAPR-6 | Импорт схемы JSON | Story | Андрей Ганюшкин | Medium | feature | 5 | Backlog | Backlog |
| SAPR-7 | Экспорт схемы JSON | Story | Андрей Ганюшкин | Medium | feature | 3 | Backlog | Backlog |
| SAPR-9 | Интеграционные тесты API | Task | Андрей Ганюшкин | Medium | tech-debt | 5 | Backlog | Backlog |
| SAPR-10 | Swagger/OpenAPI документация | Task | Андрей Ганюшкин | Medium | documentation | 3 | Backlog | Backlog |
| SAPR-12 | Логирование операций | Task | Андрей Ганюшкин | Low | feature | 2 | Backlog | Backlog |
| SAPR-13 | CI: сборка + тесты | Task | Андрей Ганюшкин | Medium | tech-debt | 3 | Backlog | Backlog |
| SAPR-14 | Пользовательская инструкция | Task | Андрей Ганюшкин | Low | documentation | 2 | Backlog | Backlog |
| SAPR-15 | Исправление дефектов | Bug | Андрей Ганюшкин | High | bug,high-priority | 5 | Backlog | Backlog |

## 6. Краткий вывод

В рамках лабораторной работы №1 Jira-проект настроен: создан Scrum board, сформирован backlog, запланирован Sprint 1, задачи назначены и распределены по статусам. Выгрузка доски добавлена в отчет и приложена в CSV.
