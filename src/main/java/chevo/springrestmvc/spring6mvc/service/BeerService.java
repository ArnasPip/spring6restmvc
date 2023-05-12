package chevo.springrestmvc.spring6mvc.service;

import chevo.springrestmvc.spring6mvc.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
}
