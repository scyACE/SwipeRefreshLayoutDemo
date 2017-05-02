package scy.com.pulltorefresh;

/**
 * Created by Administrator on 2017/4/26.
 */

public class User {

    /**
     * code : 0
     * ID : 1000438
     * user_nickname : 赚钱啊
     * user_pic_url : data/upload/apphead/20161125/14800523576124.jpg
     * user_login_name :
     * user_sex : 2
     * user_birthday : 1990-03-29
     * sign_word : 饮用前请先检查包装是
     * user_company : 佳木斯九福
     * hide_tel : 1
     * user_erweima : data/upload/erweimamy/user1000438.png
     * has_null : 0
     * is_vip : 10
     * token : MTU1NDU5MDI4ODhfMTQ5MzE5Mjk3OF8xMDAwNDM4
     */

    private String code;
    private String ID;
    private String user_nickname;
    private String user_pic_url;
    private String user_login_name;
    private String user_sex;
    private String user_birthday;
    private String sign_word;
    private String user_company;
    private String hide_tel;
    private String user_erweima;
    private String has_null;
    private String is_vip;
    private String token;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getUser_pic_url() {
        return user_pic_url;
    }

    public void setUser_pic_url(String user_pic_url) {
        this.user_pic_url = user_pic_url;
    }

    public String getUser_login_name() {
        return user_login_name;
    }

    public void setUser_login_name(String user_login_name) {
        this.user_login_name = user_login_name;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getSign_word() {
        return sign_word;
    }

    public void setSign_word(String sign_word) {
        this.sign_word = sign_word;
    }

    public String getUser_company() {
        return user_company;
    }

    public void setUser_company(String user_company) {
        this.user_company = user_company;
    }

    public String getHide_tel() {
        return hide_tel;
    }

    public void setHide_tel(String hide_tel) {
        this.hide_tel = hide_tel;
    }

    public String getUser_erweima() {
        return user_erweima;
    }

    public void setUser_erweima(String user_erweima) {
        this.user_erweima = user_erweima;
    }

    public String getHas_null() {
        return has_null;
    }

    public void setHas_null(String has_null) {
        this.has_null = has_null;
    }

    public String getIs_vip() {
        return is_vip;
    }

    public void setIs_vip(String is_vip) {
        this.is_vip = is_vip;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "code='" + code + '\'' +
                ", ID='" + ID + '\'' +
                ", user_nickname='" + user_nickname + '\'' +
                ", user_pic_url='" + user_pic_url + '\'' +
                ", user_login_name='" + user_login_name + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_birthday='" + user_birthday + '\'' +
                ", sign_word='" + sign_word + '\'' +
                ", user_company='" + user_company + '\'' +
                ", hide_tel='" + hide_tel + '\'' +
                ", user_erweima='" + user_erweima + '\'' +
                ", has_null='" + has_null + '\'' +
                ", is_vip='" + is_vip + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
