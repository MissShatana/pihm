/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet_ihm;


import javafx.scene.Parent;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Chacha
 */
public class LeMenu extends Parent{
    private Menu_Items[] items;
    Menu_Items ajouter,liste,aide,quitter;
    private Mini_projet_IHM ihm;
    
   public LeMenu(){
    final Rectangle fond_menu = new Rectangle(0,0,0,0);
    fond_menu.setWidth(260);
    fond_menu.setHeight(1000);
    fond_menu.setFill(Color.DODGERBLUE);
    Reflection r = new Reflection();//on applique un effet de réflection
      r.setFraction(0.25);
      r.setBottomOpacity(0);
      r.setTopOpacity(0.5);
    fond_menu.setEffect(r);
    this.getChildren().add(fond_menu);
    
    VBox barremenu = new VBox();
    barremenu.setSpacing(10);
    ajouter = new Menu_Items("Ajouter un étudiant",0,20,"images/croix.png");
    liste = new Menu_Items("Liste des étudiants",0,80,"images/liste.png");
    aide =  new Menu_Items("Aide",0,140,"images/aide.png");
    quitter = new Menu_Items("Quitter",0,200,"images/quit.png");
    
    this.getChildren().addAll(ajouter,liste,aide,quitter);
    Image gphy = new Image(LeMenu.class.getResourceAsStream("images/gphy.jpg"));
    ImageView logo =new ImageView();
    logo.setImage(gphy);
    logo.setFitHeight(200);
    logo.setFitWidth(200);
    logo.setY(600);
    logo.setX(30);
    this.getChildren().add(logo);
    this.setTranslateX(0);
    this.setTranslateY(0);
    
    
    
   
    this.getChildren().addAll(barremenu);
    
   
   } 

}
