package com.vega.springit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter @Setter
@ToString
@RequiredArgsConstructor
public class Comment extends Auditable{

	@Id
	@GeneratedValue
	private long id;
	@NonNull
	private String body;
	
	@ManyToOne
	@NonNull
	private Link link;

}
