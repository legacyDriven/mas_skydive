package com.example.mas_skydive.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Manifest")
@Route(value = "manifest") //layout = MainView.class)
public class ManifestView extends VerticalLayout {

    public ManifestView() {
        addClassName("manifest-view");
        setSizeFull();
        Button button = new Button("Manifest");
        add(button);

    }
}
