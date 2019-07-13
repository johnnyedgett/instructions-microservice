package com.instructionator.instructions.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;

@Entity
@TypeDef(
	name="jsonb",
	typeClass= JsonNodeBinaryType.class
)
public class Instruction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long submitterId;
	private Long categoryId;
	private int favorites;
	private int views;
	
	@Type(type="jsonb")
	@Column(columnDefinition = "jsonb")
	private JsonNode instruction;
	
	public int getFavorites() {
		return favorites;
	}
	public void setFavorites(int favorites) {
		this.favorites = favorites;
	}
	public JsonNode getInstruction() {
		return instruction;
	}
	public void setInstruction(JsonNode instruction) {
		this.instruction = instruction;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public Long getSubmitterId() {
		return submitterId;
	}
	public void setSubmitterId(Long submitterId) {
		this.submitterId = submitterId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getId() {
		return id;
	}
	
}
