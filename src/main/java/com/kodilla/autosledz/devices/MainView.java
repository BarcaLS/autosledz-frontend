package com.kodilla.autosledz.devices;

import com.kodilla.autosledz.domain.Device;
import com.kodilla.autosledz.domain.DeviceForm;
import com.kodilla.autosledz.domain.DeviceService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {
    Image imageLogo = new Image("images/autosledz_logo.jpg","Autosledz Logo");
    Label label = new Label("AUTOSLEDŹ");
    private DeviceService deviceService = DeviceService.getInstance();
    private Grid<Device> grid = new Grid<>(Device.class);
    private TextField filter = new TextField();
    private DeviceForm form = new DeviceForm(this);
    private Button addNewDevice = new Button("Add new device");

    public MainView() {
        filter.setPlaceholder("Filter by name...");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> update());
        grid.setColumns("id", "name", "uniqueId", "latitude", "longitude", "displayName", "created", "updated");

        addNewDevice.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setDevice(new Device());
        });

        imageLogo.setWidth("100px");
        imageLogo.getStyle().set("margin-left", "100px");
        label.setWidth("100px");
        label.getStyle().set("margin-left", "20px");
        HorizontalLayout topBar = new HorizontalLayout(imageLogo, label);
        topBar.setWidth("400px");
        topBar.setDefaultVerticalComponentAlignment(Alignment.CENTER);

        HorizontalLayout toolbar = new HorizontalLayout(filter, addNewDevice);
        toolbar.setSizeFull();
        toolbar.setHeight("50px");

        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        grid.setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(topBar, toolbar, mainContent);
        form.setDevice(null);
        setSizeFull();
        refresh();

        grid.asSingleSelect().addValueChangeListener(event -> form.setDevice(grid.asSingleSelect().getValue()));
    }

    public void refresh() {
        grid.setItems(deviceService.getDevices());
    }

    private void update() {
        grid.setItems(deviceService.findByName(filter.getValue()));
    }
}