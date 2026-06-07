package ro.tuiasi.pp.lab01

import java.io.File

/**
 * Citește conținutul unui fișier text.
 * Returnează șirul de caractere din fișier.
 * Aruncă IllegalArgumentException dacă fișierul nu există.
 */
fun readFile(path: String): String {
    val file = File(path)
    if (!file.exists()) {
        throw IllegalArgumentException("Fișierul nu a putut fi găsit la calea: $path")
    }
    return file.readText()
}

/**
 * Elimină semnele de punctuație din text.
 * Exemplu: "Salut, lume!" -> "Salut lume"
 */
fun removePunctuation(text: String): String {
    // Definim setul specific de caractere care trebuie eliminate
    val punctuations = ".,;:!?\"'()[]{}<>-_/\\@#\$%^&*+=~`"
    return text.filterNot { it in punctuations }
}

/**
 * Elimină spațiile multiple consecutive, înlocuindu-le cu un singur spațiu.
 * Trimite și spațiile de la început și sfârșit.
 * Exemplu: "  ana   are   mere  " -> "ana are mere"
 */
fun removeExtraSpaces(text: String): String {
    return text.trim().replace(Regex("\\s+"), " ")
}

/**
 * Convertește tot textul la litere mici.
 * Exemplu: "Ana Are Mere" -> "ana are mere"
 */
fun toLowerCase(text: String): String {
    return text.lowercase()
}

/**
 * Convertește tot textul la litere mari.
 * Exemplu: "ana are mere" -> "ANA ARE MERE"
 */
fun toUpperCase(text: String): String {
    return text.uppercase()
}

/**
 * Filtrează cuvintele din text, păstrând doar pe cele cu exact [length] litere.
 * Cuvintele sunt separate prin spații (după alte procesări).
 * Exemplu: filterWordsByLength("ana are mere acasa", 4) -> "mere"
 */
fun filterWordsByLength(text: String, length: Int): String {
    // Folosim split după spații și păstrăm doar cuvintele de dimensiunea dorită
    return text.split(Regex("\\s+"))
        .filter { it.length == length }
        .joinToString(" ")
}

/**
 * Elimină toate secvențele de cifre din text.
 * Exemplu: "am 3 mere si 12 pere" -> "am  mere si  pere"
 * Notă: spațiile rezultate nu sunt compactate — aplică removeExtraSpaces separat dacă e necesar.
 */
fun filterNumbers(text: String): String {
    // Înlocuim orice secvență de una sau mai multe cifre (\d+) cu un șir gol
    return text.replace(Regex("\\d+"), "")
}

/**
 * Aplică o listă de transformări (funcții String -> String) succesiv asupra textului.
 * Exemplu: processText("Salut, Lume! 123", listOf(::removePunctuation, ::toLowerCase, ::removeExtraSpaces))
 *          -> "salut lume 123"
 */
fun processText(text: String, transformations: List<(String) -> String>): String {
    // fold parcurge lista de funcții și aplică rezultatul acumulat (acc) ca parametru pentru următoarea
    return transformations.fold(text) { acc, transformFunction ->
        transformFunction(acc)
    }
}