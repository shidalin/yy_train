package nc.ui.lcm.baselink.listener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nc.bs.framework.common.NCLocator;
import nc.bs.lcm.pub.proxy.LCMPubProxy;
import nc.bs.lcm.pub.util.LcmConstant;
import nc.bs.logging.Logger;
import nc.funcnode.ui.FuncletInitData;
import nc.itf.pub.link.ILinkQueryDataPlural;
import nc.itf.pubapp.pub.smart.IBillQueryService;
import nc.itf.pubapp.pub.smart.IQueryBillService;
import nc.md.persist.framework.MDPersistenceService;
import nc.ui.lcm.pub.msg.LCMLinkData;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pub.bill.BillItem;
import nc.ui.pub.linkoperate.ILinkAddData;
import nc.ui.pub.linkoperate.ILinkApproveData;
import nc.ui.pub.linkoperate.ILinkMaintainData;
import nc.ui.pub.linkoperate.ILinkQueryData;
import nc.ui.pub.linkoperate.ILinkType;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener;
import nc.ui.pubapp.uif2app.view.ShowUpableBillForm;
import nc.ui.pubapp.uif2app.view.ShowUpableBillListView;
import nc.ui.uif2.IFuncNodeInitDataListener;
import nc.ui.uif2.UIState;
import nc.ui.uif2.components.pagination.PaginationModel;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.lcm.tbb.LcmQueryVOFactory;
import nc.vo.lcm.tbb.LcmToTbbQueryVO;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.pub.BusinessRuntimeException;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.SuperVO;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.querytemplate.queryscheme.SimpleQuerySchemeVO;
import nc.vo.tb.dailyexe.NtbLinkQueryData;
import nc.vo.tb.obj.NtbParamVO;
import nc.vo.tmpub.util.ArrayUtil;
import nc.vo.tmpub.util.SqlUtil;
import nc.vo.tmpub.util.VOUtil;

/**
 * �򿪽�������������Listener��
 * @author dangshw
 */
