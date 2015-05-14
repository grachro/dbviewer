package com.grachro.dbviewer.script;

import java.util.HashSet;
import java.util.Set;

import com.grachro.dbviewer.Script;
import com.grachro.dbviewer.ScriptHolder;

@ScriptHolder
public class AllJavaScripts {

	public Set<Script> getScriptList() {
		Set<Script> result = new HashSet<Script>();
		result.add(new SampleScript1());
		result.add(new SampleScript2());
		result.add(new SampleScript4());
		return result;
	}
}
