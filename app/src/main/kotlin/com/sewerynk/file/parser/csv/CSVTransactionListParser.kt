package com.sewerynk.file.parser.csv

import com.sewerynk.file.parser.TransactionListParser
import com.sewerynk.file.parser.model.TransactionData
import org.springframework.stereotype.Service



@Service
class CSVTransactionListParser: TransactionListParser {

    override fun parseLine(line: String, delimiter: String): TransactionData {
        val fixedLine = fixNumbersInQuotations(line)
        val values = fixedLine.split(delimiter)
        val transactionData = TransactionData(
            values[0],
            values[1],
            values[2],
            values[3],
            values[4],
            values[5].toDouble(),
            values[6].toDouble(),
            values[7].toInt(),
        )

        return transactionData
    }

    fun fixNumbersInQuotations(line: String): String {
        return line.split("\"").mapIndexed { index, section ->
            if (index % 2 == 0)
               return@mapIndexed section
            section.replace(",", ".")
        }.joinToString(separator = "")
    }

}