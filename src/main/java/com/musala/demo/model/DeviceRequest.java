package com.musala.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceRequest {

    private int id;
    private String uid;
    private String vendor;
    private String status;
    private String createdDate;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DeviceRequest [id=");
        builder.append(id);
        builder.append(", uid=");
        builder.append(uid);
        builder.append(", vendor=");
        builder.append(vendor);
        builder.append(", status=");
        builder.append(status);
        builder.append(", createdDate=");
        builder.append(createdDate);
        builder.append("]");
        return builder.toString();
    }
}

