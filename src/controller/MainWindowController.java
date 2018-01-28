package controller;

import entity.Group;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.GroupService;
import service.GroupServiceImp;
import service.StudentService;
import service.StudentServiceImp;

import java.io.IOException;

public class MainWindowController {

    private ObservableList<Group> groups;
    private GroupService groupService;
    private ObservableList<Student> students;
    private StudentService studentService;

    @FXML private BorderPane wdMain;
    @FXML private ListView<Group> lstGroups;
    @FXML private TableView<Student> tblStudents;

    @FXML private TableColumn<Student, Integer> clnStudentId;
    @FXML private TableColumn<Student, String> clnStudentName;
    @FXML private TableColumn<Student, String> clnStudentSurname;
    @FXML private TableColumn<Student, Integer> clnStudentAge;

    @FXML
    private void initialize() {
        groupService = new GroupServiceImp();
        groups = FXCollections.observableArrayList(groupService.getAllGroups());
        lstGroups.setItems(groups);

        studentService = new StudentServiceImp();
        students = FXCollections.observableArrayList();
        clnStudentId.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        clnStudentName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        clnStudentSurname.setCellValueFactory(new PropertyValueFactory<Student, String>("surname"));
        clnStudentAge.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age"));
        tblStudents.setItems(students);
    }

    @FXML
    private void selectGroupOnClick() {
        students.setAll(
                studentService.getGroupStudents(
                        lstGroups.getSelectionModel().getSelectedItem()));
        tblStudents.refresh();
    }

    @FXML
    private void newGroupButtonOnClick() throws IOException {
        Stage dlgGroups = new Stage();
        BorderPane vwGroups = FXMLLoader.load(getClass().getResource("/view/group_dialog.fxml"));

        dlgGroups.setTitle("Edit Groups - Dialog");
        dlgGroups.setResizable(false);
        dlgGroups.initModality(Modality.WINDOW_MODAL);
        dlgGroups.initOwner(wdMain.getScene().getWindow());
        dlgGroups.setOnCloseRequest((event) -> {
            groups.setAll(groupService.getAllGroups());
            lstGroups.refresh();
        });
        dlgGroups.setScene(new Scene(vwGroups));
        dlgGroups.showAndWait();
    }

    @FXML
    private void deleteGroupButtonOnClick() {
        Group currentGroup = lstGroups.getSelectionModel().getSelectedItem();
        groupService.delete(currentGroup);
        groups.remove(currentGroup);
    }

    @FXML
    private void findButtonOnClick() {

    }

    @FXML
    private void newStudentButtonOnClick() throws IOException {
        Stage dlgNewStudent = new Stage();
        GridPane vwStudent = FXMLLoader.load(getClass().getResource("/view/student_dialog.fxml"));

        dlgNewStudent.setTitle("New Student - Dialog");
        dlgNewStudent.setResizable(false);
        dlgNewStudent.initModality(Modality.WINDOW_MODAL);
        dlgNewStudent.initOwner(wdMain.getScene().getWindow());
        dlgNewStudent.setOnCloseRequest((event) -> {
            Group group = lstGroups.getSelectionModel().getSelectedItem();
            if (group != null) {
                students.setAll(
                        studentService.getGroupStudents(
                                lstGroups.getSelectionModel().getSelectedItem()));
                tblStudents.refresh();
            }
        });
        dlgNewStudent.setScene(new Scene(vwStudent));
        dlgNewStudent.showAndWait();
    }

    @FXML
    private void deleteStudentButtonOnClick() {
        Student student =
                tblStudents.getSelectionModel().getSelectedItem();
        studentService.delete(student);
        students.remove(student);
        tblStudents.refresh();
    }

    @FXML
    private void exitButtonOnClick() {
        System.exit(0);
    }
}
