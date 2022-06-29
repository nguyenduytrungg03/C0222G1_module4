package com.library.controller;

import com.library.model.Book;
import com.library.model.OrdBook;
import com.library.service.IBookService;
import com.library.service.IOrdBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private IOrdBookService iOrdBookService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("listBook", iBookService.findAll());
        return "home";
    }

    @GetMapping("/view/{id}")
    public String borrowBook(@PathVariable int id, Model model) {
        Book book = iBookService.findById(id);
        if (book.getAmount() <= 0) {
            model.addAttribute("mess", "Sách không thể mượn được");
            model.addAttribute("listBook", iBookService.findAll());
            return "home";
        } else {
            model.addAttribute("book", book);
            Integer random = (int) Math.floor((Math.random() * 89999) + 10000);
            model.addAttribute("random", random);
            model.addAttribute("orderBook", new OrdBook(random, book));
            return "display";
        }
    }

    @PostMapping("/save")
    public String backToHome(OrdBook ordBook) {
        Book book = iBookService.findById(ordBook.getBook().getIdBook());
        book.setAmount(book.getAmount() - 1);
        iBookService.save(book);
        iOrdBookService.save(ordBook);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String giveBack(@RequestParam(name = "id") Integer id, Model model) {
        List<OrdBook> ordBookList = iOrdBookService.findAll();
        for (OrdBook item : ordBookList) {
            if (item.getCodeRandom().equals(id)) {
                iOrdBookService.remove(item);
                model.addAttribute("listBook", iBookService.findAll());
                Book book = iBookService.findById(item.getBook().getIdBook());
                book.setAmount(book.getAmount() + 1);
                iBookService.save(book);
                model.addAttribute("mess", "Trả sách thành công");
                return "home";
            }
        }
        model.addAttribute("mess", "Không có id này");
        return "home";
    }
}
