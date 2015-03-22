package com.example.malika.contactmanager.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.malika.contactmanager.model.Contact;

import java.util.List;

/**
 * Created by Malika Pahva (mxp134930) on 3/18/2015.
 * Course: CS6301.001
 *
 * This class specifies the details of contact to display
 * in the list.
 */
public class ContactAdapter extends BaseAdapter {
    private List<Contact> contacts;
    private Context context;
    private LayoutInflater layoutInflater;

    /**
     * This is constructor creates contacts and context. It
     * also initializes the layout inflater.
     *
     * @param contacts
     *
     * @param context
     */
    public ContactAdapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    /**
     * This method returns the Contact at specified index.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param i
     *        contact index
     *
     * @return Contact
     */
    @Override
    public Contact getItem(int i) {
        return contacts.get(i);
    }

    /**
     * This method returns the contact id of the contact at
     * specified index.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param i
     *        contact index
     *
     * @return long
     */
    @Override
    public long getItemId(int i) {
        return contacts.get(i).getId();
    }

    /**
     * This method specify the detail of contact to view
     * in the list.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param i
     *        contact index
     *
     * @param view
     *
     * @param viewGroup
     *
     * @return View
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = layoutInflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        }
        Contact contact = getItem(i);
        TextView contactView = (TextView) view.findViewById(android.R.id.text1);
        contactView.setText(contact.getFirstName() + "\t" + contact.getLastName() + "\n" + contact.getPhoneNumber());
        return view;
    }
}
