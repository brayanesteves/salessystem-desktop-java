package com.halconbit.salessystem.desktop.maven.javav17.dao;

import com.halconbit.salessystem.desktop.maven.javav17.access.Access;
import com.halconbit.salessystem.desktop.maven.javav17.dao.interfaces.Methods;
import com.halconbit.salessystem.desktop.maven.javav17.dao.interfaces.MethodsDAO;
import com.halconbit.salessystem.desktop.maven.javav17.entities.NaturalPerson;
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

public class NaturalPersonDAO implements MethodsDAO<NaturalPerson> {
    
    private final List<NaturalPerson> list;
    private Methods<NaturalPerson> methods;
    private final String root = "0_NtrlPrsn.txt";
    private boolean response;
    private NaturalPerson naturalPerson;
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    
    
    public NaturalPersonDAO() {
        this.list    = new ArrayList<>();
        this.methods = new Methods<>(this.list);
        this.loadList();
    }
    
    private void loadList() {
        NaturalPerson naturalPerson;
        try {
            for(String data : Access.loadFile(this.root)) {
                StringTokenizer stringTokenizer = new StringTokenizer(data, ",");
                Date date = this.dateFormat.parse(stringTokenizer.nextToken());
                Time time = new Time(this.timeFormat.parse(stringTokenizer.nextToken()).getTime());            
                naturalPerson = new NaturalPerson(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken(), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), date, time);
                this.methods.add(naturalPerson);
            }
        } catch (ParseException ex) {
                Logger.getLogger(NaturalPersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List list() {
        List<NaturalPerson> records = new ArrayList<>();
        try {
            for(String data : Access.loadFile(this.root)) {
                StringTokenizer stringTokenizer = new StringTokenizer(data, ",");
                Date date = this.dateFormat.parse(stringTokenizer.nextToken());
                Time time = new Time(this.timeFormat.parse(stringTokenizer.nextToken()).getTime());            
                this.naturalPerson = new NaturalPerson(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken(), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), date, time);
                records.add(this.naturalPerson);
            }
        } catch(Exception e) {
            Logger.getLogger(NaturalPersonDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error while listing natural person: " + e.getMessage());
        }
        
        return records;
    }

    @Override
    public boolean insert(NaturalPerson naturalPerson) {
        this.response = false;
        PrintWriter printWriter;
        FileWriter fileWriter;
        try {
            fileWriter    = new FileWriter("Documents/Files/Texts/" + this.root);
            printWriter   = new PrintWriter(fileWriter);
            naturalPerson = new NaturalPerson(naturalPerson.getRfrnc(), naturalPerson.getRfrnc_Ncnlty(), naturalPerson.getRfrnc_Cntry(), naturalPerson.getIdntfctnDcmnt(), naturalPerson.getNms(), naturalPerson.getSrnms(), naturalPerson.getRfrntlPhnNmbr(), naturalPerson.getTxAddrss(), naturalPerson.getCndtn(), naturalPerson.getRmvd(), naturalPerson.getLckd(), naturalPerson.getDtAdmss(), naturalPerson.getChckTm());
            this.methods.add(naturalPerson);
            for(int i = 0; i< this.methods.count(); i++) {
                naturalPerson = this.methods.getData(i);
                printWriter.println(String.valueOf(naturalPerson.getRfrnc() + "," + naturalPerson.getRfrnc_Ncnlty() + "," + naturalPerson.getRfrnc_Cntry() + "," + naturalPerson.getIdntfctnDcmnt() + "," + naturalPerson.getNms() + "," + naturalPerson.getSrnms() + "," + naturalPerson.getRfrntlPhnNmbr() + "," + naturalPerson.getTxAddrss() + "," + naturalPerson.getCndtn() + "," + naturalPerson.getRmvd() + "," + naturalPerson.getLckd() + "," + naturalPerson.getDtAdmss() + "," + naturalPerson.getChckTm()));
            }
            printWriter.close();
            this.response = true;
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Error to insert: " + e.getMessage());
        }
        return this.response;
    }

    @Override
    public boolean update(NaturalPerson naturalPerson) {
        this.response = false;
        PrintWriter printWriter;
        FileWriter fileWriter;
        try {
            fileWriter    = new FileWriter("Documents/Files/Texts/" + this.root);
            printWriter   = new PrintWriter(fileWriter);
            naturalPerson = new NaturalPerson(naturalPerson.getRfrnc(), naturalPerson.getRfrnc_Ncnlty(), naturalPerson.getRfrnc_Cntry(), naturalPerson.getIdntfctnDcmnt(), naturalPerson.getNms(), naturalPerson.getSrnms(), naturalPerson.getRfrntlPhnNmbr(), naturalPerson.getTxAddrss(), naturalPerson.getCndtn(), naturalPerson.getRmvd(), naturalPerson.getLckd(), naturalPerson.getDtAdmss(), naturalPerson.getChckTm());
            int reference = this.findReference(naturalPerson.getRfrnc());
            
            if(reference == -1) {
                this.methods.add(naturalPerson);
            } else {
                this.methods.edit(reference, naturalPerson);
            }
            
            for(int i = 0; i< this.methods.count(); i++) {
                naturalPerson = this.methods.getData(i);
                printWriter.println(String.valueOf(naturalPerson.getRfrnc() + "," + naturalPerson.getRfrnc_Ncnlty() + "," + naturalPerson.getRfrnc_Cntry() + "," + naturalPerson.getIdntfctnDcmnt() + "," + naturalPerson.getNms() + "," + naturalPerson.getSrnms() + "," + naturalPerson.getRfrntlPhnNmbr() + "," + naturalPerson.getTxAddrss() + "," + naturalPerson.getCndtn() + "," + naturalPerson.getRmvd() + "," + naturalPerson.getLckd() + "," + naturalPerson.getDtAdmss() + "," + naturalPerson.getChckTm()));
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
    public NaturalPerson getObject(int reference) {
        NaturalPerson naturalPerson = null;
        for(int i = 0; i< this.methods.count(); i++) {
            naturalPerson = this.methods.getData(i);
            if(naturalPerson.getRfrnc() == reference) {
                return naturalPerson;
            }
        }
        return naturalPerson;
    }
    
}
