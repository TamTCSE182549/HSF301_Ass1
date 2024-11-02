package fall24.hsf301.slot1.fxcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import hsf301.fe.pojo.Book;
import hsf301.fe.service.BookService;
import hsf301.fe.service.IBookService;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BookManagementController implements Initializable{
	
	@FXML
	private TableView<Book> tblBooks;
	
	@FXML
	private TableColumn<Book, Integer> bookID;
	
	@FXML
	private TableColumn<Book, String> author;
	
	@FXML
	private TableColumn<Book, String> isBN;
	
	@FXML
	private TableColumn<Book, String> title;
	
	@FXML
	private TextField txtBookID;
	
	@FXML
	private TextField txtAuthor;
	
	@FXML
	private TextField txtIsBN;
	
	@FXML
	private TextField txtTitle;

	private IBookService iBookService;
	
	private ObservableList<Book> bookModel;
	
	public BookManagementController() {
		iBookService = new BookService("JPAs");
		bookModel = FXCollections.observableArrayList(iBookService.findAll());
	}
	
	

	@FXML
	public void handleStudentManagement(ActionEvent actionEvent) throws IOException {
		((Stage)((Node)actionEvent.getSource()).getScene().getWindow()).close();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxgui/StudentManagement.fxml"));
		Parent root = loader.load();
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	@FXML
	public void handleCreate() {
		Book book = new Book(txtTitle.getText(), txtAuthor.getText(), txtIsBN.getText());
		iBookService.save(book);
		refeshDataTable();
	}
	
	@FXML
	public void handleClear() {
		refeshDataTable();
	}
	
	@FXML
	public void handleCancel() {
		Platform.exit();
	}
	
	private void refeshDataTable() {
		// TODO Auto-generated method stub
		txtBookID.setText("");
		txtAuthor.setText("");
		txtIsBN.setText("");
		txtTitle.setText("");
		bookModel = FXCollections.observableArrayList(iBookService.findAll());
		tblBooks.setItems(bookModel);
	}

	@FXML
	public void handleUpdate() {
		Book book = new Book(Long.parseLong(txtBookID.getText()), txtTitle.getText(), txtAuthor.getText(), txtIsBN.getText());
		iBookService.update(book);
		refeshDataTable();
	}
	
	@FXML
	public void handleDelete() {
		iBookService.delete(Long.parseLong(txtBookID.getText()));
		refeshDataTable();
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		bookID.setCellValueFactory(new PropertyValueFactory<>("Id"));
		author.setCellValueFactory(new PropertyValueFactory<>("Author"));
		isBN.setCellValueFactory(new PropertyValueFactory<>("Isbn"));
		title.setCellValueFactory(new PropertyValueFactory<>("Title"));
		tblBooks.setItems(bookModel);
		tblBooks.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observableValue, Object oldValue, Object index) {
				// TODO Auto-generated method stub
				if (tblBooks.getSelectionModel().selectedItemProperty() != null) {
					TableViewSelectionModel selectionModel = tblBooks.getSelectionModel();
					ObservableList selectedCells = selectionModel.getSelectedCells();
					TablePosition tablePosition = (TablePosition) selectedCells.get(0);
					Object bookID = tablePosition.getTableColumn().getCellData(index);
					try {
						Book book = iBookService.findById(Long.valueOf(bookID.toString()));
						showBook(book);
					} catch (Exception e) {
						showAlert("Information Board !", "Please choose the First Cell !");
					}
				}
			}
		});
	}
	
	private void showBook(Book book) {
		// TODO Auto-generated method stub
		txtBookID.setText(String.valueOf(book.getId()));
		txtAuthor.setText(book.getAuthor());
		txtIsBN.setText(book.getIsbn());
		txtTitle.setText(book.getTitle());
	}
	
	public void showAlert(String header, String content) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
}
