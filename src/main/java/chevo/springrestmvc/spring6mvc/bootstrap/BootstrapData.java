package chevo.springrestmvc.spring6mvc.bootstrap;

import chevo.springrestmvc.spring6mvc.entities.Beer;
import chevo.springrestmvc.spring6mvc.model.BeerCSVRecord;
import chevo.springrestmvc.spring6mvc.model.BeerStyle;
import chevo.springrestmvc.spring6mvc.repositories.BeerRepository;
import chevo.springrestmvc.spring6mvc.service.BeerCsvService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;
    private final BeerCsvService beerCsvService;

    public BootstrapData(BeerRepository beerRepository, BeerCsvService beerCsvService) {
        this.beerRepository = beerRepository;
        this.beerCsvService = beerCsvService;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCsvData();
    }

    private void loadBeerData() {
        if (beerRepository.count() == 0) {
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

    private void loadCsvData() throws FileNotFoundException {
        if (beerRepository.count() < 10) {
            File file = ResourceUtils.getFile("classpath:csvdata/beers.csv");

            List<BeerCSVRecord> recs = beerCsvService.convertCSV(file);

            recs.forEach(beerCSVRecord -> {
                BeerStyle beerStyle = switch (beerCSVRecord.getStyle()) {
                    case "American Pale Lager" -> BeerStyle.LAGER;
                    case "American Pale Ale (APA)", "American Black Ale", "Belgian Dark Ale", "American Blonde Ale" ->
                            BeerStyle.ALE;
                    case "American IPA", "American Double / Imperial IPA", "Belgian IPA" -> BeerStyle.IPA;
                    case "American Porter" -> BeerStyle.PORTER;
                    case "Oatmeal Stout", "American Stout" -> BeerStyle.STOUT;
                    case "Saison / Farmhouse Ale" -> BeerStyle.SAISON;
                    case "Fruit / Vegetable Beer", "Winter Warmer", "Berliner Weissbier" -> BeerStyle.WHEAT;
                    case "English Pale Ale" -> BeerStyle.PALE_ALE;
                    default -> BeerStyle.PILSNER;
                };

                beerRepository.save(Beer.builder()
                        .beerName(StringUtils.abbreviate(beerCSVRecord.getBeer(), 50))
                        .beerStyle(beerStyle)
                        .price(BigDecimal.TEN)
                        .upc(beerCSVRecord.getRow().toString())
                        .quantityOnHand(beerCSVRecord.getCount())
                        .build());
            });
        }
    }
}
