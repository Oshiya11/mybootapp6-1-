package te4a.spring.boot.myapp13.mybootapp13.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import te4a.spring.boot.myapp13.mybootapp13.bean.UserBean;

@Data
public class LoginUserDetails extends User {
    private final UserBean user;
    public LoginUserDetails(UserBean userBean,
        boolean accountNonExpried, 
        boolean credenttialsNonExpired, 
        boolean accountNonLocked, 
        Collection<GrantedAuthority> authorities) {
        super(userBean.getUsername(), userBean.getPassword(),
            true, true, true, true, authorities);
        this.user = userBean;
    }
}