package lab4;

public class MonsterAttack {

	private int id;
	private String name;
	private String place;
	private int month;
	private int day;
	private int year;
	private int victims;

	public MonsterAttack(){
		id = 0;
		name = null;
		place = null;
		month = 0;
		day = 0;
		year = 0;
		victims = 0;
	}
	
	public MonsterAttack(int id, String date, String name, String place, int victims){
		this.id = id;
		String[] d = date.split("/");
		for(int i = 0; i < d.length; i++){
			month = Integer.parseInt(d[0]);
			day = Integer.parseInt(d[1]);
			year = Integer.parseInt(d[2]);
		}
		this.name = name;
		this.place = place;
		this.victims = victims;
	}
	
	public String toString(){
		return "ID No. " + id + ": " + name + " attacked " + place + " on " + month + "/" + day + "/" + year + ". " + victims + " dead";
	}

	public String getDate(){
		return month + "/" + day + "/" + year;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getVictims() {
		return victims;
	}
	

	public void setVictims(int victims) {
		this.victims = victims;
	}
	
}