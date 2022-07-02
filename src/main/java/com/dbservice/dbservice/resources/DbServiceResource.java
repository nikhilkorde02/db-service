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

	//http://localhost:8300/rest/db/username -> This is regular way of calling
	//http://db-service/rest/db/username -> Calling through eureka
	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username) {

		return getQuotesByUserName(username);

	}


	private List<String> getQuotesByUserName(@PathVariable("username") String username){
		return quotesRepository.findByUserName(username).
				stream().map(quote -> {
										return quote.getQuote();
									   }).collect(Collectors.toList());


		//quotesRepository.findByUserName(username) -> List<Quote>

		//Ramu Stock1,Stock2,Stock3
		//1 Ramu Stock1
		//2 Ramu Stock2
		//3 Ramu Stock3

		//Ramu -> Stock1,Stock2

		//stream().map( -> for reach ramu {
				//stock1
		//stock2

		//}
		//collect -> Convert //stock1	//stock2 to list object


	}


	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes) {

		/*
		Quotes qutoes=new Quotes();

		List<String> quoteslist=new ArrayList<>();
		quoteslist.add("stock1");
		quoteslist.add("stock2");
		qutoes.setUserName("ramu");
		qutoes.setQuotes(quoteslist);
		return qutoes;

		Quote quote1=new Quote("ramu","stock1");
		Quote		quote2=new Quote("ramu","stock2");

		quotesRepository.save(quote1);
		quotesRepository.save(quote2);
		*/

		quotes.getQuotes().stream()
		.map(quote -> new Quote(quotes.getUserName(), quote))
				.forEach(quote -> {
					System.out.println("Quotes "+quote);
					quotesRepository.save(quote);
				}

			);

		//quotes.getQuotes().stream() // qutoes.getUsername-> ramu
		//quotes.getquotes() ->"STOCK1","STOCKET2","STOCK3"

		//for reach(qutoes:quotes.getQuotes())
		//{
		    // Quote dbObj=new Quote(qutoes.getUserName,"STOCK1");
		// Quotesrepo.save(dbObj);

		//}
      System.out.println("Username "+quotes.getUserName());


		return getQuotesByUserName(quotes.getUserName());
		//return getQuotesByUserName(quotes.getUserName());
	}





    @PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username") final String username) {

        List<Quote> quotes = quotesRepository.findByUserName(username);
        quotesRepository.deleteAll(quotes);

        return getQuotesByUserName(username);
    }


}
