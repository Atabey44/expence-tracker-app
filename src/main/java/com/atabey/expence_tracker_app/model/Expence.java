package com.atabey.expence_tracker_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="expencies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private LocalDateTime expenceDate;

    @ManyToOne
    @JoinColumn(name ="category_id", nullable = false)
    private Category category;


}
