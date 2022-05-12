package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.TvEntity;

public interface TvRepository extends JpaRepository<TvEntity, Integer> {

}
