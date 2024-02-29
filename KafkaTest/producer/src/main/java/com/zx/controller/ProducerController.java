package com.zx.controller;

import com.zx.service.ISender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * description: kafka 生产者 <br>
 * create: 2024-02-29 15:06 <br>
 * </p>
 *
 * @author zhou  xun
 */
@RestController
public class ProducerController {
    private final ISender iSender;

    @Autowired
    public ProducerController(ISender iSender) {
        this.iSender = iSender;
    }

    @PostMapping("/topic/test")
    public String sendTopic(@RequestBody String str) {
        iSender.sender(str);
        return "success";
    }
}
