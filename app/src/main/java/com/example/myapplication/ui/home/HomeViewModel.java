package com.example.myapplication.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.Arrays;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private ArrayList<Group> cars;
    static int movinUp = 0;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        cars = getGroups();
        mText.setValue(Arrays.toString(cars.toArray()));
        //"FUCK I keep screwin up");
    }

    public LiveData<String> getText() {
        return mText;

    }

    public ArrayList<Group> getGroups(){
//        for(all database info)
        return fillFakeGroups(10);
    }
    public String getOne(int indx){
//        for(all database info)
        return cars.get(indx).toString();
    }

    public ArrayList<Group> fillFakeGroups(int i){
        ArrayList<Group> groups = new ArrayList<Group>();
        for (int j = 0; j < i; j++) {
            groups.add(new Group());
        }
        return groups;
    }
    public class Group {
        String driverID, startTime, riders;
        String startLocation, endLocation;

        public Group() {
            driverID = "driver" + ++movinUp;
            startTime = "" + (int) (Math.random() * 8 + 8);
            int n = (int) Math.round(Math.random() * 8);
            if (n > 5)
                startLocation = "SUNY Oswego";
            else if (n > 3)
                startLocation = "Syracuse";
            else if (n > 1)
                startLocation = "Walmart";
            else
                startLocation = "McDonald's";

            if (n > 5)
                endLocation = "Syracuse";
            else if (n > 3)
                endLocation = "SUNY Oswego";
            else if (n > 1)
                endLocation = "SUNY Oswego";
            else
                endLocation = "Walmart";

            riders = "" + (int) (Math.random() * 4);
        }
        @Override
        public String toString(){
            return driverID+"\nTime:"+startTime+"\nFrom "+startLocation+"    To "+endLocation+"\n";
        }
    }
}