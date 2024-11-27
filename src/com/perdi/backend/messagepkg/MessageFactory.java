package com.perdi.backend.messagepkg;

import java.util.ArrayList;
import com.perdi.backend.storage.datapkg.DataCenter;
import com.perdi.backend.messagepkg.MessageType;

public class MessageFactory {
    
    public boolean createMessage(UUID senderID, UUID recipientID, String messageContent, MessageType type, ArrayList<Message> userMessage) {

        Message newMessage = null;

        switch(type) {
            case TEXT_MESSAGE:
                newMessage = new TextMessage(senderID, recipientID, messageContent);
                userMessage.add(newMessage);
                System.out.println("Mensagem de texto adicionada à lista de mensagens.");
                return true;
            case IMAGE_MESSAGE:
                newMessage = new ImageMessage(senderID, recipientID, messageContent);
                userMessage.add(newMessage);
                System.out.println("Mensagem de imagem adicionada à lista de mensagens.");
                return true;
            case VIDEO_MESSAGE:
                newMessage = new VideoMessage(senderID, recipientID, messageContent);
                userMessage.add(newMessage);
                System.out.println("Mensagem de vídeo adicionada à lista de mensagens.");
                return true;
            default:
                System.out.println("Tipo de mensagem inválido.");
                return false;
        }
    }

    public boolean removeMessage(UUID messageID, ArrayList<Message> userMessage, DataCenter dataCenter) {

        Message messageToRemove = null;

        for(int i = 0; i < userMessage.size(); i++) {
            if(userMessage.get(i).getMessageID().equals(messageID)) {
                messageToRemove = userMessage.get(i);
                break;
            }
        }

        if(messageToRemove == null) {
            System.out.println("Mensagem nula. Impossível remover da lista de mensagens.");
            return false;
        } else {
            userMessage.remove(messageToRemove);
            dataCenter.removeMessage(messageID);
            System.out.println("Mensagem removida da lista de mensagens.");
            return true;
        }
    }
}
