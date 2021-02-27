package com.kodilla.autosledz.domain;

import java.util.Date;
import java.util.Objects;

public class Device {
    private Long id;
    private String name;
    private String uniqueId;
    private Float latitude;
    private Float longitude;
    private String displayName;
    private Date created;
    private Date updated;

    public Device() {
        this.id = 0L;
        this.latitude = 0F;
        this.longitude = 0F;
    }

    public Device(Long id, String name, String uniqueId, Float latitude, Float longitude, String displayName, Date created, Date updated) {
        this.id = id;
        this.name = name;
        this.uniqueId = uniqueId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.displayName = displayName;
        this.created = created;
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public Float getLatitude() {
        return latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(id, device.id) && Objects.equals(name, device.name) && Objects.equals(uniqueId, device.uniqueId) && Objects.equals(latitude, device.latitude) && Objects.equals(longitude, device.longitude) && Objects.equals(displayName, device.displayName) && Objects.equals(created, device.created) && Objects.equals(updated, device.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, uniqueId, latitude, longitude, displayName, created, updated);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
