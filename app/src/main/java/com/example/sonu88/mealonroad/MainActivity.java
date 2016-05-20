package com.example.sonu88.mealonroad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int quantity1=0 ,quantity2=0 ,quantity3=0 ,quantity4=0;
    public final static String EXTRA_MESSAGE = "com.example.sonu88.mealonroad.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 =(Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 =(Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 =(Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 =(Button)findViewById(R.id.button4);
        button4.setOnClickListener(this);
        Button button5 =(Button)findViewById(R.id.button5);
        button5.setOnClickListener(this);
        Button button6 =(Button)findViewById(R.id.button6);
        button6.setOnClickListener(this);
        Button button7 =(Button)findViewById(R.id.button7);
        button7.setOnClickListener(this);
        Button button8 =(Button)findViewById(R.id.button8);
        button8.setOnClickListener(this);
    }
    public void submitOrder(View v){
        CheckBox sweets =(CheckBox)findViewById(R.id.checkBox_sweet);
        boolean isSweet= sweets.isChecked();
        CheckBox drinks =(CheckBox)findViewById(R.id.checkBox_drink);
        boolean isDrink = drinks.isChecked();
        CheckBox plate = (CheckBox)findViewById(R.id.checkBox_plate);
        boolean isPlate= plate.isChecked();
        EditText textName =(EditText)findViewById(R.id.editText_name);
        Editable text1 = (Editable)textName.getText();
        String name = text1.toString();
        EditText pickupPlace = (EditText)findViewById(R.id.editText_place);
        Editable text2 =(Editable)pickupPlace.getText();
        String place = text2.toString();
        EditText phoneNo = (EditText)findViewById(R.id.editText_phonenumber);
        Editable text3 = (Editable)phoneNo.getText();
        String phone = text3.toString();
        double price = calculatePrice(isSweet,isDrink,isPlate,quantity1,quantity2,quantity3,quantity4);
        String sPrice = Double.toString(price);
        String summary = orderSummary(name,place,phone,sPrice);
        Intent intent=new Intent(this,SummaryActivity.class);
        intent.putExtra(EXTRA_MESSAGE,summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    private String orderSummary(String name, String place,String phone,String sPrice) {

       String msg = " NAME :"+name;
        msg =msg+ "\n PICKUP PLACE :"+place;
        msg =msg+ "\n PHONE NUMBER :"+phone;
        msg =msg+ "\n YOUR ORDER TOTAL :"+ "$"+sPrice;
        return msg;
    }

    private double calculatePrice(boolean isSweet,boolean isDrink,boolean isPlate,int quantity1,int quantity2,int quantity3,int quantity4) {
       double orderPrice = 0;
        orderPrice= (quantity1*1) + (quantity2*2) + (quantity3*2) + (quantity4*1);
        if(isSweet == true){
            orderPrice=orderPrice+.5;
        }
        if(isDrink==true){
            orderPrice=orderPrice+.25;
        }
        if (isPlate==true){
            orderPrice=orderPrice+.25;
        }
        return orderPrice;
    }
    private void displayQuantity(int num){
        TextView textView =(TextView)findViewById(R.id.quantity_text_view);
        textView.setText(""+num);

    }
    private void displayQuantity1(int num1){
        TextView textView1 = (TextView)findViewById(R.id.quantity_text_view1);
        textView1.setText(""+num1);
    }
    private void displayQuantity2(int num2)
    {TextView textView2 =(TextView)findViewById(R.id.quantity_text_view2);
        textView2.setText(""+num2);

    }
    private void displayQuantity3(int num3)
    {TextView textView3 =(TextView)findViewById(R.id.quantity_text_view3);
        textView3.setText(""+num3);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                 if(quantity1>=9){
                 Toast.makeText(this,"MAX QUANTITY PER ORDER",Toast.LENGTH_SHORT).show();
                 return;
            }
            else{
                 quantity1+=1;
                 displayQuantity(quantity1);
            }
                 break;
            case R.id.button2:
                if(quantity1<=0){
                Toast.makeText(this,"PLEASE ADD SOME NOODLES",Toast.LENGTH_SHORT).show();
            }
            else{
                quantity1-=1;
                displayQuantity(quantity1);
            }
                break;
            case  R.id.button3:
                if(quantity2>=5){
                Toast.makeText(this,"MAX QUANTITY PER ORDER",Toast.LENGTH_SHORT).show();
                return;
            }
            else{
                quantity2+=1;
                displayQuantity1(quantity2);
            }
                break;
            case R.id.button4:
                if(quantity2<=0){
                Toast.makeText(this,"PLEASE ADD SOME THALIS",Toast.LENGTH_SHORT).show();
            }
            else{
                quantity2-=1;
                displayQuantity1(quantity2);
            }
                break;
            case  R.id.button5:
                if(quantity3>=5){
                Toast.makeText(this,"MAX QUANTITY PER ORDER",Toast.LENGTH_SHORT).show();
                return;
            }
            else{
                quantity3+=1;
                displayQuantity2(quantity3);

            }
                break;
            case  R.id.button6:
                if(quantity3<=0){
                Toast.makeText(this,"PLEASE ADD SOME ROTI CURRY",Toast.LENGTH_SHORT).show();
            }
            else{
                quantity3-=1;
                displayQuantity2(quantity3);
            }
                break;
            case R.id.button7:
                if(quantity4>=9){
                Toast.makeText(this,"MAX QUANTITY PER ORDER",Toast.LENGTH_SHORT).show();
                return;
            }
            else{
                quantity4+=1;
                displayQuantity3(quantity4);

            }
                break;
            case R.id.button8:
                if(quantity4<=0){
                Toast.makeText(this,"PLEASE ADD SOME BREAD",Toast.LENGTH_SHORT).show();
            }
            else{
                quantity4-=1;
                displayQuantity3(quantity4);
            }
                break;


        }
    }
}
