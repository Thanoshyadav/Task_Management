package com.task_management.service;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebSocketService extends TextWebSocketHandler {
    private static List<WebSocketSession> sessions = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        for (WebSocketSession webSocketSession : sessions) {
            if (webSocketSession.isOpen()) {
                webSocketSession.sendMessage(message);
            }
        }
    }
}
