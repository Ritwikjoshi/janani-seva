package com.janni.botlabs.jananiseva;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by BD on 20-03-2018.
 */

public class ThirdTrimester extends android.app.Fragment {

    TextView scan1,scan2,scan3,scan5,scan6,scan7,scan8,scantv1,scantv2,scantv3,scantv5,scantv6,scantv7,scantv8;
    View ttri;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ttri = inflater.inflate(R.layout.third_trimester, container, false);
        scan1 = ttri
.findViewById(R.id.scan1);
        scan2 = ttri.findViewById(R.id.scan2);
        scan3 = ttri.findViewById(R.id.scan3);
        scan6 = ttri.findViewById(R.id.scan6);
        scan7 = ttri.findViewById(R.id.scan7);
        scan8 = ttri.findViewById(R.id.scan8);


        scantv1 = ttri.findViewById(R.id.scantv1);
        scantv2 = ttri.findViewById(R.id.scantv2);
        scantv3 = ttri.findViewById(R.id.scantv3);
        scantv6 = ttri.findViewById(R.id.scantv6);
        scantv7 = ttri.findViewById(R.id.scantv7);
        scantv8 = ttri.findViewById(R.id.scantv8);

        scan2.setVisibility(View.GONE);
        scan1.setVisibility(View.GONE);
        scan3.setVisibility(View.GONE);
        scan6.setVisibility(View.GONE);
        scan7.setVisibility(View.GONE);
        scan8.setVisibility(View.GONE);

        scantv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scan1.getVisibility() == scan1.VISIBLE) {
                    scan1.setVisibility(View.GONE);
                    scan2.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan6.setVisibility(View.GONE);
                    scan7.setVisibility(View.GONE);
                    scan8.setVisibility(View.GONE);
                }
                else{
                    scan1.setVisibility(View.VISIBLE);
                    scan2.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan6.setVisibility(View.GONE);
                    scan7.setVisibility(View.GONE);
                    scan8.setVisibility(View.GONE);
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
                    scan6.setVisibility(View.GONE);
                    scan7.setVisibility(View.GONE);
                    scan8.setVisibility(View.GONE);
                }
                else{
                    scan2.setVisibility(View.VISIBLE);
                    scan1.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan6.setVisibility(View.GONE);
                    scan7.setVisibility(View.GONE);
                    scan8.setVisibility(View.GONE);
                }
            }
        });

        scantv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scan3.getVisibility() == scan3.VISIBLE) {
                    scan2.setVisibility(View.GONE);
                    scan1.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan6.setVisibility(View.GONE);
                    scan7.setVisibility(View.GONE);
                    scan8.setVisibility(View.GONE);
                }
                else{
                    scan3.setVisibility(View.VISIBLE);
                    scan1.setVisibility(View.GONE);
                    scan2.setVisibility(View.GONE);
                    scan6.setVisibility(View.GONE);
                    scan7.setVisibility(View.GONE);
                    scan8.setVisibility(View.GONE);
                }
            }
        });

        scantv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scan6.getVisibility() == scan6.VISIBLE) {
                    scan2.setVisibility(View.GONE);
                    scan1.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan6.setVisibility(View.GONE);
                    scan7.setVisibility(View.GONE);
                    scan8.setVisibility(View.GONE);
                }
                else{
                    scan6.setVisibility(View.VISIBLE);
                    scan1.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan2.setVisibility(View.GONE);
                    scan7.setVisibility(View.GONE);
                    scan8.setVisibility(View.GONE);
                }
            }
        });

        scantv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scan7.getVisibility() == scan7.VISIBLE) {
                    scan2.setVisibility(View.GONE);
                    scan1.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan6.setVisibility(View.GONE);
                    scan7.setVisibility(View.GONE);
                    scan8.setVisibility(View.GONE);
                }
                else{
                    scan7.setVisibility(View.VISIBLE);
                    scan1.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan6.setVisibility(View.GONE);
                    scan2.setVisibility(View.GONE);
                    scan8.setVisibility(View.GONE);
                }
            }
        });

        scantv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scan8.getVisibility() == scan8.VISIBLE) {
                    scan2.setVisibility(View.GONE);
                    scan1.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan6.setVisibility(View.GONE);
                    scan7.setVisibility(View.GONE);
                    scan8.setVisibility(View.GONE);
                }
                else{
                    scan8.setVisibility(View.VISIBLE);
                    scan1.setVisibility(View.GONE);
                    scan3.setVisibility(View.GONE);
                    scan6.setVisibility(View.GONE);
                    scan7.setVisibility(View.GONE);
                    scan2.setVisibility(View.GONE);
                }
            }
        });
        return ttri;
    }
}
