package com.bit.gcmexample.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.bit.gcmexample.MainActivity;
import com.bit.gcmexample.R;

/**
 * Created by halim on 8/24/2016.
 */

public class LoginActivity extends AppCompatActivity {
    Button Login;
    EditText Username,Password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Username=(EditText)findViewById(R.id.Et_Username);
        Password=(EditText)findViewById(R.id.Et_Pwd);
        Login=(Button)findViewById(R.id.Btn_Login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekLoginId();
//                Intent i=new Intent(LoginActivity.this,MainActivity.class);
//                startActivity(i);
            }
        });
    }
    /*
        1.cek status apakah sebelumnya sudah login apa belum
        @param return value
     */
    public void CheckStatus(){

    }
private void cekLoginId(){
    if(!validateName()){
        return;
    }
    if(!validatePwd()){
        return;
    }
                    Intent i=new Intent(LoginActivity.this,MainActivity.class);
          startActivity(i);

}

    // Validating name
    private boolean validateName() {
        if (Username.getText().toString().trim().isEmpty()) {
            requestFocus(Username);
            return false;
        }
        return true;
    }
    private boolean validatePwd(){
        if(Password.getText().toString().isEmpty()){
            requestFocus(Username);
            return false;
        }
        return true;
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
