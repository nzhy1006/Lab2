package action;

import java.util.Collection;

import Dao.AuthorDao;

import Model.Book;

import com.opensymphony.xwork2.ActionSupport;

public class AuthorAction extends ActionSupport {
	private static final long serialVersionUID = -1154781281228131458L;
	
    private String name;
    private Collection<Book> books;
    private AuthorDao dao =  AuthorDao.getInstance();
    private int aa;
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
	
	public int getAa() {
		return aa;
	}

	public void setAa(int aa) {
		this.aa = aa;
	}
    
    public String showBooks() {
    	books = dao.listBooks(name);
    	return SUCCESS;
    }

	

	
    
}
