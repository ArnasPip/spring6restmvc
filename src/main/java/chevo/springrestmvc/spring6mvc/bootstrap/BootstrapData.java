package chevo.springrestmvc.spring6mvc.bootstrap;

import chevo.springrestmvc.spring6mvc.entities.Beer;
import chevo.springrestmvc.spring6mvc.model.BeerStyle;
import chevo.springrestmvc.spring6mvc.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
    loadBeerData();
    }
    public void loadBeerData(){
        if(beerRepository.count()==0){
            Beer beer1 = Beer.builder()
                    .beerName("Troll delight")
                    .beerStyle(BeerStyle.IPA)
                    .price(new BigDecimal(1.99))
                    .upc("123456")
                    .quantityOnHand(206)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();
            Beer beer2 = Beer.builder()
                    .beerName("Right side")
                    .beerStyle(BeerStyle.LAGER)
                    .price(new BigDecimal(3.99))
                    .upc("1243256")
                    .quantityOnHand(135)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();
            Beer beer3 = Beer.builder()
                    .beerName("Left footer")
                    .beerStyle(BeerStyle.STOUT)
                    .price(new BigDecimal(7.99))
                    .upc("19543")
                    .quantityOnHand(142)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();
            beerRepository.save(beer1);
            beerRepository.save(beer2);
            beerRepository.save(beer3);
        }
    }
}
