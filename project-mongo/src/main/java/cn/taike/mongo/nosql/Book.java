package cn.taike.mongo.nosql;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by huayandong on 17/7/27.
 */
@Document(collection = "book")
public class Book {

    private String bookId;

    private String bookName;

    private String projectName;

    private String type;

    private double price;


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Book(String bookId, String bookName, String projectName, String type, double price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.projectName = projectName;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
