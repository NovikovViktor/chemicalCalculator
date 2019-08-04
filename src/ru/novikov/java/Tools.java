package ru.novikov.java;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.math.BigDecimal;

public class Tools {

    public void alertEmptyCell(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Одна из ячеек не заполнена!");
        alert.setContentText("Каждая из ячеек, даже если не используется, должна быть заполнена нулем.");
        alert.showAndWait();
        return;
    }
    public void alertSecret(){
        String str = "В некотором царстве Химическом государстве у царя Купрума и царицы Меди родилась дочка Купринка. Шли годы, царевна подрастала, родители не чаяли в ней души. Медно-рыжие локоны обрамляли её сияющее личико, звонкий смех сопровождал её повсюду.\n" +
                "\n" +
                "Купринка любила гулять в саду. Здесь она познакомилась с двумя царевичами: Водородом и Кислородом. Втроём они бегали по садовым дорожкам. Водород поднимал их высоко над землёй и они катались на облаках. Если Водород и Кислород приходили в сад, а Купринки ещё не было, они начинали кружиться вдвоём,шёл дождик, Купринка знала, что друзья её уже ждут.\n" +
                "\n" +
                "В жаркую погоду, когда земля изнывала от засухи, Водород с Кислородом поднимались в небо. Тёплый дождик лился на поля, луга, сады, огороды, а Купринка бегала под дождём и звонко смеялась.\n" +
                "\n" +
                "Однажды Водороду нужно было проведать своего дедушку Гидрогена и он улетел к нему. Теперь Купринка и Кислород игрались в саду только вдвоём. Кислород не мог поднять Купринку в небо. Купринка скучала. Лицо её почернело, волосы позеленели. Разлука с Водородом показалась ей очень длительной.\n" +
                "\n" +
                "Царь с царицей забеспокоились о здоровье дочки и послали гонцов к Водороду. Водород вернулся и сразу же прилетел к Купринке. Они встретились. От радости Купринка заплакала и о, чудо, лицо её просветлело, волосы опять стали медно-рыжими. Водород пообещал, что не будет больше надолго покидать друзей, и они опять стали играть втроём.";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Пасхалка");
        alert.setHeaderText("");
        alert.setContentText(str);
        alert.showAndWait();
    }

    public void alertClearList(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Сброс");
        alert.setHeaderText("Данные по сухим веществам очищены");
        alert.showAndWait();
        return;
    }

    public String formatReplaceTrim(TextField textField){
        return textField.getText().trim().replaceAll("[a-zA-Zа-яА-Я]*", "");
    }
    public BigDecimal parseStringToBigDecimal(String str){
        return BigDecimal.valueOf(Double.parseDouble(str.replaceAll(",",".")));
    }
}
