package nc.ui.train.arriveorder.ref;

import java.awt.Container;

import nc.ui.pub.pf.BillSourceVar;
import nc.ui.pubapp.billref.src.view.SourceRefDlg;

/**
 ** ��Դ������ʾ�� ���ܣ���ѯ���ѡ������ ��д����getRefBillInfoBeanPath(), �����������������ļ�
 * 
 * @author shidl
 * 
 */

public class TR05RefTR04SourceRefDlg extends SourceRefDlg {

	public TR05RefTR04SourceRefDlg(Container parent, BillSourceVar bsVar) {
		super(parent, bsVar);
	}

	/**
	 * ���������ļ�
	 */
	@Override
	public String getRefBillInfoBeanPath() {
		return "nc/ui/train/arriveorder/ref/TR05RefTR04.xml";
	}
}
