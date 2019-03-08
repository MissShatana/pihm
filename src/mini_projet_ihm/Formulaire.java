
package mini_projet_ihm;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * This class builds a form to add or modify a student
 * @author Natasha Germain
 */
public class Formulaire extends Parent{
    
    private final TextField prenomField = new TextField();
    private final TextField nomField = new TextField();
    private final DatePicker naissanceField = new DatePicker();
    private final ComboBox<String> promoField;
    private Button submitButton;
    private Button modifButton;
    private final GridPane gridPane;
    private Mini_projet_IHM ihm;
    
    /**
     * This method builds a form to enter information of a new student
     * @param myIhm the main class
     */
    public Formulaire(Mini_projet_IHM myIhm){
        ihm=myIhm;
        // Instantiate a new Grid Pane
        gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(50);

        // Set the vertical gap between rows
        gridPane.setVgap(30);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(150, 150, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(300,300, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
       
        // Add Header
        Label headerLabel = new Label("Formulaire d'ajout d'étudiant");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add surname Label
        Label nameLabel = new Label("Nom : ");
        gridPane.add(nameLabel, 0,1);

        // Add surname Text Field
        nomField.setPrefHeight(40);
        gridPane.add(nomField, 1,1);

        // Add name Label
        Label prenomLabel = new Label("Prenom : ");
        gridPane.add(prenomLabel, 0, 2);

        // Add name Text Field
        prenomField.setPrefHeight(40);
        gridPane.add(prenomField, 1, 2);

        // Add Birthday Label
        Label naissanceLabel = new Label("Date de naissance : ");
        gridPane.add(naissanceLabel, 0, 3);

        // Add Birthday Field
        naissanceField.setPrefHeight(40);
        gridPane.add(naissanceField, 1, 3);

        // Add Promo Label
        Label promoLabel = new Label("Promo : ");
        gridPane.add(promoLabel, 0, 4);

        //Add Promo Label
        ObservableList<String> options = 
        FXCollections.observableArrayList(
            "L3",
            "M1",
            "M2"
        );
        promoField = new ComboBox(options);
        gridPane.add(promoField, 1, 4);


        // Add Submit Button
        submitButton = new Button("Valider");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        EcouteurForm e = new EcouteurForm(this,ihm);
        submitButton.setOnAction(e);

        //Add a background
        Rectangle fond = new Rectangle();
        fond.setHeight(500);
        fond.setWidth(500);
        fond.setFill(Color.BLANCHEDALMOND);
        this.getChildren().add(fond);
        fond.setTranslateX(50);
        fond.setTranslateY(30);
        fond.setStroke(Color.BLACK);

        gridPane.add(submitButton, 1, 5, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));
        this.getChildren().add(gridPane);
    }   
    
    /**
     * This method builds the form that allow user to modify information of a given student
     * @param Etu the Student whom we want to modify information
     * @param table the table where are display student
     */
    public Formulaire(Etudiant Etu, TableView<Etudiant> table){
        

        // Instantiate a new Grid Pane
        gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(50);

        // Set the vertical gap between rows
        gridPane.setVgap(30);
        
        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(150, 150, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(300,300, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
       
        // Add Header
        Label headerLabel = new Label("Formulaire de modification");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Nom : ");
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        nomField.setPrefHeight(40);
        nomField.setText(Etu.getNom());
        gridPane.add(nomField, 1,1);

        // Add Surname Label
        Label prenomLabel = new Label("Prenom : ");
        gridPane.add(prenomLabel, 0, 2);

        // Add Surname Text Field
        prenomField.setPrefHeight(40);
        prenomField.setText(Etu.getPrenom());
        gridPane.add(prenomField, 1, 2);

        // Add birthday Label
        Label naissanceLabel = new Label("Date de naissance : ");
        gridPane.add(naissanceLabel, 0, 3);

        // Add birthday field
        naissanceField.setPrefHeight(40);
        naissanceField.setValue(Etu.getNaissance());
        gridPane.add(naissanceField, 1, 3);

        // Add Promo Label
        Label promoLabel = new Label("Promo : ");
        gridPane.add(promoLabel, 0, 4);

        //Add Promo Label
        ObservableList<String> options = 
        FXCollections.observableArrayList(
            "L3",
            "M1",
            "M2"
        );
        promoField = new ComboBox(options);
        promoField.getSelectionModel().select(Etu.getPromo());
        gridPane.add(promoField, 1, 4);

        // Add Modify Button
        modifButton = new Button("Modifier");
        modifButton.setPrefHeight(40);
        modifButton.setDefaultButton(true);
        modifButton.setPrefWidth(100);
        EcouteurModif e = new EcouteurModif(this,table,Etu);
        modifButton.setOnAction(e);
        
        //Add a background
        Rectangle fond = new Rectangle();
        fond.setHeight(500);
        fond.setWidth(500);
        fond.setFill(Color.BLANCHEDALMOND);
        this.getChildren().add(fond);
        fond.setTranslateX(50);
        fond.setTranslateY(30);
        fond.setStroke(Color.BLACK);

        gridPane.add(modifButton, 1, 5, 2, 1);
        GridPane.setHalignment(modifButton, HPos.CENTER);
        GridPane.setMargin(modifButton, new Insets(20, 0,20,0));
        this.getChildren().add(gridPane);
    }
    
    public Button getButton(){
        return submitButton;
    }
    
    public String getName(){
        return nomField.getText();
    }
    
    public String getPrenom(){
        return prenomField.getText();
    }
    
    public LocalDate getNaissance(){
        return naissanceField.getValue();
    }
    
    public void setField(){
        promoField.getSelectionModel().clearSelection();
        nomField.clear();
        prenomField.clear();
        naissanceField.getEditor().clear();
    }
    
    public String getPromo(){
        return promoField.getValue();
    }
    
    public GridPane getPane(){
        return gridPane;
    }
}