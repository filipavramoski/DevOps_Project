package project.kiii_project.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.kiii_project.models.Author;
import project.kiii_project.models.Book;
import project.kiii_project.models.Review;
import project.kiii_project.service.BookstoreService;

@Controller
@RequestMapping("/bookstore")
public class BookstoreController {

    @Autowired
    private BookstoreService bookstoreService;


    @GetMapping("/authors")
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", bookstoreService.getAllAuthors());
        return "authors";
    }

    @GetMapping("/authors/add")
    public String addAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "add-author";
    }

    @PostMapping("/authors/add")
    public String addAuthor(@ModelAttribute Author author) {
        bookstoreService.saveAuthor(author);
        return "redirect:/bookstore/authors";
    }
    @GetMapping("/authors/edit/{id}")
    public String editAuthorForm(@PathVariable String id, Model model) {
        model.addAttribute("author", bookstoreService.getAuthorById(id));
        return "edit-author";
    }

    @PostMapping("/authors/edit/{id}")
    public String updateAuthor(@PathVariable String id, @ModelAttribute Author author) {
        author.setId(id);
        bookstoreService.saveAuthor(author);
        return "redirect:/bookstore/authors";
    }
    @GetMapping("/authors/delete/{id}")
    public String deleteAuthor(@PathVariable String id) {
        bookstoreService.deleteAuthor(id);
        return "redirect:/bookstore/authors";
    }


    @GetMapping("/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookstoreService.getAllBooks());
        return "books";
    }

    @GetMapping("/books/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", bookstoreService.getAllAuthors());
        return "add-book";
    }

    @PostMapping("/books/add")
    public String addBook(@ModelAttribute Book book) {
        bookstoreService.saveBook(book);
        return "redirect:/bookstore/books";
    }


    @GetMapping("/books/edit/{id}")
    public String editBookForm(@PathVariable String id, Model model) {
        model.addAttribute("book", bookstoreService.getBookById(id));
        model.addAttribute("authors", bookstoreService.getAllAuthors());
        return "edit-book";
    }

    @PostMapping("/books/edit/{id}")
    public String updateBook(@PathVariable String id, @ModelAttribute Book book) {
        book.setId(id);
        bookstoreService.saveBook(book);
        return "redirect:/bookstore/books";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        bookstoreService.deleteBook(id);
        return "redirect:/bookstore/books";
    }


    @GetMapping("/reviews")
    public String getAllReviews(Model model) {
        model.addAttribute("reviews", bookstoreService.getAllReviews());
        return "reviews";
    }

    @GetMapping("/reviews/add")
    public String addReviewForm(Model model) {
        model.addAttribute("review", new Review());
        model.addAttribute("books", bookstoreService.getAllBooks());
        return "add-review";
    }

    @PostMapping("/reviews/add")
    public String addReview(@ModelAttribute Review review) {
        bookstoreService.saveReview(review);
        return "redirect:/bookstore/reviews";
    }

    @GetMapping("/reviews/edit/{id}")
    public String editReviewForm(@PathVariable String id, Model model) {
        Review review = bookstoreService.getReviewById(id);
        if (review == null) {

            return "redirect:/bookstore/reviews";
        }
        model.addAttribute("review", review);
        model.addAttribute("books", bookstoreService.getAllBooks());
        return "edit-review";
    }

    @PostMapping("/reviews/edit/{id}")
    public String updateReview(@PathVariable String id, @ModelAttribute Review review) {
        review.setId(id);
        bookstoreService.saveReview(review);
        return "redirect:/bookstore/reviews";
    }

    @GetMapping("/reviews/delete/{id}")
    public String deleteReview(@PathVariable String id) {
        bookstoreService.deleteReview(id);
        return "redirect:/bookstore/reviews";
    }
}