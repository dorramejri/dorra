/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view.evenement;

import com.jfoenix.controls.JFXListView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import com.citeDeCulture.entities.User;
import com.citeDeCulture.entities.evenement;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.citeDeCulture.sercicesImpl.MyServiceEvenement;
//import util.Authentification;

/**
 *
 *
 */
public class MesPartController implements Initializable{
    
        
//               private final User currentUser=Authentification.user;
     MyServiceEvenement service_pr=new MyServiceEvenement();
     evenement p = new evenement();
    @FXML
    private JFXListView<Pane> ListView_Produits ;
    @FXML
    private JFXListView<evenement> ListView_Produits1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
       // ListView_Produits.setMouseTransparent( true );
ListView_Produits.setFocusTraversable( false );
          getShowPane();
         
          
    }
    
 
    public void getShowPane()
    {
        List <evenement> AllProducts  = new ArrayList();
        for (evenement p: service_pr.MesPart())
        {
            AllProducts.add(p);
        }
        System.out.println(AllProducts);
        int i=0;
        int j=0;
        ObservableList<Pane> Panes = FXCollections.observableArrayList();  

        List <evenement> ThreeProducts= new ArrayList();
        for (evenement p:AllProducts )
        {
            if(i==0)
            {
                ThreeProducts.add(p);
                i++;
                j++;
                
                     if(j==AllProducts.size())
                {System.out.println("hello322");
                    Panes.add(AddPane(ThreeProducts));
                
                    ThreeProducts.clear();
                    
                }
            }
            else
            {
                ThreeProducts.add(p);
                    i++;
                    j++;
                if((i%3==0)||(j==AllProducts.size()))
                {
                    
                    Panes.add(AddPane(ThreeProducts));
                
                    ThreeProducts.clear();
                    
                }
            }
        }
       ListView_Produits.setItems(Panes);
}
    public Pane AddPane( List<evenement> ThreeProduct)
    {
        Pane pane = new Pane();
                    int k =1;
                    for (evenement p3:ThreeProduct )
                        {
                         if(k == 1)
                            {
                                Pane pane2=new Pane();
                                pane2.setLayoutX(25);
                                pane2.setLayoutY(50);
                                pane2.setPrefWidth(pane2.getWidth() + 215); 
                                pane2.setPrefHeight(pane2.getHeight() + 200);
        pane2.setStyle(" -fx-border-radius: 10 10 0 0;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                            
                        Text t=new Text("quick view");        
                        Text t1=new Text("acheter");        
                        t1.setStyle("-fx-font-weight: bold;");
                        t.setStyle("-fx-font-weight: bold;");
                                
                                String A = p3.getImage();
                                A = "C:\\wamp64\\www\\datatable_21\\web\\"+A;
                                          File F1 = new File(A);
                                           Image image2 = new Image(F1.toURI().toString());
                                          
                                ImageView image=new ImageView();
                                image.setFitWidth(130);
                                image.setFitHeight(140);
                                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                                image.setImage(image2);
                                image.setLayoutX(45);
                                image.setLayoutY(-35);
                                pane2.getChildren().add(image);
                                
                                Text nomt=new Text("Nom : ");
                                Label nom = new Label(p3.getNom());
                                Text prixt=new Text("Adresse : ");
                                Label prix = new Label(String.valueOf(p3.getAdresse()));
                                nomt.setLayoutX(50);
                                nomt.setLayoutY(180);
                                nom.setLayoutX(100);
                                nom.setLayoutY(165);
                                prixt.setLayoutX(50);
                                prixt.setLayoutY(200);
                                prix.setLayoutX(130);
                                prix.setLayoutY(185);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                            t1.setOnMouseClicked((MouseEvent event) -> {
                                     
                                
                                      getShowPane();
                                });
              
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix);
                      
                            }
                            if(k == 2)
                            {
                               Pane pane2=new Pane();
                                pane2.setLayoutX(300);
                                pane2.setLayoutY(50);
                                pane2.setPrefWidth(pane2.getWidth() + 215); 
                                pane2.setPrefHeight(pane2.getHeight() + 200);
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle(" -fx-border-radius: 10 10 0 0;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                            
                        Text t=new Text("quick view");        
                        Text t1=new Text("acheter");        
                        t1.setStyle("-fx-font-weight: bold;");
                        t.setStyle("-fx-font-weight: bold;");
                                
                                String A = p3.getImage();
                                A = "C:\\wamp64\\www\\datatable_21\\web\\"+A;
                                          File F1 = new File(A);
                                           Image image2 = new Image(F1.toURI().toString());
                                          
                                ImageView image=new ImageView();
                                image.setFitWidth(130);
                                image.setFitHeight(140);
                                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                                image.setImage(image2);
                                image.setLayoutX(45);
                                image.setLayoutY(-35);
                                pane2.getChildren().add(image);
                                
                                Text nomt=new Text("Nom : ");
                                Label nom = new Label(p3.getNom());
                                Text prixt=new Text("Adresse : ");
                                Label prix = new Label(String.valueOf(p3.getAdresse()));
                                nomt.setLayoutX(325);
                                nomt.setLayoutY(180);
                                nom.setLayoutX(375);
                                nom.setLayoutY(165);
                                prixt.setLayoutX(325);
                                prixt.setLayoutY(200);
                                prix.setLayoutX(405);
                                prix.setLayoutY(185);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                         
                                
     
                    
                                
                                
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix); 
                      
                            
                            
                            
                            
                            
                            }
                            
                            
                            
                            
                            
                            
                            
                            
                            if(k == 3)
                                {
                                   Pane pane2=new Pane();
                                pane2.setLayoutX(575);
                                pane2.setLayoutY(50);
                                pane2.setPrefWidth(pane2.getWidth() + 215); 
                                pane2.setPrefHeight(pane2.getHeight() + 200);
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle(" -fx-border-radius: 10 10 0 0;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                            
                        Text t=new Text("quick view");        
                        Text t1=new Text("acheter");        
                        t1.setStyle("-fx-font-weight: bold;");
                        t.setStyle("-fx-font-weight: bold;");

                                String A = p3.getImage();
                                A = "C:\\wamp64\\www\\datatable_21\\web\\"+A;
                                          File F1 = new File(A);
                                           Image image2 = new Image(F1.toURI().toString());
                                          
                                ImageView image=new ImageView();
                                image.setFitWidth(130);
                                image.setFitHeight(140);
                                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                                image.setImage(image2);
                                image.setLayoutX(45);
                                image.setLayoutY(-35);
                                pane2.getChildren().add(image);
                                
                                Text nomt=new Text("Nom : ");
                                Label nom = new Label(p3.getNom());
                                Text prixt=new Text("Adresse : ");
                                Label prix = new Label(String.valueOf(p3.getAdresse()));
                                nomt.setLayoutX(600);
                                nomt.setLayoutY(180);
                                nom.setLayoutX(650);
                                nom.setLayoutY(165);
                                prixt.setLayoutX(600);
                                prixt.setLayoutY(200);
                                prix.setLayoutX(680);
                                prix.setLayoutY(185);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                
                                
                                
                       
                             
                             
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix);
//                                      
                                }
                            k++;
                            
                            }
                    return pane;
    }
    

    
}
