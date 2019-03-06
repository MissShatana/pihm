/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet_ihm;

import javafx.event.EventHandler;
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
 *
 * @author Chacha
 */
public class Menu_Items extends Parent{
    public String motif;//lettre de la touche. public car lue par les autres classes
    private int positionX,positionY;//abcsisse et ordonée de la touche  
    Rectangle fond_item;
    
    
    
    public Menu_Items(String l,int posX,int posY,String url){
        motif= new String(l);
        positionX = posX;
        positionY = posY;
        Text motif_item;
        Image image = new Image(Menu_Items.class.getResourceAsStream(url));
        ImageView icone=new ImageView();
        icone.setImage(image);
        icone.setFitWidth(25);
        icone.setFitHeight(25);
        
        fond_item= new Rectangle(260,50,Color.DODGERBLUE);
        fond_item.setStroke(Color.BLACK);
        this.getChildren().add(fond_item);
        this.setTranslateX(positionX);
        this.setTranslateY(positionY);
        
        motif_item = new Text(motif);
        motif_item.setFont(new Font(25));
        motif_item.setFill(Color.BLACK);
        motif_item.setX(10);
        motif_item.setY(45);
        
        HBox box = new HBox();
        box.setSpacing(10);
        box.setPadding(new Insets(10, 10, 10, 10));
        box.getChildren().addAll(motif_item,icone);
        this.getChildren().add(box);
    
        this.setTranslateX(positionX);
        this.setTranslateY(positionY);
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                fond_item.setFill(Color.AQUA);
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                fond_item.setFill(Color.DODGERBLUE);
            }
        });
        this.setOnMousePressed(new EventHandler<MouseEvent>(){
        public void handle(MouseEvent me){
            appuyer();
        }
    });
    
    this.setOnMouseReleased(new EventHandler<MouseEvent>(){
        public void handle(MouseEvent me){
            relacher();
        }
    });
    }
    public void appuyer(){
        fond_item.setFill(Color.AQUA);
        this.setTranslateY(positionY+2);
        
 
    }
    
    public void relacher(){
        fond_item.setFill(Color.AQUA);
        this.setTranslateY(positionY);
        
    }

    void setOnAction(EcouteurForm e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
