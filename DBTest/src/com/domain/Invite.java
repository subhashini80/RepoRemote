package com.domain;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Invite implements Serializable{
	int event_id;
	String event_name;
	
	String street_name;
	String city_name;
	String zipcode;
	String event_type;
	String theme_type;
	String event_date;
	String rsvp_date;
	
	
	public Invite()
	{
		 
		 event_name="";
		 
		 street_name="";
		 city_name="";
		 zipcode="";
		 event_type="";
		 theme_type="";
		 event_date="";
		 rsvp_date="";
		
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public String getTheme_type() {
		return theme_type;
	}
	public void setTheme_type(String theme_type) {
		this.theme_type = theme_type;
	}
	public String getEvent_date() {
		return event_date;
	}
	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}
	public String getRsvp_date() {
		return rsvp_date;
	}
	public void setRsvp_date(String rsvp_date) {
		this.rsvp_date = rsvp_date;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	
	
}
