package app;

//imports here
// YOUR CODE HERE
import java.util.Random;
import client.Person;
import goods.Item;
import payment.CreditCard;

public class Controller {

    public static void main(String[] args) throws InterruptedException{

        // create a person variable named john with following info:
        // FirstName: John
        // LastName: Doe
        // Street Address: 1100 Brickell Ave
        // Suite Address: Apt 102
        // City: Miami
        // State: Florida
        // YOUR CODE HERE
        Person john = new Person("John", "Doe", "1100 Brickell Ave", "Apt 102", " Miami", "Florida");
        
        // create a Credit Card variable named masterCard with the following info:
        // cardHolder: the person that you create above
        // Type: MasterCard
        // Credit Limit: 2500.00
        // YOUR CODE HERE
        CreditCard masterCard = new CreditCard(john,"MasterCard", 2500.00);
        
        // create a Credit Card variable named ax with the following info:
        // cardHolder: the person that you create above
        // Type: American Express
        // Credit Limit: 5000.00
        // YOUR CODE HERE
        CreditCard ax = new CreditCard(john, "American Express", 5000.00);

        //adding the masterCard to john
        john.getCreditCards().add(masterCard);
        
        
        // add the American Express to the person john
        john.getCreditCards().add(ax);

        // creating and Item variable named cafeMocha with the following info:
        Item cafeMocha = new Item("Food", "Cafe Mocha", 4.77);
        
        // creating and Item variable named gucciSlipper with the following info:
        // Cataory: Clothing
        // Name: Gucci Princetown
        // Price: 2650.00
        // YOUR CODE HERE
        Item gucciSlipper = new Item("Clothing", "Gucci Princetown", 2650.00);

        // creating and Item variable named coke with the following info:
        // Cataory: Food
        // Name: Coke
        // Price: 1.99
        // YOUR CODE HERE
        Item coke = new Item("Food", "Coke", 1.99);

        // creating and Item variable named airlinesTicket with the following info:
        // Cataory: Travel
        // Name: MIA-SFO
        // Price: 823.26
        // YOUR CODE HERE
        Item airlinesTicket = new Item("Travel", "MIA-SFO", 823.26);
        
        // john is buying cafeMocha using his MasterCard credit card
        ((CreditCard)john.getCreditCards().get(0)).makeCharge(cafeMocha);
        
        // john is buying gucciSlipper using his MasterCard credit card
        // hint this may run into credit limit issues
        // YOUR CODE HERE
        ((CreditCard)john.getCreditCards().get(0)).makeCharge(gucciSlipper);
        
        
        // john is buying gucciSlipper using his American Express credit card
        // YOUR CODE HERE
        ((CreditCard)(john.getCreditCards().get(0))).makeCharge(gucciSlipper);

        // john is running a transaction Report on his MasterCard
        ((CreditCard)john.getCreditCards().get(0)).transactionsReport();
        
        // john is running a transaction Report on his American Express
        // YOUR CODE HERE
        ((CreditCard)john.getCreditCards().get(0)).transactionsReport();
        
        Random generator = new Random();
        
        // buying 7 cafeMocha using different credit cards
        for(int i = 1; i <= 7; i++){
            
        // DO NOT MESS WITH THE SLEEP CODE
        // sleep for a random time upto 1 seconds
        Thread.sleep(generator.nextInt(1001));
        
        // buy cafeMocha on MasterCard if the cafeMocha is a multiple 3
        // else buy it on the AX card
        // example
        // i = 1 -> Buy it on the AX
        // i = 2 -> Buy it on the AX
        // i = 3 -> Buy it on the MasterCard
        // i = 4 -> Buy it on the AX
        // ...
        // hint use if else statement
        // YOUR CODE HERE
            if(i % 3 == 0) {
                ((CreditCard)(john.getCreditCards().get(0))).makeCharge(cafeMocha);
            }
                else {
                    ((CreditCard)(john.getCreditCards().get(1))).makeCharge(cafeMocha);
                }
        }//end for
        
        // buying 5 airlinesTicket using different credit cards
        for(int i= 1; i <= 5; i++){
            
            // DO NOT MESS WITH THE SLEEP CODE
            // sleep for a random time upto 1 seconds
            Thread.sleep(generator.nextInt(1001));
            
            // buy airlinesTicket on MasterCard if i is even
            // else buy it on the AX card
            // hint use if else statement
            // YOUR CODE HERE
             if(i % 2 == 0) {
                ((CreditCard)(john.getCreditCards().get(0))).makeCharge(airlinesTicket);
            }
                else {
                    ((CreditCard)(john.getCreditCards().get(1))).makeCharge(airlinesTicket);
                }           
        }//end for
        
        // buying 10 cokes using different credit cards
        for(int i = 1; i <= 10; i++) {
            
            // sleep for a random time upto 1 seconds
            Thread.sleep(generator.nextInt(1001));
            
            // this is use to be randomly select a credit card
            int randomSelectCard = generator.nextInt(2);
            
            // if randomSelectCard is 0 use the MasterCard
            // if this is the case print out "randomSelectCard: MasterCard"
            // if randomSelectCard is 1 use the American Express
            // if this is the case print out "randomSelectCard: MasterCard"
            // hint use if else statement
            // YOUR CODE HERE
            if(randomSelectCard == 0) {
                ((CreditCard)john.getCreditCards().get(0)).makeCharge(coke);
            }
                else {
                    ((CreditCard)john.getCreditCards().get(1)).makeCharge(coke);
                }    
        }//end for
        
        // john is running a transaction Report on his masterCard
        // YOUR CODE HERE
        ((CreditCard)(john.getCreditCards().get(0))).transactionsReport();
        
        // john is running a transaction Report on his American Express
        // YOUR CODE HERE
        ((CreditCard)(john.getCreditCards().get(1))).transactionsReport();
        
        // john is running displayInfo method
        // YOUR CODE HERE
        //           transactionsReport().displayInfo();
        john.displayInfo();
        
    }//end main
    
    
}//end class