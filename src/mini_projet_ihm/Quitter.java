/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet_ihm;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author Chacha
 */
public class Quitter extends Parent{
    
    Button valider,annuler;
    
    public Quitter(){
        Rectangle fond_fenetre = new Rectangle(330,150);
        fond_fenetre.setFill(Color.WHITE);
        fond_fenetre.setStroke(Color.BLACK);
        this.getChildren().add(fond_fenetre);
        
        Text confirmation = new Text("Voulez-vous vraiment quitter l'application ?");
        confirmation.setTranslateX(20);
        confirmation.setTranslateY(50);
        
        valider = new Button("Valider");
        annuler = new Button("Annuler");
        HBox boutons = new HBox();
        boutons.setTranslateX(120);
        boutons.setTranslateY(100);
        boutons.setSpacing(10);
        boutons.getChildren().addAll(valider,annuler);
        
        this.getChildren().addAll(confirmation,boutons);
        this.setTranslateX(170);
        this.setTranslateY(100);
        
//         valider.setOnMousePressed(new EventHandler<MouseEvent>(){
//            public void handle(MouseEvent me){
//                    System.exit(0);
//            }
//         });
//         
//         annuler.setOnMousePressed(new EventHandler<MouseEvent>(){
//             public void handle(MouseEvent me){
//                trouver comment revenir en arrière 
//             }
//         });
    }
    
}
