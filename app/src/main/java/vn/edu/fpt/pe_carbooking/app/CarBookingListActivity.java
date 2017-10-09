package vn.edu.fpt.pe_carbooking.app;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class CarBookingListActivity extends Activity {

    public List<HashMap<String, String>> LstCars;
    ListView lvJson;
    JSONObject oneJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_booking_list);

        lvJson = (ListView)findViewById(R.id.lstCarBooking);

        LstCars = new ArrayList<HashMap<String, String>>();

        new getBooking().execute();

    }

    private class getBooking extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            LstCars.clear();

            for(int i=0; i<MainActivity.carBookingJSONArray.length();i++){
                try {
                    oneJSON = MainActivity.carBookingJSONArray.getJSONObject(i);
                    int BId = oneJSON.getInt("BId");
                    String StaffId = oneJSON.getString("StaffId");
                    String StaffName = oneJSON.getString("StaffName");
                    String Department = oneJSON.getString("Department");
                    int NoOfSeat = oneJSON.getInt("NoOfSeat");
                    String UseCarFor = oneJSON.getString("UseCarFor");
                    Date Date = new Date(oneJSON.getString("Date"));
                    String Time = oneJSON.getString("Time");
                    String Place = oneJSON.getString("Place");
                    int Status = oneJSON.getInt("Status");
                    CarBooking cb = new CarBooking();
                    cb.setBId(BId);
                    cb.setStaffId(StaffId);
                    cb.setStaffName(StaffName);
                    cb.setDepartment(Department);
                    cb.setNoOfSeat(NoOfSeat);
                    cb.setReasonUse(UseCarFor);
                    cb.setReqDate(Date);
                    cb.setReqTime(Time);
                    cb.setPlace(Place);
                    cb.setStatus(Status);
                    LstCars.add(cb.toHashMap());
                }catch(Exception ex){
                    Log.e("error: ", ex.getMessage());
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ListAdapter adapter = new SimpleAdapter(CarBookingListActivity.this, LstCars, R.layout.simple_list_item_1,
                    new String[] { "Bid", "StaffId" },
                    new int[]{R.id.tvBIdList, R.id.tvStaffIdList});
                    lvJson.setAdapter(adapter);
        }
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
