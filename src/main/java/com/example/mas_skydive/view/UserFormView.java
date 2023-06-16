package com.example.mas_skydive.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route
@PWA(name = "Skydive Logbook & Dropzone Manager", shortName = "SLDM")
public class UserFormView extends VerticalLayout {

    private final TextField firstNameField;
    private final TextField lastNameField;
    private final EmailField emailField;
    private final DatePicker birthDateField;
    private final TextField phoneNumberField;
    private final TextField citizenshipField;
    private final IntegerField weightField;
    private final TextField peselField;

    private final TextField contactNameField;
    private final TextField contactLastNameField;
    private final TextField contactPhoneNumberField;
    private final EmailField contactEmailField;

    public UserFormView() {
        // Utwórz pola formularza dla pól User
        firstNameField = new TextField("First Name");
        lastNameField = new TextField("Last Name");
        emailField = new EmailField("Email");
        birthDateField = new DatePicker("Birth Date");
        phoneNumberField = new TextField("Phone Number");
        citizenshipField = new TextField("Citizenship");
        weightField = new IntegerField("Weight (in Kgs)");
        peselField = new TextField("PESEL");

        // Utwórz pola formularza dla pól ContactPerson
        contactNameField = new TextField("Contact Name");
        contactLastNameField = new TextField("Contact Last Name");
        contactPhoneNumberField = new TextField("Contact Phone Number");
        contactEmailField = new EmailField("Contact Email");

        // Utwórz przycisk "Add Contact Person" do rozwijanego formularza
        Button addContactButton = new Button("Add Contact Person");
        addContactButton.addClickListener(e -> showContactForm());

        // Utwórz layout formularza i dodaj pola
        FormLayout userFormLayout = new FormLayout();
        userFormLayout.add(firstNameField, lastNameField, emailField, birthDateField,
                phoneNumberField, citizenshipField, weightField, peselField,
                new Label("Contact Person:"),
                contactNameField, contactLastNameField, contactPhoneNumberField, contactEmailField,
                addContactButton);

        // Dodaj layout formularza do widoku
        add(userFormLayout);
    }

    private void showContactForm() {
        // Tutaj możesz otworzyć osobne okno/dialog z formularzem dla pola ContactPerson
        // i przypisać wprowadzone dane do odpowiednich pól
        // Możesz również dodać logikę obsługi zapisu/aktualizacji ContactPerson w bazie danych
        Notification.show("Add Contact Person button clicked");
    }
}

