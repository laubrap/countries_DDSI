package ar.edu.utn.frba.ddsi.countries_api_consume;

import ar.edu.utn.frba.ddsi.countries_api_consume.services.CountrySearcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CountriesApiConsumeApplicationTests {

    @Autowired
    private CountrySearcher countrySearcher;

	@Test
	void searchAllIsNotBlank() {
		var list = countrySearcher.searchAll();

		assertThat(list).isNotEmpty();
		assertThat(list.getFirst().getName().getOfficial()).isNotBlank();
	}

	@Test
	void searchByNameArgentinaReturnsArgentina(){
		var	list = countrySearcher.searchByName("argentina");
		assertThat(list).isNotEmpty();
		assertEquals("Argentina",list.get().getName().getCommon());
	}
}
