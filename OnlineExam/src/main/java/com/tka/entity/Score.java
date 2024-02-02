package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Score
{
	@Id
	int score;

	public Score() {
	
	}

	 
	public Score(int score) {
		
		this.score = score;
	}

	

	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	@Override
	public String toString() {
		return "Score [score=" + score + "]";
	}
	
	

}
