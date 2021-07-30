package com.coderman;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        int[] newArr = new int[arr.length + 4];

//        for (int i = 0; i < newArr.length; i++) {
//            if(i < arr.length) {
//                newArr[i] = arr[i];
//                continue;
//            }
//        }

        System.arraycopy(arr,0,newArr,0,arr.length);
        newArr[4] = 5;
        System.out.println(Arrays.toString(newArr));
    }
}


/*
*    Agenda
*
*       We looked at
*           get request
*
*       Today we will look
*           post request
*               - using simple string to create string data for body
*               - using Map to create hashmap data for body
*               - using JsonObject to create json object for body
*               - using pojo class to create java object for body
*               - using file includes json info
*                   - update this file to pass dynamic data
*
*           Verify response
*               - verify body and header
*               - using body() method
*               - using jsonPath
*               - using pojo
*
*
*           -put request
*
*
*   Agenda
*
*       put request
*       delete request
*
*
*       end-to-end
*           gmibank - states
*
*           post request - state olusturulcak. olusturulan state i respojse olarak geri donucek
*               -id i kaydedicem
*           get request - kaydettigimi id i kullnarak state i alicaz
*           put request - id ve diger bilgileri lazim.
*           get request - udapte olup olmadiigna bakicaz
*           delete request - state i sil
*           get request - state in gercekten silindiginden emin olcaz.
*
*
*
*
*
*
*
*
*
*
*
* */