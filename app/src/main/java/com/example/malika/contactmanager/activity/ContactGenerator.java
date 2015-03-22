package com.example.malika.contactmanager.activity;

import android.app.Activity;
import android.widget.EditText;

import com.example.malika.contactmanager.R;
import com.example.malika.contactmanager.model.Contact;

/**
 * Created by Malika Pahva (mxp134930) on 3/18/2015.
 * Course: CS6301.001
 *
 * This class retrieve the contact detail from EditText
 * and store them into String values to save in data file.
 */
public class ContactGenerator {
    private Activity activity;

    /**
     * This is a constructor to initialize the activity.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param activity
     */
    public ContactGenerator(Activity activity) {
        this.activity = activity;
    }

    /**
     * This method get the contact details from EditText and
     * store them in string values to create new contact.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @return Contact
     */
    public Contact generate() {
        EditText firstNameIn = (EditText) activity.findViewById(R.id.firstName);
        String firstName = firstNameIn.getText().toString();
        EditText lastNameIn = (EditText) activity.findViewById(R.id.lastName);
        String lastName = lastNameIn.getText().toString();

        EditText phoneIn = (EditText) activity.findViewById(R.id.phone);
        String phone = phoneIn.getText().toString();
        EditText emailIn = (EditText) activity.findViewById(R.id.email);
        String email = emailIn.getText().toString();
        return new Contact(firstName, lastName, phone, email);
    }

}
