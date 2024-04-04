package Day2103_Locator3;

import java.util.Date;

public class homework2103 {
    public static void main(String[] args) {
        String currentDate = String.valueOf(new Date().getTime());
        String email = "abc" + currentDate + "@gmail.com";
        System.out.println(email);
    }
}
