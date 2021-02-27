package com.kodilla.autosledz.devices;

import com.kodilla.autosledz.domain.Device;
import com.kodilla.autosledz.domain.DeviceForm;
import com.kodilla.autosledz.domain.DeviceService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {
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

        HorizontalLayout toolbar = new HorizontalLayout(filter, addNewDevice);

        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(toolbar, mainContent);
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