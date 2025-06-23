package StackOverFlow.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer {
    private int answerId;
    private String content;
    private User author;
    private Date datePosted;
    private Vote votes;
    private List<Comment> commentList;

    public Answer(String content, User user){
        this.answerId = generateId();
        this.content = content;
        this.author = user;
        this.datePosted = new Date();
        this.votes = new Vote(0);
        this.commentList = new ArrayList<>();
    }

    public int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE); //to generate unique id till some limit
    }

    public void addComment(Comment comment){
        this.commentList.add(comment);
    }

    public void updateVotes(VoteType voteType) {
        if (voteType == VoteType.UPVOTE) {
            this.votes.upVote();
        } else if (voteType == VoteType.DOWNVOTE) {
            this.votes.downVote();
        }
    }

    public Vote getVotes() {
        return this.votes;
    }
}
