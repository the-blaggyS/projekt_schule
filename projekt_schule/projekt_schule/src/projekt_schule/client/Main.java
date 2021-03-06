package projekt_schule.client;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{
	
	private Scene aktScene; //Speichert die aktuell genutzte Scene
	private Stage mainStage;
	int x = 600;
	int y = 400;
	
	//Login Seite
	private Button loginButton; 
	private Button registerButton;
	
	//Register Seite
	private Button startRegistration;
	private TextField inputUsername;
	private TextField inputPassword;
	
	private final String cssStyle = "-fx-background-color: \r\n" + 
			"        linear-gradient(#ffd65b, #e68400),\r\n" + 
			"        linear-gradient(#ffef84, #f2ba44),\r\n" + 
			"        linear-gradient(#ffea6a, #efaa22),\r\n" + 
			"        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\r\n" + 
			"        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\r\n" + 
			"    -fx-background-radius: 30;\r\n" + 
			"    -fx-background-insets: 0,1,2,3,0;\r\n" + 
			"    -fx-text-fill: #654b00;\r\n" + 
			"    -fx-font-weight: bold;\r\n" + 
			"    -fx-font-size: 14px;\r\n" + 
			"    -fx-padding: 10 20 10 20;";
	private final String cssFriendGreen = " -fx-background-color: linear-gradient(#f0ff35, #a9ff00);\r\n" + 
			"    -fx-background-radius: 1;\r\n" + 
			"    -fx-background-insets: 0;\r\n" + 
			"    -fx-text-fill: black;";
	private final String cssFriendRed = "-fx-background-color: linear-gradient(#ff5400, #be1d00);\r\n" + 
			"    -fx-background-radius: 1;\r\n" + 
			"    -fx-background-insets: 0;\r\n" + 
			"    -fx-text-fill: white;";

	@Override
	public void start(Stage primaryStage) throws Exception {
		//MainStage zuweisen
		mainStage = primaryStage;
		mainStage.setTitle("g&f");
		mainStage.setResizable(false);
		//Login erzeugen
		mainStage.setScene(setLoginScene());
		mainStage.show();
	}
	
	
	/**
	 * Die Methode gibt die Scene f�r einen Login zur�ck.
	 */
	public Scene setLoginScene() {
		Scene aktScene = new Scene(new Label(""), x,y);
		//�berschrift erstellen
		Label headline1 = new Label("Games &");
		headline1.setFont(new Font("Cambria",100));
		headline1.setStyle("-fx-background-color:POWDERBLUE");
		Label headline2 = new Label("Friends");
		headline2.setFont(new Font("Cambria", 100));
		headline2.setStyle("-fx-background-color:POWDERBLUE");
		VBox subBoxHeadline = new VBox();
		subBoxHeadline.getChildren().addAll(headline1,headline2);
		subBoxHeadline.setAlignment(Pos.CENTER);
		//Buttons erzeugen
		loginButton = new Button();
		loginButton.setText("Log in");
		loginButton.setMinWidth(aktScene.getWidth() * 0.5);
		loginButton.setFont(new Font("Cambria", 25));
		loginButton.setStyle(cssStyle);
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				updateScene(setMainMenu());
			}
		});
		registerButton = new Button();
		registerButton.setText("register");
		registerButton.setMinWidth(aktScene.getWidth() * 0.5);
		registerButton.setStyle(cssStyle);
		registerButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Register clicked");
				updateScene(setRegisterScene());
				
			}
		});
		VBox store = new VBox();
		store.getChildren().add(subBoxHeadline);
		store.getChildren().add(loginButton);
		store.getChildren().add(registerButton);
		store.setAlignment(Pos.CENTER);
		store.setSpacing(10);
		store.setStyle("-fx-background-color:POWDERBLUE");
		subBoxHeadline.setSpacing(0);
		Scene scene = new Scene(store, x, y);
		return scene;
	}
	
	/**
	 * Erzeugt die GUI, welche die Daten, die f�r eine Registrierug notwendig sind, einholt.
	 */
	public Scene setRegisterScene() {
		//Titel �ndern
		mainStage.setTitle("registration");
		//Seite erzeugen
		Label headline = new Label("registration");
		headline.setFont(new Font("Cambria", 100));
		Label username = new Label("username");
		username.setFont(new Font("Cambria", 40));
		inputUsername = new TextField();
		inputUsername.setFont(new Font("Cambria", 25));
		HBox storeUsername = new HBox();
		storeUsername.setSpacing(5);
		storeUsername.setAlignment(Pos.CENTER);
		storeUsername.getChildren().addAll(username, inputUsername);
		Label password = new Label("password");
		password.setFont(new Font("Cambria", 40));
		inputPassword = new TextField();
		inputPassword.setFont(new Font("Cambria", 25));
		HBox storePassword = new HBox();
		storePassword.setSpacing(5);
		storePassword.setAlignment(Pos.CENTER);
		storePassword.getChildren().addAll(password, inputPassword);
		registerButton = new Button("register");
		registerButton.setMinWidth(x * 0.5);
		registerButton.setStyle(cssStyle);
		registerButton.setOnAction(new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent arg0) {
				System.out.println(inputUsername.getText() + ":" + inputPassword.getText());
				/**
				 * Die Methode schickt eine Anfrage an den Server, ob der Name vergeben ist.
				 * Ist der Namen vergeben, wird eine Mitteilung ausgegeben.
				 * Ist der Name nicht vergeben, wird ein neuer Nutzer erstellt eingef�gt und 
				 * anschlie�end wird dieser eingelogt.
				 */
			}
		});
		Button backButton = new Button("back");
		backButton.setMinWidth(x * 0.5);
		backButton.setStyle(cssStyle);
		backButton.setOnAction(new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent arg0) {
				updateScene(setLoginScene());
			}
		});
		VBox store = new VBox();
		store.setAlignment(Pos.CENTER);
		store.setSpacing(10);
		store.getChildren().addAll(headline, storeUsername, storePassword, registerButton, backButton  );
		store.setStyle("-fx-background-color:POWDERBLUE");
		Scene scene = new Scene(store,x,y);
		return scene;
	}
	
	public void updateScene(Scene scene) {
		mainStage.setScene(scene);
	}
	
	/**
	 * Erzeugt das Main-Menu der Anwendung.  
	 */
	public Scene setMainMenu() {
		//Bildschirmgr��e aktualisieren
		x = 700;
		y = 500;
		//Titel aktualisieren
		mainStage.setTitle("games & friends");
		//BorderPane einrichten
		BorderPane root = new BorderPane();
		//�berschrift erzeugen
		HBox headlineStore = new HBox();
		headlineStore.setAlignment(Pos.CENTER);
		headlineStore.setSpacing(110);
		Label headlineLeague = new Label("League:");
		headlineLeague.setFont(new Font("Cambria", 50));
		headlineLeague.setMinHeight(y * 0.2);
		headlineLeague.setMaxHeight(y * 0.2);
		headlineLeague.setMinWidth(y * 0.7);
		headlineLeague.setMaxWidth(y * 0.7);
		Label headlineFriends = new Label("Friends");
		headlineFriends.setMinHeight(y * 0.2);
		headlineFriends.setMaxHeight(y * 0.2);
		headlineFriends.setFont(new Font("Cambria", 50));
		headlineFriends.setAlignment(Pos.CENTER);
		headlineStore.getChildren().addAll(headlineLeague, headlineFriends);
		//Buttons f�r Freund erzeugen
		VBox buttonsFriends = getFriends();
		ScrollPane scroll = new ScrollPane(buttonsFriends);
		scroll.setHbarPolicy(ScrollBarPolicy.NEVER);;
		scroll.setMaxHeight(y * 0.6);
		scroll.setMinHeight(y * 0.6);
		scroll.setStyle("-fx-background:POWDERBLUE; -fx-background-color:transparent;");
		scroll.setBorder(null);
		//Alle Buttons am Boden speichern
		//Freunde hinzuf�gen Button machen
		Button btn = new Button("add friend");
		btn.setOnAction((evt)->System.out.println("add"));
		btn.setMaxHeight(y * 0.1);
		btn.setMinHeight(y * 0.1);
		btn.setStyle(cssStyle);
		//Spielen Button machen
		Button playButton = new Button("play");
		playButton.setMinHeight(y * 0.1);
		playButton.setMaxHeight(y * 0.1);
		playButton.setStyle(cssStyle);
		//Liga verlassen/suchen hinzuf�gen
		Button manageLeague = new Button("leave/add");
		manageLeague.setMinHeight(y * 0.1);
		manageLeague.setMaxHeight(y * 0.1);
		manageLeague.setStyle(cssStyle);
		Region buttonsRegion1 = new Region();
        HBox.setHgrow(buttonsRegion1, Priority.ALWAYS);
        Region buttonsRegion2 = new Region();
        HBox.setHgrow(buttonsRegion2, Priority.ALWAYS);
        HBox subButtonsStore = new HBox();
        subButtonsStore = new HBox();
        subButtonsStore.setAlignment(Pos.CENTER);
        subButtonsStore.setMinWidth(x * 0.6);
        subButtonsStore.setMaxWidth(x * 0.6);
        subButtonsStore.setSpacing(30);
        subButtonsStore.getChildren().addAll(playButton, manageLeague);
        HBox buttonsStore = new HBox(subButtonsStore, buttonsRegion1, buttonsRegion2, btn);
        //Button symmetrisch unter der Liste erzeugen
        buttonsStore.setPadding(new Insets(y * 0.06, (x*0.3-btn.getWidth())*0.25, 20, 0));
		//Der Wurzel hinzuf�gen
		root.setTop(headlineStore);
		ScrollPane leagueView = new ScrollPane(createLeagueView());
		leagueView.setMinHeight(y * 0.6);
		leagueView.setMaxHeight(y * 0.6);
		leagueView.setHbarPolicy(ScrollBarPolicy.NEVER);
		leagueView.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		leagueView.setStyle("-fx-background:POWDERBLUE; -fx-background-color:transparent;");
		leagueView.setBorder(null);
		//Sp�ter entfernen
		VBox tmp2 = (VBox) leagueView.getContent();
		System.out.println(tmp2.getChildren().size());
		root.setCenter(leagueView);
		root.setRight(scroll);
		root.setBottom(buttonsStore);
		root.setStyle("-fx-background-color:POWDERBLUE;");
		Scene tmp = new Scene(root, x, y);
		return tmp;
	}

	public VBox getFriends() {
		VBox friendBox = new VBox();
		//Liste mit Usern einholen
		List<User> friends = getFriendsNames();
		friends.toFirst();
		//F�r jeden Freund einen Button erzeugen
		while(friends.hasAccess()) {
			Button aktButton = new Button(friends.getContent().getUsername());
			aktButton.setMinWidth(x * 0.3);
			aktButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					Button src = (Button) event.getSource();
					System.out.println(src.getText());
				}
			});
			//Pr�fen, ob freund online ist
			if(friends.getContent().isOnline()) {
				aktButton.setStyle(cssFriendGreen);
			}else {
				aktButton.setStyle(cssFriendRed);
			}
			friendBox.getChildren().add(aktButton);
			friends.next();
		}
		return friendBox;
	}
	
	/**
	 * Freunde aus der Datenbank hinzuholen.
	 * Die Freunde die online sind zuerst hinzuf�gen.
	 * 
	 * @return
	 */
	public List<User> getFriendsNames(){
		List<User> result = new List<User>();
		result.append(new User("ficker02", true));
		result.append(new User("dude", true));
		result.append(new User("jop", true));
		result.append(new User("name1", true));
		result.append(new User("stopper02", true));
		result.append(new User("git02", true));
		result.append(new User("destructor", false));
		result.append(new User("killer", false));
		result.append(new User("name12", false));
		result.append(new User("name123", false));
		for(int i = 0; i < 10; i++) {
			result.append(new User(new Integer(i).toString(), false));
		}
		return result;
	}
	
	public VBox createLeagueView() {
		//Erstellt die VBox in der die Liga-Tabelle gezeigt wird
		VBox table = new VBox();
		//Die Ligadaten laden (eigl. vom Server)
		List<String> data = getLeagueData();
		data.toFirst();
		int index = 1;
		while(data.hasAccess()) {
			String[] inf = data.getContent().split(":");
			//Die Datenspeichern
			HBox row = new HBox();
			row.setMinHeight(y * 0.05);
			//Platz anzeigen
			Label place = new Label(new Integer(index).toString()+".");
			place.setMinWidth(x * 0.1);
			place.setFont(new Font("Cambria", 20));
			place.setStyle("-fx-background-color:POWDERBLUE");
			Button btn = new Button(inf[0]);
			btn.setMinWidth(x * 0.5);
			if(index < 10) {
				btn.setStyle(cssFriendGreen);
			}else {
				btn.setStyle(cssFriendRed);
			}
			Label points = new Label(inf[1]);
			points.setMinWidth(x * 0.1);
			points.setFont(new Font("Cambria", 20));
			points.setStyle("-fx-background-color:POWDERBLUE");
			points.setAlignment(Pos.CENTER);
			row.getChildren().addAll(place, btn, points);
			table.getChildren().add(row);
			index++;
			data.next();
		}
		System.out.println(table.getChildren().size());
		//Die Tabelle hinzeigen
		return table;
	}
	
	public List<String> getLeagueData(){
		List<String> result = new List<String>();
		for(int i = 0; i < 30; i++) {
			result.append("asdf:1");
		}
		return result;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
		
}
