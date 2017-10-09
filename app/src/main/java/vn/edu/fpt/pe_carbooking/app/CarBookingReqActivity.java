package vn.edu.fpt.pe_carbooking.app;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.DatePickerDialog;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.Random;


public class CarBookingReqActivity extends Activity {

    private EditText edStaffId;
    private EditText edStaffName;
    private EditText edDepartment;
    private EditText edDate;
    private EditText edTime;
    private EditText edUseCarFor;
    private EditText edNoOfSeat;
    private EditText edPlace;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextView tvDate;
    private ImageButton btnDate;
    private ImageButton btnTime;
    private Button btnSendReq;
    private Button btnReset;
    private Button btnViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_booking_req);
        edStaffId = (EditText)findViewById(R.id.edStaffId);
        edStaffName = (EditText)findViewById(R.id.edStaffName);
        edDepartment = (EditText) findViewById(R.id.edDepartment);
        edNoOfSeat = (EditText) findViewById(R.id.edNoOfSeat);
        edPlace = (EditText) findViewById(R.id.edPlace);
        edDate = (EditText)findViewById(R.id.edDate);
        edTime = (EditText)findViewById(R.id.edTime);
        edUseCarFor = (EditText)findViewById(R.id.edUseCarFor);
        tvDate = (TextView)findViewById(R.id.tvDate);
        btnDate = (ImageButton)findViewById(R.id.btnDate);
        btnTime = (ImageButton)findViewById(R.id.btnTime);
        btnSendReq = (Button)findViewById(R.id.btnSendRequest);
        btnReset = (Button)findViewById(R.id.btnReset);
        btnViewList = (Button)findViewById(R.id.btnViewList);

        btnSendReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject obj = new JSONObject();

                try {
                    obj.put("BId", new Integer(MainActivity.LstCars.size() + 1));
                    obj.put("StaffId", edStaffId.getText().toString());
                    obj.put("StaffName", edStaffName.getText().toString());
                    obj.put("Department", edDepartment.getText().toString());
                    obj.put("NoOfSeat", Integer.parseInt(edNoOfSeat.getText().toString()));
                    obj.put("UseCarFor", edUseCarFor.getText().toString());
                    obj.put("Date", edDate.getText().toString());
                    obj.put("Time", edTime.getText().toString());
                    obj.put("Place", edPlace.getText().toString());
                    obj.put("Status", new Random().nextInt(3 - 1 + 1) + 1);
                    CarBookingMan.AddNewRequest(obj);
                    edStaffId.setText("");
                    edStaffName.setText("");
                    edDepartment.setText("");
                    edNoOfSeat.setText("");
                    edUseCarFor.setText("");
                    edDate.setText("");
                    edTime.setText("");
                    edPlace.setText("");
                    Log.e("XXX: ", MainActivity.carBookingJSONArray.toString());
                }catch (Exception ex)
                {
                    Log.e("Error: ", ex.getMessage());
                }
            }
        });

        btnViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(),CarBookingListActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(myIntent);
            }
        });

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        CarBookingReqActivity.this,
                        android.R.style.Theme_DeviceDefault,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getDatePicker().setCalendarViewShown(false);
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month+1;
                edDate.setText(day + "/" + month + "/" + year);
            }
        };

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(CarBookingReqActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        edTime.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
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
