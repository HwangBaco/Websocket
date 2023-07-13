/*
config 패키지에서는 애플리케이션(웹소켓 통신)의 설정을 관리, 구성하는 역할
웹소켓 관련 설정 처리, 프로토콜, 메시지 브로커, 웹소켓 엔드포인드(URL 주소) 등의 설정 구성.
*/
package study.Websocket.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration //스프링 설정 클래스임을 나타냄
@EnableWebSocketMessageBroker //클라이언트들 사이의 메시지 전송을 중개할 수 있는 환경을 설정.
public class WebSockConfig implements WebSocketMessageBrokerConfigurer {

    @Override //상위 클래스나 인터페이스의 매서드를 재정의한다는것을 나타냄, 인터페이스 구현하는 클래스에서는 선언된 모든 매서드들 Override 해야함
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/sub");
        config.setApplicationDestinationPrefixes("/pub");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp").setAllowedOriginPatterns("*")
                .withSockJS();
    }
}



