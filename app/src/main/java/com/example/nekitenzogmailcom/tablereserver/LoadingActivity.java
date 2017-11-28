package com.example.nekitenzogmailcom.tablereserver;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.nekitenzogmailcom.tablereserver.SaveData.SaveInstance;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;


//Окно загрузки, проверка на авторизацию
public class LoadingActivity extends AppCompatActivity {

    SharedPreferences sPref;
    Intent intent;
    String LOG = "MyLogs";
    String id;
    private static int SIGN_IN_REQUEST_CODE = 1;
    ConstraintLayout loadingActivity;
//    private FirebaseListAdapter<Message> adapter;
    DatabaseReference refForBron;
//    Button button;
//    EditText nameET, peopleET, timeET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        //получаем префы для загрузки состояния
        sPref = getSharedPreferences(SaveInstance.FIRST_START, MODE_PRIVATE);

        //загоняем в наш интент маин активити
        intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        //если пользователь не авторизован то вызывается окно авторизации
        //из него мы получаем реквест код
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivityForResult(AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .build(), SIGN_IN_REQUEST_CODE);
        } else {
            //если пользователь уже авторизован то стартуем активити
            Log.d(LOG, "Start activity main");
            startActivity(intent);
        }
    }


    //Метод для вызова окна авторизации
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN_REQUEST_CODE)
        {
            if (resultCode == RESULT_OK)
            {
                Snackbar.make(loadingActivity, "Вход выполнен", Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(loadingActivity, "Вход не выполнен", Snackbar.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}
