package de.sechel.thesis;

import java.util.Map;

import de.jtem.halfedge.Edge;
import de.jtem.halfedge.Face;
import de.jtem.halfedge.Node;
import de.jtem.halfedge.Vertex;
import de.jtem.halfedgetools.adapter.AbstractAdapter;
import de.jtem.halfedgetools.adapter.AdapterSet;
import de.sechel.thesis.hds.FunctionValue;

@FunctionValue
public class MyAbstractAdapter extends AbstractAdapter<Double> {
	private Map<Vertex<?, ?, ?>, Double> valueMap = null;
	
	public MyAbstractAdapter() {
		super(Double.class, true, false);
	}
	
	@Override
	public <
		N extends Node<?, ?, ?>
	> boolean canAccept(Class<N> nodeClass) {
		return Vertex.class.isAssignableFrom(nodeClass);
	}
	
	@Override
	public <
		V extends Vertex<V, E, F>, 
		E extends Edge<V, E, F>, 
		F extends Face<V, E, F>
	> Double getV(V v, AdapterSet aSet) {
		return valueMap.get(v);
	}
	
	@Override
	public <
		V extends Vertex<V, E, F>, 
		E extends Edge<V, E, F>, 
		F extends Face<V, E, F>
	> void setV(V v, Double value, AdapterSet aSet) {
		valueMap.put(v, value);
	}
}
