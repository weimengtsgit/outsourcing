/**
 * 
 */
package com.company.model;

import java.util.ArrayList;
import java.util.List;

import com.company.entity.Goods;
import com.company.entity.Order;
import com.company.entity.OrderDetail;

/**
 * @author czz
 *
 */
public class OrderDetailPageModel {
	// 客户姓名
	private String name;

	// 客户电话
	private String tel;

	// 客户邮件
	private String email;

	// 订单地址
	private String adress;

	// 客户备注
	private String comment;

	// 商品列表
	private List<GoodsListPageModel> goodsList;

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            要设置的 tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            要设置的 email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * @param adress
	 *            要设置的 adress
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            要设置的 comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return goodsList
	 */
	public List<GoodsListPageModel> getGoodsList() {
		return goodsList;
	}

	/**
	 * @param goodsList
	 *            要设置的 goodsList
	 */
	public void setGoodsList(List<GoodsListPageModel> goodsList) {
		this.goodsList = goodsList;
	}

	public static OrderDetailPageModel convertToDetail(List<OrderDetail> list) {
		OrderDetailPageModel model = new OrderDetailPageModel();
		if (null != list && list.size() > 0) {
			Order order = list.get(0).getOrder();
			model.setName(order.getName());
			model.setTel(order.getTel());
			model.setEmail(order.getEmail());
			model.setAdress(order.getAdress());
			model.setComment(order.getComment());
			List<GoodsListPageModel> modelList = new ArrayList<>();
			for (OrderDetail detail : list) {
				Goods goods = detail.getGoods();
				GoodsListPageModel goodsModel = new GoodsListPageModel();
				goodsModel.setName(goods.getName());
				goodsModel.setNum(detail.getNumber());
				goodsModel.setPrice(goods.getPrice() * detail.getNumber());
				modelList.add(goodsModel);
			}
			model.setGoodsList(modelList);
		}
		return model;
	}
}
