package chevo.springrestmv.spring6mvc.service;

import chevo.springrestmv.spring6mvc.model.Beer;
import chevo.springrestmv.spring6mvc.model.BeerStyle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID id) {
        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Troll Delight")
                .beerStyle(BeerStyle.IPA)
                .upc("12345")
                .price(new BigDecimal("3.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}
