package chevo.springrestmv.spring6mvc.controller;

import chevo.springrestmv.spring6mvc.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class BeerController {
    private final BeerService beerService;
}
