package com.example.likingapp.model_view_presenter.register_person;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.example.likingapp.R;
import com.example.likingapp.databinding.ActivityRegisterPersonBinding;
import com.example.likingapp.models.Person;

public class RegisterPersonActivity extends AppCompatActivity implements RegisterPersonContract.View{

    private ActivityRegisterPersonBinding binding;
    private RegisterPersonContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new RegisterPersonPresenter(this, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_person);

        Person person = presenter.createNewEmptyPerson();
        binding.setPerson(person);


        binding.buttonAccess.setOnClickListener(v -> registerPerson(person));
    }

    @Override
    public void registerPerson(Person person) {
        if (presenter.haveBlankFields(person)) {
            Toast.makeText(this, R.string.complete_fields, Toast.LENGTH_SHORT).show();
        }
        else if (presenter.isValidPhoneNumber(person.phone)) {
            Toast.makeText(this, R.string.incorrect_phone_format, Toast.LENGTH_SHORT).show();
        }
        else if (presenter.cpfAlreadyExists(person.cpf)) {
            //TODO
        }
    }
}