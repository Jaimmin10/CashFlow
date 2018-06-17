package com.naiya1.jgs.cashflow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity{

    DatabaseHelper mDatabaseHelper;
    Spinner spinner;
    RadioGroup radioGroup;
    Button btn;
    EditText editText;
    RadioButton credit;
    RadioButton debit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);
        editText =  findViewById(R.id.editText_main);

        spinner =  findViewById(R.id.label_spinner);
        btn =  findViewById(R.id.btn);

        List<String> customers = new ArrayList<>();
        customers.add("raman");
        customers.add("chhagan");
        customers.add("magan");
        customers.add("chaman");
        customers.add("kamlesh");
        customers.add("ravi");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, customers);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        mDatabaseHelper=new DatabaseHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                  String newEntry=editText.getText().toString();
                  if (editText.length()!=0){
                      AddData(newEntry);
                      editText.setText("");
                  }else{
                            toastMessage("invalid input");
                  }

                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> parent,
                                                   View view, int position, long id) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> arg0) {
                        }

                    });

                }
            });
        }
        public void AddData(String newEntry){
        boolean insertData=mDatabaseHelper.addData(newEntry);
        if(insertData)
            toastMessage("success");
        else
            toastMessage("failure");
        }

        public void toastMessage(String message){
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        }
    }
