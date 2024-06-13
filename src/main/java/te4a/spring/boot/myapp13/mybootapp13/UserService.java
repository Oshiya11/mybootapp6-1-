package te4a.spring.boot.myapp13.mybootapp13;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import te4a.spring.boot.myapp13.mybootapp13.bean.UserBean;
import te4a.spring.boot.myapp13.mybootapp13.form.UserForm;
import te4a.spring.boot.myapp13.mybootapp13.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserForm create(UserForm userForm) {
        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
  
        UserBean userBean = new UserBean();
        BeanUtils.copyProperties(userForm, userBean);

        userRepository.save(userBean);
        return userForm;
    }
}