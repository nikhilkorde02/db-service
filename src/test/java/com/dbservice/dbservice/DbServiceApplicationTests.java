package com.dbservice.dbservice;

import com.dbservice.dbservice.model.Quote;
import com.dbservice.dbservice.model.Quotes;
import com.dbservice.dbservice.repository.QuotesRepository;
import com.dbservice.dbservice.resources.DbServiceResource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class DbServiceApplicationTests {

	@Autowired
	DbServiceResource dbServiceResource;
	@MockBean
	QuotesRepository quotesRepository;

	@Test
	void getDbStockByUserNameTest() {
		String username = "Nikhil";
		when(quotesRepository.findByUserName(username))
				.thenReturn(Stream.of(new Quote("Nikhil", "ICICI")).collect(Collectors.toList()));
		assertEquals(1, dbServiceResource.getQuotes(username).size());
	}

	@Test
	public void saveUserStockTest() {
		Quotes quotes = new Quotes("NIKHIL", Collections.singletonList("ICICIC"));
		Quote quote = new Quote(quotes.getUserName(),"ICICIC");
		when(quotesRepository.save(quote)).thenReturn(quote);
		when(quotesRepository.findByUserName(quotes.getUserName()))
				.thenReturn(Stream.of(new Quote("NIKHIL", "ICICIC")).collect(Collectors.toList()));
		assertEquals(quotes.getQuotes(), dbServiceResource.add(quotes));
	}
}
