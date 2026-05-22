# Lab 01 — Procesor de Text în Kotlin

Temă introductivă de programare: citirea unui fișier text, aplicarea mai multor transformări
și afișarea rezultatului la consolă.

---

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

---

## Cerințe

### 1. `readFile(path: String): String`

Citește conținutul unui fișier text de la calea `path` și returnează un `String`.

- Dacă fișierul nu există, aruncă `IllegalArgumentException`.

**Exemplu:**
```kotlin
val text = readFile("input.txt")  // returnează conținutul fișierului
```

---

### 2. `removePunctuation(text: String): String`

Elimină toate semnele de punctuație din `text`.
Caracterele de eliminat: `. , ; : ! ? " ' ( ) [ ] { } - _ / \ @ # $ % ^ & * + = ~ \``

**Exemplu:**
```kotlin
removePunctuation("Salut, lume!")   // -> "Salut lume"
removePunctuation("abc123!@#")      // -> "abc123"
```

---

### 3. `removeExtraSpaces(text: String): String`

Înlocuiește orice secvență de spații consecutive cu un singur spațiu.
Elimină și spațiile de la începutul și sfârșitul șirului (trim).

**Exemplu:**
```kotlin
removeExtraSpaces("  ana   are   mere  ")  // -> "ana are mere"
```

---

### 4. `toLowerCase(text: String): String`

Convertește tot textul la litere mici.

**Exemplu:**
```kotlin
toLowerCase("ANA ARE MERE")  // -> "ana are mere"
```

---

### 5. `toUpperCase(text: String): String`

Convertește tot textul la litere mari.

**Exemplu:**
```kotlin
toUpperCase("ana are mere")  // -> "ANA ARE MERE"
```

---

### 6. `filterWordsByLength(text: String, length: Int): String`

Păstrează din `text` doar cuvintele cu exact `length` litere.
Cuvintele rezultate sunt reunite cu un spațiu.

**Exemplu:**
```kotlin
filterWordsByLength("ana are mere acasa", 4)  // -> "mere"
filterWordsByLength("eu am un ou si vin", 2)  // -> "eu am un ou si"
```

---

### 7. `filterNumbers(text: String): String`

Elimină toate secvențele de cifre (`0–9`) din text.

**Exemplu:**
```kotlin
filterNumbers("am 3 mere si 12 pere")  // -> "am  mere si  pere"
```

---

### 8. `processText(text: String, transformations: List<(String) -> String>): String`

Aplică succesiv fiecare funcție din lista `transformations` asupra textului.
Rezultatul fiecărei funcții devine intrarea pentru următoarea.

**Exemplu:**
```kotlin
processText(
    "Salut, Lume! 123",
    listOf(::removePunctuation, ::toLowerCase, ::removeExtraSpaces)
)
// -> "salut lume 123"
```

---

## Cum se rulează testele

```bash
gradle test
```

---

## Tabel de evaluare

| Cerință             | Punctaj |
|---------------------|---------|
| `readFile`          | 1p      |
| `removePunctuation` | 1p      |
| `removeExtraSpaces` | 1p      |
| `toLowerCase`       | 0.5p    |
| `toUpperCase`       | 0.5p    |
| `filterWordsByLength` | 2p    |
| `filterNumbers`     | 2p      |
| `processText`       | 2p      |
| **Total**           | **10p** |
