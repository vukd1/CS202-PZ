module com.example.cs202pz {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires mysql.connector.j;
    requires password4j;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires org.hibernate.commons.annotations;
    requires hibernate.entitymanager;

    exports com.example.cs202pz.main;
    opens com.example.cs202pz.main to javafx.fxml;
}