package net.cloudcentrik.dagenslunch.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "token")
@NamedQueries(
    {
        @NamedQuery(
            name = "net.cloudcentrik.dagenslunch.core.Token.findAll",
            query = "SELECT p FROM Token p"
        )
    }
)

public class Token {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "token_id", nullable = false)
	private int id;
	
	@Column(name = "token_key", nullable = false)
	private String key;
	
	@Column(name = "token_secret", nullable = false)
	private String secret;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "token_time", nullable = false)
	private Date time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Token(int id, String key, String secret, Date time) {
		
		this.id = id;
		this.key = key;
		this.secret = secret;
		this.time = time;
	}

	public Token() {
		
	}

}
