/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progetto_azienda;

import eccezioni.AziendaPienaException;
import eccezioni.RepartoPienoException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harry
 */
public class App {

    public static void main(String[] args) {
        Date dataAssunzione = new Date(2020, 1, 10);
        Dipendente d1=new Dipendente("aaa","bbb", "operaio", 1000,dataAssunzione);
        
        Dipendente d2=new Dipendente("bbb","ccc", "operaio", 1000,dataAssunzione);
        
        Reparto r1=new Reparto("Amministrazione");
        Reparto r2=new Reparto("Amministrazione");
        
        try {
            r1.aggiungiDipendente(d1);
            r2.aggiungiDipendente(d2);
        } 
        catch (RepartoPienoException ex) {
            System.out.println("Impossibile aggiungere il dipendente!");
        }
        
       System.out.println(d1.toString());
       System.out.println(d2.toString());
       System.out.println(r1.toString());
       System.out.println(r2.toString());
       
       Azienda a1=new Azienda("xyz");
        try {
            a1.aggiungiReparto(r1);
            a1.aggiungiReparto(r2);
        } 
        catch (AziendaPienaException ex) {
            System.out.println("Azienda piena");
        }
        System.out.println("\n\nAzienda\n"+a1.toString());
    }
}
