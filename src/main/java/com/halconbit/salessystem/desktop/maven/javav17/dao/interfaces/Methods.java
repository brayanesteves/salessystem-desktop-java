package com.halconbit.salessystem.desktop.maven.javav17.dao.interfaces;

import java.util.List;

public class Methods<T> {
    
    private final List<T> a;

    public Methods(List<T> a) {
        this.a = a;
    }
    
    public void add(T p) {
        this.a.add(p);
    }
    
    public void edit(int i, T p) {
        this.a.set(i, p);
    }
    
    public void delete(int i) {
        this.a.remove(i);
    }
    
    public T getData(int i) {
        return (T) this.a.get(i);
    }
    
    public int count() {
        return this.a.size();
    }
    
}
