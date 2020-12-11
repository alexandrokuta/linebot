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

    private boolean isNum;

    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) throws Exception {
        String acceptedMessage =  event.getMessage().getText();
        isDigit(acceptedMessage);

        if (isNum){
            return new TextMessage("これは数字やな");
        }else {
            return new TextMessage(event.getMessage().getText() + "やで");

        }

    }

    private void isDigit(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                this.isNum = true;
            } else {
                this.isNum = false;
            }
        }
    }
}


