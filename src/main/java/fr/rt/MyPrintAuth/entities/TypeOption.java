package fr.rt.MyPrintAuth.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "type_option", schema = "public", catalog = "MYPRINT")
public class TypeOption {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_type_option")
    private int idTypeOption;
    @Basic
    @Column(name = "libelle")
    private String libelle;

    @OneToOne
    @JoinColumn(name = "id_sous_type_option")
    private SousTypeOption sousTypeOption;


}
