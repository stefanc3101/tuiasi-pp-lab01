package ro.tuiasi.pp.lab01

/**
 * Citește conținutul unui fișier text.
 * Returnează șirul de caractere din fișier.
 * Aruncă IllegalArgumentException dacă fișierul nu există.
 */
fun readFile(path: String): String {
    TODO("De implementat")
}

/**
 * Elimină semnele de punctuație din text (. , ; : ! ? " ' ( ) [ ] { } - _ / \ @ # $ % ^ & * + = ~ `).
 * Exemplu: "Salut, lume!" -> "Salut lume"
 */
fun removePunctuation(text: String): String {
    TODO("De implementat")
}

/**
 * Elimină spațiile multiple consecutive, înlocuindu-le cu un singur spațiu.
 * Trimite și spațiile de la început și sfârșit.
 * Exemplu: "  ana   are   mere  " -> "ana are mere"
 */
fun removeExtraSpaces(text: String): String {
    TODO("De implementat")
}

/**
 * Convertește tot textul la litere mici.
 * Exemplu: "Ana Are Mere" -> "ana are mere"
 */
fun toLowerCase(text: String): String {
    TODO("De implementat")
}

/**
 * Convertește tot textul la litere mari.
 * Exemplu: "ana are mere" -> "ANA ARE MERE"
 */
fun toUpperCase(text: String): String {
    TODO("De implementat")
}

/**
 * Filtrează cuvintele din text, păstrând doar pe cele cu exact [length] litere.
 * Cuvintele sunt separate prin spații (după alte procesări).
 * Exemplu: filterWordsByLength("ana are mere acasa", 4) -> "mere"
 */
fun filterWordsByLength(text: String, length: Int): String {
    TODO("De implementat")
}

/**
 * Elimină toate secvențele de cifre din text.
 * Exemplu: "am 3 mere si 12 pere" -> "am  mere si  pere"
 * Notă: spațiile rezultate nu sunt compactate — aplică removeExtraSpaces separat dacă e necesar.
 */
fun filterNumbers(text: String): String {
    TODO("De implementat")
}

/**
 * Aplică o listă de transformări (funcții String -> String) succesiv asupra textului.
 * Exemplu: processText("Salut, Lume! 123", listOf(::removePunctuation, ::toLowerCase, ::removeExtraSpaces))
 *          -> "salut lume 123"
 */
fun processText(text: String, transformations: List<(String) -> String>): String {
    TODO("De implementat")
}
