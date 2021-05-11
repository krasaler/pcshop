package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hibernate.vo.Order;

public class OrderList {
	private List<OrderBean> data = new ArrayList<OrderBean>();

	public OrderList() {

	}

	public OrderList(List<Order> element) {
		for(Order order: element)
		{
			data.add(new OrderBean(order));
		}
	}
	public OrderList getOrderBeetween(int start, int count) {
		OrderList res = new OrderList();
		for (int i = start; i < start + count & i < data.size(); i++) {
			res.Add(data.get(i));
		}
		return res;
	}
	public OrderList getOrderDateLess(Date elem) {
		OrderList res = new OrderList();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getDateO().getTime() <= elem.getTime())
				res.Add(data.get(i));
		}
		return res;
	}

	public OrderList getOrderDateOver(Date elem) {
		OrderList res = new OrderList();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getDateO().getTime() >= elem.getTime())
				res.Add(data.get(i));
		}
		return res;
	}
	public OrderList getOrderPriceLess(int elem) {
		OrderList res = new OrderList();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getSum() < elem)
				res.Add(data.get(i));
		}
		return res;
	}

	public OrderList getOrderPriceOver(int elem) {
		OrderList res = new OrderList();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getSum() > elem)
				res.Add(data.get(i));
		}
		return res;
	}
	public void Add(OrderBean t) {
		data.add(t);
	}

	public int getSizeCart(int index) {
		return data.get(index).size();
	}

	public int Size() {
		return data.size();
	}

	public OrderBean getID(long idOrder) {
		for	(OrderBean orderBean:data)
		{
			if(orderBean.getId()==idOrder)
				return orderBean;				
		}
		return null;
	}
	public OrderBean get(int index) {
		return data.get(index);
	}

	public void Remove(int index) {
		data.remove(index);
	}
}
