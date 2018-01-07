package view;

import control.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private MainController mainController;

	@Override
	public void start(final Stage primaryStage) {

		try {
			final FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));
			final BorderPane root = loader.load();
			mainController = loader.getController();
			primaryStage.setTitle("Authoring");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(final String[] args) {
		launch(args);
	}
}
