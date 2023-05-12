package chevo.springrestmvc.spring6mvc.controller;

import chevo.springrestmvc.spring6mvc.model.Beer;
import chevo.springrestmvc.spring6mvc.service.BeerService;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class BeerController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BeerController.class);
    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    public Beer getBeerById(UUID id) {

        log.debug("Get beer id in controller was called");

        return beerService.getBeerById(id);
    }
}
