package eventdriven;

public class Memory {
	public int block;
	public int msize;
	public int joballocated;
	public boolean free=true;
	Memory next;
	Job work;
	public Memory(int block, int msize) {
		this.block=block;
		this.msize=msize;
		joballocated=0;
		next=null;
	}
	public int getBlock() {
		return block;
	}

	public int getMsize() {
		return msize;
	}

}
