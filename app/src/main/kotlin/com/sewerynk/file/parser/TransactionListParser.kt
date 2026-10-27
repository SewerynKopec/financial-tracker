package com.sewerynk.file.parser

import com.sewerynk.file.parser.model.TransactionData
import java.io.File

interface TransactionListParser {

    fun readFile(inputFile: File) =
        inputFile.readLines()

    fun parseLine(line: String, delimiter: String): TransactionData
}