package eventdriven;
import java.util.*;
import java.io.*;
public class Joblist {
	public static Job[] job;
	public static int numofjob=0;
	public static Job first;
	public static Job last;
	public static int n;
	public static boolean isempty() {
		return first==null;
	}
	
	public Job peek() {
        if (isempty()) throw new NoSuchElementException("Queue underflow");
        return first;
    }
	
	public static void enqueue(int jobnum, int arrivalt, int processingt , int jobsize) {
        Job oldlast = last;
        last = new Job(jobnum,arrivalt,processingt,jobsize);
        last.next = null;
        if (isempty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public static Job dequeue() {
        if (isempty()) throw new NoSuchElementException("Queue underflow");
        Job item = first;
        first = first.next;
        n--;
        if (isempty()) last = null;   // to avoid loitering
        return item;
    }
    
    public static void printQueue(Joblist list) 
    { 
        Job currNode = Joblist.first; 
   
        System.out.print("Queue: "); 
   
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.println(currNode.jobnum + " "+currNode.arrivalt+ " "+currNode.processingt+ " "+currNode.jobsize); 
   
            // Go to next node 
            currNode = currNode.next; 
        } 
    }

	public static void readjob() {
		int i=0;
		File file=new File("/Users/user/eclipse-workspace/CST232_1/res/Joblist.txt");
		try {
			Scanner scan=new Scanner(file);
			numofjob=scan.nextInt();
			job=new Job[numofjob];
			while(scan.hasNextLine()&&i<numofjob) {
				int jobnum=scan.nextInt();
				int arrivalt=scan.nextInt();
				int processingt=scan.nextInt();
				int jobsize=scan.nextInt();
				job[i]=new Job(jobnum,arrivalt,processingt,jobsize);
				enqueue(jobnum, arrivalt, processingt , jobsize);
				i++;
			}
			scan.close();

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	public static void print() {
		for(int i=0;i<numofjob;i++) {
			System.out.println(job[i].jobnum+" "+job[i].arrivalt+" "+job[i].processingt+" "+job[i].jobsize);
		}
	}
	public static int getnumofjob() {
		return numofjob;
	}
	
	public static void main(String[] arg) {
		Joblist jlist =new Joblist();
		Joblist.readjob();
		Joblist.print();
		Memorylist mlist =new Memorylist();
		mlist.readmemory();
		Memorylist.printList(mlist);
		Joblist.printQueue(jlist);
	//	mlist.firstfit(job, numofjob);
		mlist.llfirstfit();
		Memorylist.bestFit( job, numofjob);
	}

}
