package chevo.springrestmvc.spring6mvc.service;

import chevo.springrestmvc.spring6mvc.model.Beer;
import chevo.springrestmvc.spring6mvc.model.BeerStyle;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BeerServiceImpl.class);

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
