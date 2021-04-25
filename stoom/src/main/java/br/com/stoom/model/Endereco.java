package br.com.stoom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "endereco")
@ApiModel(description = "Classe de modelagem de Endereços à serem utilizados no CRUD")
public class Endereco implements Serializable{
	
   	/**
	 * 
	 */
	private static final long serialVersionUID = -7843813315667027700L;

	@Id
  	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "ID único, chave da tabela")
   	private long id;
   	
   	@Column(nullable = false)
   	@ApiModelProperty(notes = "Nome da Rua")
    private String streetName;
   	
   	@Column(nullable = false)
   	@ApiModelProperty(notes = "Número do imóvel")
    private String number;
   	
   	@Column(nullable = true)
   	@ApiModelProperty(notes = "Complemento")
    private String complement;
    
    @Column(nullable = false)
    @ApiModelProperty(notes = "Bairro")
    private String neighbourhood;
    
    @Column(nullable = false)
    @ApiModelProperty(notes = "Cidade")
    private String city;
    
    @Column(nullable = false)
    @ApiModelProperty(notes = "Estado")
    private String state;
    
    @Column(nullable = false)
    @ApiModelProperty(notes = "País")
    private String country;
    
    @Column(nullable = false)
    @ApiModelProperty(notes = "CEP")
    private String zipcode;
    
    @Column(nullable = true)
    @ApiModelProperty(notes = "Latitude")
    private String latitude;
    
    @Column(nullable = true)
    @ApiModelProperty(notes = "Longitude")
    private String longitude;
    
    
    public Endereco() {
		
	}
    
    public Endereco(String streetName, String number, String complement, String neighbourhood, String city,
			String state, String country, String zipcode, String latitude, String logitude) {
		super();
		this.streetName = streetName;
		this.number = number;
		this.complement = complement;
		this.neighbourhood = neighbourhood;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.latitude = latitude;
		this.longitude = logitude;
	}
	
	public Endereco(long id, String streetName, String number, String complement, String neighbourhood, String city,
			String state, String country, String zipcode, String latitude, String logitude) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.number = number;
		this.complement = complement;
		this.neighbourhood = neighbourhood;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.latitude = latitude;
		this.longitude = logitude;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getStreetName() {
		return streetName;
	}



	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public String getComplement() {
		return complement;
	}



	public void setComplement(String complement) {
		this.complement = complement;
	}



	public String getNeighbourhood() {
		return neighbourhood;
	}



	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getZipcode() {
		return zipcode;
	}



	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}



	public String getLatitude() {
		return latitude;
	}



	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}



	public String getLongitude() {
		return longitude;
	}



	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
