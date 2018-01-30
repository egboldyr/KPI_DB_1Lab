package controller;

import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.StudentService;
import service.StudentServiceImp;


public class FindWindowController {

    private ObservableList<Student> students;
    private StudentService studentService;

    @FXML private TableView<Student> tblStudents;
    @FXML private TableColumn<Student, Integer> clnStudentId;
    @FXML private TableColumn<Student, Integer> clnGroupId;
    @FXML private TableColumn<Student, String> clnName;
    @FXML private TableColumn<Student, String> clnSurname;
    @FXML private TableColumn<Student, Integer> clnAge;

    @FXML
    private void initialize() {
        studentService = new StudentServiceImp();
        students = FXCollections.observableArrayList();
        students.setAll(studentService.getYoungStudentsInGroups());

        clnStudentId.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        clnGroupId.setCellValueFactory(new PropertyValueFactory<Student, Integer>("groupId"));
        clnName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        clnSurname.setCellValueFactory(new PropertyValueFactory<Student, String>("surname"));
        clnAge.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age"));

        tblStudents.setItems(students);
    }
}
