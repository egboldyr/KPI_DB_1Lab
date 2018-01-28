package controller;


import entity.Group;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import service.GroupService;
import service.GroupServiceImp;
import service.StudentService;
import service.StudentServiceImp;

public class NewStudentDialogController {

    private ObservableList<Group> groups;
    private GroupService srvGroups;
    private StudentService srvStudents;

    @FXML private GridPane wdStudentDialog;

    @FXML private ComboBox<Group> chbGroup;
    @FXML private TextField fldName;
    @FXML private TextField fldSurname;
    @FXML private TextField fldAge;

    @FXML
    private void initialize() {
        srvGroups = new GroupServiceImp();
        srvStudents = new StudentServiceImp();

        groups = FXCollections.observableArrayList(srvGroups.getAllGroups());
        chbGroup.setItems(groups);
    }

    @FXML
    private void onSaveButtonClick() {
        Stage dlg = (Stage) wdStudentDialog.getScene().getWindow();
        Group selectedGroup = chbGroup.getSelectionModel().getSelectedItem();
        srvStudents.create(
                selectedGroup.getId(),
                fldName.getText(),
                fldSurname.getText(),
                Integer.parseInt(fldAge.getText()));
        dlg.close();
    }

    @FXML
    private void onCancelButtonClick() {
        Stage dlg = (Stage) wdStudentDialog.getScene().getWindow();
        dlg.close();
    }
}
