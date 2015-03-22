package com.example.malika.contactmanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.malika.contactmanager.R;
import com.example.malika.contactmanager.dao.ContactDao;
import com.example.malika.contactmanager.model.Contact;

/**
 * Created by Malika Pahva (mxp134930) on 3/18/2015.
 * Course: CS6301.001
 *
 * This Class creates new contact and save it to data file
 * and list.
 */
public class AddContact extends ActionBarActivity {
    private ContactDao contactDao;
    private ContactGenerator contactGenerator;

    /**
     * This method create new contact.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactDao = new ContactDao();
        contactGenerator = new ContactGenerator(this);
        setContentView(R.layout.addcontact);
    }

    /**
     * This method sets the save and cancel menu on
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
        inflater.inflate(R.menu.savecancel, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * This method sets functionality to action bar's save
     * and cancel button.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param item
     *
     * @return boolean
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save) {
            Contact contactFromView = contactGenerator.generate();

            if(contactFromView.getFirstName().toString().trim().equals(""))
            {
                Toast.makeText(this, "First Name cannot be empty ", Toast.LENGTH_LONG).show();
            }
            else
            {
                contactFromView.setId(System.currentTimeMillis());
                contactDao.addContact(contactFromView, this);
                Toast.makeText(this, "Contact added successfully", Toast.LENGTH_LONG).show();
                Intent i = new Intent();
                i.setClassName("com.example.malika.contactmanager", "com.example.malika.contactmanager.activity.ContactInfo");
                startActivity(i);
                finish();
            }
        }
        if (item.getItemId() == R.id.cancel){
            Intent i = new Intent();
            i.setClassName("com.example.malika.contactmanager", "com.example.malika.contactmanager.activity.ContactInfo");
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
