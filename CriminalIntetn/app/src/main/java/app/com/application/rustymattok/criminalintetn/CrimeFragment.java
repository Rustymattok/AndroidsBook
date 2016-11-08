package app.com.application.rustymattok.criminalintetn;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class CrimeFragment extends Fragment{
    private Crime mCrime;
    private EditText mTitleField;
    /**
     * Bundle use for save and load status.
     * @param savedInstanceState -status.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }
/*
    Фрагмент заполняется этим методом, в отличии от обычной активности.
     View v = inflater.inflate -передачей идентификатора ресурса макета
     parent  - родитель макета, необходим для настройки виджета.
 */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        //определяем сам макет
        //todo Посмотреть документацию на View
        View v = inflater.inflate(R.layout.crime_fragment, parent, false);
        //определяем слушатели в макете,кнопки и т.д
        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        //todo изучить TextWatcher()
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //todo изучить CharSequence s
                //CharSequence s - представляет ввод пользователя,ToString преобразуем в строку.
                //И вносим эту запись в наш класс Crime.
                mCrime.setmTitle(s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return v;
    }
}
