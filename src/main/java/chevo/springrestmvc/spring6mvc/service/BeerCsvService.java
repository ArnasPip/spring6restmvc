package chevo.springrestmvc.spring6mvc.service;

import chevo.springrestmvc.spring6mvc.model.BeerCSVRecord;

import java.io.File;
import java.util.List;

public interface BeerCsvService {
    List<BeerCSVRecord> convertCSV(File csvFile);
}
