package websample13_14_ans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Java入門 ショッピング風処理クラス.
 */
public class Shopping {
	
	/**
	 * 商品一覧のリストを返却します.
	 * @return	商品一覧のリスト
	 */
	public ArrayList<ItemBean> getItem() {
		
		ArrayList<ItemBean> beanList = new ArrayList<ItemBean>();
		ShoppingDao dao = null;
		ResultSet rs = null;
		
		try {
			
			// DAOクラスをインスタンス化
			dao = new ShoppingDao();
			// 現在の商品一覧を検索
			rs  = dao.selectItem();
			
			// 検索結果を1レコードずつ処理
			while(rs.next()) {
				
				// 商品一覧を格納するBeanクラスをインスタンス化
				ItemBean bean = new ItemBean();
				
				// 商品IDを設定
				bean.setItemId(rs.getString("item_id"));
				// 商品名を設定
				bean.setItemName(rs.getString("item_name"));
				// 商品価格を設定
				bean.setPrice(rs.getInt("price"));
				// 商品数を設定
				bean.setQuantity(rs.getInt("quantity"));
				
				// Beanクラスをリストに追加
				beanList.add(bean);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			// 処理終了時に各接続を解除
			dao.close();
		}
		
		return beanList;
	}
	
	/**
	 * 商品IDを基に商品情報を返却します.
	 * @return	商品情報
	 */
	public ItemBean getItem(String itemId) {
		
		ItemBean bean = new ItemBean();
		ShoppingDao dao = null;
		ResultSet rs = null;
		
		try {
			
			// DAOクラスをインスタンス化
			dao = new ShoppingDao();
			// 現在の商品一覧を検索
			rs  = dao.selectItem(itemId);
			
			// 検索結果を処理
			while(rs.next()) {
				
				// 商品IDを設定
				bean.setItemId(itemId);
				// 商品名を設定
				bean.setItemName(rs.getString("item_name"));
				// 商品価格を設定
				bean.setPrice(rs.getInt("price"));
				// 商品数を設定
				bean.setQuantity(rs.getInt("quantity"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			// 処理終了時に各接続を解除
			dao.close();
		}
		
		return bean;
	}
	
	/**
	 * 購入履歴のリストを返却します.
	 * @return	購入履歴のリスト
	 */
	public ArrayList<HistoryBean> getHistory(String id) {
		
		ArrayList<HistoryBean> beanList = new ArrayList<HistoryBean>();
		ShoppingDao dao = null;
		ResultSet rs = null;
		
		try {
			
			// DAOクラスをインスタンス化
			dao = new ShoppingDao();
			// 現在の商品一覧を検索
			rs  = dao.selectHistory(id);
			
			// 検索結果を1レコードずつ処理
			while(rs.next()) {
				
				// 商品一覧を格納するBeanクラスをインスタンス化
				HistoryBean bean = new HistoryBean();
				
				// 商品IDを設定
				bean.setItemId(rs.getString("item_id"));
				// 商品名を設定
				bean.setItemName(rs.getString("item_name"));
				// 商品数を設定
				bean.setQuantity(rs.getInt("quantity"));
				
				// Beanクラスをリストに追加
				beanList.add(bean);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			// 処理終了時に各接続を解除
			dao.close();
		}
		
		return beanList;
	}
}