package com.sewerynk.file.parser.csv

import com.sewerynk.file.parser.model.TransactionData
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CSVTransactionListParserTest {
    companion object {
        val correctLine = """
            27-09-2026,26-09-2026,tygodniowe zakupy,biedronka,12 3456 7890 1234 5678 9012 3456,"-200,00","1499,99",1,
            """.trimIndent()
        val fixedQuotationLine = """
            27-09-2026,26-09-2026,tygodniowe zakupy,biedronka,12 3456 7890 1234 5678 9012 3456,-200.00,1499.99,1,
            """.trimIndent()
    }

    @Test
    fun testFixingNumbersInQuotations() {
        val parser = CSVTransactionListParser()
        val fixedLine = parser.fixNumbersInQuotations(correctLine)
        assertTrue(fixedLine == fixedQuotationLine)
    }

    @Test
    fun testParsingLine() {
        val parser = CSVTransactionListParser()
        val delimiter = ","

        val parsedObject = parser.parseLine(correctLine, delimiter)

        val expectedObject = TransactionData(
            "27-09-2026",
            "26-09-2026",
            "tygodniowe zakupy",
            "biedronka",
            "12 3456 7890 1234 5678 9012 3456",
            -200.00,
            1499.99,
            1
        )

        assertTrue(parsedObject == expectedObject)
    }
}