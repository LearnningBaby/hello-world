package show;

import Design.ConnectDesign;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import show.employee.employeefunction;
;

import java.io.IOException;

public class ShowLogin {


    @FXML
    private PasswordField password;

    @FXML
    private ToggleGroup post;

    @FXML
    private AnchorPane admin;

    @FXML
    private TextField username;

    //相关页面跳转还未实现
    @FXML
    void login(ActionEvent event) throws IOException {

        Stage primary = this.getNowStage();
        Parent p = null;

        String get = this.getPost().getSelectedToggle().toString();
        String[] table = get.split("'");

        boolean login = ConnectDesign.login(table[1], this.getUsername().getText(), this.getPassword().getText());
        if (login && table[1].equals("administrator")) {

            p = FXMLLoader.load(getClass().getResource("admin/admin.fxml"));
            primary.setScene(new Scene(p));

        } else if (login && table[1].equals("employees")) {
            employeefunction.setID(this.getUsername().getText());
            p = FXMLLoader.load(getClass().getResource("employee/employlogin.fxml"));
            primary.setScene(new Scene(p));

        } else {
            Button NO = new Button("用户名或密码错误!");
            Stage alert = new Stage();
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setScene(new Scene(NO, 200, 200));
            alert.showAndWait();
        }

    }


    public Stage getNowStage() {
        Stage pri = (Stage) this.getPassword().getScene().getWindow();
        return pri;
    }


    @FXML
    void clear(ActionEvent event) {
        this.getPassword().clear();
        this.getUsername().clear();
    }

    public ToggleGroup getPost() {
        return post;
    }

    public TextField getUsername() {
        return username;
    }

    public void setUsername(TextField username) {
        this.username = username;
    }

    public PasswordField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }


}
