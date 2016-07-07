package io.vertx.web.domain;

import java.io.Serializable;
import java.util.Date;

import io.vertx.core.json.JsonObject;

public class TbIDAuth implements Serializable {

	private static final long serialVersionUID = 3946800615894295220L;

	private Integer id;
	private String serial_number;
	private String phone_number;
	private String certNo;
	private Integer order_id;
	private String type;
	private String channel;
	private Date create_time;
	private Integer status;
	private String request;
	private String response;
	private Date update_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return String.format(
				"TbIDAuth [id=%s, serial_number=%s, phone_number=%s, certNo=%s, order_id=%s, type=%s, channel=%s, create_time=%s, status=%s, request=%s, response=%s, update_time=%s]",
				id, serial_number, phone_number, certNo, order_id, type, channel, create_time, status, request,
				response, update_time);
	}

	public JsonObject toJsonObject() {
		return new JsonObject().put("id", id).put("serial_number", serial_number).put("phone_number", phone_number)
				.put("certNo", certNo).put("order_id", order_id);
	}

}
