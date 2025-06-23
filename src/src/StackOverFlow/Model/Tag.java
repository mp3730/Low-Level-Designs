package StackOverFlow.Model;

public class Tag {
    private int tagId;
    private String tagName;

    public Tag(int tagId, String tagName){
        this.tagId = tagId;
        this.tagName = tagName;
    }

    public int getTagId(){
        return this.tagId;
    }
    public String getTagName(){
        return this.tagName;
    }

}
