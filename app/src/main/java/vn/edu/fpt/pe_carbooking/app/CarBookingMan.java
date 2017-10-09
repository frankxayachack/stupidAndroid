package vn.edu.fpt.pe_carbooking.app;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sengx on 10/9/2017.
 */

public class CarBookingMan {


    public CarBookingMan(){}

    public static void AddNewRequest(JSONObject obj){
        MainActivity.carBookingJSONArray.put(obj);
    }

    public CarBooking ListReqsOfOneStaff(int BId)
    {
        for(int i=0;i<MainActivity.LstCars.size();i++)
        {
            if(MainActivity.LstCars.get(i).getBId() == BId){
                return MainActivity.LstCars.get(i);
            }
        }
        return null;
    }

}
