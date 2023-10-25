package task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	//task 1
	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> queue = new LinkedList<>();
		List<Node> explored = new ArrayList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node child = queue.poll();
			if (child.getLabel().equals(goal)) {
				return child;
			}
			explored.add(child);
			List<Node> childNode = child.getChildrenNodes();
			for (Node node : childNode) {
				if (!queue.contains(node) && !explored.contains(node)) {
					queue.add(node);
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
        Queue<Node> frontier = new LinkedList<Node>();
        List<Node> explored = new ArrayList<>();
        frontier.add(root);
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            explored.add(current);
            if (current.getLabel().equals(goal) && check) return current;
            if (current.getLabel().equals(start)) {
                check = true;
                frontier.clear();
                explored.clear();
                current.setParent(null);
            }
            for (Node child : current.getChildrenNodes()) {
                if (frontier.contains(child) || explored.contains(child)) continue;
                frontier.add(child);
                child.setParent(current);
            }
        }
        return null;
    }
}
