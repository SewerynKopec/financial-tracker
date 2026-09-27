package com.sewerynk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FinancialTrackerApplication

fun main(args: Array<String>) {
    runApplication<FinancialTrackerApplication>(*args)
}

