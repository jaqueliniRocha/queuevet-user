package com.queuevet.user.model.repository;

import com.queuevet.user.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {
     boolean existsByCrmv(String crmv);

}
