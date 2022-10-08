package br.edu.uniritter.mobile.mobile20222_1.presenter;

import android.content.Intent;

import com.example.projeto08_10.presenter.LoginPresenterContract;

import br.edu.uniritter.mobile.mobile20222_1.model.User;
import br.edu.uniritter.mobile.mobile20222_1.repository.UserRepository;
import br.edu.uniritter.mobile.mobile20222_1.view.MainActivity;

public class LoginPresenter implements LoginPresenterContract.presenter{
    private LoginPresenterContract.view view;
    private User user;

    public LoginPresenter(LoginPresenterContract.view view) {
        this.view = view;
    }
    @Override
    public void checkLogin(String login, String password) {
        UserRepository repo  = UserRepository.getInstance(view.getActivity());
        User u = repo.getUserByUserLogin(login);
        if (u == null || ! u.getPassword().equals(password)) {
            view.message("Usuário ou senha Inválido");
        } else {
            u.setPassword("trocada");
            validLogin(u);
        }
    }
    @Override
    public void validLogin(User user) {
        this.user = user;
        Intent intent = new Intent(view.getActivity(), MainActivity.class);
        //intent.putExtra("userId", user.getId());
        intent.putExtra("userObj", user);
        view.getActivity().startActivity(intent);
    }
}
