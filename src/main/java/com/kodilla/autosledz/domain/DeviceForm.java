package com.kodilla.autosledz.domain;

import com.kodilla.autosledz.devices.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class DeviceForm extends FormLayout {
    private MainView mainView;
    private Binder<Device> binder = new Binder<Device>(Device.class);
    private TextField name = new TextField("Name");
    private TextField uniqueId = new TextField("UniqueId");
    private TextField latitude = new TextField("Latitude");
    private TextField longitude = new TextField("Longitude");
    private TextField displayName = new TextField("DisplayName");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private DeviceService service = DeviceService.getInstance();

    public DeviceForm(MainView mainView) {
        this.mainView = mainView;
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        binder.forField(latitude).bind(
                device -> Float.toString(device.getLatitude()),
                (device, formValue) -> device.setLatitude(Float.valueOf(formValue))
        );
        binder.forField(longitude).bind(
                device -> Float.toString(device.getLongitude()),
                (device, formValue) -> device.setLongitude(Float.valueOf(formValue))
        );
        add(name, uniqueId, latitude, longitude, displayName, buttons);
        binder.bindInstanceFields(this);
        save.addClickListener(event -> save());
        delete.addClickListener(event -> delete());
    }

    private void save() {
        Device device = binder.getBean();
        service.save(device);
        mainView.refresh();
        setDevice(null);
    }

    private void delete() {
        Device device = binder.getBean();
        service.delete(device);
        mainView.refresh();
        setDevice(null);
    }

    public void setDevice(Device device) {
        binder.setBean(device);

        if (device == null) {
            setVisible(false);
        } else {
            setVisible(true);
            name.focus();
        }
    }
}
