package com.axis.lms.dto;

import java.time.LocalTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MessagesDto {
	private Integer messageId;
	private String senderId;
	private String reciverId;
	private String messageText;
	private LocalTime timeStamp;

}
