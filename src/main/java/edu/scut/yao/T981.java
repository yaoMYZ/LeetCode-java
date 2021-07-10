package edu.scut.yao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ValueNode {
	String value;
	int timestamp;
	
	public ValueNode(String value, int timestamp) {
		this.value = value;
		this.timestamp = timestamp;
	}
}

class NodeList{
	List<ValueNode> list;
	
	public NodeList() {
		list = new ArrayList();
	}

	public String getNodeValue(int timestamp) {
		for (int i = list.size()-1; i >= 0; i--) {
			if(list.get(i).timestamp<=timestamp) {
				return list.get(i).value;
			}
		}
		return "";
	}

	public void setNode(ValueNode node) {
		list.add(node);
	}
	
}

public class T981 {
	Map<String, NodeList> dataMap;
	
	/** Initialize your data structure here. */
    public T981() {
    	dataMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
    	dataMap.computeIfAbsent(key, k->new NodeList());
    	dataMap.get(key).setNode(new ValueNode(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
    	if(!dataMap.containsKey(key)) {
    		return "";
    	}
    	return dataMap.get(key).getNodeValue(timestamp);
    }
}
