package com.model.mappingFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contacts")
public class Contacts {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "teamName")
	private String teamName;
	
	@Column(name = "player1")
	private String player1;
	
	@Column(name = "player2")
	private String player2;
	
	@Column(name = "player3")
	private String player3;
	
	@Column(name = "player4")
	private String player4;
	
	@Column(name = "player5")
	private String player5;
	
	@Column(name = "player6")
	private String player6;
	
	@Column(name = "player7")
	private String player7;
	
	@Column(name = "player8")
	private String player8;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	public String getPlayer3() {
		return player3;
	}

	public void setPlayer3(String player3) {
		this.player3 = player3;
	}

	public String getPlayer4() {
		return player4;
	}

	public void setPlayer4(String player4) {
		this.player4 = player4;
	}

	public String getPlayer5() {
		return player5;
	}

	public void setPlayer5(String player5) {
		this.player5 = player5;
	}

	public String getPlayer6() {
		return player6;
	}

	public void setPlayer6(String player6) {
		this.player6 = player6;
	}

	public String getPlayer7() {
		return player7;
	}

	public void setPlayer7(String player7) {
		this.player7 = player7;
	}

	public String getPlayer8() {
		return player8;
	}

	public void setPlayer8(String player8) {
		this.player8 = player8;
	}
	
	
}
