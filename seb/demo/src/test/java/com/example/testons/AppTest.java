package com.example.testons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
/**
 * Unit test for simple App.
 */
class AppTest {

    @Test 
    void davidDemoTest(){
        assertNotEquals(2, 20);
    }


    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);

        final int b = 3;
        assertNotEquals(0, b);

        Seb monSeb = new Seb();
        String result = monSeb.concat("bonjour", "monde");
        assertEquals("bonjour monde", result);
        assertNotEquals("bonjourmonde", result);
    }


}
