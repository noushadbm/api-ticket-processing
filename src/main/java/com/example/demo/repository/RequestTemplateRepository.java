package com.example.demo.repository;

import com.example.demo.entity.RequestTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestTemplateRepository extends JpaRepository<RequestTemplateEntity, Long> {
}
