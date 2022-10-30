package com.assessment.dto;

import java.io.Serializable;


/**
 * The type Message response dto.
 */
public class MessageResponseDto implements Serializable {

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -4342492559343057041L;

    private Integer id;

    /**
     * Instantiates a new Message response dto.
     *
     * @param id the id
     */
    public MessageResponseDto(Integer id) {
        this.id = id;
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
}
