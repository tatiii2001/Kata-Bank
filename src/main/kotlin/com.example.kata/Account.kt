package com.example.kata

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Account : AccountService{

    data class Action(val dataTime : String, val amount: String, val balance : Int)

    var actions = mutableListOf<Action>()
    var balance = 0
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    override fun deposit(amount: Int) {
        this.balance += amount
        this.actions.add(Action(LocalDateTime.now().format(formatter), amount.toString(), this.balance))
    }

    override fun withdraw(amount: Int) {
        this.balance -= amount
        this.actions.add(Action(LocalDateTime.now().format(formatter), "-$amount", this.balance))
    }

    override fun printStatement() {
        println(
            "Date         ||  Amount  ||  Balance"
        )
        actions.forEach {
            println(it.dataTime+"   ||"+it.amount+"      ||    "+it.balance)
        }
    }

}
