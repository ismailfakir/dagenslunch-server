package net.cloudcentrik.dagenslunch.core;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
@NamedQueries(
    {
        @NamedQuery(
            name = "net.cloudcentrik.dagenslunch.core.Restaurant.findAll",
            query = "SELECT p FROM Restaurant p"
        )
    }
)
public class Restaurant {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "latitude", nullable = false)
	private double latitude;
	
	@Column(name = "longitude", nullable = false)
	private double longitude;
	
	@Column(name = "street", nullable = false)
	private String street;
	
	@Column(name = "post_code", nullable = false)
	private String postCode;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "telephone", nullable = false)
	private String telephone;
	
	@Column(name = "opening_hours", nullable = false)
	private String openingHours;
	
	@Column(name = "category", nullable = false)
	private String category;
	
	@Column(name = "rating", nullable = false)
	private short rating;
	
	@Column(name = "active", nullable = false)
	private boolean active;
	
	@Column(name = "validity_date", nullable = false)
	private Date validityDate;

	public Restaurant() {
		
	}

	public Restaurant(int id, String name, double latitude, double longitude, String street, String postCode,
			String city, String country, String email, String password, String telephone, String openingHours,
			String category, short rating, boolean active, Date validityDate) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.street = street;
		this.postCode = postCode;
		this.city = city;
		this.country = country;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.openingHours = openingHours;
		this.category = category;
		this.rating = rating;
		this.active = active;
		this.validityDate = validityDate;
	}
	
	

	public int getId() {
		return id;
	}

	public Restaurant setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String catagory) {
		this.category = catagory;
	}

	public short getRating() {
		return rating;
	}

	public void setRating(short rating) {
		this.rating = rating;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}
}
