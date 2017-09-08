package com.example.khutsomatlala.hackaton_user11;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Date;
import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.N)
public class DetailActivity extends Activity {


//        try {


    String call;
    String lat;
    String lon;
    String PlaceName;
    String infor;
    String address;
    String hours;
    String pic;

    ImageView middlePic;
    TextView   txtInformation, txtAddress, txtCell, txtHours;

    private CollapsingToolbarLayout collapsingToolbarLayout = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();

        lat = i.getStringExtra("lat");
        lon = i.getStringExtra("lon");
        call = i.getStringExtra("call");
        PlaceName = i.getStringExtra("name");
        infor = i.getStringExtra("infor");
        address = i.getStringExtra("address");
        hours = i.getStringExtra("hours");
        pic = i.getStringExtra("pic");


        txtInformation =  findViewById(R.id.txtInformation);
        txtAddress =   findViewById(R.id.txtAddress);
        txtCell =   findViewById(R.id.txtCell);
        txtHours =  findViewById(R.id.txtHours);

        middlePic =  findViewById(R.id.middlePic);

        Glide.with(this)
                .load(pic)
                //  .override(300, 200)
                .centerCrop()
                .into(middlePic);


        collapsingToolbarLayout =  findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(PlaceName);

        txtInformation.setText("Description - " + infor);
        txtAddress.setText("Address - " + address);
        txtCell.setText("Cell - " + call);
        txtHours.setText("operating hours - " + hours);

    }

    public void Call(View view) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + call));
        startActivity(intent);
    }

    public void direction(View view) {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);

        intent.putExtra("lat", lat);
        intent.putExtra("lon", lon);
        intent.putExtra("name", PlaceName);
        startActivity(intent);
    }

    public void GoToBook(View view){

         Intent i = new Intent(getApplicationContext(),BookActivity.class);
         i.putExtra("pic",pic);
         startActivity(i);

    }

}
