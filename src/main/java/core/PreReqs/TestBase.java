package core.PreReqs;

import core.general.MainCall;

import java.sql.SQLException;

public class TestBase {
    public TestBase(){}

    public static void setup(){
        MainCall.setupPreReqs();
    }

    public static void PreReqs() throws SQLException {
//        Add Preferences
        TestPage.addPreference();

//        Get Itineraries
        TestPage.getItinerary("1234");


    }

}
