package com.framgia.controller.guest;

import com.framgia.service.ChatworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private ChatworkService chatworkService;

    @Value("${chatwork.roomId}")
    private String chatworkRoomId;

    @GetMapping
    public String home(Model model) {
        return "guest/index";
    }

    @GetMapping(value = {"/home"})
    public String dashboard(Model model){
        chatworkService.sendMessage(chatworkRoomId,"https://www.facebook.com/undefendable/photos/a.112307692132971/2534478743249175/?type=3&theater");
        return "guest/index";
    }
}
