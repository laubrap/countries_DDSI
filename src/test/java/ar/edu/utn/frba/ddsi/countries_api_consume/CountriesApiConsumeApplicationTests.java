package ar.edu.utn.frba.ddsi.countries_api_consume;

import ar.edu.utn.frba.ddsi.countries_api_consume.services.CountrySearcher;
import ar.edu.utn.frba.ddsi.countries_api_consume.services.dto.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CountriesApiConsumeApplicationTests {

    @Autowired
    private CountrySearcher countrySearcher;

	@Test
	void searchAllIsNotBlank() {
		var list = countrySearcher.searchAll();

		System.out.println(list);

		assertThat(list).isNotEmpty();
		assertThat(list.getFirst().getName().getOfficial()).isNotBlank();
	}

	@Test
	void searchByNameArgentinaReturnsArgentina(){
		var	opt = countrySearcher.searchByName("argentina");

		System.out.println(opt);

		assertThat(opt).isNotEmpty();
		assertEquals("Argentina",opt.get().getName().getCommon());
	}

	@Test
	void searchByRegionEuropeIsNotBlank(){
		var list = countrySearcher.searchByRegion("Europe");

		assertThat(list).isNotEmpty();

		List<Country> filteredCountry = list.stream().
				filter(s -> s.getName().getOfficial().equals("Republic of Slovenia"))
				.toList();

		System.out.println(filteredCountry);

		assertThat(filteredCountry).isNotEmpty();
	}
}
