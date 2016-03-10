package com.example.test.samplemasterdetail;

import com.example.test.samplemasterdetail.entities.Result;
import com.example.test.samplemasterdetail.retrofit.RetrofitHelper;

import org.junit.Test;

/**
 * Created by evin on 3/10/16.
 */
public class RetrofitTest {

    @Test
    public void retrofit_isWorking() throws Exception {
        RetrofitHelper retrofitHelper = new RetrofitHelper();
        for (Object result : retrofitHelper.getCharacters().getResults()){
            System.out.println(result);
        }
    }
}
