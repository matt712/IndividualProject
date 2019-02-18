package com.qa.persistence.domain;

public class MatchUpNote {
	private int noteID;
	private String vsCharacter;
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
