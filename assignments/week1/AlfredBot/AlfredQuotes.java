
import java.time.LocalDateTime;
import java.util.Date;

public class AlfredQuotes {
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        String greeting = "Hello," + String.format(name) + ".Lovely to see you!";
        System.out.println(greeting);
        return greeting;
    }
    
    public String dateAnnouncement() {
        Date currentDate = new Date();
        String dateString = "It is currently " + currentDate;
        return dateString;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if (conversation.contains("Alexis")) {
            String response = "Right away, sir. She certainly isn't sophisticated enough for that.";
            return response;
        }
        if (conversation.contains("Alfred")) {
            String response = "At your service, is. As you wish, naturally.";
            return response;
        }
        if (conversation.contains("Alexis")|| conversation.contains("Alfred")) {
            String response = "Right. And with that I shall retire.";
            return response;
        }
        else {
            return conversation;        
        }
    }
	// method overloading with guestGreeting
    public String guestGreeting () {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        String response = "Good morning," + userName + ". Lovely to see you. It is now" + currentDateTime;
            return response;
    }
}

