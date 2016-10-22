/**
 * class that implements a simple ballot paper for an election.
 * @author Jack Nevalainen (113433498)
 */
public class BallotPaper{
    private ArrayBasedList<Candidate> votePreferences;
    public BallotPaper(){
        votePreferences = new ArrayBasedList<Candidate>();
    }
    /**
     * allows you to set a preference for a candidate 
     * @param n the preference you want to set.
     * @param c the candidate you want to set the preference for
     */
    public void setPreference(int n,Candidate c){
        votePreferences.add( n-1,c );
    }
    /**
     * allows you to check which candidate you selected for a certain prefernece
     * @param n the preference you want to check
     * @return the candidate at this preference
     */
    public Candidate getPreference(int n){
        return votePreferences.get( n-1 );
    }
}