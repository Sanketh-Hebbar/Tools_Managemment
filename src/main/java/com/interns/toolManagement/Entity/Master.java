package com.interns.toolManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Master")
@DynamicInsert
@DynamicUpdate
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long toolId;
    private String toolName;
    private int quantity;


}
