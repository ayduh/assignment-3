package com.assignment3;

public class MyTestingClass {
    private int anyNumber;
    private int hashCode;

    public MyTestingClass(int num){
        this.anyNumber = num;
    }

    public void changeNumber(int num){
        this.anyNumber = num;
    }

    @Override
    public int hashCode() {
        hashCode = anyNumber * 67;

        return hashCode;
    }

    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(object == null || this.getClass() != object.getClass()) return false;
        MyTestingClass o = (MyTestingClass) object;
        return this.anyNumber == o.anyNumber;
    }
}
