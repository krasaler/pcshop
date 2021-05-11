package bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hibernate.vo.Order;
import com.hibernate.vo.Status;
import com.hibernate.vo.Tovar;

public class OrderBean {
	private long id;

	private CartList cartList;
	private Date date;
	public String address; 
	private Status status;
	public Status getStatus() {
		return status;
	}
	public OrderBean(CartList cartList,Date date, String address) {
		super();
		this.cartList = cartList;
		this.date = date;
		this.address = address;
	}
	public OrderBean(Order order)
	{
		id= order.getId();
		cartList = new CartList();
		date = order.getDate();
		address = order.getAdress();
		status = order.getStatus();
		List<Tovar> data = order.getTovars();
		for	(Tovar tovar:data){
			cartList.Add(tovar);
		}
	}
	public long getId() {
		return id;
	}
	public CartList getCartList() {
		return cartList;
	}
	public int getSum()
	{
		return cartList.getSum();
	}
	public int getSum(int index)
	{
		return cartList.getSum(index);
	}
	public Date getDateO() {
		return date;
	}
	public String getDate() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	public String getAddress()
	{
		return address;
	}
	public int size()
	{
		return cartList.Size();
	}
	public int getCounts(int index)
	{
		return cartList.getCounts(index);
	}
	public Tovar get(int index) {
		return cartList.get(index);
	}
}
