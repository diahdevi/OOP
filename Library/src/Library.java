import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Book> borrowedBooks;

    public Library(){
        books = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);
        System.out.println("Book added to library: " + book.getTitle());
    }

    public void borrowBook(Borrower borrower, Book book){
        if(books.contains(book)){
            books.remove(book);
            borrowedBooks.add(book);
            borrower.borrowBook(book);
            System.out.println(borrower.getName() + " borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not borrowed: " + book.getTitle());
        }
    }

    public void returnBook(Borrower borrower, Book book){
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            books.add(book);
            borrower.returnBook(book);
            System.out.println(borrower.getName() + " returned: " + book.getTitle());
        } else {
            System.out.println("Book not borrowed: " + book.getTitle());
        }
    }

    public void displayLibraryBooks(){
        System.out.println("Books in Library:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Author: " + book.getAuthor().getName());
            System.out.println("Biography: " + book.getAuthor().getBiography());
            System.out.println("------------------------");
        }
    }


}
