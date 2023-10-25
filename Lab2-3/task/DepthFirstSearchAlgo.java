package task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	//task 1
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

	//task 2
	@Override
	public Node execute(Node root, String start, String goal) {
        boolean check = false;
        Stack<Node> frontier = new Stack<Node>();
        List<Node> explored = new ArrayList<>();
        frontier.push(root);
        while (!frontier.isEmpty()) {
            Node current = frontier.pop();
            explored.add(current);
            // meet the start point
            if (current.getLabel().equals(goal) && check) return current;
            if (current.getLabel().equals(start)) {
                check = true;
                frontier.clear();
                explored.clear();
                current.setParent(null);
            }
            for (Node child : current.getChildrenNodes()) {
                if (frontier.contains(child) || explored.contains(child)) continue;
                frontier.push(child);
                child.setParent(current);
            }
        }
        return null;
    }
}
