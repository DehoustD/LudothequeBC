package com.example.testons;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SebTest {
    static List<Integer> myList;

    @BeforeAll
    static void initList() {
        myList = new ArrayList<Integer>();
        System.out.println("Je suis execute avant tout le monde");
    }

    @AfterAll
    static void disposeList() {
        myList = null;
        System.out.println("Je suis execute tout a la fin.");
    }

            /**
     * tests de seb.
     */
    @Test
    void testSeb() {
        System.out.println("Methode testSeb.");
        Seb monSeb = new Seb();

        final double prixHorsTVA = 100.0;
        final double tauxTVA = 20.0;
        final double tva = monSeb.calculTVA(prixHorsTVA, tauxTVA);


        final double  expected = 20.0;
        assertEquals(expected, tva);

        assertThrows(IllegalArgumentException.class, () -> {
            final double tauxTVA2 = -20.0;
            monSeb.calculTVA(prixHorsTVA, tauxTVA2);
            //final double  expected2 = 20.0;
        }, "Negatif doit faire une exception");

        assertThrows(IllegalArgumentException.class, () -> {
            final double tauxTVA2 = -20.0;
            final double prixHorsTVA2 = -100;
            monSeb.calculTVA(prixHorsTVA2, tauxTVA2);
            //final double  expected2 = 20.0;
        }, "Negatif doit faire une exception");

        assertDoesNotThrow(()->{
            monSeb.calculTVA(prixHorsTVA, tauxTVA);
        });


        String who = "johnny";
        final boolean isGod = "johnny".equals(who) ? true : false;
        assertTrue(isGod);
    }

    @Test 
    void testList() {

    }

}
