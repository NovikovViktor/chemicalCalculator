package ru.novikov.java;

import javafx.scene.control.Alert;

public class Tools {

    public void alertEmptyCell(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Одна из ячеек не заполнена!");
        alert.setContentText("Каждая из ячеек, даже если не используется, должна быть заполнена нулем.");
        alert.showAndWait();
        return;
    }
    public void alertClearList(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Сброс");
        alert.setHeaderText("Данные по сухим веществам очищены");
        alert.showAndWait();
        return;
    }
}
