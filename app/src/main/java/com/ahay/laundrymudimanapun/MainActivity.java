package com.ahay.laundrymudimanapun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String url = "http://web.binus.ac.id/binussquare/LaundryQueue/DropInQueue.aspx/GetData";
    private List<String> namas;
    private FloatingActionButton fab;
    private Button bu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        bu = findViewById(R.id.khuchink);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            bu.setBackgroundResource(R.drawable.anjing);
//        }

        namas = new ArrayList<>();

        findViewById(R.id.kimak).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                namas.clear();

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONArray array = response.getJSONArray("d");
                                    for (int i = 0; i < array.length(); ++i) {
                                        namas.add(array.getJSONObject(i).getString("Name"));
                                    }
                                } catch (Exception e) {
                                    Log.d("hahaha", e.getMessage());
                                } finally {
                                    findViewById(R.id.kimak).setVisibility(View.VISIBLE);
                                    try {
                                        ((TextView)findViewById(R.id.a)).setText(namas.get(0));
                                        ((TextView)findViewById(R.id.b)).setText(namas.get(1));
                                        ((TextView)findViewById(R.id.c)).setText(namas.get(2));
                                        ((TextView)findViewById(R.id.d)).setText(namas.get(3));
                                        ((TextView)findViewById(R.id.e)).setText(namas.get(4));
                                    } catch (Exception e) {
                                    }
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("hahaha", error.getMessage());
                            }
                        }) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> headers = new HashMap<>();
                        headers.put("content-type", "application/json");
                        return headers;
                    }
                };

                request.setShouldCache(false);
                requestQueue.add(request);
            }
        });

        fab = findViewById(R.id.hidungmelotot);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                namas.clear();

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONArray array = response.getJSONArray("d");
                                    for (int i = 0; i < array.length(); ++i) {
                                        namas.add(array.getJSONObject(i).getString("Name"));
                                    }
                                } catch (Exception e) {
                                    Log.d("hahaha", e.getMessage());
                                } finally {
                                    findViewById(R.id.kimak).setVisibility(View.VISIBLE);
                                    try {
                                        ((TextView)findViewById(R.id.a)).setText(namas.get(0));
                                        ((TextView)findViewById(R.id.b)).setText(namas.get(1));
                                        ((TextView)findViewById(R.id.c)).setText(namas.get(2));
                                        ((TextView)findViewById(R.id.d)).setText(namas.get(3));
                                        ((TextView)findViewById(R.id.e)).setText(namas.get(4));
                                        final Snackbar s = Snackbar.make(findViewById(R.id.matakusakit), getString(R.string.yayy), Snackbar.LENGTH_LONG);
                                        s.setAction("MATI KAU", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                s.dismiss();
                                            }
                                        });
                                        s.show();
                                    } catch (Exception e) {
                                    }
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("hahaha", error.getMessage());
                            }
                        }) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> headers = new HashMap<>();
                        headers.put("content-type", "application/json");
                        return headers;
                    }
                };

                request.setShouldCache(false);
                requestQueue.add(request);
            }
        });
    }
}
