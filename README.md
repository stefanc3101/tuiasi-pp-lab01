# Lab 01 — Procesor de Text

Temă introductivă: implementarea unui procesor de text cu funcții componabile în Kotlin.

## Structura proiectului

```
lab01/
├── src/
│   ├── main/kotlin/ro/tuiasi/pp/lab01/
│   │   └── TextProcessor.kt     ← funcții de implementat
│   └── test/kotlin/ro/tuiasi/pp/lab01/
│       └── TextProcessorTest.kt ← teste (nu se modifică)
├── .github/workflows/classroom.yml
├── build.gradle.kts
├── settings.gradle.kts
├── ASSIGNMENT.md
└── README.md
```

## Funcții de implementat

| Funcție               | Descriere                                   |
|-----------------------|---------------------------------------------|
| `readFile`            | Citește un fișier text de pe disk           |
| `removePunctuation`   | Elimină semnele de punctuație               |
| `removeExtraSpaces`   | Compactează spațiile multiple               |
| `toLowerCase`         | Convertește la litere mici                  |
| `toUpperCase`         | Convertește la litere mari                  |
| `filterWordsByLength` | Păstrează cuvintele cu lungime dată         |
| `filterNumbers`       | Elimină cifrele din text                    |
| `processText`         | Aplică o secvență de transformări           |

## Cum rulezi

```bash
gradle test
```

## Cerințe sistem

- JDK 21 (Temurin recomandat)
- Gradle 8.11+ (sau IntelliJ cu suport Gradle)

## Citește mai mult

Vezi [ASSIGNMENT.md](ASSIGNMENT.md) pentru cerințele complete.
