package modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The persistent class for the hc_user_chatrooms database table.
 *
 */
@Entity
@Table(name = "hc_user_chatrooms")
@NamedQuery(name = "HcUserChatroom.findAll", query = "SELECT h FROM HcUserChatroom h")
public class HcUserChatroom implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HcUserChatroomPK id;

	// bi-directional many-to-one association to HcMessage
	@OneToMany(mappedBy = "hcUserChatroom", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<HcMessage> hcMessages;

	@ManyToOne
	@JoinColumn(name = "hc_users_user_id", insertable = false, updatable = false)
	private HcUser hcUser;

	@ManyToOne
	@JoinColumn(name = "hc_chatrooms_chat_r_id", insertable = false, updatable = false)
	private HcChatroom hcChatroom;

	public HcUserChatroom() {
	}

	public HcMessage addHcMessage(HcMessage hcMessage) {
		getHcMessages().add(hcMessage);
		hcMessage.setHcUserChatroom(this);

		return hcMessage;
	}

	public Set<HcMessage> getHcMessages() {
		return this.hcMessages;
	}

	public HcUserChatroomPK getId() {
		return this.id;
	}

	public HcMessage removeHcMessage(HcMessage hcMessage) {
		getHcMessages().remove(hcMessage);
		hcMessage.setHcUserChatroom(null);

		return hcMessage;
	}

	public void setHcMessages(Set<HcMessage> hcMessages) {
		this.hcMessages = hcMessages;
	}

	public void setId(HcUserChatroomPK id) {
		this.id = id;
	}

}