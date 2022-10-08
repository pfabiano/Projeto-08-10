package com.example.projeto08_10.presenter;

import android.app.Activity;
import android.content.Context;

import br.edu.uniritter.mobile.mobile20222_1.model.User;

public class LoginPresenterContract {
    public interface view {
        public void message(String msg);
        public Activity getActivity();
    }

    public interface presenter {
        public void checkLogin(String login, String password);
        public void validLogin(User user);

    }
}
