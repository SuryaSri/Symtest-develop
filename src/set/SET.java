<<<<<<< HEAD
package set;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import program.IProgram;
import utilities.IdGenerator;
import cfg.ICFG;
import expression.IIdentifier;

public class SET implements IProgram {
	
	ICFG mCFG;
	SETBasicBlockNode mStartNode;
	
	Set<SETDecisionNode> mDecisionNodeSet = new LinkedHashSet<SETDecisionNode>();
	Set<SETBasicBlockNode> mBasicBlockNodeSet = new LinkedHashSet<SETBasicBlockNode>();
	Set<SETEdge> mSETEdgeSet = new LinkedHashSet<SETEdge>();
	
	Set<IIdentifier> mVariableSet = new LinkedHashSet<IIdentifier>();
	
	Set<SETNode> mLeafNodeSet = new LinkedHashSet<SETNode>();

	private final String mId;
	
	public SET(ICFG cfg) {
		this.mCFG = cfg;
		this.mStartNode = new SETBasicBlockNode(this, cfg.getStartNode());
		this.mBasicBlockNodeSet.add(this.mStartNode);
		this.mLeafNodeSet.add(this.mStartNode);
		this.mId = SET.generateId();
	}
	
	public SET(String id, ICFG cfg) throws Exception {
		this.mCFG = cfg;
		this.mStartNode = new SETBasicBlockNode(this, cfg.getStartNode());
		this.mBasicBlockNodeSet.add(this.mStartNode);
		this.mLeafNodeSet.add(this.mStartNode);
		if(IdGenerator.hasId(id)) {
			this.mId = SET.generateId();
		}
		else {
			IdGenerator.addId(id);
			this.mId = id;
		}
	}

	private static String generateId() {
		return IdGenerator.generateId("SET");
	}

	public String getId() {
		return this.mId;
	}
	
	public SETBasicBlockNode getStartNode() {
		return this.mStartNode;
	}
	
	public Set<SETNode> getLeafNodes() {
		return this.mLeafNodeSet;
	}
	
	public SETDecisionNode addDecisionNode(SETDecisionNode node) {
		if(this.mDecisionNodeSet.contains(node)) {
			return null;
		}
		this.mDecisionNodeSet.add(node);
		node.setSET(this);
		return node;
	}
	
	public SETBasicBlockNode addBasicBlockNode(SETBasicBlockNode node) {
		if(this.mBasicBlockNodeSet.contains(node)) {
			return null;
		}
		this.mBasicBlockNodeSet.add(node);
		node.setSET(this);
		return node;
	}

	public boolean hasBasicBlockNode(SETBasicBlockNode node) {
		return this.mBasicBlockNodeSet.contains(node);
	}
	
	public int getNumberOfBasicBlockNodes() {
		return this.mBasicBlockNodeSet.size();
	}
	
	public boolean hasSETDecisionNode(SETDecisionNode node) {
		return this.mDecisionNodeSet.contains(node);
	}
	
	public int getNumberOfDecisionNodes() {
		return this.mDecisionNodeSet.size();
	}
	
	public boolean hasNode(SETNode node) {
		if(node instanceof SETBasicBlockNode) {
			return this.hasBasicBlockNode((SETBasicBlockNode)node);
		}
		else if(node instanceof SETDecisionNode) {
			this.hasSETDecisionNode((SETDecisionNode)node);
		}
		return false;
	}
	
	public int getNumberOfNodes() {
		return this.getNumberOfBasicBlockNodes() + this.getNumberOfDecisionNodes();
	}
	
	public SETEdge addEdge(SETEdge edge) {
		if(this.mSETEdgeSet.contains(edge)) {
			return null;
		}
		this.mSETEdgeSet.add(edge);
		edge.setSET(this);
		return edge;
	}
	
	public int getNumberOfEdges() {
		return this.mSETEdgeSet.size();
	}
	
	public Set<SETNode> getNodeSet() {
		Set<SETNode> set = new LinkedHashSet<SETNode>();
		for(SETNode n : this.mBasicBlockNodeSet) {
			set.add(n);
		}
		for(SETNode n : this.mDecisionNodeSet) {
			set.add(n);
		}
		return set;
	}
	
	@Override
	public IIdentifier addVariable(IIdentifier var) {
		if(this.hasVariable(var)) {
			return null;
		}
		this.mVariableSet.add(var);
		return var;
	}
	
	@Override
	public boolean hasVariable(IIdentifier var) {
		return this.mVariableSet.contains(var);
	}

	
	public void updateLeafNodeSet() {
		this.mLeafNodeSet.clear();
		for(SETNode node : this.getNodeSet()) {
			List<SETNode> succ = node.getSuccessorSETNodeList();
			if(succ.isEmpty()) {
				this.mLeafNodeSet.add(node);
			}
		}
	}

	@Override
	public Set<IIdentifier> getVariables() {
		return this.mVariableSet;
	}

	
	/*public String toString() {
		SETtoStringVisitor visitor = new SETtoStringVisitor(this);
		try {
			visitor.visit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return visitor.getOutputString();
	}*/
}
=======
package set;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import program.IProgram;
import utilities.IdGenerator;
import cfg.ICFG;
import expression.IIdentifier;

