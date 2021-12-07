module exone.maman13_ex1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens exone.maman13_ex1 to javafx.fxml;
    exports exone.maman13_ex1;
    exports exone.maman13_ex1.business_logic;
    opens exone.maman13_ex1.business_logic to javafx.fxml;
}