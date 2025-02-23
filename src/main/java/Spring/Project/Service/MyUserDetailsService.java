package Spring.Project.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Spring.Project.Model.UserPrinciple;
import Spring.Project.Model.Users;
import Spring.Project.Repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user= userRepository.findByUsername(username);
        if(user!=null){
            return UserPrinciple.build(user);
        }
        return null;
    }
}
