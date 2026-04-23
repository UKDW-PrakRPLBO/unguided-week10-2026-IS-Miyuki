package org.rplbo.app.ug8.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import org.rplbo.app.ug8.UmbrellaApp;
import org.rplbo.app.ug8.UmbrellaDBManager;

import java.io.IOException;

public class LoginController {
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblStatus;

    @FXML
    private void handleLogin() throws IOException {
        // ==============================================================================
        // TODO 1: PROSES AUTENTIKASI (LOGIN)
        // ==============================================================================
        // 1. Ambil input teks dari txtUsername dan txtPassword.
        // 2. Buat instansiasi dari class UmbrellaDBManager.
        // 3. Panggil metode validateUser() dari db manager tersebut.
        // 4. Jika hasil validasi berhasil (tidak null):
        //    a. Simpan nama user ke variabel statis UmbrellaApp.loggedInUser.
        //    b. Pindah ke halaman "umbrella-view.fxml" menggunakan UmbrellaApp.switchScene().
        // 5. Jika gagal, tampilkan pesan error "AUTHENTICATION FAILED" pada lblStatus.
        // ==============================================================================

        // --- TULIS KODE ANDA DI BAWAH INI ---
        String user = txtUsername.getText();
        String pass = txtPassword.getText();

        UmbrellaDBManager DB =  new UmbrellaDBManager();
        String hasil = DB.validateUser(user, pass);

        if (hasil.equals("AUTHENTICATION FAILED")) {
//            lblStatus.setText("AUTHENTICATION FAILED");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("AUTHENTICATION FAILED");
            alert.showAndWait();
        }else{
            System.out.println(user);
            System.out.println(pass);
            System.out.println(hasil);
            UmbrellaApp.switchScene("Umbrella-view.fxml");
        }



    }
}