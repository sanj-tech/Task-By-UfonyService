package com.jsstech.recyclerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    UserAdapter adapter;
    private List<UserModel> listItems;

    LinearLayoutManager layoutManager;
    String url="https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&count=25";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerVew);
        recyclerView.setHasFixedSize(true);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);



        listItems=new ArrayList<>();
        loadRecyclerdata();




    }

    private void loadRecyclerdata() {

        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("loading data");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();

                        try {
                            JSONObject jsonObject=new JSONObject(response);

                            JSONArray array=jsonObject.getJSONArray("date");
                            for (int i=0;i<=array.length();i++)
                            {
                                JSONObject object=array.getJSONObject(i);
                              UserModel item=new UserModel(
                                      object.getString("date"),
                                      object.getString("explanation"));

                            listItems.add(item);

                            }
                            adapter=new UserAdapter(listItems,getApplicationContext());
                            recyclerView.setAdapter(adapter);




                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}