package StackOverFlow.Model;

public class Vote {
    private int votes;

    public Vote(int votes){
        this.votes = votes;
    }

    public int getVotes(){return this.votes;}

    public void upVote(){this.votes++;}
    public void downVote(){this.votes--;}
}
