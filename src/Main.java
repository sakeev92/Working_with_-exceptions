import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        System.out.println(checkHandler("java_skypro.go",
                "D_1hWiKjjP_9",
                "D_1hWiKjjP_9"));
    }
    public static boolean check(String login, String password, String confirmPassword) {

        if (!(Pattern.matches("^[a-zA-Z._0-9]{1,20}$", login))) {
            throw new WrongLoginException();
        }
        if (password != confirmPassword) {
            throw new WrongConfirmPasswordException();
        }
        if (!(Pattern.matches("^[a-zA-Z_0-9]{1,19}$", password))) {
            throw new WrongPasswordException();
        }
        return true;
    }
    public static boolean checkHandler(String login, String password, String confirmPassword) {
        try {
            return check(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            return false;
        } catch (WrongPasswordException e) {
            return false;
        } catch (WrongConfirmPasswordException e) {
            return false;
        }
    }
}