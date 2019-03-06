/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet_ihm;

import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Chacha
 */
public class Aide extends Parent{
    public Aide(){
        Rectangle fond_barre = new Rectangle(860,80,Color.BLANCHEDALMOND);
        Text encadre = new Text("Aide");
        Rectangle fond_para = new Rectangle(860,700,Color.BLANCHEDALMOND);
        Text paragraphe ;
        
       
        
        fond_barre.setStroke(Color.BLACK);
        this.getChildren().add(fond_barre);

        encadre.setFill(Color.BLACK);
        encadre.setFont(new Font(40));
        encadre.setTranslateY(55);
        encadre.setTranslateX(390);
        this.getChildren().add(encadre);
        
        fond_para.setStroke(Color.BLACK);
        fond_para.setTranslateY(100);
        
        paragraphe = new Text("Dans le menu à gauche vous trouvez le bouton d'ajout d'étudiant et celui d'affichage de la liste \nLors de l'ajout d'un étudiant veillez à remplir entièrement le formulaire afin qu'il soit ajouté à la liste \nune fois complété appuyer sur valider pour passer à l'étape de confirmation de saisie ou annuler pour quitter l'ajout");
        paragraphe.setFill(Color.BLACK);
        paragraphe.setTranslateY(130);
        paragraphe.setTranslateX(20);
        this.getChildren().add(fond_para);
        this.getChildren().add(paragraphe);
        
        
        
        //this.setTranslateX(650);
        this.setTranslateY(20);
        
        
        
    }
    
    
}
