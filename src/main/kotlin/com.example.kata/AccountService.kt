package com.example.kata

interface AccountService {
    fun deposit(amount : Int)
    fun withdraw(amount: Int)
    fun printStatement()
}
