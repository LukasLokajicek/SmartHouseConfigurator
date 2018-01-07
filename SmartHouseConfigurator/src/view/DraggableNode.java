package view;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class DraggableNode extends Group {

	public static void makeDraggable(final Node node) {
		final DragContext dragContext = new DragContext();

		node.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
			@Override
			public void handle(final MouseEvent mouseEvent) {
				// disable mouse events for all children
				mouseEvent.consume();
			}
		});

		node.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(final MouseEvent mouseEvent) {
				// remember initial mouse cursor coordinates
				// and node position
				dragContext.deltaX = node.getLayoutX() - mouseEvent.getSceneX();
				dragContext.deltaY = node.getLayoutY() - mouseEvent.getSceneY();
			}
		});

		node.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(final MouseEvent mouseEvent) {
				node.getScene().setCursor(Cursor.HAND);
			}
		});

		node.addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(final MouseEvent mouseEvent) {
				node.getScene().setCursor(Cursor.DEFAULT);
			}
		});

		node.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(final MouseEvent mouseEvent) {
				// shift node from its initial position by delta
				// calculated from mouse cursor movement
				node.setLayoutX(mouseEvent.getSceneX() + dragContext.deltaX);
				node.setLayoutY(mouseEvent.getSceneY() + dragContext.deltaY);
			}
		});
	}

	private static class DragContext {
		public double deltaX;
		public double deltaY;
	}

}
