package fr.rt.MyPrintAuth.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ComportePK implements Serializable {

    @Column(name = "id_categorie")
    private int idCategorie;

    @ManyToOne
    @JoinColumn(name="id_option")
    private Option option;


}
