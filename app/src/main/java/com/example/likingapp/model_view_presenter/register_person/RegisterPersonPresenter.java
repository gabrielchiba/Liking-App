package com.example.likingapp.model_view_presenter.register_person;

import android.content.Context;

import com.example.likingapp.models.OwnUser;
import com.example.likingapp.models.Person;

import se.emilsjolander.sprinkles.Query;

public class RegisterPersonPresenter implements RegisterPersonContract.Presenter{
    private RegisterPersonContract.View view;
    private Context context;

    public RegisterPersonPresenter(RegisterPersonContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public Person createNewEmptyPerson() {
        return new Person();
    }

    @Override
    public void registerPersonOnDB(Person person) {
        person.save();
    }

    @Override
    public boolean haveBlankFields(Person person) {
        return person.name==null || person.lastName==null ||
                person.birthday==null || person.phone==null ||
                person.cpf==null || person.email==null;
    }

    @Override
    public boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    @Override
    public boolean isValidPhoneNumber(String phone) {
        String firstNumber = phone.substring(0, 1);
        return firstNumber.equals("8") || firstNumber.equals("9");
    }

    @Override
    public boolean isSameUser(long newId, long registeredId) {
        return newId == registeredId;
    }

    @Override
    public boolean checkPersonDBExists() {
        return Query.one(Person.class, " SELECT name FROM sqlite_master WHERE type = 'table' AND name= 'person'", true).get() != null;
    }

    @Override
    public boolean checkPersonCpfExists(Person person) {
        Person newPerson = Query.one(Person.class, " SELECT * FROM person WHERE cpf = '" + person.cpf + "'", true).get();

        return (newPerson != null && !isSameUser(newPerson.id, person.id));
    }

    @Override
    public Person getOnePersonOfUserFromDB(long id) {
        return Query.one(Person.class, " SELECT * FROM person WHERE id = '" + id + "'", true).get();
    }

}
