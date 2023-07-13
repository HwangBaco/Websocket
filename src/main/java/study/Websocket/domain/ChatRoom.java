package study.Websocket.domain;


import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter //필드값을 가져오고 설정
@Setter //
public class ChatRoom { //채팅방을 나타내는 도메인 객체
    private String roomId;
    private String name;

    public static ChatRoom create(String name){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString(); //roomId를 랜덤한 UUID 값으로 설정.
        chatRoom.name = name;
        return chatRoom;
    }
}
