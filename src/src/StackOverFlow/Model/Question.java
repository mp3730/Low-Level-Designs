package StackOverFlow.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question {
    private int questId;
    private User author;
    private String title;
    private String content;
    private Vote votes;
    private Tag tag;
    private Date datePosted;
    private List<Answer> answerList;
    private List<Comment> commentList;

    public Question(User user, String title, String content, Tag tag) {
        this.questId = generateId();
        this.author = user;
        this.title = title;
        this.content = content;
        this.votes = new Vote( 0);
        this.tag = tag;
        this.datePosted = new Date();
        this.answerList = new ArrayList<>();
        this.commentList = new ArrayList<>();
    }

    public int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE); //to generate unique id till some limit
    }

    public void addAnswer(Answer answer) {
        this.answerList.add(answer);
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
