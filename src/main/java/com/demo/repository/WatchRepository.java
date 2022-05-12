package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.WatchEntity;

public interface WatchRepository extends JpaRepository<WatchEntity, Integer> {

}
