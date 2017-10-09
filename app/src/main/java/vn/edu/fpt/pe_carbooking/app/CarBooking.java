package vn.edu.fpt.pe_carbooking.app;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by co.anhbn on 11/24/2016.
 */
public class CarBooking {
    private int BId;
    private String StaffId;
    private String StaffName;
    private String Department;
    private String ReasonUse; //explain the reason why staff need car booking for their work
    private Date ReqDate; //request date from staff
    private String ReqTime;
    private Date AnsDate; //answer date from their manager
    private int NoOfSeat; //number of needed seats
    private String Place; //the place where the car pickup staff
    private int Status; //status of booking
                        //0: not seen yet
                        //-1: rejected for request
                        //1: approved for request
                        //>1: in progress

    public CarBooking() {
    }

    //constructor without Answer date information
    public CarBooking(int BId, String staffId, String staffName, String department, String reasonUse, Date reqDate, String reqTime, int noOfSeat, String place, int status) {
        this.BId = BId;
        StaffId = staffId;
        StaffName = staffName;
        Department = department;
        ReasonUse = reasonUse;
        ReqDate = reqDate;
        ReqTime = reqTime;
        NoOfSeat = noOfSeat;
        Place = place;
        Status = status;
    }

    public CarBooking(int BId, String staffId, String staffName, String department, String reasonUse, Date reqDate, String reqTime, Date ansDate, int noOfSeat, String place, int status) {
        this.BId = BId;
        StaffId = staffId;
        StaffName = staffName;
        Department = department;
        ReasonUse = reasonUse;
        ReqDate = reqDate;
        ReqTime = reqTime;
        AnsDate = ansDate;
        NoOfSeat = noOfSeat;
        Place = place;
        Status = status;
    }


    public int getBId() {
        return BId;
    }

    public void setBId(int BId) {
        this.BId = BId;
    }

    public String getStaffId() {
        return StaffId;
    }

    public void setStaffId(String staffId) {
        StaffId = staffId;
    }

    public String getStaffName() {
        return StaffName;
    }

    public void setStaffName(String staffName) {
        StaffName = staffName;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getReasonUse() {
        return ReasonUse;
    }

    public void setReasonUse(String reasonUse) {
        ReasonUse = reasonUse;
    }

    public Date getReqDate() {
        return ReqDate;
    }

    public void setReqDate(Date reqDate) {
        ReqDate = reqDate;
    }

    public String getReqTime() {
        return ReqTime;
    }

    public void setReqTime(String reqTime) {
        ReqTime = reqTime;
    }

    public Date getAnsDate() {
        return AnsDate;
    }

    public void setAnsDate(Date ansDate) {
        AnsDate = ansDate;
    }

    public int getNoOfSeat() {
        return NoOfSeat;
    }

    public void setNoOfSeat(int noOfSeat) {
        NoOfSeat = noOfSeat;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "CarBooking{" +
                "BId=" + BId +
                ", StaffId='" + StaffId + '\'' +
                ", StaffName='" + StaffName + '\'' +
                ", Department='" + Department + '\'' +
                ", ReasonUse='" + ReasonUse + '\'' +
                ", ReqDate=" + ReqDate +
                ", ReqTime='" + ReqTime + '\'' +
                ", AnsDate=" + AnsDate +
                ", NoOfSeat=" + NoOfSeat +
                ", Place='" + Place + '\'' +
                ", Status=" + Status +
                '}';
    }

    public HashMap<String, String> toHashMap(){
        HashMap<String, String> h = new HashMap<String, String>();
        h.put("Bid", ""+BId);
        h.put("StaffId", StaffId);
        h.put("StaffName", StaffName);
        h.put("Department", Department);
        h.put("ReasonUse", ReasonUse);
        h.put("ReqDate", ReqDate.toString());
        h.put("ReqTime", ReqTime);
        h.put("NoOfSeat", ""+NoOfSeat);
        h.put("Place", Place);
        h.put("Status", ""+Status);
        return h;
    }
}
