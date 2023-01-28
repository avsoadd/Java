package websample13_14_ans;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Java入門 商品一覧ページ処理クラス.
 */
@WebServlet("/ShoppingServlet_ans")
public class ShoppingServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
      
	/**
	 * コンストラクタ.
	 */
    public ShoppingServlet() {
        super();
    }
    
    /**
     * POSTメソッドで呼び出された場合の処理.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 商品一覧を取得
		Shopping shopping = new Shopping();
		ArrayList<ItemBean> itemList = shopping.getItem();
		
		// 商品一覧をリクエストスコープの属性にセット
		request.setAttribute("itemList", itemList);
		
		// 商品一覧画面に移動
		RequestDispatcher rd = request.getRequestDispatcher("./WEB-sample13_14_ans/itemList.jsp");
		rd.forward(request, response);
	}	
}