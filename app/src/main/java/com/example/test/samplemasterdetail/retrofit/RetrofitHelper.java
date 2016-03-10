package com.example.test.samplemasterdetail.retrofit;

import android.util.Log;

import com.example.test.samplemasterdetail.BuildConfig;
import com.example.test.samplemasterdetail.entities.Result;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by evin on 3/10/16.
 */
public class RetrofitHelper {

    private static final String TAG = "RetrofitHelperTAG_";

    private static final String SIMPSONS_FLAVOR = "simpsons";
    private static final String SIMPSONS_QUERY = "simpsons characters";
    private static final String GOT_QUERY = "game of thrones characters";


    private static DuckService buildDuckService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.DATA_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(DuckService.class);
    }

    public Result getCharacters() {
        String query = (BuildConfig.FLAVOR.contains(SIMPSONS_FLAVOR))
                ? SIMPSONS_QUERY
                : GOT_QUERY;

        Call<Result> listCall = buildDuckService().listCharacters(query);

        Result results = null;

        try {
            results = listCall.execute().body();
        } catch (Exception e) {
            Log.e(TAG, "Error: " + e.toString());
        }

        return results;
    }
}
