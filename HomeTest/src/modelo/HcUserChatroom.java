package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the hc_user_chatrooms database table.
 * 
 */
@Entity
@Table(name="hc_user_chatrooms")
@NamedQuery(name="HcUserChatroom.findAll", query="SELECT h FROM HcUserChatroom h")
public class HcUserChatroom implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcUserChatroomPK id;

	//bi-directional many-to-one association to HcMessage
	@OneToMany(mappedBy="hcUserChatroom", fetch=FetchType.EAGER)
	private Set<HcMessage> hcMessages;

	public HcUserChatroom() {
	}

	public HcUserChatroomPK getId() {
		return this.id;
	}

	public void setId(HcUserChatroomPK id) {
		this.id = id;
	}

	public Set<HcMessage> getHcMessages() {
		return this.hcMessages;
	}

	public void setHcMessages(Set<HcMessage> hcMessages) {
		this.hcMessages = hcMessages;
	}

	public HcMessage addHcMessage(HcMessage hcMessage) {
		getHcMessages().add(hcMessage);
		hcMessage.setHcUserChatroom(this);

		return hcMessage;
	}

	public HcMessage removeHcMessage(HcMessage hcMessage) {
		getHcMessages().remove(hcMessage);
		hcMessage.setHcUserChatroom(null);

		return hcMessage;
	}

}