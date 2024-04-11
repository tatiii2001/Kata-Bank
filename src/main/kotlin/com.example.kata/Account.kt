package com.example.kata

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Account : AccountService{

    data class Action(val dataTime : String, val amount: String, val balance : Int)

    private var actions = listOf<Action>()
    var balance = 0
    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    private val currentDate = LocalDateTime.now().format(formatter)

    override fun deposit(amount: Int) {
        this.balance += amount
        this.actions.toMutableList().add(Action(currentDate, amount.toString(), this.balance))
    }

    override fun withdraw(amount: Int) {
        this.balance -= amount
        this.actions.toMutableList().add(Action(currentDate, "-$amount", this.balance))
    }

    override fun printStatement() {
        println(
            "Date         ||  Amount  ||  Balance"
        )
        actions.forEach {
            println(it.dataTime+"   ||  "+it.amount+"     ||    "+it.balance)
        }
    }

}
