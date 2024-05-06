/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progetto_azienda;

import eccezioni.AziendaPienaException;
import eccezioni.RepartoPienoException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.Menu;

/**
 *
 * @author harry
 */
public class App {

    public static void main(String[] args) {
        Scanner tastiera=new Scanner(System.in);
        Date dataAssunzione=null;
        
        Dipendente d1=new Dipendente("aaa", "bbb", "capo reparto", 1500, dataAssunzione);
        Dipendente d2=new Dipendente("aaa", "bbb", "capo reparto", 1500, dataAssunzione);
        Reparto r1=new Reparto("Amm");
        Reparto r2=new Reparto("Mar");
        try {
            r1.aggiungiDipendente(d1);
            r2.aggiungiDipendente(d2);
        } catch (RepartoPienoException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Azienda a1=new Azienda("xyz");
        
        try {
            a1.aggiungiReparto(r1);
            a1.aggiungiReparto(r2);
        } catch (AziendaPienaException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int numeroVociMenu=4,x=0;
        int sceltaPersona=0;
        int sceltaDellaPersona=0;
        
        String[] vociMenu=new String[numeroVociMenu];
        Menu m1;
        
        vociMenu[0]="0 -->\tEsci";
        vociMenu[1]="1 -->\tDipendente";
        vociMenu[2]="2 -->\tCapo Reparto";
        vociMenu[3]="3 -->\tCapo";
        
        m1=new Menu(vociMenu);
        
        int id=0;
        Reparto rep;
        Menu m2 = null;
        do {            
            sceltaPersona=m1.sceltaMenu();
            switch (sceltaPersona) {
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                case 1: //Persona --> Dipendente
                    
                    System.out.println("Inserisci il tuo id:");
                    id=tastiera.nextInt();
                    x=1;
                    numeroVociMenu=4;
                    vociMenu=new String[numeroVociMenu];
                    vociMenu[0]="0 -->\tEsci";
                    vociMenu[1]="1 -->\tVisualizza il reparto di appartenenza";
                    vociMenu[2]="2 -->\tVisualizza la lista di tutti i dipendenti del tuo reparto";
                    vociMenu[3]="3 -->\tRichiedi ferie";
                    m2=new Menu(vociMenu);
                    break;
                case 2: //Persona --> Capo Reparto
                    System.out.println("Inserisci il tuo id:");
                    id=tastiera.nextInt();
                    x=1;
                    numeroVociMenu=4;
                    vociMenu=new String[numeroVociMenu];
                    vociMenu[0]="0 -->\tEsci";
                    vociMenu[1]="1 -->\tVisualizza i reparti che gestisci";
                    vociMenu[2]="2 -->\tApprova richieste ferie";
                    vociMenu[3]="3 -->\tOrdina la lista dei dipendenti in ordine Alfabetico";
                    m2=new Menu(vociMenu);
                    break;
                case 3: //Persona --> Capo Azienda
                    x=1;
                    numeroVociMenu=9;
                    vociMenu=new String[numeroVociMenu];
                    vociMenu[0]="0 -->\tEsci";
                    vociMenu[1]="1 -->\tVisualizza la lista dei dipendenti";
                    vociMenu[2]="2 -->\tVisualizza la lista dei reparti";
                    vociMenu[3]="3 -->\tAggiungi reparto";
                    vociMenu[4]="4 -->\tAggiungi dipendente";
                    vociMenu[5]="5 -->\tEsporta su file CSV";
                    vociMenu[6]="6 -->\tImporta da file CSV";
                    vociMenu[7]="7 -->\tSerializ";
                    vociMenu[8]="8 -->\tDeserializ";
                    m2=new Menu(vociMenu);
                    break;    
                default:
                    break;
            }
        } while ((sceltaPersona!=0)&&(x!=1));
        
        do { 
            if(sceltaPersona!=0)
                sceltaDellaPersona=m2.sceltaMenu();
            switch (sceltaPersona) {
                case 0: //Esci
                    break;
                case 1: //Persona --> Dipendente
                    switch (sceltaDellaPersona) {
                        case 0:
                            System.out.println("Arrivederci!");
                            break;
                        case 1:
                            rep=a1.RepartoAppartenenza(id);
                            System.out.println(rep.getNomeReparto());
                            break;
                        case 2:
                            rep=a1.RepartoAppartenenza(id);
                            System.out.println(rep.toString());
                            break;
                        case 3:
                            Date dataInizio=null,dataFine=null;
                            String motivo="xyz";
                            Ferie ferie = new Ferie(dataInizio, dataFine, motivo);
                            d1.setFerie(ferie);
                            System.out.println(d1.getFerie());
                            break;
                        default:
                            break;
                    }
                    break;
                case 2: //Persona --> Capo Reparto
                    switch (sceltaDellaPersona) {
                        case 0:
                            System.out.println("Arrivederci!");
                            break;
                        case 1:
                            String nome;
                            String output;
                            tastiera.nextLine();
                            System.out.println("Inserisci il tuo nome:");
                            nome=tastiera.nextLine();
                            output=a1.RepartiCheGestisci(nome);
                            System.out.println(output);
                            break;
                        case 2:
                            rep=a1.RepartoAppartenenza(id);
                            rep.approvaRichiesteFerie();
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            break;
                    }
                    break;
                case 3: //Persona --> Capo Azienda
                    switch (sceltaDellaPersona) {
                        case 0:
                            System.out.println("Arrivederci!");
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        } while (sceltaDellaPersona!=0);
    }
}
