package com.helpmeproductions.chatgroup.view.activities.log_in;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;

/**
 * Created by rynel on 3/28/2018.
 */

public class LoginPresenter implements LoginContract.Presenter{

    //creating FirebaseAuth object
    private FirebaseAuth credentials;
    private LoginContract.View view;

    //Creating account
    private void createUserID(String email, String password) {

    }

    //signing in
    private void signIn(String email, String password) {

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

        return true;

    }

    private void launchChatRoom(){
//        Intent intent = new Intent(this, CheckingAccountActivity.class); //TODO: Determine launched activity name
//        startActivity(intent);

    }

    @Override
    public void addView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void createUserId(String email, String password, Context context) {
        Log.d(TAG, "UserID:" + email);
        if (!validation()) {
            return;
        }

        //create account start process
        credentials.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
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
                            view.showMessage("Login failed");
                            updateUI(null);
                        }
                    }
                });
    }

    @Override
    public void signIn(String email, String password, Context context) {
        Log.d(TAG, "signIn:" + email);
        if (!validation()) {
            return;
        }

        //sign-in with email
        credentials.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = credentials.getCurrentUser();
                            updateUI(user);
                            launchChatRoom();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            view.showMessage("Failed");
                            updateUI(null);
                        }

                        if (!task.isSuccessful()) {
//                            tv_status.setText(R.string.auth_failed);
                            view.showMessage("Success");
                        }
                    }
                });
    }
}
