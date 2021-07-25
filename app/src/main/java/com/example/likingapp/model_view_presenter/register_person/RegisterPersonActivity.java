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

    // Foreign Key user reference
    private long userID;

    // Existent Person element id reference
    private long personID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new RegisterPersonPresenter(this, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_person);

        // Create new empty person
        Person person = presenter.createNewEmptyPerson();
        binding.setPerson(person);

        userID = getIntent().getLongExtra("registeredUserID", 0);

        personID = getIntent().getLongExtra("editPersonID", 0);

        if (personID != 0) editPerson(personID);

        binding.buttonAccess.setOnClickListener(v -> registerPerson(binding.getPerson()));
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
        else if (presenter.checkPersonCpfExists(person)) {
            Toast.makeText(this, R.string.cpf_exists, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, ""+person.exists(), Toast.LENGTH_SHORT).show();
            savePerson(person);
        }
    }

    @Override
    public void savePerson(Person person) {
        person.user_id = userID;
        presenter.registerPersonOnDB(person);
        returnRegisteredPersonID(person);
    }

    @Override
    public void returnRegisteredPersonID(Person person) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("registeredPersonID", person.id);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

    @Override
    public void initiatePreviousValues(Person person) {
        binding.setPerson(person);
    }

    @Override
    public void editPerson(long id) {
        Person person = presenter.getOnePersonOfUserFromDB(id);
        initiatePreviousValues(person);
    }

}