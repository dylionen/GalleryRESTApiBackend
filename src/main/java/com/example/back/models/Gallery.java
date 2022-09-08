package com.example.back.models;

import com.example.back.models.user.Users;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortName;
    private String longName;
    private LocalDateTime createdDate;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;


}
