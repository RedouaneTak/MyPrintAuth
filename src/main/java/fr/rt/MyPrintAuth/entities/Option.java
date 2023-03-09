package fr.rt.MyPrintAuth.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Option {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_option")
    private int idOption;
    @Basic
    @Column(name = "libelle")
    private String libelle;
    @Basic
    @Column(name = "prix")
    private Float prix;

    @OneToOne
    @JoinColumn(name = "id_type_option")
    private TypeOption typeOption;


}
