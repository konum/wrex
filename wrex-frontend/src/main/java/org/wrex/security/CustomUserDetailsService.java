package org.wrex.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.wrex.api.domain.UserDTO;
import org.wrex.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
   
    @Autowired
    private UserService userService;   

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    	UserDTO domainUser = userService.getByEmail(login);
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        if (domainUser.getStatus() == org.wrex.entities.User.INACTIVE)
        	accountNonLocked = false;
        return new User(
            domainUser.getEmail(),
            domainUser.getPassword(),
            enabled,
            accountNonExpired,
            credentialsNonExpired,
            accountNonLocked,
            getAuthorities(domainUser.getRole())
        );
    }
   
    public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }
   
    /** 
     * You should use your own role management,
     * @param role
     * @return
     */
    public List<String> getRoles(Integer role) {

        List<String> roles = new ArrayList<String>();

        if (role.intValue() == 1) {
            roles.add("ROLE_ADMIN");
            roles.add("ROLE_USER");
        } else if (role.intValue() == 0) {
            roles.add("ROLE_USER");
        }
        return roles;
    }
   
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
       
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}
