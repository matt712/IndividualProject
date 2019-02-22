package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MatchUpNote {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int noteID;
	@Column
	private String vsCharacter;
	@Column
	private String contents;
	public void setId(int idNew) {
		this.noteID = idNew;
	}
	public int getId(){
		return noteID;
	}
	public void setVsCharacter(String vsCharacterNew) {
		this.vsCharacter = vsCharacterNew;
	}
	public String getVsCharacter()
	{
		return vsCharacter;
	}
	public void setContents(String newContents) {
		this.contents = newContents;
	}
	public String getContents() {
		return contents;
	}
}
