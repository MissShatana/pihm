/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet_ihm;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Chacha
 */
public class Mini_projet_IHM extends Application {
        private final TableView<Etudiant> table = new TableView<>();
    public final ObservableList<Etudiant> data =
            FXCollections.observableArrayList();
        private Formulaire formulaire;
        private TableauEtu tabEtu;
        private Formulaire formModif;
    public static void main(String[]args){
        Application.launch(Mini_projet_IHM.class,args);
        
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("gestionnaire d'étudiants Gphy");
        Group root,menu;
        root= new Group();
        Scene scene = new Scene(root,1300,700);
        menu = new Group();
        LeMenu mon_menu= new LeMenu();
        Aide mon_aide=new Aide();
        Quitter mon_quitter = new Quitter();
        BorderPane reste = new BorderPane();
        formulaire = new Formulaire();
        Etudiant etuTest = new Etudiant("Germain","Natasha", LocalDate.now(),"L3");
        formModif = new Formulaire(etuTest);
        formModif.setVisible(false);
        data.add(etuTest);
        data.add(new Etudiant("Germain","Natasha", LocalDate.now(),"L3"));
        tabEtu = new TableauEtu(data, formModif);
        
        tabEtu.table.cellButton.
        
        // ajout d'une image de fond 
       Image promo = new Image(Mini_projet_IHM.class.getResourceAsStream("images/photo_promo.jpg"));
       ImageView promo_fond = new ImageView();
       promo_fond.setImage(promo);
       promo_fond.setOpacity(0.5);
       promo_fond.setFitWidth(1700);
       promo_fond.setTranslateX(260);
       promo_fond.setTranslateY(-200);
        
//       tabEtu = new TableauEtu(data, formModif);
//       formulaire = new Formulaire();
        
        
        menu.getChildren().add(mon_menu);
        root.getChildren().addAll(menu,promo_fond,reste);
        reste.setTranslateX(700);
        reste.setAlignment(reste,Pos.CENTER);
        
        mon_menu.ajouter.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                reste.getChildren().clear();
                //formulaire= new Formulaire(this);
                formulaire.setVisible(true);
                tabEtu.setVisible(false);
                reste.getChildren().add(formulaire);
                reste.getChildren().add(tabEtu);
            }
        });
        
        mon_menu.liste.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                reste.getChildren().clear();
                //formulaire=new Formulaire(this);
                tabEtu.setVisible(true);
                formulaire.setVisible(false);
                reste.getChildren().add(tabEtu);
            }
        });
        
    
        mon_menu.aide.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                    reste.getChildren().clear();
                    reste.getChildren().add(mon_aide);
            }
        });
         mon_menu.quitter.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                reste.getChildren().clear();
                reste.getChildren().add(mon_quitter);
            }
        });
         
        mon_quitter.valider.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                    System.exit(0);
            }
         });
         
        mon_quitter.annuler.setOnMousePressed(new EventHandler<MouseEvent>(){
             public void handle(MouseEvent me){
                 reste.getChildren().remove(mon_quitter);
             }
         });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void setEtu(Etudiant newEtu){
        tabEtu.setTable(newEtu);
    }
    
     public ObservableList<Etudiant> getEtu(){
        return data;
    }
}

   
    
