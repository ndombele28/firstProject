package miniProject.board.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String password;

    @Builder
    public Admin(String name, String password){
        this.name = name;
        this.password = password;
    }

    @Override // 권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("admin"));
    }

    @Override  // 사용자의 name를 반환
    public String getUsername() {
        return name;
    }

    @Override // 계정 만료 여부 반환
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override // 계정 잠금 여부
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override // 패스워드 만료 여부
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override // 계정 가능 여부
    public boolean isEnabled() {
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
