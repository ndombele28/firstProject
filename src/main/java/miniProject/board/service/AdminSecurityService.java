package miniProject.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miniProject.board.entity.Admin;
import miniProject.board.repository.AdminRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminSecurityService implements UserDetailsService {
    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Admin> _admin = this.adminRepository.findByName(name);
        if (_admin.isEmpty()){
            throw new UsernameNotFoundException("계정을 찾을 수 없습니다.");
        }
        Admin admin = _admin.get();
        List<GrantedAuthority> authorities = new ArrayList<>();

        return new User(admin.getUsername(), admin.getPassword(), authorities);
    }
}
