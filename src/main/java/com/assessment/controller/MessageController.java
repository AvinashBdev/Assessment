package com.assessment.controller;

import com.assessment.dto.MessageRequestDto;
import com.assessment.dto.MessageResponseDto;
import com.assessment.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Message controller.
 */
@RestController
public class MessageController {

    /**
     * The Message service.
     */
    private final MessageService messageService;

    /**
     * Instantiates a new Message controller.
     *
     * @param messageService the message service
     */
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * Save message response entity.
     *
     * @param messageRequestDto the message request dto
     * @return the response entity
     */
    @PostMapping("/message")
    public ResponseEntity<MessageResponseDto> saveMessage(@RequestBody MessageRequestDto messageRequestDto){
        messageService.saveMessage(messageRequestDto);
        return ResponseEntity.ok(new MessageResponseDto(messageRequestDto.getId()));
    }

    /**
     * Get all messages response entity.
     *
     * @return the response entity
     */
    @GetMapping("/get_message")
    public ResponseEntity<List<MessageRequestDto>> getAllMessages(){
        return ResponseEntity.ok( messageService.getMessages());
    }
}
