package task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> stack = new Stack<>();
		List<Node> explored = new ArrayList<>();
		stack.add(root);

		while (!stack.isEmpty()) {
			Node child = stack.pop();
			if (child.getLabel().equals(goal)) {
				return child;
			}
			explored.add(child);
			List<Node> childNode = child.getChildrenNodes();
			Collections.reverse(childNode);
			for (Node node : childNode) {
				if (!stack.contains(node) && !explored.contains(node)) {
					stack.push(node);
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
