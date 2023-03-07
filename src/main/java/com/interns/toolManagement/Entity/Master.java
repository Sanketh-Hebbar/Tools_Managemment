package com.interns.toolManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Master")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long toolId;
    private String toolName;
    private int quantity;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "master")
    private List<Tools> tools;

}
