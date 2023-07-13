package study.Websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // 채팅 리스트 화면
    @GetMapping("")
    public String rooms(Model model) {
        return "room.html";
    }

}
