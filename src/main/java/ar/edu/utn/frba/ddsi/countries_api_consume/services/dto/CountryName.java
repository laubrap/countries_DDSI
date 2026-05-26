package ar.edu.utn.frba.ddsi.countries_api_consume.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data //genera getters y setter
@AllArgsConstructor //constructor de todo
@NoArgsConstructor // constructor vacio

public class CountryName {
    @JsonProperty("common")
    private String common;

    @JsonProperty("official")
    private String official;
}
//CLASES MOLDE