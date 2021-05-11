package bean;

import java.util.*;

import com.hibernate.vo.Tovar;

public class CartList {
	private List<Tovar> data = new ArrayList<Tovar>();
	private List<Integer> counts = new ArrayList<Integer>();
	public int IndexOf(int id) {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getID() == id) {
				return i;
			}
		}
		return -1;
	}

	public int getCounts(int index) {
		return counts.get(index).intValue();
	}
	public void setCounts(int index, int value)
	{
		counts.set(index, value);
	}
	public void Add(Tovar t) {
		for (int i = 0; i < data.size(); i++) {
			if (t.getID() == data.get(i).getID()) {
				counts.set(i, counts.get(i).intValue()+1);
				return;
			}
		}
		counts.add(1);
		data.add(t);
	}

	public int Size() {
		return data.size();
	}

	public void Remove(int index) {
		data.remove(index);
		counts.remove(index);
	}

	public Tovar get(int index) {
		return data.get(index);
	}
	public int getSum(int index) {
		return data.get(index).getPrice()*counts.get(index).intValue();
	}
	public int getSum() {
		int sum = 0;
		for (int i = 0; i < data.size(); i++) {
			sum += data.get(i).getPrice()*counts.get(i).intValue();
		}
		return sum;
	}

}
