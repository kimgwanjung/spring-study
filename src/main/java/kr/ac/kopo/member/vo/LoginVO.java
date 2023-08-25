package kr.ac.kopo.member.vo;

import javax.validation.constraints.NotEmpty;

public class LoginVO {
    
    @NotEmpty(message = "id 필수")
    private String id;
    
    @NotEmpty(message = "password 필수")
    private String password;
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "LoginVO [id=" + id + ", password=" + password + "]";
    }
    
    
    

}
