package app.com.application.rustymattok.criminalintetn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class CrimeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);
        //Для работы с фрагментами нужно вызвать фрагмент менеджер.
        //Метод может отличаться и зависит от исп. версии.
        FragmentManager fm = getSupportFragmentManager();
        //Пишем транзакцию для подключения фрагменты.
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fragment = new CrimeFragment();
            //todo изучить beginTransaction()
            fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }

}
