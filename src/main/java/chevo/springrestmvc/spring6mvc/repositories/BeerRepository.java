package chevo.springrestmvc.spring6mvc.repositories;

import chevo.springrestmvc.spring6mvc.entities.Beer;
import chevo.springrestmvc.spring6mvc.model.BeerStyle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
    Page<Beer> findAllByBeerNameIsLikeIgnoreCase(String beerName, Pageable pageable);
    Page<Beer> findAllByBeerStyle(BeerStyle beerStyle, Pageable pageable);
    Page<Beer> findAllByBeerNameIsLikeIgnoreCaseAndBeerStyle(String beerName, BeerStyle beerStyle, Pageable pageable);
}
