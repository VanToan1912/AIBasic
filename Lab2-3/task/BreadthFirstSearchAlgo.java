package task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> queue = new LinkedList<>();
		List<Node> explored = new ArrayList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node child = queue.poll();
			if(child.getLabel().equals(goal)) {
				return child;
			}
			explored.add(child);
			List<Node> childNode = child.getChildrenNodes();
			for (Node node : childNode) {
				if(!queue.contains(node) && !explored.contains(node)) {
					queue.add(node);
					node.setParent(child);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}
}
