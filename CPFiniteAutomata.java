import java.util.ArrayList;

public class CPFiniteAutomata {
	
	private ArrayList<Transition> transitionListM1;
	private ArrayList<Transition> transitionListM2;
	private int M1Kc;
	private int M2Kc;
	private ArrayList<CartesianProduct> cartesianProductListM;
	private ArrayList<CartesianProduct> validateTransition;
	private ArrayList<Validate> valList;
	
	public CPFiniteAutomata(ArrayList<Transition> fM1, ArrayList<Transition> fM2, int M1Kc, int M2Kc) {
		this.transitionListM1 = fM1;
		this.transitionListM2 = fM2;
		this.M1Kc = M1Kc;
		this.M2Kc = M2Kc;
		cartesianProductListM = new ArrayList<>();
		validateTransition = new ArrayList<>();
		valList = new ArrayList<>();
	}
	
	public void cpTransition() {
		int M1curCarry;
		int M1curI;
		int M1a1;
		int M1a2;
		int M1a3;
		int M1nextCarry;
		int M1nextI;
		int M2curCarry;
		int M2curI;
		int M2a1;
		int M2a2;
		int M2a3;
		int M2nextCarry;
		int M2nextI;
		CartesianProduct temp;
		
		for(int i = 0 ; i < transitionListM1.size() ; i++) {			
			for(int j = 0 ; j < transitionListM2.size(); j++) {
				M1curCarry = transitionListM1.get(i).getCurCarry();
				M1curI = transitionListM1.get(i).getCurI();		
				M1a1 = transitionListM1.get(i).getA1();
				M1a2 = transitionListM1.get(i).getA2();
				M1a3 = transitionListM1.get(i).getA3();
				M1nextCarry = transitionListM1.get(i).getNextCarry();
				M1nextI = transitionListM1.get(i).getNextI();
				
				M2curCarry = transitionListM2.get(j).getCurCarry();
				M2curI = transitionListM2.get(j).getCurI();	
				M2a1 = transitionListM2.get(j).getA1();
				M2a2 = transitionListM2.get(j).getA2();
				M2a3 = transitionListM2.get(j).getA3();
				M2nextCarry = transitionListM2.get(j).getNextCarry();
				M2nextI = transitionListM2.get(j).getNextI();
				
				if(M1a1 == M2a1 && M1a2 == M2a2 && M1a3 == M2a3) {
					temp = new CartesianProduct(M1curCarry,M1curI,M2curCarry,M2curI,M1a1,M1a2,M1a3,M1nextCarry,M1nextI,M2nextCarry,M2nextI);
					//System.out.println(M1curCarry + " " + M1curI + " " + M2curCarry + " " + M2curI + " " + M1a1 + " " + M1a2 + " " + M1a3 + " " + M1nextCarry + " " + M1nextI + " " + M2nextCarry + " " + M2nextI);
					cartesianProductListM.add(temp);
				}
			}
		}		
	}
	
	
	public void printListAll() {
		System.out.println("List of transition M: \nM1[carry,i] M2[carry,i] (a1,a2,a3) M1[carry',i'] M2[carry',i']");
		for(int i = 0 ; i < cartesianProductListM.size() ; i++) {
			System.out.println("M1[" + cartesianProductListM.get(i).getCurM1Carry() + "," + cartesianProductListM.get(i).getCurM1I() + 
					"] M2[" + cartesianProductListM.get(i).getCurM2Carry() + "," + cartesianProductListM.get(i).getCurM2I() + "] (" + 
					cartesianProductListM.get(i).getA1() + "," + cartesianProductListM.get(i).getA2() + "," + cartesianProductListM.get(i).getA3() + 
					") M1'[" + cartesianProductListM.get(i).getNextM1Carry() + "," + cartesianProductListM.get(i).getNextM1I() +
					"] M2'[" + cartesianProductListM.get(i).getNextM2Carry() + "," + cartesianProductListM.get(i).getNextM2I() + "]");
		}
	}
	
