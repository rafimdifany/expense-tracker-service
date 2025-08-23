package com.expense_tracker.expense_tracker_service.entity;

import com.expense_tracker.expense_tracker_service.entity.enumdata.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


/**
 * TODO : make category to be dynamic (user can create custom category)
 * */
@Entity
@Table(name ="category_template")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
