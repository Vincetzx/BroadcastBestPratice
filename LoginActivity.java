package com.example.god.broadcastbestpratice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by god on 2016/3/1.
 */
public class LoginActivity extends BaseActivity {

    private EditText usernameEdit;
    private EditText passwordEdit;
    private Button loginButton;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        usernameEdit=(EditText)findViewById(R.id.username);
        passwordEdit=(EditText)findViewById(R.id.password);
        loginButton=(Button)findViewById(R.id.login);

        mCheckBox= (CheckBox) findViewById(R.id.remember);

        mPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRember=mPreferences.getBoolean("remember_pass",false);
        if(isRember)
        {
            String username=mPreferences.getString("username","");
            String password=mPreferences.getString("password","");
            usernameEdit.setText(username);
            passwordEdit.setText(password);
            mCheckBox.setChecked(true);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor=mPreferences.edit();
                final String account=usernameEdit.getText().toString();
                final String password=passwordEdit.getText().toString();

                if(account.equals("admin")&&password.equals("123456"))
                {
                    if(mCheckBox.isChecked())
                    {
                        mEditor.putString("username",account);
                        mEditor.putString("password",password);

                        mEditor.putBoolean("remember_pass",true);
                    }
                    else
                    {
                        mEditor.clear();
                    }
                    mEditor.commit();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"wrong name or password",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
