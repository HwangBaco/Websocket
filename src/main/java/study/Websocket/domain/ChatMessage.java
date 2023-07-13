/*
domain 패키지는 애플리케이션이 다루는 문제영역(도메인)을 모델링
실제 비즈니스 도메인에 존재하는 개념, 규칙, 상태 등을 객체로 표현
비즈니스 규칙을 표현, 애플리케이션 데이터 관리, 비즈니스 로직 처리 등의 역할
 */
package study.Websocket.domain;


import lombok.Data;

@Data
public class ChatMessage { //채팅메시지를 나타내는 도메인 객체
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;

    public enum MessageType {
        ENTER, TALK
    }
}
