package miniProject.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miniProject.board.entity.Admin;
import miniProject.board.repository.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor

public class AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public void create(String name, String password){
        Admin admin = new Admin();
        admin.setName(name);
        admin.setPassword(passwordEncoder.encode(password));
        this.adminRepository.save(admin);
    }

    public boolean isEmpty() {
        return adminRepository.count() == 0;
    }
}
