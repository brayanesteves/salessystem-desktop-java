package com.halconbit.salessystem.desktop.maven.javav17.dao;

import com.halconbit.salessystem.desktop.maven.javav17.access.Access;
import com.halconbit.salessystem.desktop.maven.javav17.dao.interfaces.Methods;
import com.halconbit.salessystem.desktop.maven.javav17.dao.interfaces.MethodsDAO;
import com.halconbit.salessystem.desktop.maven.javav17.entities.Person;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PersonDAO implements MethodsDAO<Person> {
    
    private final List<Person> list;
    private Methods<Person> methods;
    private final String root = "0_Prsn.txt";
    private boolean response;
    private Person person;
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    
    public PersonDAO() {
        this.list    = new ArrayList<>();
        this.methods = new Methods<>(this.list);
        this.loadList();
    }
    
    private void loadList() {
        Person person;
        try {
            for(String data : Access.loadFile(this.root)) {
                StringTokenizer stringTokenizer = new StringTokenizer(data, ",");
                Date date = this.dateFormat.parse(stringTokenizer.nextToken());
                Time time = new Time(this.timeFormat.parse(stringTokenizer.nextToken()).getTime());            
                person = new Person(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), date, time);
                this.methods.add(person);
            }
        } catch (ParseException ex) {
            Logger.getLogger(NaturalPersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List list() {
        List<Person> records = new ArrayList<>();
        try {
            for(String data : Access.loadFile(this.root)) {
                StringTokenizer stringTokenizer = new StringTokenizer(data, ",");
                Date date = this.dateFormat.parse(stringTokenizer.nextToken());
                Time time = new Time(this.timeFormat.parse(stringTokenizer.nextToken()).getTime());            
                this.person = new Person(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), date, time);
                records.add(person);
            }
        } catch(Exception e) {
            Logger.getLogger(NaturalPersonDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error while listing person: " + e.getMessage());
        }
        
        return records;
    }

    @Override
    public boolean insert(Person person) {
        this.response = false;
        PrintWriter printWriter;
        FileWriter fileWriter;
        try {
            fileWriter    = new FileWriter("Documents/Files/Texts/" + this.root);
            printWriter   = new PrintWriter(fileWriter);
            person = new Person(person.getRfrnc(), person.getRfrnc_Prsn(), person.getRfrnc_TypPrsn(), person.getCndtn(), person.getRmvd(), person.getLckd(), person.getDtAdmssn(), person.getChckTm());
            this.methods.add(person);
            for(int i = 0; i< this.methods.count(); i++) {
                person = this.methods.getData(i);
                printWriter.println(String.valueOf(person.getRfrnc() + "," + person.getRfrnc_Prsn() + "," + person.getRfrnc_TypPrsn() + "," + person.getCndtn() + "," + person.getRmvd() + "," + person.getLckd() + "," + person.getDtAdmssn() + "," + person.getChckTm()));
            }
            printWriter.close();
            this.response = true;
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Error to insert: " + e.getMessage());
        }
        return this.response;
    }

    @Override
    public boolean update(Person person) {
        this.response = false;
        PrintWriter printWriter;
        FileWriter fileWriter;
        try {
            fileWriter    = new FileWriter("Documents/Files/Texts/" + this.root);
            printWriter   = new PrintWriter(fileWriter);
            person = new Person(person.getRfrnc(), person.getRfrnc_Prsn(), person.getRfrnc_TypPrsn(), person.getCndtn(), person.getRmvd(), person.getLckd(), person.getDtAdmssn(), person.getChckTm());
            int reference = this.findReference(person.getRfrnc());
            
            if(reference == -1) {
                this.methods.add(person);
            } else {
                this.methods.edit(reference, person);
            }
            
            for(int i = 0; i< this.methods.count(); i++) {
                person = this.methods.getData(i);
                printWriter.println(String.valueOf(person.getRfrnc() + "," + person.getRfrnc_Prsn() + "," + person.getRfrnc_TypPrsn() + "," + person.getCndtn() + "," + person.getRmvd() + "," + person.getLckd() + "," + person.getDtAdmssn() + "," + person.getChckTm()));
            }
            printWriter.close();
            this.response = true;
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Error to update: " + e.getMessage());
        }
        return this.response;
    }

    @Override
    public int findReference(int reference) {
        for(int i = 0; i < this.methods.count(); i++) {
            if(reference == this.methods.getData(i).getRfrnc()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Person getObject(int reference) {
        Person person = null;
        for(int i = 0; i< this.methods.count(); i++) {
            person = this.methods.getData(i);
            if(person.getRfrnc() == reference) {
                return person;
            }
        }
        return person;
    }
    
}
