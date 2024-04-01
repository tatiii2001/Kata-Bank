package com.example.kata

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AccountTest {


    @Test
    fun deposit() {
        val account = Account()

        account.deposit(500)

        assertEquals(500, account.balance)
    }


    @Test
    fun withdraw(){
        val account = Account()

        account.withdraw(500)
        account.printStatement()
        assertEquals(-500, account.balance)
    }


}