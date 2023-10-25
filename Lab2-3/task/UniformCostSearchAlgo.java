package task;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class UniformCostSearchAlgo implements ISearchAlgo {

	//task 4
	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparator());
		Set<Node> explored = new HashSet<>();
		frontier.add(root);

		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node children = frontier.poll();
			if (children.getLabel().equals(goal)) {
				return children;
			} else {
				explored.add(children);
				List<Edge> childrens = children.getChildren();
				for (Edge child : childrens) {
					double newPathCost = children.getPathCost() + child.getWeight();
					Node end = child.getEnd();
					if (!explored.contains(end) && !frontier.contains(end)) {
						frontier.add(end);
						end.setPathCost(newPathCost);
						end.setParent(children);
					} else if (frontier.contains(end) && end.getPathCost() > newPathCost) {
						end.setPathCost(newPathCost);
						end.setParent(children);
					}
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

	class NodeComparator implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			// Compare nodes based on their path costs
			int res = Double.compare(o1.getPathCost(), o2.getPathCost());
			if (res == 0) {
				return o1.getLabel().compareTo(o2.getLabel());
			}
			return res;
		}
	}
}
