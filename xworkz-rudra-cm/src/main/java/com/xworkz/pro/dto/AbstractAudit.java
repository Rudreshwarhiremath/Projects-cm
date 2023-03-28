package com.xworkz.pro.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public abstract class AbstractAudit {
	private String createdBy;
	private LocalDateTime createdDate;
	private String updatedBy;
	private LocalDateTime updatedDate;

}
