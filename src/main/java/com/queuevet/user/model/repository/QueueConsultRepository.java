package com.queuevet.user.model.repository;

import com.queuevet.user.model.QueueConsult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueConsultRepository extends JpaRepository<QueueConsult, Long> {
}

