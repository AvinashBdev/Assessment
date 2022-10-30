package com.assessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The type Message entity.
 */
@Table(name = "MESSAGE")
@Entity
public class MessageEntity {

    @Id
    Integer id;


    @Column(name = "message")
    String message;

    /**
     * Instantiates a new Message entity.
     */
    public MessageEntity() {
    }

    /**
     * Instantiates a new Message entity.
     *
     * @param id      the id
     * @param message the message
     */
    public MessageEntity(Integer id, String message) {
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
