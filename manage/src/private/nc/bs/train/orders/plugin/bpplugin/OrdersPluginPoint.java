package nc.bs.train.orders.plugin.bpplugin;

import nc.impl.pubapp.pattern.rule.plugin.IPluginPoint;

/**
 * ��׼���ݵ���չ�����
 * 
 */
public enum OrdersPluginPoint implements IPluginPoint {
	/**
	 * ����
	 */
	APPROVE,
	/**
	 * ����
	 */
	SEND_APPROVE,

	/**
	 * ȡ�����
	 */
	UNAPPROVE,

	/**
	 * �ջ�
	 */
	UNSEND_APPROVE,
	/**
	 * ɾ��
	 */
	DELETE,
	/**
	 * ����
	 */
	INSERT,
	/**
	 * ����
	 */
	UPDATE,
	/**
	 * �ű�ɾ��
	 */
	SCRIPT_DELETE,
	/**
	 * �ű�����
	 */
	SCRIPT_INSERT,
	/**
	 * �ű�����
	 */
	SCRIPT_UPDATE;

	@Override
	public String getComponent() {
		return "manage";
	}

	@Override
	public String getModule() {
		return "train";
	}

	@Override
	public String getPoint() {
		return this.getClass().getName() + "." + this.name();
	}

}