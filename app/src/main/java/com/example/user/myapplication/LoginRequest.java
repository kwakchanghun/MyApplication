package com.example.user.myapplication;

/**
 * Created by user on 2018-05-28.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://ckd7911.cafe24.com/Login.php";//AVD 는 10.0.2.2 로 접속
    private Map<String, String> params;

    public LoginRequest(String userID, String userPassword, Response.Listener<String> listener){
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("userID", userID);
        params.put("userPassword", userPassword);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}