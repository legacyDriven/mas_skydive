package com.example.mas_skydive.view;

import com.example.mas_skydive.model.User;
import com.example.mas_skydive.service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import lombok.experimental.FieldDefaults;

@Route("add-user")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class RegisterUserForm extends FormLayout {

    UserService userService;

    // Pola formularza
    TextField firstNameField;
    TextField lastNameField;
    TextField emailField;
    PasswordField passwordField;

    public RegisterUserForm(UserService userService) {
        this.userService = userService;

        // Nagłówek widoku
        add(new H3("Dodawanie użytkownika"));

        // Inicjalizacja pól formularza
        firstNameField = new TextField("Imię");
        lastNameField = new TextField("Nazwisko");
        emailField = new TextField("Email");
        passwordField = new PasswordField("Hasło");

        // Dodanie pól do formularza
        add(firstNameField, lastNameField, emailField, passwordField);

        // Przycisk Submit
        Button submitButton = new Button("Submit");
        submitButton.addClickListener(event -> addUser());
        add(submitButton);
    }

    private void addUser() {
        // Pobranie wartości z pól formularza
        String firstName = firstNameField.getValue();
        String lastName = lastNameField.getValue();
        String email = emailField.getValue();
        String password = passwordField.getValue();

        // Tworzenie obiektu User
        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build();  //new User(firstName, lastName, email, password);

        // Dodawanie użytkownika
        userService.addUser(user);

        // Wyświetlanie powiadomienia o sukcesie
        Notification.show("Użytkownik dodany!");

        // Czyszczenie pól formularza
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        passwordField.clear();
    }
}
