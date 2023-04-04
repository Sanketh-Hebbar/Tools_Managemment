package com.interns.toolManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Notifications")

@DynamicInsert
@DynamicUpdate
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationID;

    @ManyToOne
    @JoinColumn(name = "master_tool_id")
    private Master master;

    private String toolName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String manufacturer;

    private int quantity;

    private boolean status;


}
