package com.interns.toolManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Date;
import java.time.LocalDate;

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
    @OneToOne
    @JoinColumn(name = "toolObjectId")
    private Tools tool;  // tool_object_id

    private LocalDate dateAccepted;
    private LocalDate dateReturned;


}
