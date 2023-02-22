package com.m2i.validation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

@Entity @Table(name="T_User")
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message="Must not be null")
	private Long userId;
	
	@Size(max = 20, min = 3, message = "Size should be between 3 to 20")
	@NotEmpty(message = "Enter your name")
	private String userName;
	
	@Email(message = "Invalid EmailId.Please enter proper EmailId")
	@NotEmpty(message = "Enter your email")
	private String userEmailId;

	@Digits(integer = 3, fraction = 3, message ="Invalid age, Maximum valid number for age is 3 digits")
	private int age;
	
	@Length(max = 5, message = "maximum 5 caractères")
	private String currentTimeOfWritingArticles; // Au maximum 5 caractères
	
	@Length(min = 3, message ="Au minimum 3 caractères")
	private String proficiency2; // Au minimum 3 caractères

	@NotBlank(message = "Ne doit pas etre vide")
	private String proficiency3; // Ne doit pas etre vide
	
	@Null(message = "Doit etre Null")
	private String proficiency4; // Doit etre Null
	
	@Pattern(regexp = "YN", flags = {Flag.CASE_INSENSITIVE}, message = "Doit etre exactement les caracteres \"YN\"" )
	private String proficiency5; // Doit etre exactement les caracteres "YN"

	@Positive(message = "Doit etre positif")
	private int rating; // Doit etre positif

	@NegativeOrZero(message = "Doit etre negatif ou 0")
	private int blocklisted; // Doit etre negatif ou 0
	
	@Future(message="Doit etre dans le futur")
	private Date futureDate; // Doit etre dans le futur
	
	@FutureOrPresent(message="Doit etre aujourd'hui ou dans le futur")
	private Date futureOrPresent; // Doit etre aujourd'hui ou dans le futur

	@PastOrPresent(message = "Doit etre aujourd'hui ou dans le passé")
	private Date pastOrPresent; // Doit etre aujourd'hui ou dans le passé
	
	@Range(min = 1, max = 3, message = "Doit être entre 1 et 3")
	private int rangeExample; // Doit être entre 1 et 3 
	
	@URL(message = "Doit être une url valide")
	private String urlExample; // Doit être une url valide
	
	@CreditCardNumber(message = "Doit etre un numero de carte de credit valide")
	private String creditCardExample; // Doit etre un numero de carte de credit valide
	
	public String getProficiency3() {
		return proficiency3;
	}

	public void setProficiency3(String proficiency3) {
		this.proficiency3 = proficiency3;
	}

	public String getProficiency4() {
		return proficiency4;
	}

	public void setProficiency4(String proficiency4) {
		this.proficiency4 = proficiency4;
	}

	public String getProficiency5() {
		return proficiency5;
	}

	public void setProficiency5(String proficiency5) {
		this.proficiency5 = proficiency5;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getBlocklisted() {
		return blocklisted;
	}

	public void setBlocklisted(int blocklisted) {
		this.blocklisted = blocklisted;
	}

	public Date getFutureDate() {
		return futureDate;
	}

	public void setFutureDate(Date futureDate) {
		this.futureDate = futureDate;
	}

	public Date getFutureOrPresent() {
		return futureOrPresent;
	}

	public void setFutureOrPresent(Date futureOrPresent) {
		this.futureOrPresent = futureOrPresent;
	}

	public Date getPastOrPresent() {
		return pastOrPresent;
	}

	public void setPastOrPresent(Date pastOrPresent) {
		this.pastOrPresent = pastOrPresent;
	}

	public int getRangeExample() {
		return rangeExample;
	}

	public void setRangeExample(int rangeExample) {
		this.rangeExample = rangeExample;
	}

	public String getUrlExample() {
		return urlExample;
	}

	public void setUrlExample(String urlExample) {
		this.urlExample = urlExample;
	}

	public String getCreditCardExample() {
		return creditCardExample;
	}

	public void setCreditCardExample(String creditCardExample) {
		this.creditCardExample = creditCardExample;
	}

	public int getAge() {
		return age;
	}

	public String getProficiency2() {
		return proficiency2;
	}

	public void setProficiency2(String proficiency2) {
		this.proficiency2 = proficiency2;
	}

	public String getCurrentTimeOfWritingArticles() {
		return currentTimeOfWritingArticles;
	}

	public void setCurrentTimeOfWritingArticles(String currentTimeOfWritingArticles) {
		this.currentTimeOfWritingArticles = currentTimeOfWritingArticles;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public User(int id, @NotNull(message = "Must not be null") Long userId,
			@Size(max = 20, min = 3, message = "Size should be between 3 to 20") @NotEmpty(message = "Enter your name") String userName,
			@Email(message = "Invalid EmailId.Please enter proper EmailId") @NotEmpty(message = "Enter your email") String userEmailId,
			@Digits(integer = 3, fraction = 3, message = "Invalid age, Maximum valid number for age is 3 digits") int age,
			@Length(max = 5, message = "maximum 5 caractères") String currentTimeOfWritingArticles,
			@Length(min = 3, message = "Au minimum 3 caractères") String proficiency2,
			@NotBlank(message = "Ne doit pas etre vide") String proficiency3,
			@Null(message = "Doit etre Null") String proficiency4,
			@Pattern(regexp = "YN", flags = Flag.CASE_INSENSITIVE, message = "Doit etre exactement les caracteres \"YN\"") String proficiency5,
			@Positive(message = "Doit etre positif") int rating,
			@NegativeOrZero(message = "Doit etre negatif ou 0") int blocklisted,
			@Future(message = "Doit etre dans le futur") Date futureDate,
			@FutureOrPresent(message = "Doit etre aujourd'hui ou dans le futur") Date futureOrPresent,
			@PastOrPresent(message = "Doit etre aujourd'hui ou dans le passé") Date pastOrPresent,
			@Range(min = 1, max = 3, message = "Doit être entre 1 et 3") int rangeExample,
			@URL(message = "Doit être une url valide") String urlExample,
			@CreditCardNumber(message = "Doit etre un numero de carte de credit valide") String creditCardExample) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.userEmailId = userEmailId;
		this.age = age;
		this.currentTimeOfWritingArticles = currentTimeOfWritingArticles;
		this.proficiency2 = proficiency2;
		this.proficiency3 = proficiency3;
		this.proficiency4 = proficiency4;
		this.proficiency5 = proficiency5;
		this.rating = rating;
		this.blocklisted = blocklisted;
		this.futureDate = futureDate;
		this.futureOrPresent = futureOrPresent;
		this.pastOrPresent = pastOrPresent;
		this.rangeExample = rangeExample;
		this.urlExample = urlExample;
		this.creditCardExample = creditCardExample;
	}

	public User() {
		super();
	}	
}
