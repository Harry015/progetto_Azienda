/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progetto_azienda;

import eccezioni.dataNonValidaException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author taran
 */
public class DipendenteTest {
    
    public DipendenteTest() {
    }
    
    /**
     * Test of costruttore method, of class Dipendente.
     */
    @Test
    public void testCostruttore() {
        Dipendente dipendente = new Dipendente("Mario", "Rossi", "Ruolo");
        assertEquals("Mario", dipendente.getNome());
        assertEquals("Rossi", dipendente.getCognome());
        assertEquals("Ruolo", dipendente.getRuolo());
    }
    
    @Test
    public void testSetGetFerie() throws dataNonValidaException {
        Dipendente dipendente = new Dipendente("Mario", "Rossi", "Dipendente");
        LocalDate dataInizio=LocalDate.of(2024, 5, 1);
        LocalDate dataFine=LocalDate.of(2024, 5, 10);
        Ferie ferie1 = new Ferie(dataInizio, dataFine, "vacanza");
        Ferie ferie2 = new Ferie(dataInizio, dataFine, "vacanza");
        dipendente.setFerie(ferie1);
        dipendente.setFerie(ferie2);
        
        List<Ferie> richieste = dipendente.getArrayFerie();
        
        assertEquals(2, richieste.size());
        assertTrue(richieste.contains(ferie1));
        assertTrue(richieste.contains(ferie2));
    }


    /**
     * Test of getNome method, of class Dipendente.
     */
    @Test
    public void testGetNome() {
        Dipendente dipendente = new Dipendente("Mario", "Rossi", "Ruolo");
        assertEquals("Mario", dipendente.getNome());
    }

    /**
     * Test of setNome method, of class Dipendente.
     */
    @Test
    public void testSetNome() {
        Dipendente dipendente = new Dipendente("Mario", "Rossi", "Ruolo");
        dipendente.setNome("Luigi");
        assertEquals("Luigi", dipendente.getNome());
    }

    /**
     * Test of getCognome method, of class Dipendente.
     */
    @Test
    public void testGetCognome() {
        Dipendente dipendente = new Dipendente("Mario", "Rossi", "Ruolo");
        assertEquals("Rossi", dipendente.getCognome());
    }

    /**
     * Test of setCognome method, of class Dipendente.
     */
    @Test
    public void testSetCognome() {
        Dipendente dipendente = new Dipendente("Mario", "Rossi", "Ruolo");
        dipendente.setCognome("Verdi");
        assertEquals("Verdi", dipendente.getCognome());
    }

    /**
     * Test of getRuolo method, of class Dipendente.
     */
    @Test
    public void testGetRuolo() {
        Dipendente dipendente = new Dipendente("Mario", "Rossi", "Ruolo");
        assertEquals("Ruolo", dipendente.getRuolo());
    }

    /**
     * Test of setRuolo method, of class Dipendente.
     */
    @Test
    public void testSetRuolo() {
        Dipendente dipendente = new Dipendente("Mario", "Rossi", "Ruolo");
        dipendente.setRuolo("Nuovo Ruolo");
        assertEquals("Nuovo Ruolo", dipendente.getRuolo());
    }
    
}
