package guru.springframework.spring6restmvc.service;

import guru.springframework.spring6restmvc.model.Beer;

import java.util.UUID;

public interface BeerServices {

    Beer getBeerById(UUID id);
}
