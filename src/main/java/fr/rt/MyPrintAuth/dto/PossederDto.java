package fr.rt.MyPrintAuth.dto;

import fr.rt.MyPrintAuth.entities.Posseder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PossederDto {

    private Integer idUser;

    private Integer idAdresse;


    public PossederDto(Posseder posseder){
        idUser = posseder.getPossederPK().getIdUser();
        idAdresse = posseder.getPossederPK().getAdresse().getIdAdresse();
    }

    public static List<PossederDto> toListPossederDto(List<Posseder> listPosseder){
        List<PossederDto> listPossederDto = new ArrayList<>();

        for(Posseder posseder: listPosseder){
            listPossederDto.add(new PossederDto(posseder));
        }

        return listPossederDto;

    }
}
