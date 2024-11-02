package fall24.hsf301.slot1.fxcontroller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import hsf301.fe.pojo.Student;
import hsf301.fe.service.IStudentService;
import hsf301.fe.service.StudentService;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StudentManagementController implements Initializable{
	
	@FXML
	private Button btnThem;
	
	@FXML
	private TableView<Student> tblStudents;
	
	@FXML
	private TableColumn<Student, Integer> studentID;
	
	@FXML
	private TableColumn<Student, String> firstName;
	
	@FXML
	private TableColumn<Student, String> lastName;
	
	@FXML
	private TableColumn<Student, Integer> mark;
	
	@FXML
	private TextField txtStudentID;
	
	@FXML
	private TextField txtLastName;
	
	@FXML
	private TextField txtFirstName;
	
	@FXML
	private TextField txtMark;
	
	@FXML
	private TextField txtSearch;
	
	private ObservableList<Student> studentModel;
	
	private int roleID;

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
		if(this.roleID == 1) {
			this.btnThem.setDisable(false);
		}
	}

	private IStudentService iStudentService;

	public StudentManagementController() {
//		iStudentService = new StudentService("JPAs", 2);
//		iStudentService = new StudentService("hibernate.cfg.xml", 2);
		iStudentService = new StudentService("JPAs", 1);
		studentModel = FXCollections.observableArrayList(iStudentService.findAll());
	}
	
	public void showAlert(String header, String content) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	
	public void showStudent(Student student) {
		this.txtStudentID.setText(String.valueOf(student.getId()));
		this.txtFirstName.setText(student.getFirstName());
		this.txtLastName.setText(student.getLastName());
		this.txtMark.setText(String.valueOf(student.getMarks()));
		
	}
	
	
	private void refreshDataTable() {
		// TODO Auto-generated method stub
		this.txtStudentID.setText("");
		this.txtFirstName.setText("");
		this.txtLastName.setText("");
		this.txtMark.setText("");
		studentModel = FXCollections.observableArrayList(iStudentService.findAll());
		tblStudents.setItems(studentModel);
	}

//	Show all student and get StudentID when click first cell
	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		studentID.setCellValueFactory(new PropertyValueFactory<>("Id"));
		firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
		lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
		mark.setCellValueFactory(new PropertyValueFactory<>("Marks"));
		tblStudents.setItems(studentModel);
		tblStudents.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observableValue, Object oldValue, Object index) {
				// TODO Auto-generated method stub
				if (tblStudents.getSelectionModel().selectedItemProperty() != null) {
					TableViewSelectionModel selectionModel = tblStudents.getSelectionModel();
					ObservableList selectedCells = selectionModel.getSelectedCells();
					TablePosition tablePosition = (TablePosition) selectedCells.get(0);
					Object studentID = tablePosition.getTableColumn().getCellData(index);
					try {
						Student student = iStudentService.findById(Integer.valueOf(studentID.toString()));
						showStudent(student);
					} catch (Exception e) {
					
						showAlert("Information Board !", "Please choose the First Cell !");
					}
				}
			}
		});
	}
		
	@FXML
	public void handleAdd() {
		Student student = new Student(this.txtFirstName.getText(), 
				this.txtLastName.getText(), 
				Integer.parseInt(this.txtMark.getText()));
		iStudentService.save(student);
		refreshDataTable();
	}

	@FXML
	public void handleDelete() {
		iStudentService.delete(Integer.parseInt(txtStudentID.getText()));
		refreshDataTable();
	}
	
	@FXML
	public void handleUpdate() {
		Student student = new Student(Integer.parseInt(txtStudentID.getText()), 
				this.txtFirstName.getText(), 
				this.txtLastName.getText(), 
				Integer.parseInt(this.txtMark.getText()));
		iStudentService.update(student);
		refreshDataTable();
	}
	
	@FXML
	public void handleSearch() {
		studentModel = FXCollections.observableArrayList(iStudentService.findByFirstName(txtSearch.getText()));
		tblStudents.setItems(studentModel);
		this.txtSearch.setText("");
	}
	
	@FXML
	public void handleCancel() {
		Platform.exit();
	}
	
	@FXML
	public void handleBookManagement(ActionEvent actionEvent) throws IOException {
		((Stage)((Node)actionEvent.getSource()).getScene().getWindow()).close();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxgui/BookManagement.fxml"));
		Parent root = loader.load();
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
}
