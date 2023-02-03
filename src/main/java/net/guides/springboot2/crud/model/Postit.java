package net.guides.springboot2.crud.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Entity
@Table(name = "post_it")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Postit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String contenuto;

    private LocalDate scadenza;

    private Boolean stato = false;

}
