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
@Table(name = "sous_type_option", schema = "public", catalog = "MYPRINT")
public class SousTypeOption {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_sous_type_option")
    private int idSousTypeOption;
    @Basic
    @Column(name = "libelle")
    private String libelle;

}
