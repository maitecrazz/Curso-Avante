package ficheros;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LogEntry {
	private LocalDateTime dateTime;
	private String verb;	
	private String URI;
	private Integer response;
	private double responseTime;
	
	public LogEntry(LocalDateTime dateTime, double milliseconds, String verb, String uRI, int response,
			double responseTime) {
		super();
		this.dateTime = dateTime;
		this.verb = verb;
		URI = uRI;
		this.response = response;
		this.responseTime = responseTime;
	}
	
	public LogEntry(String entry) throws ParseException  {
		super();
		entry = entry.trim();
		
		this.dateTime = calculaFecha(entry.substring(0, 23));
				
		entry = entry.substring(23).trim();
		int index = entry.indexOf(" ");
		this.verb = entry.substring(0, index);
		
		entry = entry.substring(index).trim();
		index = entry.lastIndexOf("\"")+1;
		this.URI = entry.substring(1, index-1);
		
		entry = entry.substring(index).trim();
		index = entry.indexOf(" ");
		this.response = Integer.parseInt(entry.substring(1, index-1));
		
		entry = entry.substring(index).trim();
		this.responseTime = Double.parseDouble(entry);
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getRequestType() {
		return verb;
	}

	public void setRequestType(String requestType) {
		this.verb = requestType;
	}

	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}

	public Integer getResponse() {
		return response;
	}

	public void setResponse(Integer response) {
		this.response = response;
	}

	public double getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(double responseTime) {
		this.responseTime = responseTime;
	}
	
	private LocalDateTime calculaFecha(String fecha) {
		String[] splittedDate = fecha.split(" ");
		String[] dia = splittedDate[0].split("-");
		String[] hora = splittedDate[1].split(":");
		LocalDate date = LocalDate.of(Integer.parseInt(dia[0]), 
				Integer.parseInt(dia[1]), Integer.parseInt(dia[2])); 
		LocalTime time = LocalTime.of(Integer.parseInt(hora[0]), 
				Integer.parseInt(hora[1]), Integer.parseInt(hora[2].split(",")[0]),
				Integer.parseInt(hora[2].split(",")[1]));
		
		return LocalDateTime.of(date, time);
	}
	
	
}
