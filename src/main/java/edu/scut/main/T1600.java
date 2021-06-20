package edu.scut.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MNode{
	private List<MNode> children;
	private String name;
	private boolean death;
	
	public MNode(String name) {
		this.name = name;
		children = new ArrayList<>();
		death = false;
	}
	
	public void setChildren(MNode child) {
		children.add(child);
	}
	
	public List<MNode> getChildren() {
		return children;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDeath(boolean death) {
		this.death = death;
	}
	
	public boolean getDeath() {
		return this.death;
	}
}


class ThroneInheritance {
	
	private MNode head;
	private List<String> inheritanceOrder;
	private HashMap<String, MNode> nodeMap;

    public ThroneInheritance(String kingName) {
    	head = new MNode(kingName);
    	nodeMap = new HashMap<>();
    	nodeMap.put(kingName, head);
    }
    
    public void birth(String parentName, String childName) {
    	MNode pNode = nodeMap.get(parentName);
    	MNode childNode = new MNode(childName);
    	pNode.setChildren(childNode);
    	nodeMap.put(childName, childNode);
    }
    
    
    public void death(String name) {
    	MNode pNode = nodeMap.get(name);
    	pNode.setDeath(true);
    }
    
    public List<String> getInheritanceOrder() {
    	inheritanceOrder = new ArrayList<>();
    	getOrder(head);
    	return inheritanceOrder;
    }
    
    private void getOrder(MNode curNode) {
    	if(curNode==null)
    		return;
    	if(!curNode.getDeath())
    		inheritanceOrder.add(curNode.getName());
    	for (MNode node : curNode.getChildren()) {
			getOrder(node);
		}
    }
}

public class T1600 {

}
