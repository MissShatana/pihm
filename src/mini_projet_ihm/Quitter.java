
package mini_projet_ihm;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *This class create a Quit window that allows users cancel if they do not really want quit the application but quit if they really want it 
 * @author Charlotte Fievet
 */
public class Quitter extends Parent{
    
    Button valider,annuler;
    /**
     * This method create the window 
     */
    public Quitter(){
        // add a white background with black stroke 
        Rectangle fond_fenetre = new Rectangle(330,150);
        fond_fenetre.setFill(Color.WHITE);
        fond_fenetre.setStroke(Color.BLACK);
        this.getChildren().add(fond_fenetre);
        
        // add a question to make sure that they want to quit application 
        Text confirmation = new Text("Voulez-vous vraiment quitter l'application ?");
        confirmation.setTranslateX(20);
        confirmation.setTranslateY(50);
        
        // add the 2 buttons Validate and cancel 
        valider = new Button("Valider");
        annuler = new Button("Annuler");
        HBox boutons = new HBox();
        boutons.setTranslateX(120);
        boutons.setTranslateY(100);
        boutons.setSpacing(10);
        boutons.getChildren().addAll(valider,annuler);
        
        this.getChildren().addAll(confirmation,boutons);
        
        //set the position of the window
        this.setTranslateX(170);
        this.setTranslateY(100);
    }
    
}
