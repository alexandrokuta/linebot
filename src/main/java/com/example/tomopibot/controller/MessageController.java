package com.example.tomopibot.controller;



import org.springframework.beans.factory.annotation.Autowired;

import com.example.tomopibot.service.WebhookService;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * メッセージコントローラー
 */
@Slf4j
@LineMessageHandler
public class MessageController {

    private boolean isNum;

    private final WebhookService webhookService;

    private final PushConfirmController pushConfirmController;

    @Autowired
    public MessageController(WebhookService webhookService, PushConfirmController pushConfirmController) {
        this.webhookService = webhookService;
        this.pushConfirmController = pushConfirmController;
    }

    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) throws Exception {
        String acceptedMessage =  event.getMessage().getText();
        this.isNum = webhookService.isDigit(acceptedMessage);

        if (isNum){
            return new TextMessage("これは数字やな");
        }else if (acceptedMessage.equals("くうた")){
            pushConfirmController.pushConfirm();
            return new TextMessage("くうたでした");
        }
        else {
            return new TextMessage(event.getMessage().getText() + "やで");

        }

    }


}


