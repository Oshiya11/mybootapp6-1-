package te4a.spring.boot.myapp13.mybootapp13.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import te4a.spring.boot.myapp13.mybootapp13.bean.UserBean;

@Data
public class LoginUserDetails extends User {
    private final UserBean user;

    public LoginUserDetails(UserBean userBean) {
        super(userBean.getUsername(), userBean.getPassword(), getAuthorities(userBean));
        this.user = userBean;
    }

    private static List<GrantedAuthority> getAuthorities(UserBean userBean) {
        List<GrantedAuthority> authList;
        if (isAdmin(userBean)) {
            authList = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER", "ROLE_OTHER");
        } else if (isGeneralUser(userBean)) {
            authList = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_OTHER");
        } else {
            authList = AuthorityUtils.createAuthorityList("ROLE_OTHER");
        }
        return authList;
    }

    // 管理者の条件を判定するメソッド
    private static boolean isAdmin(UserBean userBean) {
        // ここに管理者の条件を実装する
        // 例: ロールに "ADMIN" が含まれている場合
        return userBean.getRoles().contains("ADMIN");
    }

    // 一般ユーザの条件を判定するメソッド
    private static boolean isGeneralUser(UserBean userBean) {
        // ここに一般ユーザの条件を実装する
        // 例: ロールに "USER" が含まれている場合
        return userBean.getRoles().contains("USER");
    }
}
