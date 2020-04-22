/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import citizenapp.Log;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javafx.util.Pair;

/**
 * @author admin
 */
public class UserData implements Serializable {
    private static final long serialVersionUID = 1L;


    Locale locale = new Locale("en", "TH");
    private DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", locale);

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    private String id;
    private String name;
    private String surname;
    private String gender;
    private String nationality;
    private String religion;
    private Date dateOfBirth;
    private String address;
    private String picturePath;
    private String groupLaed;
    Phone phone;
    ArrayList<Account> accountList;
    private ArrayList<adminLog> adminLogList;
    private ArrayList<Pair<String, String>> logy = new ArrayList<>();
    private Date dateExpire;
    private Date dateOfIssue;

    public void WriteData(String dataPath) {

        //System.out.println(this.toString());
        try {
		
            FileOutputStream fileOut = new FileOutputStream(dataPath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();
            System.out.println("File have been saved to " + dataPath);
            //System.out.println("The Object  was succesfully written to a file");

        } catch (IOException ex) {
            System.out.println("UserDataWriteDataFail");
            ex.printStackTrace();
        }
    }

    public UserData() {

    }

	public ArrayList<Pair<String, String>> getLogy() {
		return logy;
	}

	public void setLogy(ArrayList<Pair<String, String>> logy) {
		this.logy = logy;
	}



    public void sortAccountList() {
        divide(0, -1 + this.accountList.size());
    }

    public void divide(int s, int e) {
        if (s < e && e >= 1 + s) {
            divide(s, s + (e - s) / 2);
            divide(s + (e - s) / 2 + 1, e);
            conquer(s, s + (e - s) / 2, e);
        }
    }
    
    

    public void conquer(int s, int m, int e) {
        ArrayList<Account> t = new ArrayList<Account>();
        int l = s, r = 1 + m, j = s, i = 0;
        while (m >= l && r <= e)
            if (accountList.get(l).compareTo(accountList.get(r)) >= 0) t.add(accountList.get(l++));
            else t.add(accountList.get(r++));
        while (l <= m) t.add(accountList.get(l++));
        while (r <= e) t.add(accountList.get(r++));
        while (i < t.size()) accountList.set(j++, t.get(i++));
    }

    public UserData(String id, String name, String surname, String gender, String nationality, String religion, Date hbd, String phoneNumber, String address, Date dateExpire, Date dateOfIssue,String bloodgroup) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.nationality = nationality;
        this.religion = religion;
        this.dateOfBirth = hbd;
        this.address = address;
        this.phone = new Phone();
        this.phone.setPhoneNumber(phoneNumber);
        this.dateExpire = dateExpire;
        this.groupLaed = bloodgroup;
        this.dateOfIssue = dateOfIssue;
        accountList = new ArrayList<>();
        adminLogList = new ArrayList<>();
	logy = new ArrayList<>();
	
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfBirth() {
        return dateFormat.format(dateOfBirth);
    }

    public String getDateExpire() {
        return dateFormat.format(dateExpire);
    }

    public String getDateOfIssue() {
        return dateFormat.format(dateOfIssue);
    }


    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Phone getPhone() {
        return phone;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public ArrayList<adminLog> getAdminLogList() {
        return adminLogList;
    }

    public void setAdminLogList(ArrayList<adminLog> logList) {
        this.adminLogList = logList;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public ArrayList<Account> getAccountList() {
        return this.accountList;
    }



    public String getGroupLaed() {
        return groupLaed;
    }

    public void setGroupLaed(String groupLaed) {
        this.groupLaed = groupLaed;
    }
}
