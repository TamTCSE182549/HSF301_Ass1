package hsf301.fe.pojo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@Column(name = "user_name", nullable = false, unique = true)
	private String userName;
	
	@Column(name = "password", nullable = false)
	private String password;

	public Account() {
		super();
	}

	public Account(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [userName=" + userName + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
	}
	
	
}
