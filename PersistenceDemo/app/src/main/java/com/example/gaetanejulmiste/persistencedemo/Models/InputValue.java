package com.example.gaetanejulmiste.persistencedemo.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/**
 * Created by gaetanejulmiste on 5/22/16.
 */
@Table(name="input_value")
public class InputValue extends Model {
    @Column(name="value")
    public String text;

    public InputValue(){
        super();
    }

    public InputValue(String text){
        super();
        this.text =text;
    }

    public static InputValue queryMostRecent(){
        return new Select().from(InputValue.class).orderBy("id DESC").limit("1").executeSingle();
    }

}
