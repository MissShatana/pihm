
package mini_projet_ihm;

import java.time.LocalDate;

/**
 *The class builds a student
 * @author Natasha Germain
 */
public class Etudiant {
    private String nomEtudiant;
    private String prenomEtudiant;
    private String promoEtudiant;
    private LocalDate naissanceEtudiant;
    
    /**
     * This method builds a student
     * @param nomEtu is the student's surname
     * @param prenomEtu is the student's name
     * @param naissanceEtu is the student's birthday
     * @param promoEtu is the student's promo
     */
    public Etudiant(String nomEtu, String prenomEtu, LocalDate naissanceEtu, String promoEtu){
    this.nomEtudiant = nomEtu;
    this.prenomEtudiant= prenomEtu;
    this.naissanceEtudiant= naissanceEtu;
    this.promoEtudiant= promoEtu;
    }
    
    public String getNom(){
        return nomEtudiant;
    }
    
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
