package chevo.springrestmvc.spring6mvc.services;

import chevo.springrestmvc.spring6mvc.model.BeerCSVRecord;
import chevo.springrestmvc.spring6mvc.service.BeerCsvService;
import chevo.springrestmvc.spring6mvc.service.BeerCsvServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class TestBeerSCVserviceImpl {

    BeerCsvService beerCsvService = new BeerCsvServiceImpl();

    @Test
    void convertSCV() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:csvdata/beers.csv");

        List<BeerCSVRecord> recs = beerCsvService.convertCSV(file);

        System.out.println(recs.size());

        assertThat(recs.size()).isGreaterThan(6);
    }
}
