package com.example.malika.contactmanager.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.malika.contactmanager.R;
import com.example.malika.contactmanager.dao.ContactDao;
import com.example.malika.contactmanager.model.Contact;

/**
 * Created by Saylee Pradhan (sap140530) on 3/21/2015.
 * Course: CS6301.001
 */
public class EditContact extends ActionBarActivity {
    private ContactDao contactDao;
    private ContactGenerator contactGenerator;
    private static Contact oldContact;
    public static Context context;

    /* Created by Saylee Pradhan (sap140530)
    * This method is called at the initialization of EditContact activity.
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        final long contactIndex = getIntent().getExtras().getLong("contactIndex");
        contactDao = new ContactDao();
        contactGenerator = new ContactGenerator(this);
        oldContact = contactDao.findContactById(contactIndex,this);
        context = this;
        if (oldContact != null) {
            populateForm(oldContact);
        }

    }
/*Created by Saylee Pradhan (sap140530) on 3/21/2015.
* This method populates the TextViews as per the details of the contact on the file.*/
    public void populateForm(Contact contact){
        TextView firstName = (TextView) findViewById(R.id.firstName);
        firstName.setText(contact.getFirstName());
        TextView lastName = (TextView) findViewById(R.id.lastName);
        lastName.setText(contact.getLastName());
        TextView phone = (TextView) findViewById(R.id.phone);
        phone.setText(contact.getPhoneNumber());
        TextView email = (TextView) findViewById(R.id.email);
        email.setText(contact.getEmail());
    }
/* Created by Saylee Pradhan (sap140530) on 3/21/2015.
*  It inflates the action bar menu. */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_contact, menu);
        return true;
    }

    /*Created by Saylee Pradhan (sap140530) on 3/21/2015.
    * This method determines the actions for save and exit buttons on the action bar.
    * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.save) {
            Contact contactFromView = contactGenerator.generate();

            if(contactFromView.getFirstName().toString().trim().equals(""))
            {
                Toast.makeText(this, "First Name cannot be empty ", Toast.LENGTH_LONG).show();
            }
            else
            {
                contactFromView.setId(System.currentTimeMillis());
                long oldId = oldContact.getId();
               // Context context = getApplicationContext();

                contactDao.editContact(contactFromView, context, oldId);
                Toast.makeText(this, "Contact edited successfully", Toast.LENGTH_LONG).show();
                Intent i = new Intent();
                i.setClassName("com.example.malika.contactmanager", "com.example.malika.contactmanager.activity.ContactInfo");
                //i.putExtra("contactIndex",contactIndex);
                startActivity(i);
                finish();
            }
        }
        if (id == R.id.cancel){
            Intent i = new Intent();
            i.setClassName("com.example.malika.contactmanager", "com.example.malika.contactmanager.activity.ContactInfo");
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);

    }
}
