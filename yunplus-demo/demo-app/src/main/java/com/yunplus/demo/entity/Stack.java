package com.yunplus.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    private List<T> list;
    private int length = 0;

    public Stack() {
        list = new ArrayList<>();
    }

    public Stack(int len) {
        list = new ArrayList<>(len);
        length = len;
    }

    public Integer len() {
        return list.size();
    }

    public boolean push(T t) {
        if (length > 0 && list.size() == length) {
            throw new RuntimeException("stack is full,push fail");
        }
        return list.add(t);
    }

    public T top() {
        return list.get(list.size() - 1);
    }
    public T pop(){
        if(len()==0){
            throw new RuntimeException("stack is full,push fail");
        }
        T t = list.get(list.size()-1);

        return t;
    }

}
