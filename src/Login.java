public class Login  {

    public static boolean authenticate(String username, String password) {

        if ((username.equals("user") && password.equals("hello"))|
                (username.equals("1") && password.equals("1"))|
                (username.equals("2") && password.equals("2"))|
                (username.equals("3") && password.equals("3"))|
                (username.equals("log") && password.equals("pass")))
        {
            return true;

        }

        return false;




    }
}
