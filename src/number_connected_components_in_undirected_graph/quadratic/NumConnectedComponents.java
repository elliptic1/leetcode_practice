package number_connected_components_in_undirected_graph.quadratic;

import java.util.*;

public class NumConnectedComponents {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] test = new int[][]{{1, 0}, {2, 6}, {1, 7}, {5,1}, {6,4}, {7,0}, {0,5}, {5,1}, {6,4}};

        System.out.println(s.countComponents(8, test));

    }

}

class Solution {

    private void log(String s) {
        System.out.println(s);
    }

    private Set<int[]> keepUnique(int[][] edges) {
        HashSet<int[]> u = new HashSet<>();
        for (int[] edge: edges) {
            int[] orderedEdge = orderedEdge(edge);
            if (!setHasArray(u, orderedEdge)) {
                u.add(orderedEdge);
            }
        }
        return u;
    }

    private boolean setHasArray(Set<int[]> s, int[] a) {
        for (int[] sa : s) {
            int[] e = orderedEdge(sa);
            if (sa[0] == a[0] && sa[1] == a[1]) {
                return true;
            }
        }
        return false;
    }

    private int[] orderedEdge(int[] e) {
        if (e[0] <= e[1]) {
            return e;
        } else {
            return new int[]{e[1], e[0]};
        }
    }

    public int countComponents(int n, int[][] edges) {

        Set<int[]> uniqueEdges = keepUnique(edges);

        ArrayList<Set<int[]>> components = new ArrayList<>();

        Set<Integer> visitedNodes = new HashSet<>();

        // O(#edges)
        for (int[] edge : uniqueEdges) {
            log("");
            log("edge: " + Arrays.toString(edge));

            ArrayList<Set<int[]>> cvs = new ArrayList<>();

            // O(2)
            for (int v : edge) {
                log("vertex " + v);
                visitedNodes.add(v);

                // O(#edges)
                log("All components now: " + compsToString(components));
                for (Set<int[]> comp : components) {

                    log("Should add " + v + " to comp " + compToString(comp) + "?");
                    if (shouldAddEdgeToComponent(comp, edge, v)) {
                        log(" - yes should add edge " + Arrays.toString(edge));
                        comp.add(edge);
                        log(" - component now: " + compToString(comp));

                        cvs.add(comp);
                        log(" - cvs now: " + compsToString(components));

                    } else {
                        log("No");
                    }

                }

            }

            switch (cvs.size()) {
                case 0:
                    Set<int[]> newComp = new HashSet<>();
                    newComp.add(edge);
                    log("Adding new comp " + compToString(newComp));
                    components.add(newComp);
                    break;
                case 1:
                    break;
                case 2:
                    log("Removing comps " + compsToString(cvs));
                    log("Components are now " + compsToString(components));
                    for (Set<int[]> comp : cvs) {
                        log(" - Removing " + compToString(comp));
                        boolean b = removeComp(components, comp);
                        log(" - - " + b);
                    }
                    log("Components are now " + compsToString(components));
                    log("Adding existing comp " + compsToString(cvs));
                    components.add(combineComponents(cvs));
                    log("Components are now " + compsToString(components));
                    break;
            }

        }

        int isolatedNodes = n - visitedNodes.size();

        log("isolated nodes: " + isolatedNodes);

        log("all comps: " + compsToString(components));

        return components.size() + isolatedNodes;

    }

    boolean removeComp(ArrayList<Set<int[]>> comps, Set<int[]> r) {
        ArrayList<Integer> toBeRemoved = new ArrayList<>();
        boolean retBool = false;
        log("..Trying to remove from comps " + compsToString(comps));
        for (int i = 0; i<comps.size(); i++) {
            Set<int[]> comp = comps.get(i);
            if (compsAreEqual(comp, r)) {
                toBeRemoved.add(i);
            }
        }
        log("..To be removed is " + toBeRemoved);
        toBeRemoved.sort(Collections.reverseOrder());
        log("..To be removed sorted is " + toBeRemoved);
        for (int i : toBeRemoved) {
            comps.remove(i);
            retBool = true;
        }
        log("..Now comps is " + compsToString(comps));
        return retBool;
    }

    boolean compsAreEqual(Set<int[]> a, Set<int[]> b) {
        return compIsInComp(a, b)
                && compIsInComp(b, a);
    }

    boolean compIsInComp(Set<int[]> a, Set<int[]> b) {
        int n = a.size();
        int count = 0;
        outerA: for (int[] arrayA : a) {
            for (int[] arrayB : b) {
                if (arraysAreEqual(arrayA, arrayB)) {
                    ++count;
                    if (count == n) {
                        return true;
                    }
                    continue outerA;
                }
            }
        }
        return false;
    }

    boolean arraysAreEqual(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1]
                || a[0] == b[1] && a[1] == b[0];
    }

    String compsToString(ArrayList<Set<int[]>> cs) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Set<int[]> comp : cs) {
            sb.append(compToString(comp));
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    String compToString(Set<int[]> c) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int[] ca : c) {
            sb.append(Arrays.toString(ca));
            sb.append(", ");
        }

        sb.append("]");
        return sb.toString();
    }

    private Set<int[]> combineComponents(ArrayList<Set<int[]>> comps) {
        log("combining comps " + compsToString(comps));
        Set<int[]> combinedComponent = new HashSet<>();
        for (Set<int[]> comp : comps) {
            combinedComponent.addAll(comp);
        }
        log("combined comp: " + compToString(combinedComponent));
        return combinedComponent;
    }

    private boolean compContainsVertex(Set<int[]> comp, int v) {
        log("compContainsVertex?");
        for (int[] edge : comp) {
            for (int ev : edge) {
                if (ev == v) {
                    log(" - vertex - yes");
                    return true;
                }
            }
        }
        log(" - vertex - no");
        return false;
    }

    private boolean compContainsEdge(Set<int[]> comp, int[] edges) {
        log("compContainsEdge? " + compToString(comp)
        + " with edges " + Arrays.toString(edges));
        for (int[] cedge : comp) {
            log("checking component edge " + Arrays.toString(cedge) + " vs given edge " + Arrays.toString(edges));
            if (cedge[0] == edges[0] && cedge[1] == edges[1]) {
                log(" - edge - yes");
                return true;
            }
        }
        log(" - edge - no");
        return false;
    }

    private boolean shouldAddEdgeToComponent(Set<int[]> comp, int[] e, int v) {
        return compContainsVertex(comp, v)
                && ! compContainsEdge(comp, e);
    }
}

/*



Create an empty set of components

for each edge,

    make new list of components that this edge was added to: cvs

    for each vertex,

        for each component c,

            if component contains the vertex,

                if component does not contain the edge

                    add the edge to the component

                    add the component to cvs

                end if

            end if

        end for

    end for

    if cvs.size > 1

        components = combineComponents(cvs)

    else

        components.add( new Component[edge] )

    end if

end for

return components.size


fun Set<Pair<Int, Int>> combineComponents(Set<Set<Pair<Int, Int>>> cs) {

    Set<Pair<Int, Int>> newSet = new HashSet<>();

    for (Set<Pair<Int, Int>> s : cs) {

        newSet.addAll(s)

    }

    return newSet

}

*/