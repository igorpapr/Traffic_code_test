package utils;

import javafx.scene.control.Alert;

public class AlertCreator {

    public static void showEmptySelectedAnswerAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Спробуйте знову");
        alert.setHeaderText("Пуста правильна відповідь");
        alert.setContentText("Ви обрали правильною відповідь, яка є пустою.\nСпробуйте знову.");
        alert.showAndWait();
    }

    public static void showNoSelectedAnswerAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Спробуйте знову");
        alert.setHeaderText("Немає правильної відповіді");
        alert.setContentText("Ви не обрали правильної відповіді.\nСпробуйте знову.");
        alert.showAndWait();
    }

    public static void showEmptyQuestionDescriptionAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Спробуйте знову");
        alert.setHeaderText("Немає опису запитання");
        alert.setContentText("Ви не заповнили опис запитання.\nСпробуйте знову.");
        alert.showAndWait();
    }

    public static void showOkDialog(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
