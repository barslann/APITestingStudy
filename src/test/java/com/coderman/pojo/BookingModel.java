package com.coderman.pojo;

import lombok.*;


@Getter
@Setter
@ToString
public class BookingModel {
        private  String firstname;
        private String lastname;
        private int totalprice;
        private boolean depositpaid;
        private String additionalneeds;
        private BookingDataModel bookingdates;

}

/*
* {
    "firstname": "Jim",
    "lastname": "Wilson",
    "totalprice": 408,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2020-12-20",
        "checkout": "2021-06-17"
    },
    "additionalneeds": "Breakfast"
}
*
*
* */