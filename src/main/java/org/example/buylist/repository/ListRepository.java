package org.example.buylist.repository;

import org.example.buylist.entity.BuylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListRepository extends JpaRepository<BuylistEntity,Long> {
    Optional<BuylistEntity> findByValueNameContaining(String keyword);

}
