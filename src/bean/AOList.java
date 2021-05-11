package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hibernate.vo.Account;
import com.hibernate.vo.Order;

public class AOList {

	private List<OrderBean> orderData = new ArrayList<OrderBean>();
	private List<Account> accountData = new ArrayList<Account>();
	public void Add(Account account, List<Order> order)
	{
		for	(int i=0;i<order.size();i++)
		{
			orderData.add(new OrderBean(order.get(i)));
			accountData.add(account);
		}
	}
	public void Add(Account account, OrderBean order)
	{
			orderData.add(order);
			accountData.add(account);
	}
	public Account getAccount(int index)
	{
		return accountData.get(index);
	}
	public OrderBean getOrder(int index)
	{
		return orderData.get(index);
	}
	public AOList getOrderBeetween(int start, int count) {
		AOList res = new AOList();
		for (int i = start; i < start + count & i< orderData.size(); i++) {
			res.Add(accountData.get(i),orderData.get(i));
		}
		return res;
	}
	public AOList getOrderbyAccount(String Name) {
		AOList res = new AOList();
		for (int i = 0; i< orderData.size(); i++) {
			if(accountData.get(i).getLogin().indexOf(Name)>-1)
				res.Add(accountData.get(i),orderData.get(i));
		}
		return res;
	}
	public AOList getOrderDateLess(Date elem) {
		AOList res = new AOList();
		for (int i = 0; i < orderData.size(); i++) {
			if (orderData.get(i).getDateO().getTime() <= elem.getTime())
				res.Add(accountData.get(i),orderData.get(i));
		}
		return res;
	}

	public AOList getOrderDateOver(Date elem) {
		AOList res = new AOList();
		for (int i = 0; i < orderData.size(); i++) {
			if (orderData.get(i).getDateO().getTime() >= elem.getTime())
				res.Add(accountData.get(i),orderData.get(i));
		}
		return res;
	}
	public AOList getOrderPriceLess(int elem) {
		AOList res = new AOList();
		for (int i = 0; i < orderData.size(); i++) {
			if (orderData.get(i).getSum() < elem)
				res.Add(accountData.get(i),orderData.get(i));
		}
		return res;
	}

	public AOList getOrderPriceOver(int elem) {
		AOList res = new AOList();
		for (int i = 0; i < orderData.size(); i++) {
			if (orderData.get(i).getSum() > elem)
				res.Add(accountData.get(i),orderData.get(i));
		}
		return res;
	}
	public AOList getIndexOfbyID(String idOrder)
	{
		AOList res = new AOList();
		for (int i = 0; i< orderData.size(); i++) {
			String string = String.valueOf(orderData.get(i).getId());
			if(string.indexOf(idOrder)>-1)
				res.Add(accountData.get(i),orderData.get(i));
		}
		return res;
	}
	public OrderBean getOrderByID(int idOrder)
	{
			for	(int i=0;i<orderData.size();i++)
			{
				if(orderData.get(i).getId()==idOrder)
					return orderData.get(i);
			}
		return null;
	}
	public int Size()
	{
		return orderData.size();
	}
}
