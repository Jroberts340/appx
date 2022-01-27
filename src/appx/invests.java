package appx;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class invests extends Application
{
		public static final String BUTTONHOVER = "-fx-text-fill: #FFFFFF;" + "-fx-background-color: #808080;" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		public static final String BUTTONIDLE = "-fx-background-radius: 15px;" + "-fx-background-color: rgb(249,166,25);" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		static Stage newInvest = new Stage();
		
		public static int userId;
		public static String First;
		public static String Last;
		public static String Email;
		public static String Phone;
		public static String Password;
		
		public invests (int uid, String fname, String lname, String email, String num, String pass) {
			invests.userId = uid;
			invests.First = fname;
			invests.Last = lname;
			invests.Email = email;
			invests.Phone = num;
			invests.Password = pass;
			
		}
		
			public void start(Stage newI) {
				newInvest = newI;
				
				Label label = new Label("New Investment");
					label.setStyle(
							"-fx-text-fill: white; "+
							"-fx-font-weight: bold; "+
							"-fx-font-size: 3em; "+
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
							account a = new account(home.userId, First, Last, Email, Phone, Password);
							a.start(home.hStage);
							
							newI.close();
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
							newI.close();
							
							showprev a = new showprev(String.valueOf(userId), First, Last, Email, Phone, Password);
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
							home h = new home(home.userId, First, Last, Email, Phone, Password);
							h.start(home.hStage);
							
							newI.close();
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
											usercomp1 hi = new usercomp1(userId, usercomp1.CompName, usercomp1.Address, usercomp1.City, usercomp1.State, usercomp1.Zip, usercomp1.TotInvest);
											hi.start(usercomp1.ucomp);
											
											newI.close();
										}
										else {
											usercomp2 h = new usercomp2(String.valueOf(userId), First, Last, Email, Phone, Password);
											h.start(usercomp2.ucomp2);
											
											newI.close();
										}
										
									} catch (SQLException e1) 
									{
									}
								}
							});
				
				Label lb = new Label("Which Company Do You Want To Invest In?");
					lb.setStyle(
							"-fx-text-fill: rgb(249,166,25); "+
							"-fx-font-weight: bold; "+
							"-fx-font-size: 8pt; "+
							"-fx-font-family: Courier;" );
				
				Label lb1 = new Label("How Many Shares Would You Like To Buy");
					lb1.setStyle(
							"-fx-text-fill: rgb(249,166,25); "+
							"-fx-font-weight: bold; "+
							"-fx-font-size: 8pt; "+
							"-fx-font-family: Courier;" );
				
				Label lb2 = new Label("How Much Money Would You Like To Invest ");
					lb2.setStyle(
							"-fx-text-fill: rgb(249,166,25); "+
							"-fx-font-weight: bold; "+
							"-fx-font-size: 8pt; "+
							"-fx-font-family: Courier;" );
				
				ComboBox<String> cb = new ComboBox<String>();
				company comp;
				try {
					 comp = new company();
					 if (!comp.showCompany().isEmpty()) 
						{
							ObservableList<investment_company> data = FXCollections.observableArrayList(comp.showCompany());	
							for (investment_company element : data) 
							{
								String tx = String.valueOf(element.getComp());
								cb.getItems().add(tx);
							}
						}
					 
				} catch (SQLException e2) {
					
				}
				
				TextField tf2 = new TextField();
					tf2.setFocusTraversable(false);
					tf2.setMaxWidth(180);
					tf2.textProperty().addListener(new ChangeListener<String>() {
					    public void changed(ObservableValue<? extends String> observable, String oldValue, 
					        String newValue) {
					        if (!newValue.matches("\\d*")) {
					            tf2.setText(newValue.replaceAll("[^\\d]", ""));
					        }
					    }
					});
				
				TextField tf3 = new TextField();
					tf3.setFocusTraversable(false);
					tf3.setMaxWidth(180);
					tf3.textProperty().addListener(new ChangeListener<String>() {
					    public void changed(ObservableValue<? extends String> observable, String oldValue, 
					        String newValue) {
					        if (!newValue.matches("\\d*")) {
					            tf3.setText(newValue.replaceAll("[^\\d]", ""));
					        }
					    }
					});
				
					
					
				Button addDB = new Button("Invest");
					addDB.setFocusTraversable(false);
					addDB.setCursor(Cursor.HAND);
					addDB.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							String compname = cb.getValue();
							int samount = Integer.parseInt(tf2.getText());
							double pamount = Double.parseDouble(tf3.getText());
							String type = "Original";
													
							try {
								investmentDAO dao = new investmentDAO();
								previnvestmentDAO pdao = new previnvestmentDAO();
								investment invest = new investment(userId,compname,samount,pamount);
								
								if (dao.NewInvest(invest)) {
									int investID = dao.get();
									investment_history i = new investment_history(type, investID, userId,compname,samount,pamount);
									if (pdao.saveInvest(i)) {
										System.out.println("Investment Successful");
										
										home h = new home(home.userId, First, Last, Email, Phone, Password);
										h.start(home.hStage);
											
										newI.close();
									}
								}
							} catch (SQLException e1) {
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
					vb2.setSpacing(25);
					vb2.setPadding(new Insets(30,0,0,0));
					vb2.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
					vb2.getChildren().addAll(lb, cb, lb1, tf2, lb2, tf3, addDB);
					//vb2.getChildren().addAll(table);
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
				newI.setScene(scene);
				newI.setTitle("Investment Page");
				newI.setResizable(false);
				newI.show();
				newI.setOnCloseRequest(new EventHandler<WindowEvent>() 
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

class showinvest extends Application
{
		public static final String BUTTONHOVER = "-fx-text-fill: #FFFFFF;" + "-fx-background-color: #808080;" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		public static final String BUTTONIDLE = "-fx-background-radius: 15px;" + "-fx-background-color: rgb(249,166,25);" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		static Stage showInvest = new Stage();
		
		public String userId;
		public String First;
		public String Last;
		public String Email;
		public String Phone;
		public String Password;
		
		public showinvest (String uid, String fname, String lname, String email, String num, String pass) {
			this.userId = uid;
			this.First = fname;
			this.Last = lname;
			this.Email = email;
			this.Phone = num;
			this.Password = pass;
			
		}
		
			public void start(Stage showI) {
				showInvest = showI;
				
				Label label = new Label(First + "'s Current Investments");
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
							a.start(home.hStage);
							
							showI.close();
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
							showI.close();
							
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
							
							showI.close();
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
								if (uc.compCheck(String.valueOf(userId)) == true){
									usercomp1 hi = new usercomp1(Integer.parseInt(userId), usercomp1.CompName, usercomp1.Address, usercomp1.City, usercomp1.State, usercomp1.Zip, usercomp1.TotInvest);
									hi.start(usercomp1.ucomp);
									
									showI.close();
								}
								else {
									usercomp2 h = new usercomp2(String.valueOf(userId), First, Last, Email, Phone, Password);
									h.start(usercomp2.ucomp2);
									
									showI.close();
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
					vb2.setSpacing(25);
					vb2.setPadding(new Insets(10,0,0,0));
					vb2.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
						
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
								 
								vb2.getChildren().add(val);
								vb2.setMinHeight(vb2.getMinHeight() + 50);

							}
						}
						else
							val = new Label("No investment to display");
					} catch (SQLException e1) 
					{}	
				
				ScrollPane sb = new ScrollPane();
				sb.setContent(vb2);
				sb.setHbarPolicy(ScrollBarPolicy.NEVER);
				sb.setMaxHeight(430); sb.setMaxWidth(300);
				sb.setMinHeight(430); sb.setMinWidth(300);
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
					showI.setScene(scene);
					showI.setTitle("Show Investment Page");
					showI.setResizable(false);
					showI.show();
					showI.setOnCloseRequest(new EventHandler<WindowEvent>() 
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

class preupdinvest extends Application
{
		public static final String BUTTONHOVER = "-fx-text-fill: #FFFFFF;" + "-fx-background-color: #808080;" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		public static final String BUTTONIDLE = "-fx-background-radius: 15px;" + "-fx-background-color: rgb(249,166,25);" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		static Stage preupdInvest = new Stage();
		
		public String userId;
		public String First;
		public String Last;
		public String Email;
		public String Phone;
		public String Password;
		
		public preupdinvest (String uid, String fname, String lname, String email, String num, String pass) {
			this.userId = uid;
			this.First = fname;
			this.Last = lname;
			this.Email = email;
			this.Phone = num;
			this.Password = pass;
			
		}
		
			public void start(Stage preupdI) {
				preupdInvest = preupdI;
				
				Label label = new Label("Updating Current Investments");
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
							a.start(home.hStage);
							
							preupdI.close();
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
							preupdI.close();
							
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
							
							preupdI.close();
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
								if (uc.compCheck(String.valueOf(userId)) == true){
									usercomp1 hi = new usercomp1(Integer.parseInt(userId), usercomp1.CompName, usercomp1.Address, usercomp1.City, usercomp1.State, usercomp1.Zip, usercomp1.TotInvest);
									hi.start(usercomp1.ucomp);
									
									preupdI.close();
								}
								else {
									usercomp2 h = new usercomp2(String.valueOf(userId), First, Last, Email, Phone, Password);
									h.start(usercomp2.ucomp2);
									
									preupdI.close();
								}
								
							} catch (SQLException e1) 
							{
							}
						}
					});
					
				TextField tf = new TextField();
					tf.setFocusTraversable(false);
					tf.setMaxWidth(180);
					tf.textProperty().addListener(new ChangeListener<String>() {
					    public void changed(ObservableValue<? extends String> observable, String oldValue, 
					        String newValue) {
					        if (!newValue.matches("\\d*")) {
					            tf.setText(newValue.replaceAll("[^\\d]", ""));
					        }
					    }
					});
				
				Label lb = new Label("Input Investment ID# of\nInvestment Would Like To Change");
					lb.setAlignment(Pos.CENTER);
					lb.setStyle(
						"-fx-font-size: 10pt; "+
						"-fx-font-family: Courier;" );
/////////////////////////////////////////////////////////////////////////				
				Button makeu = new Button("Make Updates");
					makeu.setFocusTraversable(false);
					makeu.setCursor(Cursor.HAND);
					makeu.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle (ActionEvent e) {
							int id = Integer.parseInt(tf.getText());
							
							try {
								investmentDAO dao = new investmentDAO();
								if (dao.idCheck(id)) {
									updinvest upd = new updinvest(id, Integer.parseInt(userId));
									upd.start(updinvest.updInvest);
									
									preupdI.close();
									}
								
							} catch (SQLException e1) {
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
					vb2.setAlignment(Pos.CENTER);
					vb2.setMaxHeight(430); vb2.setMaxWidth(300);
					vb2.setMinHeight(430); vb2.setMinWidth(300);
					vb2.setSpacing(35);
					vb2.setPadding(new Insets(30,0,0,0));
					vb2.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
					vb2.getChildren().addAll(lb, tf, makeu);
				
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
					preupdI.setScene(scene);
					preupdI.setTitle("Update Investment Page");
					preupdI.setResizable(false);
					preupdI.show();
					preupdI.setOnCloseRequest(new EventHandler<WindowEvent>() 
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

class updinvest extends Application
{
		public static final String BUTTONHOVER = "-fx-text-fill: #FFFFFF;" + "-fx-background-color: #808080;" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		public static final String BUTTONIDLE = "-fx-background-radius: 15px;" + "-fx-background-color: rgb(249,166,25);" 
													+ "-fx-font-weight: bold;" + "-fx-font-family: Courier;" + "-fx-font-size: 12pt ;";
		static Stage updInvest = new Stage();
		
		public static int userId;
		public static int InvestId;
		
		public updinvest (int investid, int user) {
			updinvest.InvestId = investid;
			updinvest.userId = user;
		}
		
			public void start(Stage updI) {
				updInvest = updI;
				
				Label companyname = new Label();
				companyname.setStyle(
						"-fx-font-size: 16pt; "+
						"-fx-font-family: Courier;" );
				
				Label lb = new Label("Amount of Shares");
				lb.setStyle(
						"-fx-font-size: 10pt; "+
						"-fx-font-family: Courier;" );
				
				Label lb1 = new Label("Purchase Amount");
				lb1.setStyle(
						"-fx-font-size: 10pt; "+
						"-fx-font-family: Courier;" );
				
				TextField shareamount = new TextField();
				shareamount.setFocusTraversable(false);
				shareamount.setMaxWidth(180);
				
				TextField purchaseamount = new TextField();
				purchaseamount.setFocusTraversable(false);
				purchaseamount.setMaxWidth(180);

				investmentDAO dao;
				try {
					dao = new investmentDAO();
					if (!dao.updInvest(InvestId).isEmpty()) 
					{
						ObservableList<investment> data = FXCollections.observableArrayList(dao.updInvest(InvestId));	
						for (investment element : data) 
						{
							companyname.setText(element.getComp());
							shareamount.setText(String.valueOf(element.getSamount()));
							purchaseamount.setText(String.valueOf(element.getPamount()));
						}
					}
				} 
				catch (SQLException e1) 
				{}	
				
				Button update = new Button("Confirm Update");
				update.setCursor(Cursor.HAND);
				update.setFocusTraversable(false);
				update.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle (ActionEvent e) {
						String comp = companyname.getText();
						int sam = Integer.parseInt(shareamount.getText());
						double pam = Double.parseDouble(purchaseamount.getText());
						String type = "Updated";
						
											
						try {
							investmentDAO dao = new investmentDAO();
							previnvestmentDAO pdao = new previnvestmentDAO();
							investment invest = new investment(InvestId, sam, pam);
							investment_history i = new investment_history(type, InvestId, userId, comp, sam, pam);
							
							if(dao.updateInvestment(invest)) {
								if (pdao.saveInvest(i)) {
									System.out.println("Updates Were Made");
									home h = new home(home.userId, home.First, home.Last, home.Email, home.Phone, home.Password);
									h.start(home.hStage);
									
									updI.close();
								}
							}	
						}
						catch (SQLException ex){
							ex.printStackTrace();
						}
					}
				});
				
				Button delete = new Button("Pull Out Funds");
				delete.setCursor(Cursor.HAND);
				delete.setFocusTraversable(false);
				delete.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle (ActionEvent e) {
						try {
							Alert alert = new Alert(AlertType.CONFIRMATION, "Are You Sure You Want To Pull Out These Funds?", ButtonType.NO, ButtonType.YES, ButtonType.CANCEL);
							alert.showAndWait();

							if (alert.getResult() == ButtonType.YES) {
							investmentDAO doa = new investmentDAO();
							doa.deleteInvestment(InvestId);
							System.out.println("You Successfully Pulled Out Of This Investment");
							
							home h = new home(home.userId, home.First, home.Last, home.Email, home.Phone, home.Password);
							h.start(home.hStage);
							
							updI.close();
							}
							
							if (alert.getResult() == ButtonType.NO) {
								
								updI.close();
								
								home h = new home(home.userId, home.First, home.Last, home.Email, home.Phone, home.Password);
								h.start(home.hStage);				
							}
							
							if (alert.getResult() == ButtonType.CANCEL) {
								
								updI.close();
								
								home h = new home(home.userId, home.First, home.Last, home.Email, home.Phone, home.Password);
								h.start(home.hStage);	
							}

						} catch (SQLException e1) {
						}
					}
				});
				
				HBox hb = new HBox();
				hb.getChildren().addAll(update, delete);
				hb.setSpacing(30);
				hb.setAlignment(Pos.CENTER);
				
				Label label = new Label("Update Investments");
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
							account a = new account(account.userId, account.First, account.Last, account.Email, account.Phone, account.Password);
							a.start(home.hStage);
							
							updI.close();
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
							updI.close();
							
							showprev a = new showprev(String.valueOf(userId), home.First, home.Last, home.Email, home.Phone, home.Password);
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
							
							updI.close();
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
								if (uc.compCheck(String.valueOf(userId)) == true){
									usercomp1 hi = new usercomp1(userId, usercomp1.CompName, usercomp1.Address, usercomp1.City, usercomp1.State, usercomp1.Zip, usercomp1.TotInvest);
									hi.start(usercomp1.ucomp);
									
									updI.close();
								}
								else {
									usercomp2 h = new usercomp2(String.valueOf(userId), home.First, home.Last, home.Email, home.Phone, home.Password);
									h.start(usercomp2.ucomp2);
									
									updI.close();
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
					vb2.setPadding(new Insets(30,0,0,0));
					vb2.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), null, null)));
					vb2.getChildren().addAll(companyname, lb, shareamount, lb1, purchaseamount, hb);
					
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
					updI.setScene(scene);
					updI.setTitle("Update Investment Page");
					updI.setResizable(false);
					updI.show();
					updI.setOnCloseRequest(new EventHandler<WindowEvent>() 
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

