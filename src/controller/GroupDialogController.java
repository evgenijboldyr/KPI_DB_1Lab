package controller;

import entity.Group;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.GroupService;
import service.GroupServiceImp;

public class GroupDialogController {

    private ObservableList<Group> groups;
    private Group currentGroup;
    private GroupService service;

    @FXML private TextField fldGroupName;

    @FXML private TableView<Group> tblGroups;
    @FXML private TableColumn<Group, Integer> clnGroupId;
    @FXML private TableColumn<Group, String> clnGroupName;

    @FXML
    private void initialize() {
        service = new GroupServiceImp();
        groups = FXCollections.observableArrayList(service.getAllGroups());
        clnGroupId.setCellValueFactory(new PropertyValueFactory<Group, Integer>("id"));
        clnGroupName.setCellValueFactory(new PropertyValueFactory<Group, String>("name"));
        tblGroups.setItems(groups);
    }

    @FXML
    private void onSelectedGroup() {
        currentGroup = tblGroups.getSelectionModel().getSelectedItem();
        fldGroupName.setText(currentGroup.getName());
    }

    @FXML
    private void newGroupButtonOnClick() {
        groups.add(service.create(fldGroupName.getText()));
        tblGroups.refresh(); fldGroupName.clear();
    }

    @FXML
    private void updateGroupButtonOnClick() {
        if (currentGroup != null) {
            currentGroup.setName(fldGroupName.getText());
            service.update(currentGroup);
        }
        tblGroups.refresh(); fldGroupName.clear();
    }

    @FXML
    private void deleteGroupButtonOnClick() {
        if (currentGroup != null) {
            service.delete(currentGroup);
            groups.remove(currentGroup);
        }
    }
}
