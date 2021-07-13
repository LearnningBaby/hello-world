package show.employee;

import Design.ConnectDesign;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


import java.util.List;

public class employeefunction {
    private static String ID;

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        employeefunction.ID = ID;
    }

    @FXML
    private TextArea result;

    @FXML
    void select(ActionEvent event) {
        // result.getScene().getWindow()
        List<Object> salary = ConnectDesign.select(getID(), "salary");
        String results = "";
        for (Object o : salary
        ) {
            results += o.toString();
            results += "\n";
        }
        result.setText(results);
    }

}
