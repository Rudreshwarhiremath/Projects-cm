package com.axis.lms.service;

import java.time.LocalTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.lms.dto.MessagesDto;
import com.axis.lms.entity.MessagesEntity;
import com.axis.lms.entity.UserEntity;
import com.axis.lms.repository.MessageRepositery;
import com.axis.lms.repository.UserRepository;

@Service
public class MessagesServiceImpl implements MessagesService {
	@Autowired
	private MessageRepositery messageRepositery;
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean save(MessagesDto messagesDto) {
		UserEntity userEntity = userRepository.findByUserName(messagesDto.getSenderId());
		UserEntity userEntity1 = userRepository.findByUserName(messagesDto.getReciverId());
		MessagesEntity mentity = new MessagesEntity();
		mentity.setSenderId(userEntity.getUserId());
		mentity.setReciverId(userEntity1.getUserId());
		mentity.setTimeStamp(LocalTime.now());
		mentity.setMessageText(messagesDto.getMessageText());
		mentity.setMessageId(messagesDto.getMessageId());
		mentity.setUserEntity(userEntity);
		this.messageRepositery.save(mentity);
		return true;
	}

	@Override
	public MessagesDto findByReciverId(String reciver) {
		UserEntity userEntity = this.userRepository.findByUserName(reciver);
		MessagesEntity messagesEntity=this.messageRepositery.findByReciverId(userEntity.getUserId());
		MessagesDto messagesDto=new MessagesDto();
		messagesDto.setMessageText(messagesEntity.getMessageText());
		return messagesDto;
	}

}
