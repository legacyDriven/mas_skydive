package com.example.mas_skydive.view;

import com.example.mas_skydive.model.DzRoleHolder;
import com.example.mas_skydive.model.User;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hibernate.Hibernate;

@PageTitle("Users")
@Route("users")
public class UserView extends VerticalLayout {

    Grid<User> grid = new Grid<>(User.class);
    TextField filterText = new TextField();

    public UserView() {
        addClassName("user-view");
        setSizeFull();
        configureGrid();
        grid.setWidth("50%");
        add(grid);
//        updateList();
    }
    private void configureGrid() {
        grid.addClassName("user-grid");
        grid.setSizeFull();
        grid.setColumns("firstName", "lastName"); //"jumps");
        grid.addColumn(user -> {
            Hibernate.initialize(user.getJumplogs());  // tylko jeśli lista jest leniwa
            return user.getJumplogs().size();
        }).setHeader("Jumps");
        grid.addColumn(user -> {
            DzRoleHolder roleHolder = user.getRole();
            if (roleHolder != null) {
                return roleHolder.getRatings().toString(); // konwertujemy listę na String
            }
            return "";
        }).setHeader("Ratings");


        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
}

