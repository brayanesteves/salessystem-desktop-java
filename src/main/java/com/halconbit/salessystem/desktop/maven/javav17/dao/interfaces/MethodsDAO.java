package com.halconbit.salessystem.desktop.maven.javav17.dao.interfaces;

import java.util.List;

public interface MethodsDAO<T> {
    
    public List<T> list();
    public boolean insert(T obj);
    public boolean update(T obj);
    public int findReference(int reference);
    public T getObject(int reference);
    
}
