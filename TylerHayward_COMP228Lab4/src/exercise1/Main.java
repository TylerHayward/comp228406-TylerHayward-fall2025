package exercise1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stg){

        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        TextField t4 = new TextField();
        TextField t5 = new TextField();
        TextField t6 = new TextField();
        TextField t7 = new TextField();

        RadioButton r1 = new RadioButton("Computer Science");
        RadioButton r2 = new RadioButton("Business");
        ToggleGroup tg = new ToggleGroup();
        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);

        ComboBox<String> cb = new ComboBox<>();
        ListView<String> lv = new ListView<>();

        CheckBox c1 = new CheckBox("Student Council");
        CheckBox c2 = new CheckBox("Volunteer Work");

        TextArea ta = new TextArea();
        ta.setPrefHeight(120);

        Button btn = new Button("Display");

        GridPane g = new GridPane();
        g.setPadding(new Insets(10));
        g.setHgap(8);
        g.setVgap(8);

        g.add(new Label("Name:"),0,0);
        g.add(t1,1,0);

        g.add(new Label("Address:"),0,1);
        g.add(t2,1,1);

        g.add(new Label("Province:"),0,2);
        g.add(t3,1,2);

        g.add(new Label("City:"),0,3);
        g.add(t4,1,3);

        g.add(new Label("Postal Code:"),0,4);
        g.add(t5,1,4);

        g.add(new Label("Phone:"),0,5);
        g.add(t6,1,5);

        g.add(new Label("Email:"),0,6);
        g.add(t7,1,6);

        g.add(new Label("Major:"),0,7);
        HBox majors = new HBox(10, r1, r2);
        g.add(majors,1,7);

        g.add(new Label("Courses:"),0,8);
        g.add(cb,1,8);
        g.add(lv,1,9);

        g.add(new Label("Activities:"),0,10);
        VBox acts = new VBox(5,c1,c2);
        g.add(acts,1,10);

        g.add(btn,1,11);
        g.add(ta,0,12,2,1);

        tg.selectedToggleProperty().addListener((o,x,y)->{
            cb.getItems().clear();
            lv.getItems().clear();
            if(r1.isSelected()){
                cb.getItems().addAll("Java","C#","Python");
            } else {
                cb.getItems().addAll("Business Math","Accounting","Marketing");
            }
        });

        cb.setOnAction(e->{
            String c = cb.getValue();
            if(c!=null && !lv.getItems().contains(c)){
                lv.getItems().add(c);
            }
        });

        btn.setOnAction(e->{
            StringBuilder sb = new StringBuilder();
            sb.append("Name: ").append(t1.getText())
                    .append("\nAddress: ").append(t2.getText())
                    .append("\nProvince: ").append(t3.getText())
                    .append("\nCity: ").append(t4.getText())
                    .append("\nPostal: ").append(t5.getText())
                    .append("\nPhone: ").append(t6.getText())
                    .append("\nEmail: ").append(t7.getText());

            if(r1.isSelected()) sb.append("\nMajor: Computer Science");
            if(r2.isSelected()) sb.append("\nMajor: Business");

            sb.append("\nCourses: ").append(lv.getItems());
            sb.append("\nActivities: ");

            if(c1.isSelected()) sb.append("Student Council ");
            if(c2.isSelected()) sb.append("Volunteer Work ");

            ta.setText(sb.toString());
        });

        Scene sc = new Scene(g, 650, 600);
        stg.setScene(sc);
        stg.setTitle("Student Info");
        stg.show();
    }

    public static void main(String[] args){
        launch();
    }
}
