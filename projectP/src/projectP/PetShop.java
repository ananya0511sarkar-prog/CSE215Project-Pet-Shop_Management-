package projectP;

import java.util.Scanner;
import java.util.*;
import java.io.*;
import bird.*;

class CustomerInfo{
	private String name , phonenum;
	
	CustomerInfo(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	
	CustomerInfo(String n , String phn){
		name = n;
		phonenum = phn;
	}
	
}
class InvalidInputException extends Exception{
	int input;
	
	InvalidInputException(int input){
		this.input = input;
	}
	
	@Override
	public String toString() {
		return "InvalidInputException [input=" + input + "]";
	}
	
}

class InvalidInput1Exception extends Exception{
	int input1;
	
	InvalidInput1Exception(int input1){
		this.input1 = input1;
	}
	
	@Override
	public String toString() {
		return "InvalidInputException [input=" + input1 + "]";
	}
	
}
class InvalidInput2Exception extends Exception{
	int input2;
	
	InvalidInput2Exception(int input2){
		this.input2 = input2;
	}
    
	@Override
	public String toString() {
		return "InvalidInputException [input=" + input2 + "]";
	}
	
}
public class PetShop{

	static void Compute(int input) throws InvalidInputException{
		if(input==2) {
			System.out.println("Your input is valid!");
		}else {
			System.err.println("Try again later!");
			throw new InvalidInputException(input);
			
		}
	}
	

static void Compute1(int input1) throws InvalidInput1Exception{
	if(input1==2 || input1==4) {
		System.out.println("Your input is valid!");
		if(input1==2) {
			System.out.println("We have this 2 legged Animal.");
			System.out.println("rabbit");
		}
		if(input1==4) {
			System.out.println("We have these 4 legged Animals.");
			System.out.println("Cat, Dog, Cow, Goat");
		}
	}else {
		System.err.println("Try again later!");
		throw new InvalidInput1Exception(input1);
	}
}

static void Compute2(int input2) throws InvalidInput2Exception{
	if(input2==1) {
		System.out.println("Your input is valid!");
	}else {
		System.err.println("Try again later!");
		throw new InvalidInput2Exception(input2);
		
	}
}
	public static void main(String[] args) {
		
		CustomerInfo pdata = new CustomerInfo();
		try {//1
			FileWriter fileWrite = new FileWriter("PetShop.txt");
			fileWrite.write("Customer Information File\n\n");
		System.out.println("We need customer information! We need your name & phone number.");
		System.out.println("For example: ");
		CustomerInfo exampledata = new CustomerInfo("Jhon Smith" , "01978437999");
		System.out.println("Name: "+exampledata.getName());
		System.out.println("Phone Number: "+exampledata.getPhonenum());
		System.out.println("Please, enter your name:");
		Scanner scan = new Scanner(System.in);
		
		
		String customer_name = scan.nextLine();
		pdata.setName(customer_name);
		System.out.println(pdata.getName());
		fileWrite.write(pdata.getName()+"\n");//1
		System.out.println("Phone number(it must be in 11 digits): ");
		String customer_phone = scan.nextLine();
		pdata.setPhonenum(customer_phone);
		if(customer_phone.matches("[0][1][3-9][0-9]{8}")) {
	    	  System.out.println("Valid phone number");
	    	  System.out.println(pdata.getPhonenum());
	    	  fileWrite.write(pdata.getPhonenum()+"\n");
	      }else {
	    	  System.err.println("Invalid Phone Number! Please, read the example given above.");
	    	  return ;
	      }
		fileWrite.close();
	}catch(IOException e) {
		System.out.println("An error occured");
		e.printStackTrace();
	}
		Scanner scan = new Scanner(System.in);
		System.out.println("Press 'A' to choose animal.");
		System.out.println("Press 'B' to choose bird.");
        String num = scan.next();
        
        switch(num) {
        case ("A"):
            Ani animal = new Ani();
            animal.Animal();
           
           ArrayList<String> l1= new ArrayList<>();
           l1.add("cat");
           l1.add("cow");
           l1.add("dog");
           l1.add("goat");
           l1.add("rabbit");
           System.out.println("The animals we have");
           for(int i=0;i<l1.size();i++) {
        	   System.out.println(l1.get(i));
        	   
           }
           
           
           System.out.println("Press 'R' to input your requarements");
           System.out.println("Press 'E' to see detail information about our animal");
           String ch = scan.next();
           switch(ch) {
           case("R"):
              
        	   int i , input , input1 , input2;
               
   		
   		
   		System.out.print("Enter the number of legs. ");
           System.out.println("Number of legs must be 2 or 4"); 
       	input1 = scan.nextInt();
       	try {
       		Compute1(input1);
       	}catch(InvalidInput1Exception e) {
       		System.err.println("Exception caught: "+e);
       	}
       	
       	System.out.print("Now, firstly, you need to enter the ");
		System.out.print("number of eyes then ears. Both ");
		System.out.println("of them must be 2");
        for(i=0;i<2;i++) {
        	input = scan.nextInt();
        	try {
        		Compute(input);
        	}catch(InvalidInputException e) {
        		System.err.println("Exception caught: "+e);
        	}
        }
        System.out.print("Well, now, you need to enter the ");
		System.out.print("number of tail then nose in this sequence. Both ");
		System.out.println("of them must be 1");
        for(i=0;i<2;i++) {
        	input2 = scan.nextInt();
        	try {
        		Compute2(input2);
        	}catch(InvalidInput2Exception e) {
        		System.err.println("Exception caught: "+e);
        	}
        }
        	   break;
           case("E"):
        	   
        		   
        	   System.out.println("You chose to know the detail option!");
               System.out.println("Now, input an animal that we have to see ");
               System.out.println("it's detail and to order it:");
               String ani_name = scan.next();
               Eat animal1 = new Eat();
               Eat1 animal2 = new Eat1();
               Nature animal3 = new Nature();
               Nature1 animal4 = new Nature1();
               try {
            	  FileWriter fileWrite1 = new FileWriter("PetShopAnimal.txt"); 
                  fileWrite1.write("Customer's buying record!\n");
               switch(ani_name) {
               case("cat"):
            	   animal1.Animal();
                   
                   animal3.Animal("teeth");
                   System.out.println("It's Potty-trained");
                   System.out.println("Price: 1200$");
                   fileWrite1.write("You bought a cat worth of 1200$");
                   break;
               case("dog"):
            	   animal1.Animal();
                   animal3.Animal("teeth");
                   System.out.println("It's not Potty-trained");
                   System.out.println("Price: 1000$");
                   fileWrite1.write("You bought a dog worth of 1000$");
                   break;
               case("cow"):
                   animal2.Animal();
                   animal4.Animal();
                   System.out.println("Price: 10000$");
                   fileWrite1.write("You bought a cow worth of 10000$");
                   break;
               case("goat"):
            	   animal2.Animal();
                   animal4.Animal();
                   System.out.println("Price: 8500$");
                   fileWrite1.write("You bought a goat worth of 8500$");
                   break;
               case("rabbit"):
            	   animal2.Animal();
                   animal3.Animal("teeth");
                   System.out.println("It's not Potty-trained");
                   System.out.println("Price: 800$");
                   fileWrite1.write("You bought a rabbit worth of 800$");
                   break;   
                   default:
                	  System.out.println("We don't have this animal");
               }
               fileWrite1.close();
               }catch(IOException e) {
            	   System.out.println("An error");
            	   e.printStackTrace();
               }
               break;
               default:
            	   System.out.println("wrong input!");
            	   System.out.println("try again later");
           }
            break;
        case("B"):
        	PetBird birdP = new PetBird();
            birdP.bird();
            
            ArrayList<String> l2= new ArrayList<>();
            l2.add("dove");
            l2.add("parrot");
            l2.add("love-bird");
            l2.add("chicken");
            l2.add("duck");
            System.out.println("The birds we have");
            
            for(int i=0;i<l2.size();i++) {
         	   System.out.println(l2.get(i));
         	   
            }
            
            System.out.println("Press 'D' to see details about the bird");
            String ch1 = scan.next();
            switch(ch1) {
            case("D"):
            	System.out.println("You chose to see every details about birds");
                System.out.println("Choose a bird that we have to see it's details ");
                System.out.println("to order it:");
            	String bird_name = scan.next();
                NatureB bird1 = new NatureB();
                NatureB1 bird2 = new NatureB1();
                NatureB2 bird3 = new NatureB2();
                NatureB3 bird4= new NatureB3();
            try {
            	FileWriter myfile = new FileWriter("PetShopBird.txt");
            	myfile.write("Customer's buying record!\n");
            switch(bird_name) {
            case("dove"):
            	bird1.bird();
                System.out.println("Price: 50$");
                myfile.write("You bought a dove worth of 50$.");
            break;
            case("parrot"):
            	bird2.bird();
                System.out.println("Price:100$");
                myfile.write("You bought a parrot worth of 100$.");
            break;
            case("love-bird"):
            	bird1.bird();
                System.out.println("Price: 55$");
                myfile.write("You bought a love-bird worth of 55$.");
            break;
            case("chicken"):
            	bird3.bird();
                System.out.println("Price: 45$");
                myfile.write("You bought a chicken worth of 45$.");
            break;
            case("duck"):
            	bird4.bird();
                System.out.println("Price 60$");
                myfile.write("You bought a duck worth of 60$.");
            break;	
            default:
            	System.out.println("We don't have this bird!");
            }
            myfile.close();
            }catch(IOException e) {
            	System.out.println("An error!");
            	e.printStackTrace();
            }
            break;
            default:
            	System.out.println("wrong input!");
            	System.out.println("try again later!");
            }
            
        	break;
        	default: 
        		System.out.println("wrong character!");
        }
	}

}
