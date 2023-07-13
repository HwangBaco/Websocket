package study.Websocket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.tomcat.util.codec.binary.Base64;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequiredArgsConstructor
public class ImageUploadController {

    private final AtomicInteger idCounter = new AtomicInteger();
    private final ConcurrentHashMap<Integer, String> imageStore = new ConcurrentHashMap<>();
    private final SimpMessageSendingOperations messagingTemplate; //메시지 보내는 기능


    // 이미지 업로드가 외부 장치와 공유되는 구조가 아님.
    @PostMapping("/uploadImage")
    @ResponseBody
    public int uploadImage(@RequestParam("image") MultipartFile image) {
        try {
            String base64Image = Base64.encodeBase64String(image.getBytes());
            int id = idCounter.incrementAndGet();
            imageStore.put(id, base64Image);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @GetMapping("/image/{id}")
    public String displayImage(@PathVariable int id, Model model) {
        model.addAttribute("image", imageStore.get(id));
        return "displayImage";
    }
}

