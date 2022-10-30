package com.assessment.service;

import com.assessment.dto.MessageRequestDto;
import com.assessment.entity.MessageEntity;
import com.assessment.repo.MessageRepo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Message service.
 */
@Service
public class MessageService {

    /**
     * The Message repo.
     */
    private final MessageRepo messageRepo;

    /**
     * Instantiates a new Message service.
     *
     * @param messageRepo the message repo
     */
    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    /**
     * Save message.
     *
     * @param messageRequestDto the message request dto
     */
    @Async
    public void saveMessage(MessageRequestDto messageRequestDto) {

        WebClient client = getWebClient();

        String request = getRequest(messageRequestDto.getMessage());

        ResponseEntity<String> response = soapApiCall(messageRequestDto, client, request);


        saveMessage(response,messageRequestDto);
    }

    /**
     * Soap api call response entity.
     *
     * @param messageRequestDto the message request dto
     * @param client            the client
     * @param request           the request
     * @return the response entity
     */
    private static ResponseEntity<String> soapApiCall(MessageRequestDto messageRequestDto, WebClient client, String request) {
        ResponseEntity<String> response = client.post()
                .uri("http://localhost:8088/mock").body(Mono.just(request), String.class)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .toEntity(String.class).contextWrite(context -> context.put("id", messageRequestDto.getId())).block();
        return response;
    }

    /**
     * Save message.
     *
     * @param response          the response
     * @param messageRequestDto the message request dto
     */
    private void saveMessage(ResponseEntity<String> response,MessageRequestDto messageRequestDto) {
        MessageEntity messageEntity = new MessageEntity(messageRequestDto.getId(),messageRequestDto.getMessage());

        if (ObjectUtils.nullSafeEquals(response.getStatusCode(),HttpStatus.OK)) {
            messageRepo.saveAndFlush(messageEntity);
        }
    }

    /**
     * Gets request.
     *
     * @param message the message
     * @return the request
     */
    private static String getRequest(String message) {
        return "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:xmethods-delayed-quotes\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <urn:post_message>\n" +
                "      \t<message>"+ message +"</message>\n" +
                "      </urn:post_message>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
    }

    /**
     * Gets web client.
     *
     * @return the web client
     */
    private static WebClient getWebClient() {
        WebClient client = WebClient.create();
        return client;
    }

    /**
     * Get messages list.
     *
     * @return the list
     */
    public List<MessageRequestDto> getMessages(){
        List<MessageEntity> messageEntities = messageRepo.findAll();
        List<MessageRequestDto> messageRequestDtos = new ArrayList<>();

        messageEntities.forEach(item -> messageRequestDtos.add(new MessageRequestDto(item.getId(), item.getMessage())));
        return messageRequestDtos;
    }
}
