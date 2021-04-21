package com.aircraft.codelab.core.entities;

/**
 * 2021-04-11
 *
 * @author tao.zhang
 * @since 1.0
 */
public class Payment {
    private Long id;
    private String serial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
