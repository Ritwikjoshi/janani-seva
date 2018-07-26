package com.janni.botlabs.jananiseva;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by BD on 20-03-2018.
 */

public class registrationActivity extends AppCompatActivity {
    TextView  dateText,menstrualMissDate,parity,aborted;
    private int mYearFrom, mMonthFrom, mDayFrom,mCurrentYear, mCurrentMonth, mCurrentDay;
    EditText NameEdit,mobileEdit,StateEdit,AddressEdit,weightEdit,FirstContactNameEdit,FirstContactMobileEdit;
    Spinner CitySpinner,bloodGroupSpinner,bloodGroupPNSpinner,gravidaSpinner,livingSpinner;
    Button registerButton;
    AppCompatButton pickContact;
    LinearLayout dateLinear;
    ImageView calenderMenstrual;
    int gravida, living;
    final int REQUEST_CODE = 1;
    String num, name;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (REQUEST_CODE):
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor c = getContentResolver().query(contactData, null, null, null, null);
                    if (c.moveToFirst()) {
                        String contactId = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                        String hasNumber = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                        if (Integer.valueOf(hasNumber) == 1) {
                            Cursor numbers = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
                            while (numbers.moveToNext()) {
                                num = numbers.getString(numbers.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                                name = numbers.getString(numbers.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                            }
                        }
                    }
                    break;
                }

        }
    }

    @Override
    protected void onPostResume() {
        FirstContactNameEdit.setText(name);
        FirstContactMobileEdit.setText(num);
        super.onPostResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        NameEdit= findViewById(R.id.NameEdit);
        dateLinear = findViewById(R.id.dateLinear);
        menstrualMissDate = findViewById(R.id.firstMenstrualMissDate);
        mobileEdit= findViewById(R.id.mobileEdit);
        StateEdit= findViewById(R.id.StateEdit);
        AddressEdit= findViewById(R.id.AddressEdit);
        weightEdit= findViewById(R.id.weightEdit);
        FirstContactNameEdit= findViewById(R.id.FirstContactNameEdit);
        FirstContactMobileEdit= findViewById(R.id.FirstContactMobileEdit);
        parity = findViewById(R.id.paritynumber);
        aborted = findViewById(R.id.abortedNumber);
        dateText = findViewById(R.id.dateText);
        pickContact = findViewById(R.id.pickContact);
        calenderMenstrual = findViewById(R.id.menstrualcalender);

        final Calendar c = Calendar.getInstance();
        mCurrentYear = c.get(Calendar.YEAR);
        mCurrentMonth = c.get(Calendar.MONTH);
        mCurrentDay = c.get(Calendar.DAY_OF_MONTH);
        dateText.setText( mCurrentDay+ "-" + (mCurrentMonth + 1) + "-" +mCurrentYear );

        mYearFrom=mCurrentYear;
        mMonthFrom=mCurrentMonth;
        mDayFrom=mCurrentDay;

        dateLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(registrationActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                if (year > mCurrentYear) {
                                    Toast.makeText(registrationActivity.this, "", Toast.LENGTH_SHORT).show();
                                }
                                else if (monthOfYear > mCurrentMonth && year == mCurrentYear) {
                                    Toast.makeText(getApplicationContext(), "Invalid Date", Toast.LENGTH_SHORT).show();
                                }
                                else if (dayOfMonth > mCurrentDay && year == mCurrentYear && monthOfYear == mCurrentMonth) {
                                    Toast.makeText(getApplicationContext(), "Invalid Date", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    dateText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                    mYearFrom=year;
                                    mMonthFrom=monthOfYear;
                                    mDayFrom=dayOfMonth;
                                }

                            }
                        }, mCurrentYear, mCurrentMonth, mCurrentDay);
                datePickerDialog.show();
            }
        });

        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(registrationActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                if (year > mCurrentYear) {
                                    Toast.makeText(registrationActivity.this, "", Toast.LENGTH_SHORT).show();
                                }
                                else if (monthOfYear > mCurrentMonth && year == mCurrentYear) {
                                    Toast.makeText(getApplicationContext(), "Invalid Date", Toast.LENGTH_SHORT).show();
                                }
                                else if (dayOfMonth > mCurrentDay && year == mCurrentYear && monthOfYear == mCurrentMonth) {
                                    Toast.makeText(getApplicationContext(), "Invalid Date", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    dateText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                    mYearFrom=year;
                                    mMonthFrom=monthOfYear;
                                    mDayFrom=dayOfMonth;
                                }

                            }
                        }, mCurrentYear, mCurrentMonth, mCurrentDay);
                datePickerDialog.show();
            }
        });

        pickContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        menstrualMissDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(registrationActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                if (year > mCurrentYear) {
                                    Toast.makeText(registrationActivity.this, "", Toast.LENGTH_SHORT).show();
                                }
                                else if (monthOfYear > mCurrentMonth && year == mCurrentYear) {
                                    Toast.makeText(getApplicationContext(), "Invalid Date", Toast.LENGTH_SHORT).show();
                                }
                                else if (dayOfMonth > mCurrentDay && year == mCurrentYear && monthOfYear == mCurrentMonth) {
                                    Toast.makeText(getApplicationContext(), "Invalid Date", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    menstrualMissDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                    mYearFrom=year;
                                    mMonthFrom=monthOfYear;
                                    mDayFrom=dayOfMonth;
                                }

                            }
                        }, mCurrentYear, mCurrentMonth, mCurrentDay);
                datePickerDialog.show();
            }
        });

        calenderMenstrual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(registrationActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                if (year > mCurrentYear) {
                                    Toast.makeText(registrationActivity.this, "", Toast.LENGTH_SHORT).show();
                                }
                                else if (monthOfYear > mCurrentMonth && year == mCurrentYear) {
                                    Toast.makeText(getApplicationContext(), "Invalid Date", Toast.LENGTH_SHORT).show();
                                }
                                else if (dayOfMonth > mCurrentDay && year == mCurrentYear && monthOfYear == mCurrentMonth) {
                                    Toast.makeText(getApplicationContext(), "Invalid Date", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    menstrualMissDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                    mYearFrom=year;
                                    mMonthFrom=monthOfYear;
                                    mDayFrom=dayOfMonth;
                                }

                            }
                        }, mCurrentYear, mCurrentMonth, mCurrentDay);
                datePickerDialog.show();
            }
        });



        CitySpinner = findViewById(R.id.CitySpinner);
        String[] CitySpinnerItems = new String[]{
                "अजमेर", "अलवर", "बीकानेर", "भरतपुर","भीलवाड़ा", "जयपुर *", "जोधपुर", "लछमणगढ", "लाडनूं", "लखेरी", "लालसोट", "लोसल"," मकराना "," मालपुरा "," मंडलगढ़ "," मंडवा "," मंगोल "," मेर्टा सिटी "," माउंट आबू "," नदबाई "," नगर "," नागौर "," नसीराबाद "," नाथद्वारा "," नीम-का-थाना "," निम्बाहेड़ा "," नोहर "," नोखा "," पाली "," फलोदी "," फुलेरा "," पिलानी "," पीलीबांगा "," पिंडवाड़ा "," पिपर सिटी "," प्रांतिज", "राजगढ़", "राजगढ़", "राजखेड़ा", "राजलदेसर", "राजगढ़ (अलवर)", "राजगढ़ (चुरु)", "राजसमंद", "रामगंज मंडी", "रामगढ़", "रतनगढ़", " रावतभाटा "," रावतार "," रेगस "," सदरी "," सदुलशहर "," सदुलपुर "," सागावाड़ा "," संहार "," संचर "," संगिया "," सरदारशहर "," सवाई माधोपुर "," शाहपुरा "," शाहपुरा "," शेओगंज "," सीकर "," सिरोही "," सुजात "," श्री माधोपुर "," सुजांगढ़ "," सुमेरपुर "," सूरतगढ़ "," तारनगर "," टोडाभीम "," तोड़रासिंघ " , "टोंक", "उदयपुर", "उदयपुरवती", "विजयनगर, अजमेर"};
        ArrayAdapter<String> CitySpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CitySpinnerItems);
        CitySpinner.setAdapter(CitySpinnerAdapter);

        bloodGroupSpinner = findViewById(R.id.bloodGroupSpinner);
        String[] bloodGroupSpinnerItems = new String[]{"A","B","AB","O"};
        ArrayAdapter<String> bloodGroupSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, bloodGroupSpinnerItems);
        bloodGroupSpinner.setAdapter(bloodGroupSpinnerAdapter);

        gravidaSpinner = findViewById(R.id.gravidaSpinner);
        livingSpinner = findViewById(R.id.livingSpinner);
        String[] gravidaSpinnerItems = new String[]{"0","1","2","3","4","5","6","7","8","9","10"};
        ArrayAdapter<String> gravidaSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, gravidaSpinnerItems);
        gravidaSpinner.setAdapter(gravidaSpinnerAdapter);
        livingSpinner.setAdapter(gravidaSpinnerAdapter);

        gravidaSpinner.setSelection(1);

        bloodGroupPNSpinner = findViewById(R.id.bloodGroupPNSpinner);
        String[] bloodGroupPNSpinnerItems = new String[]{"+","-"};
        ArrayAdapter<String> bloodGroupPNSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, bloodGroupPNSpinnerItems);
        bloodGroupPNSpinner.setAdapter(bloodGroupPNSpinnerAdapter);

        gravidaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView <?> parent, View view, int position, long id) {

                if(position == 0)
                {
                    Toast.makeText(registrationActivity.this, "अवैध मूल्य!", Toast.LENGTH_SHORT).show();
                    gravidaSpinner.setSelection(1);

                }
                else {
                    gravida = Integer.parseInt(gravidaSpinner.getItemAtPosition(position).toString());
                    parity.setText(gravida - 1 + "");
                }
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {

            }
        });

        
        livingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView <?> parent, View view, int position, long id) {

                living = Integer.parseInt(livingSpinner.getItemAtPosition(position).toString());
                if (Integer.parseInt(parity.getText().toString()) < living) {

                    Toast.makeText(registrationActivity.this, "जीवित बच्चों का अवैध मूल्य!", Toast.LENGTH_SHORT).show();
                    livingSpinner.setSelection(0);
                    
                } else if (Integer.parseInt(parity.getText().toString()) !=0) {
                    aborted.setText(Integer.parseInt(parity.getText().toString())-living  + "");
                }
            }

            @Override
            public void onNothingSelected(AdapterView <?> parent) {

            }
        });
        
        registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shared = registrationActivity.this.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

                SharedPreferences.Editor edit = shared.edit();
                if(NameEdit.getText().toString().length()>0)
                    edit.putString("NameEdit", NameEdit.getText().toString());
                if(mobileEdit.getText().toString().length()>0)
                    edit.putString("mobileEdit", mobileEdit.getText().toString());
                if(StateEdit.getText().toString().length()>0)
                    edit.putString("StateEdit", StateEdit.getText().toString());
                if(AddressEdit.getText().toString().length()>0)
                    edit.putString("AddressEdit", AddressEdit.getText().toString());
                if(weightEdit.getText().toString().length()>0)
                    edit.putString("weightEdit", weightEdit.getText().toString());
                if(FirstContactNameEdit.getText().toString().length()>0)
                    edit.putString("FirstContactNameEdit", FirstContactNameEdit.getText().toString());
                if(FirstContactMobileEdit.getText().toString().length()>0)
                    edit.putString("FirstContactMobileEdit", FirstContactMobileEdit.getText().toString());
                if(dateText.getText().toString().length()>0)
                    edit.putString("dateLinear", dateText.getText().toString());

                edit.putString("CitySpinner", ""+CitySpinner.getSelectedItemPosition());
                edit.putString("bloodGroupSpinner", ""+bloodGroupSpinner.getSelectedItemPosition());
                edit.putString("bloodGroupPNSpinner", ""+bloodGroupPNSpinner.getSelectedItemPosition());
                edit.putString("lastMissedMenstruation",menstrualMissDate.getText().toString());
                edit.apply();

                Intent i = new Intent(registrationActivity.this,MainActivity.class);
                startActivity(i);


            }
        });
        SharedPreferences shared = registrationActivity.this.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        if(shared.contains("NameEdit"))
            NameEdit.setText(shared.getString("NameEdit", ""));
        if(shared.contains("mobileEdit"))
            mobileEdit.setText(shared.getString("mobileEdit", ""));
        if(shared.contains("StateEdit"))
            StateEdit.setText(shared.getString("StateEdit", ""));
        if(shared.contains("AddressEdit"))
            AddressEdit.setText(shared.getString("AddressEdit", ""));
        if(shared.contains("weightEdit"))
            weightEdit.setText(shared.getString("weightEdit", ""));
        if(shared.contains("FirstContactNameEdit"))
            FirstContactNameEdit.setText(shared.getString("FirstContactNameEdit", ""));
        if(shared.contains("FirstContactMobileEdit"))
            FirstContactMobileEdit.setText(shared.getString("FirstContactMobileEdit", ""));

        if(shared.contains("dateLinear"))
            dateText.setText(shared.getString("dateLinear", ""));

        if(shared.contains("lastMissedMenstruation"))
        {
            menstrualMissDate.setText(shared.getString("lastMissedMenstruation", ""));
        }



    }

}
