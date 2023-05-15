package chevo.springrestmvc.spring6mvc.repositories;

import chevo.springrestmvc.spring6mvc.entities.Beer;
import chevo.springrestmvc.spring6mvc.model.BeerStyle;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BeerRepositoryTest {
    @Autowired
    BeerRepository beerRepository;

    @Test
    void testBeerNameTooLong(){

        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                    .beerName("122222222222222222222222222222222222222222222222222222222222222222221222222222222222222222222222222222222222222222222222222222222222222212222222222222222222222222222222222222222222222222222222222222222222")
                    .upc("1234567890")
                    .price(new BigDecimal(1))
                    .beerStyle(BeerStyle.IPA)
                    .build());

            beerRepository.flush();
        });
    }

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                .beerName("My beer")
                        .upc("1234567890")
                        .price(new BigDecimal(1))
                        .beerStyle(BeerStyle.IPA)
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}