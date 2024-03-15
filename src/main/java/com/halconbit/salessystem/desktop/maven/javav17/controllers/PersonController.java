package com.halconbit.salessystem.desktop.maven.javav17.controllers;

import com.halconbit.salessystem.desktop.maven.javav17.dao.PersonDAO;
import com.halconbit.salessystem.desktop.maven.javav17.entities.Person;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PersonController {

    private PersonDAO personDAO;
    private Person person;
    private DefaultTableModel defaultTableModel;

    public PersonController() {
        this.personDAO = new PersonDAO();
        this.person = new Person();
    }

    public DefaultTableModel list() {
        String[] titles = {"Rfrnc", "Rfrnc_Prsn", "Rfrnc_TypPrsn", "Cndtn", "Rmvd", "Lckd", "DtAdmss", "ChckTm"};
        this.defaultTableModel = new DefaultTableModel(null, titles);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String[] records = new String[titles.length];
        List<Person> list = this.personDAO.list();
        for (Person item : list) {
            records[0] = Integer.toString(item.getRfrnc());
            records[1] = Integer.toString(item.getRfrnc_Prsn());
            records[2] = Integer.toString(item.getRfrnc_TypPrsn());
            records[8] = Integer.toString(item.getCndtn());
            records[9] = Integer.toString(item.getRmvd());
            records[10] = Integer.toString(item.getLckd());
            records[11] = dateFormat.format(item.getDtAdmssn());
            records[12] = item.getChckTm().toString();
            this.defaultTableModel.addRow(records);
        }
        return this.defaultTableModel;
    }

    public String create(Integer Rfrnc, Integer Rfrnc_Prsn, Integer Rfrnc_TypPrsn, Integer Cndtn, Integer Rmvd, Integer Lckd, Date DtAdmss, Time ChckTm) {

        this.person.setRfrnc(Rfrnc);
        this.person.setRfrnc_Prsn(Rfrnc_Prsn);
        this.person.setRfrnc_TypPrsn(Rfrnc_TypPrsn);
        this.person.setCndtn(Cndtn);
        this.person.setRmvd(Rmvd);
        this.person.setLckd(Lckd);
        this.person.setDtAdmssn(DtAdmss);
        this.person.setChckTm(ChckTm);

        if (this.personDAO.insert(this.person)) {
            return "OK";
        } else {
            return "ERROR to register.";
        }

    }

    public String update(Integer Rfrnc, Integer Rfrnc_Prsn, Integer Rfrnc_TypPrsn, Integer Cndtn, Integer Rmvd, Integer Lckd, Date DtAdmss, Time ChckTm) {

        this.person.setRfrnc(Rfrnc);
        this.person.setRfrnc_Prsn(Rfrnc_Prsn);
        this.person.setRfrnc_TypPrsn(Rfrnc_TypPrsn);
        this.person.setCndtn(Cndtn);
        this.person.setRmvd(Rmvd);
        this.person.setLckd(Lckd);
        this.person.setDtAdmssn(DtAdmss);
        this.person.setChckTm(ChckTm);

        if (this.personDAO.insert(this.person)) {
            return "OK";
        } else {
            return "ERROR to register.";
        }
    }

}
