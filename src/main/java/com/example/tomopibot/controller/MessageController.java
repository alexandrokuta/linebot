package com.example.tomopibot.controller;



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

    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) throws Exception {
        System.out.println("event: " + event);
        String returnMessage = event.getMessage().getText() + "やで";
        return new TextMessage(event.getMessage().getText());
    }
}

