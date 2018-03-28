package com.helpmeproductions.chatgroup.view.activities.log_in;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.helpmeproductions.chatgroup.R;

public class LogIn extends AppCompatActivity {

    private static final String TAG = "Credentials";

    //creating FirebaseAuth object TODO: add firebase @Will (access purposes)
    private FirebaseAuth credentials;

    //TextView and EditView inits
    private TextView tvUserID;
    private TextView tvPassword;
    private EditText etUser;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //starting firebase
        credentials = FirebaseAuth.getInstance();

        //binding views
        tvUserID = findViewById(R.id.tv_userID);
        tvPassword = findViewById(R.id.tv_password);
        etUser = findViewById(R.id.et_user);
        etPassword = findViewById(R.id.et_password);

        //setting buttons --- creating user registration //TODO: add setOnClickListener after adding button functionality
        findViewById(R.id.signIn);
        findViewById(R.id.register);
    }


    //Creating account
    private void createUserID(String email, String password) {
        Log.d(TAG, "UserID:" + email);
        if (!validation()) {
            return;
        }

        //create account start process
        credentials.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = credentials.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LogIn.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    //signing in
    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);
        if (!validation()) {
            return;
        }

        //sign-in with email
        credentials.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = credentials.getCurrentUser();
                            launchChatRoom();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LogIn.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        if (!task.isSuccessful()) {
//                            tv_status.setText(R.string.auth_failed);
                            Toast.makeText(LogIn.this, "Login Success", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    //TODO: Determine signout
//    private void signOut() {
//        mAuth.signOut();
//        updateUI(null);
//    }

    public void updateUI(FirebaseUser user) { //TODO: create updateUI method after connecting firebase


    }

    //confirming information required is met TODO: create boolean to check data for user/pass
    public boolean validation(){

        boolean valid = true;
        return valid;

    }

    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.register) {
            createUserID(etUser.getText().toString(), etPassword.getText().toString());
        } else if (i == R.id.signIn) {
            signIn(etUser.getText().toString(), etPassword.getText().toString());
            launchChatRoom();

        }
    }

    private void launchChatRoom(){
//        Intent intent = new Intent(this, ); //TODO: Determine launched activity name
//        startActivity(intent);

    }

}
