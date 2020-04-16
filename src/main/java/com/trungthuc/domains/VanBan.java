package com.trungthuc.domains;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "vanban")
@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(name = "VanBan.createVanBanFromJson",
                procedureName = "createVanBanFromJson",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "params", type = JsonObject.class)
                }))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VanBan extends AbtractDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    private String numberPH;
}
