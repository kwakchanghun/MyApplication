package com.example.user.myapplication;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2018-05-30.
 */

public class DeleteRequest extends StringRequest{

    final static private String URL ="http://ckd7911.cafe24.com/Delete.php";
    private Map<String, String> parameters;

    public DeleteRequest(String userID, Response.Listener<String> listener) {
        super(Method.POST,URL ,listener,null);
      parameters = new HashMap<>();
      parameters.put("userID",userID);
    }

    @Override
    public Map<String,String > getParams(){
        return parameters;
    }

}
