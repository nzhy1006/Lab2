/**
 * 
 */
/**
 * @author 倪郑鸿远
 *
 */
package Model;


public class Book {
    private String isbn;
    private String title;
    private String authorID;
    private String publisher;
    private String publishdate;
    private double price;
    
    public Book() {        
    }
    
    public Book(String isbn, String title, String authorID, 
    		  String publisher, String publishdate, double price) {
        this.isbn = isbn;
        this.title = title;
        this.authorID = authorID;
        this.publisher = publisher;
        this.setPublishdate(publishdate);
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }  
    
    public String getAuthorID() {
    	return authorID;
    }
    
    public void setAuthorID(String authorID) {
    	this.authorID = authorID;
    }
    
    public String getPublisher() {
    	return publisher;
    }
    
    public void setPublisher(String publisher) {
    	this.publisher = publisher;
    }
    
    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

      
}