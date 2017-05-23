package com.example.temasolution;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import static com.example.temasolution.Constants.KEY_ADDRESS;
import static com.example.temasolution.Constants.KEY_EDUCATION;
import static com.example.temasolution.Constants.KEY_EMAIL;
import static com.example.temasolution.Constants.KEY_HOSPITAL;
import static com.example.temasolution.Constants.KEY_MOBILE;
import static com.example.temasolution.Constants.KEY_REGISTERID;
import static com.example.temasolution.Constants.KEY_USERNAME;

/**
 * Created by Justin Joy (jojus) on 17-05-2017.
 */

@SuppressWarnings("ALL")
public class Registration extends Fragment implements View.OnClickListener {
    private final String URL = "http://vehicleiot.in/hosp/get.php";
    private EditText name;
    private EditText emailId;
    private EditText phoneNo;
    private EditText registrationId;
    private EditText hospital;
    private EditText address;
    private EditText education;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, container, false);
        name = (EditText) v.findViewById(R.id.name);
        emailId = (EditText) v.findViewById(R.id.email_id);
        phoneNo = (EditText) v.findViewById(R.id.phone_no);
        registrationId = (EditText) v.findViewById(R.id.registration_id);
        hospital = (EditText) v.findViewById(R.id.hospital);
        address = (EditText) v.findViewById(R.id.address);
        education = (EditText) v.findViewById(R.id.educaton);

        Button submit = (Button) v.findViewById(R.id.submit);
        submit.setOnClickListener(this);
        return v;
    }

    private void registerUser() {
        final String username = name.getText().toString().trim();
        final String email = emailId.getText().toString().trim();
        final String phoneNumber = phoneNo.getText().toString().trim();
        final String registration = registrationId.getText().toString().trim();
        final String hospi = hospital.getText().toString().trim();
        final String addr = address.getText().toString().trim();
        final String educa = education.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put(KEY_USERNAME, username);
                params.put(KEY_EMAIL, email);
                params.put(KEY_MOBILE, phoneNumber);
                params.put(KEY_REGISTERID, registration);
                params.put(KEY_HOSPITAL, hospi);
                params.put(KEY_ADDRESS, addr);
                params.put(KEY_EDUCATION, educa);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        registerUser();
    }
}
