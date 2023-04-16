package com.isxcode.star.backend.module.workflow.repository;

import com.isxcode.star.backend.module.workflow.entity.WorkflowEntity;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/** 只负责数据库查询逻辑. */
@Repository
@CacheConfig(cacheNames = {"sy_engines"})
public interface WorkflowRepository extends JpaRepository<WorkflowEntity, String> {

  @Query("SELECT w FROM WorkflowEntity w WHERE w.name LIKE %:keyword% OR w.commentInfo LIKE %:keyword%")
  Page<WorkflowEntity> searchAll(@Param("keyword") String searchKeyWord, Pageable pageable);
}
