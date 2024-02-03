package com.satta.priya.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "records")
public class records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sid;
    private String value;
    private LocalDate currentdate;

//    @ManyToOne
//    @JoinColumn(name = "item_id")
//    private Items item;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
