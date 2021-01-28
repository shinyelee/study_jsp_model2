package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

// ��ٱ��� �׸� �˻� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class MdCartSearchService {

	public ArrayList<Cart> getCartSearchList(int start_money, int end_money, HttpServletRequest request) {
		
		// ��û�� �� Ŭ���̾�Ʈ�� ���� ��ü�� ����.
		HttpSession session = request.getSession();
		// ���� ������ �����Ǿ� �ִ� ��ٱ��� ��� ��ü�� ����.
		ArrayList<Cart> oldCartList = (ArrayList<Cart>)session.getAttribute("cartList");
		// �˻��� ��ٱ��� �׸��� ������ ���ο� ArrayList ��ü ����.
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		
		// ��ٱ��� ����� �ݺ��ϸ鼭 �˻� ������ �ش��ϴ� ��ٱ��� �׸��� ã�Ƽ� ���� ������ ArrayList ��ü�� �߰�.
		for (int i = 0; i < oldCartList.size(); i++) {
			// ��ٱ��� �׸� �� ������ �˻� ���ݿ� �ش��ϴ��� üũ.
			if(oldCartList.get(i).getPrice()>=start_money && oldCartList.get(i).getPrice()<=end_money) {
				cartList.add(oldCartList.get(i));
			}
			
		}
		
		return cartList;
	}
	
}