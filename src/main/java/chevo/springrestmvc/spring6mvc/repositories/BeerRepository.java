package chevo.springrestmvc.spring6mvc.repositories;

import chevo.springrestmvc.spring6mvc.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
