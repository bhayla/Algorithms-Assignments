import java.util.Random;
/**
 * class that you feed in a list of running candidates and then call its determine 
 * results method with a list of ballots from a vote and the winner is decided.
 * @author Jack Nevalainen (113433498)
 */
public class VoteCounter{
    private List<Candidate> candidates;
    private ArrayBasedMap< Candidate, ArrayBasedList<BallotPaper> > candidatesVotes;
    private int numberOfRemainingCandidates;
    private int highestPossiblePreference;
    private int numberOfRunningCandidates;
    
    public VoteCounter( List<Candidate> candidates ){
        this.candidates =  candidates; 
        numberOfRunningCandidates = candidates.size();
        numberOfRemainingCandidates = numberOfRunningCandidates;
        highestPossiblePreference = 1;
        
    }
    /**
     * returns the candidate that has the least amount of votes per round. If there are multiple
     * candidates with the same amount of votes as the least amount of votes one is 
     * randomly selected to be the loser
     * @return the loosing candidate
     */
    private Candidate getLeastVoted( ){
           ArrayBasedList<Candidate> losers = new ArrayBasedList<Candidate>();
           losers.add(candidates.get(0));
           int leastNumOfVotes = candidatesVotes.get( candidates.get(0) ).size();
           for(int i=1; i < candidates.size(); i++){
                Candidate candidate = candidates.get(i);
                int NumVotes = candidatesVotes.get( candidate ).size();
                if( NumVotes < leastNumOfVotes ){
                    for(int j=0; j < losers.size(); j++){
                        losers.remove(j);
                    }
                    losers.add(candidate);
                    leastNumOfVotes = NumVotes;
                }
                else if( NumVotes == leastNumOfVotes ){
                    losers.add(candidate);
                }
            }
            Candidate loser;
            if(losers.size()==1){
                loser = losers.get(0);
            }
            else{
                Random generator = new Random();
                loser =  losers.get( generator.nextInt( losers.size() ) );
            }
            return loser;
    }
    /**
     * removes a candidate from the election and returns the ballots they had
     * @return the eliminated candidates ballots
     */
    private ArrayBasedList<BallotPaper> eliminateCandidiate(){
        Candidate loser = getLeastVoted();
        ArrayBasedList<BallotPaper> losersVotes = candidatesVotes.get( loser );
        candidatesVotes.remove(loser);
        int index = 0;
        for(int i=0; i < candidates.size(); i++){
               if(candidates.get(i) == loser){
                    index = i;    
               }
        }
        candidates.remove(index);
        return losersVotes;
    }
    /**
     * distributes a list of ballots between remaining candidates 
     * @param votesToDistribute a list of the ballots you want to distribute
     */
    private void distributeVotes(List<BallotPaper> votesToDistribute){
        for(int i=0; i < votesToDistribute.size(); i++){
            int tempHighestPossiblePreference = highestPossiblePreference;
            BallotPaper vote = votesToDistribute.get(i);
            boolean FoundvoteToGive = false;
            Candidate candidate = null;
            while( !FoundvoteToGive && (tempHighestPossiblePreference <= numberOfRunningCandidates)){
                candidate = vote.getPreference( tempHighestPossiblePreference );
                for(int j=0; j < candidates.size(); j++){
                    if(candidates.get(j) == candidate){
                        FoundvoteToGive = true;
                    }
               }
               tempHighestPossiblePreference++;
            }
            ArrayBasedList<BallotPaper> myVotes = candidatesVotes.get( candidate );
            myVotes.add( vote );
            candidatesVotes.put(candidate, myVotes );
        }
    }
    /**
    * determines the result of an election by calling helper methods to eliminate the candidate with
    * the least number of votes after each round and then distributes that candidates votes until there
    * is only one candidate left. 
    * @param votesCast a list of the ballots from the election
    * @return The winning candidate.
    */
    public Candidate determineResult(List<BallotPaper> votesCast){
     
        candidatesVotes = new ArrayBasedMap< Candidate, ArrayBasedList<BallotPaper> >();
        for(int i=0; i < candidates.size(); i++){
            candidatesVotes.put( candidates.get(i), new ArrayBasedList<BallotPaper>() );
        }    
        distributeVotes( votesCast);
        
        ArrayBasedList<BallotPaper> votesToDistribute;
        highestPossiblePreference++;
        while(numberOfRemainingCandidates > 1){
            votesToDistribute = eliminateCandidiate() ;
            distributeVotes(votesToDistribute);
            numberOfRemainingCandidates--;
        }
        return  candidates.get(0);  
    } 
}