package Java;

public abstract class user {
    private String email;
    private String password;
    private String admin_password;

    public user(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public user(String email){
        this.email = email;
        this.admin_password = "12345";
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
