package com.example.telephonebook;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/5/17.
 */

public class Info extends DataSupport{

    private String name;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
