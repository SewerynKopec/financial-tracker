package com.sewerynk.file.parser.model

import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class TransactionData(
    val transactionDate: LocalDate,
    val receiptDate: LocalDate,
    val title: String,
    val recipientName: String,
    val accountNumber: String,
    val amount: Double,
    val currentBalance: Double,
    val index: Int
) {

    companion object {
        private val DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    }

    constructor(
        rawTransactionDate: String,
        rawReceiptDate: String,
        title: String,
        recipientName: String,
        accountNumber: String,
        amount: Double,
        currentBalance: Double,
        index: Int
    ): this(
        transactionDate = LocalDate.parse(rawTransactionDate, DATE_FORMAT),
        receiptDate = LocalDate.parse(rawReceiptDate, DATE_FORMAT),
        title,
        recipientName,
        accountNumber,
        amount,
        currentBalance,
        index
    )
}
