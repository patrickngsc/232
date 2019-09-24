package eventdriven;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Memorylist {
	public static Memory[] memory;
	public static int numofblock;
	public int time=0;
	public static Memory head;
	// Method to insert a new node 
    public static void insert(int block,int msize) 
    { 
        // Create a new node with given data 
       Memory new_node = new Memory(block,msize); 
        new_node.next = null;
  
        // If the Linked List is empty, 
        // then make the new node as head 
        if (head == null) { 
            head = new_node; 
        } 
        else { 
            // Else traverse till the last node 
            // and insert the new_node there 
            Memory last = head; 
            while (last.next != null) { 
                last = last.next; 
            } 
  
            // Insert the new_node at last node 
            last.next = new_node; 
        } 
  
        // Return the list by head 
       
    } 
  
    // Method to print the LinkedList. 
    public static void printList(Memorylist list) 
    { 
        Memory currNode = Memorylist.head; 
   
        System.out.print("LinkedList: "); 
   
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.println(currNode.block + " "+currNode.msize); 
   
            // Go to next node 
            currNode = currNode.next; 
        } 
    }
    
    
    
	public void readmemory(){
		int i=0;
		File file=new File("/Users/user/eclipse-workspace/CST232_1/res/MemoryList.txt");
		try {
			Scanner scan=new Scanner(file);
			numofblock=scan.nextInt();
			memory=new Memory[numofblock];
			while(scan.hasNextLine()&&i<numofblock) {
				int block=i+1;
				int msize=scan.nextInt();
				memory[i]=new Memory(block,msize);
				insert(block,msize);
				i++;
			}
			scan.close();
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	public void print() {
		for(int i=0;i<numofblock;i++) {
			System.out.println(memory[i].block+" "+memory[i].msize);
		}
	}
	public static int getnumofblock() {
		return numofblock;
	}
	public void firstfit(Job[] job,int numofjob) {
		int j,k;
		j=0;
		ArrayList<Job> waitjob=new ArrayList<Job>();
		while(j<numofjob){
			System.out.println(time);
		//	if(job[j].arrivalt==time) {
				for(k=0;k<numofblock;k++) {
					System.out.println(k);
					if(!memory[k].free&&time-job[memory[k].joballocated].arrctime==job[memory[k].joballocated].processingt) {
						memory[k].joballocated=0;
						memory[k].free=true;
						System.out.println("block "+(k+1)+" is free");
						System.out.println("Press Any Key To Continue...");
				          new java.util.Scanner(System.in).nextLine();
					}
				}
				for(k=0;k<numofblock;k++) {
					System.out.println(k);
					if(job[j].jobsize<=memory[k].msize&&memory[k].free) {
						memory[k].joballocated=j;
						job[j].arrctime=time;
						System.out.println("Job "+(j+1)+" -> block "+(k+1));
						memory[k].free=false;
						j++;
						System.out.println("Press Any Key To Continue...");
				          new java.util.Scanner(System.in).nextLine();
						break;
					}

					else if(job[j].jobsize>memory[k].msize||!memory[k].free) {
						System.out.println("Job "+(j+1)+" is in waiting queue");
					}
					
					if(job[j].jobsize>memory[k].msize&&k==9) {
						waitjob.add(job[j]);
						j++;
						break;
					}
					
				}
				
		//	}

			
			time++;
		}
	}
	
		public void llfirstfit() {
			while(!Joblist.isempty()){
				System.out.println(time);
				System.out.println(Joblist.first.arrivalt);
		/*		if(Joblist.first.arrivalt!=time) {
					time++;
					new java.util.Scanner(System.in).nextLine();
					continue;
				}*/
				Memory temp=head;
				
					while(temp!=null) {
						if(!temp.free&&time-temp.work.arrctime==temp.work.processingt) {
							temp.work=null;
							temp.free=true;
							System.out.println("block "+temp.block+" is free"+" at time "+time);
					//		System.out.println("Press Any Key To Continue...");
					//          new java.util.Scanner(System.in).nextLine();
						}
						temp=temp.next;
					}
					temp=head;
					while(temp!=null) {
						if(Joblist.first.jobsize<=temp.msize&&temp.free) {
							temp.work=Joblist.dequeue();
							temp.work.arrctime=time;
							System.out.println("Job "+temp.work.jobnum+" -> block "+temp.block+" at time "+temp.work.arrctime);
							temp.free=false;
					//		System.out.println("Press Any Key To Continue...");
					  //        new java.util.Scanner(System.in).nextLine();
							break;
						}

						else if(Joblist.first.jobsize>temp.msize||!temp.free) {
							System.out.println("next memory block");
						}
						
						if(Joblist.first.jobsize>temp.msize&&temp.next==null) {
							System.out.println("Job "+Joblist.first.jobnum+" is in waiting queue");
							Joblist.dequeue();
							
						}
							temp=temp.next;
						}
						time++;
					}
					
			

				
				
			}

	    static void bestFit(Job[] job,int numofjob) 
		{ 
		// Stores block id of the block allocated to a 
		// process 
		int allocation[] = new int[numofjob]; 
		
		// Initially no block is assigned to any process 
		for (int i = 0; i < allocation.length; i++) 
		allocation[i] = -1; 
		
		// pick each process and find suitable blocks 
		// according to its size ad assign to it 
		for (int i=0; i<numofjob; i++) 
		{ 
		// Find the best fit block for current process 
		int bestIdx = -1; 
		for (int j=0; j<numofblock; j++) 
		{ 
		if (memory[j].msize >= job[i].jobsize) 
		{ 
			if (bestIdx == -1) 
			bestIdx = j; 
			else if (memory[bestIdx].msize > memory[j].msize ) 
			bestIdx = j; 
		} 
		} 
		
		// If we could find a block for current process 
		if (bestIdx != -1) 
		{ 
		// allocate block j to p[i] process 
		allocation[i] = bestIdx; 
		
		// Reduce available memory in this block. 
		memory[bestIdx].msize-= job[i].jobsize; 
		} 
		} 
		
		System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
		for (int i = 0; i < numofjob; i++) 
		{ 
		System.out.print("   " + (i+1) + "\t\t" + job[i].jobsize + "\t\t"); 
		if (allocation[i] != -1) 
		System.out.print(allocation[i] + 1); 
		else
		System.out.print("Not Allocated"); 
		System.out.println(); 
		} 
		} 
}