public class SET implements IProgram {
	
	ICFG mCFG;
	SETBasicBlockNode mStartNode;
	
	Set<SETDecisionNode> mDecisionNodeSet = new LinkedHashSet<SETDecisionNode>();
	Set<SETBasicBlockNode> mBasicBlockNodeSet = new LinkedHashSet<SETBasicBlockNode>();
	Set<SETEdge> mSETEdgeSet = new LinkedHashSet<SETEdge>();
	
	Set<IIdentifier> mVariableSet = new LinkedHashSet<IIdentifier>();
	
	Set<SETNode> mLeafNodeSet = new LinkedHashSet<SETNode>();

	private final String mId;
	
	public SET(ICFG cfg) {
		this.mCFG = cfg;
		this.mStartNode = new SETBasicBlockNode(this, cfg.getStartNode());
		this.mBasicBlockNodeSet.add(this.mStartNode);
		this.mLeafNodeSet.add(this.mStartNode);
		this.mId = SET.generateId();
	}
	
	public SET(String id, ICFG cfg) throws Exception {
		this.mCFG = cfg;
		this.mStartNode = new SETBasicBlockNode(this, cfg.getStartNode());
		this.mBasicBlockNodeSet.add(this.mStartNode);
		this.mLeafNodeSet.add(this.mStartNode);
		if(IdGenerator.hasId(id)) {
			this.mId = SET.generateId();
		}
		else {
			IdGenerator.addId(id);
			this.mId = id;
		}
	}

	private static String generateId() {
		return IdGenerator.generateId("SET");
	}

	public String getId() {
		return this.mId;
	}
	
	public SETBasicBlockNode getStartNode() {
		return this.mStartNode;
	}
	
	public Set<SETNode> getLeafNodes() {
		return this.mLeafNodeSet;
	}
	
	public SETDecisionNode addDecisionNode(SETDecisionNode node) {
		if(this.mDecisionNodeSet.contains(node)) {
			return null;
		}
		this.mDecisionNodeSet.add(node);
		node.setSET(this);
		return node;
	}
	
	public SETBasicBlockNode addBasicBlockNode(SETBasicBlockNode node) {
		if(this.mBasicBlockNodeSet.contains(node)) {
			return null;
		}
		this.mBasicBlockNodeSet.add(node);
		node.setSET(this);
		return node;
	}

	public boolean hasBasicBlockNode(SETBasicBlockNode node) {
		return this.mBasicBlockNodeSet.contains(node);
	}
	
	public int getNumberOfBasicBlockNodes() {
		return this.mBasicBlockNodeSet.size();
	}
	
	public boolean hasSETDecisionNode(SETDecisionNode node) {
		return this.mDecisionNodeSet.contains(node);
	}
	
	public int getNumberOfDecisionNodes() {
		return this.mDecisionNodeSet.size();
	}
	
	public boolean hasNode(SETNode node) {
		if(node instanceof SETBasicBlockNode) {
			return this.hasBasicBlockNode((SETBasicBlockNode)node);
		}
		else if(node instanceof SETDecisionNode) {
			this.hasSETDecisionNode((SETDecisionNode)node);
		}
		return false;
	}
	
	public int getNumberOfNodes() {
		return this.getNumberOfBasicBlockNodes() + this.getNumberOfDecisionNodes();
	}
	
	public SETEdge addEdge(SETEdge edge) {
		if(this.mSETEdgeSet.contains(edge)) {
			return null;
		}
		this.mSETEdgeSet.add(edge);
		edge.setSET(this);
		return edge;
	}
	
	public int getNumberOfEdges() {
		return this.mSETEdgeSet.size();
	}
	
	public Set<SETNode> getNodeSet() {
		Set<SETNode> set = new LinkedHashSet<SETNode>();
		for(SETNode n : this.mBasicBlockNodeSet) {
			set.add(n);
		}
		for(SETNode n : this.mDecisionNodeSet) {
			set.add(n);
		}
		return set;
	}
	
	@Override
	public IIdentifier addVariable(IIdentifier var) {
		if(this.hasVariable(var)) {
			return null;
		}
		this.mVariableSet.add(var);
		return var;
	}
	
	@Override
	public boolean hasVariable(IIdentifier var) {
		return this.mVariableSet.contains(var);
	}

	
	public void updateLeafNodeSet() {
		this.mLeafNodeSet.clear();
		for(SETNode node : this.getNodeSet()) {
			List<SETNode> succ = node.getSuccessorSETNodeList();
			if(succ.isEmpty()) {
				this.mLeafNodeSet.add(node);
			}
		}
	}

	@Override
	public Set<IIdentifier> getVariables() {
		return this.mVariableSet;
	}

	
	/*public String toString() {
		SETtoStringVisitor visitor = new SETtoStringVisitor(this);
		try {
			visitor.visit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return visitor.getOutputString();
	}*/
}
>>>>>>> 25ebf124fd450adaed57ee1006dedb1a7734bcf9
