package chevo.springrestmvc.spring6mvc.service;

import chevo.springrestmvc.spring6mvc.model.Beer;
import chevo.springrestmvc.spring6mvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID id) {

        log.debug("Get beer id in service was called");

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
