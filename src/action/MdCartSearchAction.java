package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.MdCartSearchService;
import vo.ActionForward;
import vo.Cart;

public class MdCartSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// �������� ��ٱ��� �׸��� �˻��ϴ� ����Ͻ� ������ �����Ǿ� �ִ� ���� ��ü�� ����.
		MdCartSearchService mdCartSearchService = new MdCartSearchService();
		// �˻��� ���� ���� �ݾװ� ������ �ݾ��� �Ķ���ͷ� ����.
		int startMoney = Integer.parseInt(request.getParameter("startMoney"));
		int endMoney = Integer.parseInt(request.getParameter("endMoney"));
		// ���� �ݾװ� ������ �ݾ� ���̿� �����ϴ� �ݾ��� ������ �ִ� ��ǰ�� ��ٱ��� �׸��� �˻��ϴ� �޼ҵ带 ȣ��.
		ArrayList<Cart> cartList = mdCartSearchService.getCartSearchList(startMoney,endMoney,request);
		// �˻��� ��ٱ��� �׸��� request ������ �Ӽ����� ����.
		request.setAttribute("cartList", cartList);
		// �˻��� ���� ���� �ݾ��� request ������ �Ӽ����� ����.
		request.setAttribute("startMoney", startMoney);
		// �˻��� ���� ������ �ݾ��� request ������ �Ӽ����� ����.
		request.setAttribute("endMoney", endMoney);
		
		int totalMoney = 0;
		int money = 0 ;
		
		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice()*cartList.get(i).getQty();
			totalMoney += money;
		}

		request.setAttribute("totalMoney", totalMoney);
		// ������ ������ ActionForward ��ü�� ����.
		// �������� �������� GoodsList.jsp �������� ���������� ������ ����� ����ġ ������� ó���ϱ� ���� false�� ����.
		ActionForward forward = new ActionForward("mdCartList.jsp", false);
		
		return forward;
	}
	
}