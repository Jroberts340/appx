package appx;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class signup extends Application {
	static Stage sStage = new Stage();
	
	final int maxlen = 25;
	
	@Override
	public void start(Stage signupStage) {
		sStage = signupStage;
		
		Label label1 = new Label("Register for Account");
		label1.setTextFill(Color.rgb(249, 166, 25));
		label1.setPadding(new Insets(0, 0, 0, 0));
		label1.setStyle(
				"-fx-font-size: 2em; "+
				"-fx-font-style: italic; "+
				"-fx-font-family: Courier;" );
		
		Hyperlink link = new Hyperlink();
		link.setVisited(false);
		link.setFocusTraversable(false);
		link.setPadding(new Insets(0,0,20,0));
		link.setTextFill(Color.rgb(249, 166, 25));
		link.setText("Already have an account? Sign In.");
		link.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				login log = new login();
				log.start(login.lStage);
				System.out.println("Link was clicked");
				
				signupStage.close();
			}
		});
		
		TextField firstname = new TextField();
		firstname.setPromptText("First Name");
		firstname.setFocusTraversable(false);
		firstname.setMaxWidth(180);
		//Limit the amount of characters allowed in the text field
		firstname.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		            if(newValue.length() > maxlen) 
		            	 ((StringProperty)observable).setValue(oldValue);
		        }
		);
		
		TextField lastname = new TextField();
		lastname.setPromptText("Last Name");
		lastname.setFocusTraversable(false);
		lastname.setMaxWidth(180);
		lastname.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		            if(newValue.length() > maxlen) 
		            	 ((StringProperty)observable).setValue(oldValue);
		        }
		);
		
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
		
		TextField phonenum = new TextField();
		phonenum.setPromptText("Cell Phone Number");
		phonenum.setFocusTraversable(false);
		phonenum.setMaxWidth(180);
		phonenum.textProperty().addListener(new ChangeListener<String>() {
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		            phonenum.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		});
		phonenum.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		            if(newValue.length() > 10) 
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
		
		PasswordField vpassword = new PasswordField();
		vpassword.setPromptText("Re-Enter Password");
		vpassword.setFocusTraversable(false);
		vpassword.setMaxWidth(180);
		vpassword.isVisible();
		vpassword.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		            if(newValue.length() > maxlen) 
		            	 ((StringProperty)observable).setValue(oldValue);
		        }
		);
		
		Button btn = new Button("SignUp");
		btn.setFocusTraversable(false);
		btn.setCursor(Cursor.HAND);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String fname = firstname.getText();
				String lname = lastname.getText();
				String user = username.getText();
				String pass = password.getText();
				String vpass = vpassword.getText();
				String pnum = phonenum.getText();
				
				fname = fname.substring(0,1).toUpperCase() + fname.substring(1);
				lname = lname.substring(0,1).toUpperCase() + lname.substring(1);
				
					try {
						userDAO uDAO = new userDAO();
						user u = new user(fname, lname, user, pnum, pass);
						
						if (uDAO.suNewUser(user)) {
							if (!pass.equals("")) {
								if (pass.equals(vpass)) {
									if(uDAO.addUser(u)) {
										System.out.println("Registration Successful");	
										String userId = uDAO.getUserId(user);
										home h = new home(userId,fname,lname,user,pnum,pass);
										h.start(home.hStage);
										
										signupStage.close();
									}
								}
								else
									System.out.print("The Passwords You Entered Do Not Match");
							}
							else
								System.out.println("No Password Was Entered");
						}
						else
							System.out.println("An Account Using This Email Already Exists");
					} catch (SQLException e1) {
				}
			}
		});

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
			public void handle (ActionEvent e) {
				Main main = new Main();
				main.start(Main.mStage);
				System.out.println("Link was clicked");
				
				signupStage.close();
			}
		});
		
		FlowPane vb1 = new FlowPane();
		vb1.setAlignment(Pos.CENTER);
		vb1.setMaxHeight(100); vb1.setMaxWidth(350);
		vb1.setMinHeight(100); vb1.setMinWidth(350);
		vb1.setPadding(new Insets(40, 0, 0, 0));
		vb1.setHgap(25);
		vb1.setVgap(25);
		vb1.getChildren().addAll(firstname, lastname, phonenum, username, password, vpassword);
		
		VBox vb2 = new VBox();
		vb2.setAlignment(Pos.TOP_CENTER);
		vb2.setMaxHeight(110); vb2.setMaxWidth(400);
		vb2.setMinHeight(110); vb2.setMinWidth(400);
		vb2.setSpacing(20);
		vb2.setPadding(new Insets(50, 0, 0,0));
		vb2.getChildren().addAll(btn, link);
		
		VBox vb3 = new VBox();
		vb3.setAlignment(Pos.BOTTOM_CENTER);
		vb3.setMaxHeight(400); vb3.setMaxWidth(400);
		vb3.setMinHeight(400); vb3.setMinWidth(400);
		vb3.setSpacing(30);
		vb3.getChildren().addAll(vb2);
		
		VBox vb4 = new VBox();
		vb4.setAlignment(Pos.CENTER);
		vb4.setMaxHeight(200); vb4.setMaxWidth(400);
		vb4.setMinHeight(200); vb4.setMinWidth(400);
		vb4.setSpacing(30);
		vb4.getChildren().addAll(label1, vb1);
		
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.setMaxHeight(250); hb.setMaxWidth(350);
		hb.setMinHeight(250); hb.setMinWidth(350);
		hb.getChildren().addAll(vb4);
		
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.setMaxHeight(150); vb.setMaxWidth(400);
		vb.setMinHeight(150); vb.setMinWidth(400);
		vb.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
		vb.getChildren().add(label);
		
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(0,0,50,0));
		bp.setMaxHeight(500); bp.setMaxWidth(400);
		bp.setMinHeight(500); bp.setMinWidth(400);
		bp.setTop(vb);
		

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
		sPane.getChildren().addAll(bp, back, vb3, hb);
		
		Scene scene = new Scene(sPane);
		signupStage.setScene(scene);
		signupStage.setTitle("Sign Up Page");
		signupStage.setResizable(false);
		signupStage.show();
		signupStage.setOnCloseRequest(new EventHandler<WindowEvent>() 
		{
			@Override
			public void handle(WindowEvent e) {
				Platform.exit();
				System.exit(0);
			}
		});
	}
}
