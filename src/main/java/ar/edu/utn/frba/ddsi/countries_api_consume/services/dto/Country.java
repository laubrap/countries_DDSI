package ar.edu.utn.frba.ddsi.countries_api_consume.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//CLASES MOLDE(son las que mappean contra la request)

@JsonIgnoreProperties(ignoreUnknown = true)
@Data //genera getters y setter
@AllArgsConstructor //constructor de todo
@NoArgsConstructor // constructor vacio
public class Country {
    @JsonProperty("name")
    private CountryName name;

    @JsonProperty("capital")
    private List<String> capital;

    @JsonProperty("region")
    private String region;

    @JsonProperty("subregion")
    private String subRegion;
}

//si usamos directamente el mismo nombre de la key de json, matchea
// igualmente hay que modelarlo bien. Sin embargo, es buena practica el uso
// de json property
