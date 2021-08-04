package com.example.likingapp.view_presenter.register_person;

import com.example.likingapp.models.Person;

import java.util.Calendar;

import mk.webfactory.dz.maskededittext.MaskedEditText;

public interface RegisterPersonContract {
    interface View {
        void registerPerson(Person person);
        void savePerson(Person person);
        void returnRegisteredPersonID(Person person);
        void editPerson(long id);
        void initiatePreviousValues(Person person);
        void showCalendar();
        void updateBirthdayLabel(Calendar calendar);
    }

    interface Presenter {
        Person createNewEmptyPerson();
        boolean haveBlankFields(Person person);
        boolean isNullOrEmpty(String... values);
        void registerPersonOnDB(Person person);
        boolean isValidEmail(CharSequence target);
        boolean isValidPhoneNumber(String phone);
        boolean isSameUser(long newId, long registeredId);
        boolean checkPersonDBExists();
        boolean checkPersonCpfExists(Person person);
        Person getOnePersonOfUserFromDB(long id);
        String getRawEditValue(MaskedEditText maskedEditText);
    }
}
