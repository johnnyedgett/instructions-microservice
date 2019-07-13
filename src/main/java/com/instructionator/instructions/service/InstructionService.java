package com.instructionator.instructions.service;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instructionator.instructions.entity.Instruction;
import com.instructionator.instructions.repository.InstructionRepository;

@Service
public class InstructionService {

	private static final Logger LOG = LoggerFactory.getLogger(InstructionService.class);
	
	@Autowired
	InstructionRepository instructionRepository;
	
	public Instruction getInstructionById(Long id) {
		try {
			Instruction i = instructionRepository.findById(id).get();
			return i;
		} catch (NoSuchElementException e) {
			LOG.error(String.format("GET ID: %d, ERROR: %s", id, e.getMessage()));
			return null;
		}
	}
	
	public Instruction createInstruction(Instruction instruction) {
		try {
			Instruction i = instructionRepository.save(instruction);
			return i;
		} catch (Exception e) {
			LOG.error(String.format("CREATE INSTRUCTION ERROR: %s", e.getMessage()));
			return null;
		}
	}
}
