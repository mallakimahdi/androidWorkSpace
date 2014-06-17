
public class AccountRecord 
{
	private int accountNumber;
	private String firstName;
	private String lastName;
	private double balance;
	
	public AccountRecord() 
	{}
	
	public AccountRecord(int account, String name, String family, double balance)
	{
		setAccountNumber(account);
		setFirstName(name);
		setLastName(family);
		setBalance(balance);
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
