package controller;

import entity.Group;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.GroupService;
import service.GroupServiceImp;

import java.io.IOException;

/**/

public class MainWindowController {

    private ObservableList<Group> groups;
    private GroupService groupService;
    private ObservableList<Student> students;

    @FXML private BorderPane wdMain;
    @FXML private ListView<Group> lstGroups;
    @FXML private TableView<Student> tblStudents;

    @FXML
    private void initialize() {
        groupService = new GroupServiceImp();
        groups = FXCollections.observableArrayList(groupService.getAllGroups());
        lstGroups.setItems(groups);

        students = FXCollections.observableArrayList();
    }

    @FXML
    private void newGroupButtonOnClick() throws IOException {
        Stage dlgGroups = new Stage();
        BorderPane vwGroups = FXMLLoader.load(getClass().getResource("/view/group_dialog.fxml"));

        dlgGroups.setTitle("Edit Groups - Dialog");
        dlgGroups.setResizable(false);
        dlgGroups.initModality(Modality.WINDOW_MODAL);
        dlgGroups.initOwner(wdMain.getScene().getWindow());
        dlgGroups.setScene(new Scene(vwGroups));
        dlgGroups.showAndWait();
    }
}
