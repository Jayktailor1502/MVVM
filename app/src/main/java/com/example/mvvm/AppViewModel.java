package com.example.mvvm;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class AppViewModel extends BaseObservable {
    private Model model;

    private String successMessage = "Login successful";
    private String errorMessage = "Email or Password is not valid";

    @Bindable
    private String toastMessage = null;

    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    @Bindable
    public String getUserEmail() {
            String email = model.getEmail();
            return email;
    }

    public void setUserEmail(String email) {
        model.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserPassword() {
        return model.getPassword();
    }

    public void setUserPassword(String password) {
        model.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public AppViewModel() {
        model = new Model("","");
    }

    public void onButtonClicked() {
        if (isValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }

    public boolean isValid() {
        if (getUserEmail().equals("jaytailor@gmail.com") && getUserPassword().equals("jaytailor123")) {
            Log.e("email","-" + getUserPassword());
            return true;
        }
        else {
            Log.e("password","-" + getUserPassword());
            Log.e("email","-" + getUserEmail());
            return false;
        }
    }
}
