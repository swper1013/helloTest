package org.example.buylist.repository;

import org.example.buylist.entity.BuylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<BuylistEntity,Long> {
}
