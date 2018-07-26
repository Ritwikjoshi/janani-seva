package com.janni.botlabs.jananiseva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WarningSigns extends AppCompatActivity {

    TextView warning1,warning2,warning3,warning4,warning5,warning6,warning7;
    LinearLayout info1,info2,info3,info4,info5,info6,info7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning_signs);

        warning1 = findViewById(R.id.signtv1);
        warning2 = findViewById(R.id.signtv2);
        warning3 = findViewById(R.id.signtv3);
        warning4 = findViewById(R.id.signtv4);
        warning5 = findViewById(R.id.signtv5);
        warning6 = findViewById(R.id.signtv6);
        warning7 = findViewById(R.id.signtv7);

        info1 = findViewById(R.id.signinfo1);
        info2 = findViewById(R.id.signinfo2);
        info3 = findViewById(R.id.signinfo3);
        info4 = findViewById(R.id.signinfo4);
        info5 = findViewById(R.id.signinfo5);
        info6 = findViewById(R.id.signinfo6);
        info7 = findViewById(R.id.signinfo7);

        info1.setVisibility(View.GONE);
        info2.setVisibility(View.GONE);
        info3.setVisibility(View.GONE);
        info4.setVisibility(View.GONE);
        info5.setVisibility(View.GONE);
        info6.setVisibility(View.GONE);
        info7.setVisibility(View.GONE);


        warning1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(info1.getVisibility() == View.VISIBLE)
                {
                    info1.setVisibility(View.GONE);
                    info2.setVisibility(View.GONE);
                    info3.setVisibility(View.GONE);
                    info4.setVisibility(View.GONE);
                    info5.setVisibility(View.GONE);
                    info6.setVisibility(View.GONE);
                    info7.setVisibility(View.GONE);
                }
                else
                {
                    info1.setVisibility(View.VISIBLE);
                    info2.setVisibility(View.GONE);
                    info3.setVisibility(View.GONE);
                    info4.setVisibility(View.GONE);
                    info5.setVisibility(View.GONE);
                    info6.setVisibility(View.GONE);
                    info7.setVisibility(View.GONE);
                }
            }
        });

        warning2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(info2.getVisibility() == View.VISIBLE)
                {
                    info1.setVisibility(View.GONE);
                    info2.setVisibility(View.GONE);
                    info3.setVisibility(View.GONE);
                    info4.setVisibility(View.GONE);
                    info5.setVisibility(View.GONE);
                    info6.setVisibility(View.GONE);
                    info7.setVisibility(View.GONE);
                }
                else
                {
                    info1.setVisibility(View.GONE);
                    info2.setVisibility(View.VISIBLE);
                    info3.setVisibility(View.GONE);
                    info4.setVisibility(View.GONE);
                    info5.setVisibility(View.GONE);
                    info6.setVisibility(View.GONE);
                    info7.setVisibility(View.GONE);
                }
            }
        });

        warning3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(info3.getVisibility() == View.VISIBLE)
                {
                    info1.setVisibility(View.GONE);
                    info2.setVisibility(View.GONE);
                    info3.setVisibility(View.GONE);
                    info4.setVisibility(View.GONE);
                    info5.setVisibility(View.GONE);
                    info6.setVisibility(View.GONE);
                    info7.setVisibility(View.GONE);
                }
                else
                {
                    info1.setVisibility(View.GONE);
                    info2.setVisibility(View.GONE);
                    info3.setVisibility(View.VISIBLE);
                    info4.setVisibility(View.GONE);
                    info5.setVisibility(View.GONE);
                    info6.setVisibility(View.GONE);
                    info7.setVisibility(View.GONE);
                }
            }
        });

        warning4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(info4.getVisibility() == View.VISIBLE)
                {
                    info1.setVisibility(View.GONE);
                    info2.setVisibility(View.GONE);
                    info3.setVisibility(View.GONE);
                    info4.setVisibility(View.GONE);
                    info5.setVisibility(View.GONE);
                    info6.setVisibility(View.GONE);
                    info7.setVisibility(View.GONE);
                }
                else
                {
                    info1.setVisibility(View.GONE);
                    info2.setVisibility(View.GONE);
                    info3.setVisibility(View.GONE);
                    info4.setVisibility(View.VISIBLE);
                    info5.setVisibility(View.GONE);
                    info6.setVisibility(View.GONE);
                    info7.setVisibility(View.GONE);
                }
            }
        });

        warning5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(info5.getVisibility() == View.VISIBLE)
                {
                    info1.setVisibility(View.GONE);
                    info2.setVisibility(View.GONE);
                    info3.setVisibility(View.GONE);
                    info4.setVisibility(View.GONE);
                    info5.setVisibility(View.GONE);
                    info6.setVisibility(View.GONE);
                    info7.setVisibility(View.GONE);
                }
                else
                {
                    info1.setVisibility(View.GONE);
                    info2.setVisibility(View.GONE);
                    info3.setVisibility(View.GONE);
                    info4.setVisibility(View.GONE);
                    info5.setVisibility(View.VISIBLE);
                    info6.setVisibility(View.GONE);
                    info7.setVisibility(View.GONE);
                }
            }
        });

        warning6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(info6.getVisibility() == View.VISIBLE)
                {
                    info1.setVisibility(View.GONE);
                    info2.setVisibility(View.GONE);
                    info3.setVisibility(View.GONE);
                    info4.setVisibility(View.GONE);
                    info5.setVisibility(View.GONE);
                    info6.setVisibility(View.GONE);
                    info7.setVisibility(View.GONE);
                }
                else
                {
                    info1.setVisibility(View.GONE);
                    info2.setVisibility(View.GONE);
                    info3.setVisibility(View.GONE);
                    info4.setVisibility(View.GONE);
                    info5.setVisibility(View.GONE);
                    info6.setVisibility(View.VISIBLE);
                    info7.setVisibility(View.GONE);
                }
            }
        });

        warning7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(info7.getVisibility() == View.VISIBLE)
                {
                    info1.setVisibility(View.GONE);
                    info2.setVisibility(View.GONE);
                    info3.setVisibility(View.GONE);
                    info4.setVisibility(View.GONE);
                    info5.setVisibility(View.GONE);
                    info6.setVisibility(View.GONE);
                    info7.setVisibility(View.GONE);
                }
                else
                {
                    info1.setVisibility(View.GONE);
                    info2.setVisibility(View.GONE);
                    info3.setVisibility(View.GONE);
                    info4.setVisibility(View.GONE);
                    info5.setVisibility(View.GONE);
                    info6.setVisibility(View.GONE);
                    info7.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
