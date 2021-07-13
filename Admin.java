package show.admin;

import Design.ConnectDesign;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.List;

public class Admin {

    @FXML
    private TextArea result;

    @FXML
    private TextArea sql;

    @FXML
    void execute(ActionEvent event) {
        List<Object> list = ConnectDesign.execute(sql.getText());
        if (list.size() > 0) {
            String results = "";
            for (Object o : list) {
                results += o.toString();
                results += "\n";
            }
            result.setText(results);
        } else {
            result.setText("执行完成!");
        }
    }

    @FXML
    void clear(ActionEvent event) {
        sql.clear();
        result.clear();
    }

}

