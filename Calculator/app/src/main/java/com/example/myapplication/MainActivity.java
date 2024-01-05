package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
   TextView totalComputation, enterData;

   String number = "";
   String computationData = "0";
   ArrayList<Integer> num = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterData = findViewById(R.id.input);
        totalComputation = findViewById(R.id.total);
    }

//    Operations
    public void click_AC (View view){
        try{
            number = "";
            computationData = "";
            enterData.setText("");
            totalComputation.setText("");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete (View view){
        try{
            computationData = computationData.substring(0, computationData.length()-1);
            enterData.setText(computationData);
            totalComputation.setText(computationData);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void moduleDiv (View view) throws ScriptException {
        try{
            if(number.length() >= 2 ){
                totalComputation.setText("0."+number);
            }else{
                totalComputation.setText("0.0"+number);
            }
            number += "%";
            computationData= number;
            enterData.setText(computationData);

        }catch (Exception e){
            totalComputation.setText("Error");
            e.printStackTrace();
        }

    }
    public void divide (View view){
        try{
            number += "/";
            computationData= number;
            enterData.setText(computationData);
        }catch (Exception e){
            totalComputation.setText("Error");
            e.printStackTrace();
        }

    }
    public void multiplication (View view){
        try{
            number += "*";
            computationData= number;
            enterData.setText(computationData);
        }catch(Exception e){
            totalComputation.setText("Error");
            e.printStackTrace();
        }

    }

    public void subtraction (View view){
        try{
            number += "-";
            computationData= number;
            enterData.setText(computationData);
        }catch (Exception e){
            totalComputation.setText("Error");
            e.printStackTrace();
        }

    }

    public void addition (View view) throws ScriptException {
        try{
            number += "+";
            computationData= number;
            enterData.setText(computationData);
        }catch (Exception e){
            totalComputation.setText("Error");
            e.printStackTrace();
        }

    }

    public void equal (View view){
        try{
            computeAutoEqual();
        }catch (Exception e){
            totalComputation.setText("Error");
            e.printStackTrace();
        }

    }



//    numbers

    public void one (View view){
        try {
            number += "1";
            computationData = number;
            enterData.setText(number);
            computeAuto();
        }catch (Exception e){
            totalComputation.setText("Error");
            e.printStackTrace();
        }
    }
    public void two (View view){
        number += '2';
        computationData= number;
        enterData.setText(number);
        computeAuto();
    }
    public void three (View view){
        try {
            number += '3';
            computationData = number;
            enterData.setText(number);
            computeAuto();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void four (View view){
        try {
            number += '4';
            computationData = number;
            enterData.setText(number);
            computeAuto();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void five (View view){
        try {
            number += '5';
            computationData = number;
            enterData.setText(number);
            computeAuto();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void six (View view){
        try {
            number += '6';
            computationData = number;
            enterData.setText(number);
            computeAuto();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void seven (View view){
        try {
            number += '7';
            computationData = number;
            enterData.setText(number);
            computeAuto();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void eight (View view){
        try {
            number += '8';
            computationData = number;
            enterData.setText(number);
            computeAuto();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void nine (View view){
        try {
            number += '9';
            computationData = number;
            enterData.setText(number);
            computeAuto();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void zero (View view){
        try {
            number += '0';
            computationData = number;
            enterData.setText(number);
            computeAuto();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void point (View view){
        try {
            number += '.';
            computationData = number;
            enterData.setText(number);
            computeAuto();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

   public void computeAuto(){
       try {
           Object result = engine.eval(computationData);
           String resultotal = result.toString();
           int indexNum = resultotal.indexOf(".");
           char nextDigit = resultotal.charAt(indexNum + 1);
           String[] decimalSplit = resultotal.split("\\.");
           System.out.println("nextDigit" + nextDigit);
           if(nextDigit == '0'){
               result = Integer.parseInt(decimalSplit[0]);
           }
           totalComputation.setText(result.toString());
           Log.d("Calculator", "Operation: " + computationData + " result: " + result);
       } catch (ScriptException e) {
           totalComputation.setText("Error");
           Log.d("Calculator", " ScriptEngine error: " + e.getMessage());
           e.printStackTrace();
       }
   }

    public void computeAutoEqual(){
        try {
            Object result = engine.eval(computationData);
            String resultotal = result.toString();
            int indexNum = resultotal.indexOf(".");
            char nextDigit = resultotal.charAt(indexNum + 1);
            String[] decimalSplit = resultotal.split("\\.");
            System.out.println("nextDigit" + nextDigit);
            if(nextDigit == '0'){
                result = Integer.parseInt(decimalSplit[0]);
            }
            enterData.setText(result.toString());
            number = result.toString();
            computationData = "";
            totalComputation.setText("");
            Log.d("Calculator", "Operation: " + computationData + " result: " + result);
        } catch (ScriptException e) {
            Log.d("Calculator", " ScriptEngine error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}