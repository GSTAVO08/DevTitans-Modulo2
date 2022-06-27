package com.example.webservicevolley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    private void jsonParseString() {
        String url = "https://www.google.com";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        textView.setText("Response is: " + response.substring(0, 500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                textView.setText("That didn't work!" + error.toString());
            }
        });

        MySingleton.getInstance(this.getApplicationContext()).addToRequestQueue(stringRequest);
    }

    private void jsonParse(){
        //https://jsonplaceholder.typicode.com/
        String url = "https://randomuser.me/api/?inc=name,email";

        JsonObjectRequest request = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jArray;
                        JSONObject jObject,jNome;
                        String title = null;
                        String status = null;
                        try {
                            jArray = response.getJSONArray("results");
                            jObject =  jArray.getJSONObject(0);
                            jNome = (jObject.getJSONObject("name"));
                            title = jNome.getString("first") +" "+jNome.getString("last");
                            status = jObject.getString("email");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        textView.setText("Title:  "+title + "\n " +
                                "Status: " + status);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("That didn't work!");
                        textView.setText(error.toString());
                    }
                });

        MySingleton.getInstance(this).addToRequestQueue(request);
    }

}

