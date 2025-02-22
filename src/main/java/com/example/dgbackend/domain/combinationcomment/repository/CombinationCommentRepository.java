package com.example.dgbackend.domain.combinationcomment.repository;

import com.example.dgbackend.domain.combinationcomment.CombinationComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombinationCommentRepository extends JpaRepository<CombinationComment, Long> {

    Page<CombinationComment> findAllByCombinationIdAndState(Long combinationId, boolean state,
        Pageable pageable);

}
