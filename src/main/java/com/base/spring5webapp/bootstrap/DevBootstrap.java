package com.base.spring5webapp.bootstrap;

import com.base.spring5webapp.model.Address;
import com.base.spring5webapp.model.Author;
import com.base.spring5webapp.model.Book;
import com.base.spring5webapp.model.Publisher;
import com.base.spring5webapp.repositories.AddressRepository;
import com.base.spring5webapp.repositories.AuthorRepository;
import com.base.spring5webapp.repositories.BookRepository;
import com.base.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private AddressRepository addressRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        AddressRepository addressRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.addressRepository = addressRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        // Eric
        Author eric = new Author("Eric", "Evans");

        Address firstAddress = new Address("31-223", "malopolskie", "Krakow");
        Publisher someOne = new Publisher("SuperMarioBrothers", firstAddress);

        Book ddd = new Book("Domain Driven Design", "1234", someOne);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        addressRepository.save(firstAddress);
        publisherRepository.save(someOne);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");

        Address secondAddress = new Address("41-224", "mazowieckie", "Warszawa");
        Publisher secondPublisher = new Publisher("BestInTheWorld", secondAddress);

        Book noEJB = new Book("J2EE Development without EJB", "23444", secondPublisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        addressRepository.save(secondAddress);
        publisherRepository.save(secondPublisher);
        bookRepository.save(noEJB);

    }
}
