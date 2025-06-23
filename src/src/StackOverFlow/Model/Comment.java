package StackOverFlow.Model;

import java.util.Date;

public class Comment {
    private int commentId;
    private User author;
    private String content;
    private Date datePosted;

    public Comment(User author, String content) {
        this.commentId = generateId();
        this.author = author;
        this.content = content;
        this.datePosted = new Date();
    }

    public int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE); //to generate unique id till some limit
        //we can use UUID from java utils to generate the universal unique id : UUID uniqueId = UUID.randomUUID();
    }

    public int getCommentId() {
        return commentId;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Date getDatePosted() {
        return datePosted;
    }
}

