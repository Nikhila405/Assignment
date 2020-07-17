package com.example.covid19;

public class Details {
    private String Active, Death, Recovered, Date;

    public Details(String Active, String Death , String Recovered, String Date) {
        this.Active = Active;
        this.Death = Death;
        this.Recovered = Recovered;
        this.Date = Date;

    }
    public String getActive(){

        return Active;
    }

    public String getDeath() {

        return Death;
    }

    public String getRecovered() {

        return Recovered;
    }

    public String getDate(){

        return Date;
    }
}
