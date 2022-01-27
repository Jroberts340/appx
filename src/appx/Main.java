package appx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application
{
	static Stage mStage = new Stage();
	private static final String BUTTONHOVER = "-fx-text-fill: #FFFFFF;" + "-fx-background-color: #808080;";
	private static final String BUTTONIDLE = "-fx-background-radius: 15px;" + "-fx-background-color: #FFFFFF;";

	
	public void start(Stage mainStage)
	{
		mStage = mainStage;
		
		Button btn1 = new Button("Sign In");
		btn1.setFocusTraversable(false);
		btn1.setCursor(Cursor.HAND);
		btn1.setMinWidth(180);
		btn1.setTextFill(Color.rgb(249, 166, 25));
		btn1.hoverProperty().addListener((observable,  oldValue,  show) -> {
			if (btn1.isHover())
				btn1.setStyle(BUTTONHOVER);
			else
				btn1.setStyle(BUTTONIDLE);
			
		});
		btn1.setStyle("-fx-background-radius: 15px;" +
				      "-fx-background-color: #FFFFFF;");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e)
			{
				login log = new login();
				log.start(login.lStage);
				System.out.println("Link was clicked");
				
				mainStage.close();
			}
		});
		
		Button btn2 = new Button("Sign Up");
		btn2.setFocusTraversable(false);
		btn2.setCursor(Cursor.HAND);
		btn2.setMinWidth(180);
		btn2.setTextFill(Color.rgb(249, 166, 25));
		btn2.hoverProperty().addListener((observable,  oldValue,  show) -> {
			if (btn2.isHover())
				btn2.setStyle(BUTTONHOVER);
			else
				btn2.setStyle(BUTTONIDLE);
			
		});
		btn2.setStyle("-fx-background-radius: 15px;" +
				      "-fx-background-color: #FFFFFF;");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e)
			{
				signup su = new signup();
				su.start(signup.sStage);
				System.out.println("Link was clicked");
				
				mainStage.close();
			}
		});
		
		Label lb = new Label("Welcome to\nME-Vesting");
		lb.setTextFill(Color.rgb(255, 255, 255));
		lb.setPadding(new Insets(30, 0, 0, 0));
		lb.setStyle(
				"-fx-text-fill: white; "+
						"-fx-font-weight: bold; "+
						"-fx-font-size: 3em; "+
						"-fx-font-family: Courier;");
		
		VBox vb = new VBox();
		vb.setMaxHeight(500); vb.setMaxWidth(400);
		vb.setMinHeight(500); vb.setMinWidth(400);
		vb.setAlignment(Pos.CENTER);
		vb.setSpacing(50);
		vb.getChildren().addAll(btn1, btn2);
		
		HBox hb = new HBox();
		hb.setMaxHeight(500); hb.setMaxWidth(400);
		hb.setMinHeight(500); hb.setMinWidth(400);
		hb.setAlignment(Pos.TOP_CENTER);
		hb.getChildren().addAll(lb);
		
		StackPane sPane = new StackPane();
		sPane.setMaxHeight(500); sPane.setMaxWidth(400);
		sPane.setMinHeight(500); sPane.setMinWidth(400);
		sPane.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25),null, null)));
		sPane.setAlignment(Pos.CENTER);
		sPane.getChildren().addAll(hb,vb);
		
		Scene scene = new Scene(sPane);
		mainStage.setScene(scene);
		mainStage.setTitle("Main Page");
		mainStage.setResizable(false);
		mainStage.show();
		mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() 
		{
			@Override
			public void handle(WindowEvent e)
			{
				Platform.exit();
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		System.out.println("Starting launch...");
		launch(args);
	}
	
}
