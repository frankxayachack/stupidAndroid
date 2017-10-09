package vn.edu.fpt.pe_carbooking.app;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends Activity {

    Button btnCarBookingRequest;
    Button btnCarBookingList;
    public static List<CarBooking> LstCars;
    public static JSONArray carBookingJSONArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LstCars = new ArrayList<CarBooking>();
        carBookingJSONArray = new JSONArray();

        btnCarBookingRequest = (Button)findViewById(R.id.btnCarBookingRequest);
        btnCarBookingList = (Button)findViewById(R.id.btnCarBookingList);

        btnCarBookingRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,CarBookingReqActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        btnCarBookingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,CarBookingListActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
