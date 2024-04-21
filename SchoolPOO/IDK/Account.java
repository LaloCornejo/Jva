package SchoolPOO.IDK;
public class Account {
    
    private double balance;

    public Account( double initilalBalance ){

        if(initilalBalance > 0.0)
            balance = initilalBalance;
    }

    public void credit( double amount ){

        balance = balance + amount;
    }

    public double getBalance(){
            
            return balance;
    }
}
