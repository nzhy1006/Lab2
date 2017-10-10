package Dao;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import Model.Author;
import Model.Book;
import db.dbconn;

public class AuthorDao {
	
    static dbconn database;
    private static final AuthorDao instance = new AuthorDao();
    
   // static {
    	
    //}
    
    public AuthorDao() {
    	database = new dbconn();
    }
    
    public static AuthorDao getInstance() {
		return instance;
	}
    
    public Collection<Book> listBooks(String name) {
	    ConcurrentMap<String, Book> data = new ConcurrentHashMap<String, Book>();
	    data = database.au_list(name); 
    	return data.values();
    }
    
    public Author getAuthor(String authorID) {
    	Author author = new Author();
    	author = database.findauthor(authorID);
    	return author;
    }
    
    public void storeAu(Author author) {
    	database.storeAuthor(author);
    }
    
}
