package com.c2r.junitbasics

import org.junit.Assert.*
import org.junit.Test
import kotlin.random.Random.Default.nextLong

class AssertionsTest{

    // Probar Array
    @Test
    fun getArrayTest(){
        val assertions = Assertions()
        val array = arrayOf(21, 117) // Valor esperado
        assertArrayEquals(array, assertions.getLuckyNumbers())
    }

    // Probar Igualdad
    @Test
    fun getNameTest(){
        val assertions = Assertions()
        val name = "Robinnsson"
        val otherName = "Ruth"
        assertEquals(name, assertions.getName())
        assertNotEquals(otherName, assertions.getName())
    }

    // Probar Boolean
    @Test
    fun checkHumanTest(){
        val assertions = Assertions()
        val bot = User("8bit", 1, false)
        val juan = User("Juan", 18, true)
        assertFalse(assertions.checkHuman(bot))
        assertTrue(assertions.checkHuman(juan))
    }

    // Probar Nulls
    @Test
    fun checkNullUserTest(){
        val user = null
        assertNull(user)
        val assertions = Assertions()
        assertNull(assertions.checkHuman(user))
    }

    // Probar No Nulo
    @Test
    fun checkNotNullUserTest(){
        val juan = User("Juan", 18, true)
        assertNotNull(juan)
    }

    // Probar que no sean los mismos objetos
    @Test
    fun checkNotSameUsersTest(){
        val bot = User("8bit", 1, false)
        val juan = User("Juan", 18, true)
        assertNotSame(bot, juan)
    }

    // Probar si son los mismos objetos
    @Test
    fun checkSameUsersTest(){
        val juan = User("Juan", 18, true)
        val copyJuan = juan
        assertSame(copyJuan, juan)
    }

    // Probar con limite de tiempo
    @Test(timeout = 1_000)
    fun getCitiesTest(){
        val cities = arrayOf("Bogotá", "Cali", "Garzón", "Pradera")
        Thread.sleep(nextLong(200, 1_100))
        assertEquals(4, cities.size)
    }
}