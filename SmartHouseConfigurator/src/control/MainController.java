/**
 * Sample Skeleton for 'Main.fxml' Controller Class
 */

package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import view.DraggableNode;

public class MainController {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="pnlB"
	private TitledPane pnlB; // Value injected by FXMLLoader

	@FXML // fx:id="pnlA"
	private TitledPane pnlA; // Value injected by FXMLLoader

	@FXML // fx:id="btn2"
	private Button btn2; // Value injected by FXMLLoader

	@FXML // fx:id="btn3"
	private Button btn3; // Value injected by FXMLLoader

	@FXML // fx:id="btn1"
	private Button btn1; // Value injected by FXMLLoader

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		DraggableNode.makeDraggable(pnlA);
		DraggableNode.makeDraggable(pnlB);

	}
}
