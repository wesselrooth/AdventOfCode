package com.example.AdventOfCode;

import java.util.ArrayList;
import java.util.List;

public class Collumn {

    private List<Long> numberList = new ArrayList<>();
    private List<String> numberStringList = new ArrayList<>();
    private String oparent;

    public List<Long> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Long> numberList) {
        this.numberList = numberList;
    }

    public String getOparent() {
        return oparent;
    }

    public void setOparent(String oparent) {
        this.oparent = oparent;
    }

    public void addNumber(Long number){
        this.numberList.add(number);
    }

    public void addNumberString(String numberString){
        this.numberStringList.add(numberString);
    }
    public List<String> getNumberStringList() {
        return numberStringList;
    }
    public void setNumberStringList(List<String> numberStringList) {
        this.numberStringList = numberStringList;
    }
}
