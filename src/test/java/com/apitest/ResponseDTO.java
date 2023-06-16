package com.apitest;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDTO{

	@JsonProperty("data")
	private List<DataItem> data;

	@JsonProperty("message")
	private String message;

	@JsonProperty("status")
	private String status;

	public List<DataItem> getData(){
		return data;
	}

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}
}