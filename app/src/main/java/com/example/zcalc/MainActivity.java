package com.example.zcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView input, operation;
    String sign=null,val1=null,val2=null,mathf=null;
    Double opd1=null,opd2=null,finalres=null;
    boolean dot,checkmath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input=(TextView) findViewById(R.id.input);
        operation=(TextView) findViewById(R.id.opr);
        dot=false;
        checkmath=false;

    }

    public void btn_7(View view) {
        input.setText(input.getText()+"7");
    }
    public void btn_8(View view) {
        input.setText(input.getText()+"8");
    }
    public void btn_9(View view) {
        input.setText(input.getText()+"9");
    }
    public void btn_4(View view) {
        input.setText(input.getText()+"4");
    }
    public void btn_5(View view) {
        input.setText(input.getText()+"5");
    }
    public void btn_6(View view) {
        input.setText(input.getText()+"6");
    }
    public void btn_1(View view) {
        input.setText(input.getText()+"1");
    }
    public void btn_2(View view) {
        input.setText(input.getText()+"2");
    }
    public void btn_3(View view) { input.setText(input.getText()+"3"); }
    public void btn_0(View view) { input.setText(input.getText()+"0"); }

    public void btn_clear(View view)
    {
        sign=null;
        val1=null;
        val2=null;
        opd1=null;
        opd2=null;
        finalres=null;
        input.setText(null);
        operation.setText(null);
        dot=false;
    }
    public void btn_multiply(View view) {
        sign = "x";
        val1 = input.getText().toString();
        input.setText(null);
        operation.setText("x");
        dot=false;
    }
    public void btn_add(View view) {
        sign = "+";
        val1 = input.getText().toString();
        input.setText(null);
        operation.setText("+");
        dot=false;
    }
    public void btn_divide(View view) {
        sign = "/";
        val1 = input.getText().toString();
        input.setText(null);
        operation.setText("/");
        dot=false;
    }
    public void btn_substract(View view) {
        sign = "-";
        val1 = input.getText().toString();
        input.setText(null);
        operation.setText("-");
        dot=false;
    }
    public void btn_log(View view) {
        mathf = "log";
        operation.setText("log");
        dot=false;
    }
    public void btn_sqrt(View view) {
        mathf = "sqrt";
        operation.setText("√");
        dot=false;
    }
    public void btn_dot(View view) {
        if(!dot)
        {
            if(input.getText().equals("")){
                input.setText("0.");
            }
            else{
                input.setText(input.getText()+".");
            }
            dot=true;
        }
    }
    public void btn_erase(View view) {
        if(input.getText().equals(""))
            input.setText(null);
        else
        {
            int length=input.getText().length();
            String temp=input.getText().toString();
            if(temp.charAt(length-1)=='.')  // here we check if the number is a decimal or integer type
            {
                dot=false;
                input.setText(input.getText().subSequence(0,input.getText().length()-1));
            }
            else
                input.setText(input.getText().subSequence(0,input.getText().length()-1));

        }
    }
    public void btn_equal(View view) {
        if((mathf==null && sign==null) || input.getText().equals(""))
            operation.setText("No Value Entered!");
        else if(mathf!=null)
        {
            val1=input.getText().toString();
            opd1=Double.parseDouble(val1);
            input.setText(null);
            switch(mathf)
            {
                case "log":
                    input.setText(Math.log10(opd1)+"");
                    operation.setText(null);
                    mathf=null;
                    break;
                case "sqrt":
                    operation.setText(null);
                    input.setText(Math.sqrt(opd1)+"");
                    mathf=null;
                    break;
                default:
                    break;
            }
        }
        else if(sign!=null)
        {
            val2=input.getText().toString();
            input.setText(null);
            opd1=Double.parseDouble(val1);
            opd2=Double.parseDouble(val2);
            switch (sign)
            {
                case "+":
                    finalres=opd1+opd2;
                    input.setText(finalres+"");
                    operation.setText(null);
                    break;
                case "-":
                    finalres=opd1-opd2;
                    input.setText(finalres+"");
                    operation.setText(null);
                    break;
                case "x":
                    finalres=opd1*opd2;
                    input.setText(finalres+"");
                    operation.setText(null);
                    break;
                case "/":
                    finalres=opd1/opd2;
                    input.setText(finalres+"");
                    operation.setText(null);
                    break;
                default:
                    break;
            }


        }
        else {
            operation.setText("Error!");
            input.setText(null);
        }
    }



}