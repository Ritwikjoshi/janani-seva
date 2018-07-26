package com.janni.botlabs.jananiseva;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by BD on 20-03-2018.
 */

public class FirstTrimester extends android.app.Fragment {

    View book;
    TextView scan1,scan2,scan3,scan4,scantv1,scantv2,scantv3,scantv4,scantv5;
    LinearLayout scan5;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        book = inflater.inflate(R.layout.first_trimester, container, false);

        scan1 = book.findViewById(R.id.scan1);
        scan2 = book.findViewById(R.id.scan2);
        scan3 = book.findViewById(R.id.scan3);
        scan5 = book.findViewById(R.id.scan5);

        scantv1 = book.findViewById(R.id.scantv1);
        scantv2 = book.findViewById(R.id.scantv2);
        scantv3 = book.findViewById(R.id.scantv3);
        scantv5 = book.findViewById(R.id.scantv5);

        scan1.setVisibility(View.GONE);
        scan2.setVisibility(View.GONE);
        scan3.setVisibility(View.GONE);
        scan5.setVisibility(View.GONE);

        scantv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scan1.getVisibility() == scan1.VISIBLE) {
                    scan1.setVisibility(View.GONE);
                    scan2.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan5.setVisibility(View.GONE);
                }
                else{
                    scan1.setVisibility(View.VISIBLE);
                    scan2.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan5.setVisibility(View.GONE);
                }
            }
        });

        scantv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scan2.getVisibility() == scan2.VISIBLE) {
                    scan2.setVisibility(View.GONE);
                    scan1.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan5.setVisibility(View.GONE);
                }
                else{
                    scan2.setVisibility(View.VISIBLE);
                    scan1.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan5.setVisibility(View.GONE);
                }
            }
        });

        scantv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scan3.getVisibility() == scan1.VISIBLE) {
                    scan1.setVisibility(View.GONE);
                    scan2.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan5.setVisibility(View.GONE);
                }
                else{
                    scan3.setVisibility(View.VISIBLE);
                    scan2.setVisibility(View.GONE);
                    scan1.setVisibility(View.GONE);
                    scan5.setVisibility(View.GONE);
                }
            }
        });

        scantv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scan5.getVisibility() == scan1.VISIBLE) {
                    scan1.setVisibility(View.GONE);
                    scan2.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan5.setVisibility(View.GONE);
                }
                else{
                    scan5.setVisibility(View.VISIBLE);
                    scan2.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan1.setVisibility(View.GONE);
                }
            }
        });

        return book;
    }

}
