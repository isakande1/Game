
import java.util.*;
import java.io.*;
public class Bank1 {
	static int []withdra;
	static int countD;
	static Scanner Console = new Scanner(System.in);
	 static int [] ID;
	 static String [] name;
	 static int [] password;
    static int[] deposit;
	static File fi;
	static ArrayList<Integer> sum = new ArrayList<>();
   static int [] IDs;
   static String [] names;
	static int [] passwords;
	static ArrayList<Integer> totals;
	static int [] withdras;
	 static int[] deposits;
	 static ArrayList<Integer> sums = new ArrayList<>();
////////////////////////////////////////////////////////////////////
public static void main(String[]args) throws  IOException{
	ID = new int[1];
	 name= new String[1];
	 password = new int [1];
	 deposit = new int [1];
	 withdra = new int[1];
	 choice();

	
}
/////////////////////////////////////////////////////////////////////////////
/*public static void add() {
	int j=0;
	System.out.println(" Enter index: ");
	int index = Console.nextInt();
	Sindex= index;
	System.out.println(" Enter name: ");
	String name1= Console.next();
	System.out.println(" Enter ID: ");
	int ID1 = Console.nextInt();
	System.out.println(" Enter password: ");
	int password1 = Console.nextInt();
	//System.out.println(Arrays.toString(name));
if(name[0]==null ) {
	name[0]=name1;
	//System.out.println(name1);
	password[0]= password1;
	ID[0]= ID1;
}else {
String []Sname= new String[(name.length+1)];
int [] SID = new int[(ID.length+1)];
int[] Spassword = new int [(password.length+1)];
for (int i=0; i <name.length; i++) {
	if(i == index ) {
		Sname[index]= name1;
		Spassword[index]= password1;
		SID[index] = ID1;
		j++;
	}
	Sname[(i+j)] = name[i];
	Spassword[(i+j)]= password[i];
	SID[(i+j)]= ID[i];
	
}
name = Sname;
password = Spassword;
ID = SID;


}
System.out.println(Arrays.toString(name));
}*/
public static void add() {
	int j=0;
	System.out.println(" Enter name: ");
	String name1= Console.next();
	System.out.println(" Enter ID: ");
	int ID1 = Console.nextInt();
	System.out.println(" Enter password: ");
	int password1 = Console.nextInt();
if(name[0]==null ) {
	name[0]=name1;
	password[0]= password1;
	ID[0]= ID1;
	withdra[0] = 0; 
}else {
String []Sname= new String[(name.length+1)];
int [] SID = new int[(ID.length+1)];
int[] Spassword = new int [(password.length+1)];
int [] Swithdra= new int [(withdra.length+1)];
for(int i=0; i<name.length;i++) {
	Sname[i] = name[i];
	Spassword[i]= password[i];
	SID[i]= ID[i];
	Swithdra[i]= withdra[i];
}
Sname[name.length]= name1;
Spassword[name.length]= password1;
SID[name.length] = ID1;
name = Sname;
password = Spassword;
ID = SID;
withdra = Swithdra;
}
}

////////////////////////////////////////////////////////////////////////////////////
public static void adddeposit() {
System.out.println("Enter deposit");
int deposit1 = Console.nextInt();
if(deposit[0]==0) {
	 deposit[0]= deposit1;
}else {
int[] Sdeposit= new int[deposit.length+1];

for (int i=0; i<deposit.length;i++) {
	Sdeposit[i]= deposit[i];
}
Sdeposit[deposit.length]= deposit1;
deposit = Sdeposit;

}

}
//////////////////////////////////////////////////////////////////////////////////////////////
public static void holder() {
	System.out.print("Account No|  Names   |   ID    |  Password |");
	for (int i = 0; i< countD; i++) {
		System.out.printf("%s %d %s","Deposit",(i+1),"|");
		//System.out.print("Deposit"+(i+1)+"|");
	}
	System.out.println("withdraw | Balance ");
}
//////////////////////////////////////////////////////////////////////////////////////////////
public static void choice() throws IOException {
	int option =0;
	do {
		System.out.println("Menu");
		System.out.println("Enter 1 to add a new account");
		System.out.println("Enter 2 withdraw money");
		System.out.println("Enter 3 to delete an account");
		System.out.println("Enter 4 to modify an account ID");
		System.out.println("Enter 5 to modify  an account name");
		System.out.println("Enter 6 to modify an account password");
		System.out.println("Enter 7 to sort by ID");
		System.out.println("Enter 8 to sort by Name");
		System.out.println("Enter 9 to search by ID");
		System.out.println("Enter 10 to create a file");
		System.out.println("Enter 11 to delete");
		System.out.println();
		option = Console.nextInt();
		
		switch(option){
		case 1:
			add();
			countD=0;
			//holder();
			//displayAll(name,ID,password,deposit,withdra, sum);
			int option2 = 0;
			
			do {
				
			System.out.println("Enter 1 to add a new deposit and 2 to exit");
			option2= Console.nextInt();
			switch(option2) {
			case 1:
			countD++;
			adddeposit();
			//holder();
			//displayAll(name,ID,password,deposit,withdra,sum);
			break;
			}}
			while(option2== 1);
			holder();
			displayAll(name,ID,password,deposit,withdra,sum);
			break;
		case 2:
		withdraw();
		holder();
		displayAll(name,ID,password,deposit,withdra,sum);
		break;
		case 3:
		delete();
		holder();
		displayAll(name,ID,password,deposit,withdra,sum);
		break;
		case 4:
		modifyId();
		holder();
		displayAll(name,ID,password,deposit,withdra,sum);
		break;
		case 5:
		modifyName();
		holder();
		displayAll(name,ID,password,deposit,withdra,sum);
		break;
		case 6:
		modifyPassword();
		holder();
		displayAll(name,ID,password,deposit,withdra,sum);
		break;
		case 7:
		bublesortID();
		holder();
		displayAll(name,ID,password,deposit,withdra,sum);
		break;
		case 8:
		bublesortName();
		holder();
		displayAll(name,ID,password,deposit,withdra,sum);
		break;
		case 9 :
		displaySearch();
		break;
		case 10:
		file();
		copyfile(names,IDs,passwords,deposits,totals,withdras);
		//System.out.print(names[0]);
		//displayAll(names,IDs,passwords,deposits,withdras,totals);
					
			}}while(option != 11);
					
}	

//////////////////////////////////////////////////////////////////////////////////////////////////
/*public static void display() {
	//System.out.println(Arrays.toString(name));
	int j=0;
	for(int i=0; i< (name.length-1); i++) {
		j++;
		System.out.printf(("%5S %8d %12d  \n") ,name[i], ID[i], password[i]);
	}
	if(name.length==1) {
		System.out.printf(("%5S %8d %12d ") ,name[0], ID[0], password[0]); 
	}else {
	System.out.printf(("%5S %8d %12d \n ") ,name[(j)], ID[(j)], password[(j)]);
	}
}
*/
public static void displayAll(String []name, int[]ID, int[]password,int[] deposit, int []withdra, ArrayList sum) {
	int f=0;
	int count=0;
	for(int i=0; i< (name.length-1); i++) {
		int total1=0;
		f++;
		System.out.printf(("%5S %11S %10d %12d  ") , (i+1), name[i], ID[i], password[i]);
		if(i>1) {
	    	count+= count;
	    }
	for(int j =0; j< countD; j++) {
		System.out.printf("%8d %S %S",deposit[(j+count)],"$", "");
		total1+=deposit[(j+count)];
		sum.add(total1);

		}
	System.out.printf("%10d", withdra[i]);

	System.out.printf(" %8d %S \n",(total1 -withdra[i]),"$");
	count = countD;
	System.out.println();
	}
	if(name.length==1) {
		System.out.printf(("%5S %11S %10d %12d ") ,(1),name[0], ID[0], password[0]); 
		displayD(name,ID,password,deposit,withdra,sum);
	}else {
		int total=0;
	System.out.printf(("%5S %11S %10d %12d  ") ,(f+1),name[(f)], ID[(f)], password[(f)]);
	
	if(name.length>2) {
		count+=count;
	}
	for(int j =0; j< countD; j++) {
		System.out.printf("%8d %S %S",deposit[(j+count)],"$", "");
		 total+=deposit[(j+count)];
		 sum.add(total);
		}
	System.out.printf("%10d", withdra[f]);

	System.out.printf(" %8d %S \n",(total -withdra[f]),"$");
	System.out.println();
	}

}
//////////////////////////////////////////////////////////////////////////////////////////

public static void displayD(String []name, int[]ID, int[]password,int[] deposit, int []withdra, ArrayList sum) {

	int count=0;
	int total2=0;
	for(int i =0; i<( name.length);i++) {
		    
		    if(i>1) {
		    	count+= count;
		    }
		for(int j =0; j< countD; j++) {
			System.out.printf("%8d %S %S",deposit[(j+count)],"$", "");
			total2+=deposit[(j+count)];
			sum.add(total2);

			}
		System.out.printf("%10d", withdra[0]);

		count = countD;
		System.out.printf(" %8d %S \n",(total2 -withdra[0]),"$");
}
	}
///////////////////////////////////////////////////////////////////////
public static void withdraw() {
	System.out.print(" Enter the ID of the account to withdraw:");
	int index = Console.nextInt();
	System.out.print(" Enter the amount to  withdraw:");
	int i =0;
	while(ID[i] != index) {
		i++;
		
	}
	int amount = Console.nextInt();
	withdra[i]=amount;
}

public static void delete() {
	int d =0;
	System.out.print("Enter the index of the account to delete");
	int index = Console.nextInt();
	int[] Sdeposit= new int[deposit.length-countD];
	String []Sname= new String[(name.length-1)];
	int [] SID = new int[(ID.length-1)];
	int[] Spassword = new int [(password.length-1)];
	int [] Swithdra= new int [(withdra.length-1)];
	for(int i=0; i<(Sname.length*countD); i++) {
		 if (i== (index-1)) {
		    	d=countD;
		    }
		 Sdeposit[i]= deposit[i+d];
	}
	for (int i = 0,j=0; i<Sname.length; i++ ) {
	    if (i== (index-1)) {
	    	++j;
	    	d=countD;
	    }
	    Sname[i] = name[(i+j)];
		Spassword[i]= password[(i+j)];
		SID[i]= ID[(i+j)];
		Swithdra[i]= withdra[(i+j)];
		
	}
	deposit= Sdeposit;
	name = Sname;
	password = Spassword;
	ID = SID;
	withdra = Swithdra;
}
public static void modifyId() {
	System.out.print(" Enter the ID of the account to modify:");
	int index = Console.nextInt();
	System.out.print(" Enter the new ID:");
	int i =0;
	while(ID[i] != index) {
		i++;
		
	}
	int newID = Console.nextInt();
	ID[i]= newID ;
}
public static void modifyName() {
	System.out.print(" Enter the ID of the account to modify:");
	int index = Console.nextInt();
	System.out.print(" Enter the new name:");
	int i =0;
	while(ID[i] != index) {
		i++;
		
	}
	String newName = Console.next();
	name[i]= newName ;
}

public static void modifyPassword() {
	System.out.print(" Enter the ID of the account to modify:");
	int index = Console.nextInt();
	System.out.print(" Enter the new password:");
	int i =0;
	while(ID[i] != index) {
		i++;
		
	}
	int newPassword = Console.nextInt();
	password[i]= newPassword ;
}	


public static void bublesortID( ) {
	for(int i = 0; i< ID.length - 1; i++) {
		int d=0;
		for(int j=0; j< (ID.length- 1-i); j++) {
			
			if(ID[j]>ID[j+1]) {
				for (int f=0; f<countD; f++) {
					int tempD = deposit[(d+f)];
					deposit[(d+f)]=deposit[(d+countD+f)];
					deposit[(d+countD+f)]=tempD;
				
				}
				
				int tempW= withdra[j];
				int tempP= password[j];
				String tempN = name[j];
				int tempI = ID[j];
				withdra[j]=withdra[j+1];
				ID[j]=ID[j+1];
				password[j]=password[j+1];																		
				name[j]=name[j+1];
				ID[j+1]=tempI;
				name[j+1]=tempN;
				password[j+1]= tempP;
				withdra[j+1]= tempW;
				
			}
			d=countD;
			if(j>1) {
			d++;
			}
		}
		
	}
		//System.out.println(Arrays.toString(deposit));
	
}

public static void bublesortName( ) {
	//System.out.println(Arrays.toString(deposit));
	for(int i = 0; i< ID.length - 1; i++) {
		int d=0;
		for(int j=0; j< (ID.length- 1-i); j++) {
			
			if(name[j].compareTo(name[j+1])>0) {
				for (int f=0; f<countD; f++) {
					int tempD = deposit[(d+f)];
					deposit[(d+f)]=deposit[(d+countD+f)];
					deposit[(d+countD+f)]=tempD;
				
				}
				int tempW= withdra[j];
				int tempP= password[j];
				String tempN = name[j];
				int tempI = ID[j];
				withdra[j]=withdra[j+1];
				ID[j]=ID[j+1];
				password[j]=password[j+1];																		
				name[j]=name[j+1];
				ID[j+1]=tempI;
				name[j+1]=tempN;
				password[j+1]= tempP;
				withdra[j+1]= tempW;
				
			}
			d=countD;
			if(j>1) {
			d++;
			}
		}
		
	}
	//System.out.println(Arrays.toString(deposit));
	
}

public static  int Binsearch( ) {
	bublesortID();
	System.out.print("Enter the ID of the account to search: ");
	int key = Console.nextInt();
	int low = 0;
	int high = ID.length-1;
	while(low <= high) {
		int mid =(low + high)/2;
	if( key == ID[mid]) {
		return mid;
	}else if (key < ID[mid]) {
		high = mid -1;
	}else if(key > ID[mid]) {
		low = mid +1;
	}
		
	}
	return -1;
}

public static void displaySearch() {
	int search = Binsearch();
	holder();
	int total2=0;
	System.out.printf(("%5S %11S %10d %12d  ") , (search+1), name[search], ID[search], password[search]);
	for(int j = 0; j< countD; j++) {
		System.out.printf("%d %S %S",deposit[(j+search)],"$", "");
		total2+=deposit[(j+search)];
		}
	System.out.printf("%9d",withdra[search]);
	System.out.printf(" %8d %S \n",(total2 -withdra[search]),"$");
}

public static void file() throws FileNotFoundException {
	
	System.out.println("Name the file: ");
	String nam = Console.next();
	 fi = new File(nam+(".txt"));
	PrintStream t = new PrintStream(fi);
	t.println(countD);
	t.println(name.length);
	t.println();
	for(int i=0; i< name.length; i++) {
		t.print( name[i]+" ");
		}
	t.println();
	for(int i=0; i< name.length; i++) {
		t.print(password[i]+" ");
		}
	t.println();
	for(int i=0; i< name.length; i++) {
		t.print(ID[i]+" ");
		}
	t.println();
	for(int i=0; i< countD*name.length; i++) {
		t.print(deposit[i]+" ");
		}
	t.println();
	for(int i=0; i< name.length; i++) {
		t.print(withdra[i]+" ");
		}
	t.println();
	for(int i=0; i< name.length; i++) {
		t.print(sum.get(i)+" ");
		}

}

public static void copyfile(String[] names, int[] IDs, int[] passwords,int [] deposits,ArrayList totals, int [] withdras) throws IOException{
	int size =0;
	Scanner console = new Scanner(fi);
	int count= console.nextInt();
	size = console.nextInt();
	names = new String[size];
	passwords = new int[size];
	withdras = new int[size];
	deposits = new int[size*count];
	IDs = new int[size];
	totals = new ArrayList<>();
	for(int i=0; i<size;i++) {
		names[i] = console.next();
	}
	for(int i=0; i<size;i++) {
		passwords[i] = console.nextInt();
	}
	for(int i=0; i<size;i++) {
		IDs[i] = console.nextInt();
	}
	for(int i=0; i<countD*size;i++) {
		deposits[i] = console.nextInt();
	}
	for(int i=0; i<size;i++) {
		withdras[i] = console.nextInt();
	}
	for(int i=0; i<size;i++) {
		 totals.add(console.nextInt());
	}
	holder();
	displayAll(names,IDs,passwords,deposits,withdras,totals);
}
}






