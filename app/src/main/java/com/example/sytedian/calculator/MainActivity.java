package com.example.sytedian.calculator;

import android.databinding.DataBindingUtil;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sytedian.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private char currentOperation;

    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char MUL = '*';
    private static final char DIV = '/';

    private double leftValue = Double.NaN;
    private double rightValue = Double.NaN;
    //private double result;

    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding  = DataBindingUtil.setContentView(this,R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");

        binding.buttonZero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.inputText.setText(binding.inputText.getText()+"0");
            }
        });

        binding.buttonOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.inputText.setText(binding.inputText.getText()+"1");
            }
        });

        binding.buttonTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.inputText.setText(binding.inputText.getText()+"2");
            }
        });

        binding.buttonThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.inputText.setText(binding.inputText.getText()+"3");
            }
        });

        binding.buttonFour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.inputText.setText(binding.inputText.getText()+"4");
            }
        });

        binding.buttonFive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.inputText.setText(binding.inputText.getText()+"5");
            }
        });

        binding.buttonSix.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.inputText.setText(binding.inputText.getText()+"6");
            }
        });

        binding.buttonSeven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.inputText.setText(binding.inputText.getText()+"7");
            }
        });

        binding.buttonEight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.inputText.setText(binding.inputText.getText()+"8");
            }
        });

        binding.buttonNine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.inputText.setText(binding.inputText.getText()+"9");
            }
        });

        binding.buttonDot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.inputText.setText(binding.inputText.getText()+".");
            }
        });

        binding.buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculate();
                currentOperation = ADD;
                //binding.inputText.setText(binding.inputText.getText()+"+");

                binding.inputText.setText(null);
            }
        });

        binding.buttonSubtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculate();
                currentOperation = SUB;
               // binding.inputText.setText(binding.inputText.getText()+"-");
                binding.inputText.setText(null);
            }
        });

        binding.buttonMultiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculate();
                currentOperation = MUL;
              //  binding.inputText.setText(binding.inputText.getText()+"*");
                binding.inputText.setText(null);
            }
        });

        binding.buttonDivide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculate();
                currentOperation = DIV;
              //  binding.inputText.setText(binding.inputText.getText()+"/");
                binding.inputText.setText(null);
            }
        });

        binding.buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
               /* binding.infoTextView.setText(binding.infoTextView.getText().toString() +
                        decimalFormat.format(leftValue) + " = " + decimalFormat.format(rightValue));*/
                binding.inputText.setText(leftValue+"");
               // leftValue = Double.NaN;
                currentOperation = '0';
            }
        });

        binding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* if(binding.inputText.getText().length() > 0) {
                    CharSequence currentText = binding.inputText.getText();
                    binding.inputText.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else {*/
                    leftValue = Double.NaN;
                    rightValue = Double.NaN;
                    binding.inputText.setText("");
                   // binding.infoTextView.setText("");
               // }
            }
        });

    }

    private void calculate() {
        if(!Double.isNaN(leftValue)&&currentOperation!='0') {
            rightValue = Double.parseDouble(binding.inputText.getText().toString());
            binding.inputText.setText(null);

            if(currentOperation == ADD)
                leftValue = this.leftValue + rightValue;
            else if(currentOperation == SUB)
                leftValue = this.leftValue - rightValue;
            else if(currentOperation == MUL)
                leftValue = this.leftValue * rightValue;
            else if(currentOperation == DIV)
                leftValue = this.leftValue / rightValue;
        }
        else if(Double.isNaN(leftValue)){
            try {
                leftValue = Double.parseDouble(binding.inputText.getText().toString());
            }
            catch (Exception e){}
        }
    }
}
