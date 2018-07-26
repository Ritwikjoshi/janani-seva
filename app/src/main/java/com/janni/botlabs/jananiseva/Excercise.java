package com.janni.botlabs.jananiseva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Excercise extends AppCompatActivity {

    TextView excercisetv1,excercisetv2,excercisetv3,excercisetv4,excercisetv5,excercisetv6,excercisetv7,excercisetv8;
    LinearLayout excerciseInfo1,excerciseInfo2,excerciseInfo3,excerciseInfo4,excerciseInfo5,excerciseInfo6,excerciseInfo7,excerciseInfo8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_excercise);

        excercisetv1 = findViewById(R.id.excercisetv1);
        excercisetv2 = findViewById(R.id.excercisetv2);
        excercisetv3 = findViewById(R.id.excercisetv3);
        excercisetv4 = findViewById(R.id.excercisetv4);
        excercisetv5 = findViewById(R.id.excercisetv5);
        excercisetv6 = findViewById(R.id.excercisetv6);
        excercisetv7 = findViewById(R.id.excercisetv7);
        excercisetv8 = findViewById(R.id.excercisetv8);

        excerciseInfo1 = findViewById(R.id.excerciseinfo1);
        excerciseInfo2 = findViewById(R.id.excerciseinfo2);
        excerciseInfo3 = findViewById(R.id.excerciseinfo3);
        excerciseInfo4 = findViewById(R.id.excerciseinfo4);
        excerciseInfo5 = findViewById(R.id.excerciseinfo5);
        excerciseInfo6 = findViewById(R.id.excerciseinfo6);
        excerciseInfo7 = findViewById(R.id.excerciseinfo7);
        excerciseInfo8 = findViewById(R.id.excerciseinfo8);

        excerciseInfo1.setVisibility(View.GONE);
        excerciseInfo2.setVisibility(View.GONE);
        excerciseInfo3.setVisibility(View.GONE);
        excerciseInfo4.setVisibility(View.GONE);
        excerciseInfo5.setVisibility(View.GONE);
        excerciseInfo6.setVisibility(View.GONE);
        excerciseInfo7.setVisibility(View.GONE);
        excerciseInfo8.setVisibility(View.GONE);

        excercisetv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(excerciseInfo1.getVisibility() == View.VISIBLE)
                {
                    excerciseInfo1.setVisibility(View.GONE);
                    excerciseInfo2.setVisibility(View.GONE);
                    excerciseInfo3.setVisibility(View.GONE);
                    excerciseInfo4.setVisibility(View.GONE);
                    excerciseInfo5.setVisibility(View.GONE);
                    excerciseInfo6.setVisibility(View.GONE);
                    excerciseInfo7.setVisibility(View.GONE);
                    excerciseInfo8.setVisibility(View.GONE);
                }else
                {
                    excerciseInfo1.setVisibility(View.VISIBLE);
                    excerciseInfo2.setVisibility(View.GONE);
                    excerciseInfo3.setVisibility(View.GONE);
                    excerciseInfo4.setVisibility(View.GONE);
                    excerciseInfo5.setVisibility(View.GONE);
                    excerciseInfo6.setVisibility(View.GONE);
                    excerciseInfo7.setVisibility(View.GONE);
                    excerciseInfo8.setVisibility(View.GONE);
                }
            }
        });

        excercisetv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(excerciseInfo2.getVisibility() == View.VISIBLE)
                {
                    excerciseInfo1.setVisibility(View.GONE);
                    excerciseInfo2.setVisibility(View.GONE);
                    excerciseInfo3.setVisibility(View.GONE);
                    excerciseInfo4.setVisibility(View.GONE);
                    excerciseInfo5.setVisibility(View.GONE);
                    excerciseInfo6.setVisibility(View.GONE);
                    excerciseInfo7.setVisibility(View.GONE);
                    excerciseInfo8.setVisibility(View.GONE);
                }else
                {
                    excerciseInfo1.setVisibility(View.GONE);
                    excerciseInfo2.setVisibility(View.VISIBLE);
                    excerciseInfo3.setVisibility(View.GONE);
                    excerciseInfo4.setVisibility(View.GONE);
                    excerciseInfo5.setVisibility(View.GONE);
                    excerciseInfo6.setVisibility(View.GONE);
                    excerciseInfo7.setVisibility(View.GONE);
                    excerciseInfo8.setVisibility(View.GONE);
                }
            }
        });

        excercisetv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(excerciseInfo3.getVisibility() == View.VISIBLE)
                {
                    excerciseInfo1.setVisibility(View.GONE);
                    excerciseInfo2.setVisibility(View.GONE);
                    excerciseInfo3.setVisibility(View.GONE);
                    excerciseInfo4.setVisibility(View.GONE);
                    excerciseInfo5.setVisibility(View.GONE);
                    excerciseInfo6.setVisibility(View.GONE);
                    excerciseInfo7.setVisibility(View.GONE);
                    excerciseInfo8.setVisibility(View.GONE);
                }else
                {
                    excerciseInfo1.setVisibility(View.GONE);
                    excerciseInfo2.setVisibility(View.GONE);
                    excerciseInfo3.setVisibility(View.VISIBLE);
                    excerciseInfo4.setVisibility(View.GONE);
                    excerciseInfo5.setVisibility(View.GONE);
                    excerciseInfo6.setVisibility(View.GONE);
                    excerciseInfo7.setVisibility(View.GONE);
                    excerciseInfo8.setVisibility(View.GONE);
                }
            }
        });

        excercisetv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(excerciseInfo4.getVisibility() == View.VISIBLE)
                {
                    excerciseInfo1.setVisibility(View.GONE);
                    excerciseInfo2.setVisibility(View.GONE);
                    excerciseInfo3.setVisibility(View.GONE);
                    excerciseInfo4.setVisibility(View.GONE);
                    excerciseInfo5.setVisibility(View.GONE);
                    excerciseInfo6.setVisibility(View.GONE);
                    excerciseInfo7.setVisibility(View.GONE);
                    excerciseInfo8.setVisibility(View.GONE);
                }else
                {
                    excerciseInfo1.setVisibility(View.GONE);
                    excerciseInfo2.setVisibility(View.GONE);
                    excerciseInfo3.setVisibility(View.GONE);
                    excerciseInfo4.setVisibility(View.VISIBLE);
                    excerciseInfo5.setVisibility(View.GONE);
                    excerciseInfo6.setVisibility(View.GONE);
                    excerciseInfo7.setVisibility(View.GONE);
                    excerciseInfo8.setVisibility(View.GONE);
                }
            }
        });

        excercisetv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(excerciseInfo5.getVisibility() == View.VISIBLE)
                {
                    excerciseInfo1.setVisibility(View.GONE);
                    excerciseInfo2.setVisibility(View.GONE);
                    excerciseInfo3.setVisibility(View.GONE);
                    excerciseInfo4.setVisibility(View.GONE);
                    excerciseInfo5.setVisibility(View.GONE);
                    excerciseInfo6.setVisibility(View.GONE);
                    excerciseInfo7.setVisibility(View.GONE);
                    excerciseInfo8.setVisibility(View.GONE);
                }else
                {
                    excerciseInfo1.setVisibility(View.GONE);
                    excerciseInfo2.setVisibility(View.GONE);
                    excerciseInfo3.setVisibility(View.GONE);
                    excerciseInfo4.setVisibility(View.GONE);
                    excerciseInfo5.setVisibility(View.VISIBLE);
                    excerciseInfo6.setVisibility(View.GONE);
                    excerciseInfo7.setVisibility(View.GONE);
                    excerciseInfo8.setVisibility(View.GONE);
                }
            }
        });

        excercisetv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(excerciseInfo6.getVisibility() == View.VISIBLE)
                {
                    excerciseInfo1.setVisibility(View.GONE);
                    excerciseInfo2.setVisibility(View.GONE);
                    excerciseInfo3.setVisibility(View.GONE);
                    excerciseInfo4.setVisibility(View.GONE);
                    excerciseInfo5.setVisibility(View.GONE);
                    excerciseInfo6.setVisibility(View.GONE);
                    excerciseInfo7.setVisibility(View.GONE);
                    excerciseInfo8.setVisibility(View.GONE);
                }else
                {
                    excerciseInfo1.setVisibility(View.GONE);
                    excerciseInfo2.setVisibility(View.GONE);
                    excerciseInfo3.setVisibility(View.GONE);
                    excerciseInfo4.setVisibility(View.GONE);
                    excerciseInfo5.setVisibility(View.GONE);
                    excerciseInfo6.setVisibility(View.VISIBLE);
                    excerciseInfo7.setVisibility(View.GONE);
                    excerciseInfo8.setVisibility(View.GONE);
                }
            }
        });

        excercisetv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(excerciseInfo7.getVisibility() == View.VISIBLE)
                {
                    excerciseInfo1.setVisibility(View.GONE);
                    excerciseInfo2.setVisibility(View.GONE);
                    excerciseInfo3.setVisibility(View.GONE);
                    excerciseInfo4.setVisibility(View.GONE);
                    excerciseInfo5.setVisibility(View.GONE);
                    excerciseInfo6.setVisibility(View.GONE);
                    excerciseInfo7.setVisibility(View.GONE);
                    excerciseInfo8.setVisibility(View.GONE);
                }else
                {
                    excerciseInfo1.setVisibility(View.GONE);
                    excerciseInfo2.setVisibility(View.GONE);
                    excerciseInfo3.setVisibility(View.GONE);
                    excerciseInfo4.setVisibility(View.GONE);
                    excerciseInfo5.setVisibility(View.GONE);
                    excerciseInfo6.setVisibility(View.GONE);
                    excerciseInfo7.setVisibility(View.VISIBLE);
                    excerciseInfo8.setVisibility(View.GONE);
                }
            }
        });

        excercisetv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(excerciseInfo8.getVisibility() == View.VISIBLE)
                {
                    excerciseInfo1.setVisibility(View.GONE);
                    excerciseInfo2.setVisibility(View.GONE);
                    excerciseInfo3.setVisibility(View.GONE);
                    excerciseInfo4.setVisibility(View.GONE);
                    excerciseInfo5.setVisibility(View.GONE);
                    excerciseInfo6.setVisibility(View.GONE);
                    excerciseInfo7.setVisibility(View.GONE);
                    excerciseInfo8.setVisibility(View.GONE);
                }else
                {
                    excerciseInfo1.setVisibility(View.GONE);
                    excerciseInfo2.setVisibility(View.GONE);
                    excerciseInfo3.setVisibility(View.GONE);
                    excerciseInfo4.setVisibility(View.GONE);
                    excerciseInfo5.setVisibility(View.GONE);
                    excerciseInfo6.setVisibility(View.GONE);
                    excerciseInfo7.setVisibility(View.GONE);
                    excerciseInfo8.setVisibility(View.VISIBLE);
                }
            }
        });



    }
}
