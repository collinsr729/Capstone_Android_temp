package com.example.myapplication;

public class Group {
    String driverID, startTime, riders;
    String startLocation, endLocation;
    static int movinUp = 0;
    public Group(){
        driverID = "driver"+ ++movinUp;
        startTime = ""+(int) (Math.random()*8+8);
        int n = (int) Math.round(Math.random()*8);
        if(n>5)
            startLocation = "SUNY Oswego";
        else if(n>3)
            startLocation = "Syracuse";
        else if(n>1)
            startLocation = "Walmart";
        else
            startLocation = "McDonald's";

        if(n>5)
            endLocation = "Syracuse";
        else if(n>3)
            endLocation = "SUNY Oswego";
        else if(n>1)
            endLocation = "SUNY Oswego";
        else
            endLocation = "Walmart";

        riders = "" +(int)(Math.random()*4);
    }
}
