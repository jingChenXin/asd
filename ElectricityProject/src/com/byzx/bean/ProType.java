package com.byzx.bean;

import java.io.Serializable;

/**
 * 
 * @Description 商品分类
 * @author 景
 * @date 2019年4月23日 上午9:31:03
 * @version v1.0
 */
public class ProType implements Serializable {

	private static final long serialVersionUID = -8815397732357096094L;
	// 1.分类id
	private int typeId;
	// 2.分类名称
	private String typeName;
	// 3.分类父id
	private int parentId;
	// 4.分类描述
	private String typeDesc;

	public ProType() {

	}

	public ProType(int typeId, String typeName, int parentId, String typeDesc) {
		this.typeId = typeId;
		this.typeName = typeName;
		this.parentId = parentId;
		this.typeDesc = typeDesc;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

}
