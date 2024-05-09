package com.mycompany.progetto_azienda;

import eccezioni.CapoRepartoNonTrovatoException;
import eccezioni.DipendenteNonTrovatoException;
import eccezioni.RepartoPienoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.Menu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Studente
 */
public class Reparto {
    
    private final static int NUM_MAX_DIPENDENTI=11;
    private ArrayList<Dipendente> dipendenti;
    private String nomeReparto;
    private int id_Reparto;
    private static int id=1;
    Scanner tastiera=new Scanner(System.in);
    
    /**
     * metodo che restituisce lunghezza del array list dipendenti
     * @return 
     */
    public int getLength(){
        return dipendenti.size();
    }
    
    /**
     * metodo che restituisce la lista dei dipendenti
     * @return 
     */
    public ArrayList getArrayDipendenti(){
        return dipendenti;
    }
    
    public int getId_Reparto() {
        return id_Reparto;
    }
    
    public void setId_Reaprto() {
        this.id_Reparto = id++;
    }
    
    public String getNomeReparto() {
        return nomeReparto;
    }

    public Reparto(String nomeReparto)
    {
        this.nomeReparto=nomeReparto;
        dipendenti=new ArrayList<>();
    }
    
    /**
     * metodo che consente di aggiungere un dipendente
     * @param d
     * @throws RepartoPienoException 
     */
    public void aggiungiDipendente(Dipendente d) throws RepartoPienoException {
        if(getNumDipendenti()>10)
            throw new RepartoPienoException();
        else
            dipendenti.add(d);
    }
    
    /**
     * metodo che restituisce un dipendente in base al id
     * @param id
     * @return
     * @throws DipendenteNonTrovatoException 
     */
    public Dipendente getDipendente(int id) throws DipendenteNonTrovatoException {
        int x=0;
        for (Dipendente dipendente : dipendenti) {
            if (dipendente.getId_Dipendente()==id) {
                x=1;
                return dipendente;
            }
        }
        if(x==0)
            throw new DipendenteNonTrovatoException();
        return null;
    }
    
    /**
     * metodo che restituisce il nome del capo reparto
     * @return
     * @throws CapoRepartoNonTrovatoException 
     */
    public String getNomeCapoReparto() throws CapoRepartoNonTrovatoException {
        int x=0;
        for (Dipendente dipendente : dipendenti) {
            if (dipendente.getRuolo().equalsIgnoreCase("capo reparto")) {
                x=1;
                return dipendente.getNome();
            }
        }
        if(x==0)
            throw new CapoRepartoNonTrovatoException();
        return "";
    }
    
    /**
     * metodo per rimuovere un dipendente
     * @param id
     * @throws DipendenteNonTrovatoException 
     */
    public void rimuoviDipendente(int id) throws DipendenteNonTrovatoException {
        boolean x=false;
        for (Dipendente dipendente : dipendenti) {
            if (dipendente.getId_Dipendente()==id) {
                x=dipendenti.remove(dipendente);
                break;
            }
        }
        if(x==false)
            throw new DipendenteNonTrovatoException();
    }
    
    /**
     * metodo che restituisce il numero di dipendenti presenti
     * @return 
     */
    public int getNumDipendenti()
    {
        int c=0;
        for (Dipendente dipendente : dipendenti) {
            if (dipendente!=null) {
                c++;
            }
        }
        return c;
    }
    
    /**
     * metodo che consente di approvare le richieste di ferire
     * @param d 
     */
    public void approvaRichiesteFerie(Dipendente d){
        ArrayList<Ferie> x=new ArrayList<>();
        x=d.getArrayFerie();
        int c;
        for (Ferie ferie : x) {
            if(ferie.isApprovato()==false){
                System.out.println(ferie.toString());
                System.out.println("Inserisci 1 per approvare questa richiesta altrimenti inserisci 0:");
                c=tastiera.nextInt();
                if(c==1)
                    ferie.setApprovato(true);
            }
        }
    }
    
    /**
     * metodo creato solo per fare test
     * @param d 
     */
    public void approvaRichiesteFeriePerTest(Dipendente d){
        ArrayList<Ferie> x=new ArrayList<>();
        x=d.getArrayFerie();
        int c=1;
        for (Ferie ferie : x) {
            if(ferie.isApprovato()==false){
                //System.out.println(ferie.toString());
                ferie.setApprovato(true);
            }
        }
    }
    
    /**
     * metodo che consente di modificare i dati del dipendente
     * @param id
     * @return 
     */
    public Dipendente modificaDipendente(int id){
        Dipendente dip=null;
        try {
            dip = getDipendente(id);
            Scanner tastiera=new Scanner(System.in);
            int num=4,scelta=0;
            String[] vociMenu=new String[num];
            Menu m1;
            vociMenu[0]="0 -->\tEsci";
            vociMenu[1]="1 -->\tModifica nome";
            vociMenu[2]="2 -->\tModifica cognome";
            vociMenu[3]="3 -->\tModifica ruolo";
            m1=new Menu(vociMenu);

            do {            
                scelta=m1.sceltaMenu();
                switch (scelta) {
                case 1:
                    System.out.print("Nuovo nome: ");
                    String nuovoNome = tastiera.nextLine();
                    dip.setNome(nuovoNome);
                    break;
                case 2:
                    System.out.print("Nuovo cognome: ");
                    String nuovoCognome = tastiera.nextLine();
                    dip.setCognome(nuovoCognome);
                    break;
                case 3:
                    System.out.print("Nuovo ruolo: ");
                    String nuovoRuolo = tastiera.nextLine();
                    dip.setRuolo(nuovoRuolo);
                    break;
                default:
                    break;
            }
            } while (scelta!=0);
            
        } 
        catch (DipendenteNonTrovatoException ex) {
            
        }
        return dip;
    }
    
    /**
     * metodo che restituisce un array di dipendenti in ordine alfabetico in base al nome
     * @return 
     */
    public Dipendente[] ordineAlfabeticoDipendenti()
    {
        ArrayList<Dipendente> x=new ArrayList<>();

        for (Dipendente dipendente : dipendenti) {
            x.add(dipendente);
        }
        
        x.toArray();
        Dipendente[] array = x.toArray(new Dipendente[x.size()]);

        for (int i=0;i<getLength()-1;i++)
        {
            for (int j=i;j<getLength();j++)
            {
                if (array[j].getNome().compareToIgnoreCase(array[i].getNome())<0)
                        scambia(array, i, j);
            }
        }
        return array;
    }
    
    public static void scambia (Dipendente[] array, int pos1, int pos2)
        {
            Dipendente s;
            s=array[pos1];
            array[pos1]=array[pos2];
            array[pos2]=s;
        }
    
    public String toString()
    {
        String s="";
        s+="Nome:"+nomeReparto+"\n";
        for(int i=0;i<dipendenti.size();i++)
        {
            if (dipendenti.get(i)==null)
                s+=i+"-->\n";
            else
                s+=i+"-->\t"+dipendenti.get(i).toString()+"\n";
        }
        return s;
    }
}
