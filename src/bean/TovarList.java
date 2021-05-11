package bean;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.vo.Tovar;

public class TovarList {
	protected List<Tovar> data = new ArrayList<Tovar>();

	public TovarList() {
	}

	public TovarList(List<Tovar> data) {
		this.data = data;
	}

	public TovarList getTovarPriceBeetween(int start, int end) {
		TovarList res = new TovarList();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getPrice() > start & data.get(i).getPrice() < end)
				res.Add(data.get(i));
		}
		return res;
	}

	public TovarList getTovarByRAM(int RAM) {
		TovarList res = new TovarList();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getRAM() != null)
				if (data.get(i).getRAM() == RAM)
					res.Add(data.get(i));
		}
		return res;
	}

	public TovarList getTovarByCORE(int CORE) {
		TovarList res = new TovarList();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getCoresCount() != null)
				if (data.get(i).getCoresCount() == CORE)
					res.Add(data.get(i));
		}
		return res;
	}

	public TovarList getTovarByHDD(int HDD) {
		TovarList res = new TovarList();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getHDD() != null)
				if (data.get(i).getHDD() == HDD)
					res.Add(data.get(i));
		}
		return res;
	}

	public TovarList getTovarByPCType(List<String> pcType) {
		TovarList res = new TovarList();
		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < pcType.size(); j++) {
				if (data.get(i).getPctype().getId() == Long.parseLong(pcType.get(j)))
					res.Add(data.get(i));
			}
		}
		return res;
	}

	public TovarList getTovarPriceLess(int elem) {
		TovarList res = new TovarList();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getPrice() < elem)
				res.Add(data.get(i));
		}
		return res;
	}

	public TovarList getTovarPriceOver(int elem) {
		TovarList res = new TovarList();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getPrice() > elem)
				res.Add(data.get(i));
		}
		return res;
	}

	public TovarList getTovarBeetween(int start, int count) {
		TovarList res = new TovarList();
		for (int i = start; i < start + count & i < data.size(); i++) {
			res.Add(data.get(i));
		}
		return res;
	}

	public void Add(Tovar t) {
		data.add(t);
	}

	public int IndexOf(int id) {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getID() == id)
				return i;
		}
		return -1;
	}

	public Tovar get(int index) {
		return data.get(index);
	}

	public int Size() {
		return data.size();
	}
}
