package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the hc_chatrooms database table.
 * 
 */
@Entity
@Table(name="hc_chatrooms")
@NamedQuery(name="HcChatroom.findAll", query="SELECT h FROM HcChatroom h")
public class HcChatroom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HC_CHATROOMS_CHATRID_GENERATOR", sequenceName="HC_CHATROOMS_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HC_CHATROOMS_CHATRID_GENERATOR")
	@Column(name="chat_r_id")
	private String chatRId;

	@Column(name="is_active")
	private Boolean isActive;

	//bi-directional many-to-many association to HcUser
	@ManyToMany(mappedBy="hcChatrooms", fetch=FetchType.EAGER)
	private Set<HcUser> hcUsers;

	public HcChatroom() {
	}

	public String getChatRId() {
		return this.chatRId;
	}

	public void setChatRId(String chatRId) {
		this.chatRId = chatRId;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Set<HcUser> getHcUsers() {
		return this.hcUsers;
	}

	public void setHcUsers(Set<HcUser> hcUsers) {
		this.hcUsers = hcUsers;
	}

}