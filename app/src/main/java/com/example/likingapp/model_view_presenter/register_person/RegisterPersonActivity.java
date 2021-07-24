package com.example.likingapp.model_view_presenter.register_person;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.likingapp.R;
import com.example.likingapp.databinding.ActivityRegisterPersonBinding;
import com.example.likingapp.models.OwnUser;
import com.example.likingapp.models.Person;

public class RegisterPersonActivity extends AppCompatActivity implements RegisterPersonContract.View{

    private ActivityRegisterPersonBinding binding;
    private RegisterPersonContract.Presenter presenter;
    private long userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new RegisterPersonPresenter(this, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_person);

        Person person = presenter.createNewEmptyPerson();
        binding.setPerson(person);

        userID = getIntent().getLongExtra("registeredUserID", 0);

        binding.buttonAccess.setOnClickListener(v -> registerPerson(person));
    }

    @Override
    public void registerPerson(Person person) {
        if (presenter.haveBlankFields(person)) {
            Toast.makeText(this, R.string.complete_fields, Toast.LENGTH_SHORT).show();
        }
        else if (!presenter.isValidPhoneNumber(person.phone)) {
            Toast.makeText(this, R.string.incorrect_phone_format, Toast.LENGTH_SHORT).show();
        }
        else if (!presenter.isValidEmail(person.email)) {
            Toast.makeText(this, R.string.insert_valid_email, Toast.LENGTH_SHORT).show();
        }
        else if (!presenter.checkPersonCpfExists(person.cpf)) {
            Toast.makeText(this, R.string.cpf_exists, Toast.LENGTH_SHORT).show();
        }
        else {
            savePerson(person);
        }
    }

    @Override
    public void savePerson(Person person) {
        Intent returnIntent = new Intent();
        person.user_id = userID;
        presenter.registerPersonOnDB(person);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}