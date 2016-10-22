/**
 * class that can be used to represent a candidate running in an election.
 * stores the candidates name and political party.
 * @author Jack Nevalainen (113433498)
 */
public class Candidate{
    private String name;
    private String party;
    
    public Candidate( String name, String party){
        this.name = name;
        this.party = party;
    }
    /**
     * gets a candidates name
     * @return the candidates name
     */
    public String getName(){
        return name;   
    }
    /**
     * allows you to set the name of a candidate
     * @param name the name you want to set for a candidate
     */
    public void setName( String name ){
        this.name = name;   
    }
    /**
     * gets a candidates party
     * @return the candidates party
     */
    public String getParty(){
        return party;
    }
    /**
     * allows you to set the party of a candidate
     * @param party the party you want to set for a candidate
     */
    public void setParty( String party ){
        this.party = party;   
    }
}
