/**
 * 
 */
/**
 * @author 倪郑鸿远
 *
 */
package action;

import java.util.Collection;

import Dao.AuthorDao;
import Dao.BookDao;
import Model.Book;
import Model.Author;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
    private static final long serialVersionUID = 872316812305356L;
    
    private String isbn;
    private String[] isbns;
    private Book book;
    private Author author;
    private Collection<Book> books;
    private BookDao dao =  BookDao.getInstance();
    private AuthorDao au_dao = AuthorDao.getInstance();
            
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String[] getIsbns() {
        return isbns;
    }

    public void setIsbns(String[] isbns) {
        this.isbns = isbns;
    }
        
    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    public String load() {
        book = dao.getBook(isbn);
        author = au_dao.getAuthor(book.getAuthorID());
        return SUCCESS;
    }

    public String list() {
        books = dao.getBooks();
        return SUCCESS;
    }
    
    public String update() {
    	dao.updateBook(book);
    	return SUCCESS;
    }
        
    public String store() {
    	boolean jug = false;
        jug = dao.storeBook(book);
        if (jug == true) {
            return SUCCESS;
        }
        return "ff";
    }
    
    public String storeall() {
    	author.setAuthorID(book.getAuthorID());
    	dao.storeBook(book);
    	au_dao.storeAu(author);
    	return SUCCESS;
    }
    
    public String remove() {
        if(null != isbn) {
            dao.removeBook(isbn);
        } else {
            dao.removeBooks(isbns);
        }
        return SUCCESS;
    }

}