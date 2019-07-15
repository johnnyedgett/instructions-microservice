package com.instructionator.instructions.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.instructionator.instructions.entity.Instruction;
import com.instructionator.instructions.service.InstructionService;

@RestController
@RequestMapping("/api/instruction")
public class InstructionController {

	private static final Logger LOG = LoggerFactory.getLogger(InstructionController.class);	
	@Autowired
	InstructionService instructionService;
	
	@GetMapping("/get")
	public ResponseEntity<Instruction> getInstructionById(@RequestParam("id") Long id){
		Instruction i = instructionService.getInstructionById(id);
		if(i != null) {
			return new ResponseEntity<>(i, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/top")
	public ResponseEntity<List<Instruction>> getTopInstructions(){
		List<Instruction> iList = instructionService.getTopInstructions();
		if(iList != null) {
			return new ResponseEntity<>(iList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Instruction> createInstruction(@RequestBody Instruction instruction){
		Instruction i = instructionService.createInstruction(instruction);
		if(i != null) {
			return new ResponseEntity<>(i, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
