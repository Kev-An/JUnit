import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount account;
    private static int count;
    @org.junit.BeforeClass
    public static void beforeClass(){
        System.out.println("this executes before any test case. count = "+count++);
    }

    @org.junit.Before
    public void setup(){
        account = new BankAccount("Kevin", "Anthony", 1000.00,BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @org.junit.Test
    public void getBalance_deposit() throws Exception {
        account.deposit(200.00,true);
        assertEquals(1200, account.getBalance(),0);

    }

    @org.junit.Test
    public void deposit() throws Exception{
        double balance = account.deposit(200.00,true);
        assertEquals(1200, balance,0);
        assertEquals(1200.00, balance,0);
    }

    @org.junit.Test
    public void getBalance_withdraw() throws Exception {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void withdraw_branch() throws Exception{
        double balance =account.withdraw(600.00,true);
        assertEquals(400.00,balance,0);
    }

    @org.junit.Test
    public void withdraw_notBranch(){
        double balance = account.withdraw(600.00,false);
        assertEquals(400.00,balance,0);
    }
    @org.junit.Test
    public void isChecking_true(){
        assertTrue("This account is not a Checking Account ",account.isChecking());
    }
    @org.junit.AfterClass
    public static void afterClass(){
        System.out.println("prints after any test case count = "+count++);


    }
    @org.junit.After
    public void teardown(){
        System.out.println("count = "+count++);
    }



}