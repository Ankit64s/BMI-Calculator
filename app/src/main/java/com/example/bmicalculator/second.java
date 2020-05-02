package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Locale;

public class second extends AppCompatActivity implements TextToSpeech.OnInitListener {
EditText e1,e2;
TextView t1,t2;
Button b1;
String s1,s2,s3,s4;
double height,weight,BMI;
TextToSpeech tts1,tts2,tts3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        e1=findViewById(R.id.wet);
        tts1=new TextToSpeech(second.this,this);
        tts2=new TextToSpeech(second.this,this);
        tts3=new TextToSpeech(second.this,this);
        e2=findViewById(R.id.het);
        t1=findViewById(R.id.set);
        t2=findViewById(R.id.cat);
        b1=findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                weight=Double.parseDouble(s1);
                height=Double.parseDouble(s2);
                BMI=(weight)/(height*height);
                DecimalFormat df=new DecimalFormat("#.##");
                double result= Double.parseDouble(df.format(BMI));
                tts2.speak("Your BMI is",TextToSpeech.QUEUE_ADD,null);
                s3=Double.toString(result);
                tts3.speak(s3,TextToSpeech.QUEUE_ADD,null);
                t1.setText(s3);
                if(result<15){
                    s4="Very Severly Underweight";
                    t2.setText(s4);
                    t2.setTextColor(Color.RED);
                    tts1.speak(s4,TextToSpeech.QUEUE_ADD,null);
                }
                else if(result<16){
                    s4="Severly Underweight";
                    t2.setText(s4);
                    t2.setTextColor(Color.YELLOW);
                    tts1.speak(s4,TextToSpeech.QUEUE_ADD,null);
                }
                else if(result<18.5){
                    s4="Underweight";
                    t2.setText(s4);
                    t2.setTextColor(Color.MAGENTA);
                    tts1.speak(s4,TextToSpeech.QUEUE_ADD,null);
                }
                else if(result<25){
                    s4="Normal";
                    t2.setText(s4);
                    t2.setTextColor(Color.GREEN);
                    tts1.speak(s4,TextToSpeech.QUEUE_ADD,null);
                }
                else if(result<30){
                    s4="Overweight";
                    t2.setText(s4);
                    t2.setTextColor(Color.BLUE);
                    tts1.speak(s4,TextToSpeech.QUEUE_ADD,null);
                }
                else if (result < 35){
                    s4 = "Obese Class 1 - Moderately Obese";
                    t2.setText(s4);
                    t2.setTextColor(Color.MAGENTA);
                    tts1.speak(s4,TextToSpeech.QUEUE_ADD,null);
                }
                else if (result < 40){
                    s4 = "Obese Class 2 - Severely Obese";
                    t2.setText(s4);
                    t2.setTextColor(Color.YELLOW);
                    tts1.speak(s4,TextToSpeech.QUEUE_ADD,null);
                }
                else{
                    s4 = "Obese Class 3 - Very Severely Obese";
                    t2.setText(s4);
                    t2.setTextColor(Color.RED);
                    tts1.speak(s4,TextToSpeech.QUEUE_ADD,null);
                }
            }
        });
    }


    @Override
    public void onInit(int i) {
        tts1.setLanguage(Locale.ENGLISH);
        tts1.setSpeechRate(1.0f);
        tts2.setLanguage(Locale.ENGLISH);
        tts2.setSpeechRate(1.0f);
        tts3.setLanguage(Locale.ENGLISH);
        tts3.setSpeechRate(1.0f);
    }
}
