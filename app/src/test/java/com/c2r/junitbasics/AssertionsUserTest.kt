package com.c2r.junitbasics

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class AssertionsUserTest {

    /**
     * Se emplea las anotaciones @Before cuando las variables se emplean en varias pruebas y estas se realizan en la misma clase
     * La anotacion @After se utiliza para limpiar dichas variables.
     * Esto se emplea solo cuando no es costoso cargar nuevamente las variables.
     */

    private lateinit var bot: User
    private lateinit var juan: User

    // Esto se ejecuta antes de cada prueba, carga inicialmente todas las variables
    @Before
    fun setup() {
        bot = User("8bit", 1, false)
        juan = User("Juan", 18, true)
    }

    // Esto se encarga de limpiar las variables
    @After
    fun tearDown() {
        bot = User()
        juan = User()
    }

    @Test
    fun checkHumanTest() {
        val assertions = Assertions()
        assertFalse(assertions.checkHuman(bot))
        assertTrue(assertions.checkHuman(juan))
    }

    @Test
    fun checkNotNullUserTest() {
        assertNotNull(juan)
    }

}