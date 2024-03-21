package miniProject.board.controller;

import lombok.RequiredArgsConstructor;
import miniProject.board.entity.Admin;
import miniProject.board.repository.AdminRepository;
import miniProject.board.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class AdminController {

    @GetMapping("/admin/login")
    public String adminLogin (){
        return "admin/login";
    }
    @GetMapping("/admin/main")
    public String adminMain(){
        return "admin/main";
    }
}
