package com.interns.toolManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Events")

@DynamicInsert
@DynamicUpdate
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user; //user id
    private String userName;
    private String toolName;

    private int quantity;
//    @OneToOne
//    @JoinColumn(name = "toolObjectId")
//    private Tools tool;  // tool_object_id

    private LocalDateTime dateAccepted;
    private String approval;

}
