/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet_ihm;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *This class display the Help instructions to the user
 * @author Charlotte Fievet
 */
public class Aide extends Parent{
    /**
     * this method builds the help instructions
     */
    public Aide(){
        
        //add a background to the first component (the title)
        Rectangle fond_barre = new Rectangle(860,80,Color.BLANCHEDALMOND);
        fond_barre.setStroke(Color.BLACK);
        this.getChildren().add(fond_barre);
        
        //Add the title 
        Text encadre = new Text("Aide");
        encadre.setFill(Color.BLACK);
        encadre.setFont(new Font(40));
        encadre.setTranslateY(55);
        encadre.setTranslateX(390);
        this.getChildren().add(encadre);
        
        //Add a background to the help instructions
        Rectangle fond_para = new Rectangle(860,700,Color.BLANCHEDALMOND);
        fond_para.setStroke(Color.BLACK);
        fond_para.setTranslateY(100);
        
        //Add the text for instructions
        Label paragraphe ; 
        paragraphe = new Label("         Dans le menu à gauche vous trouvez le bouton d'ajout d'étudiant,d'affichage de la liste, \nd'aide et enfin de sortie de l'application. \n\n         Lors de l'ajout d'un étudiant veillez à remplir entièrement le formulaire afin qu'il soit \najouté à la liste. Une fois ce formulaire complété et la saisie vérifiée, appuyer sur valider pour \nque les données de l'étudiant soient ajoutées à la table.\n\n        Si lors de la validation de l'ajout étudiant un message apparait disant Bienvenue c'est \nqu'il a bien été ajouté à la liste; sinon c'est qu'il y a une erreur et donc d'autres types de \nmessage apparraissent: il se peut que la date de naissance(birthday) ne soit pas renseignée \nou bien le nom/prénom ou la promo.\n\n        Au niveau de la liste des étudiants vous pouvez trier la liste par ordre alphabétique par \ndate de naissance ou par promo en selectionnant les flèches de chaque colonnes.\n\n        Pour modifier un étudiant il suffit de cliquer sur le bouton modifier de la ligne en question \nde même pour supprimer une ligne il suffit de cliquer sur le bouton correspondant à la ligne à \nsupprimer.\n\n\n        En vous souhaitant une agréable utilisation de notre gestionnaire\n\n\n         Réalisé par Natasha Germain et Charlotte Fievet ");
        paragraphe.setFont(Font.font("Arial",20));
        paragraphe.setTranslateY(130);
        paragraphe.setTranslateX(20);
        
        this.getChildren().add(fond_para);
        this.getChildren().add(paragraphe);
        
        
        
        //display all of this at a precise position
        this.setTranslateY(20);
        
        
        
    }
    
    
}
