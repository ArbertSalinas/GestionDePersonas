import java.net.URL;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class ControlPersona {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea areaResults;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Label lblCodigo;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;
    
    //Definiendo la variable del modelo
    List<Persona> listaPersonas = new ArrayList<Persona>();

    @FXML
    void codigoIn(ActionEvent event) {
        txtCodigo.getText();
    }
    
    @FXML
    void nombreIn(ActionEvent event) {

    }
    
    @FXML
    void emailIn(ActionEvent event) {

    }

    @FXML
    void guardarDatos(ActionEvent event) {
        String codigo=txtCodigo.getText();
        String email=txtEmail.getText();
        String nombre=txtNombre.getText();
        if (codigo.isEmpty() || email.isEmpty() || nombre.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos vacíos");
            alert.setContentText("Por favor, complete todos los campos antes de guardar los datos.");
            alert.showAndWait();
            return;
        }

        boolean encontrado = false;
        for (Persona personaExistente : listaPersonas) {
        if (personaExistente.getCodigo().equals(codigo)) {
            encontrado = true;
            break;
        }
        }

        // Si el código está duplicado, mostrar mensaje de error y salir del método
        if (encontrado) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Código duplicado");
            alert.setContentText("El código ingresado ya existe en la lista.");
            alert.showAndWait();
            return;
        }
        Persona persona = new Persona(codigo, nombre, email);
        
        if(!(codigo.equals("")&&email.equals("")&&nombre.equals(""))&& !encontrado){
            this.listaPersonas.add(persona);}
        String sb = new String();
        if (listaPersonas.isEmpty()) {
            areaResults.setText("No hay estudiantes registrados.");
        } else {
            for (Persona personas : listaPersonas) {
                sb = String.format("Codigo: %s, Nombre: %s, Email: %s\n", 
                                                persona.getCodigo(), persona.getNombre(), 
                                                persona.getEmail());
                
            }
            areaResults.appendText(sb);
        }
    }

    @FXML
    void limpiarDatos(ActionEvent event) {
        txtCodigo.setText("");
        txtEmail.setText("");
        txtNombre.setText("");
        areaResults.setText("");
        listaPersonas.clear();
    }

    

    @FXML
    void initialize() {
        assert areaResults != null : "fx:id=\"areaResults\" was not injected: check your FXML file 'DatosPersonales.fxml'.";
        assert btnGuardar != null : "fx:id=\"btnGuardar\" was not injected: check your FXML file 'DatosPersonales.fxml'.";
        assert btnLimpiar != null : "fx:id=\"btnLimpiar\" was not injected: check your FXML file 'DatosPersonales.fxml'.";
        assert lblCodigo != null : "fx:id=\"lblCodigo\" was not injected: check your FXML file 'DatosPersonales.fxml'.";
        assert lblEmail != null : "fx:id=\"lblEmail\" was not injected: check your FXML file 'DatosPersonales.fxml'.";
        assert lblNombre != null : "fx:id=\"lblNombre\" was not injected: check your FXML file 'DatosPersonales.fxml'.";
        assert lblTitulo != null : "fx:id=\"lblTitulo\" was not injected: check your FXML file 'DatosPersonales.fxml'.";
        assert txtCodigo != null : "fx:id=\"txtCodigo\" was not injected: check your FXML file 'DatosPersonales.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'DatosPersonales.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'DatosPersonales.fxml'.";
        areaResults.setEditable(false);
        
        List<Persona> listaPersonas = new ArrayList<Persona>();
    }

}
