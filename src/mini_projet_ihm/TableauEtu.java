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

/**
 *
 * @author Natashaa
 */
public class TableauEtu extends Parent{
    private final TableView<Etudiant> table = new TableView<>();
    private ObservableList<Etudiant> data =
            FXCollections.observableArrayList();
    private Formulaire formModif;
    private ButtonCell cellButton;
    
    public TableauEtu(ObservableList<Etudiant> myData, Formulaire myDormModif){
        data=myData;
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
        
//        //Insert Button
//        TableColumn col_action = new TableColumn<>("Action");
//        table.getColumns().add(col_action);
//       
//        col_action.setCellFactory(
//                new Callback<TableColumn<Etudiant, Boolean>, TableCell<Etudiant, Boolean>>() {
//
//            @Override
//            public TableCell<Etudiant, Boolean> call(TableColumn<Etudiant, Boolean> p) {
//                cellButton = new ButtonCell();
//                
//                cellButton.setOnMousePressed(new EventHandler<MouseEvent>(){
//                public void handle(MouseEvent me){
//                    Etudiant data = getTableView().getItems().get(getIndex);
//            }
//            });
//                
//            public void updateItem(String item, boolean empty) {
//                super.updateItem(item, empty);
//                if(!empty){
//                    setGraphic(cellButton);
//                }
//            }
//            }
//        });
        
        
                
        
        
        
        //table.setItems(data);
        table.getItems().addAll(data);
        addButtonToTable();
        
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
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
        final Image image = new Image(TableauEtu.class.getResourceAsStream("images/trash.png"));
        final ImageView poubelle = new ImageView(image);
        poubelle.setFitWidth(30);
        poubelle.setFitHeight(30);
        

        Callback<TableColumn<Etudiant, String>, TableCell<Etudiant, String>> cellFactory = new Callback<TableColumn<Etudiant, String>, TableCell<Etudiant, String>>() {
            @Override
            public TableCell<Etudiant, String> call(final TableColumn<Etudiant, String> param) {
                final TableCell<Etudiant, String> cell = new TableCell<Etudiant, String>() {
                       private Button supprimer = new Button("Supprimer",poubelle);
                       private Button modifier = new Button ("Modifier");
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

        table.getColumns().add(sixthNameCol);

    }
    
}