@SuppressWarnings("restriction")
public class DefaultInitDataListener extends DefaultFuncNodeInitDataListener implements IFuncNodeInitDataListener{
	private BillManageModel model;
	private ShowUpableBillForm editor;
	private ShowUpableBillListView listView;
    private String voClassName;
    private PaginationModel paginationModel;
    private boolean isContainBodyItems = false;   //�Ƿ��������,�޸�ǰû�д��ֶΣ�Ĭ��Ϊfalse,��ͨ�����Կ����Ƿ����������Ϣ
	@Override
	public void initData(FuncletInitData data) { 
		try {
			getModel().initModel(null);            
			// �ж������Ƿ�Ϊ��
	        if (null==data) {	        	
	            return;
	        } else { 
	        	//У��ڵ��Ƿ�༭̬
	        	nc.ui.tmpub.billlinkquery.TMLinkOpenChecker.checkOpenNode(model);
				// ȡ������
				Object dataObject = data.getInitData();

				if(dataObject instanceof LCMLinkData){
					//��ӿ�֤����
					if(doOpenProcess(data)){
						return;
					}
				}
				int initType = data.getInitType();		
				ILinkQueryData[] datas = null;
				if(dataObject != null) {
					if (dataObject instanceof SimpleQuerySchemeVO) {
						this.getQueryAction().doSimpleSchemeQuery((SimpleQuerySchemeVO) dataObject);
					} else {
						//�жϹ�����������
						switch (initType){
						case ILinkType.LINK_TYPE_ADD://����
							linkAddOperate((ILinkAddData)dataObject);
							break;
						case ILinkType.LINK_TYPE_APPROVE://����
							linkApproveOperate((ILinkApproveData)dataObject);
							break;
						case ILinkType.LINK_TYPE_MAINTAIN://ά��
							linkMaintainOperate((ILinkMaintainData)dataObject);
							break;
						case ILinkType.LINK_TYPE_QUERY://��ѯ
							if (dataObject.getClass().isArray()) {
								datas = (ILinkQueryData[]) dataObject;
								String[] pks = new String[datas.length];
								for (int i = 0; i < pks.length; i++)
									pks[i] = datas[i].getBillID();
								linkQueryOperateDatas(pks);
							} else {
								ILinkQueryData linkQryData = (ILinkQueryData) dataObject;

								if (linkQryData instanceof ILinkQueryDataPlural) {
									// ƾ֤�ϲ��������������Ҫ��ѯ����
									String[] pks = ((ILinkQueryDataPlural) linkQryData)
											.getBillIDs();
									// ��������Դ����
									linkQueryOperateDatas(pks);
								}else if(linkQryData instanceof NtbLinkQueryData){
									// Ԥ������
									doNtbQueryAction(linkQryData);
								} else {
									linkQueryOperate((ILinkQueryData) dataObject);
								}
							}
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			Logger.error(e.getMessage(),e);
			throw new BusinessRuntimeException(e.getMessage(), e);
		}
	}
	/**
	 * Ԥ������
	 * @param linkQryData
	 */
	private void doNtbQueryAction(ILinkQueryData linkQryData) {
		try {
			ArrayList<NtbParamVO> ntbParamList = (ArrayList<NtbParamVO>) linkQryData.getUserObject();
			if(ntbParamList != null && ntbParamList.size() > 0){
				NtbParamVO ntbParamVO = ntbParamList.get(0);
				LcmToTbbQueryVO queryvo = LcmQueryVOFactory.getInstance().chgToLcmQueryVO(ntbParamVO, ntbParamVO.getMethodCode());
				if (null == queryvo) {
					return ;
				}
				//ѡ���ֶ�
				StringBuilder sqlbuilder = new StringBuilder("  ");
				String fromTable = "";
		 
				//���
				String headtable = queryvo.getHeadTableName();
				fromTable = headtable + " "+ headtable;
				String bodytable = queryvo.getBodyTableName();

				//�Ƿ��б���
				boolean isHaveBody = (bodytable != null && !"".equals(bodytable.trim())) ? true : false;

		        sqlbuilder.append("  isnull(").append(headtable).append(".dr, 0) = 0 ");
				
				if (isHaveBody) {
					sqlbuilder.append(" and isnull(").append(bodytable).append(".dr, 0) = 0 ");
					sqlbuilder.append(" and ").append(queryvo.getJoinPart());
					fromTable += ", " + bodytable + " " + bodytable;
				}
				
				//��������
				if(queryvo.getBilltypecode() != null){
					sqlbuilder.append(" and ").append(headtable).append(".pk_billtypecode = '").append(queryvo.getBilltypecode()).append("'");
				}
				//���ݵĹ̶���������
				if(queryvo.getFixCondition() != null){
					sqlbuilder.append(queryvo.getFixCondition());
				}	
				
		        //����
				appendDateSql(sqlbuilder, queryvo.getDateKeyName(), queryvo.getStartdate(), queryvo.getEnddate());
				//Ԥռ������ִ����
				appendUfindOrPrefindSql(sqlbuilder, queryvo.getUfindOrPrefindPart());
				//����
				if(queryvo.getCurrtype() == LcmConstant.TBB_CurrType_Original){
					appendSql(sqlbuilder, queryvo.getCurrKeyName(), queryvo.getPk_curr());
				}
				appendSql(sqlbuilder, queryvo.getOrgKeyName(), queryvo.getPk_org());

				//ȡ��ÿ�����ݵĵ�����Ŀ����������Ŀƴ��SQL
				String[] dataitemnames = queryvo.getDataItemNames();
				if (dataitemnames != null && dataitemnames.length > 0) {
					String[] namesub = null;
					for (String attr : dataitemnames) {
						namesub = attr.split("\\" + LcmToTbbQueryVO.DISPOINT);
						if (namesub != null && namesub.length == 2) {
							Object obj = queryvo.getAttributeValue(namesub[1]);
							if(obj instanceof String[]){
								appendSql(sqlbuilder , attr, (String[])obj );
							}else {
								appendSql(sqlbuilder , attr, (String)obj );
							}
						}
					}
				}
				showTbbLinkData(fromTable, sqlbuilder.toString());
			}
		} catch (BusinessException e) {
			Logger.error(e.getMessage(), e);
		}
	}
	/**
	 * չʾ��������
	 * @param fromTable
	 * @param sql
	 * @throws BusinessException
	 */
	protected void showTbbLinkData(String fromTable, String sql) throws BusinessException {
		Class cls = null;
		try {
			cls = Class.forName(getVoClassName());
		} catch (ClassNotFoundException e) {
			throw new BusinessException(e.getMessage());
		}
		Collection<AggregatedValueObject> collection = LCMPubProxy.getMDQueryService().queryBusiVOByFromAndCond(cls, fromTable, sql, false, null);
		AggregatedValueObject[] aggVos =  null;
		if(collection != null){
			aggVos = (AggregatedValueObject[]) collection.toArray(new AggregatedValueObject[0]);

			List<String> pklist = new ArrayList<String>();
			for (AggregatedValueObject aggvo : aggVos) {
				if (!pklist.contains(aggvo.getParentVO().getPrimaryKey())) {
					pklist.add(aggvo.getParentVO().getPrimaryKey());
				}
			}
			Collection<AggregatedValueObject> result = LCMPubProxy.getMDQueryService().queryBillOfVOByPKs(cls, pklist.toArray(new String[0]), false);
			aggVos = (AggregatedValueObject[])result.toArray(new AggregatedValueObject[0]);
		}
		if (aggVos != null && aggVos.length == 1) {
			getModel().initModel(aggVos[0]);
			setPageModelPks(getModel().getData());
			getEditor().showMeUp();
		} else if (aggVos != null && aggVos.length > 1) {
			getModel().initModel(aggVos);
			setPageModelPks(getModel().getData());
			getListView().showMeUp();
		}
	}
	protected void appendUfindOrPrefindSql(StringBuilder sqlbuilder, String ufindOrPrefindPart){
		if (!StringUtil.isEmptyWithTrim(ufindOrPrefindPart)) {
			sqlbuilder.append(" and ").append(ufindOrPrefindPart);
		}
	}
	protected void appendSql(StringBuilder sqlbuilder, String name, String[] value){
		if (null == value  || value.length == 0) {
			return ;
		} else if (value.length == 0) {
			sqlbuilder.append(" and ").append(name).append(" = '").append(value).append("'");
		} else {			
			sqlbuilder.append(" and ").append(SqlUtil.buildSqlForIn(name, value));
		}
	}
	protected void appendDateSql(StringBuilder sqlbuilder, String datekeyname, String startdate, String enddate) {
		if(!StringUtil.isEmptyWithTrim(startdate)){
			sqlbuilder.append(" and ").append(datekeyname).append(" >= '").append(startdate).append("' ");
		}
		if(!StringUtil.isEmptyWithTrim(enddate)){
			sqlbuilder.append(" and ").append(datekeyname).append(" <= '").append(enddate).append("'");
		}
	}
	protected void appendSql(StringBuilder sqlbuilder, String name, String value) {
		if (!StringUtil.isEmptyWithTrim(value)) {
			sqlbuilder.append(" and ").append(name).append(" = '").append(value).append("'");
		}
	}
	/**
	 * ���·�ҳģ���е������б�
	 * 
	 * @param list
	 * @throws BusinessException
	 */
	public void setPageModelPks(List list) throws BusinessException {
		List<String> pks = new ArrayList<String>();
		for (Object obj : list) {
			pks.add(VOUtil.getPKFromObj(obj));
		}
		getPaginationModel().setObjectPks(pks.toArray(new String[0]));
	}
	/**
	 * ��֤���������
	 * @param data
	 */
	private boolean doOpenProcess(FuncletInitData data) {
		boolean flag = false;
		LCMLinkData linkData = (LCMLinkData) data.getInitData();
		if (linkData.isInOrOutTradeFlag() && null != this.getProcessorMap()) {
			IInitDataProcessor processor = this.getProcessorMap()
					.get(Integer.valueOf(data.getInitType()));
			if (null != processor) {
				processor.process(data);
				flag = true;
			}
		}
		return flag;
	}
	
	/**
	 * ������ģʽ�򿪽��������ݴ���
	 */
	protected void linkApproveOperate(ILinkApproveData dataObject) {
		try {
//	        Object obj = getService().queryByPk(dataObject.getBillID());
//	        getModel().initModel(obj);
			getPaginationModel().setObjectPks(new String[]{dataObject.getBillID()});
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
			throw new BusinessRuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * ��ά��ģʽ�򿪽��������ݴ���
	 */
	protected void linkMaintainOperate(ILinkMaintainData dataObject) {
		try {
//	        Object obj = getService().queryByPk(dataObject.getBillID());
//	        getModel().initModel(obj);
			getPaginationModel().setObjectPks(new String[]{dataObject.getBillID()});
			Object[] currentDatas = getPaginationModel().getCurrentDatas();
			if(ArrayUtil.isNull(currentDatas)){
				ExceptionUtils.wrappBusinessException(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("3617pub_0","03617pub-0076")/*@res "δ�ҵ��������"*/);
			}
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
			throw new BusinessRuntimeException(e.getMessage(), e);
		}
	}

	protected void linkAddOperate(ILinkAddData dataObject) {
		//ȡ�ÿ�Ƭ���沢չʾ
		ShowUpableBillForm billForm = getEditor();
		billForm.showMeUp();
		//���ý���״̬
		getModel().setUiState(UIState.ADD);
		
		//�����������ݵ�vo
		AggregatedValueObject aggvo = (AggregatedValueObject) dataObject.getUserObject();
		if (aggvo == null) {
			return;
		}
		BillCardPanel billCardPanel = billForm.getBillCardPanel();
		// ����vo���ý�������
		String pkOrg = billForm.getBillOrgPanel().getOrgGetter().getPkOrg(aggvo);
		billForm.getBillOrgPanel().setPkOrg(pkOrg);
		billForm.getBillOrgPanel().setEnabled(false);
		
		BillItem[] headItems = billCardPanel.getHeadItems();
		for (BillItem billItem : headItems) {
			billItem.setValue(aggvo.getParentVO().getAttributeValue(billItem.getKey()));
		}
		// ���ñ�������
		if(isContainBodyItemsByAdd()){
			BillItem[] bodyItems = billCardPanel.getBodyItems();
			CircularlyAccessibleValueObject[] bvos = aggvo.getChildrenVO();
			if(bvos != null && bvos.length > 0){
				for(int i=0;i<bvos.length;i++){
					billCardPanel.addLine();
					for (BillItem billItem : bodyItems) {
						String itemkey = billItem.getKey();
						billCardPanel.setBodyValueAt(bvos[i].getAttributeValue(itemkey), i, itemkey);
						billCardPanel.getBillModel().loadEditRelationItemValue(i, itemkey);
					}
				}
			}
		}
		billCardPanel.execHeadTailLoadFormulas();
		billCardPanel.getBillData().loadLoadHeadRelation();
		billCardPanel.getBillModel().loadLoadRelationItemValue();
	}
	/**
	 * �������������Ƿ��������������Ϣ
	 * @return
	 */
	protected boolean isContainBodyItemsByAdd() {
		return this.isContainBodyItems;
	}

	/**
	 * ���õ��ݵ�������
	 */
	protected void setDefaultData(ShowUpableBillForm billForm, SuperVO[] vos) {
		
	}
	
	/**
	 * �жϱ����Ƿ��Ƕ������еı���
	 * @return
	 */
	protected  boolean isBodyLineItems(){
		return false;
	}
	
	/**
	 * �Բ�ѯģʽ�򿪽��������ݴ���
	 */
	protected void linkQueryOperate(ILinkQueryData dataObject) {					
			try {
//				/*Object obj = getService().queryByPk(dataObject.getBillID());
//				getModel().initModel(obj);*/
				getPaginationModel().setObjectPks(new String[]{dataObject.getBillID()});
				Object[] currentDatas = getPaginationModel().getCurrentDatas();
				if(ArrayUtil.isNull(currentDatas)){
					ExceptionUtils.wrappBusinessException(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("3617pub_0","03617pub-0076")/*@res "δ�ҵ��������"*/);
				}
				getEditor().showMeUp();
			} catch (Exception e) {
				Logger.error(e.getMessage(), e);
				throw new BusinessRuntimeException(e.getMessage(), e);
			}
	}
	
	/**
	 * �Բ�ѯģʽ�򿪽��������ݴ���(����൥�ݴ���
	 */
	protected void linkQueryOperateDatas(String[] pks) {					
		try {
//	    	Object[] objs = null;
//	    	if(getService() instanceof IQueryServiceWithFuncCodeExt){
//	    		objs = ((IQueryServiceWithFuncCodeExt)getService()).queryByPksWithFunCode(pks,getContext().getNodeCode());
//	    	}else{
//	    		objs = ((IQueryServiceExt)getService()).queryByPk(pks);
//	    	}
//	    	getModel().initModel(objs);
			getPaginationModel().setObjectPks(pks);
			Object[] currentDatas = getPaginationModel().getCurrentDatas();
			if(ArrayUtil.isNull(currentDatas)){
				ExceptionUtils.wrappBusinessException(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("3617pub_0","03617pub-0076")/*@res "δ�ҵ��������"*/);
			}
			//�����������飬ֱ����ʾ��Ƭ����
			if(pks.length == 1){
				getEditor().showMeUp();
			}
			
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
			throw new BusinessRuntimeException(e.getMessage(), e);
		}
	}
	
    private IQueryService service = null;
    public void setService(IQueryService service) {
        this.service = service;
    }
    public IQueryService getService() {
        if (null == service) {
            service = new SimpleQueryByPk();
        }
        return service;
    }

	private class SimpleQueryByPk implements IQueryServiceWithFunCode ,IQueryServiceWithFuncCodeExt,IQueryServiceExt{
        @Override
        public Object queryByPk(String pk) {
            try {
                Class<?> voClass = Class.forName(getVoClassName());
                if (SuperVO.class.isAssignableFrom(voClass)) {
                    return MDPersistenceService.lookupPersistenceQueryService().queryBillOfNCObjectByPK(voClass, pk);
                } else if (AbstractBill.class.isAssignableFrom(voClass)) {
                    Class<? extends AbstractBill> bill = (Class<? extends AbstractBill>) voClass;
                    return NCLocator.getInstance().lookup(IBillQueryService.class).querySingleBillByPk(bill, pk);
                } else {
                    Logger.debug("Ŀǰֻ֧��SuperVO��AbstractBill�ṹ������");
                }
            } catch (Exception e) {
                ExceptionUtils.wrappException(e);
            }
            return null;
        }
        
    	@Override
    	public Object[] queryByPk(String[] pk) {
    		try {
    	        Class<?> voClass = Class.forName(getVoClassName());
    	        IQueryBillService queryBillService = NCLocator.getInstance().lookup(IQueryBillService.class);
    	        return queryBillService.queryBills(voClass, pk);
    		} catch (Exception e) {
    			ExceptionUtils.wrappException(e);
    		}
    		return null;
    	}
    	
        @Override
        public Object queryByPkWithFunCode(String pk, String nodeCode) {
            try {
	            Class<?> voClass = Class.forName(getVoClassName());
	            IQueryBillService queryBillService = NCLocator.getInstance().lookup(IQueryBillService.class);
	            return queryBillService.queryBill(voClass, pk, nodeCode);
            } catch (Exception e) {
            	ExceptionUtils.wrappException(e);
            }
            return null;
        }
        
    	@Override
    	public Object[] queryByPksWithFunCode(String[] pks, String nodeCode) {
    		try {
	            Class<?> voClass =Class.forName(getVoClassName());
	            IQueryBillService queryBillService =
	                NCLocator.getInstance().lookup(IQueryBillService.class);
	            return queryBillService.queryBills(voClass, pks, nodeCode);
    		} catch (Exception e) {
    			ExceptionUtils.wrappException(e);
    		}
    		return null;
    	}
    }

    public void setVoClassName(String voClassName) {
        this.voClassName = voClassName;
    }
    public String getVoClassName() {
        return voClassName;
    }

	public PaginationModel getPaginationModel() {
		return paginationModel;
	}

	public void setPaginationModel(PaginationModel paginationModel) {
		this.paginationModel = paginationModel;
	}

	public ShowUpableBillForm getEditor() {
		return editor;
	}
	
	public void setEditor(ShowUpableBillForm editor) {
		this.editor = editor;
	}
	public ShowUpableBillListView getListView() {
		return listView;
	}

	public void setListView(ShowUpableBillListView listView) {
		this.listView = listView;
	}
	public BillManageModel getModel() {
		return model;
	}
	
	public void setModel(BillManageModel model) {
		this.model = model;
	}
	public void setIsContainBodyItems(boolean isContainBodyItems) {
		this.isContainBodyItems = isContainBodyItems;
	}
}
