package de.sechel.thesis;

import de.jtem.halfedge.Edge;
import de.jtem.halfedge.Face;
import de.jtem.halfedge.HalfEdgeDataStructure;
import de.jtem.halfedge.Vertex;
import de.jtem.halfedge.util.HalfEdgeUtils;
import de.jtem.halfedgetools.adapter.AdapterSet;
import de.jtem.halfedgetools.adapter.type.Weight;
import de.sechel.thesis.hds.FunctionValue;
import de.sechel.thesis.hds.VHDS;

public class MyUtility {

public static <
	V extends Vertex<V, E, F>,
	E extends Edge<V, E, F>,
	F extends Face<V, E, F>,
	HDS extends HalfEdgeDataStructure<V, E, F>
> double computeDirichlet(HDS hds, AdapterSet a){
	double energy = 0.0;
	for (E e : hds.getPositiveEdges()) {
		V s = e.getStartVertex();
		V t = e.getTargetVertex();
		double fStart = a.get(FunctionValue.class, s, Double.class);
		double fTarget = a.get(FunctionValue.class, t, Double.class);
		double w = a.getDefault(Weight.class, e, 1.0);
		double d = fStart - fTarget;
		energy += w * d * d; 
	}
	return energy;
}

public static double calculate() {
	VHDS hds = new VHDS();
	HalfEdgeUtils.addDodecahedron(hds);
	AdapterSet a = new AdapterSet();
	a.add(new MyTypedAdapter());
	return computeDirichlet(hds, a);
}
	

public static void main(String[] args) {
	double r = calculate();
	System.out.println("result: " + r);
}
	
}
