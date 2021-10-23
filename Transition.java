
public class Transition {
	private int curCarry;
	private int curI;
	private int a1;
	private int a2;
	private int a3;
	private int nextCarry;
	private int nextI;
	
	public Transition(int curCarry, int curI, int a1, int a2, int a3, int nextCarry, int nextI) {
		setCurCarry(curCarry);
		setCurI(curI);
		setA1(a1);
		setA2(a2);
		setA3(a3);
		setNextCarry(nextCarry);
		setNextI(nextI);
	}
	
	public int getCurCarry() {
		return curCarry;
	}
	public void setCurCarry(int curCarry) {
		this.curCarry = curCarry;
	}
	public int getCurI() {
		return curI;
	}
	public void setCurI(int curI) {
		this.curI = curI;
	}
	public int getA1() {
		return a1;
	}
	public void setA1(int a1) {
		this.a1 = a1;
	}
	public int getA2() {
		return a2;
	}
	public void setA2(int a2) {
		this.a2 = a2;
	}
	public int getA3() {
		return a3;
	}
	public void setA3(int a3) {
		this.a3 = a3;
	}
	public int getNextCarry() {
		return nextCarry;
	}
	public void setNextCarry(int nextCarry) {
		this.nextCarry = nextCarry;
	}
	public int getNextI() {
		return nextI;
	}
	public void setNextI(int nextI) {
		this.nextI = nextI;
	}
}
