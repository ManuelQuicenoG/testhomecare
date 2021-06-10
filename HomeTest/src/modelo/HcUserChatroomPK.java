package modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hc_user_chatrooms database table.
 * 
 */
@Embeddable
public class HcUserChatroomPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="hc_users_user_id", insertable=false, updatable=false)
	private Integer hcUsersUserId;

	@Column(name="hc_chatrooms_chat_r_id", insertable=false, updatable=false)
	private String hcChatroomsChatRId;

	public HcUserChatroomPK() {
	}
	public Integer getHcUsersUserId() {
		return this.hcUsersUserId;
	}
	public void setHcUsersUserId(Integer hcUsersUserId) {
		this.hcUsersUserId = hcUsersUserId;
	}
	public String getHcChatroomsChatRId() {
		return this.hcChatroomsChatRId;
	}
	public void setHcChatroomsChatRId(String hcChatroomsChatRId) {
		this.hcChatroomsChatRId = hcChatroomsChatRId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HcUserChatroomPK)) {
			return false;
		}
		HcUserChatroomPK castOther = (HcUserChatroomPK)other;
		return 
			this.hcUsersUserId.equals(castOther.hcUsersUserId)
			&& this.hcChatroomsChatRId.equals(castOther.hcChatroomsChatRId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hcUsersUserId.hashCode();
		hash = hash * prime + this.hcChatroomsChatRId.hashCode();
		
		return hash;
	}
}