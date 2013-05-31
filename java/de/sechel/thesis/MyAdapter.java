package de.sechel.thesis;

import de.jtem.halfedge.Edge;
import de.jtem.halfedge.Face;
import de.jtem.halfedge.Node;
import de.jtem.halfedge.Vertex;
import de.jtem.halfedgetools.adapter.Adapter;
import de.jtem.halfedgetools.adapter.AdapterSet;
import de.sechel.thesis.hds.FunctionValue;

@FunctionValue
public class MyAdapter extends Adapter<Double> {

	public MyAdapter() {
		super(true, true);
	}
	
	@Override
	public <N extends Node<?, ?, ?>> boolean canAccept(Class<N> nodeClass) {
		return Vertex.class.isAssignableFrom(nodeClass);
	}

	@Override
	public boolean checkType(Class<?> type) {
		return Double.class.equals(type);
	}

	@Override
	protected <
		V extends Vertex<V, E, F>, 
		E extends Edge<V, E, F>,
		F extends Face<V, E, F>
	> Double getV(V arg0, AdapterSet arg1) {
		return null;
	}

	@Override
	protected <
		V extends Vertex<V, E, F>, 
		E extends Edge<V, E, F>, 
		F extends Face<V, E, F>
	> Double getE(E arg0, AdapterSet arg1) {
		return null;
	}

	@Override
	protected <
		V extends Vertex<V, E, F>, 
		E extends Edge<V, E, F>, 
		F extends Face<V, E, F>
	> Double getF(F arg0, AdapterSet arg1) {
		return null;
	}

	@Override
	protected <
		V extends Vertex<V, E, F>, 
		E extends Edge<V, E, F>, 
		F extends Face<V, E, F>
	> void setV(V arg0, Double arg1, AdapterSet arg2) {

	}
	
	@Override
	protected <
		V extends Vertex<V, E, F>, 
		E extends Edge<V, E, F>, 
		F extends Face<V, E, F>
	> void setE(E arg0, Double arg1, AdapterSet arg2) {

	}

	@Override
	protected <
		V extends Vertex<V, E, F>, 
		E extends Edge<V, E, F>, 
		F extends Face<V, E, F>
	> void setF(F arg0, Double arg1, AdapterSet arg2) {

	}

	@Override
	public double getPriority() {
		return 0;
	}

}
