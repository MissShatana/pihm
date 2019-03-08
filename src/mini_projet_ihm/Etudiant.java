/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet_ihm;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Natashaa
 */
public class Etudiant {
    private String nomEtudiant;
    private String prenomEtudiant;
    private String promoEtudiant;
    private LocalDate naissanceEtudiant;
    //private SimpleStringProperty nomEtudiant;
    //private final SimpleStringProperty lastName;

      
    
    public Etudiant(String nomEtu, String prenomEtu, LocalDate naissanceEtu, String promoEtu){
    this.nomEtudiant = nomEtu;
    this.prenomEtudiant= prenomEtu;
    this.naissanceEtudiant= naissanceEtu;
    this.promoEtudiant= promoEtu;
    }
    
    public String getNom(){
        return nomEtudiant;
    }
    
//    public void setNom(String nomEtu){
//        this.nomEtudiant= new SimpleStringProperty(nomEtu);
//    }
    
    public String getPrenom(){
        return prenomEtudiant;
    }
    
    public void setNom(String nomEtu){
        nomEtudiant=nomEtu;
    }
    
    public void setPrenom(String prenomEtu){
        prenomEtudiant=prenomEtu;
    }
    
    public LocalDate getNaissance(){
        return naissanceEtudiant;
    }
    
    public void setNaissance(LocalDate naissanceEtu){
        naissanceEtudiant=naissanceEtu;
    }
    
    public String getPromo(){
        return promoEtudiant;
    }
    
    public void setPromo(String promoEtu){
        promoEtudiant=promoEtu;
    }
}
