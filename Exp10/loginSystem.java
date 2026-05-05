package Exp10;
import java.util.Scanner;
public class loginSystem {
    static class InvalidCredentialsException extends Exception {
        public InvalidCredentialsException(String user) {
            super("Invalid password for user: " + user);
        }
    }
    static class AccountLockedException extends Exception {
        public AccountLockedException(String user, int min) {
            super("Account locked for user: " + user + " for " + min + " minutes");
        }
    }
    static class LoginSystem {
        private String[][] users = {
            {"sanjeet", "1234"}
        };
        private int attempts = 0;
        public void login(String username, String password) 
                throws InvalidCredentialsException, AccountLockedException {
            if(attempts >= 3) {
                throw new AccountLockedException(username, 10);
            }
            if(users[0][0].equals(username) && users[0][1].equals(password)) {
                System.out.println("Login successful");
                attempts = 0;
            } else {
                attempts++;
                throw new InvalidCredentialsException(username);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginSystem obj = new LoginSystem();
        System.out.println("Simulating 5 login attempts:");
        String user = "sanjeet";
        String[] passwords = {"1234", "111", "222", "333", "1234"};
        for(int i=0;i<5;i++) {
            try {
                System.out.println("Attempt " + (i+1));
                obj.login(user, passwords[i]);
            }
            catch(InvalidCredentialsException e) {
                System.out.println(e.getMessage());
            }
            catch(AccountLockedException e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println("Attempt completed\n");
            }
        }
    }
}