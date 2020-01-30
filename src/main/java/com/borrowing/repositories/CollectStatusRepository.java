package com.borrowing.repositories;

import com.borrowing.entity.CollectStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectStatusRepository extends JpaRepository<CollectStatus,Integer> {
}
