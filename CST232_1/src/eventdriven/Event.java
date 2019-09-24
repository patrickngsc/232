package eventdriven;

public class Event {
	public int timeofevent;
	public int jobarrive;
	public int jobleave;
	public int waitingtime;
	public int nexteventtime;
	public Event(int timeofevent,int jobarrive,int jobleave,int waitingtime,int nexteventtime){
		this.timeofevent=timeofevent;
		this.jobarrive=jobarrive;
		this.jobleave=jobleave;
		this.waitingtime=waitingtime;
		this.nexteventtime=nexteventtime;
	}
	public int getTimeofevent() {
		return timeofevent;
	}
	public void setTimeofevent(int timeofevent) {
		this.timeofevent = timeofevent;
	}
	public int getJobarrive() {
		return jobarrive;
	}
	public void setJobarrive(int jobarrive) {
		this.jobarrive = jobarrive;
	}
	public int getJobleave() {
		return jobleave;
	}
	public void setJobleave(int jobleave) {
		this.jobleave = jobleave;
	}
	public int getWaitingtime() {
		return waitingtime;
	}
	public void setWaitingtime(int waitingtime) {
		this.waitingtime = waitingtime;
	}
	public int getNexteventtime() {
		return nexteventtime;
	}
	public void setNexteventtime(int nexteventtime) {
		this.nexteventtime = nexteventtime;
	}
}
