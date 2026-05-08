package Exp10;

import java.util.Scanner;

public class loginSystem {
    private String title;

    public loginSystem() {
        this.title = "Login System Driver";
    }

    public loginSystem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Program: " + title;
    }

    static class InvalidCredentialsException extends Exception {
        private String username;

        public InvalidCredentialsException() {
            super("Invalid password");
            this.username = "Unknown";
        }

        public InvalidCredentialsException(String username) {
            super("Invalid password for user: " + username);
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String toString() {
            return getMessage();
        }
    }

    static class AccountLockedException extends Exception {
        private String username;
        private int minutes;

        public AccountLockedException() {
            super("Account locked");
            this.username = "Unknown";
            this.minutes = 0;
        }

        public AccountLockedException(String username, int minutes) {
            super("Account locked for user: " + username + " for " + minutes + " minutes");
            this.username = username;
            this.minutes = minutes;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        @Override
        public String toString() {
            return getMessage();
        }
    }

    static class LoginSystem {
        private String[][] users;
        private String[][] failedAttempts;

        public LoginSystem() {
            this.users = new String[][]{{"sanjeet", "1234"}};
            this.failedAttempts = new String[][]{{"sanjeet", "0"}};
        }

        public LoginSystem(String[][] users) {
            this.users = users;
            this.failedAttempts = new String[users.length][2];

            for(int i = 0; i < users.length; i++) {
                failedAttempts[i][0] = users[i][0];
                failedAttempts[i][1] = "0";
            }
        }

        public String[][] getUsers() {
            return users;
        }

        public void setUsers(String[][] users) {
            this.users = users;
        }

        public String[][] getFailedAttempts() {
            return failedAttempts;
        }

        public void setFailedAttempts(String[][] failedAttempts) {
            this.failedAttempts = failedAttempts;
        }

        private int findUserIndex(String username) {
            for(int i = 0; i < users.length; i++) {
                if(users[i][0].equals(username)) {
                    return i;
                }
            }
            return -1;
        }

        public int getAttemptCount(String username) {
            int index = findUserIndex(username);

            if(index == -1) {
                return 0;
            }
            return Integer.parseInt(failedAttempts[index][1]);
        }

        public void setAttemptCount(String username, int attemptCount) {
            int index = findUserIndex(username);

            if(index != -1) {
                failedAttempts[index][1] = String.valueOf(attemptCount);
            }
        }

        public void login(String username, String password)
                throws InvalidCredentialsException, AccountLockedException {
            int index = findUserIndex(username);

            if(index == -1) {
                throw new InvalidCredentialsException(username);
            }

            int attemptCount = getAttemptCount(username);

            if(attemptCount >= 3) {
                throw new AccountLockedException(username, 10);
            }

            if(users[index][1].equals(password)) {
                System.out.println("Login successful for user: " + username);
                setAttemptCount(username, 0);
            } else {
                setAttemptCount(username, attemptCount + 1);
                throw new InvalidCredentialsException(username);
            }
        }

        @Override
        public String toString() {
            String result = "Valid users and failed attempts:\n";

            for(int i = 0; i < users.length; i++) {
                result += "Username: " + users[i][0]
                        + ", Failed attempts: " + failedAttempts[i][1] + "\n";
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loginSystem driver = new loginSystem("Exception Handling Login Program");

        System.out.print("Enter valid username: ");
        String username = sc.nextLine().trim();

        System.out.print("Enter valid password: ");
        String correctPassword = sc.nextLine().trim();

        System.out.print("Enter wrong password for simulation: ");
        String wrongPassword = sc.nextLine().trim();

        String[][] validUsers = {{username, correctPassword}};
        LoginSystem loginObj = new LoginSystem(validUsers);

        String[] passwords = {
            correctPassword,
            wrongPassword,
            wrongPassword
        };

        System.out.println("\n" + driver);
        System.out.println("Simulating 3 login attempts for user: " + username + "\n");

        for(int i = 0; i < passwords.length; i++) {
            try {
                System.out.println("Attempt " + (i + 1));
                loginObj.login(username, passwords[i]);
            }
            catch(InvalidCredentialsException e) {
                System.out.println(e);
            }
            catch(AccountLockedException e) {
                System.out.println(e);
            }
            finally {
                System.out.println("Current attempt count: " + loginObj.getAttemptCount(username));
                System.out.println("Attempt completed\n");
            }
        }

        System.out.println(loginObj);
        sc.close();
    }
}
