package appx;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class login extends Application
{
	static Stage lStage = new Stage();
	
	final int maxlen = 25;
	
	@Override
	public void start(Stage loginStage) 
	{
		lStage = loginStage;
		
		TextField username = new TextField();
		username.setPromptText("Email");
		username.setFocusTraversable(false);
		username.setMaxWidth(180);
		username.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		            if(newValue.length() > maxlen+5) 
		            	 ((StringProperty)observable).setValue(oldValue);
		        }
		);
		
		
		PasswordField password = new PasswordField();
		password.setPromptText("Password");
		password.setFocusTraversable(false);
		password.setMaxWidth(180);
		password.isVisible();
		password.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		            if(newValue.length() > maxlen) 
		            	 ((StringProperty)observable).setValue(oldValue);
		        }
		);
		
		Hyperlink link = new Hyperlink();
		link.setVisited(false);
		link.setFocusTraversable(false);
		link.setTextFill(Color.rgb(249, 166, 25));
		link.setText("Do not have an account yet? Sign Up.");
		link.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e)
			{
				
				signup su = new signup();
				su.start(signup.sStage);
				System.out.println("Link was clicked");
				
				loginStage.close();
			}
		});
		
		Button btn = new Button("SignIn");
		btn.setFocusTraversable(false);
		btn.setCursor(Cursor.HAND);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e)
			{	
				try 
				{
					Connection connect = DbConnect.getInstance().getConnection();

					String user = username.getText();
					String pass = password.getText();
					
					Statement statement = connect.createStatement();
					
					String sql = "select * from user where email = '"+user+"' and password = '"+pass+"'";
					ResultSet resultset = statement.executeQuery(sql);
					
					if (resultset.next())
					{
						System.out.println("User Login Successful");
						String userID = resultset.getString(1);
						String userFN = resultset.getString(2);
						String userLN = resultset.getString(3);
						String userEMAIL = resultset.getString(4);
						String userPH = resultset.getString(5);
						String userPA = resultset.getString(6);
						
						home h = new home(userID,userFN,userLN,userEMAIL,userPH,userPA);
						h.start(home.hStage);
						
						loginStage.close();
					}
					else
						System.out.println("Failed To Login To User Account");
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		});
				
		Label label1 = new Label("Log into your account");
		label1.setTextFill(Color.rgb(249, 166, 25));
		label1.setStyle(
				"-fx-font-size: 2em; "+
				"-fx-font-style: italic; "+
				"-fx-font-family: Courier;" );
		label1.setLayoutX(500);
		
		Label label = new Label("ME-Vesting");
		label.setStyle(
				"-fx-text-fill: white; "+
				"-fx-font-weight: bold; "+
				"-fx-font-size: 3em; "+
				"-fx-font-family: Courier;" );
		
		Hyperlink back1 = new Hyperlink();
		back1.setVisited(false);
		back1.setFocusTraversable(false);
		back1.setTextFill(Color.rgb(255, 255, 255));
		back1.setText("Back To Main");
		back1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e)
			{
				
				Main main = new Main();
				main.start(Main.mStage);
				System.out.println("Link was clicked");
				
				loginStage.close();
			}
		});
		
		VBox vb1 = new VBox();
		vb1.setAlignment(Pos.TOP_CENTER);
		vb1.setMaxHeight(200); vb1.setMaxWidth(350);
		vb1.setMinHeight(200); vb1.setMinWidth(350);
		vb1.setSpacing(30);
		vb1.getChildren().addAll(label1, username, password);
		
		VBox vb2 = new VBox();
		vb2.setAlignment(Pos.BOTTOM_CENTER);
		vb2.setMaxHeight(450); vb2.setMaxWidth(400);
		vb2.setMinHeight(450); vb2.setMinWidth(400);
		vb2.setSpacing(30);
		vb2.getChildren().addAll(btn, link);
		
		HBox hb1 = new HBox();
		hb1.setAlignment(Pos.BOTTOM_CENTER);
		hb1.setMaxHeight(300); hb1.setMaxWidth(400);
		hb1.setMinHeight(300); hb1.setMinWidth(400);
		hb1.getChildren().addAll(vb1);
		
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.setMaxHeight(150); vb.setMaxWidth(400);
		vb.setMinHeight(150); vb.setMinWidth(400);
		vb.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
		vb.getChildren().add(label);
		
		HBox hb = new HBox();
		hb.setAlignment(Pos.TOP_LEFT);
		hb.setMaxHeight(500); hb.setMaxWidth(400);
		hb.setMinHeight(500); hb.setMinWidth(400);
		hb.getChildren().addAll(vb);
		
		HBox back = new HBox();
		back.setAlignment(Pos.TOP_LEFT);
		back.setMaxHeight(500); back.setMaxWidth(400);
		back.setMinHeight(500); back.setMinWidth(400);
		back.getChildren().add(back1);
		
		StackPane sPane = new StackPane();
		sPane.setMaxHeight(500); sPane.setMaxWidth(400);
		sPane.setMinHeight(500); sPane.setMinWidth(400);
		sPane.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
		sPane.setAlignment(Pos.CENTER);
		sPane.getChildren().addAll(hb, back,vb2, hb1);
		
		
		Scene scene = new Scene(sPane);
		loginStage.setScene(scene);
		loginStage.setTitle("Login Page");
		loginStage.setResizable(false);
		loginStage.show();
		loginStage.setOnCloseRequest(new EventHandler<WindowEvent>() 
		{
			@Override
			public void handle(WindowEvent e)
			{
				Platform.exit();
				System.exit(0);
			}
		});
	}

	

}
