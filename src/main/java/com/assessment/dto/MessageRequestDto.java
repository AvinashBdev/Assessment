package com.assessment.dto;


import java.io.Serializable;

/**
 * The type Message request dto.
 */
public class MessageRequestDto implements Serializable {

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -5392185826126648165L;


    private Integer id;

    private String message;

    /**
     * Instantiates a new Message request dto.
     */
    public MessageRequestDto() {
    }

    /**
     * Instantiates a new Message request dto.
     *
     * @param id      the id
     * @param message the message
     */
    public MessageRequestDto(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
