package appx;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class home extends Application
{
	public static final String BUTTONHOVER = "-fx-text-fill: #FFFFFF;" + "-fx-background-color: #808080;" 
												+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
	public static final String BUTTONIDLE = "-fx-background-radius: 15px;" + "-fx-background-color: rgb(249,166,25);" 
												+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
	static Stage hStage = new Stage();
	
	public static String userId;
	public static String First;
	public static String Last;
	public static String Email;
	public static String Phone;
	public static String Password;
	

	public home (String uid, String fname, String lname, String email, String num, String pass) {
		home.userId = uid;
		home.First = fname;
		home.Last = lname;
		home.Email = email;
		home.Phone = num;
		home.Password = pass;
		
	}
	
		@Override
		public void start(Stage homeStage){
			hStage = homeStage;
						
			Label label = new Label("WELCOME " + First);
			label.setStyle(
					"-fx-text-fill: white; "+
					"-fx-font-weight: bold; "+
					"-fx-font-size: 3em; "+
					"-fx-font-family: Courier;" );
			
			Label lb = new Label("Latest Investment");
			lb.setStyle(
					"-fx-text-fill: rgb(249,166,25); "+
					"-fx-font-weight: bold; "+
					"-fx-font-size: 15pt; "+
					"-fx-font-family: Courier;" );
			
			Button btn1 = new Button("Account");
			btn1.setCursor(Cursor.HAND);
			btn1.setMinWidth(100);
			btn1.setMinHeight(50);
			btn1.setFocusTraversable(false);
			btn1.setTextFill(Color.rgb(255, 255, 255));
			btn1.hoverProperty().addListener((observable,  oldValue,  show) -> {
				if (btn1.isHover())
					btn1.setStyle(BUTTONHOVER);
				else
					btn1.setStyle(BUTTONIDLE);
			});
			btn1.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
			+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
			btn1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle (ActionEvent e) {
					account a = new account(userId, First, Last, Email, Phone, Password);
					a.start(account.aStage);
					
					homeStage.close();
				}
			});
			
			Button btn2 = new Button("Purchase\nHistory");
			btn2.setCursor(Cursor.HAND);
			btn2.setMinWidth(100);
			btn2.setMinHeight(50);
			btn2.setFocusTraversable(false);
			btn2.setTextFill(Color.rgb(255, 255, 255));
			btn2.hoverProperty().addListener((observable,  oldValue,  show) -> {
				if (btn2.isHover())
					btn2.setStyle(BUTTONHOVER);
				else
					btn2.setStyle(BUTTONIDLE);
			});
			btn2.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
			+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
			btn2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle (ActionEvent e) {
					homeStage.close();
					
					showprev a = new showprev(userId, First, Last, Email, Phone, Password);
					a.start(showprev.showPrev);
				}
			});
			
			Button btn3 = new Button("Home");
			btn3.setCursor(Cursor.HAND);
			btn3.setMinWidth(100);
			btn3.setMinHeight(50);
			btn3.setFocusTraversable(false);
			btn3.setTextFill(Color.rgb(255, 255, 255));
			btn3.hoverProperty().addListener((observable,  oldValue,  show) -> {
				if (btn3.isHover())
					btn3.setStyle(BUTTONHOVER);
				else
					btn3.setStyle(BUTTONIDLE);
			});
			btn3.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
			+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
			btn3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle (ActionEvent e) {
					
					homeStage.close();
					
					home h = new home(userId, First, Last, Email, Phone, Password);
					h.start(home.hStage);
				}
			});
			
			Button btn4 = new Button("My\nCompany");
			btn4.setCursor(Cursor.HAND);
			btn4.setMinWidth(100);
			btn4.setMinHeight(50);
			btn4.setFocusTraversable(false);
			btn4.setTextFill(Color.rgb(255, 255, 255));
			btn4.hoverProperty().addListener((observable,  oldValue,  show) -> {
				if (btn4.isHover())
					btn4.setStyle(BUTTONHOVER);
				else
					btn4.setStyle(BUTTONIDLE);
				
			});
			btn4.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
			+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
			btn4.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle (ActionEvent e) {
					try {
					
						usecomp uc = new usecomp();
						if (uc.compCheck(userId) == true){
							usercomp1 hi = new usercomp1(Integer.parseInt(userId), usercomp1.CompName, usercomp1.Address, usercomp1.City, usercomp1.State, usercomp1.Zip, usercomp1.TotInvest);
							hi.start(usercomp1.ucomp);
							
							homeStage.close();
						}
						else {
							usercomp2 h = new usercomp2(userId, First, Last, Email, Phone, Password);
							h.start(usercomp2.ucomp2);
							
							homeStage.close();
						}
						
					} catch (SQLException e1) 
					{
					}
				}
			});
			
			Button newInvest = new Button("Make Investment");
			newInvest.setCursor(Cursor.HAND);
			newInvest.setMinWidth(200);
			newInvest.setMinHeight(50);
			newInvest.setFocusTraversable(false);
			newInvest.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle (ActionEvent e)
				{
					invests mi = new invests(Integer.parseInt(userId), First, Last, Email, Phone, Password);
					mi.start(invests.newInvest);
					System.out.println("Link was clicked");
					
					homeStage.close();
				}
			});
			Label val = new Label();
			investmentDAO dao;
			try {
				dao = new investmentDAO();
				if (!dao.showInvest(userId).isEmpty()) 
				{
					ObservableList<investment> data = FXCollections.observableArrayList(dao.showInvest(userId));	
					for (investment element : data) 
					{
						 val = new Label("Investment ID: " +element.getID()+ "\nCompany Name: " +element.getComp()+ "\nAmount of Shares: " 
								 		+element.getSamount()+ "\nPurchase Price: $" +element.getPamount()+ "\nTime of Purchase: " + element.getTime());
					}
				}
				else
					val = new Label("No investment to display");
			} catch (SQLException e1) 
			{}	
			
			Button currInvest = new Button("Show Current Investments");
			currInvest.setCursor(Cursor.HAND);
			currInvest.setMinWidth(200);
			currInvest.setMinHeight(50);
			currInvest.setFocusTraversable(false);
			currInvest.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle (ActionEvent e) {
					showinvest shI = new showinvest(userId, First, Last, Email, Phone, Password);
					shI.start(showinvest.showInvest);
					
					homeStage.close();
				}
			});
			
			Button modInvest = new Button("Update Investment");
			modInvest.setCursor(Cursor.HAND);
			modInvest.setMinWidth(200);
			modInvest.setMinHeight(50);
			modInvest.setFocusTraversable(false);
			modInvest.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle (ActionEvent e) {
					preupdinvest pupd = new preupdinvest(userId, First, Last, Email, Phone, Password);
					pupd.start(preupdinvest.preupdInvest);
					
					homeStage.close();
				}
			});
			
			VBox vb = new VBox();
			vb.setAlignment(Pos.CENTER);
			vb.setMaxHeight(500); vb.setMaxWidth(100);
			vb.setMinHeight(500); vb.setMinWidth(100);
			vb.setSpacing(45);
			vb.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
			vb.getChildren().addAll(btn3, btn4, btn2, btn1);
			
			VBox vb1 = new VBox();
			vb1.setAlignment(Pos.CENTER);
			vb1.setMaxHeight(75); vb1.setMaxWidth(400);
			vb1.setMinHeight(75); vb1.setMinWidth(400);
			vb1.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
			vb1.getChildren().add(label);
			
			VBox vb2 = new VBox();
			vb2.setAlignment(Pos.TOP_CENTER);
			vb2.setMaxHeight(430); vb2.setMaxWidth(300);
			vb2.setMinHeight(430); vb2.setMinWidth(300);
			vb2.setSpacing(20);
			vb2.setPadding(new Insets(15,0,0,0));
			vb2.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
			vb2.getChildren().addAll(lb, val, newInvest, currInvest, modInvest);
			
			BorderPane bp = new BorderPane();
			bp.setMaxHeight(500); bp.setMaxWidth(400);
			bp.setMinHeight(500); bp.setMinWidth(400);
			bp.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
			bp.setRight(vb2);
			bp.setBottom(vb);
			bp.setTop(vb1);
			
			
			
			StackPane sPane = new StackPane();
			sPane.setMaxHeight(500); sPane.setMaxWidth(400);
			sPane.setMinHeight(500); sPane.setMinWidth(400);
			sPane.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
			sPane.setAlignment(Pos.CENTER);
			sPane.getChildren().addAll(bp);
			
			Scene scene = new Scene(sPane);
			homeStage.setScene(scene);
			homeStage.setTitle("Home Page");
			homeStage.setResizable(false);
			homeStage.show();
			homeStage.setOnCloseRequest(new EventHandler<WindowEvent>() 
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

class account extends Application
{
	public static final String BUTTONHOVER = "-fx-text-fill: #FFFFFF;" + "-fx-background-color: #808080;" 
			+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
	public static final String BUTTONIDLE = "-fx-background-radius: 15px;" + "-fx-background-color: rgb(249,166,25);" 
			+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";

	static Stage aStage = new Stage();
	
	public static String userId;
	public static String First;
	public static String Last;
	public static String Email;
	public static String Phone;
	public static String Password;
	
	public account (String uid, String fname, String lname, String email, String num, String pass) {
		account.userId = uid;
		account.First = fname;
		account.Last = lname;
		account.Email = email;
		account.Phone = num;
		account.Password = pass;
	}

	public account(int userId2, String compName, String address, String city, String state, int zip, double totInvest) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(Stage accountStage) {
		aStage = accountStage;
		
		Label label = new Label("Account Management");
		label.setStyle(
				"-fx-text-fill: white; "+
				"-fx-font-weight: bold; "+
				"-fx-font-size: 14pt; "+
				"-fx-font-family: Courier;" );
		
		Label cname = new Label("Name of User:\n\t " + First +" "+ Last);
			cname.setStyle(
					"-fx-font-weight: bold; "+
					"-fx-font-size: 12pt; "+
					"-fx-font-family: Courier;" );
		
		Label cemail = new Label("Active Email:\n\t " + Email);
			cemail.setStyle(
					"-fx-font-weight: bold; "+
					"-fx-font-size: 12pt; "+
					"-fx-font-family: Courier;" );
		Label cphone = new Label("Active Phone Number:\n\t " + Phone);
			cphone.setStyle(
					"-fx-font-weight: bold; "+
					"-fx-font-size: 12pt; "+
					"-fx-font-family: Courier;" );
		Label cpass = new Label("Password:\n\t " + Password);
			cpass.setStyle(
					"-fx-font-weight: bold; "+
					"-fx-font-size: 12pt; "+
					"-fx-font-family: Courier;" );
		
		Button update = new Button("Update Account");
		update.setCursor(Cursor.HAND);
		update.setFocusTraversable(false);
		update.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				updateAccount ua = new updateAccount(userId, First, Last, Email, Phone, Password);
				ua.start(updateAccount.upStage);
				
				accountStage.close();
			}
		});
		
		Button delete = new Button("Delete Account");
		delete.setCursor(Cursor.HAND);
		delete.setFocusTraversable(false);
		delete.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					Alert alert = new Alert(AlertType.CONFIRMATION, "Are You Sure You Want To Delete This Account?", ButtonType.NO, ButtonType.YES, ButtonType.CANCEL);
					alert.showAndWait();

					if (alert.getResult() == ButtonType.YES) {
						userDAO uDao = new userDAO();
						uDao.deleteUser(Email);
						
						Main m = new Main();
						m.start(Main.mStage);
						
						accountStage.close();
					}
					
					if (alert.getResult() == ButtonType.NO) {
						
						accountStage.close();
						
						account a = new account(userId, First, Last, Email, Phone, Password);
						a.start(account.aStage);				
					}
					
					if (alert.getResult() == ButtonType.CANCEL) {
						
						accountStage.close();
						
						account a = new account(userId, First, Last, Email, Phone, Password);
						a.start(account.aStage);	
					}

				} catch (SQLException e1) {
					System.out.println("User Account Could Not Be Deleted");
				}
			}
		});
		
		Button signout = new Button("Sign Out");
		signout.setCursor(Cursor.HAND);
		signout.setFocusTraversable(false);
		signout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Main m = new Main();
				m.start(Main.mStage);
				
				accountStage.close();
			}
		});	
		
		HBox hb = new HBox();
		hb.setAlignment(Pos.BOTTOM_CENTER);
		hb.setSpacing(30);
		hb.getChildren().addAll(update, delete);
			
		Button btn1 = new Button("Account");
		btn1.setCursor(Cursor.HAND);
		btn1.setMinWidth(100);
		btn1.setMinHeight(50);
		btn1.setFocusTraversable(false);
		btn1.setTextFill(Color.rgb(255, 255, 255));
		btn1.hoverProperty().addListener((observable,  oldValue,  show) -> {
			if (btn1.isHover())
				btn1.setStyle(BUTTONHOVER);
			else
				btn1.setStyle(BUTTONIDLE);
		});
		btn1.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
		+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				accountStage.close();
				
				account a = new account(userId, First, Last, Email, Phone, Password);
				a.start(account.aStage);
			}
		});
		
		Button btn2 = new Button("Purchase\nHistory");
		btn2.setCursor(Cursor.HAND);
		btn2.setMinWidth(100);
		btn2.setMinHeight(50);
		btn2.setFocusTraversable(false);
		btn2.setTextFill(Color.rgb(255, 255, 255));
		btn2.hoverProperty().addListener((observable,  oldValue,  show) -> {
			if (btn2.isHover())
				btn2.setStyle(BUTTONHOVER);
			else
				btn2.setStyle(BUTTONIDLE);
		});
		btn2.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
		+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				accountStage.close();
				
				showprev a = new showprev(userId, First, Last, Email, Phone, Password);
				a.start(showprev.showPrev);
			}
		});
		
		Button btn3 = new Button("Home");
		btn3.setCursor(Cursor.HAND);
		btn3.setMinWidth(100);
		btn3.setMinHeight(50);
		btn3.setFocusTraversable(false);
		btn3.setTextFill(Color.rgb(255, 255, 255));
		btn3.hoverProperty().addListener((observable,  oldValue,  show) -> {
			if (btn3.isHover())
				btn3.setStyle(BUTTONHOVER);
			else
				btn3.setStyle(BUTTONIDLE);
		});
		btn3.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
		+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				home h = new home(userId, First, Last, Email, Phone, Password);
				h.start(home.hStage);
				
				accountStage.close();
			}
		});
		
		Button btn4 = new Button("My\nCompany");
		btn4.setCursor(Cursor.HAND);
		btn4.setMinWidth(100);
		btn4.setMinHeight(50);
		btn4.setFocusTraversable(false);
		btn4.setTextFill(Color.rgb(255, 255, 255));
		btn4.hoverProperty().addListener((observable,  oldValue,  show) -> {
			if (btn4.isHover())
				btn4.setStyle(BUTTONHOVER);
			else
				btn4.setStyle(BUTTONIDLE);
			
		});
		btn4.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
		+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
		btn4.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
				+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
				btn4.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle (ActionEvent e) {
						try {
						
							usecomp uc = new usecomp();
							if (uc.compCheck(userId) == true){
								usercomp1 hi = new usercomp1(Integer.parseInt(userId), usercomp1.CompName, usercomp1.Address, usercomp1.City, usercomp1.State, usercomp1.Zip, usercomp1.TotInvest);
								hi.start(usercomp1.ucomp);
								
								accountStage.close();
							}
							else {
								usercomp2 h = new usercomp2(userId, First, Last, Email, Phone, Password);
								h.start(usercomp2.ucomp2);
								
								accountStage.close();
							}
							
						} catch (SQLException e1) 
						{
						}
					}
				});
		
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.setMaxHeight(500); vb.setMaxWidth(100);
		vb.setMinHeight(500); vb.setMinWidth(100);
		vb.setSpacing(45);
		vb.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
		vb.getChildren().addAll(btn3, btn4, btn2, btn1);
		
		VBox vb1 = new VBox();
		vb1.setAlignment(Pos.CENTER);
		vb1.setMaxHeight(75); vb1.setMaxWidth(400);
		vb1.setMinHeight(75); vb1.setMinWidth(400);
		vb1.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
		vb1.getChildren().add(label);
		
		VBox vb2 = new VBox();
		vb2.setAlignment(Pos.TOP_CENTER);
		vb2.setMaxHeight(430); vb2.setMaxWidth(300);
		vb2.setMinHeight(430); vb2.setMinWidth(300);
		vb2.setSpacing(35);
		vb2.setPadding(new Insets(15,0,0,0));
		vb2.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
		vb2.getChildren().addAll(cname, cemail, cphone, cpass, signout, hb);
		
		BorderPane bp = new BorderPane();
		bp.setMaxHeight(500); bp.setMaxWidth(400);
		bp.setMinHeight(500); bp.setMinWidth(400);
		bp.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
		bp.setRight(vb2);
		bp.setBottom(vb);
		bp.setTop(vb1);
		
		StackPane sPane = new StackPane();
		sPane.setMaxHeight(500); sPane.setMaxWidth(400);
		sPane.setMinHeight(500); sPane.setMinWidth(400);
		sPane.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
		sPane.setAlignment(Pos.CENTER);
		sPane.getChildren().addAll(bp);
		
		Scene scene = new Scene(sPane);
		accountStage.setScene(scene);
		accountStage.setTitle("Account Page");
		accountStage.setResizable(false);
		accountStage.show();
		accountStage.setOnCloseRequest(new EventHandler<WindowEvent>() 
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

class updateAccount extends Application
{
	public static final String BUTTONHOVER = "-fx-text-fill: #FFFFFF;" + "-fx-background-color: #808080;" 
			+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
	public static final String BUTTONIDLE = "-fx-background-radius: 15px;" + "-fx-background-color: rgb(249,166,25);" 
			+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";

	static Stage upStage = new Stage();
	final int maxlen = 25;
	
	public String userId;
	public String First;
	public String Last;
	public String Email;
	public String Phone;
	public String Password;
	
	public updateAccount (String uid, String fname, String lname, String email, String num, String pass) {
		this.userId = uid;
		this.First = fname;
		this.Last = lname;
		this.Email = email;
		this.Phone = num;
		this.Password = pass;
	}

	@Override
	public void start(Stage updateStage) {
		upStage = updateStage;
		
		Label label = new Label("Account Management");
		label.setStyle(
				"-fx-text-fill: white; "+
				"-fx-font-weight: bold; "+
				"-fx-font-size: 14pt; "+
				"-fx-font-family: Courier;" );
		
		TextField firstname = new TextField();
		firstname.setFocusTraversable(false);
		firstname.setMaxWidth(180);
		firstname.setPromptText("First Name");
		firstname.setText(First);
		firstname.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		            if(newValue.length() > maxlen) 
		            	 ((StringProperty)observable).setValue(oldValue);
		        }
		);
		if(firstname.getText().trim().isEmpty()) {
            firstname.setText(First);
		}
		            
		TextField lastname = new TextField();
		lastname.setFocusTraversable(false);
		lastname.setMaxWidth(180);
		lastname.setPromptText("Last Name");
		lastname.setText(Last);
		lastname.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		            if(newValue.length() > maxlen) 
		            	 ((StringProperty)observable).setValue(oldValue);
		        }
		);
		if(lastname.getText().trim().isEmpty()) {
            lastname.setText(Last);
		}
		
		TextField em = new TextField();
		em.setFocusTraversable(false);
		em.setMaxWidth(180);
		em.setPromptText("Email");
		em.setText(Email);
		em.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		            if(newValue.length() > maxlen+5) 
		            	 ((StringProperty)observable).setValue(oldValue);
		        }
		);
		if(em.getText().trim().isEmpty()) {
            em.setText(Email);
		}
		
		TextField phonenumber = new TextField();
		phonenumber.setFocusTraversable(false);
		phonenumber.setMaxWidth(180);
		phonenumber.setPromptText("Phone Number");
		phonenumber.setText(Phone);
		phonenumber.textProperty().addListener(new ChangeListener<String>() {
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		            phonenumber.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		});
		phonenumber.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		            if(newValue.length() > 10) 
		            	 ((StringProperty)observable).setValue(oldValue);
		        }
		);	
		if(phonenumber.getText().trim().isEmpty()) {
            phonenumber.setText(Phone); 
		}
		
        
		PasswordField password = new PasswordField();
		password.setFocusTraversable(false);
		password.setMaxWidth(180);
		password.setPromptText("Password");
		password.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		            if(newValue.length() > maxlen) 
		            	 ((StringProperty)observable).setValue(oldValue);
		        }
		);
		if(password.getText().trim().isEmpty()) {
            password.setText(Password);
		}
		
		TextField confirmpass = new TextField();
		confirmpass.setFocusTraversable(false);
		confirmpass.setMaxWidth(180);
		confirmpass.setPromptText("Confirm Password");
		confirmpass.textProperty().addListener(
		        (observable,oldValue,newValue)-> {
		            if(newValue.length() > maxlen) 
		            	 ((StringProperty)observable).setValue(oldValue);
		        }
		);
		
		Label cname = new Label("Update Name:");
			cname.setStyle(
					"-fx-font-weight: bold; "+
					"-fx-font-size: 10pt; "+
					"-fx-font-family: Courier;" );
		
		Label cemail = new Label("Update Email:");
			cemail.setStyle(
					"-fx-font-weight: bold; "+
					"-fx-font-size: 10pt; "+
					"-fx-font-family: Courier;" );
		Label cphone = new Label("Update Phone Number:");
			cphone.setStyle(
					"-fx-font-weight: bold; "+
					"-fx-font-size: 10pt; "+
					"-fx-font-family: Courier;" );
		Label currpass = new Label("Change Password:");
			currpass.setStyle(
					"-fx-font-weight: bold; "+
					"-fx-font-size: 10pt; "+
					"-fx-font-family: Courier;" );
		
		VBox up1 = new VBox();
		up1.setAlignment(Pos.CENTER);
		up1.getChildren().addAll(cname, firstname, lastname);
		
		VBox up2 = new VBox();
		up2.setAlignment(Pos.CENTER);
		up2.getChildren().addAll(cemail, em);
		
		VBox up3 = new VBox();
		up3.setAlignment(Pos.CENTER);
		up3.getChildren().addAll(cphone, phonenumber);
		
		VBox up4 = new VBox();
		up4.setAlignment(Pos.CENTER);
		up4.getChildren().addAll(currpass, password, confirmpass);
			
		Button update = new Button("Confirm Update");
		update.setCursor(Cursor.HAND);
		update.setFocusTraversable(false);
		update.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String fname = firstname.getText();
				String lname = lastname.getText();
				String email = em.getText();
				String phone = phonenumber.getText();
				String pass = password.getText();
				String cpass = confirmpass.getText();
				
				fname = fname.substring(0,1).toUpperCase() + fname.substring(1);
				lname = lname.substring(0,1).toUpperCase() + lname.substring(1);
				try {
					userDAO dao = new userDAO();
					user u = new user(fname, lname, email, phone, pass, userId);
					
					if (dao.suNewUser(email) || email.equals(Email)){
						if (pass.equals(cpass)) {
							if (dao.updateUser(u)) {
								System.out.println("Updates Were Made");
	
								First = fname;
								Last = lname;
								Email = email;
								Phone = phone;
								Password = pass;
								
								account a = new account(userId, First, Last, Email, Phone, Password);
								a.start(account.aStage);
								
								updateStage.close();
							}
						}
						else
							System.out.println("The Password Do Not Match");
					}
					else
						System.out.println("An Account Already Exists For This Email");
					
				} catch (SQLException e1) {
					
				}
				
			}
		});
			
		Button cancel = new Button("Cancel");
		cancel.setCursor(Cursor.HAND);
		cancel.setFocusTraversable(false);
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				account a = new account(userId, First, Last, Email, Phone, Password);
				a.start(account.aStage);
				
				updateStage.close();
			}
		});	
		
		HBox up5 = new HBox();
		up5.setAlignment(Pos.CENTER);
		up5.setSpacing(30);
		up5.getChildren().addAll(update,cancel);
		
		Button btn1 = new Button("Account");
		btn1.setCursor(Cursor.HAND);
		btn1.setMinWidth(100);
		btn1.setMinHeight(50);
		btn1.setFocusTraversable(false);
		btn1.setTextFill(Color.rgb(255, 255, 255));
		btn1.hoverProperty().addListener((observable,  oldValue,  show) -> {
			if (btn1.isHover())
				btn1.setStyle(BUTTONHOVER);
			else
				btn1.setStyle(BUTTONIDLE);
		});
		btn1.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
		+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				account a = new account(userId, First, Last, Email, Phone, Password);
				a.start(account.aStage);
				
				updateStage.close();
			}
		});
		
		Button btn2 = new Button("Purchase\nHistory");
		btn2.setCursor(Cursor.HAND);
		btn2.setMinWidth(100);
		btn2.setMinHeight(50);
		btn2.setFocusTraversable(false);
		btn2.setTextFill(Color.rgb(255, 255, 255));
		btn2.hoverProperty().addListener((observable,  oldValue,  show) -> {
			if (btn2.isHover())
				btn2.setStyle(BUTTONHOVER);
			else
				btn2.setStyle(BUTTONIDLE);
		});
		btn2.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
		+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				updateStage.close();
				
				showprev a = new showprev(userId, First, Last, Email, Phone, Password);
				a.start(showprev.showPrev);
			}
		});
		
		Button btn3 = new Button("Home");
		btn3.setCursor(Cursor.HAND);
		btn3.setMinWidth(100);
		btn3.setMinHeight(50);
		btn3.setFocusTraversable(false);
		btn3.setTextFill(Color.rgb(255, 255, 255));
		btn3.hoverProperty().addListener((observable,  oldValue,  show) -> {
			if (btn3.isHover())
				btn3.setStyle(BUTTONHOVER);
			else
				btn3.setStyle(BUTTONIDLE);
		});
		btn3.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
		+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				home h = new home(userId, First, Last, Email, Phone, Password);
				h.start(home.hStage);
				
				updateStage.close();
			}
		});
		
		Button btn4 = new Button("My\nCompany");
		btn4.setCursor(Cursor.HAND);
		btn4.setMinWidth(100);
		btn4.setMinHeight(50);
		btn4.setFocusTraversable(false);
		btn4.setTextFill(Color.rgb(255, 255, 255));
		btn4.hoverProperty().addListener((observable,  oldValue,  show) -> {
			if (btn4.isHover())
				btn4.setStyle(BUTTONHOVER);
			else
				btn4.setStyle(BUTTONIDLE);
			
		});
		btn4.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
		+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
		btn4.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
				+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
				btn4.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle (ActionEvent e) {
						try {
						
							usecomp uc = new usecomp();
							if (uc.compCheck(userId) == true){
								usercomp1 hi = new usercomp1(Integer.parseInt(userId), usercomp1.CompName, usercomp1.Address, usercomp1.City, usercomp1.State, usercomp1.Zip, usercomp1.TotInvest);
								hi.start(usercomp1.ucomp);
								
								updateStage.close();
							}
							else {
								usercomp2 h = new usercomp2(userId, First, Last, Email, Phone, Password);
								h.start(usercomp2.ucomp2);
								
								updateStage.close();
							}
							
						} catch (SQLException e1) 
						{
						}
					}
				});
		
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.setMaxHeight(500); vb.setMaxWidth(100);
		vb.setMinHeight(500); vb.setMinWidth(100);
		vb.setSpacing(45);
		vb.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
		vb.getChildren().addAll(btn3, btn4, btn2, btn1);
		
		VBox vb1 = new VBox();
		vb1.setAlignment(Pos.CENTER);
		vb1.setMaxHeight(75); vb1.setMaxWidth(400);
		vb1.setMinHeight(75); vb1.setMinWidth(400);
		vb1.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
		vb1.getChildren().add(label);
		
		VBox vb2 = new VBox();
		vb2.setAlignment(Pos.TOP_CENTER);
		vb2.setMaxHeight(430); vb2.setMaxWidth(300);
		vb2.setMinHeight(430); vb2.setMinWidth(300);
		vb2.setSpacing(35);
		vb2.setPadding(new Insets(15,0,0,0));
		vb2.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
		vb2.getChildren().addAll(up1, up2, up3, up4, up5);
		
		BorderPane bp = new BorderPane();
		bp.setMaxHeight(500); bp.setMaxWidth(400);
		bp.setMinHeight(500); bp.setMinWidth(400);
		bp.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
		bp.setRight(vb2);
		bp.setBottom(vb);
		bp.setTop(vb1);
		
		StackPane sPane = new StackPane();
		sPane.setMaxHeight(500); sPane.setMaxWidth(400);
		sPane.setMinHeight(500); sPane.setMinWidth(400);
		sPane.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
		sPane.setAlignment(Pos.CENTER);
		sPane.getChildren().addAll(bp);
		
		Scene scene = new Scene(sPane);
		updateStage.setScene(scene);
		updateStage.setTitle("Update Account Page");
		updateStage.setResizable(false);
		updateStage.show();
		updateStage.setOnCloseRequest(new EventHandler<WindowEvent>() 
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

class showprev extends Application
{
		public static final String BUTTONHOVER = "-fx-text-fill: #FFFFFF;" + "-fx-background-color: #808080;" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		public static final String BUTTONIDLE = "-fx-background-radius: 15px;" + "-fx-background-color: rgb(249,166,25);" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		static Stage showPrev = new Stage();
		
		public String userId;
		public String First;
		public String Last;
		public String Email;
		public String Phone;
		public String Password;
		
		public showprev (String uid, String fname, String lname, String email, String num, String pass) {
			this.userId = uid;
			this.First = fname;
			this.Last = lname;
			this.Email = email;
			this.Phone = num;
			this.Password = pass;
			
		}
		
			public void start(Stage showP) {
				showPrev = showP;
				
				Label label = new Label("All of "+First+"'s Investments");
					label.setStyle(
							"-fx-text-fill: white; "+
							"-fx-font-weight: bold; "+
							"-fx-font-size: 15pt; "+
							"-fx-font-family: Courier;" );
				
				Button btn1 = new Button("Account");
					btn1.setCursor(Cursor.HAND);
					btn1.setMinWidth(100);
					btn1.setMinHeight(50);
					btn1.setFocusTraversable(false);
					btn1.setTextFill(Color.rgb(255, 255, 255));
					btn1.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn1.isHover())
							btn1.setStyle(BUTTONHOVER);
						else
							btn1.setStyle(BUTTONIDLE);
						
					});
					btn1.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn1.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							account a = new account(userId, First, Last, Email, Phone, Password);
							a.start(account.aStage);
							
							showP.close();
						}
					});
				
				Button btn2 = new Button("Purchase\nHistory");
					btn2.setCursor(Cursor.HAND);
					btn2.setMinWidth(100);
					btn2.setMinHeight(50);
					btn2.setFocusTraversable(false);
					btn2.setTextFill(Color.rgb(255, 255, 255));
					btn2.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn2.isHover())
							btn2.setStyle(BUTTONHOVER);
						else
							btn2.setStyle(BUTTONIDLE);
						
					});
					btn2.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn2.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							showP.close();
							
							showprev a = new showprev(userId, First, Last, Email, Phone, Password);
							a.start(showprev.showPrev);
						}
					});
				
				Button btn3 = new Button("Home");
					btn3.setCursor(Cursor.HAND);
					btn3.setMinWidth(100);
					btn3.setMinHeight(50);
					btn3.setFocusTraversable(false);
					btn3.setTextFill(Color.rgb(255, 255, 255));
					btn3.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn3.isHover())
							btn3.setStyle(BUTTONHOVER);
						else
							btn3.setStyle(BUTTONIDLE);
						
					});
					btn3.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn3.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							home h = new home(userId, First, Last, Email, Phone, Password);
							h.start(home.hStage);
							
							showP.close();
						}
					});
					
					Button btn4 = new Button("My\nCompany");
					btn4.setCursor(Cursor.HAND);
					btn4.setMinWidth(100);
					btn4.setMinHeight(50);
					btn4.setFocusTraversable(false);
					btn4.setTextFill(Color.rgb(255, 255, 255));
					btn4.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn4.isHover())
							btn4.setStyle(BUTTONHOVER);
						else
							btn4.setStyle(BUTTONIDLE);
						
					});
					btn4.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn4.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
							+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
							btn4.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle (ActionEvent e) {
									try {
									
										usecomp uc = new usecomp();
										if (uc.compCheck(userId) == true){
											usercomp1 hi = new usercomp1(Integer.parseInt(userId), usercomp1.CompName, usercomp1.Address, usercomp1.City, usercomp1.State, usercomp1.Zip, usercomp1.TotInvest);
											hi.start(usercomp1.ucomp);
											
											showP.close();
										}
										else {
											usercomp2 h = new usercomp2(userId, First, Last, Email, Phone, Password);
											h.start(usercomp2.ucomp2);
											
											showP.close();
										}
										
									} catch (SQLException e1) 
									{
									}
								}
							});
													
				VBox vb = new VBox();
					vb.setAlignment(Pos.CENTER);
					vb.setMaxHeight(500); vb.setMaxWidth(100);
					vb.setMinHeight(500); vb.setMinWidth(100);
					vb.setSpacing(45);
					vb.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
					vb.getChildren().addAll(btn3, btn4, btn2, btn1);
					
				VBox vb1 = new VBox();
					vb1.setAlignment(Pos.CENTER);
					vb1.setMaxHeight(75); vb1.setMaxWidth(400);
					vb1.setMinHeight(75); vb1.setMinWidth(400);
					vb1.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
					vb1.getChildren().add(label);
				
				VBox vb2 = new VBox();
					vb2.setAlignment(Pos.TOP_CENTER);
					vb2.setMaxHeight(450); vb2.setMaxWidth(300);
					vb2.setMinHeight(450); vb2.setMinWidth(300);
					vb2.setSpacing(15);
					vb2.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
						
				Label val = new Label();
				previnvestmentDAO dao;
					try {
						dao = new previnvestmentDAO();
						if (!dao.showHistory(userId).isEmpty()) 
						{
							ObservableList<investment_history> data = FXCollections.observableArrayList(dao.showHistory(userId));	
							for (investment_history element : data) 
							{
								TextFlow flow = new TextFlow();
								flow.setTextAlignment(TextAlignment.CENTER);;
								Text tx = new Text(element.getType());
								tx.setStyle("-fx-font-weight: bold; " + "-fx-font-family: Courier;");
								Text tx1 = new Text(" Investment ID: " + element.getiID() + "\nTime of Purchase: " + element.getTime()+"\nCompany Name: " 
										+element.getComp()+ "\nAmount of Shares: " +element.getSamount()+ "\nPurchase Price: $" +element.getPamount());
								flow.getChildren().addAll(tx, tx1);
								 
								vb2.getChildren().add(flow);
								vb2.setMinHeight(vb2.getMinHeight() + 100);
								
							}
						}
						else {
							val = new Label("No investment to display");
							vb2.getChildren().add(val);
						}
					} catch (SQLException e1) 
					{}	
				
					Button delete = new Button("Clear History");
					delete.setCursor(Cursor.HAND);
					delete.setFocusTraversable(false);
					delete.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							try {
								Alert alert = new Alert(AlertType.CONFIRMATION, "Are You Sure You Want To Clear Investment History?", ButtonType.NO, ButtonType.YES, ButtonType.CANCEL);
								alert.showAndWait();

								if (alert.getResult() == ButtonType.YES) {
									previnvestmentDAO dao = new previnvestmentDAO();
									dao.clearHistory(Integer.parseInt(userId));
									
									home m = new home(userId, First, Last, Email, Phone, Password);
									m.start(home.hStage);
									
									showP.close();
								}
								
								if (alert.getResult() == ButtonType.NO) {
									
									showP.close();
									
									showprev a = new showprev(userId, First, Last, Email, Phone, Password);
									a.start(showprev.showPrev);				
								}
								
								if (alert.getResult() == ButtonType.CANCEL) {
									
									showP.close();
									
									showprev a = new showprev(userId, First, Last, Email, Phone, Password);
									a.start(showprev.showPrev);	
								}

							} catch (SQLException e1) {
								System.out.println("User Account Could Not Be Deleted");
							}
						}
					});
				vb2.getChildren().add(delete);	
					
				ScrollPane sb = new ScrollPane();
				sb.setContent(vb2);
				sb.setMinViewportHeight(0);
				sb.setHbarPolicy(ScrollBarPolicy.NEVER);
				sb.setMaxHeight(450); sb.setMaxWidth(300);
				sb.setMinHeight(450); sb.setMinWidth(300);
				sb.setPadding(new Insets(30,0,0,0));
				sb.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
				
				BorderPane bp = new BorderPane();
					bp.setMaxHeight(500); bp.setMaxWidth(400);
					bp.setMinHeight(500); bp.setMinWidth(400);
					bp.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
					bp.setRight(sb);
					bp.setBottom(vb);
					bp.setTop(vb1);
				
				StackPane sPane = new StackPane();
					sPane.setMaxHeight(500); sPane.setMaxWidth(400);
					sPane.setMinHeight(500); sPane.setMinWidth(400);
					sPane.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
					sPane.setAlignment(Pos.CENTER);
					sPane.getChildren().addAll(bp);	
					
				Scene scene = new Scene(sPane);
					showP.setScene(scene);
					showP.setTitle("Investment History Page");
					showP.setResizable(false);
					showP.show();
					showP.setOnCloseRequest(new EventHandler<WindowEvent>() 
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

////////////////////////////////////////////////////////////////////////////////////////

class usercomp1 extends Application
{
		public static final String BUTTONHOVER = "-fx-text-fill: #FFFFFF;" + "-fx-background-color: #808080;" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		public static final String BUTTONIDLE = "-fx-background-radius: 15px;" + "-fx-background-color: rgb(249,166,25);" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		static Stage ucomp = new Stage();
		
		public static int userId;
		public static String CompName;
		public static String Address;
		public static String City;
		public static String State;
		public static int Zip;
		public static double TotInvest;
		
		public usercomp1 (int uid, String comp, String addy, String city, String state, int zip, double total) {
			this.userId = uid;
			this.CompName = comp;
			this.Address = addy;
			this.City = city;
			this.State = state;
			this.Zip = zip;
			this.TotInvest = total;
		}
		
			public void start(Stage ucompany) {
				ucomp = ucompany;
				
				usecomp dao;
				try {
					dao = new usecomp();
					if (!dao.showUserCompany(Integer.parseInt(home.userId)).isEmpty()) 
					{
						ObservableList<user_company> data = FXCollections.observableArrayList(dao.showUserCompany(Integer.parseInt(home.userId)));	
						for (user_company element : data) 
						{
							userId = element.getUid();
							CompName = element.getCompName();
							Address = element.getAddy();
							City = element.getCity();
							State = element.getState();
							Zip = element.getZip();
							TotInvest = element.getInvest();
						}
					}
				} catch (SQLException e1) 
				{}	
				
								
				Label label = new Label("User's Company");
				label.setStyle(
						"-fx-text-fill: white; "+
						"-fx-font-weight: bold; "+
						"-fx-font-size: 3em; "+
						"-fx-font-family: Courier;" );
				
				Label lb = new Label(CompName);
				lb.setStyle(
						"-fx-font-weight: bold; "+
						"-fx-font-size: 22pt; "+
						"-fx-font-family: Courier;" );
				
				Label lb2 = new Label();
				lb2.setStyle(
						"-fx-font-weight: bold; "+
						"-fx-font-size: 28pt; "+
						"-fx-font-family: Courier;" );
				
				Label lb4 = new Label();
				lb4.setStyle(
						"-fx-font-weight: bold; "+
						"-fx-font-size: 28pt; "+
						"-fx-font-family: Courier;" );
				
				
				Button reveal = new Button("Reveal");
				reveal.setCursor(Cursor.HAND);
				reveal.setFocusTraversable(false);
				reveal.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {	
						int numb = 0;
						try {
							investmentDAO dao = new investmentDAO();
							usecomp ucp = new usecomp();
							
							TotInvest = dao.earned(CompName);
							numb = dao.num(CompName);
							user_company u_c = new user_company(userId, CompName, TotInvest);
		
							if(ucp.updateamount(u_c)) {
								System.out.println("Update Successful");
							}
							
							lb2.setText(String.valueOf(numb));
							lb4.setText(String.valueOf(TotInvest));
							
						} catch (SQLException e1) {
							
						}
					}
				});
				
				Button info = new Button("Info");
				info.setCursor(Cursor.HAND);
				info.setFocusTraversable(false);
				info.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						compinfo ci = new compinfo(userId, CompName, Address, City, State, Zip, TotInvest);
						ci.start(compinfo.compInfo);
						
						ucompany.close();
					}
				});
				
				Button delete = new Button("Delete");
				delete.setCursor(Cursor.HAND);
				delete.setFocusTraversable(false);
				delete.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						try {
							Alert alert = new Alert(AlertType.CONFIRMATION, "Are You Sure You Want To Remove This Business?", ButtonType.NO, ButtonType.YES, ButtonType.CANCEL);
							alert.showAndWait();

							if (alert.getResult() == ButtonType.YES) {
							usecomp doa = new usecomp();
							doa.deleteComp(userId);
							
							company co = new company();
							co.deletecomp(CompName);
							
							usecomp uc = new usecomp();
							uc.deleteIComp(CompName);		
							System.out.println("You Successfully Remove This Company");
							
							home h = new home(home.userId, home.First, home.Last, home.Email, home.Phone, home.Password);
							h.start(home.hStage);
							
							ucompany.close();
							}
							
							if (alert.getResult() == ButtonType.NO) {
								
								ucompany.close();
								
								usercomp1 h = new usercomp1(usercomp1.userId, usercomp1.CompName, usercomp1.Address, usercomp1.City, usercomp1.State, usercomp1.Zip, usercomp1.TotInvest);
								h.start(usercomp1.ucomp);				
							}
							
							if (alert.getResult() == ButtonType.CANCEL) {
								
								ucompany.close();
								
								usercomp1 h = new usercomp1(usercomp1.userId, usercomp1.CompName, usercomp1.Address, usercomp1.City, usercomp1.State, usercomp1.Zip, usercomp1.TotInvest);
								h.start(usercomp1.ucomp);	
							}

						} catch (SQLException e1) {
						}
					}
				});
				
				HBox hb = new HBox();
				hb.setAlignment(Pos.CENTER);
				hb.setSpacing(20);
				hb.getChildren().addAll(info, delete);
							
				Label lb1 = new Label("Number of Investors");
				lb1.setStyle(
						"-fx-font-weight: bold; "+
						"-fx-font-size: 12pt; "+
						"-fx-font-family: Courier;" );
				
				Label lb3 = new Label("Amount Invested in Company");
				lb3.setStyle(
						"-fx-font-weight: bold; "+
						"-fx-font-size: 12pt; "+
						"-fx-font-family: Courier;" );
				
				Button btn1 = new Button("Account");
					btn1.setCursor(Cursor.HAND);
					btn1.setMinWidth(100);
					btn1.setMinHeight(50);
					btn1.setFocusTraversable(false);
					btn1.setTextFill(Color.rgb(255, 255, 255));
					btn1.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn1.isHover())
							btn1.setStyle(BUTTONHOVER);
						else
							btn1.setStyle(BUTTONIDLE);
						
					});
					btn1.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn1.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							account a = new account(home.userId, home.First, home.Last, home.Email, home.Phone, home.Password);
							a.start(account.aStage);
							
							ucompany.close();
						}
					});
				
				Button btn2 = new Button("Purchase\nHistory");
					btn2.setCursor(Cursor.HAND);
					btn2.setMinWidth(100);
					btn2.setMinHeight(50);
					btn2.setFocusTraversable(false);
					btn2.setTextFill(Color.rgb(255, 255, 255));
					btn2.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn2.isHover())
							btn2.setStyle(BUTTONHOVER);
						else
							btn2.setStyle(BUTTONIDLE);
						
					});
					btn2.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn2.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							ucompany.close();
							
							showprev a = new showprev(home.userId, home.First, home.Last, home.Email, home.Phone, home.Password);
							a.start(showprev.showPrev);
						}
					});
				
				Button btn3 = new Button("Home");
					btn3.setCursor(Cursor.HAND);
					btn3.setMinWidth(100);
					btn3.setMinHeight(50);
					btn3.setFocusTraversable(false);
					btn3.setTextFill(Color.rgb(255, 255, 255));
					btn3.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn3.isHover())
							btn3.setStyle(BUTTONHOVER);
						else
							btn3.setStyle(BUTTONIDLE);
						
					});
					btn3.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn3.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							home h = new home(home.userId, home.First, home.Last, home.Email, home.Phone, home.Password);
							h.start(home.hStage);
							
							ucompany.close();
						}
					});
						
				Button btn4 = new Button("My\nCompany");
					btn4.setCursor(Cursor.HAND);
					btn4.setMinWidth(100);
					btn4.setMinHeight(50);
					btn4.setFocusTraversable(false);
					btn4.setTextFill(Color.rgb(255, 255, 255));
					btn4.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn4.isHover())
							btn4.setStyle(BUTTONHOVER);
						else
							btn4.setStyle(BUTTONIDLE);
						
					});
					btn4.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn4.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
							+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
							btn4.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle (ActionEvent e) {
									try {
									
										usecomp uc = new usecomp();
										if (uc.compCheck(String.valueOf(userId)) == true){
											ucompany.close();
											
											usercomp1 hi = new usercomp1(userId, usercomp1.CompName, usercomp1.Address, usercomp1.City, usercomp1.State, usercomp1.Zip, usercomp1.TotInvest);
											hi.start(usercomp1.ucomp);
										}
										else {
											usercomp2 h = new usercomp2(String.valueOf(userId), home.First, home.Last, home.Email, home.Phone, home.Password);
											h.start(usercomp2.ucomp2);
											
											ucompany.close();
										}
										
									} catch (SQLException e1) 
									{
									}
								}
							});
					
				VBox vb = new VBox();
					vb.setAlignment(Pos.CENTER);
					vb.setMaxHeight(500); vb.setMaxWidth(100);
					vb.setMinHeight(500); vb.setMinWidth(100);
					vb.setSpacing(35);
					vb.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
					vb.getChildren().addAll(btn3, btn4, btn2, btn1);
					
				VBox vb1 = new VBox();
					vb1.setAlignment(Pos.CENTER);
					vb1.setMaxHeight(75); vb1.setMaxWidth(400);
					vb1.setMinHeight(75); vb1.setMinWidth(400);
					vb1.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
					vb1.getChildren().add(label);
				
				VBox vb2 = new VBox();
					vb2.setAlignment(Pos.TOP_CENTER);
					vb2.setMaxHeight(400); vb2.setMaxWidth(300);
					vb2.setMinHeight(400); vb2.setMinWidth(300);
					vb2.setSpacing(30);
					vb2.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
					vb2.getChildren().addAll(lb, lb1, lb2, lb3, lb4, reveal, hb);		
					
				BorderPane bp = new BorderPane();
					bp.setMaxHeight(500); bp.setMaxWidth(400);
					bp.setMinHeight(500); bp.setMinWidth(400);
					bp.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
					bp.setRight(vb2);
					bp.setBottom(vb);
					bp.setTop(vb1);
				
				StackPane sPane = new StackPane();
					sPane.setMaxHeight(500); sPane.setMaxWidth(400);
					sPane.setMinHeight(500); sPane.setMinWidth(400);
					sPane.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
					sPane.setAlignment(Pos.CENTER);
					sPane.getChildren().addAll(bp);	
					
				Scene scene = new Scene(sPane);
					ucompany.setScene(scene);
					ucompany.setTitle("View Company Page");
					ucompany.setResizable(false);
					ucompany.show();
					ucompany.setOnCloseRequest(new EventHandler<WindowEvent>() 
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

class usercomp2 extends Application
{
		public static final String BUTTONHOVER = "-fx-text-fill: #FFFFFF;" + "-fx-background-color: #808080;" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		public static final String BUTTONIDLE = "-fx-background-radius: 15px;" + "-fx-background-color: rgb(249,166,25);" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		static Stage ucomp2 = new Stage();
		
		public String userId;
		public String First;
		public String Last;
		public String Email;
		public String Phone;
		public String Password;
		public static String Company;
		public static String City;
		public static String State;
		public static String Address;
		public static int Zip;
		public static double Total;
		public static int UserId;
		
		public usercomp2 (String uid, String fname, String lname, String email, String num, String pass) {
			this.userId = uid;
			this.First = fname;
			this.Last = lname;
			this.Email = email;
			this.Phone = num;
			this.Password = pass;
			
		}
		
			public void start(Stage ucompany2) {
				ucomp2 = ucompany2;
				
				Label label = new Label("User's Company");
				label.setStyle(
						"-fx-text-fill: white; "+
						"-fx-font-weight: bold; "+
						"-fx-font-size: 3em; "+
						"-fx-font-family: Courier;" );
				
				Label lb = new Label("Register A New Company");
				lb.setStyle(
						"-fx-font-weight: bold; "+
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				TextField companyname = new TextField();
				companyname.setPromptText("Name of Company");
				companyname.setFocusTraversable(false);
				companyname.setMaxWidth(130);
				companyname.textProperty().addListener(
				        (observable,oldValue,newValue)-> {
				            if(newValue.length() > 30) 
				            	 ((StringProperty)observable).setValue(oldValue);
				        }
				);
				
				TextField address = new TextField();
				address.setPromptText("Companies Address");
				address.setFocusTraversable(false);
				address.setMaxWidth(130);
				address.textProperty().addListener(
				        (observable,oldValue,newValue)-> {
				            if(newValue.length() > 35) 
				            	 ((StringProperty)observable).setValue(oldValue);
				        }
				);	
				            
				TextField city = new TextField();
				city.setPromptText("City");
				city.setFocusTraversable(false);
				city.setMaxWidth(130);
				city.textProperty().addListener(
				        (observable,oldValue,newValue)-> {
				            if(newValue.length() > 30) 
				            	 ((StringProperty)observable).setValue(oldValue);
				        }
				);
				
				TextField state = new TextField();
				state.setPromptText("State");
				state.setFocusTraversable(false);
				state.setMaxWidth(130);
				state.textProperty().addListener(
				        (observable,oldValue,newValue)-> {
				            if(newValue.length() > 2) 
				            	 ((StringProperty)observable).setValue(oldValue);
				        }
				);
				
				TextField zipcode = new TextField();
				zipcode.setPromptText("Zip Code");
				zipcode.setFocusTraversable(false);
				zipcode.setMaxWidth(130);
				zipcode.textProperty().addListener(
				        (observable,oldValue,newValue)-> {
				            if(newValue.length() > 5) 
				            	 ((StringProperty)observable).setValue(oldValue);
				        }
				);
				zipcode.textProperty().addListener(new ChangeListener<String>() {
				    public void changed(ObservableValue<? extends String> observable, String oldValue, 
				        String newValue) {
				        if (!newValue.matches("\\d*")) {
				            zipcode.setText(newValue.replaceAll("[^\\d]", ""));
				        }
				    }
				});
							
				Button register = new Button("Register");
				register.setCursor(Cursor.HAND);
				register.setFocusTraversable(false);
				register.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {	
						Company = companyname.getText();
						Address = address.getText();
						City = city.getText();
						State = state.getText();
						Zip = Integer.parseInt(zipcode.getText());
						Total = 0;
						UserId = Integer.parseInt(userId);
						
						State = State.substring(0,2).toUpperCase();
						
						try {
							usecomp uco = new usecomp();
							user_company u_c = new user_company(UserId, Company, Address, City, State, Zip, Total);
							
							if(uco.register(u_c)) {
								
								company co = new company();
								investment_company ic = new investment_company(Company); 
								
								if (co.addcomp(ic)) {
									System.out.println("Registration Successful");
									
									ucompany2.close();
									
									usercomp1 h = new usercomp1(UserId, Company, Address, City, State, Zip, Total);
									h.start(usercomp1.ucomp);
								}	
							}
							
						} catch (SQLException e1) {
							
						}
					}
				});
				
				
				HBox hb = new HBox();
				hb.setAlignment(Pos.CENTER);
				hb.setSpacing(20);
				hb.getChildren().addAll(address, city);
				
				HBox hb2 = new HBox();
				hb2.setAlignment(Pos.CENTER);
				hb2.setSpacing(20);
				hb2.getChildren().addAll(state, zipcode);
				
				Button btn1 = new Button("Account");
					btn1.setCursor(Cursor.HAND);
					btn1.setMinWidth(100);
					btn1.setMinHeight(50);
					btn1.setFocusTraversable(false);
					btn1.setTextFill(Color.rgb(255, 255, 255));
					btn1.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn1.isHover())
							btn1.setStyle(BUTTONHOVER);
						else
							btn1.setStyle(BUTTONIDLE);
						
					});
					btn1.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn1.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							account a = new account(userId, First, Last, Email, Phone, Password);
							a.start(account.aStage);
							
							ucompany2.close();
						}
					});
				
				Button btn2 = new Button("Purchase\nHistory");
					btn2.setCursor(Cursor.HAND);
					btn2.setMinWidth(100);
					btn2.setMinHeight(50);
					btn2.setFocusTraversable(false);
					btn2.setTextFill(Color.rgb(255, 255, 255));
					btn2.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn2.isHover())
							btn2.setStyle(BUTTONHOVER);
						else
							btn2.setStyle(BUTTONIDLE);
						
					});
					btn2.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn2.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							ucompany2.close();
							
							showprev a = new showprev(userId, First, Last, Email, Phone, Password);
							a.start(showprev.showPrev);
						}
					});
				
				Button btn3 = new Button("Home");
					btn3.setCursor(Cursor.HAND);
					btn3.setMinWidth(100);
					btn3.setMinHeight(50);
					btn3.setFocusTraversable(false);
					btn3.setTextFill(Color.rgb(255, 255, 255));
					btn3.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn3.isHover())
							btn3.setStyle(BUTTONHOVER);
						else
							btn3.setStyle(BUTTONIDLE);
						
					});
					btn3.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn3.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							home h = new home(userId, First, Last, Email, Phone, Password);
							h.start(home.hStage);
							
							ucompany2.close();
						}
					});
						
				Button btn4 = new Button("My\nCompany");
					btn4.setCursor(Cursor.HAND);
					btn4.setMinWidth(100);
					btn4.setMinHeight(50);
					btn4.setFocusTraversable(false);
					btn4.setTextFill(Color.rgb(255, 255, 255));
					btn4.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn4.isHover())
							btn4.setStyle(BUTTONHOVER);
						else
							btn4.setStyle(BUTTONIDLE);
						
					});
					btn4.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn4.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
							+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
							btn4.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle (ActionEvent e) {
									try {
									
										usecomp uc = new usecomp();
										if (uc.compCheck(userId) == true){
											usercomp1 hi = new usercomp1(Integer.parseInt(userId), usercomp1.CompName, usercomp1.Address, usercomp1.City, usercomp1.State, usercomp1.Zip, usercomp1.TotInvest);
											hi.start(usercomp1.ucomp);
											
											ucompany2.close();
										}
										else {
											usercomp2 h = new usercomp2(userId, First, Last, Email, Phone, Password);
											h.start(usercomp2.ucomp2);
											
											ucompany2.close();
										}
										
									} catch (SQLException e1) 
									{
									}
								}
							});
					
				VBox vb = new VBox();
					vb.setAlignment(Pos.CENTER);
					vb.setMaxHeight(500); vb.setMaxWidth(100);
					vb.setMinHeight(500); vb.setMinWidth(100);
					vb.setSpacing(35);
					vb.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
					vb.getChildren().addAll(btn3, btn4, btn2, btn1);
					
				VBox vb1 = new VBox();
					vb1.setAlignment(Pos.CENTER);
					vb1.setMaxHeight(75); vb1.setMaxWidth(400);
					vb1.setMinHeight(75); vb1.setMinWidth(400);
					vb1.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
					vb1.getChildren().add(label);
				
				VBox vb2 = new VBox();
					vb2.setAlignment(Pos.TOP_CENTER);
					vb2.setMaxHeight(400); vb2.setMaxWidth(300);
					vb2.setMinHeight(400); vb2.setMinWidth(300);
					vb2.setSpacing(40);
					vb2.setPadding(new Insets(40,0,0,0));
					vb2.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
					vb2.getChildren().addAll(lb, companyname, hb, hb2, register);		
					
				BorderPane bp = new BorderPane();
					bp.setMaxHeight(500); bp.setMaxWidth(400);
					bp.setMinHeight(500); bp.setMinWidth(400);
					bp.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
					bp.setRight(vb2);
					bp.setBottom(vb);
					bp.setTop(vb1);
				
				StackPane sPane = new StackPane();
					sPane.setMaxHeight(500); sPane.setMaxWidth(400);
					sPane.setMinHeight(500); sPane.setMinWidth(400);
					sPane.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
					sPane.setAlignment(Pos.CENTER);
					sPane.getChildren().addAll(bp);	
					
				Scene scene = new Scene(sPane);
					ucompany2.setScene(scene);
					ucompany2.setTitle("Company Registration Page");
					ucompany2.setResizable(false);
					ucompany2.show();
					ucompany2.setOnCloseRequest(new EventHandler<WindowEvent>() 
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

class compinfo extends Application
{
		public static final String BUTTONHOVER = "-fx-text-fill: #FFFFFF;" + "-fx-background-color: #808080;" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		public static final String BUTTONIDLE = "-fx-background-radius: 15px;" + "-fx-background-color: rgb(249,166,25);" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		static Stage compInfo = new Stage();
		
		public static int userId;
		public static String CompName;
		public static String Address;
		public static String City;
		public static String State;
		public static int Zip;
		public static double TotInvest;
		
		public compinfo (int uid, String comp, String addy, String city, String state, int zip, double total) {
			this.userId = uid;
			this.CompName = comp;
			this.Address = addy;
			this.City = city;
			this.State = state;
			this.Zip = zip;
			this.TotInvest = total;
		}
		
			public void start(Stage Info) {
				compInfo = Info;
				
//				usecomp dao;
//				try {
//					dao = new usecomp();
//					if (!dao.showUserCompany(Integer.parseInt(home.userId)).isEmpty()) 
//					{
//						ObservableList<user_company> data = FXCollections.observableArrayList(dao.showUserCompany(Integer.parseInt(home.userId)));	
//						for (user_company element : data) 
//						{
//							userId = element.getUid();
//							CompName = element.getCompName();
//							Address = element.getAddy();
//							City = element.getCity();
//							State = element.getState();
//							Zip = element.getZip();
//							TotInvest = element.getInvest();
//						}
//					}
//				} catch (SQLException e1) 
//				{}	
				
				Label label = new Label("Company Information");
				label.setStyle(
						"-fx-text-fill: white; "+
						"-fx-font-weight: bold; "+
						"-fx-font-size: 23pt; "+
						"-fx-font-family: Courier;" );
				
				Button update = new Button("Update Info");
				update.setCursor(Cursor.HAND);
				update.setFocusTraversable(false);
				update.setOnAction(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent e) {
						updateinfo ui = new updateinfo(userId, CompName, Address, City, State, Zip, TotInvest);
						ui.start(updateinfo.updInfo);
						
						Info.close();
					}
				});
				
				Label lb = new Label("Company Name");
				lb.setStyle(
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				Label lb1 = new Label(CompName);
				lb1.setStyle(
						"-fx-font-weight: bold; "+
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				VBox line1 = new VBox();
				line1.setAlignment(Pos.CENTER);
				line1.setSpacing(10);
				line1.getChildren().addAll(lb, lb1);
				
				Label lb2 = new Label("Company Address");
				lb2.setStyle(
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				Label lb3 = new Label(Address);
				lb3.setStyle(
						"-fx-font-weight: bold; "+
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				VBox line2 = new VBox();
				line2.setAlignment(Pos.CENTER);
				line2.setSpacing(10);
				line2.getChildren().addAll(lb2, lb3);
				
				Label lb4 = new Label("City");
				lb4.setStyle(
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				Label lb5 = new Label(City);
				lb5.setStyle(
						"-fx-font-weight: bold; "+
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				VBox line3 = new VBox();
				line3.setAlignment(Pos.CENTER);
				line3.setSpacing(10);
				line3.getChildren().addAll(lb4, lb5);
				
				Label lb6 = new Label("State");
				lb6.setStyle(
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				Label lb7 = new Label(State);
				lb7.setStyle(
						"-fx-font-weight: bold; "+
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				VBox line4 = new VBox();
				line4.setAlignment(Pos.CENTER);
				line4.setSpacing(10);
				line4.getChildren().addAll(lb6, lb7);
				
				Label lb8 = new Label("Zip Code");
				lb8.setStyle(
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				Label lb9 = new Label(String.valueOf(Zip));
				lb9.setStyle(
						"-fx-font-weight: bold; "+
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				VBox line5 = new VBox();
				line5.setAlignment(Pos.CENTER);
				line5.setSpacing(10);
				line5.getChildren().addAll(lb8, lb9);
				
				Button btn1 = new Button("Account");
					btn1.setCursor(Cursor.HAND);
					btn1.setMinWidth(100);
					btn1.setMinHeight(50);
					btn1.setFocusTraversable(false);
					btn1.setTextFill(Color.rgb(255, 255, 255));
					btn1.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn1.isHover())
							btn1.setStyle(BUTTONHOVER);
						else
							btn1.setStyle(BUTTONIDLE);
						
					});
					btn1.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn1.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							account a = new account(home.userId, home.First, home.Last, home.Email, home.Phone, home.Password);
							a.start(account.aStage);
							
							Info.close();
						}
					});
				
				Button btn2 = new Button("Purchase\nHistory");
					btn2.setCursor(Cursor.HAND);
					btn2.setMinWidth(100);
					btn2.setMinHeight(50);
					btn2.setFocusTraversable(false);
					btn2.setTextFill(Color.rgb(255, 255, 255));
					btn2.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn2.isHover())
							btn2.setStyle(BUTTONHOVER);
						else
							btn2.setStyle(BUTTONIDLE);
						
					});
					btn2.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn2.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							Info.close();
							
							showprev a = new showprev(home.userId, home.First, home.Last, home.Email, home.Phone, home.Password);
							a.start(showprev.showPrev);
						}
					});
				
				Button btn3 = new Button("Home");
					btn3.setCursor(Cursor.HAND);
					btn3.setMinWidth(100);
					btn3.setMinHeight(50);
					btn3.setFocusTraversable(false);
					btn3.setTextFill(Color.rgb(255, 255, 255));
					btn3.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn3.isHover())
							btn3.setStyle(BUTTONHOVER);
						else
							btn3.setStyle(BUTTONIDLE);
						
					});
					btn3.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn3.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							home h = new home(home.userId, home.First, home.Last, home.Email, home.Phone, home.Password);
							h.start(home.hStage);
							
							Info.close();
						}
					});
						
				Button btn4 = new Button("My\nCompany");
					btn4.setCursor(Cursor.HAND);
					btn4.setMinWidth(100);
					btn4.setMinHeight(50);
					btn4.setFocusTraversable(false);
					btn4.setTextFill(Color.rgb(255, 255, 255));
					btn4.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn4.isHover())
							btn4.setStyle(BUTTONHOVER);
						else
							btn4.setStyle(BUTTONIDLE);
						
					});
					btn4.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn4.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
							+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
							btn4.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle (ActionEvent e) {
									try {
									
										usecomp uc = new usecomp();
										if (uc.compCheck(String.valueOf(userId)) == true){
											usercomp1 hi = new usercomp1(userId, CompName, Address, City, State, Zip, TotInvest);
											hi.start(usercomp1.ucomp);
											
											Info.close();
										}
										else {
											usercomp2 h = new usercomp2(String.valueOf(userId), home.First, home.Last, home.Email, home.Phone, home.Password);
											h.start(usercomp2.ucomp2);
											
											Info.close();
										}
										
									} catch (SQLException e1) 
									{
									}
								}
							});
					
				VBox vb = new VBox();
					vb.setAlignment(Pos.CENTER);
					vb.setMaxHeight(500); vb.setMaxWidth(100);
					vb.setMinHeight(500); vb.setMinWidth(100);
					vb.setSpacing(35);
					vb.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
					vb.getChildren().addAll(btn3, btn4, btn2, btn1);
					
				VBox vb1 = new VBox();
					vb1.setAlignment(Pos.CENTER);
					vb1.setMaxHeight(75); vb1.setMaxWidth(400);
					vb1.setMinHeight(75); vb1.setMinWidth(400);
					vb1.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
					vb1.getChildren().addAll(label);
				
				VBox vb2 = new VBox();
					vb2.setAlignment(Pos.TOP_CENTER);
					vb2.setMaxHeight(400); vb2.setMaxWidth(300);
					vb2.setMinHeight(400); vb2.setMinWidth(300);
					vb2.setSpacing(20);
					vb2.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
					vb2.getChildren().addAll(line1, line2, line3, line4, line5, update);		
					
				BorderPane bp = new BorderPane();
					bp.setMaxHeight(500); bp.setMaxWidth(400);
					bp.setMinHeight(500); bp.setMinWidth(400);
					bp.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
					bp.setRight(vb2);
					bp.setBottom(vb);
					bp.setTop(vb1);
				
				StackPane sPane = new StackPane();
					sPane.setMaxHeight(500); sPane.setMaxWidth(400);
					sPane.setMinHeight(500); sPane.setMinWidth(400);
					sPane.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
					sPane.setAlignment(Pos.CENTER);
					sPane.getChildren().addAll(bp);	
					
				Scene scene = new Scene(sPane);
					Info.setScene(scene);
					Info.setTitle("Company Information Page");
					Info.setResizable(false);
					Info.show();
					Info.setOnCloseRequest(new EventHandler<WindowEvent>() 
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

class updateinfo extends Application
{
		public static final String BUTTONHOVER = "-fx-text-fill: #FFFFFF;" + "-fx-background-color: #808080;" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		public static final String BUTTONIDLE = "-fx-background-radius: 15px;" + "-fx-background-color: rgb(249,166,25);" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		static Stage updInfo = new Stage();
		
		public static int userId;
		public static String CompName;
		public static String Address;
		public static String City;
		public static String State;
		public static int Zip;
		public static double TotInvest;
		
		public updateinfo (int uid, String comp, String addy, String city, String state, int zip, double total) {
			this.userId = uid;
			this.CompName = comp;
			this.Address = addy;
			this.City = city;
			this.State = state;
			this.Zip = zip;
			this.TotInvest = total;
		}
		
			public void start(Stage upInfo) {
				updInfo = upInfo;					
				
				String oldcomp = CompName;
				
				Label label = new Label("Company Information");
				label.setStyle(
						"-fx-text-fill: white; "+
						"-fx-font-weight: bold; "+
						"-fx-font-size: 23pt; "+
						"-fx-font-family: Courier;" );
				
				Label lb = new Label("Company Name");
				lb.setStyle(
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				TextField comp = new TextField();
				comp.setFocusTraversable(false);
				comp.setMaxWidth(180);
				comp.setText(CompName);
				comp.textProperty().addListener(
				        (observable,oldValue,newValue)-> {
				            if(newValue.length() > 30) 
				            	 ((StringProperty)observable).setValue(oldValue);
				        }
				);
				if(comp.getText().trim().isEmpty()) {
		            comp.setText(CompName);
				}
				
				VBox line1 = new VBox();
				line1.setAlignment(Pos.CENTER);
				line1.setSpacing(10);
				line1.getChildren().addAll(lb, comp);
				
				Label lb2 = new Label("Company Address");
				lb2.setStyle(
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				TextField addy = new TextField();
				addy.setFocusTraversable(false);
				addy.setMaxWidth(180);
				addy.setPromptText("Last Name");
				addy.setText(Address);
				addy.textProperty().addListener(
				        (observable,oldValue,newValue)-> {
				            if(newValue.length() > 35) 
				            	 ((StringProperty)observable).setValue(oldValue);
				        }
				);
				if(addy.getText().trim().isEmpty()) {
		            addy.setText(Address);
				}
				
				VBox line2 = new VBox();
				line2.setAlignment(Pos.CENTER);
				line2.setSpacing(10);
				line2.getChildren().addAll(lb2, addy);
				
				Label lb4 = new Label("City");
				lb4.setStyle(
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				TextField cty = new TextField();
				cty.setFocusTraversable(false);
				cty.setMaxWidth(180);
				cty.setPromptText("Last Name");
				cty.setText(City);
				cty.textProperty().addListener(
				        (observable,oldValue,newValue)-> {
				            if(newValue.length() > 30) 
				            	 ((StringProperty)observable).setValue(oldValue);
				        }
				);
				if(cty.getText().trim().isEmpty()) {
		            cty.setText(City);
				}
				
				VBox line3 = new VBox();
				line3.setAlignment(Pos.CENTER);
				line3.setSpacing(10);
				line3.getChildren().addAll(lb4, cty);
				
				Label lb6 = new Label("State");
				lb6.setStyle(
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				TextField st = new TextField();
				st.setFocusTraversable(false);
				st.setMaxWidth(180);
				st.setPromptText("Last Name");
				st.setText(State);
				st.textProperty().addListener(
				        (observable,oldValue,newValue)-> {
				            if(newValue.length() > 2) 
				            	 ((StringProperty)observable).setValue(oldValue);
				        }
				);
				if(st.getText().trim().isEmpty()) {
		            st.setText(State);
				}
				
				VBox line4 = new VBox();
				line4.setAlignment(Pos.CENTER);
				line4.setSpacing(10);
				line4.getChildren().addAll(lb6, st);
				
				Label lb8 = new Label("Zip Code");
				lb8.setStyle(
						"-fx-font-size: 14pt; "+
						"-fx-font-family: Courier;" );
				
				TextField zip = new TextField();
				zip.setFocusTraversable(false);
				zip.setMaxWidth(180);
				zip.setPromptText("Phone Number");
				zip.setText(String.valueOf(Zip));
				zip.textProperty().addListener(new ChangeListener<String>() {
				    public void changed(ObservableValue<? extends String> observable, String oldValue, 
				        String newValue) {
				        if (!newValue.matches("\\d*")) {
				            zip.setText(newValue.replaceAll("[^\\d]", ""));
				        }
				    }
				});
				zip.textProperty().addListener(
				        (observable,oldValue,newValue)-> {
				            if(newValue.length() > 5) 
				            	 ((StringProperty)observable).setValue(oldValue);
				        }
				);	
				if(zip.getText().trim().isEmpty()) {
		            zip.setText(String.valueOf(Zip)); 
				}
				
				VBox line5 = new VBox();
				line5.setAlignment(Pos.CENTER);
				line5.setSpacing(10);
				line5.getChildren().addAll(lb8, zip);
				
				Button update = new Button("Update Info");
				update.setCursor(Cursor.HAND);
				update.setFocusTraversable(false);
				update.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle (ActionEvent e) {
						String company = comp.getText();
						String address = addy.getText();
						String city = cty.getText();
						String state = st.getText();
						int zipcode = Integer.parseInt(zip.getText());
						
						state = state.substring(0,2).toUpperCase();

						
						try {
							usecomp userc = new usecomp();
							user_company uc = new user_company(userId, company, address, city, state, zipcode);
							
							company co = new company();
							investment_company ic = new investment_company(company, oldcomp);
							if (userc.updateCompInfo(uc) && co.updateComp(ic)) {
								System.out.println("Update Were Made");
								
								CompName = company;
								Address = address;
								City = city;
								State = state;
								Zip = zipcode;
								
								compinfo ci = new compinfo(userId, CompName, Address, City, State, Zip, TotInvest);
								ci.start(compinfo.compInfo);
								
								upInfo.close();
							}
						} catch (SQLException e1) {
						}
					}
				});
				
				Button btn1 = new Button("Account");
					btn1.setCursor(Cursor.HAND);
					btn1.setMinWidth(100);
					btn1.setMinHeight(50);
					btn1.setFocusTraversable(false);
					btn1.setTextFill(Color.rgb(255, 255, 255));
					btn1.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn1.isHover())
							btn1.setStyle(BUTTONHOVER);
						else
							btn1.setStyle(BUTTONIDLE);
						
					});
					btn1.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn1.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							account a = new account(home.userId, home.First, home.Last, home.Email, home.Phone, home.Password);
							a.start(account.aStage);
							
							upInfo.close();
						}
					});
				
				Button btn2 = new Button("Purchase\nHistory");
					btn2.setCursor(Cursor.HAND);
					btn2.setMinWidth(100);
					btn2.setMinHeight(50);
					btn2.setFocusTraversable(false);
					btn2.setTextFill(Color.rgb(255, 255, 255));
					btn2.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn2.isHover())
							btn2.setStyle(BUTTONHOVER);
						else
							btn2.setStyle(BUTTONIDLE);
						
					});
					btn2.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn2.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							upInfo.close();
							
							showprev a = new showprev(home.userId, home.First, home.Last, home.Email, home.Phone, home.Password);
							a.start(showprev.showPrev);
						}
					});
				
				Button btn3 = new Button("Home");
					btn3.setCursor(Cursor.HAND);
					btn3.setMinWidth(100);
					btn3.setMinHeight(50);
					btn3.setFocusTraversable(false);
					btn3.setTextFill(Color.rgb(255, 255, 255));
					btn3.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn3.isHover())
							btn3.setStyle(BUTTONHOVER);
						else
							btn3.setStyle(BUTTONIDLE);
						
					});
					btn3.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn3.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							home h = new home(home.userId, home.First, home.Last, home.Email, home.Phone, home.Password);
							h.start(home.hStage);
							
							upInfo.close();
						}
					});
						
				Button btn4 = new Button("My\nCompany");
					btn4.setCursor(Cursor.HAND);
					btn4.setMinWidth(100);
					btn4.setMinHeight(50);
					btn4.setFocusTraversable(false);
					btn4.setTextFill(Color.rgb(255, 255, 255));
					btn4.hoverProperty().addListener((observable,  oldValue,  show) -> {
						if (btn4.isHover())
							btn4.setStyle(BUTTONHOVER);
						else
							btn4.setStyle(BUTTONIDLE);
						
					});
					btn4.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
					+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
					btn4.setStyle("-fx-background-color: rgb(249,166,25);" + "-fx-font-weight: bold;" 
							+ "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;");
							btn4.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle (ActionEvent e) {
									try {
									
										usecomp uc = new usecomp();
										if (uc.compCheck(String.valueOf(userId)) == true){
											usercomp1 hi = new usercomp1(userId, CompName, Address, City, State, Zip, TotInvest);
											hi.start(usercomp1.ucomp);
											
											upInfo.close();
										}
										else {
											usercomp2 h = new usercomp2(String.valueOf(userId), home.First, home.Last, home.Email, home.Phone, home.Password);
											h.start(usercomp2.ucomp2);
											
											upInfo.close();
										}
										
									} catch (SQLException e1) 
									{
									}
								}
							});
					
				VBox vb = new VBox();
					vb.setAlignment(Pos.CENTER);
					vb.setMaxHeight(500); vb.setMaxWidth(100);
					vb.setMinHeight(500); vb.setMinWidth(100);
					vb.setSpacing(35);
					vb.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
					vb.getChildren().addAll(btn3, btn4, btn2, btn1);
					
				VBox vb1 = new VBox();
					vb1.setAlignment(Pos.CENTER);
					vb1.setMaxHeight(75); vb1.setMaxWidth(400);
					vb1.setMinHeight(75); vb1.setMinWidth(400);
					vb1.setBackground(new Background(new BackgroundFill(Color.rgb(249, 166, 25), null, null)));
					vb1.getChildren().addAll(label);
				
				VBox vb2 = new VBox();
					vb2.setAlignment(Pos.TOP_CENTER);
					vb2.setMaxHeight(400); vb2.setMaxWidth(300);
					vb2.setMinHeight(400); vb2.setMinWidth(300);
					vb2.setSpacing(20);
					vb2.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
					vb2.getChildren().addAll(line1, line2, line3, line4, line5, update);		
					
				BorderPane bp = new BorderPane();
					bp.setMaxHeight(500); bp.setMaxWidth(400);
					bp.setMinHeight(500); bp.setMinWidth(400);
					bp.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
					bp.setRight(vb2);
					bp.setBottom(vb);
					bp.setTop(vb1);
				
				StackPane sPane = new StackPane();
					sPane.setMaxHeight(500); sPane.setMaxWidth(400);
					sPane.setMinHeight(500); sPane.setMinWidth(400);
					sPane.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255),null, null)));
					sPane.setAlignment(Pos.CENTER);
					sPane.getChildren().addAll(bp);	
					
				Scene scene = new Scene(sPane);
					upInfo.setScene(scene);
					upInfo.setTitle("Company Info Update Page");
					upInfo.setResizable(false);
					upInfo.show();
					upInfo.setOnCloseRequest(new EventHandler<WindowEvent>() 
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