	public void printListVal() {
		System.out.println("List of validate transition M: \nM1[carry,i] M2[carry,i] (a1,a2,a3) M1[carry',i'] M2[carry',i']");
		for(int i = 0 ; i < validateTransition.size() ; i++) {
			System.out.println("M1[" + validateTransition.get(i).getCurM1Carry() + "," + validateTransition.get(i).getCurM1I() + 
					"] M2[" + validateTransition.get(i).getCurM2Carry() + "," + validateTransition.get(i).getCurM2I() + "] (" + 
					validateTransition.get(i).getA1() + "," + validateTransition.get(i).getA2() + "," + validateTransition.get(i).getA3() + 
					") M1'[" + validateTransition.get(i).getNextM1Carry() + "," + validateTransition.get(i).getNextM1I() +
					"] M2'[" + validateTransition.get(i).getNextM2Carry() + "," + validateTransition.get(i).getNextM2I() + "]");
		}
	}
	
	public void validateCheck() {
		
		Validate initVal = new Validate(0,1,0,1);
		valList.add(initVal);
		
		for(int i = 0 ; i < valList.size() ; i++) {
			validate(valList.get(i).getcurM1C(), valList.get(i).getcurM1I(), valList.get(i).getcurM2C(), valList.get(i).getcurM2I());
		}		
	}
	
	public void validate(int a, int b, int c, int d) {
		Validate temp;
		boolean check;

		for(int i = 0 ; i < cartesianProductListM.size() ; i++) {
			if (cartesianProductListM.get(i).getCurM1Carry() == a && cartesianProductListM.get(i).getCurM1I() == b &&
					cartesianProductListM.get(i).getCurM2Carry() == c && cartesianProductListM.get(i).getCurM2I() == d) {
				
				check = true;
				
				for(int j = 0 ; j < validateTransition.size() ; j++) {
					if(validateTransition.get(j).getCurM1Carry() == cartesianProductListM.get(i).getCurM1Carry() &&
							validateTransition.get(j).getCurM1I() == cartesianProductListM.get(i).getCurM1I() &&
							validateTransition.get(j).getCurM2Carry() == cartesianProductListM.get(i).getCurM2Carry() &&
							validateTransition.get(j).getCurM2I() == cartesianProductListM.get(i).getCurM2I() &&
							validateTransition.get(j).getA1() == cartesianProductListM.get(i).getA1() &&
							validateTransition.get(j).getA2() == cartesianProductListM.get(i).getA2() &&
							validateTransition.get(j).getA3() == cartesianProductListM.get(i).getA3() &&
							validateTransition.get(j).getNextM1Carry() == cartesianProductListM.get(i).getNextM1Carry() &&
							validateTransition.get(j).getNextM1I() == cartesianProductListM.get(i).getNextM1I() &&
							validateTransition.get(j).getNextM2Carry() == cartesianProductListM.get(i).getNextM2Carry() &&
							validateTransition.get(j).getNextM2I() == cartesianProductListM.get(i).getNextM2I()) {
						check = false;
					}
				}
				
				if (check == true) {
					validateTransition.add(cartesianProductListM.get(i));
					temp = new Validate(cartesianProductListM.get(i).getNextM1Carry(), cartesianProductListM.get(i).getNextM1I(), cartesianProductListM.get(i).getNextM2Carry(), cartesianProductListM.get(i).getNextM2I());
					valList.add(temp);
				}
			}
		}	
	}
		
	public void checkInitToAcpt() {
		for(int i = 0 ; i < validateTransition.size() ; i++) {
			if (validateTransition.get(i).getNextM1Carry() == 0 && validateTransition.get(i).getNextM1I() == (M1Kc+1) && 
					validateTransition.get(i).getNextM2Carry() == 0 && validateTransition.get(i).getNextM2I() == (M2Kc+1)) {
				System.out.println("\nThere is solution");
				return;
			}
		}
		System.out.println("\nThere is no solution");
	}
	
	public void findPath() {
		
	}
}