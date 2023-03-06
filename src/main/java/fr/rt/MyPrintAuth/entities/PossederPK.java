package fr.rt.MyPrintAuth.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable

public class PossederPK implements Serializable {

    @Column(name = "id_user")
    private int idUser;

    @ManyToOne
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;


}
