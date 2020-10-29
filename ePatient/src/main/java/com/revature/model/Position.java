package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "positionlookup")
public class Position {
	@Id
    @Column(name = "positionid")
    @GeneratedValue(generator = "position_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "position_id_seq", sequenceName = "position_id_seq")
	private int id;
	
	@Column(name = "position")
	private String name;
	
	public Position() {}
	
	public Position(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
