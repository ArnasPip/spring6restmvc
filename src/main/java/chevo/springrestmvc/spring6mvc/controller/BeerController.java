package chevo.springrestmvc.spring6mvc.controller;

import chevo.springrestmvc.spring6mvc.model.Beer;
import chevo.springrestmvc.spring6mvc.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {
    private final BeerService beerService;

    public Beer getBeerById(UUID id){

        log.debug("Get beer id in controller was called");

        return beerService.getBeerById(id);
    }
}
