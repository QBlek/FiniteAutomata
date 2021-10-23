import java.util.ArrayList;
import java.util.LinkedList;

public class FiniteAutomata {

	private int C1;
	private int C2;
	private int C3;
	private int C;
	private int Cmax;
	private String C_bin;
	private int Kc;
	
	private ArrayList<InputSymbol> inputList;
	private ArrayList<State> stateList;
	private ArrayList<Transition> transitionList;
	private State curState;
	
	public FiniteAutomata(int c1, int c2, int c3, int c) {
		setEquation(c1,c2,c3,c);
		setCmax();
		setKc();
		printInformation();
		generateFA();
	}
	
	//Preparation******************
	
	public void setEquation(int c1, int c2, int c3, int c) {
		if(c >= 0) {
			this.C1 = c1;
			this.C2 = c2;
			this.C3 = c3;
			this.C = c;					
		} else {
			this.C1 = -c1;
			this.C2 = -c2;
			this.C3 = -c3;
			this.C = -c;		
		}	
	}
	
	public void setCmax() {
		int i = 0, j = 0, k = 0, l = 0;
		int tempcmax = 0;
		int temp = 0;
		
		while(i+j+k+l < 4) {			
			
			if(i == 0) {
				i++;
			} else {
				if(j == 0) {
					i--;
					j++;
				} else {
					if(k == 0) {
						i--;
						j--;
						k++;
					} else {
						i--;
						j--;
						k--;
						l++;
					}
				}
			}
			
			temp = Math.abs((C1*i) + (C2*j) + (C3*k) + l);
			
			if(temp > tempcmax) {
				tempcmax = temp;
			}			
		}
		
		Cmax = tempcmax;
	}
	
	public void setKc() {
		C_bin = Integer.toBinaryString(C);
		Kc = C_bin.length();
	}
	
	public int getBi(int i) {
		int R = 0;
		if(i <= Kc) {
			R = Character.getNumericValue(C_bin.charAt(Kc-i));
		}		
		return R;
	}
	
	public void printInformation() {
		//System.out.println(C1 + "x1 + " + C2 + "x2 + " + C3 + "x3 + " + C + "\n");
		System.out.println("Value of Cmax: " + Cmax);
		System.out.println("Binary of Constant: " + C_bin);
		System.out.println("Value of Kc: " + Kc);
				
		for(int i = Kc +1 ; i > 0 ; i--) {
			System.out.print("b" + i +": " + getBi(i) + "  ");
		}
		System.out.println("\n");
	}
	
	public void checkState() {
		System.out.println("List of state [carry,i]");
		for(int i = 0 ; i < stateList.size() ; i++) {
			System.out.println("[" + stateList.get(i).getCarry() + "," + stateList.get(i).getI() + "]");
		}
		System.out.println();
	}
	
	public void checkTransition() {
		System.out.println("List of transition: \n[carry,i] (a1,a2,a3) [carry',i']");
		for(int i = 0 ; i < transitionList.size() ; i++) {
			System.out.println("[" + transitionList.get(i).getCurCarry() + "," + transitionList.get(i).getCurI() + "] (" + 
			transitionList.get(i).getA1() + "," + transitionList.get(i).getA2() + "," + transitionList.get(i).getA3() + ") [" + 
			transitionList.get(i).getNextCarry() + "," + transitionList.get(i).getNextI() + "]");
		}		
	}
	
	//Algorithm1****************
	
	public void runM() {
		for(int j = 0 ; j < stateList.size() ; j++) {
			findAdjVertex(stateList.get(j));
		}
	}
	
	private void findAdjVertex(State curState) {
		int a1;
		int a2;
		int a3;
		int R;
		State temp = curState;
		State newState;
		Transition newTransition;
		boolean check = false;
		
		for(int i = 1 ; i < 9 ; i++) {
			a1 =inputList.get(i-1).getA1();
			a2 =inputList.get(i-1).getA2();
			a3 =inputList.get(i-1).getA3();
			check = true;
						
			R = (C1*a1) + (C2*a2) + (C3*a3) + getBi(temp.getI()) + temp.getCarry();			
						
			for(int j = 0 ; j < stateList.size() ; j++) {
				if(stateList.get(j).getCarry() == R/2 && stateList.get(j).getI() == temp.getI()+1) {
					check = false;
				}
			}
			
			if(R%2 != 0) {
				check = false;
			} else {
				if(temp.getI() < Kc+1) {
					newTransition = new Transition(temp.getCarry(), temp.getI(), a1, a2, a3, R/2,temp.getI()+1);
					transitionList.add(newTransition);
				} else {
					newTransition = new Transition(temp.getCarry(), temp.getI(), a1, a2, a3, R/2,temp.getI());
					transitionList.add(newTransition);
				}			
			}
			
			
			if(temp.getCarry() == 0 && temp.getI() == Kc+1) {
				check = false;
			}
			
			if(R/2 < -Cmax && R/2 > Cmax) {
				check = false;
			}
									
			if(check == true) {
				if(temp.getI() < Kc+1) {
					newState = new State(R/2,temp.getI()+1);
					stateList.add(newState);
				}
			}			
		}		
	}
		
	private void generateFA() {
		inputList = new ArrayList<>();
		stateList = new ArrayList<>();
		transitionList = new ArrayList<>();
		curState = new State(0,1);
		stateList.add(curState);
				
		int i = 0, j = 0, k = 0, l = 0;
		InputSymbol genInput;
		
		while(l < 1) {			
			
			if(i == 0) {
				i++;
			} else {
				if(j == 0) {
					i--;
					j++;
				} else {
					if(k == 0) {
						i--;
						j--;
						k++;
					} else {
						i--;
						j--;
						k--;
						l++;
					}
				}
			}
			genInput = new InputSymbol(i,j,k);
			inputList.add(genInput);
		}
	}
	
	public ArrayList<Transition> getTransList() {
		return transitionList;
	}
	
	public int getKc() {
		return Kc;
	}
}
