package com.musala.demo.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="gateway")
public class Gateway {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="serial", unique = true)
    private String serial;

    @Column(name="name")
    private String name;

    @Column(name="ip", columnDefinition = "varchar(15)")  
    private String ip;

    @OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="gateway")
    private List<Device> deviceList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }
}
