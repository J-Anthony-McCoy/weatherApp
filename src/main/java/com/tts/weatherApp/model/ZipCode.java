package com.tts.weatherApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

// getters, setters, to string
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ZipCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    private Date timeStamp;

    private String zipCode;

    public ZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
