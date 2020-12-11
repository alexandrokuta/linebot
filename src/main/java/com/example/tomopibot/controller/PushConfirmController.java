package com.example.tomopibot.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.template.ConfirmTemplate;
import com.linecorp.bot.model.response.BotApiResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PushConfirmController {

    @Value("${t.user.id")
    private  String t_user_id;

    private final LineMessagingClient lineMessagingClient;

    @Autowired
    public PushConfirmController(LineMessagingClient lineMessagingClient) {
        this.lineMessagingClient = lineMessagingClient;
    }

    public void pushConfirm() throws ExecutionException, InterruptedException {
        try{
            TemplateMessage message = new TemplateMessage("僕はくうただよ", new ConfirmTemplate("智宏くんだね",new MessageAction("yes", "yes"),new MessageAction("no","no")));
            BotApiResponse response = lineMessagingClient.pushMessage(new PushMessage(t_user_id,message)).get();
        }catch (InterruptedException | ExecutionException e){
            throw new RuntimeException(e);
        }
    }

}
