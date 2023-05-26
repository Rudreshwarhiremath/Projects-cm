package com.axis.lms.entity;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "message")
public class MessagesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer messageId;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id")
	private Long senderId;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id")
	private Long reciverId;
	private String messageText;
	private LocalTime timeStamp;
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "userId",referencedColumnName ="userId" )
	private UserEntity userEntity;

}
