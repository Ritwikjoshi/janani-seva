package com.janni.botlabs.jananiseva;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton sos;
    CollapsingToolbarLayout collapsingToolbarLayout;
    AppBarLayout appBarLayout;
    CardView Jagrukta,stepper,chatbot,signs,trimVid,excercise;

    Intent call = new Intent(Intent.ACTION_CALL);

    private String number = "9950123753";
    private String number2 = "8005520736";
    private String number3 = "9950123753";
    String link;
    View SOSView;
    private static final int REQUEST_CALL = 1;
    private static final int REQUEST_SMS = 2;
    private String sms;
    GoogleApiClient mGoogleApiClient;
    String coordinates = " ";

    LocationManager locationManager;


    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Jagrukta = findViewById(R.id.jagrukta);
        stepper = findViewById(R.id.stepper);
        collapsingToolbarLayout = findViewById(R.id.collapsing);
        appBarLayout = findViewById(R.id.toolbar);
        chatbot = findViewById(R.id.chatbotTile);
        signs = findViewById(R.id.signs);
        trimVid = findViewById(R.id.trimestervid);
        excercise = findViewById(R.id.excercise);

        getMyLocation();

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS},REQUEST_SMS);
        }
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(MainActivity.this)
                    .addApi(LocationServices.API)
                    .build();
            mGoogleApiClient.connect();
        }


        // code to dissapear name when collapsing layout is open
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle("     जननी सेवा");
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbarLayout.setTitle(" ");//name to show while toolbar is open , be careful if no input then space should be there
                    isShow = false;
                }
            }
        });
//code ends here for collapsing toolbar
        sos = findViewById(R.id.sos);

        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_CALL);
                } else {

                    getMyLocation();
                    Toast.makeText(MainActivity.this,"alert sent",Toast.LENGTH_LONG).show();
                    sms = "सावधान माँ को प्रसव पीड़ा हो रही है, यह मां का सटीक स्थान है।\n"+coordinates +link;
                    SmsManager.getDefault().sendTextMessage(number, null, sms, null, null);
                    if(!number2.equals("")) {
                        SmsManager.getDefault().sendTextMessage(number2,null,sms, null, null);
                    }
                    if(!number3.equals("")) {
                        SmsManager.getDefault().sendTextMessage(number3,null,sms, null, null);
                    }
                }
                call.setData(Uri.parse("tel:+91-800-552-0736"));
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                }else {
                    startActivity(call);
                }
            }
        });

        Jagrukta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,Awareness.class);
                startActivity(i);
            }
        });

        stepper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,stepperActivity.class);
                startActivity(i);
            }
        });

        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ChatBot.class);
                startActivity(i);
            }
        });

        excercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Excercise.class);
                startActivity(i);
            }
        });

    }

    @SuppressLint("MissingPermission")
    private void getMyLocation() {
        locationManager = (LocationManager) MainActivity.this.getSystemService(Context.LOCATION_SERVICE);

        if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new android.location.LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double longitude = location.getLongitude();
                    double lattitude = location.getLatitude();

                   // LatLng latlong = new LatLng(lattitude,longitude);

                    try {

                        Geocoder gcoder = new Geocoder(getApplication());
                        List<Address> adrlist = gcoder.getFromLocation(lattitude,longitude,1);

                        coordinates = "\n"+adrlist.get(0).getSubLocality()+ " "+ adrlist.get(0).getLocality()+", "+adrlist.get(0).getCountryName()+"\n";
                        link = "http://maps.google.com/maps?q=loc:" + String.format("%f,%f", lattitude, longitude);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });

            signs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this,WarningSigns.class);
                    startActivity(i);
                }
            });

            trimVid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this,Jagrukta.class);
                    startActivity(i);
                }
            });
        }

        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new android.location.LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double longitude = location.getLongitude();
                    double lattitude = location.getLatitude();

                    Geocoder gcoder = new Geocoder(getApplicationContext());

                    try {
                        List<Address> adrlist = gcoder.getFromLocation(lattitude,longitude,1);

                        coordinates = "\n"+adrlist.get(0).getSubLocality()+ " "+ adrlist.get(0).getLocality()+", "+adrlist.get(0).getCountryName()+"\n";
                        link = "http://maps.google.com/maps?q=loc:" + String.format("%f,%f", lattitude, longitude);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });
        }

    }
}
