package com.c2r.junitbasics

import org.junit.*
import org.junit.Assert.*

class AssertionsUserTest {

    /**
     * Se emplea las anotaciones @BeforeClass cuando las variables se emplean en varias pruebas y estas se realizan en la misma clase
     * La anotacion @AfterClass se utiliza para limpiar dichas variables.
     * Esto se emplea cuando es costoso cargar nuevamente las variables.
     * Se deben acompañar de la anotacion @JvmStatic
     */

    private lateinit var bot: User

    companion object{
        private lateinit var juan: User

        @BeforeClass @JvmStatic
        fun setupCommon() {
            juan = User("Juan", 18, true)
        }
        
        @AfterClass @JvmStatic
        fun tearDownCommon() {
            juan = User()
        }
    }

    @Before
    fun setup() {
        bot = User("8bit", 1, false)
    }

    @After
    fun tearDown() {
        bot = User()
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


    @Test
    fun checkNotSameUsersTest(){
        assertNotSame(bot, juan)
    }

    @Test
    fun checkSameUsersTest(){
        val copyJuan = juan
        assertSame(copyJuan, juan)
    }

}