package de.sechel.thesis;

import de.jtem.halfedgetools.adapter.AbstractTypedAdapter;
import de.jtem.halfedgetools.adapter.AdapterSet;
import de.sechel.thesis.hds.FunctionValue;
import de.sechel.thesis.hds.VE;
import de.sechel.thesis.hds.VF;
import de.sechel.thesis.hds.VV;

@FunctionValue
public class MyTypedAdapter extends AbstractTypedAdapter<VV, VE, VF, Double> {
	public MyTypedAdapter() {
		super(VV.class, null, null, Double.class, true, true);
	}
	
	@Override
	public Double getVertexValue(VV v, AdapterSet aSet) {
		return v.value;
	}
	
	@Override
	public void setVertexValue(VV v, Double value, AdapterSet aSet) {
		v.value = value;
	}
}
