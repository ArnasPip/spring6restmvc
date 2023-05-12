package chevo.springrestmv.spring6mvc.service;

import chevo.springrestmv.spring6mvc.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
}
