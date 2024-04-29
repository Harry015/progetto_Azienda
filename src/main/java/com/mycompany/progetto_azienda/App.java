/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progetto_azienda;

import eccezioni.AziendaPienaException;
import eccezioni.RepartoPienoException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.Menu;

/**
 *
 * @author harry
 */
public class App {

    public static void main(String[] args) {
        
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
        
        Menu m2 = null;
        do {            
            sceltaPersona=m1.sceltaMenu();
            switch (sceltaPersona) {
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                case 1:
                    x=1;
                    numeroVociMenu=5;
                    vociMenu=new String[numeroVociMenu];
                    vociMenu[0]="0 -->\tEsci";
                    vociMenu[1]="1 -->\tVisualizza le tue informazioni";
                    vociMenu[2]="2 -->\tVisualizza il reparto di appartenenza";
                    vociMenu[3]="3 -->\tVisualizza la lista dei tuoi colleghi";
                    vociMenu[4]="4 -->\tRichiedi ferie";
                    m2=new Menu(vociMenu);
                    break;
                case 2:
                    x=1;
                    numeroVociMenu=5;
                    vociMenu=new String[numeroVociMenu];
                    vociMenu[0]="0 -->\tEsci";
                    vociMenu[1]="1 -->\tVisualizza le tue informazioni";
                    vociMenu[2]="2 -->\tVisualizza la lista dei dipendenti del tuo riparto";
                    vociMenu[3]="3 -->\tAssegna un compito a un dipendente";
                    vociMenu[4]="4 -->\tApprova richieste ferie";
                    m2=new Menu(vociMenu);
                    break;
                case 3:
                    x=1;
                    vociMenu=new String[numeroVociMenu];
                    numeroVociMenu=7;
                    vociMenu[0]="0 -->\tEsci";
                    vociMenu[1]="1 -->\tVisualizza le informazioni dell'azienda";
                    vociMenu[2]="2 -->\tVisualizza la lista dei dipendenti";
                    vociMenu[3]="3 -->\tVisualizza la lista dei reparti";
                    vociMenu[4]="3 -->\tAssegna un progetto a un reparto";
                    vociMenu[5]="4 -->\tAggiungi reparto";
                    vociMenu[6]="4 -->\tAggiungi dipendente";
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
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            break;
                    }
                    break;
                case 2: //Persona --> Capo Reparto
                    switch (sceltaDellaPersona) {
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
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
