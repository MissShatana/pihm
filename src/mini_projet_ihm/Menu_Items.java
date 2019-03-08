
package mini_projet_ihm;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * This class builds Items used in the menu 
 * @author Charlotte
 */
public class Menu_Items extends Parent{
    public String motif;
    private final int positionX,positionY;//abcsisse et ordonée de la touche  
    Rectangle fond_item;
    
    /**
     * This method buils a button/item used in a menu 
     * @param l is the message displayed in the button 
     * @param posX is the position of the button on the X axis
     * @param posY is the position of the button on the Y axis
     * @param url is the pathway to the icon linked to the button
     */
    public Menu_Items(String l,int posX,int posY,String url){
        motif= new String(l);
        positionX = posX;
        positionY = posY;
        Text motif_item;
        
        //set an image in an icone
        Image image = new Image(Menu_Items.class.getResourceAsStream(url));
        ImageView icone=new ImageView();
        icone.setImage(image);
        icone.setFitWidth(25);
        icone.setFitHeight(25);
        
        // add a blue background and a black strocke to put border to the button
        fond_item= new Rectangle(260,50,Color.DODGERBLUE);
        fond_item.setStroke(Color.BLACK);
        this.getChildren().add(fond_item);
        this.setTranslateX(positionX);
        this.setTranslateY(positionY);
        
        // add a text in the button 
        motif_item = new Text(motif);
        motif_item.setFont(new Font(25));
        motif_item.setFill(Color.BLACK);
        motif_item.setX(10);
        motif_item.setY(45);
        
        //add the icone next to the text of the button
        HBox box = new HBox();
        box.setSpacing(10);
        box.setPadding(new Insets(10, 10, 10, 10));
        box.getChildren().addAll(motif_item,icone);
        this.getChildren().add(box);
        
        // set the position of each button 
        this.setTranslateX(positionX);
        this.setTranslateY(positionY);
        
        // add an event : if the mouse enter on the button it will change its color to notify this mouse position 
        this.setOnMouseEntered((MouseEvent me) -> {
            fond_item.setFill(Color.AQUA);
        });
        // another event that show the mouse exit by taking back the first blue color
        this.setOnMouseExited((MouseEvent me) -> {
            fond_item.setFill(Color.DODGERBLUE);
        });     
    }
}
