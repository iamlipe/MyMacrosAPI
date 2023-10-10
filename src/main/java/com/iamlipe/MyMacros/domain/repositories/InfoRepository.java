package com.iamlipe.MyMacros.domain.repositories;

import com.iamlipe.MyMacros.domain.entities.info.Info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InfoRepository extends JpaRepository<Info, UUID> {
}
