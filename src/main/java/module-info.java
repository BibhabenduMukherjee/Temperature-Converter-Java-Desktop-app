module com.example.firstappjavafx {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.example.firstappjavafx to javafx.fxml;
	exports com.example.firstappjavafx;
}