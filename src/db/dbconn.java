/**
 * 
 */
/**
 * @author 倪郑鸿远
 *
 */
package db;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
//import java.util.Date;


import Model.Author;
import Model.Book;

import com.mysql.jdbc.PreparedStatement;

public class dbconn {
	static String driver = "com.mysql.jdbc.Driver";
	//static String url = "jdbc:mysql://localhost:3306/bookdb?useUnicode=true&characterEncoding=UTF-8";
	//static String user = "root";
	//static String password = "nzhy1006";
	
    static String url = String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=UTF-8",
    		       System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));
	//static String user = "33l1m23l01";
	//static String password = "llizkzm21230w5miwhzk521ihzhil0x5i421l04m";
	static String user = System.getenv("ACCESSKEY");
	static String password = System.getenv("SECRETKEY");
	
	private Connection conn;  
    
	private static void init() {
        try {
	        Class.forName(driver).newInstance();
	    } catch(ClassNotFoundException e) {  
	        System.out.println("sorry, can't find the driver!");  
	        e.printStackTrace();  
  	    }  catch(Exception e) {
	        e.printStackTrace();
	    }
	} 

	public ConcurrentMap<String, Book> list() {
		
	    ConcurrentMap<String, Book> data = new ConcurrentHashMap<String, Book>();

		try {  
		    init();
		    conn = DriverManager.getConnection(url, user, password);  
		    conn.setAutoCommit(false); 
		    Statement statement = conn.createStatement();
		    String sql = "select * from book";
		    ResultSet rs;
		    rs = statement.executeQuery(sql);
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		    while(rs.next()) {
			    java.util.Date date=new java.util.Date();  
			    date = (java.util.Date) rs.getDate("publishdate");
			    String str = sdf.format(date); 
		        Book bb = new Book(rs.getString("isbn"),rs.getString("title"),
		    	     	rs.getString("authorID"),rs.getString("publisher"),
		    		    str,rs.getDouble("price"));    	
		        data.put(rs.getString("isbn"), bb);
		    } 
		    rs.close(); 
		    statement.close();
		    conn.close();
		    
		} catch (Exception e) {  
		    System.out.println("取得连接错误");  
		    System.out.println(e.getMessage());  
		}  
		return data;
	}

	public void update(Book book) {
		init();
		String sql="update book set title=?,authorID=?,publisher=?,publishdate=?,price=? where isbn=?";
		try {  
		    conn = DriverManager.getConnection(url, user, password);  
		
		PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql);
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");    
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  

		String str = book.getPublishdate(); 
		java.util.Date d = null;
		try {
			sim.setLenient(true);
			d = sim.parse(str);
			java.sql.Date date = new java.sql.Date(d.getTime());
			String newd = sdf.format(d);
			book.setPublishdate(newd);
			preStmt.setString(1, book.getTitle());
		    preStmt.setString(2, book.getAuthorID());
		    preStmt.setString(3, book.getPublisher());
		    //preStmt.setDate(4, UtilToSql(book.getPublishdate()));
		    //preStmt.setString(4, book.getPublishdate());
		    preStmt.setDate(4, date);
		    preStmt.setDouble(5, book.getPrice());
		    preStmt.setString(6, book.getIsbn());
		    preStmt.executeUpdate();
		    preStmt.close();
		    conn.close();
		} catch (ParseException e) {
			e.printStackTrace();
		}} catch (Exception e) {  
		    System.out.println("取得连接错误");  
		    System.out.println(e.getMessage());  
		}
	}
	
	public boolean store(Book book) {
		init();
		
		//statement = getConn().createStatement();
		String sql = "insert into book(isbn,title,authorID,publisher,publishdate,price) values(?,?,?,?,?,?)";
		try {  
		    conn = DriverManager.getConnection(url, user, password);  
		 
		PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql);
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");    
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  

		String str = book.getPublishdate(); 
		java.util.Date d = null;
		
		
		try {
		    sim.setLenient(true);
			d = sim.parse(str);
			java.sql.Date date = new java.sql.Date(d.getTime());
			String newd = sdf.format(d);
			book.setPublishdate(newd);
			preStmt.setString(1, book.getIsbn());
			preStmt.setString(2, book.getTitle());
		    preStmt.setString(3, book.getAuthorID());
		    preStmt.setString(4, book.getPublisher());
		    //preStmt.setDate(5, UtilToSql(book.getPublishdate()));
		    preStmt.setDate(5, date);
		    preStmt.setDouble(6, book.getPrice());
		    preStmt.executeUpdate();
		    preStmt.close();
		    conn.close();
		} catch (ParseException e) {
			e.printStackTrace();
		}} catch (Exception e) {  
		    System.out.println("取得连接错误");  
		    System.out.println(e.getMessage());  
		}
		return isexistauid(book.getAuthorID());
	}
	
	public void remove(String isbn) {
		init();
		String sql = "delete from book where isbn= '" + isbn + "'"; 
		try {  
		    conn = DriverManager.getConnection(url, user, password);  
		
		PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql);
		preStmt.executeUpdate();
		preStmt.close();
		conn.close();
		} catch (Exception e) {  
		    System.out.println("取得连接错误");  
		    System.out.println(e.getMessage());  
		}
	}
	
	
	
	private String findID(String au_name) {
		init();
		String str = "";
		try {  
		    conn = DriverManager.getConnection(url, user, password);  
		 
		Statement statement = conn.createStatement();
		String sql = "select authorid,name,age,country from author";
		ResultSet rs;
		rs = statement.executeQuery(sql);
		while(rs.next()) {
			if(rs.getString("name").equals(au_name)){
		        str = rs.getString("authorid");
		        System.out.println(str);
		        break;
			}
		} 
		rs.close(); 
		statement.close();
		conn.close();
		} catch (Exception e) {  
		    System.out.println("取得连接错误");  
		    System.out.println(e.getMessage());  
		}  
		return str;
	}
	
    public ConcurrentMap<String, Book> au_list(String au_name) {
		
	    ConcurrentMap<String, Book> data = new ConcurrentHashMap<String, Book>();
        String au_id = findID(au_name);
        init();
        
		try {  
		    conn = DriverManager.getConnection(url, user, password);  
		
		Statement statement = conn.createStatement();
		String sql = "select isbn,title,authorID,publisher,publishdate,price from book";
		ResultSet rs;
		rs = statement.executeQuery(sql);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  

		while(rs.next()) {
			if(rs.getString("authorid").equals(au_id)){
				java.util.Date date=new java.util.Date();  
		    	date = (java.util.Date) rs.getDate("publishdate");
		    	String str = sdf.format(date); 
		        Book bb = new Book(rs.getString("isbn"),rs.getString("title"),
		    		rs.getString("authorID"),rs.getString("publisher"),
		    		str,rs.getDouble("price"));    	
		        data.put(rs.getString("isbn"), bb);
			}
		} 
		rs.close(); 
		statement.close();
		conn.close();
		} catch (Exception e) {  
		    System.out.println("取得连接错误");  
		    System.out.println(e.getMessage());  
		}  
		return data;
	}
    
    public boolean isexistauid(String au_id) {
    	init();
    	
    	boolean jug = false;
    	Statement statement;
		try {  
		    conn = DriverManager.getConnection(url, user, password);  
		
		statement = conn.createStatement();
		String sql = "select authorid,name,age,country from author";
		ResultSet rs;
		rs = statement.executeQuery(sql);
		while(rs.next()) {
			if(rs.getString("authorid").equals(au_id)){
				jug = true;
				break;
			}
		}
		} catch (Exception e) {  
		    System.out.println("取得连接错误");  
		    System.out.println(e.getMessage());  
		}
        
    	return jug;
    }
    
    public Author findauthor(String authorID) {
    	init();
		Author author = new Author();
		try {  
		    conn = DriverManager.getConnection(url, user, password);  
		
		Statement statement = conn.createStatement();
		String sql = "select authorid,name,age,country from author";
		ResultSet rs;
		rs = statement.executeQuery(sql);
		while(rs.next()) {
			if(rs.getString("authorid").equals(authorID)){
		        author.setAuthorID(rs.getString("authorid"));
		        author.setName(rs.getString("name"));
		        author.setAge(rs.getInt("age"));
		        author.setCountry(rs.getString("country"));
		        break;
			}
		} 
		rs.close(); 
		statement.close();
		conn.close();
		} catch (Exception e) {  
		    System.out.println("取得连接错误");  
		    System.out.println(e.getMessage());  
		}  
		return author;
    }
    
    public void storeAuthor(Author au) {
init();
		
		String sql = "insert into author(authorid,name,age,country) values(?,?,?,?)";
		try {  
		    conn = DriverManager.getConnection(url, user, password);  
		
		PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql);        	
		
		preStmt.setString(1, au.getAuthorID());
		preStmt.setString(2, au.getName());
		preStmt.setInt(3, au.getAge());
		preStmt.setString(4, au.getCountry());

		preStmt.executeUpdate();
		preStmt.close();
		conn.close();
		} catch (Exception e) {  
		    System.out.println("取得连接错误");  
		    System.out.println(e.getMessage());  
		}
    }
	
}