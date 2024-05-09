/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progetto_azienda;

import eccezioni.AziendaPienaException;
import eccezioni.AziendaVuotaException;
import eccezioni.DipendenteNonTrovatoException;
import eccezioni.FileException;
import eccezioni.RepartoNonTrovatoException;
import eccezioni.RepartoPienoException;
import eccezioni.dataNonValidaException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
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
        Azienda a1=new Azienda("xyz");
        
        int numeroVociMenu=4,x=0;
        int sceltaPersona=0;
        int sceltaDellaPersona=0;
        
        int id=0;
        Reparto rep;
        Dipendente dip=null;
        String nomeFile;
        
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
                case 1: //Persona --> Dipendente
                    System.out.println("Inserisci il tuo id:");
                    id=tastiera.nextInt();
                    x=1;
                    
                    try {
                        dip=a1.getDipendenteConId(id);
                    }
                    catch (DipendenteNonTrovatoException ex) {
                        System.out.println("Dipendente non trovato!");
                    }
                    
                    try {
                        rep=a1.RepartoAppartenenza(id);
                    } 
                    catch (AziendaVuotaException ex) {
                        System.out.println("Non ci sono reparti nell'azienda!\n");
                        break;
                    }
                    
                    numeroVociMenu=4;
                    vociMenu=new String[numeroVociMenu];
                    vociMenu[0]="0 -->\tEsci";
                    vociMenu[1]="1 -->\tVisualizza il reparto di appartenenza";
                    vociMenu[2]="2 -->\tVisualizza la lista di tutti i dipendenti del tuo reparto";
                    vociMenu[3]="3 -->\tRichiedi ferie";
                    m2=new Menu(vociMenu);
                    
                    
                    
                    do {     
                        sceltaDellaPersona=m2.sceltaMenu();
                        switch (sceltaDellaPersona) {
                        case 0:
                            System.out.println("Arrivederci!");
                            break;
                        case 1:
                            System.out.println(rep.getNomeReparto());
                            break;
                        case 2:
                            System.out.println(rep.toString());
                            break;
                        case 3:
                            int g,m,a;
                            String motivo="";
                            System.out.println("Inserisci data inizio:\n");
                            System.out.println("Giorno:");
                            g=tastiera.nextInt();
                            System.out.println("Mese:");
                            m=tastiera.nextInt();
                            System.out.println("Anno:");
                            a=tastiera.nextInt();
                            LocalDate dataInizio=LocalDate.of(a, m, g);
                            System.out.println("\nInserisci data fine:\n");
                            System.out.println("Giorno:");
                            g=tastiera.nextInt();
                            System.out.println("Mese:");
                            m=tastiera.nextInt();
                            System.out.println("Anno:");
                            a=tastiera.nextInt();
                            LocalDate dataFine=LocalDate.of(a, m, g);
                            tastiera.nextLine();
                            System.out.println("Inserisci il motivo:");
                            motivo=tastiera.nextLine();
                            Ferie ferie;
                            try {
                                ferie = new Ferie(dataInizio, dataFine, motivo);
                                if(dip==null)
                                    System.out.println("Impossibile inviare la richiesta!");
                                else
                                    dip.setFerie(ferie);
                            } catch (dataNonValidaException ex) {
                                System.out.println("Richiesta non valida!");
                            }
                            break;
                        default:
                            break;
                        }
                    } while (sceltaDellaPersona!=0);
                    break;


                    
                case 2: //Persona --> Capo Reparto
                    System.out.println("Inserisci il tuo id:");
                    id=tastiera.nextInt();
                    x=1;
                    
                    try {
                        dip=a1.getDipendenteConId(id);
                    }
                    catch (DipendenteNonTrovatoException ex) {
                        System.out.println("Capo Reparto non trovato!");
                    }
                    
                    try {
                        rep=a1.RepartoAppartenenza(id);
                    } 
                    catch (AziendaVuotaException ex) {
                        System.out.println("Non ci sono reparti nell'azienda!\n");
                        break;
                    }
                    
                    numeroVociMenu=7;
                    vociMenu=new String[numeroVociMenu];
                    vociMenu[0]="0 -->\tEsci";
                    vociMenu[1]="1 -->\tVisualizza i reparti che gestisci";
                    vociMenu[2]="2 -->\tApprova richieste ferie";
                    vociMenu[3]="3 -->\tOrdina la lista dei dipendenti in ordine Alfabetico";
                    vociMenu[4]="4 -->\tAggiungi Dipendente";
                    vociMenu[5]="5 -->\tRimuovi dipendente";
                    vociMenu[6]="6 -->\tModifica Dipendente";
                    m2=new Menu(vociMenu);
                    
                    
                    
                    do {       
                        sceltaDellaPersona=m2.sceltaMenu();
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
                            System.out.println("Inserisci id del dipendente per il quale vuoi approvare richeste ferie:");
                            id=tastiera.nextInt();
                            try {
                                dip=a1.getDipendenteConId(id);
                                rep.approvaRichiesteFerie(dip);
                            } 
                            catch (DipendenteNonTrovatoException ex) {
                                System.out.println("Dipendente non trovato!");
                            }
                            break;

                        case 3:
                            Dipendente[] ordine=new Dipendente[rep.ordineAlfabeticoDipendenti().length];
                            ordine=rep.ordineAlfabeticoDipendenti();
                            for (int i = 0; i < ordine.length; i++) {
                                System.out.println(ordine[i].toString());
                            }
                            break;
                        case 4:
                            String n,c,r;
                            System.out.println("Inserisci il nome:");
                            n=tastiera.nextLine();
                            System.out.println("Inserisci il cognome:");
                            c=tastiera.nextLine();
                            System.out.println("Inserisci il ruolo:");
                            r=tastiera.nextLine();
                            Dipendente d1=new Dipendente(n,c,r);
                            try {
                                rep.aggiungiDipendente(d1);
                            } 
                            catch (RepartoPienoException ex) {
                                System.out.println("Impossibile aggiungere il dipendente perchè il reparto è pieno!");
                            }
                            break;
                        case 5:
                            try {
                                System.out.println("Inserisci id del dipendente che vuoi togliere:");
                                id=tastiera.nextInt();
                                rep.rimuoviDipendente(id);
                            } 
                            catch (DipendenteNonTrovatoException ex) {
                                System.out.println("Dipendente non trovato!");
                            }
                            break;
                        case 6:
                            System.out.println("Inserisci id del dipendente che vuoi modificare:");
                            id=tastiera.nextInt();
                            rep.modificaDipendente(id);
                            break;
                        default:
                            break;
                        }
                    } while (sceltaDellaPersona!=0);
                    break;
                case 3: //Persona --> Capo Azienda
                    x=1;
                    numeroVociMenu=9;
                    vociMenu=new String[numeroVociMenu];
                    vociMenu[0]="0 -->\tEsci";
                    vociMenu[1]="1 -->\tVisualizza i reparti";
                    vociMenu[2]="2 -->\tAggiungi reparto";
                    vociMenu[3]="3 -->\tRimuovi reparto";
                    vociMenu[4]="4 -->\tEsporta su file CSV";
                    vociMenu[5]="5 -->\tImporta da file CSV";
                    vociMenu[6]="6 -->\tSalva azienda";
                    vociMenu[7]="7 -->\tcarica azienda";
                    vociMenu[8]="8 -->\tAggiungi capo reparto";
                    m2=new Menu(vociMenu);
                    
                    do {         
                        sceltaDellaPersona=m2.sceltaMenu();
                        switch (sceltaDellaPersona) {
                        case 0:
                            System.out.println("Arrivederci!");
                            break;
                        case 1:
                            System.out.println(a1.toString());
                            break;
                        case 2:
                            String nomeReparto;
                            tastiera.nextLine();
                            System.out.println("Inserisci il nome del reparto:");
                            nomeReparto=tastiera.nextLine();
                            Reparto r1=new Reparto(nomeReparto);
                            try {
                                a1.aggiungiReparto(r1);
                            } catch (AziendaPienaException ex) {
                                System.out.println("Impossibile aggiungere il reparto perchè l'azienda è piena!");
                            }
                            break;

                        case 3:
                            try {
                                System.out.println("Inserisci id del reparto che vuoi togliere:");
                                id=tastiera.nextInt();
                                a1.rimuoviReparto(id);
                            } 
                            catch (RepartoNonTrovatoException ex) {
                                System.out.println("Reparto non trovato!");
                            }
                            break;
                        case 4: // Esp Csv
                            nomeFile="dipendenti.csv";
                            {
                                try {
                                    a1.esportaDipendentiCSV(nomeFile);
                                } 
                                catch (IOException ex) {
                                    System.out.println("Operazione non è andata a buon fine!");
                                } catch (FileException ex) {
                                    System.out.println("Operazione non è andata a buon fine!");
                                }
                            }
                            break;

                        case 5: // Imp Csv
                            nomeFile="dipendenti.csv";
                            try {
                                a1.importaDipendentiCSV(nomeFile);
                            } 
                            catch (IOException ex) {
                                System.out.println("Operazione non è andata a buon fine!");
                            }
                            break;

                        case 6: // Ser
                            nomeFile="aziend.bin";
                            try {
                                a1.salvaAzienda(nomeFile);
                            } 
                            catch (IOException ex) {
                                System.out.println("Operazione non è andata a buon fine!");
                            }
                            break;

                        case 7: // Deser
                            nomeFile="azienda.bin";
                            try {
                                a1.caricaAzienda(nomeFile);
                            } 
                            catch (IOException ex) {
                                System.out.println("Operazione non è andata a buon fine!");                            } 
                            catch (ClassNotFoundException ex) {
                                System.out.println("Operazione non è andata a buon fine!");                            }
                        break;

                        case 8:
                            System.out.println("Inserisci id del reparto al quale vuoi aggiungere il capoReparto:");
                            id=tastiera.nextInt();
                            try {
                                rep=a1.getReparto(id);
                                String n,c,r;
                                tastiera.nextLine();
                                System.out.println("Inserisci il nome:");
                                n=tastiera.nextLine();
                                System.out.println("Inserisci il cognome:");
                                c=tastiera.nextLine();
                                System.out.println("Inserisci il ruolo:");
                                r=tastiera.nextLine();
                                Dipendente d1=new Dipendente(n,c,r);
                                try {
                                    rep.aggiungiDipendente(d1);
                                } 
                                catch (RepartoPienoException ex) {
                                    System.out.println("Impossibile aggiungere il dipendente perchè il reparto è pieno!");
                                }
                            } 
                            catch (RepartoNonTrovatoException ex) {
                                System.out.println("Reparto non trovato!");
                            }

                        default:
                            break;
                        }
                    } while (sceltaDellaPersona!=0);
                    break;    
                default:
                    break;
            }
        } while ((sceltaPersona!=0));
    }
}
