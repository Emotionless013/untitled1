import exeptions.WrongLoginException;
import exeptions.WrongPasswordException;

public class Main {
    public static boolean verification(String login, String password, String confirmPassword) {
        try {
            verificationControl(login, password, confirmPassword);
        } catch (WrongLoginException wrongLoginException) {
            System.out.println("Длина пароля не должна превышать 20 символов.");
        } catch (WrongPasswordException wrongPasswordException) {
            System.out.println("Введенные пароли не совпадают.");
        } finally {
            if (login.matches("[a-zA-Z0-9_]+") &&
                    password.matches("[a-zA-Z0-9_]+") &&
                    confirmPassword.matches("[a-zA-Z0-9_]+") &&
                    login.length() <= 20 && password.length() <= 20 && confirmPassword.length() <= 20 &&
                    password.equals(confirmPassword)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void verificationControl(String login, String password, String confirmPassword) {
        if (login.length() > 20) {
            throw new WrongLoginException();
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }

    public static void main(String[] args) {
        String login;
        login = "java_skypro_go";
        String password;
        password = "D_1hWiKjjP_9";
        String confirmPassword;
        confirmPassword = "D_1hWiKjjP_";
        System.out.println("verification(login, password, confirmPassword) = " +
                verification(login, password, confirmPassword));
    }
}
