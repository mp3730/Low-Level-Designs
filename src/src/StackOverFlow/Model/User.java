package StackOverFlow.Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String userName;
    private int reputation;
    private String email;
    private List<Question> questionList;
    private List<Answer> answerList;
    private List<Comment> commentList;

    //reputation
    private static final int QUESTION_REPUTATION = 5;
    private static final int ANSWER_REPUTATION = 10;
    private static final int COMMENT_REPUTATION = 2;

    public User(int id, String name, String email){
        this.userId = id;
        this.userName = name;
        this.reputation = 0;
        this.email = email;
        this.questionList = new ArrayList<>();
        this.answerList = new ArrayList<>();
        this.commentList = new ArrayList<>();
    }

    public void askQuestion(String title, String content, Tag tag){
        Question question = new Question(this, title, content, tag);
        this.questionList.add(question);
        this.reputation += QUESTION_REPUTATION;
    }

    public void answerTheQuestion(String content, Question question){
        Answer answer = new Answer(content, this);
        this.answerList.add(answer);
        question.addAnswer(answer);
        this.reputation += ANSWER_REPUTATION;
    }

    public void addCommentToAnswer(String content, Answer answer){
        Comment comment = new Comment(this, content);
        this.commentList.add(comment);
        answer.addComment(comment);
        this.reputation += COMMENT_REPUTATION;
    }

    public void addCommentToQuestion(String content, Question question){
        Comment comment = new Comment(this, content);
        this.commentList.add(comment);
        question.addComment(comment);
        this.reputation += COMMENT_REPUTATION;
    }

    public void addVoteToQuestion(VoteType voteType, Question question){
        question.updateVotes(voteType);
    }

    public void addVoteToAnswer(VoteType voteType, Answer answer){
        answer.updateVotes(voteType);
    }

    public int getReputation() {
        return reputation;
    }
}
