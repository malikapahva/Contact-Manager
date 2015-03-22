package com.example.malika.contactmanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.malika.contactmanager.R;
import com.example.malika.contactmanager.dao.ContactDao;
import com.example.malika.contactmanager.model.Contact;

import java.util.List;

/**
 * Created by Malika Pahva (mxp134930) on 3/18/2015.
 * Course: CS6301.001
 *
 * This class add contacts to list, search contacts and
 * specify action on selected contact.
 */
public class ContactInfo extends ActionBarActivity {

    /**
     * This method add contacts to ListView, specify action
     * on select item from list and search contacts.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        final ContactDao contactDao = new ContactDao();
        List<Contact> contacts = contactDao.getAllContacts(this);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent displayContactIntent = new Intent();
                displayContactIntent.setClassName("com.example.malika.contactmanager", "com.example.malika.contactmanager.activity.DisplayContact");
                displayContactIntent.putExtra("contactId", id);
                startActivity(displayContactIntent);
            }
        });
        addContactsToList(contacts);
        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            /**
             * This method searches for requested String in the list
             * and display them.
             *
             * Author: Malika Pahva(mxp134930)
             *
             * @param query
             *
             * @return boolean
             */
            @Override
            public boolean onQueryTextSubmit(String query) {
                List<Contact> filteredContacts = contactDao.findBySearchQuery(query, ContactInfo.this);
                addContactsToList(filteredContacts);
                return false;
            }

            /**
             * This method searches for String as it changes from the list
             * and display them.
             *
             * Author: Malika Pahva(mxp134930)
             *
             * @param newText
             *
             * @return boolean
             */
            @Override
            public boolean onQueryTextChange(String newText) {
                List<Contact> filteredContacts = contactDao.findBySearchQuery(newText, ContactInfo.this);
                addContactsToList(filteredContacts);
                return false;
            }
        });

    }

    /**
     * This method add contacts to ListView.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param contacts
     */
    private void addContactsToList(List<Contact> contacts) {
        ListView listView = (ListView) findViewById(R.id.listView);
        ContactAdapter contactAdapter = new ContactAdapter(contacts, this);
        listView.setAdapter(contactAdapter);
    }

    /**
     * This method sets the add menu on action bar.
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
        inflater.inflate(R.menu.add, menu);
        return super.onCreateOptionsMenu(menu);

    }

    /**
     * This method sets functionality to action bar's add
     * button.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param item
     *
     * @return boolean
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            Intent i = new Intent();
            i.setClassName("com.example.malika.contactmanager", "com.example.malika.contactmanager.activity.AddContact");
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

}
