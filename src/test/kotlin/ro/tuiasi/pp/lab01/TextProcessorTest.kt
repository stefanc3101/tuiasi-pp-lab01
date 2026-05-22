package ro.tuiasi.pp.lab01

import java.io.File
import kotlin.test.*

class TextProcessorTest {

    // --- removePunctuation ---

    @Test
    fun `removePunctuation sterge punctuatia de baza`() {
        assertEquals("Salut lume", removePunctuation("Salut, lume!"))
    }

    @Test
    fun `removePunctuation pastreaza literele si cifrele`() {
        val result = removePunctuation("abc123!@#")
        assertEquals("abc123", result)
    }

    @Test
    fun `removePunctuation text fara punctuatie ramane neschimbat`() {
        assertEquals("ana are mere", removePunctuation("ana are mere"))
    }

    // --- removeExtraSpaces ---

    @Test
    fun `removeExtraSpaces compacteaza spatii multiple`() {
        assertEquals("ana are mere", removeExtraSpaces("ana   are   mere"))
    }

    @Test
    fun `removeExtraSpaces trimite spatii de la capete`() {
        assertEquals("ana are mere", removeExtraSpaces("  ana are mere  "))
    }

    @Test
    fun `removeExtraSpaces un singur spatiu ramane neschimbat`() {
        assertEquals("ana are", removeExtraSpaces("ana are"))
    }

    // --- toLowerCase ---

    @Test
    fun `toLowerCase converteste tot la litere mici`() {
        assertEquals("ana are mere", toLowerCase("ANA ARE MERE"))
    }

    @Test
    fun `toLowerCase text deja mic ramane neschimbat`() {
        assertEquals("ana are mere", toLowerCase("ana are mere"))
    }

    // --- toUpperCase ---

    @Test
    fun `toUpperCase converteste tot la litere mari`() {
        assertEquals("ANA ARE MERE", toUpperCase("ana are mere"))
    }

    // --- filterWordsByLength ---

    @Test
    fun `filterWordsByLength pastreaza doar cuvintele cu lungimea exacta`() {
        assertEquals("mere", filterWordsByLength("ana are mere acasa", 4))
    }

    @Test
    fun `filterWordsByLength fara cuvinte potrivite returneaza sir gol`() {
        assertEquals("", filterWordsByLength("ana are acasa", 10))
    }

    @Test
    fun `filterWordsByLength mai multe cuvinte potrivite`() {
        val result = filterWordsByLength("eu am un ou si vin", 2)
        assertEquals("eu am un ou si", result)
    }

    // --- filterNumbers ---

    @Test
    fun `filterNumbers elimina cifrele`() {
        val result = filterNumbers("am 3 mere si 12 pere").trim()
        assertFalse(result.contains(Regex("\\d")))
        assertTrue(result.contains("am"))
        assertTrue(result.contains("mere"))
    }

    @Test
    fun `filterNumbers text fara cifre ramane neschimbat`() {
        assertEquals("mere pere", filterNumbers("mere pere"))
    }

    // --- processText ---

    @Test
    fun `processText aplica transformarile in ordine`() {
        val result = processText(
            "Salut, Lume! 123",
            listOf(::removePunctuation, ::toLowerCase, ::removeExtraSpaces)
        )
        assertEquals("salut lume 123", result)
    }

    @Test
    fun `processText lista goala returneaza textul original`() {
        assertEquals("Salut!", processText("Salut!", emptyList()))
    }

    @Test
    fun `processText o singura transformare`() {
        val result = processText("Ana Are Mere", listOf(::toLowerCase))
        assertEquals("ana are mere", result)
    }

    // --- readFile ---

    @Test
    fun `readFile citeste continutul unui fisier`() {
        val tmp = File.createTempFile("lab01_test", ".txt")
        try {
            tmp.writeText("ana are mere")
            assertEquals("ana are mere", readFile(tmp.absolutePath))
        } finally {
            tmp.delete()
        }
    }

    @Test
    fun `readFile arunca exceptie pentru fisier inexistent`() {
        assertFailsWith<IllegalArgumentException> {
            readFile("/tmp/fisier_care_nu_exista_lab01.txt")
        }
    }
}
