/*
컨트롤러 필드는 스프링에서 기능을 컨트롤하는데 사용
클라이언트의 요청을 처리, 필요한 작업 수행하는 역할
 */

package study.Websocket.controller;

import study.Websocket.domain.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Controller //해당 클래스가 컨트롤러 역할을 수행함을 나타냄
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate; //메시지 보내는 기능
    private final ConcurrentHashMap<Integer, String> imageStore = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger();


    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType()))
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

}

