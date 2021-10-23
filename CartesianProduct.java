
public class CartesianProduct {
	private int curM1Carry;
	private int curM1I;
	private int curM2Carry;
	private int curM2I;
	private int a1;
	private int a2;
	private int a3;
	private int nextM1Carry;
	private int nextM1I;
	private int nextM2Carry;
	private int nextM2I;
	
	public CartesianProduct(int curM1Carry, int curM1I, int curM2Carry, int curM2I, int a1, int a2, int a3, int nextM1Carry, int nextM1I, int nextM2Carry, int nextM2I) {
		setCurM1Carry(curM1Carry);
		setCurM1I(curM1I);
		setCurM2Carry(curM2Carry);
		setCurM2I(curM2I);
		setA1(a1);
		setA2(a2);
		setA3(a3);
		setNextM1Carry(nextM1Carry);
		setNextM1I(nextM1I);
		setNextM2Carry(nextM2Carry);
		setNextM2I(nextM2I);
	}
	
	public int getCurM1Carry() {
		return curM1Carry;
	}
	public void setCurM1Carry(int curM1Carry) {
		this.curM1Carry = curM1Carry;
	}
	public int getCurM1I() {
		return curM1I;
	}
	public void setCurM1I(int curM1I) {
		this.curM1I = curM1I;
	}
	
	public int getCurM2Carry() {
		return curM2Carry;
	}
	public void setCurM2Carry(int curM2Carry) {
		this.curM2Carry = curM2Carry;
	}
	public int getCurM2I() {
		return curM2I;
	}
	public void setCurM2I(int curM2I) {
		this.curM2I = curM2I;
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
	
	public int getNextM1Carry() {
		return nextM1Carry;
	}
	public void setNextM1Carry(int nextM1Carry) {
		this.nextM1Carry = nextM1Carry;
	}
	public int getNextM1I() {
		return nextM1I;
	}
	public void setNextM1I(int nextM1I) {
		this.nextM1I = nextM1I;
	}
	
	public int getNextM2Carry() {
		return nextM2Carry;
	}
	public void setNextM2Carry(int nextM2Carry) {
		this.nextM2Carry = nextM2Carry;
	}
	public int getNextM2I() {
		return nextM2I;
	}
	public void setNextM2I(int nextM2I) {
		this.nextM2I = nextM2I;
	}
}