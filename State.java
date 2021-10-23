
public class State {
	
	private int carry;
	private int i;
	
	public State(int carry, int i) {
		setCarry(carry);
		setI(i);
	}

	public int getCarry() {
		return carry;
	}

	public void setCarry(int carry) {
		this.carry = carry;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
