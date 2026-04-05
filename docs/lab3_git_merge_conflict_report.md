# Лабораторная работа №3
## Симуляция работы двух разработчиков и разрешение merge conflict

**Дисциплина:** Система автоматизированного проектирования (САПР) схем  
**Дата выполнения:** 05.04.2026  
**Ветка интеграции:** `main`

## 1. Цель работы

Смоделировать параллельную работу двух разработчиков:

- создать ветки `feature-1` и `feature-2`;
- добавить в них базовый код системы;
- выполнить слияние в `main` через Pull Request;
- искусственно создать конфликт и разрешить его вручную.

## 2. Выполненные действия

### Разработчик 1

- создана ветка `feature-1`;
- добавлен файл `src/main/kotlin/stud/ganyushkin/sapr/model/CircuitComponent.kt`;
- в `README.md` добавлен блок с описанием модели `CircuitComponent`;
- создан коммит `b65eca8` — `feature-1: add circuit component model`.

### Разработчик 2

- создана ветка `feature-2`;
- добавлен файл `src/main/kotlin/stud/ganyushkin/sapr/model/CircuitConnection.kt`;
- в `README.md` добавлен альтернативный блок с описанием модели `CircuitConnection`;
- создан коммит `535b4ab` — `feature-2: add circuit connection model`.

## 3. Слияние через Pull Request

В `main` выполнены merge-коммиты:

- `4164d5f` — `Merge pull request #1 from feature-1`
- `5675c09` — `Merge pull request #2 from feature-2`

Первое слияние прошло автоматически.  
При втором слиянии возник искусственно созданный конфликт в файле `README.md`.

## 4. Разрешение конфликта

Конфликт был создан в разделе `Базовый код системы` файла `README.md`, так как обе ветки изменяли один и тот же фрагмент текста разным образом.

Конфликт разрешен вручную объединением изменений обеих веток:

- сохранено описание модели компонента `CircuitComponent`;
- сохранено описание модели соединения `CircuitConnection`;
- итоговый текст оформлен как общий результат после merge.

## 5. Итоговая история ветвления

```text
*   5675c09 (HEAD -> main) Merge pull request #2 from feature-2
|\  
| * 535b4ab (feature-2) feature-2: add circuit connection model
* |   4164d5f Merge pull request #1 from feature-1
|\ \  
| |/  
|/|   
| * b65eca8 (feature-1) feature-1: add circuit component model
|/  
* c316030 (origin/main) init
* 4681e2c first commit
```

## 6. Результат

В рамках лабораторной работы №3 выполнена симуляция работы двух разработчиков: созданы ветки `feature-1` и `feature-2`, добавлен базовый код системы, выполнено слияние в `main` через merge-коммиты в стиле Pull Request, создан и вручную разрешен конфликт в `README.md`.
