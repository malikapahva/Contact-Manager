package com.example.malika.contactmanager.dao;

import android.content.Context;

import com.example.malika.contactmanager.model.Contact;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malika Pahva (mxp134930) on 3/18/2015.
 * Course: CS6301.001
 *
 * This Class creates methods to add and find
 * contacts.
 */
public class ContactDao {
    private static final String FILE_PATH = "data.txt";
    private ContactTransformer contactTransformer = new ContactTransformer();

    /**
     * This method returns the list of contacts contains the
     * requested characters.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param query
     *        set of characters based on which contents of list matches.
     * @param context
     *             *
     * @return List<Contacts>
     */
    public List<Contact> findBySearchQuery(String query, Context context) {
        List<String> lines = readLines(context);
        List<Contact> contacts = new ArrayList<Contact>();
        for (String line : lines) {
            if (query.isEmpty() || line.toLowerCase().contains(query.toLowerCase())) {
                Contact contact = contactTransformer.reverse(line);
                contacts.add(contact);
            }
        }
        return contacts;
    }
    /**
     * This method returns the contact where id of contact
     * matches the given id.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param id
     *        contact id
     * @param context
     *             *
     * @return Contact
     */
    public Contact findContactById(Long id, Context context) {
        List<String> lines = readLines(context);
        for (String line : lines) {
            Contact contact = contactTransformer.reverse(line);
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }

    /**
     * This method returns the list of all contacts.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param context
     *             *
     * @return List<Contacts>
     */
    public List<Contact> getAllContacts(Context context) {
        List<String> lines = readLines(context);
        List<Contact> contacts = new ArrayList<Contact>();
        for (String line : lines) {
            Contact contact = contactTransformer.reverse(line);
            contacts.add(contact);
        }
        return contacts;
    }

    /**
     * This method read the records from data file and return
     * the list of records.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param context
     *             *
     * @return List<String>
     */
    private List<String> readLines(Context context) {
        List<String> lines = new ArrayList<String>();


        String line;

        try {
            InputStream inputStream = context.openFileInput(FILE_PATH);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while ((line = bufferedReader.readLine()) != null) {
                    lines.add(line + "\n");
                }

                inputStream.close();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    /**
     * This method add contact to data file.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param contactToAdd
     *
     * @param context
     */
    public void addContact(Contact contactToAdd, Context context) {
        File file = new File(context.getFilesDir(), FILE_PATH);
        String contactRecord = contactTransformer.transform(contactToAdd);
        try {
            FileOutputStream fileOutputStream;
            if (file.exists()) {
                fileOutputStream = context.openFileOutput(FILE_PATH, Context.MODE_APPEND);
            } else {
                fileOutputStream = context.openFileOutput(FILE_PATH, Context.MODE_PRIVATE);
            }

            OutputStreamWriter outputWriter = new OutputStreamWriter(fileOutputStream);
            outputWriter.write(contactRecord);
            outputWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
