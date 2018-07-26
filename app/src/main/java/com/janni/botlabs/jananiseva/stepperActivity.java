package com.janni.botlabs.jananiseva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class stepperActivity extends AppCompatActivity {


    Button prev,next;
    private final int  FIRST = 1, SECOND = 2, THIRD = 3;
    public int TAG = FIRST;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepper);

        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);




        getFragmentManager().beginTransaction().replace(R.id.diagnose,new FirstTrimester()).commit();


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(TAG==FIRST)
                {
                    TAG = THIRD;
                    getFragmentManager().beginTransaction().replace(R.id.diagnose,new ThirdTrimester()).commit();


                }

                else if(TAG==SECOND)
                {
                    TAG = FIRST;
                    getFragmentManager().beginTransaction().replace(R.id.diagnose,new FirstTrimester()).commit();


                }
                else if(TAG == THIRD)
                {
                    TAG = SECOND;
                    getFragmentManager().beginTransaction().replace(R.id.diagnose,new SecondTrimester()).commit();


                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(TAG==FIRST)
                {
                    TAG = SECOND;
                    getFragmentManager().beginTransaction().replace(R.id.diagnose,new SecondTrimester()).commit();

                }

                else if(TAG==SECOND)
                {
                    TAG = THIRD;
                    getFragmentManager().beginTransaction().replace(R.id.diagnose,new ThirdTrimester()).commit();


                }
                else if(TAG == THIRD)
                {
                    TAG = FIRST;
                    getFragmentManager().beginTransaction().replace(R.id.diagnose,new FirstTrimester()).commit();

                }
            }
        });

    }
}
