/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet_ihm;


import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *This class display the four Menu Items into a blue rectangle used as a vertical menu
 * @author Charlotte Fievet
 */
public class LeMenu extends Parent{
    
    Menu_Items ajouter,liste,aide,quitter;
    
    /** 
     * This method creates the vertical menu displaying the 4 items used in our application
     * 
     */
   public LeMenu(){
       
    // add a blue background to our menu
    final Rectangle fond_menu = new Rectangle(0,0,0,0);
    fond_menu.setWidth(260);
    fond_menu.setHeight(1000);
    fond_menu.setFill(Color.DODGERBLUE);
    this.getChildren().add(fond_menu);
    
    // add Items from Menu_Items class
    VBox barremenu = new VBox();
    barremenu.setSpacing(10);
    ajouter = new Menu_Items("Ajouter un étudiant",0,20,"images/croix.png");
    liste = new Menu_Items("Liste des étudiants",0,80,"images/liste.png");
    aide =  new Menu_Items("Aide",0,140,"images/aide.png");
    quitter = new Menu_Items("Quitter",0,200,"quitter.jpg");
    this.getChildren().addAll(ajouter,liste,aide,quitter);
    
    // add a logo at the bottom of the menu
    Image gphy = new Image(LeMenu.class.getResourceAsStream("images/gphy.jpg"));
    ImageView logo =new ImageView();
    logo.setImage(gphy);
    logo.setFitHeight(200);
    logo.setFitWidth(200);
    logo.setY(600);
    logo.setX(30);
    this.getChildren().add(logo);
    
    // this menu will stay at the left of the screen 
    this.setTranslateX(0);
    this.setTranslateY(0);
   } 

}
