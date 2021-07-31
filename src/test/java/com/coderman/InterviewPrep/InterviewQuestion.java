package com.coderman.InterviewPrep;

import io.cucumber.java.hu.Ha;

import java.util.*;

public class InterviewQuestion {
    public static void main(String[] args) {
        String[][] personWithRecords = {
                {"Paul", "enter"},
                {"Mike", "enter"},
                {"Andrew", "enter"},
                {"Paul", "exit"},
                {"Paul", "enter"},
                {"Mike", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
                {"Andrew","enter"},
                {"Mike","enter"}
        };

        // list - {1,2,3,4,5}
        // list.get(4)
        // HashSet - duplicate yok

        Map<String, List<String>> map = new HashMap<>();
        Set<String> result = new HashSet<>();


        // 2d array - HashMap - ArrayList - HashSet

        //index i
        for (String[] personWithRecord: personWithRecords) {
            String name = personWithRecord[0]; //mike
            String record = personWithRecord[1]; // enter

            if(map.containsKey(name)){
                List<String> currentRecordList = map.get(name); //[enter]

                if(currentRecordList.get(currentRecordList.size()-1).equals("enter") &&  record.equals("enter")){
                    result.add(name);
                }

                currentRecordList.add(record); // [enter,exit,enter]
                map.put(name,currentRecordList);

            }else{
                List<String> records = new ArrayList<>();
                records.add(record);
                map.put(name, records);
            }

        }

        System.out.println(result);
        /*
        *  First step -
        *           Paul - [enter]
        *   Second Step
        *           Paul - [enter]
        *           Mike - [enter]
        *   Third Step -
        *           Paul - [enter]
         *          Mike - [enter]
         *          Andrew - [enter]
         *  Fourth Step
         *          Paul - [enter,exit]
         *          Mike - [enter]
         *          Andrew - [enter]
         * Fifth Step
         *          Paul - [enter,exit,enter]
         *          Mike - [enter]
         *          Andrew - [enter]
         *
         * Sixth Step
         *          Paul - [enter,exit,enter]
         *          Mike - [enter,enter]
         *          Andrew - [enter]
         * Seventh Step
         *          Paul - [enter,exit,enter,exit]
         *          Mike - [enter,enter]
         *          Andrew - [enter]
         *
         *
         * Eighth Step
         *          Paul - [enter,exit,enter,exit,exit]
         *          Mike - [enter,enter]
         *          Andrew - [enter]
        *
        * */



    }


}



/*
*
*
* int[][] personWithStatus= {
*   [Paul, enter]
*   [Mike, enter]
*   [Andrew, enter]
*   [Paul, exit]
*   [Paul, enter]
*   [Mike, enter]
*   [Paul, exit]
*   [Paul,exit]
* }
*
*   Data structure  - hashmap
*       key- value
*       name - List<String>
*
*   Hashmap is empty
*   paul - enter

*
* bu kayitlara bakarak, hangi calisanin cikis yapmadan giris yaptigini bularak ekrana bas.
*
*       enter, enter
*
*   [Mike,]
*
*
*
*
* */