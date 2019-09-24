package eventdriven;

public class Job {
	public int jobnum;
	public int arrivalt;
	public int processingt;
	public int jobsize;
	public int arrctime;
	Job next;
	public Job(int jobnum,int arrivalt,int processingt, int jobsize) {
		this.jobnum=jobnum;
		this.arrivalt=arrivalt;
		this.processingt=processingt;
		this.jobsize=jobsize;
		next=null;
	}
	
	public int getJobnum() {
		return jobnum;
	}

	public int getArrivalt() {
		return arrivalt;
	}

	public int getProcessingt() {
		return processingt;
	}

	public int getJobsize() {
		return jobsize;
	}

	
}
