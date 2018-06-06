package com.example.user.myapplication;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
/**
 * Created by user on 2018-05-28.
 */

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://ckd7911.cafe24.com/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String userID, String userPassword, String userName, int userAge, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("userID", userID);
        params.put("userPassword", userPassword);
        params.put("userName", userName);
        params.put("userAge", userAge + "");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}