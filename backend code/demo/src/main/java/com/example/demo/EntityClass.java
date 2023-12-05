
package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;


@Entity


@Table(name = "rate")
public class EntityClass {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "usd")
    private double usd; 

    @Column(name = "eur")
    private double eur; 

    @Column(name = "gbp")
    private double gbp; 
    public EntityClass() {
    	
    }



	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public double getUsd() {
		return usd;
	}

	public void setUsd(double usd) {
		this.usd = usd;
	}

	public double getEur() {
		return eur;
	}

	public void setEur(double eur) {
		this.eur = eur;
	}

	public double getGbp() {
		return gbp;
	}

	public void setGbp(double d) {
		this.gbp = d;
	}

	public EntityClass(Long id, LocalDateTime timestamp, double usd, double eur, double gbp) {
		super();
		
		this.timestamp = timestamp;
		this.usd = usd;
		this.eur = eur;
		this.gbp = gbp;
	}




    
}
