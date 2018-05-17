package com.datasnail.action;

import net.sf.json.JSONObject;

import com.datasnail.dao.UserStatisticDao;
import com.datasnail.filters.SpringInit;
import com.opensymphony.xwork2.ActionSupport;


public class UserStatisticAction extends ActionSupport {
	 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nodeSize;
	private String nodeIds;
	private UserStatisticDao usDao = (UserStatisticDao) SpringInit.getApplicationContext().getBean("usDao");
	private JSONObject jsonResult = new JSONObject();
	
	public JSONObject getJsonResult() {
		return jsonResult;
	}
	public void setJsonResult(JSONObject jsonResult) {
		this.jsonResult = jsonResult;
	}
	
	public String getNodeSize() {
		return nodeSize;
	}
	public void setNodeSize(String nodeSize) {
		this.nodeSize = nodeSize;
	}
	
	public String getFollowTopoPage(){
		return SUCCESS;
	}
	public String getInteractionTopoPage(){
		
		return SUCCESS;
	}
	public String getStatisticPage(){
		
		return SUCCESS;
	}
	
	
	public String getNodeIds() {
		return nodeIds;
	}
	public void setNodeIds(String nodeIds) {
		this.nodeIds = nodeIds;
	}
	public String followTopoAPI(){
		nodeSize = this.getNodeSize();
		nodeIds = this.getNodeIds();
		int end = -1;
		String[] nodeIdsArr = null;
		if(nodeIds!=null&&!nodeIds.equals("null")&&nodeIds.length()>0){
			nodeIdsArr = nodeIds.split(",");
		}
		if(nodeIdsArr==null&&nodeSize!=null){
			end = Integer.parseInt(nodeSize);
		}
		jsonResult = usDao.getrelationJsonResult(0, end,nodeIdsArr);
		return SUCCESS;
	}
	
	public String interactionTopoAPI(){
		nodeSize = this.getNodeSize();
		nodeIds = this.getNodeIds();
		int end = -1;
		String[] nodeIdsArr = null;
		if(nodeIds!=null&&!nodeIds.equals("null")&&nodeIds.length()>0){
			nodeIdsArr = nodeIds.split(",");
		}
		if(nodeIdsArr==null&&nodeSize!=null){
			end = Integer.parseInt(nodeSize);
		}
		jsonResult = usDao.getInteractionJsonResult(0, end,nodeIdsArr);
		return SUCCESS;
	}
	
	public String getUserLocationDataAPI(){
		nodeSize = this.getNodeSize();
		if(nodeSize.equals("all"))nodeSize = "-1";
		jsonResult = usDao.getUserLocation(1,Integer.parseInt(nodeSize));
		return SUCCESS;
	}
	
	public String getGenderDistributionAPI(){
		nodeSize = this.getNodeSize();
		jsonResult = usDao.getGenderDistribution();
		return SUCCESS;
	}
	
	public String blogAnalyzePage(){
		return SUCCESS;
	}
	
}
