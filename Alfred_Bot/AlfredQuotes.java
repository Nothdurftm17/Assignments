import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Hello," + name;
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "Today's date is " + date ;
    }
    
    public String respondBeforeAlexis(String conversation) {
        
        return conversation;
    }
    
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}