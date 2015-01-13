import java.util.Scanner;

public class Mod{


public static void main(String[] args){


	while(true){
	Scanner scanner = new Scanner(System.in);
	System.out.println("Mod computation enter -1 to quit");
	System.out.println("Enter number one");
	int a = scanner.nextInt();
	if(a == -1 ){
		System.exit(0);
	}
	System.out.println("Enter number two");
	int b = scanner.nextInt();
	int result = a % b;
	System.out.println("Mod = " + result);
	}

}

}
