package pl.haladyj.ss_basics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.haladyj.ss_basics.entity.User;
import pl.haladyj.ss_basics.repository.UserRepository;
import pl.haladyj.ss_basics.security.model.SecurityUser;

public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));

        var securityUser = new SecurityUser(user);

        return securityUser;
    }
}
