package com.byzx.bean;

import java.io.Serializable;

/**
 * 
 * @Description ��Ʒ����
 * @author ��
 * @date 2019��4��23�� ����9:31:03
 * @version v1.0
 */
public class ProType implements Serializable {

	private static final long serialVersionUID = -8815397732357096094L;
	// 1.����id
	private int typeId;
	// 2.��������
	private String typeName;
	// 3.���ุid
	private int parentId;
	// 4.��������
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
