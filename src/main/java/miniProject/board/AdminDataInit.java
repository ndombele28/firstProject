package miniProject.board;

import lombok.RequiredArgsConstructor;
import miniProject.board.service.AdminService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AdminDataInit implements ApplicationRunner {
    private final AdminService adminService;

    public AdminDataInit(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 데이터베이스에 저장된 관리자 정보가 비어있을 때만 관리자 생성 메서드 호출
        if (adminService.isEmpty()) {
            adminService.create("admin", "test");
        }
    }
}
