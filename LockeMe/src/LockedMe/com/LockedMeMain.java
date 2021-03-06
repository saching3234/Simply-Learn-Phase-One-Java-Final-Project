package LockedMe.com;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;



public class LockedMeMain {
	 
	 static final String folderPath="E:\\My File Folder";
	 static int choice=0;
	 static  Scanner sc=new Scanner(System.in);	 
     static String errorMsg="Something wrong happened please contact admin@sachin.com";
     
	
	
 //main method	
	public static void main(String[] args) {
	
		
		// Do while loop for displaying the user menu again and again
		do {
		     displayMenu();
		     try {
		     System.out.println("Enter Your Choice : ");
		     choice=Integer.parseInt(sc.nextLine());
		     }catch(Exception ex) {
		    	 System.out.println("Only Numbers  allowed  ");
		    	 break;
		     }
		     //checking the user choice and calling the appropriate fucntion
		     switch(choice) {
		     case 1:
		         	 displayAllFiles();
		    	     break;
		     case 2:
		    	      addNewFile();
		    	      break;
		     case 3:
	    	         deleteFile();
	    	          break;
		     case 4:
	    	         searchFile();
	    	          break;
	    	      
		       default:
		    	       if(choice!=5)
		    	    	   System.out.println("Please Enter your choice in the range of 1-5\n");
		     }
		
		}while(choice!=5);
		
		System.out.println("\n\nThanks for visiting the app good by have a nice day");
		sc.close();
}
//main method end here  	
	
	
	
	//function for display a menubar to user 
		public static void displayMenu() {
			System.out.println("\n\n************************************************************");
			System.out.println("\t\t Welcome to Lockedme.com ");
			System.out.println("*************************************************************");
			System.out.println("\t\t 1. Dsiplay All the files");
			System.out.println("\t\t 2. Add A New File");
			System.out.println("\t\t 3. Delete A File");
			System.out.println("\t\t 4. Search A File");
			System.out.println("\t\t 5. Exit");
			System.out.println("************************************************************");
			System.out.println("\t\t\t \tDesigned and Developed By          \n\t\t\t\t\t ----Sachin Gawade");
			System.out.println("*************************************************************");
			
		}	
	
	
	
	
  //displaying all files from the given directory 	
	static void displayAllFiles() {
		//creating the file object 
		File file=new  File("E:\\My File Folder");
		
		//getting the all file names in the folder
		File[] fileList=file.listFiles();
		if(fileList.length==0)
			System.out.println("\nFolder is empty please create some files to display name\n\n");
		
		//displaying the file name here
		
		else {
			System.out.println("\n\nFile Names Are :  \n\n");
			
			for(var fname:fileList) 			
				System.out.println(fname.getName());			
		}		
	}
	


//searching the file	
	private static void searchFile() {
		// TODO Auto-generated method stub
		
	    	File file=new  File("E:\\My File Folder");
			LinkedList<String> list=new LinkedList<String>();
			
				//getting the all file names in the folder
				File[] fileList=file.listFiles();
			
				if(fileList.length==0)
					System.out.println("\nFolder is empty please create some files first to search  \n\n");
				
				//displaying the file name here
				
				else {
					//adding file names to the linkedlist 
					//Scanner sc=new Scanner(System.in);
					String fileName;
					System.out.println("Enter The file name to search :  ");
					fileName=sc.nextLine();
					
					for(var fname:fileList) 			
						list.add(fname.getName());			
				
				
				if(list.contains(fileName))
					System.out.println(fileName+" Exist in the folder");
				else
					System.out.println(fileName+" File does not exist");
				}
		
	}


//function for deleting the file 	
	private static void deleteFile() {
	
	      String fname;
			
			try {
			System.out.println("\nEnter The file Name to delete :");
			fname=sc.nextLine();
			File file=new File(folderPath+"\\"+fname);
			
			//checking the file exist or not
			if(file.exists()) {
				file.delete();
				System.out.println(fname+" Deleted Successfully\n\n ");
			}	
			else
				System.out.println("Sorry No such file exist");
			
			
			}catch(Exception ex) {
				System.out.println(errorMsg);
			}
			
	}


		private static void addNewFile() {
			String fName;
			int noOfLines=0;
			try {
			System.out.println("Enter The file name first : ");
			fName=sc.nextLine();
			FileWriter fw=new FileWriter(folderPath+"\\"+fName);
			
			System.out.println("Enter How many lines you want to write :");
			noOfLines=Integer.parseInt(sc.nextLine());
			
			for(int i=1;i<=noOfLines;i++) {
				
			System.out.println("Enter The Message to write into the file ");
			fw.write(sc.nextLine()+"\n");
			}
			System.out.println("\n FIle Created and saved  Successfully");
		
			//closing the file
			 fw.close();
		      }catch(Exception ex) {
				System.out.println(errorMsg);	
				}
			
	        }
 }
