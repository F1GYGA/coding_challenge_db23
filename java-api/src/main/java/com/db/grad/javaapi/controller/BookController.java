package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.dto.BondDto;
import com.db.grad.javaapi.dto.BookDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.service.BondService;
import com.db.grad.javaapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BondService bondService;

    @GetMapping("/books")

    public List<BookDto> getUserBooks() {

        List<BookDto> list = new ArrayList<>();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Book> userBooks = bookService.getUserBooks(username);

        for (Book book : userBooks) {
            List<Bond> bondsInBook = bondService.getBondsInBook(book);
            List<BondDto> bondDtoList = new ArrayList<>();
            for (Bond bond: bondsInBook) {
                List<CounterParty> holders = bondService.getHolders(bond);
                bondDtoList.add(new BondDto(bond.getIsin(), bond.getCusip(), bond.getBondCurrency(), bond.getCouponPercent(),
                        bond.getFaceValue(), bond.getIssuerName(), bond.getStatus(), bond.getType(), bond.getMaturityDate(), holders));
            }
            list.add(new BookDto(book.getId(), book.getBookName(), bondDtoList));
        }

        return list;
    }
}
