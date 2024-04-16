package com.example.kata

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Account : AccountService{
    data class Action(val dataTime : String, val singAction : String, val amount: Int, val balance : Int)

    private var actions = mutableListOf<Action>()
    var balance = 0

    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    private val currentDate = LocalDateTime.now().format(formatter)

    override fun deposit(amount: Int) {
        balance += amount
        actions.add(Action(currentDate,"+", amount, balance))
    }

    override fun withdraw(amount: Int) {
        balance -= amount
        actions.add(Action(currentDate, "-",amount, balance))
    }

    override fun printStatement() {
        println(
            "Date         ||  Amount  ||  Balance"
        )
        actions.forEach {
            println(it.dataTime+"   ||  "+it.singAction+it.amount+"     ||    "+it.balance)
        }
    }

}
