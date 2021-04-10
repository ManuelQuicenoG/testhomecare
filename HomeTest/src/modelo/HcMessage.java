package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;


/**
 * The persistent class for the hc_messages database table.
 * 
 */
@Entity
@Table(name="hc_messages")
@NamedQuery(name="HcMessage.findAll", query="SELECT h FROM HcMessage h")
public class HcMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_MESSAGES_MESSAGEID_GENERATOR", sequenceName="HC_MESSAGES_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_MESSAGES_MESSAGEID_GENERATOR")
	@Column(name="message_id")
	private Integer messageId;

	private String content;

	@Column(name="date_sent")
	private LocalDate dateSent;

	@Column(name="is_sent")
	private Boolean isSent;

	@Column(name="time_sent")
	private LocalTime timeSent;

	//bi-directional many-to-one association to HcUserChatroom
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="hc_user_chatrooms_hc_chatrooms_chat_r_id", referencedColumnName="hc_chatrooms_chat_r_id"),
		@JoinColumn(name="hc_user_chatrooms_user_id", referencedColumnName="hc_users_user_id")
		})
	private HcUserChatroom hcUserChatroom;

	public HcMessage() {
	}

	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getLocalDateSent() {
		return this.dateSent;
	}

	public void setLocalDateSent(LocalDate dateSent) {
		this.dateSent = dateSent;
	}

	public Boolean getIsSent() {
		return this.isSent;
	}

	public void setIsSent(Boolean isSent) {
		this.isSent = isSent;
	}

	public LocalTime getTimeSent() {
		return this.timeSent;
	}

	public void setTimeSent(LocalTime timeSent) {
		this.timeSent = timeSent;
	}

	public HcUserChatroom getHcUserChatroom() {
		return this.hcUserChatroom;
	}

	public void setHcUserChatroom(HcUserChatroom hcUserChatroom) {
		this.hcUserChatroom = hcUserChatroom;
	}

}