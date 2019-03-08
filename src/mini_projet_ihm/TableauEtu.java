/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet_ihm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Natashaa
 */
public class TableauEtu extends Parent{
    private final TableView<Etudiant> table = new TableView<>();
    private ObservableList<Etudiant> data =
            FXCollections.observableArrayList();
    private Mini_projet_IHM ihm;
    private BorderPane bp = new BorderPane();
    
    public TableauEtu(ObservableList<Etudiant> myData, Formulaire myDormModif, Mini_projet_IHM myIhm){
        data=myData;
        ihm=myIhm;
        TableColumn<Etudiant, String> firstNameCol = new TableColumn<>("Nom");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("Nom"));

        TableColumn<Etudiant, String> secondNameCol = new TableColumn<>("Prenom");
        secondNameCol.setMinWidth(100);
        secondNameCol.setCellValueFactory(new PropertyValueFactory<>("Prenom"));


        TableColumn<Etudiant, String> thirdNameCol = new TableColumn("Année de Naissance");
        thirdNameCol.setMinWidth(150);
        thirdNameCol.setCellValueFactory(new PropertyValueFactory<>("Naissance"));

        TableColumn<Etudiant, String> fourthNameCol = new TableColumn("Promo");
        fourthNameCol.setMinWidth(100);
        fourthNameCol.setCellValueFactory(new PropertyValueFactory<>("Promo"));
        
        table.getColumns().addAll(firstNameCol, secondNameCol, thirdNameCol, fourthNameCol);

        //table.setItems(data);
        table.getItems().addAll(data);
        
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
       
        addModifToTable(this, bp, ihm, table);
        addButtonToTable();
        
        
        vbox.getChildren().add(table);
        this.getChildren().add(vbox);
        
    }
    
    public void setTable(Etudiant etu){
        table.getItems().add(etu);
    }
    

        
//    //Define the button cell
//    private class ButtonCell extends TableCell<Etudiant, Boolean> {
//        final Image img = new Image(TableauEtu.class.getResourceAsStream("images/quitter.jpg"));
//        final ImageView imgv = new ImageView(img);
//        final Button cellButton;
//        final TableView<Etudiant> table;
//        Formulaire formModif;
//        
//        private ButtonCell(TableView<Etudiant> myTable, Formulaire myFormModif){
//            imgv.setFitHeight(30);
//            imgv.setFitWidth(30);
//            cellButton = new Button("",imgv);
//            table=myTable;
//            formModif = myFormModif;
//        	//Action when the button is pressed
//            
//            EcouteurModifTable e = new EcouteurModifTable(this,ihm, Etu);
//            cellButton.setOnAction(e);
//            
//
//        //Display button if the row is not empty
//        @Override
//        protected void updateItem(Boolean t, boolean empty) {
//            super.updateItem(t, empty);
//            if(!empty){
//                setGraphic(cellButton);
//            }
//        }
//    }
        private void addButtonToTable() {
        TableColumn<Etudiant, String> sixthNameCol = new TableColumn("Supprimer");
        final Image image = new Image(TableauEtu.class.getResourceAsStream("quitter.jpg"));
        final ImageView poubelle = new ImageView(image);
        poubelle.setFitWidth(30);
        poubelle.setFitHeight(30);
        

        Callback<TableColumn<Etudiant, String>, TableCell<Etudiant, String>> cellFactory;
        cellFactory = new Callback<TableColumn<Etudiant, String>, TableCell<Etudiant, String>>() {
            @Override
            public TableCell<Etudiant, String> call(final TableColumn<Etudiant, String> param) {
                final TableCell<Etudiant, String> cell = new TableCell<Etudiant, String>() {
                    private Button supprimer = new Button("Supprimer");
                    {
                        supprimer.setOnMousePressed(new EventHandler<MouseEvent>(){
                            public void handle(MouseEvent me){
                                Etudiant data = getTableView().getItems().get(getIndex());
                                table.getItems().remove(data);
                                
//                
                            }
                        });
                    }

                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(supprimer);
                        }
                    }
                };
                return cell;
            }
        };

        sixthNameCol.setCellFactory(cellFactory);
        sixthNameCol.setMinWidth(100);

        table.getColumns().add(sixthNameCol);

    }
    private void addModifToTable(TableauEtu tabEtu, BorderPane bp, Mini_projet_IHM myIhm, TableView<Etudiant> table) {
        TableauEtu tabEtus = tabEtu;
        TableColumn<Etudiant, String> fifthNameCol = new TableColumn("Modifier");
        

        Callback<TableColumn<Etudiant, String>, TableCell<Etudiant, String>> cellFactory;
        cellFactory = new Callback<TableColumn<Etudiant, String>, TableCell<Etudiant, String>>() {
            @Override
            public TableCell<Etudiant, String> call(final TableColumn<Etudiant, String> param) {
                final TableCell<Etudiant, String> cell = new TableCell<Etudiant, String>() {
                    private Button modifier = new Button ("Modifier");
                    {
                        modifier.setOnMousePressed(new EventHandler<MouseEvent>(){
                            public void handle(MouseEvent me){
                                Etudiant currentEtu = (Etudiant) getTableView().getItems().get(getIndex());
                                tabEtus.getChildren().clear();
                                Formulaire formulaire = new Formulaire(currentEtu, table);
                                data.remove(currentEtu);
                                tabEtu.getChildren().clear();
                                tabEtu.getChildren().add(formulaire);
                                table.setVisible(false);
                                tabEtu.getChildren().add(table);
//                
                            }
                        });
                    }

                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(modifier);
                        }
                    }
                };
                return cell;
            }
        };

        fifthNameCol.setCellFactory(cellFactory);
        fifthNameCol.setMinWidth(100);

        table.getColumns().add(fifthNameCol);

    }
    
}

