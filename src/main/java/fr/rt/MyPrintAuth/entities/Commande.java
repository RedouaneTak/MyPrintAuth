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
public class Commande {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numero_commande")
    private String numeroCommande;
    @Basic
    @Column(name = "prix_commande")
    private Object prixCommande;
    @Basic
    @Column(name = "id_status")
    private int idStatus;
    @Basic
    @Column(name = "id_user")
    private int idUser;


}
