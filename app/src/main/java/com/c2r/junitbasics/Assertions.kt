package com.c2r.junitbasics

class Assertions {
    private val user = User("Robinnsson", 44)

    fun getLuckyNumbers(): Array<Int> = arrayOf(21, 117)

    fun getName(): String = user.name

    fun checkHuman(user: User): Boolean = user.isHuman

    fun checkHuman(user: User? = null): Boolean? {
        if (user == null) return null
        return user.isHuman
    }

    fun isAdult(user: User): Boolean {
        if (!user.isHuman) return true
        return user.age >= 18
    }
}