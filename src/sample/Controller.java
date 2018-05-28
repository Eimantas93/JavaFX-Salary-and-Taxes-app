package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField SalaryBrutoTextField;
    @FXML
    private TextField NumberOfKidsTextField;
    @FXML
    private Label VSDLabel;
    @FXML
    private Label PSDLabel;
    @FXML
    private Label NPDLabel;
    @FXML
    private Label PNPDLabel;
    @FXML
    private Label GPMLabel;
    @FXML
    private Label WorkPlaceCostsLabel;

    /**
     * On first tab action button clicked action.
     *
     * @param event action event.
     */
    public void onTabOneActionButtonClicked(ActionEvent event) {
        // Checking is it fields empty
        double salaryBruto;
        try {
            salaryBruto = Double.parseDouble(SalaryBrutoTextField.getText());
        } catch (NumberFormatException e) {
            salaryBruto = 0;
        }

        double numberOfKids;
        try {
            numberOfKids = Double.parseDouble(NumberOfKidsTextField.getText());
        } catch (NumberFormatException e) {
            numberOfKids = 0;
        }

        Taxes taxes = new Taxes(salaryBruto, numberOfKids);

        // Checking is it true information
        if (numberOfKids > 8) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("May be filled wrong information");
            alert.setContentText("Are You sure You have " + numberOfKids + " kids?");
            alert.showAndWait();
        }

        // Setting TAB ONE Labels
        VSDLabel.setText("VSD tax = " + Math.round(taxes.getVSD() * 100.0) / 100.0);
        PSDLabel.setText("PSD tax = " + Math.round(taxes.getPSD() * 100.0) / 100.0);
        NPDLabel.setText("NPD size = " + Math.round(taxes.getNPD() * 100.0) / 100.0);
        PNPDLabel.setText("PNPD size = " + Math.round(taxes.getPNPD() * 100.0) / 100.0);
        GPMLabel.setText("GPM tax = " + Math.round(taxes.getGPM() * 100.0) / 100.0);
        WorkPlaceCostsLabel.setText("Work place costs = " + String.valueOf(Math.round(taxes.getWorkPlaceCost() * 100.0) / 100.0));
    }

    @FXML
    private TextField SalaryNetoTextField;
    @FXML
    private TextField NPDAndPNPDTextField;
    @FXML
    private Label SalaryBrutoLabel;
    @FXML
    private Label SalaryPSDLabel;
    @FXML
    private Label SalaryVSDLabel;
    @FXML
    private Label SalaryGPMLabel;


    /**
     * On second tab action button clicked action.
     *
     * @param event action event.
     */
    public void onTabTwoActionButtonClicked(ActionEvent event) {
        // Checking is it fields empty
        double salaryNeto;
        try {
            salaryNeto = Double.parseDouble(SalaryNetoTextField.getText());
        } catch (NumberFormatException e) {
            salaryNeto = 0;
        }

        double NPDAndPNPD;
        try {
            NPDAndPNPD = Double.parseDouble(NPDAndPNPDTextField.getText());
        } catch (NumberFormatException e) {
            NPDAndPNPD = 0;
        }

        double salaryBruto = Converter.brutoToNeto(salaryNeto, NPDAndPNPD);

        Taxes taxes = new Taxes(salaryBruto);

        // Setting TAB Two Labels
        SalaryBrutoLabel.setText("Bruto salary = " + Math.round(salaryBruto * 100.0) / 100.0);
        SalaryPSDLabel.setText("PSD taxes = " + Math.round(taxes.getPSD() * 100.0) / 100.0);
        SalaryVSDLabel.setText("VSD taxes = " + Math.round(taxes.getVSD() * 100.0) / 100.0);
        SalaryGPMLabel.setText("GPM taxes = " + Math.round(taxes.getGPM() * 100.0) / 100.0);
    }
}
