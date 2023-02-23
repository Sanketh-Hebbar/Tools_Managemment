package com.interns.toolManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ToolsMaster")
public class ToolsMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long toolId;
    private String toolName;
    private int quantity;

}
