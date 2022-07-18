package com.javafee.darts.back.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_points")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserPoints {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer points;
    @Column(name = "turn_points")
    private Integer turnPoints = 0;
    private Integer turn;
    @OneToOne(mappedBy = "userPoints")
    private Player player;
}
