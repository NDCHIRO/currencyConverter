package com.example.currencyconvertert3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText value;
    Button convertBt;
    TextView result;
    String []currency={"USD","EGY"};
    Spinner sp1;
    Spinner sp2;
    int BSp1;
    int BSp2;
    Double castToDouble =0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value=findViewById(R.id.editTextTextPersonName);
        //castToInt=Integer.parseInt(value.getText().toString());
        result=findViewById(R.id.resultTextView);
        convertBt=findViewById(R.id.convertButton);

        sp1=findViewById(R.id.spinner1);
        sp2=findViewById(R.id.spinner2);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_spinner_item,currency );
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(aa);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                    BSp1=0;
                else
                    BSp1=1;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        ArrayAdapter aa1=new ArrayAdapter(this,android.R.layout.simple_spinner_item,currency );
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(aa1);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                    BSp2=0;
                else
                    BSp2=1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        convertBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((BSp1==0 && BSp2==0) ||(BSp1==1 && BSp2==1)) {
                    System.out.println("yes");
                    result.setText(value.getText().toString());
                }
                else if(BSp1==0 && BSp2==1) //from=USD and to=EGY
                {
                    castToDouble=0.0;
                    System.out.println("USD and EGY");
                    castToDouble =Double.parseDouble(value.getText().toString());
                    castToDouble = castToDouble *15.9;
                    result.setText(castToDouble +"");
                }
                else if(BSp1==1 && BSp2==0) //from=USD and to=EGY
                {
                    castToDouble=0.0;
                    System.out.println("USD and EGY");
                    castToDouble =Double.parseDouble(value.getText().toString());
                    castToDouble = castToDouble /15.9;
                    result.setText(castToDouble +"");
                }
            }
        });
    }
}