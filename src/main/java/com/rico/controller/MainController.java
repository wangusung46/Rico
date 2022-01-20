/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.rico.controller;

import com.rico.dao.MemberDao;
import com.rico.dao.TransactionDao;
import com.rico.model.FeMember;
import com.rico.model.FePoint;
import com.rico.model.FeTransaction;
import com.rico.util.HibernateUtil;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Rico
 */
public class MainController implements Initializable {

    @FXML
    private Button btnSave;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnUpdate;
    @FXML
    private Label totalMember;
    @FXML
    private Label selectedTransaction;
    @FXML
    private Label SelectedMember;
    @FXML
    private TextField citizenId;
    @FXML
    private TextField name;
    @FXML
    private TextArea address;
    @FXML
    private TextField phone;
    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private DatePicker brithDate;
    @FXML
    private TableView<FeMember> tableMember;
    @FXML
    private TableColumn<FeMember, String> mId;
    @FXML
    private TableColumn<FeMember, String> mName;
    @FXML
    private TableColumn<FeMember, String> mPhone;
    @FXML
    private TableColumn<FeMember, Timestamp> mBrithDate;

    private MemberDao memberDao;
    @FXML
    private TableView<FeTransaction> transaction;
    @FXML
    private TableColumn<FeTransaction, Timestamp> tTransactionDate;
    @FXML
    private TableColumn<FeTransaction, String> tNominal;
    @FXML
    private TableView<FePoint> TablePoint;
    @FXML
    private TableColumn<FePoint, String> pId;
    @FXML
    private TableColumn<FePoint, String> pPoint;

    public MainController() {
        memberDao = HibernateUtil.getMemberDao();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTableMember();
        loadTableTransaction();
    }

    @FXML
    private void saveMemberAction(ActionEvent event) {
        memberDao = HibernateUtil.getMemberDao();
        FeMember feMember = new FeMember(citizenId.getText(), name.getText(), address.getText(), phone.getText(), email.getText(), username.getText());
        memberDao.insert(feMember);
        loadTableMember();

    }

    @FXML
    private void resetAction(ActionEvent event) {
    }

    @FXML
    private void updateAction(ActionEvent event) {
    }

    @FXML
    private void saveTransAction(ActionEvent event) {
    }

    private void loadTableMember() {
        mId.setCellValueFactory(new PropertyValueFactory<FeMember, String>("citizenID"));
        mName.setCellValueFactory(new PropertyValueFactory<FeMember, String>("name"));
        mPhone.setCellValueFactory(new PropertyValueFactory<FeMember, String>("phone"));
        mBrithDate.setCellValueFactory(new PropertyValueFactory<FeMember, Timestamp>("brithdate"));
        MemberDao memberDao = HibernateUtil.getMemberDao();
        List<FeMember> members = memberDao.getAllMember();
        ObservableList<FeMember> observableList = FXCollections.observableArrayList();
        Integer count = 0;
        for (FeMember member : members) {
            count++;
            observableList.add(member);
            TableViewLoadMember(observableList);
        }
        totalMember.setText(count.toString());
    }

    private void TableViewLoadMember(ObservableList<FeMember> observableList) {
        tableMember.setItems(observableList);
    }

    private void loadTableTransaction() {
        tTransactionDate.setCellValueFactory(new PropertyValueFactory<FeTransaction, Timestamp>("transactiondate"));
        tNominal.setCellValueFactory(new PropertyValueFactory<FeTransaction, String>("nominal"));
        TransactionDao transactionDao = HibernateUtil.getTransactionDao();
        List<FeTransaction> transactions = transactionDao.getAllTransaction();
        ObservableList<FeTransaction> observableList = FXCollections.observableArrayList();
        for (FeTransaction transaction : transactions) {
            observableList.add(transaction);
            TableViewLoadTransaction(observableList);
        }
    }
    
    private void TableViewLoadTransaction(ObservableList<FeTransaction> observableList) {
        transaction.setItems(observableList);
    }

}
