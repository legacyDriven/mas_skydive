package com.example.mas_skydive.view;

import com.example.mas_skydive.model.User;
import com.example.mas_skydive.service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Route("register-user")
@CssImport("./styles/my-styles.css")

@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class RegisterUserForm extends VerticalLayout {

    UserService userService;

    TextField firstNameField;
    TextField lastNameField;
    TextField emailField;
    PasswordField passwordField;
    TextField weightField;
    Checkbox tandemPassengerCheckbox;
    DatePicker birthDateField;
    ComboBox<String> citizenshipComboBox;
    TextField peselField;


    public RegisterUserForm(UserService userService) {
        this.userService = userService;

        // Nagłówek widoku
        add(new H3("Rejestracja skoczków"));

        // Inicjalizacja pól formularza
        firstNameField = new TextField("Imię");
        firstNameField.addClassName("white-input-field");
        lastNameField = new TextField("Nazwisko");
        emailField = new TextField("Email");
        passwordField = new PasswordField("Hasło");
        weightField = new TextField("Waga (kg)");
        tandemPassengerCheckbox = new Checkbox("Pasażer tandemowy?");
        birthDateField = new DatePicker("Data urodzenia");
        citizenshipComboBox = new ComboBox<>("Obywatelstwo");
        citizenshipComboBox.setItems("Polskie", "Inne");
        peselField = new TextField("Numer PESEL");

        // Dodanie pól do formularza
        add(
                firstNameField,
                lastNameField,
                emailField,
                passwordField,
                weightField,
                tandemPassengerCheckbox,
                birthDateField,
                citizenshipComboBox,
                peselField
        );

        // Przycisk Submit
        Button submitButton = new Button("Submit");
        submitButton.addClickListener(event -> addUser());
        add(submitButton);

        getStyle().set("gap", "1px"); // Odstęp między komponentami
        setAlignItems(Alignment.BASELINE); // Wyśrodkowanie zawartości
        setWidth("100%"); // Szerokość formularza
        setMaxWidth("500px"); // Maksymalna szerokość formularza
    }

    private void addUser() {
        // Pobranie wartości z pól formularza
        String firstName = firstNameField.getValue();
        String lastName = lastNameField.getValue();
        String email = emailField.getValue();
        String password = passwordField.getValue();
        Integer weight = Integer.valueOf(weightField.getValue());
        boolean tandemPassenger = tandemPassengerCheckbox.getValue();
        LocalDate birthDate = birthDateField.getValue();
        String citizenship = citizenshipComboBox.getValue();
        String pesel = peselField.getValue();

        // Tworzenie obiektu User
        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .weightInKgs(weight)
                .isTandemPassenger(tandemPassenger)
                .birthDate(birthDate)
                .citizenship(citizenship)
                .PESEL(pesel)
                .build();

        // Dodawanie użytkownika
        userService.addUser(user);

        // Wyświetlanie powiadomienia o sukcesie
        Notification.show(String.format("Użytkownik: %s %s dodany!", user.getFirstName(), user.getLastName()));

        // Czyszczenie pól formularza
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        passwordField.clear();
        weightField.clear();
        tandemPassengerCheckbox.clear();
        birthDateField.clear();
        citizenshipComboBox.clear();
        peselField.clear();
    }
}
