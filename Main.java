
public class Main {

	public static void main(String[] args) {
		
		System.out.println("*****Test1*****\n");
		
		System.out.println("***** FiniteAutomata M1 Info *****");
		FiniteAutomata M1 = new FiniteAutomata(3, -2, 1, 5);
		M1.runM();
		//M1.checkState();  //set of M1's State
		//M1.checkTransition();  //set of M1's Transition		
		
		System.out.println();
		
		System.out.println("***** FiniteAutomata M2 Info *****");
		FiniteAutomata M2 = new FiniteAutomata(6, -4, 2, 9);
		M2.runM();
		//M2.checkState();  //set of M2's State
		//M2.checkTransition();  //set of M2's Transition
		
		
		System.out.println("\n***** CartesianProduct M Info *****");
		CPFiniteAutomata M = new CPFiniteAutomata(M1.getTransList(), M2.getTransList(), M1.getKc(), M2.getKc());
		M.cpTransition();
		M.validateCheck();
		//M.printListAll();  //All transition set of M
		M.printListVal();  //Validate transition set of M
		
		M.checkInitToAcpt();  //check weather there is solution or not
		
		///////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("\n\n\n*****Test2*****\n");
		
		System.out.println("***** FiniteAutomata M1 Info *****");
		FiniteAutomata M3 = new FiniteAutomata(3, -2, -1, 3);
		M3.runM();
		//M3.checkState();  //set of M3's State
		//M3.checkTransition();  //set of M3's Transition		
		
		System.out.println();
		
		System.out.println("***** FiniteAutomata M2 Info *****");
		FiniteAutomata M4 = new FiniteAutomata(6, -4, 1, 3);
		M4.runM();
		//M4.checkState();  //set of M4's State
		//M4.checkTransition();  //set of M4's Transition
		
		
		System.out.println("\n***** CartesianProduct M Info *****");
		CPFiniteAutomata Me = new CPFiniteAutomata(M3.getTransList(), M4.getTransList(), M3.getKc(), M4.getKc());
		Me.cpTransition();
		Me.validateCheck();
		//Me.printListAll();  //All transition set of M
		Me.printListVal();  //Validate transition set of M
		
		Me.checkInitToAcpt();  //check weather there is solution or not
		
		//System.out.println("\n\n*****I wasn't able to implement DFS for find path because of time *****\n");
	}

}
