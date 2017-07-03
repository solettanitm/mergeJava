package merge;

public class Interval {

	private String since;
	private String until;

	public Interval(String since, String until){
		this.since = since;
		this.until = until;
	} 
	
	public String getSince() {
		return since;
	}
	public void setSince(String since) {
		this.since = since;
	}
	public String getUntil() {
		return until;
	}
	public void setUntil(String until) {
		this.until = until;
	}
	
	
}
