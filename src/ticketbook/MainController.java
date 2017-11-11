/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketbook;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author BangKho
 */
public class MainController implements Initializable {
    
    private Label label;
    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextField ktp;
    @FXML
    private JFXTextField umur;
    @FXML
    private JFXComboBox film;
    @FXML
    private JFXComboBox jam;
    @FXML
    private JFXDatePicker tgl;
    @FXML
    private JFXButton oke;
    @FXML
    private FontAwesomeIconView close;
    private double xOffset = 0;
    private double yOffset = 0;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        jam.getItems().addAll("13.00","15.00","18.00","21.00");
        film.getItems().addAll("IT","Annabel : The Creation","Cars 3");
    }    

    @FXML
    private void Simpan(ActionEvent event) throws IOException {
        // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Hasil.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
             scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.setTitle("Hasil");
            stage.show();
            LocalDate d = tgl.getValue();
            String datetime = d.toString();
            HasilController b = new HasilController();
            b = fxmlLoader.getController();
            b.HasilController(nama.getText(),ktp.getText(),umur.getText(), (String) film.getValue(),(String) jam.getValue(),datetime);
    }

    @FXML
    private void Close(MouseEvent event) {
        System.exit(0);
    }
    
}
