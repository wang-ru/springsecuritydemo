package wr.security.core.properties;

/**
 * Created by wsh10801 on 2018/9/24.
 */
public class BrowserProperties {
    private String loginPage ="/signIn.html";
    private LoginResponseType loginType = LoginResponseType.JSON;
    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginResponseType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginResponseType loginType) {
        this.loginType = loginType;
    }
}
