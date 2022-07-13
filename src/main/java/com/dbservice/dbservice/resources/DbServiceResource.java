package com.dbservice.dbservice.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.dbservice.dbservice.model.Quote;
import com.dbservice.dbservice.model.Quotes;
import com.dbservice.dbservice.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

	@Autowired
	private QuotesRepository quotesRepository;

	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username) {
		return getQuotesByUserName(username);
	}


	private List<String> getQuotesByUserName(@PathVariable("username") String username){
		return quotesRepository.findByUserName(username).
				stream().map(quote -> {
										return quote.getQuote();
									   }).collect(Collectors.toList());
	}


	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes) {
		quotes.getQuotes().stream()
		.map(quote -> new Quote(quotes.getUserName(), quote))
				.forEach(quote -> {
					System.out.println("Quotes "+quote);
					quotesRepository.save(quote);
				}

			);
		System.out.println("Username "+quotes.getUserName());
		return getQuotesByUserName(quotes.getUserName());
	}

    @PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username") final String username) {
        List<Quote> quotes = quotesRepository.findByUserName(username);
        quotesRepository.deleteAll(quotes);
        return getQuotesByUserName(username);
    }


}
