package network.chatserver.handler.controller;

import lombok.RequiredArgsConstructor;
import network.chatserver.domain.ChatRoom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller //스프링 MVC 컨트롤러로 동작
@RequestMapping("/chat") //'/chat'경로를 기준으로 요청 매핑 처리
public class ChatRoomController {

    private final network.chatserver.repository.ChatRoomRepository chatRoomRepository;

    // 채팅 리스트 화면
    @GetMapping("/room")
    public String rooms(Model model) {
        return "room.html";
    }
    // 모든 채팅방 목록 반환
    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
        return chatRoomRepository.findAllRoom();
    }
    // 채팅방 생성
    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {
        return chatRoomRepository.createChatRoom(name);
    }
    // 채팅방 입장 화면
    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
        model.addAttribute("roomId", roomId);
        return "roomdetail.html";
    }
    // 특정 채팅방 조회
    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomId) {
        return chatRoomRepository.findRoomById(roomId);
    }
}
