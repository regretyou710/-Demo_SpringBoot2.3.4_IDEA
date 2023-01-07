package tw.com.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@Slf4j
public class FormController {

    @GetMapping("/form_layouts")
    public String form_layouts() {
        return "forms/form_layouts";
    }

    @PostMapping("/formUpload")
    public String form_layouts(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam("photo") MultipartFile photo,
                               @RequestParam("photos") MultipartFile[] photos) throws IOException {

        log.info("表單上傳訊息: email={}, password={}, photo={}, photos={}",
                email, password, photo.getSize(), photos.length);

        if (!photo.isEmpty()) {
            photo.transferTo(new File("C:/cache/" + photo.getOriginalFilename()));
        }

        if (photos.length != 0) {
            for (MultipartFile file : photos) {
                if (!file.isEmpty()) {
                    file.transferTo(new File("C:/cache/" + file.getOriginalFilename()));
                }
            }
        }

        return "main";
    }
}
