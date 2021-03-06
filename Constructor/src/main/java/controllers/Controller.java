package controllers;

import dao.Connector;
import dao.DataBaseDao;
import entity.Compliance;
import entity.MultipleChoice;
import entity.SingleChoice;
import exceptions.EmptyQuestionDescriptionException;
import exceptions.EmptySelectedAnswerException;
import exceptions.NoSelectedAnswerException;
import exceptions.OneSideComplianceException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import utils.AlertCreator;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller {
    final static DataBaseDao dataBaseDao = new DataBaseDao(new Connector());

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="compliance_answer_1_1"
    private TextField compliance_answer_1_1;
    @FXML // fx:id="compliance_answer_1_2"
    private TextField compliance_answer_1_2;
    @FXML // fx:id="compliance_answer_2_1"
    private TextField compliance_answer_2_1;
    @FXML // fx:id="compliance_answer_2_2"
    private TextField compliance_answer_2_2;
    @FXML // fx:id="compliance_answer_3_1"
    private TextField compliance_answer_3_1;
    @FXML // fx:id="compliance_answer_3_2"
    private TextField compliance_answer_3_2;
    @FXML // fx:id="compliance_answer_4_1"
    private TextField compliance_answer_4_1;
    @FXML // fx:id="compliance_answer_4_2"
    private TextField compliance_answer_4_2;
    @FXML // fx:id="compliance_button"
    private Button compliance_button;

    @FXML // fx:id="description"
    private TextArea description;

    @FXML // fx:id="multiple_answer_1"
    private TextField multiple_answer_1;
    @FXML // fx:id="multiple_answer_2"
    private TextField multiple_answer_2;
    @FXML // fx:id="multiple_answer_3"
    private TextField multiple_answer_3;
    @FXML // fx:id="multiple_answer_4"
    private TextField multiple_answer_4;
    @FXML // fx:id="multiple_button"
    private Button multiple_button;
    @FXML // fx:id="multiple_checkbox_1"
    private CheckBox multiple_checkbox_1;
    @FXML // fx:id="multiple_checkbox_2"
    private CheckBox multiple_checkbox_2;
    @FXML // fx:id="multiple_checkbox_3"
    private CheckBox multiple_checkbox_3;
    @FXML // fx:id="multiple_checkbox_4"
    private CheckBox multiple_checkbox_4;

    @FXML // fx:id="single_answer_1"
    private TextField single_answer_1;
    @FXML // fx:id="single_answer_2"
    private TextField single_answer_2;
    @FXML // fx:id="single_answer_3"
    private TextField single_answer_3;
    @FXML // fx:id="single_answer_4"
    private TextField single_answer_4;
    @FXML // fx:id="single_button"
    private Button single_button;
    @FXML // fx:id="single_group"
    private ToggleGroup single_group;
    @FXML // fx:id="single_radio_1"
    private RadioButton single_radio_1;
    @FXML // fx:id="single_radio_2"
    private RadioButton single_radio_2;
    @FXML // fx:id="single_radio_3"
    private RadioButton single_radio_3;
    @FXML // fx:id="single_radio_4"
    private RadioButton single_radio_4;

    //gets correct answer
    private byte getSingleRightAnswer() throws NoSelectedAnswerException {
        Object res = single_group.getSelectedToggle();
        if (res == null)
            throw new NoSelectedAnswerException();
        return (byte) single_group.getSelectedToggle().getUserData();
    }


    //collects correct answers
    private byte[] getMultipleRightAnswers() throws NoSelectedAnswerException {
        boolean[] tmp = new boolean[4];
        if (multiple_checkbox_1.isSelected()) {
            tmp[0] = true;
        }
        if (multiple_checkbox_2.isSelected()) {
            tmp[1] = true;
        }
        if (multiple_checkbox_3.isSelected()) {
            tmp[2] = true;
        }
        if (multiple_checkbox_4.isSelected()) {
            tmp[3] = true;
        }
        int size = 0, i;
        for (i = 0; i < 4; i++) {
            if (tmp[i])
                size++;
        }
        byte[] res = new byte[size];

        if (size == 0)
            throw new NoSelectedAnswerException();

        i = 0;
        for (int j = 0; i < 4; i++) {
            if (tmp[i]) {
                res[j] = (byte) (i + 1);
                j++;
            }
        }

        return res;
    }


    //gets all the data from fields and transforms it to the object
    private SingleChoice createSingleChoice() throws EmptySelectedAnswerException,
            NoSelectedAnswerException, EmptyQuestionDescriptionException {
        String descr;
        String[] answers;
        byte rightAnswer = 0;
        descr = description.getText().trim();
        if (descr.equals(""))
            throw new EmptyQuestionDescriptionException();
        answers = new String[4];
        answers[0] = single_answer_1.getText().trim();
        answers[1] = single_answer_2.getText().trim();
        answers[2] = single_answer_3.getText().trim();
        answers[3] = single_answer_4.getText().trim();
        rightAnswer = getSingleRightAnswer();
        int selected = (int) rightAnswer;
        System.out.println(selected);
        for (int i = 0; i < 4; i++) {
            if (answers[i].equals("") && selected == (i + 1)) {
                throw new EmptySelectedAnswerException();
            }
        }

        int size = 0;
        for (int i = 0; i < 4; i++) {
            if (!answers[i].equals("")) {
                size++;
            }
        }
        String[] res_answers = new String[size];

        for (int i = 0, j = 0; i < 4; i++) {
            if (!answers[i].equals("")) {
                res_answers[j] = answers[i];
                j++;
            }
        }
        return new SingleChoice(descr, res_answers, rightAnswer);
    }

    //gets all the data from fields and transforms it to the object
    private Compliance createCompliance() throws EmptyQuestionDescriptionException, OneSideComplianceException {
        String descr;
        String[] leftAnswers;
        String[] rightAnswers;

        descr = description.getText().trim();
        if (descr.equals(""))
            throw new EmptyQuestionDescriptionException();

        leftAnswers = new String[4];
        leftAnswers[0] = compliance_answer_1_1.getText().trim();
        leftAnswers[1] = compliance_answer_2_1.getText().trim();
        leftAnswers[2] = compliance_answer_3_1.getText().trim();
        leftAnswers[3] = compliance_answer_4_1.getText().trim();

        rightAnswers = new String[4];
        rightAnswers[0] = compliance_answer_1_2.getText().trim();
        rightAnswers[1] = compliance_answer_2_2.getText().trim();
        rightAnswers[2] = compliance_answer_3_2.getText().trim();
        rightAnswers[3] = compliance_answer_4_2.getText().trim();

        //check for onesidecompliance exception
        for (int i = 0; i < 4; i++) {
            if ((leftAnswers[i].equals("") && !rightAnswers[i].equals("")) || (!leftAnswers[i]
                    .equals("") && rightAnswers[i].equals(""))) {
                throw new OneSideComplianceException();
            }
        }
        //check for all fields emptiness
        boolean empty = true;
        for (int i = 0; i < 4; i++) {
            if (!leftAnswers[i].equals("") && !rightAnswers[i].equals("")) {
                empty = false;
            }
        }
        if (empty)
            throw new OneSideComplianceException();

        int size = 0;
        for (int i = 0; i < 4; i++) {
            if (!leftAnswers[i].equals("")) {
                size++;
            }
        }
        String[] res_left_answers = new String[size];

        for (int i = 0, j = 0; i < 4; i++) {
            if (!leftAnswers[i].equals("")) {
                res_left_answers[j] = leftAnswers[i];
                j++;
            }
        }

        String[] res_right_answers = new String[size];
        for (int i = 0, j = 0; i < 4; i++) {
            if (!rightAnswers[i].equals("")) {
                res_right_answers[j] = rightAnswers[i];
                j++;
            }
        }

        return new Compliance(descr.trim(), res_left_answers, res_right_answers);
    }

    private MultipleChoice createMultipleChoice() throws EmptySelectedAnswerException,
            NoSelectedAnswerException, EmptyQuestionDescriptionException {
        String descr;
        String[] answers;
        byte[] rightAnswers;
        descr = description.getText().trim();
        if (descr.equals(""))
            throw new EmptyQuestionDescriptionException();

        answers = new String[4];
        answers[0] = multiple_answer_1.getText().trim();
        answers[1] = multiple_answer_2.getText().trim();
        answers[2] = multiple_answer_3.getText().trim();
        answers[3] = multiple_answer_4.getText().trim();
        rightAnswers = getMultipleRightAnswers();
        for (byte rightAnswer : rightAnswers) {
            if (answers[((int) rightAnswer) - 1].equals("")) {
                throw new EmptySelectedAnswerException();
            }
        }

        int size = 0;
        for (int i = 0; i < 4; i++) {
            if (!answers[i].equals("")) {
                size++;
            }
        }
        String[] res_answers = new String[size];

        for (int i = 0, j = 0; i < 4; i++) {
            if (!answers[i].equals("")) {
                res_answers[j] = answers[i];
                j++;
            }
        }

        return new MultipleChoice(descr.trim(), res_answers, rightAnswers);
    }

    //clear all fields of single choice tab
    public void clearSingleChoiceTab() {
        description.clear();
        single_answer_1.clear();
        single_answer_2.clear();
        single_answer_3.clear();
        single_answer_4.clear();
        single_group.getSelectedToggle().setSelected(false);
    }

    //clear all fields of Multiple choice tab
    public void clearMultipleChoiceTab() {
        description.clear();
        multiple_answer_1.clear();
        multiple_answer_2.clear();
        multiple_answer_3.clear();
        multiple_answer_4.clear();
        multiple_checkbox_1.setSelected(false);
        multiple_checkbox_2.setSelected(false);
        multiple_checkbox_3.setSelected(false);
        multiple_checkbox_4.setSelected(false);

    }

    //clear all fields of comliance tab
    public void clearComplianceTab() {
        description.clear();
        compliance_answer_1_1.clear();
        compliance_answer_1_2.clear();
        compliance_answer_2_1.clear();
        compliance_answer_2_2.clear();
        compliance_answer_3_1.clear();
        compliance_answer_3_2.clear();
        compliance_answer_4_1.clear();
        compliance_answer_4_2.clear();
    }

    // Handler for Button[fx:id="single_button"] onAction
    @FXML
    void onSingleButtonClick(ActionEvent event) {
        SingleChoice sa = null;
        try {
            sa = createSingleChoice();

            //logging
            System.out.println(sa);

            //dao
            dataBaseDao.insertSingle(sa.getDescription(), sa.getAnswers(), sa.getRightAnswer());

            clearSingleChoiceTab();
            AlertCreator.showOkDialog("OK", "Операція пройшла успішно", "");

        } catch (EmptySelectedAnswerException e) {
            AlertCreator.showEmptySelectedAnswerAlert();
        } catch (NoSelectedAnswerException e1) {
            AlertCreator.showNoSelectedAnswerAlert();
        } catch (EmptyQuestionDescriptionException e2) {
            AlertCreator.showEmptyQuestionDescriptionAlert();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    // Handler for Button[fx:id="multiple_button"] onAction
    @FXML
    void onMultipleButtonClick(ActionEvent event) {
        MultipleChoice mch = null;
        try {
            mch = createMultipleChoice();

            //logging
            System.out.println(mch);

            //dao
            dataBaseDao.insertMultiple(mch.getDescription(), mch.getAnswers(), mch.getRightAnswers());

            clearMultipleChoiceTab();
            AlertCreator.showOkDialog("OK", "Операція пройшла успішно", "");

        } catch (EmptySelectedAnswerException e) {
            AlertCreator.showEmptySelectedAnswerAlert();
        } catch (NoSelectedAnswerException e1) {
            AlertCreator.showNoSelectedAnswerAlert();
        } catch (EmptyQuestionDescriptionException e2) {
            AlertCreator.showEmptyQuestionDescriptionAlert();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    // Handler for Button[fx:id="compliance_button"] onAction
    @FXML
    void onComplianceButtonClick(ActionEvent event) {
        Compliance c = null;
        try {
            c = createCompliance();

            //just logging
            System.out.println(c);

            //dao
            dataBaseDao.insertCompliance(c.getDescription(), c.getAnswers(), c.getRightAnswers());

            clearComplianceTab();
            AlertCreator.showOkDialog("OK", "Операція пройшла успішно", "");

        } catch (EmptyQuestionDescriptionException e2) {
            AlertCreator.showEmptyQuestionDescriptionAlert();
        } catch (OneSideComplianceException e3) {
            AlertCreator.showOneSideComplianceAlert();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }


    @FXML
// This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert compliance_answer_1_1 != null : "fx:id=\"compliance_answer_1_1\" was not injected: check your FXML file 'main.fxml'.";
        assert compliance_answer_1_2 != null : "fx:id=\"compliance_answer_1_2\" was not injected: check your FXML file 'main.fxml'.";
        assert compliance_answer_2_1 != null : "fx:id=\"compliance_answer_2_1\" was not injected: check your FXML file 'main.fxml'.";
        assert compliance_answer_2_2 != null : "fx:id=\"compliance_answer_2_2\" was not injected: check your FXML file 'main.fxml'.";
        assert compliance_answer_3_1 != null : "fx:id=\"compliance_answer_3_1\" was not injected: check your FXML file 'main.fxml'.";
        assert compliance_answer_3_2 != null : "fx:id=\"compliance_answer_3_2\" was not injected: check your FXML file 'main.fxml'.";
        assert compliance_answer_4_1 != null : "fx:id=\"compliance_answer_4_1\" was not injected: check your FXML file 'main.fxml'.";
        assert compliance_answer_4_2 != null : "fx:id=\"compliance_answer_4_2\" was not injected: check your FXML file 'main.fxml'.";
        assert compliance_button != null : "fx:id=\"compliance_button\" was not injected: check your FXML file 'main.fxml'.";
        assert description != null : "fx:id=\"description\" was not injected: check your FXML file 'main.fxml'.";
        assert multiple_answer_1 != null : "fx:id=\"multiple_answer_1\" was not injected: check your FXML file 'main.fxml'.";
        assert multiple_answer_2 != null : "fx:id=\"multiple_answer_2\" was not injected: check your FXML file 'main.fxml'.";
        assert multiple_answer_3 != null : "fx:id=\"multiple_answer_3\" was not injected: check your FXML file 'main.fxml'.";
        assert multiple_answer_4 != null : "fx:id=\"multiple_answer_4\" was not injected: check your FXML file 'main.fxml'.";
        assert multiple_button != null : "fx:id=\"multiple_button\" was not injected: check your FXML file 'main.fxml'.";
        assert multiple_checkbox_1 != null : "fx:id=\"multiple_checkbox_1\" was not injected: check your FXML file 'main.fxml'.";
        assert multiple_checkbox_2 != null : "fx:id=\"multiple_checkbox_2\" was not injected: check your FXML file 'main.fxml'.";
        assert multiple_checkbox_3 != null : "fx:id=\"multiple_checkbox_3\" was not injected: check your FXML file 'main.fxml'.";
        assert multiple_checkbox_4 != null : "fx:id=\"multiple_checkbox_4\" was not injected: check your FXML file 'main.fxml'.";
        assert single_answer_1 != null : "fx:id=\"single_answer_1\" was not injected: check your FXML file 'main.fxml'.";
        assert single_answer_2 != null : "fx:id=\"single_answer_2\" was not injected: check your FXML file 'main.fxml'.";
        assert single_answer_3 != null : "fx:id=\"single_answer_3\" was not injected: check your FXML file 'main.fxml'.";
        assert single_answer_4 != null : "fx:id=\"single_answer_4\" was not injected: check your FXML file 'main.fxml'.";
        assert single_button != null : "fx:id=\"single_button\" was not injected: check your FXML file 'main.fxml'.";
        assert single_group != null : "fx:id=\"single_group\" was not injected: check your FXML file 'main.fxml'.";
        assert single_radio_1 != null : "fx:id=\"single_radio_1\" was not injected: check your FXML file 'main.fxml'.";
        assert single_radio_2 != null : "fx:id=\"single_radio_2\" was not injected: check your FXML file 'main.fxml'.";
        assert single_radio_3 != null : "fx:id=\"single_radio_3\" was not injected: check your FXML file 'main.fxml'.";
        assert single_radio_4 != null : "fx:id=\"single_radio_4\" was not injected: check your FXML file 'main.fxml'.";

        // all @FXML variables will have been injected
        single_radio_1.setUserData((byte) 1);
        single_radio_2.setUserData((byte) 2);
        single_radio_3.setUserData((byte) 3);
        single_radio_4.setUserData((byte) 4);

        multiple_checkbox_1.setUserData((byte) 1);
        multiple_checkbox_2.setUserData((byte) 2);
        multiple_checkbox_3.setUserData((byte) 3);
        multiple_checkbox_4.setUserData((byte) 4);
    }
}
