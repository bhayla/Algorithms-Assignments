/**
 * test class used to simulate a simple election and test the VoteCounter, BalloPaper and 
 * Candidate classes.
 * @author Jack Nevalainen (113433498) 
 */
public class TestElection{
/* simulates 6 different ballots and gets the winner of the election*/
    public static void main(String args[]){
       
        Candidate john = new Candidate("john","fine gael");
        Candidate paul = new Candidate("paul","fine gael");
        Candidate mike = new Candidate("mike","green");
        Candidate philip = new Candidate("philip","green");
        ArrayBasedList<Candidate> candidates = new ArrayBasedList<Candidate>();   
        candidates.add( paul );
        candidates.add( philip );
        candidates.add( mike );
        candidates.add( john );
        ArrayBasedList<BallotPaper> ballots = new ArrayBasedList<BallotPaper>();
        
        BallotPaper first = new BallotPaper();
        first.setPreference(1,john);
        first.setPreference(2,mike);
        first.setPreference(3,paul);
        first.setPreference(4,philip);
        ballots.add(first);
        
        BallotPaper second = new BallotPaper();
        second.setPreference(1,mike);
        second.setPreference(2,john);
        second.setPreference(3,paul);
        second.setPreference(4,philip);
        ballots.add(second);
        
        BallotPaper third = new BallotPaper();
        third.setPreference(1,mike );
        third.setPreference(2,john);
        third.setPreference(3,paul);
        third.setPreference(4, philip);
        ballots.add(third);
        
        BallotPaper fourth = new BallotPaper();
        fourth.setPreference(1,paul );
        fourth.setPreference(2,john);
        fourth.setPreference(3,mike);
        fourth.setPreference(4,philip);
        ballots.add(fourth);
        
        BallotPaper fith = new BallotPaper();
        fith.setPreference(1,philip );
        fith.setPreference(2,mike);
        fith.setPreference(3,john);
        fith.setPreference(4,paul);
        ballots.add(fith);
       
        BallotPaper six = new BallotPaper();
        six.setPreference(1,paul );
        six.setPreference(2,mike);
        six.setPreference(3,philip);
        six.setPreference(4,john);
        ballots.add(six);
        
        VoteCounter voteCounter = new VoteCounter( candidates );
        Candidate winer = voteCounter.determineResult( ballots );
        System.out.println( "Winner = " + winer.getName());
    }
}