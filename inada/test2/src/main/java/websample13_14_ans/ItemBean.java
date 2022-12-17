package websample13_14_ans;

import java.io.Serializable;

/**
 * Java入門 商品情報クラス.
 */
public class ItemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String itemId;		// 商品ID
	private String itemName;	// 商品名
	private int price;			// 商品価格
	private int quantity;		// 商品数
	
	/**
	 * コンストラクタ.<br>
	 * メンバ変数の値を初期化します.
	 */
	public ItemBean() {
		itemId   = "";
		itemName = "";
		price = 0;
		quantity = 0;
	}
	
	/**
	 * 商品IDを返却します.
	 * @return 商品ID
	 */
	public String getItemId() {
		return itemId;
	}
	
	/**
	 * 商品IDを設定します.
	 * @param itemId 商品ID
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	/**
	 * 商品名を返却します.
	 * @return 商品名
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * 商品名を設定します.
	 * @param itemName	商品名
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/**
	 * 商品価格を返却します.
	 * @return	商品価格
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * 商品価格を設定します.
	 * @param price	商品価格
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * 商品数を返却します.
	 * @return	商品数
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * 商品数を設定します.
	 * @param stok	商品数
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}