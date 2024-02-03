package com.satta.priya.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String start_time;
//    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
//    private List<records> recordsList;
}
