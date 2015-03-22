package com.example.malika.contactmanager.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import com.example.malika.contactmanager.R;
import com.example.malika.contactmanager.dao.ContactDao;
import com.example.malika.contactmanager.model.Contact;

/**
 * Created by Malika Pahva (mxp134930) on 3/19/2015.
 * Course: CS6301.001
 *
 * This class displays the details of selected
 * Contact.
 */
public class DisplayContact extends ActionBarActivity {

    /**
     * This method gets the contact based on contact id
     * and display details of that contact.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaycontact);
        final long contactId = getIntent().getExtras().getLong("contactId");
        ContactDao contactDao = new ContactDao();
        Contact contact = contactDao.findContactById(contactId, this);
        if (contact != null) {
            updateContactDetail(contact);
        }
    }

    /**
     * This method gets the contact details and sets into
     * the TextView to display.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param contact
     */
    private void updateContactDetail(Contact contact) {
        TextView firstName = (TextView) findViewById(R.id.firstNameValue);
        firstName.setText(contact.getFirstName());
        TextView lastName = (TextView) findViewById(R.id.lastNameValue);
        lastName.setText(contact.getLastName());
        TextView phone = (TextView) findViewById(R.id.phoneValue);
        phone.setText(contact.getPhoneNumber());
        TextView email = (TextView) findViewById(R.id.emailValue);
        email.setText(contact.getEmail());
    }

    /**
     * This method sets the edit and delete menu on
     * action bar.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param menu
     *
     * @return boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.editdelete, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
