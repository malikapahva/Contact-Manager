package com.example.malika.contactmanager.dao;


import com.example.malika.contactmanager.model.Contact;

/**
 * Created by Malika Pahva (mxp134930) on 3/18/2015.
 * Course: CS6301.001
 *
 * This Class converts the Contact Object into String and
 * from String to Contact.
 */

public class ContactTransformer {
    private static final String CONTACT_DELIMITER = "\t";
    public static final String BLANK = " ";

    /**
     * This method converts the Contact object to String.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param contact
     *
     * @return String
     */
    public String transform(Contact contact) {
            return contact.getId() + CONTACT_DELIMITER + contact.getFirstName() + CONTACT_DELIMITER +  nullSafe(contact.getLastName())
                    + CONTACT_DELIMITER + nullSafe(contact.getPhoneNumber()) + CONTACT_DELIMITER + nullSafe(contact.getEmail()) + "\n";
    }

    /**
     * This method checks for any null value and replaces
     * it with empty String(BLANK).
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param value
     *
     * @return String.
     */
    private String nullSafe(String value) {
        if (value == null) {
            return BLANK;
        }
        return value;
    }

    /**
     * This method converts the String to Contact object.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param line
     *        contact detail in String form.
     *
     * @return Contact
     */
    public Contact reverse(String line) {
        String[] contactRecord = line.split(CONTACT_DELIMITER);
        Long id = Long.valueOf(contactRecord[0]);
        Contact contact = new Contact(id);
        contact.setFirstName(contactRecord[1]);
        contact.setLastName(contactRecord[2]);
        contact.setPhoneNumber(contactRecord[3]);
        contact.setEmail(contactRecord[4].trim());
        return contact;
    }
}
