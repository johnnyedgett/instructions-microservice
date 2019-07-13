package com.instructionator.instructions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instructionator.instructions.entity.Instruction;

@Repository
public interface InstructionRepository extends JpaRepository<Instruction, Long> {

}
