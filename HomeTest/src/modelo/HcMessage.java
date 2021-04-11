package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the hc_messages database table.
 *
 */
@Entity
@Table(name = "hc_messages")
@NamedQuery(name = "HcMessage.findAll", query = "SELECT h FROM HcMessage h")
public class HcMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HC_MESSAGES_MESSAGEID_GENERATOR", sequenceName = "HC_MESSAGES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HC_MESSAGES_MESSAGEID_GENERATOR")
	@Column(name = "message_id")
	private Integer messageId;

	private String content;

	@Column(name = "date_sent")
	private LocalDate dateSent;

	@Column(name = "is_sent")
	private Boolean isSent;

	@Column(name = "time_sent")
	private LocalTime timeSent;

	// bi-directional many-to-one association to HcUserChatroom
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "hc_user_chatrooms_hc_chatrooms_chat_r_id", referencedColumnName = "hc_chatrooms_chat_r_id"),
			@JoinColumn(name = "hc_user_chatrooms_user_id", referencedColumnName = "hc_users_user_id") })
	private HcUserChatroom hcUserChatroom;

	public HcMessage() {
	}

	public String getContent() {
		return this.content;
	}

	public LocalDate getDateSent() {
		return this.dateSent;
	}

	public HcUserChatroom getHcUserChatroom() {
		return this.hcUserChatroom;
	}

	public Boolean getIsSent() {
		return this.isSent;
	}

	public Integer getMessageId() {
		return this.messageId;
	}

	public LocalTime getTimeSent() {
		return this.timeSent;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDateSent(LocalDate dateSent) {
		this.dateSent = dateSent;
	}

	public void setHcUserChatroom(HcUserChatroom hcUserChatroom) {
		this.hcUserChatroom = hcUserChatroom;
	}

	public void setIsSent(Boolean isSent) {
		this.isSent = isSent;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public void setTimeSent(LocalTime timeSent) {
		this.timeSent = timeSent;
	}

}