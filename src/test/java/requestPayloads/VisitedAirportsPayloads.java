package requestPayloads;

import core.general.BaseTest;

public class VisitedAirportsPayloads extends BaseTest{
    public VisitedAirportsPayloads(){}

    public static String correctLastUpdatedTime(){
        req = "{\n" +
                "\t\"operationName\": null,\n" +
                "\t\"variables\": {},\n" +
                "\t\"query\": \"{\\n  fetchVisitedAirports(context: \\\"customerapp\\\", lastUpdatedTime: \\\"1515994856000\\\") {\\n    responseHeaderDto {\\n      message\\n      isError\\n      statusCode\\n    }\\n    airports {\\n      id\\n      icao\\n      name\\n      city\\n      country\\n      countryCode\\n    }\\n  }\\n}\"\n" +
                "}";

        return req;
    }

    public static String completeFieldsAndSubFields(){
        req = "{\n" +
                "\t\"operationName\": null,\n" +
                "\t\"variables\": {},\n" +
                "\t\"query\": \"{\\n fetchVisitedAirports(context:\\\"customerapp\\\", lastUpdatedTime: \\\"1515994856000\\\")\\n {\\nresponseHeaderDto\\n{\\n message\\n isError\\n statusCode\\n}\\nairports\\n{\\n id\\n icao\\n name\\n iata\\n iso3\\n iso2\\n city\\n country\\n countryCode\\n city\\n latitude\\n longitude\\n value\\n pfaReviewerDate \\n itineraryAirportName \\n place \\n { \\n\\tid \\n\\tcity \\n\\tcountry \\n\\tdescription \\n\\tflightCount \\n\\tthreeLetterCode \\n\\ttwoLetterCode \\n\\tregion \\n\\tcapital \\n\\ttelCountryCode \\n\\tofficialLanguage \\n\\tcode \\n\\tsymbol \\n\\tname \\n\\tisCreditCardsCompatible \\n\\tregion \\n\\timageUrl \\n\\tnewsFeed \\n } \\n description \\n elevationMetres \\n phoneNumber \\n flightCount \\n imageUrl \\n timezones \\n { \\n\\tid \\n\\tcityList \\n\\tregionName \\n\\tdstUtcOffset \\n\\tstandardUtcOffsetMinutes \\n\\tcode \\n\\tcountryName \\n\\tdstFromTimeUtc \\n\\tdstToTimeUtc \\n\\teffectiveToTimeUtc \\n\\teffectiveFromTimeUtc \\n\\tsource \\n\\tdateCreated \\n\\tairportId \\n } \\n airportCount \\n maxLastUpdatedTime \\n websiteAddress \\n openingTimes \\n { \\n\\tfromDate \\n\\ttoDate \\n\\tstartTimeInSeconds \\n\\tendTimeInSeconds \\n\\tdayOfWeekBitMask \\n\\tairportId \\n } \\n \\n \\n } \\n \\n} }\"\n" +
                "}";

        return req;
    }

    public static String msServerDown(){
        req = "{\n" +
                "\t\"operationName\": null,\n" +
                "\t\"variables\": {},\n" +
                "\t\"query\": \"{\\n  fetchVisitedAirports(context: \\\"customerapp\\\", lastUpdatedTime: \\\"1515994856000\\\") {\\n    responseHeaderDto {\\n      message\\n      isError\\n      statusCode\\n    }\\n    airports {\\n      id\\n      icao\\n      name\\n      city\\n      country\\n      countryCode\\n    }\\n  }\\n}\\n\"\n" +
                "}";

        return req;
    }

    public static String incorrectContext(){
        req = "{\n" +
                "\t\"operationName\": null,\n" +
                "\t\"variables\": {},\n" +
                "\t\"query\": \"{\\n  fetchVisitedAirports(context: \\\"customerapps\\\", lastUpdatedTime: \\\"1515994856000\\\") {\\n    responseHeaderDto {\\n      message\\n      isError\\n      statusCode\\n    }\\n    airports {\\n      id\\n      icao\\n      name\\n      iata\\n      iso3\\n      iso2\\n      city\\n      country\\n      countryCode\\n      city\\n      latitude\\n      longitude\\n      value\\n      pfaReviewerDate\\n      itineraryAirportName\\n      place {\\n        id\\n        city\\n        country\\n        description\\n        flightCount\\n        threeLetterCode\\n        twoLetterCode\\n        region\\n        capital\\n        telCountryCode\\n        officialLanguage\\n        code\\n        symbol\\n        name\\n        isCreditCardsCompatible\\n        region\\n        imageUrl\\n        newsFeed\\n      }\\n      description\\n      elevationMetres\\n      phoneNumber\\n      flightCount\\n      imageUrl\\n      timezones {\\n        id\\n        cityList\\n        regionName\\n        dstUtcOffset\\n        standardUtcOffsetMinutes\\n        code\\n        countryName\\n        dstFromTimeUtc\\n        dstToTimeUtc\\n        effectiveToTimeUtc\\n        effectiveFromTimeUtc\\n        source\\n        dateCreated\\n        airportId\\n      }\\n      airportCount\\n      maxLastUpdatedTime\\n      websiteAddress\\n      openingTimes {\\n        fromDate\\n        toDate\\n        startTimeInSeconds\\n        endTimeInSeconds\\n        dayOfWeekBitMask\\n        airportId\\n      }\\n    }\\n  }\\n}\\n\"\n" +
                "}";

        return req;
    }

}
