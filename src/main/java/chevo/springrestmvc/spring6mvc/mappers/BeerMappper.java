package chevo.springrestmvc.spring6mvc.mappers;

import chevo.springrestmvc.spring6mvc.entities.Beer;
import chevo.springrestmvc.spring6mvc.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMappper {
    Beer beerDtoToBeer(BeerDTO dto);
    BeerDTO beerToBeerDto(Beer beer);
}
