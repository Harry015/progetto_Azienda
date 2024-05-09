/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progetto_azienda;

import eccezioni.CapoRepartoNonTrovatoException;
import eccezioni.DipendenteNonTrovatoException;
import eccezioni.RepartoPienoException;
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
public class RepartoTest {
    
    public RepartoTest() {
    }

    /**
     * Test of getLength method, of class Reparto.
     */
    @Test
    public void testGetLength() throws RepartoPienoException {
        Reparto reparto = new Reparto("Vendite");
        Dipendente dipendente1 = new Dipendente("Mario", "Rossi", "Dipendente");
        Dipendente dipendente2 = new Dipendente("Mario", "Rossi", "Dipendente");
        reparto.aggiungiDipendente(dipendente1);
        reparto.aggiungiDipendente(dipendente2);
        assertEquals(2, reparto.getLength());
    }

    /**
     * Test of getNomeReparto method, of class Reparto.
     */
    @Test
    public void testGetNomeReparto() {
        Reparto reparto = new Reparto("Vendite");
        assertEquals("Vendite", reparto.getNomeReparto());
    }

    /**
     * Test of aggiungiDipendente method, of class Reparto.
     */
    @Test
    public void testAggiungiDipendente() throws Exception {
        Reparto reparto = new Reparto("Vendite");
        Dipendente dipendente1 = new Dipendente("Mario", "Rossi", "Dipendente");
        
        // Esecuzione
        reparto.aggiungiDipendente(dipendente1);
        
        // Verifica
        assertEquals(1, reparto.getNumDipendenti());
        assertTrue(reparto.getArrayDipendenti().contains(dipendente1));
    }

    /**
     * Test of getDipendente method, of class Reparto.
     */
    @Test
    public void testGetDipendente() throws Exception {
        Reparto reparto = new Reparto("Vendite");
        Dipendente dipendente1 = new Dipendente("Mario", "Rossi", "Dipendente");
        reparto.aggiungiDipendente(dipendente1);
        assertEquals(dipendente1, reparto.getDipendente(dipendente1.getId_Dipendente()));
    }

    /**
     * Test of getNomeCapoReparto method, of class Reparto.
     */
    @Test
    public void testGetNomeCapoReparto() throws Exception {
        Reparto reparto = new Reparto("Vendite");
        Dipendente dipendente1 = new Dipendente("Mario", "Rossi", "capo reparto");
        reparto.aggiungiDipendente(dipendente1);
        assertEquals(dipendente1.getNome(), reparto.getNomeCapoReparto());
    }

    /**
     * Test of rimuoviDipendente method, of class Reparto.
     */
    @Test
    public void testRimuoviDipendente() throws Exception {
        Reparto reparto = new Reparto("Vendite");
        Dipendente dipendente1 = new Dipendente("Mario", "Rossi", "Dipendente");
        reparto.aggiungiDipendente(dipendente1);
        
        // Esecuzione
        reparto.rimuoviDipendente(dipendente1.getId_Dipendente());
        
        // Verifica
        assertEquals(0, reparto.getNumDipendenti());
        assertFalse(reparto.getArrayDipendenti().contains(dipendente1));
    }

    /**
     * Test of getNumDipendenti method, of class Reparto.
     */
    @Test
    public void testGetNumDipendenti() throws RepartoPienoException {
        Reparto reparto = new Reparto("Vendite");
        Dipendente dipendente1 = new Dipendente("Mario", "Rossi", "Dipendente");
        reparto.aggiungiDipendente(dipendente1);
        assertEquals(1, reparto.getNumDipendenti());
    }

    /**
     * Test of approvaRichiesteFerie method, of class Reparto.
     */
    @Test
    public void testApprovaRichiesteFeriePerTest() throws dataNonValidaException {
        Reparto reparto = new Reparto("Vendite");
        Dipendente dipendente1 = new Dipendente("Mario", "Rossi", "Dipendente");
        LocalDate dataInizio=LocalDate.of(2024, 5, 1);
        LocalDate dataFine=LocalDate.of(2024, 5, 10);
        Ferie ferie1 = new Ferie(dataInizio, dataFine, "vacanza");
        dipendente1.setFerie(ferie1);
        reparto.approvaRichiesteFeriePerTest(dipendente1);
        assertEquals(true, ferie1.isApprovato());
    }

    /**
     * Test of ordineAlfabeticoDipendenti method, of class Reparto.
     */
    @Test
    public void testOrdineAlfabeticoDipendenti() throws RepartoPienoException {
        Reparto reparto = new Reparto("Vendite");
        Dipendente dipendente1 = new Dipendente("Mario", "Rossi", "Dipendente");
        Dipendente dipendente2 = new Dipendente("Luigi", "Verdi", "Dipendente");
        Dipendente dipendente3 = new Dipendente("Anna", "Bianchi", "Dipendente");
        reparto.aggiungiDipendente(dipendente1);
        reparto.aggiungiDipendente(dipendente2);
        reparto.aggiungiDipendente(dipendente3);
        
        // Esecuzione
        
        Dipendente[] dipendentiOrdinati = reparto.ordineAlfabeticoDipendenti();
        
        // Verifica
        assertEquals("Anna", dipendentiOrdinati[0].getNome());
        assertEquals("Luigi", dipendentiOrdinati[1].getNome());
        assertEquals("Mario", dipendentiOrdinati[2].getNome());
    }
    
    public void testDipendenteNonTrovatoException(){
        Reparto reparto = new Reparto("Vendite");
        DipendenteNonTrovatoException eccezione = assertThrows(DipendenteNonTrovatoException.class, () ->reparto.getDipendente(0));
    }
    
    public void testCapoRepartoNonTrovatoException(){
        Reparto reparto = new Reparto("Vendite");
        CapoRepartoNonTrovatoException eccezione = assertThrows(CapoRepartoNonTrovatoException.class, () ->reparto.getNomeCapoReparto());
    }
    
    
}
