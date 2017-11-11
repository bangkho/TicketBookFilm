/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketbook;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author BangKho
 */
public class HasilController implements Initializable {

    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextField ktp;
    @FXML
    private JFXTextField umur;
    @FXML
    private JFXTextField film;
    @FXML
    private JFXTextField jam;
    @FXML
    private JFXTextField tgl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void Close(ActionEvent event) {
        System.exit(0);
    }
    public HasilController(){
    }
    public void HasilController(String nm,String no,String um,String fm,String jm,String tg){
        nama.setText(nm);
        ktp.setText(no);
        umur.setText(um);
        film.setText(fm);
        jam.setText(jm);
        tgl.setText(tg);
    }
}
