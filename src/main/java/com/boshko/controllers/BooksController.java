package com.boshko.controllers;

import com.boshko.entities.Book;
import com.boshko.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {
    private BooksService booksService;

    @Autowired
    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }

    @RequestMapping("/list")
    public String showBooksList(Model model) {
        List<Book> allBooks = booksService.getAllBooksList();
        model.addAttribute("booksList", allBooks);
        System.out.println("Получаем список книг");
        return "books-list";
    }

    @RequestMapping(path="/add", method= RequestMethod.GET)
    public String showAddForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "add-book";
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String showAddForm(Book book) {
        System.out.println("Добавляем новую книгу");
        booksService.addBook(book);
        return "redirect:/books/list";
    }

    @RequestMapping(path="/remove/{id}", method=RequestMethod.GET)
    public String removeById(@PathVariable(value = "id") Long bookId) {
        System.out.println("Удаляем книгу из списка");
        booksService.removeById(bookId);
        return "redirect:/books/list";
    }

}
