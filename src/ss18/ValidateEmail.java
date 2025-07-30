package ss18;


public class ValidateEmail {
    static String listMail = "1nguyenvana@gmail.com;tranthib123@yahoo.com;lehoanganh@fpt.edu.vn;phamminhduc@outlook.com;ngoclinh2002@gmail.com";
    static String[] arrs = listMail.split(";");

    public static void main(String[] args) {
        for (String arr : arrs) {
            String email = arr.trim();
            if (validateMail(email)) {
                System.out.println(email + "true");
            } else {
                System.out.println(email + "false");
            }
        }
    }
    public static boolean validateMail(String mail) {
        String regex = "^[A-Za-z][A-Za-z0-9_]{6,32}@[A-Za-z]+(\\.[A-Za-z]{2,12})$";
        return mail.matches(regex);
    }

}
