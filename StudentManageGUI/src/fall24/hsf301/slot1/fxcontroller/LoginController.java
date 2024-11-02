package fall24.hsf301.slot1.fxcontroller;


import java.io.IOException;

import hsf301.fe.pojo.Account;
import hsf301.fe.service.AccountService;
import hsf301.fe.service.IAccountService;
import hsf301.fe.service.IStudentService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {
	
//	private IStudentService studentService;
	
	private IAccountService iAccountService;
	
	public LoginController() {
		iAccountService = new AccountService("JPAs");
	}

	@FXML
	private TextField txtUserName;
	
	@FXML
	private TextField txtPassword;
	
	public void showAlert(String header, String content) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	
	@FXML
	public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
		int index = 1;
//		txtUserName.setText("admin");
//		txtPassword.setText("admin");
//		Student student = studentService.findById(Integer.parseInt(txtUserName.getText()));
//		txtUserName.getText().equals("admin") && txtPassword.getText().equals("admin");
		Account account = iAccountService.findByUserName(txtUserName.getText());
		if (account!=null && account.getPassword().equals(txtPassword.getText())) {
//		if (txtUserName.getText().equals("admin") && txtPassword.getText().equals("admin")) {
			((Stage)((Node)actionEvent.getSource()).getScene().getWindow()).close();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxgui/StudentManagement.fxml"));
			Parent root = loader.load();
			StudentManagementController managementController = loader.getController();
			managementController.setRoleID(1);
			Stage primaryStage = new Stage();
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} else {
			showAlert("Error", "Username or Password was wrong!!!");
		}
//		System.out.println(Integer.parseInt(txtUserName.getText()));
	}
	
	@FXML
	public void closeLoginForm(ActionEvent event) {
		//Exit application syntax
		Platform.exit();
		System.out.println("Close Form");
	}
}
