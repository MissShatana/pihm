/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet_ihm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 *This class build the table that shows the list of student
 * @author Natasha Germain & Charlotte Fievet
 */
public class TableauEtu extends Parent{
    private final TableView<Etudiant> table = new TableView<>();
    private ObservableList<Etudiant> data =
            FXCollections.observableArrayList();
    private final Mini_projet_IHM ihm;
    
    /**
     * This method builds a table that displays student list.
     * @param myData the list of student
     * @param myFormModif the modification form
     * @param myIhm the main class
     */
    public TableauEtu(ObservableList<Etudiant> myData, Formulaire myFormModif, Mini_projet_IHM myIhm){
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
       
        addModifToTable(this, table);
        addButtonToTable();
        
        
        vbox.getChildren().add(table);
        this.getChildren().add(vbox);
        
    }
    
    public void setTable(Etudiant etu){
        table.getItems().add(etu);
    }

    /**
     * This method add a button supp to the table
     */
    private void addButtonToTable() {
    TableColumn<Etudiant, String> sixthNameCol = new TableColumn("Supprimer");

    Callback<TableColumn<Etudiant, String>, TableCell<Etudiant, String>> cellFactory;
    cellFactory = new Callback<TableColumn<Etudiant, String>, TableCell<Etudiant, String>>() {
        @Override
        public TableCell<Etudiant, String> call(final TableColumn<Etudiant, String> param) {
            final TableCell<Etudiant, String> cell = new TableCell<Etudiant, String>() {
                private final Button supprimer = new Button("Supprimer");
                {
                    supprimer.setOnMousePressed((MouseEvent me) -> {
                        Etudiant data1 = getTableView().getItems().get(getIndex());
                        table.getItems().remove(data1);
                    });
                }

                @Override
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
    
    /**
     * This method adds a button modify to the table
     * @param tabEtu the interface table that display the list of etu
     * @param table the table that saves the student
     */
    private void addModifToTable(TableauEtu tabEtu, TableView<Etudiant> table) {
        TableauEtu tabEtus = tabEtu;
        TableColumn<Etudiant, String> fifthNameCol = new TableColumn("Modifier");
        
        Callback<TableColumn<Etudiant, String>, TableCell<Etudiant, String>> cellFactory;
        cellFactory = new Callback<TableColumn<Etudiant, String>, TableCell<Etudiant, String>>() {
            @Override
            public TableCell<Etudiant, String> call(final TableColumn<Etudiant, String> param) {
                final TableCell<Etudiant, String> cell = new TableCell<Etudiant, String>() {
                    private final Button modifier = new Button ("Modifier");
                    {
                        modifier.setOnMousePressed((MouseEvent me) -> {
                            Etudiant currentEtu = (Etudiant) getTableView().getItems().get(getIndex());
                            tabEtus.getChildren().clear();
                            Formulaire formulaire = new Formulaire(currentEtu, table);
                            tabEtu.getChildren().clear();
                            tabEtu.getChildren().add(formulaire);
                            table.setVisible(false);
                            tabEtu.getChildren().add(table);
                        });
                    }

                    @Override
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

