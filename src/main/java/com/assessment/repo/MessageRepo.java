package com.assessment.repo;

import com.assessment.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Message repo.
 */
public interface MessageRepo extends JpaRepository<MessageEntity,Integer> {
}
