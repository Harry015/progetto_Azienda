/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progetto_azienda;


import eccezioni.AziendaVuotaException;
import eccezioni.RepartoNonTrovatoException;
import eccezioni.AziendaPienaException;
import eccezioni.CapoRepartoNonTrovatoException;
import eccezioni.DipendenteNonTrovatoException;
import eccezioni.FileException;
import eccezioni.RepartoPienoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.TextFile;

/**
 *
 * @author Studente
 */
public class Azienda {
    
    private static final int NUM_MAX_REPARTI=5;
    private String nome;
    private ArrayList<Reparto> reparti;
    
    public Azienda(String nomeAzienda)
    {
        this.nome=nomeAzienda;
        reparti=new ArrayList<>();
    }
    
    /**
     * metodo per aggiungere un reparto
     * @param r
     * @throws AziendaPienaException 
     */
    public void aggiungiReparto(Reparto r) throws AziendaPienaException{
        int x=0;
        if(getNumReparti()>5)
            throw new AziendaPienaException();
        else
            reparti.add(r);
    }
    
    /**
     * metodo per ottenere un reparto in base al reparto
     * @param id
     * @return
     * @throws RepartoNonTrovatoException 
     */
    public Reparto getReparto(int id) throws RepartoNonTrovatoException{
        int x=0;
        for (Reparto r : reparti) {
            if (r.getId_Reparto()==id) {
                x=1;
                return r;
            }
        }
        if(x==0)
            throw new RepartoNonTrovatoException();
        return null;
    }
    
    /**
     * metodo per rimuovere un reparto
     * @param id
     * @throws RepartoNonTrovatoException 
     */
    public void rimuoviReparto(int id) throws RepartoNonTrovatoException{
        boolean x=false;
        for (Reparto r : reparti) {
            if (r.getId_Reparto()==id) {
                x=reparti.remove(r);
                break;
            }
        }
        if(x==false)
            throw new RepartoNonTrovatoException();
    }
    
    public int getNumReparti()
    {
        int c=0;
        for (Reparto r : reparti) {
            if (r!=null) {
                c++;
            }
        }
        return c;
    }
    
    /**
     * metodo per restituire il reparto di appartenenza di un dipendente
     * @param id
     * @return
     * @throws AziendaVuotaException 
     */
    public Reparto RepartoAppartenenza(int id) throws AziendaVuotaException
    {
        if(getNumReparti()==0)
            throw new AziendaVuotaException();
        Dipendente d;
        for (Reparto r : reparti) {
            if (r!=null) {
                try {
                    d=r.getDipendente(id);
                    if(d!=null)
                       return r;
                } 
                catch (DipendenteNonTrovatoException ex) {
                    //vai avanti
                }
            }
        }
        return null;
    }
    
    /**
     * metodo che restituisce id del reparto di appartenenza di un dipendente
     * @param id
     * @return
     * @throws AziendaVuotaException 
     */
    public int idRepartoAppartenenza(int id) throws AziendaVuotaException
    {
        if(getNumReparti()==0)
            throw new AziendaVuotaException();
        Dipendente d;
        for (Reparto r : reparti) {
            if (r!=null) {
                try {
                    d=r.getDipendente(id);
                    if(d!=null)
                       return r.getId_Reparto();
                } 
                catch (DipendenteNonTrovatoException ex) {
                    //vai avanti
                }
            }
        }
        return -1;
    }
    
    /**
     * metodo che restiutisce reparti gestiti da un capo reparto
     * @param nomeCapoReparto
     * @return 
     */
    public String RepartiCheGestisci(String nomeCapoReparto)
    {
        String s="";
        for (Reparto r : reparti) {
            if (r!=null) {
                try {
                    if(r.getNomeCapoReparto().equals(nomeCapoReparto))
                        s+=r.toString();
                } 
                catch (CapoRepartoNonTrovatoException ex) {
                    //vai avanti
                }
            }
        }
        return s;
    }
    
    /**
     * metodo per ottenere un dipendente in base al id
     * @param id
     * @return
     * @throws DipendenteNonTrovatoException 
     */
    public Dipendente getDipendenteConId(int id) throws DipendenteNonTrovatoException{
        Dipendente d=null;
        for (Reparto reparto : reparti) {
            try {
                d=reparto.getDipendente(id);
            } 
            catch (DipendenteNonTrovatoException|NullPointerException ex) {
                // Vai avanti
            }
        }
        if(d==null)
            throw new DipendenteNonTrovatoException();
        return d;
    }
    
    public void esportaDipendentiCSV(String nomeFile) throws IOException, FileException
    {
        Dipendente d;
        String dipendenteCSV;
        TextFile f1;
        
        //Prima cancello i dipendenti presenti nel file
        f1=new TextFile(nomeFile, 'W');
        f1.close();
        
        //Poi apro il file in append per aggiungere, uno alla volta, i dipendenti dell'azienda
        f1=new TextFile(nomeFile, 'W',true); //Apro il file in scrittura in append
        for (Reparto reparto : reparti) {
            for (int i = 0; i < reparto.getLength(); i++) {
                try {
                    d=reparto.getDipendente(i);
                    dipendenteCSV=d.getNome()+";"+d.getCognome()+";"+d.getRuolo()+";";
                    f1.toFile(dipendenteCSV);
                } 
                catch (DipendenteNonTrovatoException ex) {
                    // vai avanti
                }
            }
        }
       f1.close();
    }
    
    public void importaDipendentiCSV(String nomeFile) throws IOException
    {
        TextFile f1=new TextFile(nomeFile, 'R'); //Apro il file in lettura
        String dipendenteLetto;
        String[] dipendenteLettoSplit;
        String nome,cognome,ruolo;
        
        Dipendente d = null;
        int id;
        
        try 
        {
            //ciclo di lettura da file
            dipendenteLetto=f1.fromFile();  
            while(dipendenteLetto!=null)
            {     
               
                dipendenteLettoSplit=dipendenteLetto.split(";");
                nome=dipendenteLettoSplit[0];
                cognome=dipendenteLettoSplit[1];
                ruolo=dipendenteLettoSplit[2];
                id=Integer.parseInt(dipendenteLettoSplit[0]);
                d=new Dipendente(nome, cognome, ruolo);
                for (Reparto reparto : reparti) {
                    try {
                        if(reparto.getId_Reparto()==idRepartoAppartenenza(id))
                            reparto.aggiungiDipendente(d);
                    } 
                    catch (AziendaVuotaException|RepartoPienoException ex) {
                        System.out.println("Impossibile importare il dipendente!");
                    }
                } 
                
                dipendenteLetto=f1.fromFile();   //Leggo il libro successivo
            }
        } 
        catch (FileException ex) 
        {
           //Esce dal ciclo quando il file è terminato oppure è stato apreto in scrittura anzichè in lettura
        }
        f1.close();
    }
    
    public void salvaAzienda(String nomeFile) throws FileNotFoundException, IOException
    {
        
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream output=new ObjectOutputStream(f1);
        output.writeObject(this);
        output.flush();
        output.close();
    }
    
    public static Azienda caricaAzienda(String nomeFile) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream f1=new FileInputStream(nomeFile);
        ObjectInputStream input=new ObjectInputStream(f1);
        Azienda a;    
        a=(Azienda)input.readObject();
        input.close();
        return a;
    }
    
    
    public String toString()
    {
        String s="";
        for(int i=0;i<reparti.size();i++)
        {
            if (reparti.get(i)==null)
                s+="Reparto "+i+" --> Vuoto\n";
            else
                s+=reparti.get(i).toString()+"\n";
        }
        return s;
    }
}
