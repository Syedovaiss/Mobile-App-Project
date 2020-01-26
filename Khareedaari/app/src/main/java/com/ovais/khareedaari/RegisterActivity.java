package com.ovais.khareedaari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    public static final String URL="";

    private static final Pattern PASSWORD_PATTERN=Pattern.compile("^" +
            "(?=.*[0-9])" +         //at least 1 digit
            "(?=.*[a-z])" +         //at least 1 lower case letter
            "(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[a-zA-Z])" +      //any letter
            "(?=.*[@#$%^&+=])" +    //at least 1 special character
            "(?=\\S+$)" +           //no white spaces
            ".{5,8}" +               //at least 5 characters and max 8 characters
            "$");

EditText email,name,password,num,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);




    }

    public void getLoginActivity(View view) {
        email=findViewById(R.id.email);
        name=findViewById(R.id.fullname);
        password=findViewById(R.id.password);
        num=findViewById(R.id.contact);
        username=findViewById(R.id.username);
       final String inputEmail,inputName,inputUsername,inputPhone,inputPassword;

        inputEmail=email.getText().toString().trim();
        inputName=name.getText().toString().trim();
        inputUsername=username.getText().toString().trim();
        inputPhone=num.getText().toString().trim();
        inputPassword=password.getText().toString().trim();
        if (inputEmail.isEmpty() || inputPassword.isEmpty() || inputUsername.isEmpty()){


            email.setError("email can't be empty");
            password.setError("email can't be empty");
            username.setError("email can't be empty");

        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches()){
            email.setError("Please enter a valid email address");

        }
        else if (!PASSWORD_PATTERN.matcher(inputPassword).matches()){

            password.setError("Password must contains a uppercase,a Lowercase," +
                    "a digit,a special character");
        }


        else {

            email.setError(null);
            password.setError(null);
            username.setError(null);
            StringRequest stringRequest=new StringRequest(Request.Method.POST, URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jsonArray=new JSONArray(response);
                                JSONObject jsonObject=jsonArray.getJSONObject(0);
//                                String code=jsonObject.getString("code");
//                                String message=jsonObject.getString("message");

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params=new HashMap<String,String>();
                    params.put("name",inputName);

                    params.put("email",inputEmail);

                    params.put("password",inputPassword);

                    params.put("mobile",inputPhone);

                    params.put("username",inputUsername);
                    return params;
                }
            };
            MySingleton.getInstance(RegisterActivity.this).addToRequestQueue(stringRequest);
            Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);


        }

    }


//    private boolean validateEmail(){
//        EditText email;
//        email=findViewById(R.id.email);
//        String emailInput=email.getText().toString().trim();
//
//        if (emailInput.isEmpty()){
//
//
//            email.setError("email can't be empty");
//            return false;
//        }
//        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
//            email.setError("Please enter a valid email address");
//            return false;
//        }
//        else {
//
//            email.setError(null);
//
//
//            return true;
//        }
//
//
//    }


//    private boolean passwordValidation(){
//        EditText password=findViewById(R.id.password);
//        String passwordInput=password.getText().toString().trim();
//        if (passwordInput.isEmpty()){
//
//            password.setError("Password can't be empty");
//            return false;
//        }
//        else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()){
//
//            password.setError("Password must contains a uppercase,a Lowercase," +
//                    "a digit,a special character");
//            return false;
//        }
//        else {
//            password.setError(null);
//            return true;
//        }
//
//    }


//    private boolean nameValidation(){
//        EditText name=findViewById(R.id.fullname);
//        String nameInput=name.getText().toString().trim();
//        if (nameInput.isEmpty()){
//
//            name.setError("Please enter your fullname");
//            return false;
//        }
//        else
//        {
//            return true;
//        }
//
//    }


//    private boolean phoneValidation(){
//        EditText phone=findViewById(R.id.contact);
//        String phoneInput=phone.getText().toString().trim();
//        if (phoneInput.isEmpty()){
//
//            phone.setError("Please enter your contact number");
//            return false;
//        }
//        else if (phoneInput.length()>11 && phoneInput.length()>7){
//
//            phone.setError("contact number must be between 8 and 11 digits");
//            return false;
//        }
//        else
//        {
//            return true;
//        }}

    public void towardsLogin(View view) {
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);

    }
}
