package com.mithu.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends CrudRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);
}
